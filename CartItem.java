public class CartItem{
    //----------Data Fields (Private)----------
    private String itemCategory;
    private Beverage beverage;
    private Food food;
    //----------End Data Fields (Private)----------

    //----------Constructors----------
    //----------No-arg constructor----------
    public CartItem(){

    }
    //----------End No-arg Constructors----------

    //----------Parameterised Constructors----------
    public CartItem(Beverage beverage){
        setItemCategory(beverage.getClass().getSimpleName());
        this.beverage = beverage;
        this.food = null;
    }

    public CartItem(Food food){
        setItemCategory(food.getClass().getSimpleName());
        this.food = food;
        this.beverage = null;
    }

    //----------End Parameterised Constructors----------
    //----------End Constructors----------

    //----------Methods----------
    //----------Accessors And Mutators----------
    //----------Setters----------
    public void setItemCategory(String newItemCategory){
        this.itemCategory = newItemCategory;
    }
    //----------End Setters----------

    //----------Getters----------
    public String getItemCategory(){
        return this.itemCategory;
    }

    public double getItemPrice(){
        if (this.beverage == null) {
            return food.getSustenancePrice();
        } else {
            return beverage.getSustenancePrice();
        }
    }

    public String getItemName(){
        if (this.beverage == null) {
            return food.getSustenanceName();
        } else {
            return beverage.getSustenanceName();
        }
    }
    //----------End Getters----------
    //----------End Accessors And Mutators----------

    //----------Override----------
    //----------ToString----------
    public String toString() {
        if (this.beverage == null) {
            return String.format("%-60s RM %.2f\n", food.getSustenanceName(), food.getSustenancePrice());
        } else {
            if(beverage.getIced()) {
                return String.format("%-60s RM %.2f\n", beverage.getSustenanceName() + "(Iced)", beverage.getSustenancePrice());
            }else{
                return String.format("%-60s RM %.2f\n", beverage.getSustenanceName(), beverage.getSustenancePrice());
            }
        }
    }
    //----------End ToString----------

    //----------Equals----------
    public boolean equals(Object tempObject){
        return super.equals(tempObject);
    }
    //----------End Equals----------
    //----------End Override----------
    //----------End Methods----------
}
