/**
 * Created by Denislav on 1/30/2018.
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denislav on 12/11/2017.
 */


/*
This class will be used for running through all the files in the 'data' folder and loading all of the recipes found there,
where each file following the specified format is a new recipe.
 */


public class FileProcessor {
    private ArrayList<Recipe> recipeList;
    private ArrayList<String> fileList;



    public FileProcessor(){
        //scans the data folder and creates a Recipe object for each file
        ArrayList<String> fileList = new ArrayList<>();
        setFileList(setupFileList());
        ArrayList<Recipe> recipeList = new ArrayList<>();
        setRecipeList(loadRecipes(this.fileList));
    }

    //scan the data folder of the project and generate a list of all the files in there
    public ArrayList<String> setupFileList() {
        File folder = new File("data/");

        File[] listOfFiles = folder.listFiles();
        System.out.println("Running...");
        System.out.println(listOfFiles.length + " recipe files loaded...");
        ArrayList<String> files = new ArrayList<>();
        for (int i = 0; i < listOfFiles.length; i++) {
            String s = listOfFiles[i].getName();
            files.add(s);
        }
        return files;
    }
    public void setFileList(ArrayList<String> fileList) {
        this.fileList = fileList;
    }
    public void setRecipeList(ArrayList<Recipe> recipeList){
        this.recipeList = recipeList;
    }

    public ArrayList<Recipe> loadRecipes(ArrayList<String> fileList){
        ArrayList<Recipe> loadedRecipes = new ArrayList<>();
        //for each line of the fileList, create a new Recipe object and store it
        for(String s : fileList){
            loadedRecipes.add(new Recipe(s));
        }
        return loadedRecipes;
    }
    public ArrayList<Recipe> getRecipeList() {
        return recipeList;
    }

    public ArrayList<String> getFileList() {
        return fileList;
    }
    public void displayRecipeList(){
        for(Recipe r : getRecipeList()){
            System.out.println("Recipe Name: " + r.getName());
        }
    }




}