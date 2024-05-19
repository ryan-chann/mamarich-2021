class PaymentCard{
    private String ownerID;
    private String ownerName;
    private int cardNumber;
    private double totalAmount;
    private static int[] cardNum;

    //Non-argument constructor
    public PaymentCard (){

    }

    //Constructor with ID, Name, Payment and Payment card balance
    public PaymentCard (String ownerID, String ownerName, double totalAmount){
        this.ownerID = ownerID;
        this.ownerName = ownerName;
        this.totalAmount = totalAmount;
    }

    //Constructor with ID, Name, Payment card number and Payment card balance
    public PaymentCard (String ownerID, String ownerName, int cardNumber, double totalAmount){
        this.ownerID = ownerID;
        this.ownerName = ownerName;
        this.totalAmount = totalAmount;
        this.cardNumber = cardNumber;
    }

    //Getter
    //Get card number with 12345678
    public int getCardNum(){
        return this.cardNumber;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    //Setter
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    //Calculate the balance of the payment card after done transaction
    public int calculateCardAmount(double totalAmount){
        if(this.totalAmount >= totalAmount){
            this.totalAmount -= totalAmount;
            setTotalAmount(this.totalAmount);
            return 0;
        }
        else {
            return 1;
        }
    }

    //Check for the validation of card number that user input
    public int cardValidation(){
        int cardNumber1 = cardNumber;

        this.cardNum = new int[8];
        int[] numDigit = new int[8];
        int i, num2 = 0, sum = 0, sum2 = 0, total = 0;
        //Find the value start from index 0 of numDigit
        for (i = 0; i < 8; i++){
            //If card number = 12345678
            //Index 0 = 8, index 1 = 7, .....
            numDigit[i] = cardNumber1  % 10;
            cardNumber1 = cardNumber1 /10;
        }

        for (i = 0; i < 8; i++){
            //If card number = 12345678

            //If i = even number, will do addition (1+3+5+7)
            if (i % 2 == 0) {
                sum += numDigit[i];
            }

            //If i = odd number, will multiple 2 and the number will be modulo 10 and divide 10 and do addition
            //2*2 = 4, 4%10 and 4/10 = 4 and 0, so 4 + 0 = 4
            //Another example = 7*2 = 14, 14%10 and 14/10 = 4 and 1, 4 + 1 = 5
            else {
                num2 = numDigit[i] * 2;
                do {
                    sum2 += num2 % 10; //Add the first digit of the number
                    num2 = num2 / 10; // Keep the second digit of the number

                } while (num2 % 10 != 0);
            }
        }

        total = sum + sum2;

        //If the total % 10 is equal to 0
        if(total % 10 == 0){
            //Return 0 when total % 10 is equal to 0
            return 0;
        }
        //Return 1 when total % 10 not equal to 0
        return 1;

    }

    //Return the card number and balance in the card
    @Override
    public String toString() {
        return "\nPayment Card Number: " + getCardNum() + "\nCurrent Amount In Payment Card: RM " +
                String.format("%.2f", getTotalAmount());
    }
}
