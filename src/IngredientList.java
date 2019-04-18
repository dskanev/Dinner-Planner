
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import static java.lang.String.valueOf;

/**
 * Created by Denislav on 12/11/2017.
 */
public class IngredientList implements Collection<Ingredient> {
    private ArrayList<Ingredient> ingredients;

    public IngredientList(String fileName){
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        setIngredients(loadIngredients(fileName));
    }

    public ArrayList<Ingredient> loadIngredients(String fileName) {
        ArrayList<Ingredient> in = new ArrayList<>();
        try {
            //uses the recipe files to create a list of ingredients for each Recipe object
            Scanner sc = new Scanner(new File("data/"+fileName), "UTF-8");

            while (sc.hasNext()) {
                String line = sc.nextLine();
                //only uses the lines which match the following pattern:
                if(line.matches("[\\.\\d]* [\\S]*( [\\w]*)*")){
                    String[] ingr = line.split(" ");

                    //this is to handle the case when the ingredient name consists of several words
                    int x = 2;
                    String name = "";
                    while(x<ingr.length-1){
                        name = name.concat(ingr[x]).concat(" ");
                        x++;
                    }
                    name = name.concat(ingr[x]);
                    in.add(new Ingredient(Double.parseDouble(ingr[0]), ingr[1],name));
                }

            }

        }catch (Exception e) {


        }
        return in;

    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void display(){
        for(Ingredient i : getIngredients()){
            i.display();
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Ingredient> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Ingredient ingredient) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Ingredient> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}