import java.util.*;

public class Order {
    private String orderID;
    private Customer customerDetails;
    private String orderItems;
    private double orderPrice;
    private int itemQuantity;
    private Date orderDate;
    private static final double TAX = 0.07;
    private static final double DISCOUNT = 0.015;
    private static final double PROMOTION = 30.00; //Discount after RM30.00

    public Order() {

    }

    public Order(String orderID, Customer customerDetails, String orderItems, double orderPrice, int itemQuantity){
        setOrderID(orderID);
        setCustomerDetails(customerDetails);
        setOrderItems(orderItems);
        setOrderPrice(orderPrice);
        setItemQuantity(itemQuantity);
        setOrderDate(new Date());
    }


    //----------Methods----------
    //----------Assessors And Mutators----------
    //----------Setters----------
    public void setCustomerDetails(Customer newCustomerDetails){this.customerDetails = newCustomerDetails;}

    public void setOrderID(String newOrderID) {
        this.orderID = newOrderID;
    }

    public void setOrderItems(String newOrderItems) {
        this.orderItems = newOrderItems;
    }

    public void setOrderPrice(double newOrderPrice) {
        this.orderPrice = newOrderPrice;
    }

    public void setItemQuantity(int newItemQuantity) {
        this.itemQuantity = newItemQuantity;
    }

    public void setOrderDate(Date newOrderDate) {
        this.orderDate = newOrderDate;
    }
    //----------End Setters----------

    //----------Getters----------
    public Customer getCustomerDetails(){return this.customerDetails;}

    public String getCustomerName(){return this.customerDetails.getCustomerName();}

    public String getOrderID() {
        return this.orderID;
    }

    public String getOrderItems() {
        return this.orderItems;
    }

    public double getOrderPrice() {
        return this.orderPrice;
    }

    public int getItemQuantity() {
        return this.itemQuantity;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public double getDiscount(){
        if(this.getOrderPrice() >= PROMOTION){
            return this.getOrderPrice() * DISCOUNT;
        }else{
            return 0.0;
        }
    }

    public double getTax(){
        return (this.getOrderPrice() - getDiscount()) * TAX;
    }

    public double getTotalPrice(){
        return this.getOrderPrice() - getDiscount() + getTax();
    }
    //----------End Getters----------
    //----------End Assessors And Mutators----------


    public String toString() {//1. Order, 2.Order ID: , 3. AliOrderID, 4.Customer Name : , 5.Ali, 6. Order Date : , 7. Date,8.get Order Price
        return String.format("%36s\n------------------------------------------------------------------------\n%-16s %s\n%-16s %s\n%-16s %s\n%-16s %d %s\n\n%s\n-------------------------------RM %.2f---------------------------------\n%-16s RM %.2f\n%-16s RM %.2f\n-----------------------------------------\n%-16s RM %.2f\n-----------------------------------------\n"
                ,this.getClass().getSimpleName(),"Order ID      : ",this.getOrderID(),"Customer Name : ",this.getCustomerName(),"Order Date    : ",this.getOrderDate(),"Total Items   : ",this.getItemQuantity() ," items", this.getOrderItems(), this.getOrderPrice(),"+ Service Tax   :",this.getTax(),"- Discount      :",this.getDiscount(),"= Total         :",this.getTotalPrice());
    }

    /*
        SAMPLE OUTPUT OF toString:

        System.out.printf("%20s\n","Order");
        System.out.printf("----------------------------------------\n");
        System.out.printf("%-16s AliOrder1\n","Order ID      :");
        System.out.printf("%-16s Ali\n","Customer Name :");
        System.out.printf("%-16s 13/9/2021\n","Order Date    :");
        System.out.printf("%-16s 13 %s\n\n","Total Items   :","items");
        System.out.printf("----------------RM %.2f----------------\n\n", 100.00);
        System.out.printf("%-16s RM 200.00 \n","+ Service Tax   :");
        System.out.printf("%-16s RM 200.00 \n","- Discount      :");
        System.out.printf("-----------------------------------------\n");
        System.out.printf("%-16s RM 100.00\n", "= Total         :");
     */
}

