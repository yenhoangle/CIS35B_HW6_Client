package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Automotive implements Serializable {
    private static final long serialVersionUID = 1L; //to keep consistency in serialization / deserialization
    //separate variables to hold make and model, make + model = full name
    private String make;
    private String model;
    private String year;
    private float baseprice;
    private ArrayList<OptionSet> optionSets;
    private ArrayList<Option> choices; //choices is an array list of options chosen

    //constructors
    public Automotive() {
        this("", "", "",0);
    }

    public Automotive(float baseprice) {
        this("","", "", baseprice);
    }

    public Automotive(String make, String model, String year, float baseprice ) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.baseprice = baseprice;
        optionSets = new ArrayList<OptionSet>();
        choices = new ArrayList<Option>();
    }

    //getters
    public String getName() {
        return(make + " " + model + " " + year);
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public String getYear() {return year; }
    public float getBaseprice() {
        return baseprice;
    }

    public ArrayList<OptionSet> getOpsets() {
        return optionSets;
    }

    public ArrayList<Option> getChoices() {
        return choices;
    }

    public OptionSet getOpSet(int index) {
        return optionSets.get(index);
    }

    public String getOpSetName(int index) {
        return getOpSet(index).getName();
    }

        //get option chosen for a given option set
    public Option getOptionChoice(String opsetName) {
        int opsetIndex = findOpsetIndex(opsetName);
        return optionSets.get(opsetIndex).getOpChoice();
    }

    public String getChoiceName(String opsetName) {
        return getOptionChoice(opsetName).getName();
    }

    public float getChoicePrice(String opsetName) {
        return getOptionChoice(opsetName).getPrice();
    }

    //get opchoice, get opchoiceprice, set opchoice, get totalprice
    //setters
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) { this.year = year; }

    public void setBaseprice(float price) {
        this.baseprice = price;
    }

    public void setChoices(ArrayList<Option> choices) {
        this.choices = choices;
    }

    public int findOpsetIndex(String opsetName) {
        for (OptionSet opset : optionSets) {
            if (opset.getName().equals(opsetName)) {
                //use built in arraylist method to find index
                return optionSets.indexOf(opset);
            }
        }
        //not found
        return -1;
    }

    public OptionSet findOpset(String opsetName) {
        for (OptionSet opset : optionSets) {
            if (opset.getName().equals(opsetName)) {
                return opset;
            }
        }
        return null;
    }

    public Option findOption(String opsetName, String opName) {
        if (opsetName != null && opName != null) {
            OptionSet opset = findOpset(opsetName);
            return opset.findOption(opName);
        }
        return null;
    }

    //add methods
    public boolean addOpset(String name){
        if (name != null) {
            optionSets.add(new OptionSet(name));
            return true;
        }
        //do we have to do anything with choice here
        return false;
    }

    public boolean addOption(int opsetIndex, String opname, float opPrice) {
        if (opname != null && opname != null) {
            if (opsetIndex != -1) {
                return optionSets.get(opsetIndex).addOption(opname, opPrice);

            }
        }
        return false;
    }

    public void addOptionChoice(Option choice) {
        choices.add(choice);
    }

    //update methods
    public void updateOpsetName(String name, String newName) {
        if (name != null && newName != null) {
            OptionSet op = findOpset(name);
            if (op != null) {
                op.setName(newName);
            }
        }
    }

    public void updateOpset(String name, OptionSet newOpset) {
        if (name != null) {
            int opsetIndex = findOpsetIndex(name);
            if (opsetIndex != -1) {
                optionSets.set(opsetIndex, newOpset);
            }
        }
    }
    //update the entire option
    public void updateOp(String opsetName, String opname, String newOpname, float newPrice ) {
        if (opsetName != null && opname != null && newOpname!= null) {
            int opsetIndex = findOpsetIndex(opsetName);
            if (opsetIndex != -1) {
                optionSets.get(opsetIndex).updateOption(opname, newOpname, newPrice);
            }
        }
    }

    public void updateOpname (String opsetName, String opname, String newOpname) {
        if (opsetName != null && opname != null && newOpname!= null) {
            int opsetIndex = findOpsetIndex(opsetName);
            if (opsetIndex != -1) {
                optionSets.get(opsetIndex).updateOpName(opname, newOpname);
            }
        }
    }

    public void updateOpPrice (String opsetName, String opname, float newPrice) {
        if (opsetName != null && opname != null) {
            int opsetIndex = findOpsetIndex(opsetName);
            if (opsetIndex != -1) {
                optionSets.get(opsetIndex).updateOpPrice(opname, newPrice);
            }
        }
    }

    //delete methods
    public boolean deleteOpset(String name) {
        if (optionSets != null) {
            for(int i = 0; i < optionSets.size(); i++) {
                if (optionSets.get(i).getName().equals(name)) {
                    //use existing arraylist set method to set item to null
                    optionSets.set(i, null);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteOption(String opsetName, String opName) {
        if (optionSets != null) {
            for (int i = 0; i < optionSets.size(); i++) {
                if(optionSets.get(i).getName().equals(opsetName)) {
                    return optionSets.get(i).deleteOption(opName);
                }
            }
        }
        return false;
    }

    public void clearChoices() {
        this.choices.clear();
    }

    public void selectChoices() {
        Scanner scanner = new Scanner(System.in);
        //clear existing choices so user can pick again
        if (getChoices().size() > 0) {
            clearChoices();
        }
        for (int i = 0; i < getOpsets().size(); i++) {
            boolean done = false;
            while(!done) {
                String opsetName = getOpSetName(i);
                System.out.println("Please enter choice for " + opsetName +": ");
                String opNameChosen = scanner.nextLine().trim();
                //search optionset for option choice with name to check validity
                Option chosen = findOption(opsetName, opNameChosen);
                if (chosen != null) {
                    //put that choice in choices arraylist
                    addOptionChoice(chosen);
                    done = true;
                }
                else {
                    System.out.println("Invalid choice");
                }
            }
        }
    }

    public float getTotalPrice() {
        float total = this.getBaseprice();
        for(int i = 0; i < choices.size(); i++) {
            total += choices.get(i).getPrice();
        }
        return total;
    }



    //print method for the Automotive object
    public void print() {
        System.out.printf("%s\nBase Price: $%.2f\n", getName(), baseprice);
        if (optionSets != null) {
            for(OptionSet opset : optionSets) {
                opset.print();
            }
        }
    }

    public void printChoices() {
        System.out.printf("%s with selected options:\n", getName());
        if (choices != null) {
            for (Option op : choices) {
                op.print();
            }
        }
    }
}
