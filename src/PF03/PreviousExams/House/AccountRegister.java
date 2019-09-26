package PF03.PreviousExams.House;

public class AccountRegister {
    private House house;

    public AccountRegister() { this.setHouse(new House()); }
    public House getHouse() { return house; }
    public void setHouse(House house) { this.house = house; }

    public void addApartmentToHouse(Apartment apartment) {
        getHouse().getApartments().add(apartment); }
    public Apartment findApartmentInHouse(String aNr) {
        // Filter, if, return made in stream/lambda
        return getHouse().getApartments().stream().filter(apartment -> apartment.getaNr().equals(aNr))
                .findAny().get(); }
    public void removeApartmentFromHouse(String aNr) {
        findApartmentInHouse(aNr).getTenant().setApartment(null);
        getHouse().getApartments().remove(findApartmentInHouse(aNr)); }
    public double averagePriceOfApartment() {
        return ((double)sumOfPricesOfApartments() / amountOfApartmentsInHouse()); }
    private int sumOfPricesOfApartments() {
        // Sum made in stream/lambda
        int sum = getHouse().getApartments().stream().mapToInt(Apartment::getPrice).sum();
        return sum; }
    private int amountOfApartmentsInHouse() {
        return getHouse().getApartments().size(); }
    public Tenant findTenantOfApartment(String aNr) {
        return findApartmentInHouse(aNr).getTenant(); }
    public void changeTenantOfApartment(Tenant oldTenant, Tenant newTenant) {
        oldTenant.getApartment().setTenant(newTenant);
        newTenant.getApartment().setTenant(oldTenant);
        Apartment tmpApartment = oldTenant.getApartment();
        oldTenant.setApartment(newTenant.getApartment());
        newTenant.setApartment(tmpApartment); }
    public void setTenantOfApartment(String aNr, Tenant newTenant) {
        // Filter, if, set made in stream/lambda
        getHouse().getApartments().stream().filter(apartment -> apartment.getTenant() == newTenant)
                .forEach(apartment -> apartment.setTenant(null));
        if (findTenantOfApartment(aNr) != null)
            findTenantOfApartment(aNr).setApartment(null);
        findApartmentInHouse(aNr).setTenant(newTenant);
        newTenant.setApartment(findApartmentInHouse(aNr)); }
}
