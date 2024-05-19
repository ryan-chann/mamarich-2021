import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.System.in;
import static java.lang.System.out;

abstract class MamaRich {

    private  final Scanner scanner = new Scanner(in);
    private  int cartItemsCount = 0;
    private  double cartPrice;
    private  Food[] food = new Food[setFoodItems().length];
    private  Beverage[] beverage = new Beverage[setBeverageItems().length];
    private  CartItem[] cartItems = new CartItem[20];
    private  Order order = new Order();

    private  Customer currentCus = new Customer();
    private  Customer[] customerMamaRich = new Customer[4];

    public void system() {

        Scanner User = new Scanner(in);
        //Temporary Variables
        int selection;
        String UserID;

        food = setFoodItems();
        beverage = setBeverageItems();
        customerMamaRich = setCustomer();

        do {
            //Display login menu
            loginMenu();
            while (!User.hasNextInt()){
                //If the input is not digit
                if (!User.hasNextInt()){
                    out.println("\n\n\tInvalid Input !!! Please enter again.\n");
                    loginMenu();
                    User.next();
                }
            }
            //Store the selection
            selection = User.nextInt();
            switch (selection){
                //If selection 1, go to login module
                case 1:
                    loginModule();
                    mainModule();
                    break;
                //If selection 2, go to register module
                case 2:
                    registerModule();
                    mainModule();
                    break;
                //If selection 3, exit program
                case 3:
                    System.exit(0);
                    break;
                //If selection out of range
                default:
                    out.println("\n\n\tInput Out Of Range !!! Please enter again.\n");
            }

        }while (selection >= 4 || selection == 0);

    }
    //----------Methods (Ryan Chan Joon Yew)----------
    //----------Set Sustenance Items----------
    //----------Set Food Items----------
    private Food[] setFoodItems() {
        //Assign temporary variable
        Food[] tempFood = new Food[999];
        int foodCount;

        //Assign Food Items into the food array
        tempFood[0] = new Food("FNG01", "Nasi Goreng Ayam", 14.00, false, "Nasi Goreng");
        tempFood[1] = new Food("FNG02", "Nasi Goreng HongKong", 15.00, true, "Nasi Goreng");
        tempFood[2] = new Food("FNG03", "Nasi Goreng Ati Ampela", 16.00, false, "Nasi Goreng");
        tempFood[3] = new Food("FNG04", "Nasi Goreng Basis", 16.00, true, "Nasi Goreng");
        tempFood[4] = new Food("FIP01", "Seafood Pasta", 24.90, false, "Pasta");
        tempFood[5] = new Food("FIP02", "Spicy Seafood Aglio Oglio", 22.90, false, "Pasta");
        tempFood[6] = new Food("FIP03", "Pasta with Crab Meat in Tomato Cream Sauce", 24.90, false, "Pasta");
        tempFood[7] = new Food("FIP04", "Mushrooms in Tomato Cream Sauce", 18.90, false, "Pasta");


        foodCount = countFoodItems(tempFood); //Count food items
        Food[] food = new Food[foodCount]; //Initialize a new array with array size of the records found
        int index = 0; //Set index to 0 for creating the new array with actual size

        for (Food value : tempFood) { //For-each loop to loop through Food tempFood[999]
            if (value != null) { //If the value == null
                food[index] = value; //Else assign the value into the new array
                index++; //Increase the index
            }
        }
        return food; //Return new food array
    }
    //----------End Set Food Items----------

    //----------Set Beverage Items----------
    private Beverage[] setBeverageItems() {
        //Assign temporary variable
        Beverage[] tempBeverage = new Beverage[999];
        int beverageCount;

        //Assign Beverage Items into the beverage array
        tempBeverage[0] = new Beverage("BTA01", "Lemon Tea", 13.03, "Tea");
        tempBeverage[1] = new Beverage("BTA02", "Black Tea", 7.58, "Tea");
        tempBeverage[2] = new Beverage("BTA03", "Green Tea", 7.58, "Tea");
        tempBeverage[3] = new Beverage("BTA04", "Milk Tea", 12.76, "Tea");
        tempBeverage[4] = new Beverage("BCL01", "Green Tea Latte", 16.67, "Coffee");
        tempBeverage[5] = new Beverage("BCL02", "Black Tea Latte", 12.73, "Coffee");
        tempBeverage[6] = new Beverage("BCL03", "Hazelnut Latte", 15.76, "Coffee");
        tempBeverage[7] = new Beverage("BCC01", "Chocolate Cappuccino", 15.40, "Coffee");
        tempBeverage[8] = new Beverage("BCC02", "Hazelnut Cappuccino", 17.80, "Coffee");
        tempBeverage[9] = new Beverage("BCC03", "Vanilla Cappuccino", 16.50, "Coffee");

        beverageCount = countBeverageItems(tempBeverage); //Count Beverage items
        Beverage[] beverage = new Beverage[beverageCount]; //Initialize new beverage array with actual array size based on the record
        int index = 0; //Set index to 0 for assigning records into the new array

        for (Beverage value : tempBeverage) { //For-each loop to loop through Beverage tempBeverage[999]
            if (value != null) {
                beverage[index] = value;
                index++; //Increase the index
            }
        }

        return beverage; //Return beverage array
    }
    //----------End Set Beverage Items----------
    //----------End Set Sustenance Items----------

