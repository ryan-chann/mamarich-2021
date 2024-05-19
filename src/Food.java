public class Food extends Sustenance{
    private boolean spice;
    private String foodCategory;

    //----------Constructors----------
    public Food(){

    }

    public Food(String sustenanceID, String sustenanceName, double sustenancePrice, boolean spice, String foodCategory){
        super(sustenanceID,sustenanceName,sustenancePrice);
        this.setSpice(spice);
        this.setFoodCategory(foodCategory);
    }
    //----------End Constructors----------

    //----------Methods----------
    //----------Assessors And Mutators----------
    //----------Setters----------
    public void setSpice(boolean newSpice){
        this.spice = newSpice;
    }

    public void setFoodCategory(String newFoodCategory){
        this.foodCategory = newFoodCategory;
    }

    //----------End Setters----------

    //----------Getters----------
    public boolean getSpice(){
        return this.spice;
    }

    public String getFoodCategory(){
        return this.foodCategory;
    }
    //----------End Getters----------
    //----------End Assessors And Mutators----------

    public void displayFoodCategory(String foodCategory){
        if(this.getFoodCategory().equalsIgnoreCase(foodCategory)){
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
    public String toString() {
        if (this.getSpice()) {
            return String.format("%s --> %-50s %s %.2f)\n", this.getSustenanceID(), (this.getSustenanceName() + "*"), "(RM", this.getSustenancePrice());
        } else {
            return super.toString();
        }
    }
    //----------End ToString----------
    //----------End Override----------
    //----------End Methods---------

}
