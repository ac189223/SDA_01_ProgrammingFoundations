package PF02.Exs.Ex10;

public class Asset {
    private String name;
    private String type;
    private double value;
    private Subsidiary subsidiary;
    private Business business;

    public Asset() {
        this.name = "";
        this.type = "";
        this.value = 0;
        this.subsidiary = new Subsidiary();
        this.business = new Business();
    }

    public Asset(String name, String type, double value) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.subsidiary = new Subsidiary();
        this.business = new Business();
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public double getValue() { return value; }

    public void setValue(double value) { this.value = value; }

    public Subsidiary getSubsidiary() { return subsidiary; }

    public void setSubsidiary(Subsidiary subsidiary) { this.subsidiary = subsidiary; }

    public Business getBusiness() { return business; }

    public void setBusiness(Business business) { this.business = business; }
}