    //----------Count Array Methods----------
    //Method to count food items
    private int countFoodItems(Food[] food) {
        int foodCount = 0;

        for (Food value : food) {
            if (value != null) {
                foodCount++;
            }
        }
        return foodCount;
    }

    //Method to count Beverage Items
    private int countBeverageItems(Beverage[] beverage) {
        int beverageCount = 0;

        for (Beverage value : beverage) {
            if (value != null) {
                beverageCount++;
            }
        }
        return beverageCount;
    }
    //----------End Count Array Methods----------

    //----------Display Sustenance By Category----------
    //----------Nasi Goreng----------
    private void displayNasiGoreng() {
        for (Food value : this.food) {
            if (value != null) {
                value.displayFoodCategory("Nasi Goreng");
            }
        }
    }
    //----------End Nasi Goreng----------

    //----------Pasta----------
    private void displayPasta() {
        for (Food value : this.food) {
            if (value != null) {
                value.displayFoodCategory("Pasta");
            }
        }
    }
    //----------End Pasta----------

    //----------Tea----------
    private void displayTea() {
        for (Beverage value : this.beverage) {
            if (value != null) {
                value.displayBeverageType("Tea");
            }
        }
    }
    //----------End Tea----------

    //----------Coffee----------
    private void displayCoffee() {
        for (Beverage value : this.beverage) {
            if (value != null) {
                value.displayBeverageType("Coffee");
            }
        }
    }

    //----------End Coffee----------
    //----------End Display Sustenance By Category----------

    //----------Menu----------
    //----------Cart Menu----------
    private void cartMenu() {
        out.println("\n\t+-----------------------+");
        out.printf("\t|%18s%6s\n", "Add To Cart", "|");
        out.println("\t+-----------------------+");
        out.printf("\t|%13s%11s\n", "1. Food", "|");
        out.printf("\t|%17s%7s\n", "2. Beverage", "|");
        out.printf("\t|%18s%6s\n", "3. View Cart", "|");
        out.printf("\t|%13s%11s\n", "4. Back", "|");
        out.println("\t+-----------------------+");
        out.print("\tPlease enter your selection > ");
    }
    //----------End Cart Menu----------

    //----------Food Menu----------
    private void foodMenu() {
        out.printf("\n%17s\n", "Food");
        out.println("===================================");
        out.println("1. Nasi Goreng");
        out.println("2. Pasta");
        out.println("3. Back");
        out.print("Please enter your selection > ");
    }
    //----------End Food Menu----------

    //----------Beverage Menu----------
    private void beverageMenu() {
        out.printf("\n%22s\n", "Beverages");
        out.println("===================================");
        out.println("1. Coffee");
        out.println("2. Tea");
        out.println("3. Back");
        out.print("Please enter your selection > ");
    }
    //----------End Beverage Menu----------

    //----------Nasi Goreng Menu----------
    private String nasiGorengMenu() {
        String selection;
        boolean valid = false;

        out.printf("\n%21s %47s\n", "Nasi Goreng", "Price");
        out.printf("%-61s%s\n", "===============================", "==========");
        this.displayNasiGoreng();
        out.println("-----------------------------------------------------------------------");
        out.println("Foods with asterisk '*' behind the name --> Spicy Food");
        out.println("Enter 'XXXXX' to head back to the order menu"); //XXXXX to cancel order
        selection = this.promptOrderSelection();

        for (Food value : this.food) {
            if (value != null) {
                if (value.equals(selection)) {
                    valid = true;
                }
            }
        }

        if (selection.equalsIgnoreCase("XXXXX")) {
            valid = true;
        }

        if (valid) {
            return selection;
        } else {
            return "SKIP";
        }

    }
    //----------End Nasi Goreng Menu----------

    //----------Pasta Menu----------
    private String pastaMenu() {
        String selection;
        boolean valid = false;

        out.printf("\n%15s %53s\n", "Pasta", "Price");
        out.printf("%-61s%s\n", "===============================", "==========");
        this.displayPasta();
        out.println("-----------------------------------------------------------------------");
        out.println("Foods with asterisk '*' behind the name --> Spicy Food");
        out.println("Enter 'XXXXX' to head back to the order menu"); //XXXXX to cancel order

        selection = this.promptOrderSelection();

        for (Food value : this.food) {
            if (value != null) {
                if (value.equals(selection)) {
                    valid = true;
                }
            }
        }

        if (selection.equalsIgnoreCase("XXXXX")) {
            valid = true;
        }

        if (valid) {
            return selection;
        } else {
            return "SKIP";
        }
    }
    //----------End Pasta Menu----------

