public class Sustenance {
    //----------Data Fields (Private)----------
    private String sustenanceID;
    private String sustenanceName;
    private double sustenancePrice;

    //----------Methods----------
    //----------Constructors----------
    public Sustenance(){

    }

    public Sustenance(String sustenanceID, String sustenanceName, double sustenancePrice){
        this.sustenanceID = sustenanceID;
        this.sustenanceName = sustenanceName;
        this.sustenancePrice = sustenancePrice;
    }
    //----------End Constructors----------
    //----------Assessors And Mutators----------
    //----------Setters----------
    public void setSustenanceName(String newSustenanceName){
        this.sustenanceName = newSustenanceName;
    }

    public void setSustenanceID(String newSustenanceID){
        this.sustenanceID = newSustenanceID;
    }

    public void setSustenancePrice(double newSustenancePrice){
        this.sustenancePrice = newSustenancePrice;
    }

    //----------End Setters----------

    //----------Getters----------
    public String getSustenanceName(){
        return this.sustenanceName;
    }

    public String getSustenanceID(){
        return this.sustenanceID;
    }

    public double getSustenancePrice(){
        return this.sustenancePrice;
    }

    //----------End Getters----------
    //----------End Assessors And Mutators----------

    //----------Override----------
    //----------Equals----------
    public boolean equals(String tempID){
        return this.getSustenanceID().equalsIgnoreCase(tempID);
    }
    //----------End Equals----------
    //----------ToString----------
    public String toString(){
        return String.format("%s --> %-50s %s %.2f)\n",this.getSustenanceID(),this.getSustenanceName(),"(RM",this.getSustenancePrice());
    }
    //----------End ToString----------
    //----------End Override----------
    //----------End Methods---------
}
