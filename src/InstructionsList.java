/**
 * Created by Denislav on 1/30/2018.
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Denislav on 12/11/2017.
 */

/*
As an instruction is nothing more than a line of text, it doesn't need it's own class as it can be simply treated as a string.
Therefore this InstructionsList class does nothing more but read files and store collections of strings (instructions).
 */
public class InstructionsList {
    private ArrayList<String> instructions;

    public InstructionsList(String fileName){
        setInstructions(loadInstructions(fileName));
    }


    public ArrayList<String> loadInstructions(String fileName){
        ArrayList<String> loadedInstructions = new ArrayList<>();
        //using this pattern to find lines containing proper sentences (these could be the recipe description or the instructions)
        Pattern pattern1 = Pattern.compile("[^.]* [^.]*\\.");
        try {
            Scanner sc = new Scanner(new File("data/"+fileName), "UTF-8");
            while (sc.hasNext()) {
                String line = sc.nextLine();
                Matcher matcher1 = pattern1.matcher(line);
                //make sure the line doesn't contain the recipe description which is also a sentence, this leaves instructions as the only possible thing that can be matched
                if(matcher1.find()&& !line.startsWith("Description")){
                    loadedInstructions.add(line);
                }
            }
        }catch (Exception e) {


        }
        return loadedInstructions;
    }

    public void setInstructions(ArrayList<String> instructions) {
        this.instructions = instructions;
    }

    public void display() {
        for (String i : getInstructions()) {
            System.out.println(i);
        }
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

}