    //----------Tea Menu----------
    private String teaMenu() {
        String selection;
        boolean valid = false;
        out.printf("\n%13s %30s\n", "Tea", "Price");
        out.printf("%-36s%s\n", "===============================", "==========");
        displayTea();
        out.println("Enter 'XXXXX' to head back to the order menu"); //XXXXX to cancel order

        selection = promptOrderSelection();

        for (Beverage value : this.beverage) {
            if (value != null) {
                if (value.equals(selection)) {
                    valid = true;
                }
            }
        }

        if (selection.equalsIgnoreCase("XXXXX")) {
            valid = true;
        }

        if (valid) {
            return selection;
        } else {
            return "SKIP";
        }
    }
    //----------End Tea Menu----------

    //----------Serve Beverage Iced Menu----------
    private void icedMenu(){
        out.println("\nWould you like your drink to be served iced?");
        out.println("1. Yes (+ RM 1.00)");
        out.println("2. No");
        out.print("Selection > ");
    }
    //----------End Serve Beverage Iced Menu----------

    //----------Serve Beverage Iced Module----------
    private boolean icedModule() {
        Scanner userInput = new Scanner(in);
        boolean iced = false;
        int selection;
        //Do-While Loop
        do {
            this.icedMenu(); //Display Iced Menu

            //Validate for input other than integer
            while (!userInput.hasNextInt()) {
                if (!userInput.hasNextInt()) {
                    out.println("\n\nInvalid Input !!! Please enter again.\n");
                    this.icedMenu();
                    userInput.next();
                }
            }

            selection = userInput.nextInt();

            switch (selection) {
                case 1: {
                    //iced = true
                    iced = true;
                    break;
                }
                case 2: {
                    //Default iced = false
                    break;
                }
                default: {
                    out.println("\n\n\tInput Out Of Range !!! Please enter again.\n\n");
                }
            }
        }while(selection >= 3 || selection == 0);
        return iced;
    }
    //----------End Serve Beverage Iced Module----------

    //----------Coffee Menu----------
    private String coffeeMenu() {
        String selection;
        boolean valid = false;

        out.printf("\n%16s %27s\n", "Coffee", "Price");
        out.printf("%-36s%s\n", "===============================", "==========");
        displayCoffee();
        out.println("Enter 'XXXXX' to head back to the order menu"); //XXXXX to cancel order

        selection = promptOrderSelection();

        for (Beverage value : beverage) {
            if (value != null) {
                if (value.equals(selection)) {
                    valid = true;
                }
            }
        }
        if (selection.equalsIgnoreCase("XXXXX")) {
            valid = true;
        }

        if (valid) {
            return selection;
        } else {
            return "SKIP";
        }
    }
    //----------End Coffee Menu----------
    //----------End Menu----------

    //----------Cart-Related Modules----------
    //----------Main Cart Module----------
    private void cartModule() {
        //Temporary Variables
        int selection;

        Scanner cart = new Scanner(in);

        //Do-While Loop
        do {
            cartMenu(); //Display Cart Menu

            //Validate for input other than integer
            while (!cart.hasNextInt()) {
                if (!cart.hasNextInt()) {
                    out.println("\n\nInvalid Input !!! Please enter again.\n");
                    this.cartMenu();
                    cart.next();
                }
            }

            //Set selection variable with user input
            selection = cart.nextInt();

            switch (selection) {
                case 1: {
                    this.foodModule();
                    break;
                }
                case 2:
                    this.beverageModule();
                    break;
                case 3:
                    if (checkCartFilled()) {
                        this.cartFunctionSelection();
                    } else {
                        out.println("\nPlease Fill In Your Cart First !!!\n");
                        selection = 0;
                    }
                    break;
                case 4: {
                    this.orderMenu();
                    break;
                }
                default: {
                    out.println("\n\n\tInput Out Of Range !!! Please enter again.\n\n");
                }
            }

        } while (selection >= 5 || selection == 0);
    }
    //----------End Main Cart Module----------

    //----------Food Module----------
    private void foodModule() {
        int selection;
        Scanner foodInput = new Scanner(in);
        String orderedItemID;
        //Do-While Loop to validate selection out of range
        do {
            this.foodMenu(); //Display Food Menu

            //Validate for input other than integer
            while (!foodInput.hasNextInt()) {
                if (!foodInput.hasNextInt()) {
                    out.println("\n\nInvalid Input !!! Please enter again.\n");
                    this.foodMenu();
                    foodInput.next();
                }
            }

            selection = foodInput.nextInt();//Assign selection to the user input


            switch (selection) {
                case 1: { //Nasi Goreng
                    selection = 0; //Clears the selection for the next input
                    orderedItemID = this.nasiGorengMenu();  //Assign orderedItem with user input
                    this.addFoodToCart(orderedItemID);
                    break;
                }
                case 2: { //Pasta
                    selection = 0;
                    orderedItemID = this.pastaMenu();
                    this.addFoodToCart(orderedItemID);
                    break;
                }
                case 3: { //Back
                    this.cartModule();
                    break;
                }
                default: {
                    out.println("\n\n\tInput Out Of Range !!! Please enter again.\n\n");
                }
            }
        } while (selection >= 4 || selection == 0);
    }
    //----------End Food Module----------

