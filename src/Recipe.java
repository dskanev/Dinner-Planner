/**
 * Created by Denislav on 1/30/2018.
 */
import java.io.File;
import java.util.Scanner;

/**
 * Created by Denislav on 12/11/2017.
 */
public class Recipe {
    private String name;
    private String author;
    private String description;
    private int timeToMake;
    private String timeUnits;

    public String getTimeUnits() {
        return timeUnits;
    }

    private int servings;
    private int calories;
    //
    private IngredientList listOfIngredients;
    //basically an array list of strings
    private InstructionsList listOfInstructions;

    public Recipe(String fileName){
        //uses the recipe.txt files to create Recipe objects
        this.listOfIngredients = new IngredientList(fileName);
        setAll(fileName);
        this.listOfInstructions = new InstructionsList(fileName);

    }
    private void setAll(String fileName){

        try {
            Scanner sc = new Scanner(new File("data/"+fileName), "UTF-8");
            while (sc.hasNext()) {
                String line = sc.nextLine();

                if (line.startsWith("Name: ")) {
                    this.name = line.substring(6);
                }
                if (line.startsWith("Author: ")) {
                    this.author = line.substring(8);
                }
                if (line.startsWith("Description: ")) {
                    this.description = line.substring(13);
                }
                if (line.startsWith("Time: ")) {
                    String s = line.substring(6);
                    String[] temp = s.split(" ");

                    this.timeToMake = Integer.parseInt(temp[0]);
                    this.timeUnits = (temp[1]);
                }
                if (line.startsWith("Servings: ")) {
                    this.servings = Integer.parseInt(line.substring(10));
                }
                if (line.startsWith("Calories: ")) {
                    this.calories = Integer.parseInt(line.substring(10));
                }
            }


        }catch (Exception e) {


        }
    }
    public String getName() {
        return name;
    }


    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public int getTimeToMake() {
        return timeToMake;
    }

    public int getServings() {
        return servings;
    }

    public int getCalories() {
        return calories;
    }

    public IngredientList getListOfIngredients() {
        return listOfIngredients;
    }

    public InstructionsList getListOfInstructions() {
        return listOfInstructions;
    }
    public void displayListOfIngredients(){
        listOfIngredients.display();
    }

    public void display(){
        System.out.println("Name of recipe: " + getName());
        System.out.println("Author: " + getAuthor());
        System.out.println("Description: " + getDescription());
        System.out.println("Time: " + getTimeToMake()+ " " + timeUnits);
        System.out.println("Servings: " + getServings());
        System.out.println("Calories: " + getCalories());
        System.out.println("List of ingredients: ");
        listOfIngredients.display();
        System.out.println("Instructions: ");
        listOfInstructions.display();


    }


}
