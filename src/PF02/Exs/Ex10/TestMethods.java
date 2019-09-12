package PF02.Exs.Ex10;

import java.util.ArrayList;
import java.util.Random;

class TestMethods {
    private static TestMethods tm = new TestMethods();
    private ArrayList<Asset> assets = new ArrayList<>();
    private ArrayList<Subsidiary> subsidiaries = new ArrayList<>();
    private ArrayList<Business> businesses = new ArrayList<>();
    private Random random = new Random();

    static void prepareData() {
        createBusinesses();
        createSubsidiaries();
        createAssets();
        createConnections();
    }

    private static void createBusinesses() {
        for (int i = 0; i < tm.random.nextInt(2) + 2; i++)
            tm.businesses.add(new Business());
    }

    private static void createSubsidiaries() {
        for (int i = 0; i < tm.random.nextInt(10) + 5; i++) {
            int num = tm.random.nextInt(tm.businesses.size());
            tm.subsidiaries.add(new Subsidiary("sub" + i, "" + i, tm.businesses.get(num)));
            // Mark it in subsidiaries of proper Business
            tm.businesses.get(num).getSubsidiaries().add(tm.subsidiaries.get(tm.subsidiaries.size() - 1));
        }
    }

    private static void createAssets() {
        for (int i = 0; i < tm.random.nextInt(20) + 15; i++)
            tm.assets.add(new Asset("ass" + i ,"" + (i % 5) ,((double)tm.random.nextInt(50) + 1) * 1000.));
    }

    private static void createConnections() {
        tm.assignAssetsToSubsidiaries();
        tm.assignAssetsToBusinesses();
    }

    private void assignAssetsToSubsidiaries() {
        // Both ways, many - one
        for (int i = 0; i < tm.assets.size(); i++) {
            int num = tm.random.nextInt(tm.subsidiaries.size() + 1);
            if (num != tm.subsidiaries.size()) {
                tm.assets.get(i).setSubsidiary(tm.subsidiaries.get(num));
                tm.subsidiaries.get(num).getAssets().add(tm.assets.get(i));
            }
        }
    }

    private void assignAssetsToBusinesses() {
        // Both ways, many - one
        for (int i = 0; i < tm.assets.size(); i++) {
            int num = tm.random.nextInt(tm.businesses.size() + 1);
            if (num != tm.businesses.size()) {
                tm.assets.get(i).setBusiness(tm.businesses.get(num));
                tm.businesses.get(num).getAssets().add(tm.assets.get(i));
            }
        }
    }

    static void testAndPresentData() {
        // Business - subsidiaries - (assets + free assets)
        tm.listBusinesses();
        // Free assets
        tm.listFreeAssets();
    }

    private void listBusinesses() {
        for (int i = 0; i < tm.businesses.size(); i++) {
            Business tmpBusiness = tm.businesses.get(i);
            System.out.print("Business" + i + " is worth " + tmpBusiness.getBusinessValue() + " SEK and has ");
            if (tmpBusiness.getSubsidiaries().size() == 0)
                System.out.println("no subsidiaries,");
            else {
                System.out.println(tmpBusiness.getSubsidiaries().size() + " subsidiaries:");
                for (int j = 0; j < tmpBusiness.getSubsidiaries().size(); j++) {
                    Subsidiary tmpSubsidiary = tmpBusiness.getSubsidiaries().get(j);
                    if (tmpSubsidiary.getAssets().size() == 0)
                        System.out.print("    " + tmpSubsidiary.getName() + " with no assets,");
                    else {
                        System.out.print("    " + tmpSubsidiary.getName() + " worth " + tmpSubsidiary.getSubsidiaryValue() + " SEK with " +
                                tmpSubsidiary.getAssets().size() + " assets: \n" + "        ");
                        for (int k = 0; k < tmpSubsidiary.getAssets().size(); k++)
                            System.out.print(tmpSubsidiary.getAssets().get(k).getName() + " worth " + tmpSubsidiary.getAssets().get(k).getValue() + " SEK, ");
                    }
                    System.out.println();
                }
            }
            String freeAccounts = "";
            int freeAccountsCount = 0;
            for (Asset asset: tmpBusiness.getAssets())
                if (!tmpBusiness.getSubsidiaries().contains(asset.getSubsidiary()) && asset.getBusiness() == tmpBusiness) {
                    freeAccounts += (asset.getName() + " worth " + asset.getValue() + " SEK, ");
                    freeAccountsCount++;
                }
            if (freeAccounts.length() > 0)
                System.out.println("Business" + i + " has " + freeAccountsCount + " accounts not assigned to subsidiaries: \n" +
                        "    " + freeAccounts);
            System.out.println();
        }
    }

    private void listFreeAssets() {
        String freeAccounts = "";
        for (Asset asset: assets)
            if (!tm.businesses.contains(asset.getBusiness()) && !tm.subsidiaries.contains(asset.getSubsidiary()))
                freeAccounts += (asset.getName() + " worth " + asset.getValue() + " SEK, ");
        if (freeAccounts.length() > 0)
            System.out.println("Assets that are not assigned: " + freeAccounts);
    }
}