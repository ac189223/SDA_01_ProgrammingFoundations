package PF02.Exs.Ex10;

import java.util.ArrayList;

public class Subsidiary {
    String name;
    String id;
    Business business;
    ArrayList<Asset> assets;

    public Subsidiary() {
        this.name = "";
        this.id = "";
        this.business = new Business();
        this.assets = new ArrayList<>();
    }

    public Subsidiary(String name, String id, Business business) {
        this.name = name;
        this.id = id;
        this.business = business;
        this.assets = new ArrayList<>();
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public Business getBusiness() { return business; }

    public void setBusiness(Business business) { this.business = business; }

    public ArrayList<Asset> getAssets() { return assets; }

    public void setAssets(ArrayList<Asset> assets) { this.assets = assets; }

    public void addAsset(Asset asset) { getAssets().add(asset); }

    public Asset findAsset(String name) {
        for (Asset asset: getAssets())
            if (asset.getName().equals(name))
                return asset;
        return null;
    }

    public void deleteAsset(String name) {
        if (findAsset(name) != null)
            getAssets().remove(findAsset(name));
    }

    public double getAssetValue(String name) {
        if (findAsset(name) != null)
            return findAsset(name).getValue();
        else
            return 0;
    }

    public double getSubsidiaryValue() {
        double sum = 0;
        for (Asset asset: getAssets())
            sum += getAssetValue(asset.getName());
        return sum;
    }
}
