public class MamaRichWallet{

    private String ownerID;
    private String ownerName;
    private double currentAmount;

    //Non-argument constructor
    public MamaRichWallet(){

    }

    //Constructor with ID, Name, Current balance in the wallet
    public MamaRichWallet(String ownerID, String ownerName, double currentAmount){
        this.ownerID = ownerID;
        this.ownerName = ownerName;
        this.currentAmount = currentAmount;
    }
    //Setter
    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    //Getter
    public double getCurrentAmount() {
        return currentAmount;
    }

    //Add the balance in wallet after done transaction from payment card
    public void addAmount(double currentAmount){
        this.currentAmount += currentAmount;
        setCurrentAmount(this.currentAmount);
    }

    //Calculate the balance if user pay for order, if the balance in wallet is not enough,
    // return 1 for prompt user do transaction
    public int calculateBalance(double price){
        if (currentAmount >= price){
           currentAmount -= price;
           setCurrentAmount(currentAmount);
           return 0;
        }
        else {
            return 1;
        }
    }
    //Return the balance in the wallet
    @Override
    public String toString() {
        return "\nCurrent Amount In MamaRich E-Wallet: RM "
                + String.format("%.2f", getCurrentAmount());
    }
}
