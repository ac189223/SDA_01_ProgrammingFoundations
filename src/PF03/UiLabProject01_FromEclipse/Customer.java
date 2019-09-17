package PF03.UiLabProject01_FromEclipse;

public class Customer {
    private String cNumber;
    private String cName;
    private CreditCard creditcard;

    public Customer(String cNumber, String cName) { this.setCNumber(cNumber); this.setCName(cName); }

    public String getCNumber() { return this.cNumber; }
    public void setCNumber(String cNumber) { this.cNumber = cNumber; }

    public String getCName() { return this.cName; }
    public void setCName(String cName) { this.cName = cName; }

    public CreditCard getCreditCard() { return this.creditcard; }
    public void setCreditCard(CreditCard value) { this.creditcard = value; }
    public void addCreditCard(CreditCard card) { this.setCreditCard(card); }
}