    //----------Beverage Module----------
    private void beverageModule() {
        int selection;
        Scanner beverageInput = new Scanner(in);
        String orderedItemID;
        boolean iced;
        do {
            this.beverageMenu();
            //Validate for input other than integer
            while (!beverageInput.hasNextInt()) {
                if (!beverageInput.hasNextInt()) {
                    out.println("\n\nInvalid Input !!! Please enter again.\n");
                    this.foodMenu();
                    beverageInput.next();
                }
            }

            selection = beverageInput.nextInt();//Assign selection to the user input

            switch (selection) {
                case 1: { //Coffee
                    selection = 0;
                    orderedItemID = this.coffeeMenu();
                    if(!orderedItemID.equalsIgnoreCase("SKIP") && !orderedItemID.equalsIgnoreCase("XXXXX")) {
                        iced = this.icedModule();
                        this.addBeverageToCart(orderedItemID,iced);
                    }else{
                        this.addBeverageToCart(orderedItemID,false);
                    }
                    break;
                }


                case 2: { //Tea
                    selection = 0;
                    orderedItemID = this.teaMenu();
                    if(!orderedItemID.equalsIgnoreCase("SKIP") && !orderedItemID.equalsIgnoreCase("XXXXX")) {
                        iced = this.icedModule();
                        this.addBeverageToCart(orderedItemID,iced);
                    }else{
                        this.addBeverageToCart(orderedItemID,false);
                    }
                    break;
                }

                case 3: { //Back
                    this.cartModule();
                    break;
                }

                default: {
                    out.println("\n\n\tInput Out Of Range !!! Please enter again.\n\n");
                }
            }
        } while (selection >= 4 || selection == 0);
    }
    //----------End Beverage Module----------

    //----------User add cart validation ----------
    private boolean getCartItemValidation(String id) {
        if (id.equalsIgnoreCase("XXXXX")) {
            return false;
        } else if (id.equalsIgnoreCase("SKIP")) {
            out.println("\nID entered not found in the record");
            return false;
        } else {
            return true;
        }
    }
    //----------End user add cart validation----------

    //----------Add Beverage To Cart----------
    private void addBeverageToCart(String orderedItemID, boolean iced) {
        if (getCartItemValidation(orderedItemID)) { //Compare user input with food records
            for (Beverage value : this.beverage) {
                if (value != null) { //If the value is empty skip the for-each loop
                    if (value.equals(orderedItemID)) {
                        if (iced) {
                            value.setIced();
                        }
                        this.cartItems[cartItemsCount] = new CartItem(value);
                        this.cartItemsCount++;
                        out.println("\n You have successfully added " + value.getSustenanceName() + " into your cart!\n");
                    }
                }
            }
        }
    }
    //----------End Add Beverage To Cart----------

    //----------Add Food To Cart----------
    private void addFoodToCart(String orderedItemID) {
        if (getCartItemValidation(orderedItemID)) { //Compare user input with food records
            for (Food value : this.food) {
                if (value != null) { //If the value is empty skip the for-each loop
                    if(value.equals(orderedItemID)){
                        this.cartItems[cartItemsCount] = new CartItem(value);
                        this.cartItemsCount++;
                        out.println("\n You have successfully added "+ value.getSustenanceName() + " into your cart!\n");
                    }
                }
            }
        }
    }
    //----------End Add Food To Cart----------

    //----------Display Cart List----------
    private void displayCartList() {
        int index = 0;
        out.printf("\n%42s\n", "Cart List");
        out.println("========================================================================");
        for (CartItem value : this.cartItems) {
            if (value != null) {
                out.print((index + 1) + ". " + value);
                index++;
            }
        }
        out.println("------------------------------------------------------------------------");
        out.printf("%-10s : %d Items\n", "Total", index);
        out.printf("%15s %.2f\n", ": RM", this.calculateCartPrice());
        out.println("\n1. Delete Cart Item");
        out.println("2. Place Order");
        out.println("3. Back");
        out.print("Enter your selection > ");
        this.clearCartPriceForDisplay();
    }
    //----------End Display Cart List----------

    //----------Calculate Cart Price----------
    private double calculateCartPrice() {
        for (CartItem value : this.cartItems) {
            if (value != null) {
                this.cartPrice += value.getItemPrice();
            }
        }
        return this.cartPrice;
    }
    //----------End Calculate Cart Price----------

