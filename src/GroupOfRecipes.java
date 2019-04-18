import java.util.ArrayList;

/**
 * Created by Denislav on 2/6/2018.
 */
public class GroupOfRecipes {
    public ArrayList<Recipe> getSelectedRecipes() {
        return selectedRecipes;
    }

    ArrayList<Recipe> selectedRecipes = new ArrayList<>();
    ArrayList<Ingredient> totalIngredients = new ArrayList<>();


    public GroupOfRecipes() {
        ArrayList<Recipe> selectedRecipes = new ArrayList<>();
        ArrayList<Ingredient> totalIngredients = new ArrayList<>();
    }

    public void addRecipe(Recipe r) {
        this.selectedRecipes.add(r);
        this.totalIngredients.addAll(r.getListOfIngredients().getIngredients());
        combineIngredients();
    }

    public void removeRecipe(String name) {
        for (int i = 0; i < selectedRecipes.size(); i++) {

            if (selectedRecipes.get(i).getName().equals(name)) {
                selectedRecipes.remove(selectedRecipes.get(i));
            }
        }
    }

    public void combineIngredients() {
        for (int i = 0; i < totalIngredients.size(); i++) {
            for (int k = i + 1; k < totalIngredients.size(); k++) {
                if (totalIngredients.get(i).getName().equals(totalIngredients.get(k).getName())) {
                    double x = totalIngredients.get(i).getAmmount();
                    double y = totalIngredients.get(k).getAmmount();
                    double result = x + y;
                    totalIngredients.get(i).setAmmount(result);
                    totalIngredients.remove(k);
                }
            }
        }
    }

    public void recipesLister() {
        System.out.println("The recipes you have selected are: ");
        for (Recipe r : selectedRecipes) {
            System.out.println(r.getName());
        }
    }

    public void displayTotalIngredients() {
        for (Ingredient i : totalIngredients) {
            i.display();
        }
    }

    public ArrayList<Ingredient> getTotalIngredients() {
        return totalIngredients;
    }

    public int getTotalCalories() {
        int totalCalories = 0;
        for (Recipe r : selectedRecipes){
            totalCalories = totalCalories + r.getCalories();
        }
        return totalCalories;
    }
}
