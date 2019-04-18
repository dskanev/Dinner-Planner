/**
 * Created by Denislav on 1/30/2018.
 */


/*
    This class is used to create objects of a common type for all ingredients. This will help manipulate ingredients
    in the future, e.g. convert measurement units, combine ingredients, etc.


 */
public class Ingredient {
    private double amount;
    private String measurement;
    private String name;

    public Ingredient(double amount, String measurement, String name){
        this.amount = amount;

        if(amount>1.0 && measurement.length()>1.0){
            this.measurement = measurement + "s";
        }else{
            this.measurement = measurement;
        }
        this.name = name;
    }

    public double getAmmount() {
        return amount;
    }

    public String getMeasurement() {
        return measurement;
    }

    public String getName() {
        return name;
    }

    public void setAmmount(double ammount) {
        this.amount = ammount;
    }


    public void display(){
        System.out.println(getAmmount() + " " + getMeasurement() + " " + getName());
    }

}