    //----------View Cart Functions----------
    private void cartFunctionSelection() {
        int selection;
        Scanner userInput = new Scanner(in);
        do {
            this.displayCartList();
            while (!userInput.hasNextInt()) {
                if (!userInput.hasNextInt()) {
                    out.println("\n\nInvalid Input !!! Please enter again.\n"); //Display Error Message
                    this.displayCartList();    //Display Order Menu
                    userInput.next();   //Prompt User Input
                }
            }

            selection = userInput.nextInt();

            switch (selection) {
                case 1: {
                    this.deleteCartItems();
                    this.cartModule();
                    break;
                }
                case 2: {
                    this.setOrders();
                    this.orderModule();
                    this.cartModule();
                    break;
                }

                case 3:{
                    this.cartModule();
                    break;
                }
                default: {
                    out.println("\n\n\tInput Out Of Range !!! Please enter again.\n\n");
                }
            }

        } while (selection >= 4);
    }
    //----------End View Cart Functions----------

    //----------Set Order Function----------
    private String getOrderItems() {
        String orderItems = new String();
        int index = 1;
        for (CartItem value : this.cartItems) {
            if (value != null) {
                orderItems += index + ". " + value;
                index++;
            }
        }
        return orderItems;
    }


    private void orderModule(){
        int selection, valid, index;
        Scanner userInput = new Scanner(in);

        do{
            this.orderFunctionMenu();
            while (!userInput.hasNextInt()) {
                if (!userInput.hasNextInt()) {
                    out.println("\n\nInvalid Input !!! Please enter again.\n"); //Display Error Message
                    orderFunctionMenu();
                    userInput.next();   //Prompt User Input
                }
            }
            selection = userInput.nextInt();

            switch(selection){
                case 1:{ //Pay Order

                    //Get the index of the current user
                    index = this.getcurrentUser();

                    //Get the valid (That to check whether user's balance is enough or not)
                    valid = customerMamaRich[index].calculateOrder(order.getTotalPrice());
                    if (valid == 1){
                        out.println("\n\nYour e-wallet balance is not enough !!! Please reload the balance.");
                        this.clearCartPriceForDisplay();
                        this.clearOrder();
                        this.walletModule();
                    }else {
                        this.clearCart();
                        out.println("\n\nYour order had been pay successfully. Thank you\n\n");
                        System.exit(0);
                    }

                    break;
                }
                case 2:{ //Cancel
                    this.clearCartPriceForDisplay();
                    this.clearOrder();
                    this.cartFunctionSelection();
                    break;
                }
                default:{
                    out.println("\n\n\tInput Out Of Range !!! Please enter again.\n\n");
                }
            }
        }while(selection >= 3 || selection == 0);
    }


    private void orderFunctionMenu(){
        out.println("1. Pay Now");
        out.println("2. Cancel");
        out.print("Selection > ");
    }


    private void setOrders() {
        int index = 0;
        String orderID = currentCus.getCustomerID() + " Order" + (index + 1);
        order = new Order(orderID, currentCus, this.getOrderItems(), this.calculateCartPrice(), this.cartItemsCount);
        out.print(order);
    }

    private void clearOrder(){
        this.order = null;
    }

    private void clearCart(){
        int index = 0;
        for(CartItem value : this.cartItems){
            this.cartItems[index] = null;
            index++;
        }
        clearCartPriceForDisplay();
        this.cartItemsCount = 0;
    }

    //----------Delete Cart Items----------
    private void deleteCartItems() {
        int selection;
        String tempName;
        do {

            Scanner userInput = new Scanner(in);
            out.print("Enter the number of item to be deleted (Enter 999 to cancel): ");

            while (!userInput.hasNextInt()) {
                if (!userInput.hasNextInt()) {
                    out.println("\n\nInvalid Input !!! Please enter again.\n"); //Display Error Message
                    out.println("Enter the number of item to be deleted (Enter 999 to cancel): ");
                    displayCartList();    //Display Order Menu
                    userInput.next();   //Prompt User Input
                }
            }
            selection = userInput.nextInt();

            if (selection <= cartItemsCount && selection != 0) {
                tempName = cartItems[selection - 1].getItemName();
                for(int index = (selection - 1); index < cartItems.length - 1; index++){
                    cartItems[index] = cartItems[index + 1];
                }
                cartItemsCount -= 1;
                out.println("\nYou have successfully removed item '" + tempName + "' \n");
                break;
            } else if ((selection > cartItemsCount || selection == 0) && selection != 999) {
                out.println("\nInvalid Input !!! Please enter again.\n"); //Display Error Message
                continue;
            }
        } while (selection != 999);
    }
    //----------End Delete Cart Items----------

    //----------Clear Cart For Display----------
    private void clearCartPriceForDisplay() {
        this.cartPrice = 0.0;
    }
    //----------End Clear Cart For Display----------

    //----------Check Cart is filled----------
    private boolean checkCartFilled() {
        boolean valid = false;

        for (CartItem value : cartItems) {
            if (value != null) {
                valid = true;
                break;
            }
        }
        return valid;
    }
    //----------End Check Cart is filled----------

