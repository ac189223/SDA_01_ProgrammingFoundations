package PF02.Exs.Ex10;

import java.util.ArrayList;

public class Business {
    private ArrayList<Subsidiary> subsidiaries;
    private ArrayList<Asset> assets;

    public Business() {
        this.subsidiaries = new ArrayList<>();
        this.assets = new ArrayList<>();
    }

    public ArrayList<Subsidiary> getSubsidiaries() { return subsidiaries; }

    public void setSubsidiaries(ArrayList<Subsidiary> subsidiaries) { this.subsidiaries = subsidiaries; }

    public void addSubsidiaries(Subsidiary subsidiary) { getSubsidiaries().add(subsidiary); }

    public void deleteSubsidiary(String id) {
        if (findSubsidiary(id) != null)
            getSubsidiaries().remove(findSubsidiary(id));
    }

    public Subsidiary findSubsidiary(String id) {
        for (Subsidiary subsidiary: getSubsidiaries())
            if (subsidiary.getId().equals(id))
                return subsidiary;
        return null;
    }

    public ArrayList<Asset> getAssets() { return assets; }

    public void setAssets(ArrayList<Asset> assets) { this.assets = assets; }

    public void addAssets(Asset asset) { getAssets().add(asset); }

    public double getBusinessValue() {
        double sum = 0;
        for (Subsidiary subsidiary : this.getSubsidiaries())
            sum += subsidiary.getSubsidiaryValue();
        for (Asset asset : this.getAssets())
            if (!this.getSubsidiaries().contains(asset.getSubsidiary()))
                sum += asset.getValue();
        return sum;
    }


       /* for (Subsidiary subsidiary: getSubsidiaries())
            if (subsidiary.getAssets().size() > 0)
                sum += subsidiary.getSubsidiaryValue();
        for (Asset asset: getAssets())
            if (!getSubsidiaries().contains(asset.getSubsidiary())) {
                sum += asset.getValue();
            }*/

      /*  ArrayList<Asset> summed = new ArrayList<>();
        for (Asset asset: getAssets()) {
            sum += asset.getValue();
            summed.add(asset);
        }
        for (Subsidiary subsidiary: getSubsidiaries())
            if (subsidiary.getAssets().size() > 0)
                for (Asset asset: subsidiary.getAssets())
                    if (!summed.contains(asset))
                        sum += asset.getValue();
    */
}
