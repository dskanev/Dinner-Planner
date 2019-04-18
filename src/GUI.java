import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Denislav on 2/6/2018.
 */
public class GUI {

    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList;
    JFrame theFrame;


    public void buildGUI() {

        GroupOfRecipes selectedRecipes = new GroupOfRecipes();
        Scanner keyboard = new Scanner(System.in);
        FileProcessor recipes = new FileProcessor();


        GroupOfRecipes monday = new GroupOfRecipes();
        GroupOfRecipes tuesday = new GroupOfRecipes();
        GroupOfRecipes wednesday = new GroupOfRecipes();
        GroupOfRecipes thursday = new GroupOfRecipes();
        GroupOfRecipes friday = new GroupOfRecipes();
        GroupOfRecipes saturday = new GroupOfRecipes();
        GroupOfRecipes sunday = new GroupOfRecipes();

        theFrame = new JFrame("Dinner Planner");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setLocationRelativeTo(null);

        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkboxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);


        JButton calculateIngredients = new JButton("Calculate Ingredients");
        calculateIngredients.addActionListener(new SelectListener());

        JButton displayRecipe = new JButton("Display Recipe");
        displayRecipe.addActionListener(new DisplayListener());

        buttonBox.add(displayRecipe);
        buttonBox.add(Box.createRigidArea(new Dimension(5,10)));
        buttonBox.add(calculateIngredients);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        GridLayout grid = new GridLayout(30, 30);
        grid.setVgap(1);
        grid.setHgap(2);

        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        for (Recipe r : recipes.getRecipeList()) {

            JCheckBox c = new JCheckBox(r.getName());
            c.setSelected(false);
            c.setToolTipText(r.getDescription());

            checkboxList.add(c);
            mainPanel.add(c);
        }


        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);


        theFrame.setBounds(50, 50, 300, 300);
        theFrame.pack();
        theFrame.setVisible(true);


    }

    public class SelectListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            FileProcessor recipes = new FileProcessor();
            GroupOfRecipes selectedRecipes = new GroupOfRecipes();
            for (JCheckBox checkbox : checkboxList) {
                if (checkbox.isSelected()) {
                    for (Recipe r : recipes.getRecipeList()) {
                        if (checkbox.getText().equals(r.getName())) {
                            selectedRecipes.addRecipe(r);
                        }
                    }
                }
            }
            selectedRecipes.combineIngredients();

            JFrame frame2 = new JFrame("Total Ingredients");
            frame2.setLocationRelativeTo(theFrame);
            frame2.setSize(400,600);
            JTextArea text = new JTextArea(10,20);
            JScrollPane scroller = new JScrollPane(text);
            text.setLineWrap(true);
            frame2.add(scroller);

            text.setText("Total ingredients: " + "\n");
            for(Ingredient i: selectedRecipes.getTotalIngredients()){
                text.append(i.getAmmount() + " " + i.getMeasurement() + " " + i.getName() + "\n");
            }
            text.append("\n Total calories: \n");
            text.append(Integer.toString(selectedRecipes.getTotalCalories()) + "\n");
            frame2.setVisible(true);
        }
    }
    public class DisplayListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            FileProcessor recipes = new FileProcessor();
            GroupOfRecipes selectedRecipes = new GroupOfRecipes();
            for (JCheckBox checkbox : checkboxList) {
                if (checkbox.isSelected()) {
                    for (Recipe r : recipes.getRecipeList()) {
                        if (checkbox.getText().equals(r.getName())) {
                            selectedRecipes.addRecipe(r);
                        }
                    }
                }
            }
            selectedRecipes.combineIngredients();

            JFrame frame2 = new JFrame("Recipe Showcase");
            frame2.setLocationRelativeTo(theFrame);
            frame2.setSize(800,600);
            JTextArea text = new JTextArea(10,20);
            JScrollPane scroller = new JScrollPane(text);
            text.setLineWrap(true);
            frame2.add(scroller);
            text.setText("You have selected the following recipes: " + "\n" + "\n");
            for(Recipe r : selectedRecipes.getSelectedRecipes()){
                text.append("Name: " + r.getName() + "\n");
                text.append("Author: " + r.getAuthor() + "\n");
                text.append("Time to make: " + r.getTimeToMake() + r.getTimeUnits() + "\n");
                text.append("Description: " + "\n");
                text.append(r.getDescription() + "\n");
                text.append("Instructions: " + "\n" );
                for(String s : r.getListOfInstructions().getInstructions()){
                    text.append("\n" + s + "\n");
                }
                text.append("Calories: " + r.getCalories() + "\n" + "\n" + "\n");
            }


            text.append("\n Total calories: \n");
            text.append(Integer.toString(selectedRecipes.getTotalCalories()) + "\n");
            frame2.setVisible(true);
        }
    }
}