    //----------Prompt Order Selection (On Food and Beverage Menu)----------
    private String promptOrderSelection() {
        //Define variables
        String selection;

        //Print Selection Prompt Message
        out.print("Enter ID > ");

        //Assign selection with user input
        selection = scanner.nextLine();

        //Return selection with uppercase
        return selection.toUpperCase();
    }
    //----------End Prompt Order Selection (On Food and Beverage Menu)----------
    //----------End Cart-Related Modules----------
    //----------End Methods (Ryan Chan Joon Yew)----------

    //----------Methods (Jong Xuan Jie)----------
    //----------Menu----------
    //----------Login Menu----------
    private void loginMenu() {
        out.println("\t+---------------------------------------+");
        out.printf("\t|%30s%10s\n", "Welcome to MamaRich", "|");
        out.println("\t+---------------------------------------+");
        out.printf("\t|%30s%10s\n", "Enter Your Selection", "|");
        out.println("\t+---------------------------------------+");
        out.printf("\t|%22s%18s\n", "1. Login", "|");
        out.printf("\t|%25s%15s\n", "2. Register", "|");
        out.printf("\t|%21s%19s\n", "3. Exit", "|");
        out.println("\t+---------------------------------------+");
        out.print("\tEnter your selection > ");
    }
    //----------End Login Menu----------

    //----------Main Menu----------
    private void mainMenu() {
        out.println("\t+------------------------------+");
        out.printf("\t|%25s%6s\n", "Choose Your Option", "|");
        out.println("\t+------------------------------+");
        out.printf("\t|%16s%15s\n", "1. Order", "|");
        out.printf("\t|%26s%5s\n", "2. MamaRich Wallet", "|");
        out.printf("\t|%15s%16s\n", "3. Exit", "|");
        out.println("\t+------------------------------+");
        out.print("\tPlease enter your selection > ");
    }
    //----------End Main Menu----------

    //----------MamaRich E-Wallet Menu----------
    private void walletMenu() {
        out.println("\n\n\t+--------------------+");
        out.printf("\t|%18s%3s\n", "MamaRich Wallet", "|");
        out.println("\t+--------------------+");
        out.printf("\t|%18s%3s\n", "1. Check Amount", "|");
        out.printf("\t|%19s%2s\n", "2. Reload Amount", "|");
        out.printf("\t|%10s%11s\n", "3. Back", "|");
        out.println("\t+--------------------+");
        out.print("\tPlease enter your selection > ");
    }
    //----------MamaRich E-Wallet Menu----------

    //----------Order Menu----------
    private void displayOrderMenu() {
        out.println("\n\t+-----------------------+");
        out.printf("\t|%17s%7s\n", "Order Menu", "|");
        out.println("\t+-----------------------+");
        out.printf("\t|%14s%10s\n", "1. Cart", "|");
        out.printf("\t|%19s%5s\n", "2. Check Out", "|");
        out.printf("\t|%14s%10s\n", "3. Back", "|");
        out.println("\t+-----------------------+");
        out.print("\tPlease enter your selection > ");
    }
    //----------End Order Menu----------
    //----------End Menu----------

    //----------Modules----------
    //----------Login Module----------
    private void loginModule() {
        //Temporary Variables
        int valid = 1;
        Scanner Customer = new Scanner(in);
        String ID, Name;
        //Do-While Loop
        do {
            out.print("\n\tEnter your ID: ");
            ID = Customer.nextLine();   //Prompt Customer's ID
            out.print("\tEnter your Name: ");
            Name = Customer.nextLine(); //Prompt Customer's Name

            //Trim out unnecessary spaces
            Name = Name.trim();
            ID = ID.trim();

            //For Loop
            for (int i = 0; i < customerMamaRich.length; i++) {
                //Tips: "equalsIgnoreCase" compares String ignoring uppercase and lowercase
                if (!(customerMamaRich[i].getCustomerName().equalsIgnoreCase(Name) && customerMamaRich[i].getCustomerID().equalsIgnoreCase(ID))) { //If Customer name and Customer ID does not match the record
                    valid = 1;  //Valid = 1 indicates access denied
                } else {        //If Customer name and customer ID match the record
                    valid = 0;  //Valid = 0 indicates access granted
                    currentCus.setCurrentCustomer(ID, Name);  //Store the current user
                    out.println("\n\t+---------------------------------------------------------+");
                    out.printf("\t|%58s\n", "Welcome To MamaRich Food & Beverage Ordering System !!! |");
                    out.println("\t+---------------------------------------------------------+\n");
                    break;      //Break statement to break out the For loop
                }
            }

            if (valid == 1) {    //If access denied
                out.println("\n\tInvalid Name And ID !!! Please enter again.\n");     //Print Error Message
            }
        } while (valid != 0);    //End Do-While loop if access granted

    }
    //----------End Login Module----------

