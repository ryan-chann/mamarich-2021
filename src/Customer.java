public class Customer {
    private String customerName;
    private String customerID;
    private PaymentCard paymentCard;
    private MamaRichWallet mamaRichWallet;

    //Non-argument constructor
    public Customer(){

    }

    //Constructor with ID, Name and Payment card balance
    public Customer(String customerID, String customerName, double balance){
        this.customerName = customerName;
        this.customerID = customerID;
        this.paymentCard = new PaymentCard(getCustomerID(), getCustomerName(), balance);

        //Define the current balance of the wallet is 0
        this.mamaRichWallet = new MamaRichWallet(getCustomerID(), getCustomerName(), 0);
    }

    //Constructor with ID, Name, Payment card number and Payment card balance
    public Customer(String customerID, String customerName, int cardNumber,double balance){
        this.customerName = customerName;
        this.customerID = customerID;
        this.paymentCard = new PaymentCard(getCustomerID(), getCustomerName(), cardNumber, balance);

        //Define the current balance of the wallet is 0
        this.mamaRichWallet = new MamaRichWallet(getCustomerID(), getCustomerName(), 0);
    }

    //Getters
    public String getCustomerName(){
        return this.customerName;
    }

    public String getCustomerID(){
        return this.customerID;
    }

    //Setter of ID and Name
    public void setCurrentCustomer(String customerID, String customerName){
        customerName = customerName.substring(0, 1).toUpperCase() +  customerName.substring(1);
        customerID = customerID.toUpperCase();
        this.customerID = customerID;
        this.customerName = customerName;
    }

    //Return the ID and Name of current customer
    @Override
    public String toString() {
        return "\nUser ID: " + getCustomerID() + "\nUser Name: " + getCustomerName();
    }

    //Methods in MamaRich Wallet Class
    public String displayWallet(){
        return toString() + mamaRichWallet.toString();
    }

    public void setWalletBalance(double amount){
        mamaRichWallet.addAmount(amount);
    }

    public int calculateOrder(double price){
        return mamaRichWallet.calculateBalance(price);
    }

    //Methods in Payment Card Class
    public double getTotalAmount(){
        return paymentCard.getTotalAmount();
    }

    public int calculateAmount(double amount){
        return paymentCard.calculateCardAmount(amount);
    }

    public int checkCard(){
        return paymentCard.cardValidation();
    }

    public String displayPayment(){
        return toString() + paymentCard.toString();
    }


}
