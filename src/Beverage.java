public class Beverage extends Sustenance{
    private boolean iced;
    private String beverageType;

    //----------Methods----------
    //----------Constructors----------
    public Beverage(){

    }

    public Beverage(String sustenanceID, String sustenanceName, double sustenancePrice, String beverageType){
        super(sustenanceID,sustenanceName,sustenancePrice);
        this.setBeverageType(beverageType);
    }
    //----------End Constructors----------


    //----------Assessors And Mutators----------
    //----------Setters----------
    public void setBeverageType(String newBeverageType){
        this.beverageType = newBeverageType;
    }

    public void setIced(){
        this.iced = true;
        super.setSustenancePrice(super.getSustenancePrice() + 1.00);
    }

    //----------End Setters----------

    //----------Getters----------
    public String getBeverageType(){
        return this.beverageType;
    }

    public boolean getIced(){
        return this.iced;
    }
    //----------End Getters----------
    //----------End Assessors And Mutators----------

    //Display Beverage Type
    public void displayBeverageType(String beverageType){
        if(this.getBeverageType().equalsIgnoreCase(beverageType)){
            System.out.print(this.toString());
        }
    }

    //----------Override----------
    //----------Equals----------
    public boolean equals(String tempID){
        return super.equals(tempID);
    }

    public boolean equals(Object tempObject){
        return super.equals(tempObject);
    }
    //----------End Equals----------

    //----------ToString----------
    public String toString(){
        return String.format("%s --> %-25s %s %.2f)\n",this.getSustenanceID(),this.getSustenanceName(),"(RM",this.getSustenancePrice());
    }
    //----------End ToString----------
    //----------End Override----------
    //----------End Methods---------

}