    //----------Register Module--------------
    private void registerModule(){
        //Temporary Variables
        String Name;
        int valid;
        Scanner register = new Scanner(in);
        do {
            //User input name
            out.print("\n\tEnter Your Name: ");
            Name = register.nextLine().trim();
            //Check Name is string or not
            if (checkName(Name)){
                //Stop looping
                valid = 0;
                out.println("\n\t+---------------------------------------------------------+");
                out.printf("\t|%58s\n", "Welcome To MamaRich Food & Beverage Ordering System !!! |");
                out.println("\t+---------------------------------------------------------+\n");
            }
            else {
                out.println("\n\n\tInvalid Input !!! Please enter again.\n"); //Display Error Message
                valid = 1;  //Continue looping
            }

        }while (valid == 1);

        //Store to object and set payment card amount to 5000
        customerMamaRich[3] = new Customer("C004", Name, 5000);
        //Set current user
        currentCus.setCurrentCustomer(customerMamaRich[3].getCustomerID(), Name);
    }
    //----------End Register Module----------

    //----------Order Module----------
    private void orderMenu() {
        //Temporary Variables
        int selection;
        Scanner Order = new Scanner(in);

        //Do-While Loop
        do {
            displayOrderMenu(); //Display Order Menu

            //If the user enter other than integer (Validation)
            while (!Order.hasNextInt()) {
                //If the input is not digit
                if (!Order.hasNextInt()) {
                    out.println("\n\nInvalid Input !!! Please enter again.\n"); //Display Error Message
                    displayOrderMenu();    //Display Order Menu
                    Order.next();   //Prompt User Input
                }
            }
            //Store the selection
            selection = Order.nextInt();

            switch (selection) {
                //If selection 1, go to cart module
                case 1:
                    cartModule();
                    break;
                //If selection 2, go to check out
                case 2:
                    if (checkCartFilled()) {
                        setOrders();
                        orderModule();
                    } else {
                        out.println("\nPlease Fill In Your Cart First !!!\n");
                        selection = 0;
                    }
                    cartModule();
                    break;
                //If selection 3, back to main module
                case 3:
                    mainModule();
                    break;
                //If selection out of range
                default:
                    out.println("\n\n\tInput Out Of Range !!! Please enter again.\n\n");
            }
        } while (selection >= 4 || selection == 0);
    }
    //----------End Order Module---------

    //----------Main Module----------
    private void mainModule() {
        //Temporary Variables
        int selection;
        Scanner Menu = new Scanner(in);

        do {
            //Display main menu
            mainMenu();
            while (!Menu.hasNextInt()) {
                //If the input is not digit
                if (!Menu.hasNextInt()) {
                    out.println("\n\nInvalid Input !!! Please enter again.\n");
                    mainMenu();
                    Menu.next();
                }

            }
            //Store the selection
            selection = Menu.nextInt();

            switch (selection) {
                //If selection 1, go to order module
                case 1:
                    orderMenu();
                    break;
                //If selection 2, go to e-wallet module
                case 2:
                    walletModule();
                    break;
                //If selection 3, exit program
                case 3:
                    System.exit(0);
                    break;
                //If selection out of range
                default:
                    out.println("\n\n\tInput Out Of Range !!! Please enter again.\n\n");
            }
        } while (selection >= 4 || selection == 0);
    }
    //----------End Main Module----------

    //----------E-Wallet Module----------
    private void walletModule() {
        //Temporary Variables
        int selection;

        Scanner Wallet = new Scanner(in);

        do {

            //Display wallet menu
            walletMenu();

            while (!Wallet.hasNextInt()) {
                //If input is not digit
                if (!Wallet.hasNextInt()) {
                    out.println("\n\nInvalid Input !!! Please enter again.");
                    walletMenu();
                    Wallet.next();
                }

            }
            //Store the selection
            selection = Wallet.nextInt();

            switch (selection) {
                //If selection 1, check the current balance in e-wallet
                case 1:
                    checkAmountModule();
                    break;
                //If selection 2, allow user transfer the money in payment card to e-wallet
                case 2:
                    reloadAmountModule();
                    break;
                //If selection 3, back to main module
                case 3:
                    mainModule();
                    break;
                //If selection out of range
                default:
                    out.println("\n\n\tInput Out Of Range !!! Please enter again.\n\n");
            }
        } while (selection >= 4 || selection == 0);
    }
    //----------End Wallet Module----------

    //----------Check Amount Module----------
    private void checkAmountModule(){
        //Temporary Variables
        int index = 0;
        char choose;

        Scanner Wallet = new Scanner(in);

        //Get index of current user
        index = getcurrentUser();
        out.println(customerMamaRich[index].displayWallet());

        do {
            //Ask user for continue
            out.print("\n\nDo you want to continue (Y/N)\n" +
                    "Enter any letters start with (Y/N)\n"
                    + "NOTE: N will exit the program > ");
            //Find out the first letter user input
            choose = Wallet.next().charAt(0);
            choose = Character.toUpperCase(choose);
            //If input is not start with Y or N
            if (choose != 'N' && choose != 'Y') {
                out.println("\nInvalid Input !!! Please enter again\n");
            }
        } while (choose != 'N' && choose != 'Y');
        //If start with Y, move to main module
        if (choose == 'Y') {
            mainModule();
        }
        //If start with N, exit program
        else {
            System.exit(0);
        }
    }
    //----------End Check Amount Module------

    //----------Reload Module----------
    private void reloadAmountModule(){
        //Temporary Variables
        int cardNum = 0, valid = 0, index = 0;
        double addAmount;
        char choose;
        Scanner Wallet = new Scanner(in);


        //Get index of current user
        index = getcurrentUser();

        do {
            valid = 0;
            out.print("Enter Your Payment Card Number > ");
            while (!Wallet.hasNextInt()) {
                //If the input is not integer
                if (!Wallet.hasNextInt()) {
                    out.println("\n\nInvalid Input !!! Please enter again.\n");
                    out.print("Enter Your Payment Card Number > ");
                    Wallet.next();
                }
            }
            //Store the payment card number
            cardNum = Wallet.nextInt();
            if (String.valueOf(cardNum).length() == 8) {
                customerMamaRich[index] = new Customer(customerMamaRich[index].getCustomerID(), customerMamaRich[index].getCustomerName(), cardNum, customerMamaRich[index].getTotalAmount());
                //If the payment card is invalid
                if (customerMamaRich[index].checkCard() == 1) {
                    out.println("\nInvalid Payment Card Number !!! Please enter again\n");
                    //Reset the object
                    customerMamaRich[index] = new Customer();
                    //Continue looping
                    valid = 1;
                }
                else {
                    //Stop looping
                    valid = 0;
                }
            }
            else {
                //Display invalid message if the length of the payment card is not equal to 8
                out.println("\nInvalid Payment Card Number !!! Please enter again\n");

                //Continue looping
                valid = 1;
            }

        } while (valid == 1);

        //Display payment card details
        out.println(customerMamaRich[index].displayPayment());

        //Prompt user input the amount to do the transaction to e-wallet
        out.print("Enter The Amount You Want Transfer to MamaRich E-Wallet: RM ");
        while (!Wallet.hasNextDouble()) {
            //If the input is invalid format of money
            if (!Wallet.hasNextDouble()) {
                out.println("\n\nInvalid Input !!! Please enter again.\n");
                out.print("Enter The Amount You Want Transfer to MamaRich E-Wallet: RM ");
                Wallet.next();
            }
        }
        //Store the amount
        addAmount = Wallet.nextDouble();

        valid = customerMamaRich[index].calculateAmount(addAmount);
        //Transaction completed
        if (valid == 0) {
            out.println("\nTransactions Successfully Completed");
            //Add amount in e-wallet
            customerMamaRich[index].setWalletBalance(addAmount);

        } else {
            //Balance in payment card is not enough
            out.println("\nThe Balance In Payment Card Is Not Enough !!! Please Reload Your Amount In Payment Card");
            //Auto exit program
            System.exit(0);
        }

        do {
            //Ask user for continue
            out.print("\n\nDo you want to continue (Y/N)\n" +
                    "Enter any letters start with (Y/N)\n"
                    + "NOTE: N will exit the program > ");
            //Find out the first letter user input
            choose = Wallet.next().charAt(0);
            choose = Character.toUpperCase(choose);
            //If input is not start with Y or N
            if (choose != 'N' && choose != 'Y') {
                out.println("\nInvalid Input !!! Please enter again\n");
            }
        } while (choose != 'N' && choose != 'Y');
        //If start with Y, move to main module
        if (choose == 'Y') {
            mainModule();
        }
        //If start with N, exit program
        else {
            System.exit(0);
        }
    }
    //----------End Reload Module------
    //----------End Module-------------

    //Get current user
    private int getcurrentUser(){
        //Find the current user
        String ID = currentCus.getCustomerID();
        int index = 0;
        //Get the index of array for the current user
        for (int i = 0; i < customerMamaRich.length; i++) {
            if (customerMamaRich[i].getCustomerID().equalsIgnoreCase(ID)) {
                index = i;
                break;
            }

        }
        //Return the index of the current user
        return index;
    }

    //Check validation of name
    private boolean checkName(String name){
        return Pattern.matches("[a-zA-Z ]+", name);
    }

    //Set the customers that already exist
    private Customer[] setCustomer(){
        Customer[] customers = new Customer[4];
        customers[0] = new  Customer("C001", "Ali", 7500);
        customers[1] = new  Customer("C002", "Mary", 4500);
        customers[2] = new  Customer("C003", "Abu", 5000);
        return customers;
    }
    //----------End Methods (Jong Xuan Jie)------
}