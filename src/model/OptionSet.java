package model;

import java.io.Serializable;
import java.util.ArrayList;


public class OptionSet implements Serializable {
    private String name;
    private ArrayList<Option> options;
    private Option choice;

    //constructors
    protected OptionSet() {
        this("", 0);
    }

    protected OptionSet(String name) {
        this(name, 0);
    }

    protected OptionSet(String name, int size) {
        this.name = name;
        options = new ArrayList<Option>(size); {
            this.name = name;
            //populating the array list with new option objects
            for (int i = 0; i < options.size(); i++) {
                options.set(i, new Option());
            }
        }
    }

    //getters
    protected String getName() {
        return name;
    }

    protected Option getOption(int index) {
        if (index >= 0 && index < options.size()) {
            //use the arraylist's built in get method to get index of option
            return options.get(index);
        }
        //if not found return null
        return null;
    }

    protected ArrayList<Option> getOptions() {
        return options;
    }

    protected Option getOpChoice() {
        return choice;
    }

    //setters
    protected void setName(String name) {
        this.name = name;
    }

    protected void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    protected void setOpName(int index, String opName) {
        options.get(index).setName(opName);
    }

    protected void setOpPrice(int index, float price) {
        options.get(index).setPrice(price);
    }

    protected void setOpChoice(int opIndex) {
        if (opIndex >= 0 && opIndex < options.size()) {
            choice = options.get(opIndex);
        }
    }

    protected Option findOption(String opName) {
        for (Option option : options)  {
            if (option.getName().equals(opName)) {
                return option;
            }
        }
        return null;
    }

    protected int findOpIndex(String opName) {
        //uses built in arraylist method indexOf to return index
        return options.indexOf(opName);
    }

    protected boolean hasOption(String opName) {
        for (Option option : options) {
            if (option.getName().equals(opName)) {
                return true;
            }
        }
        return false;
    }

    //updaters
    protected boolean updateOpName(String opName, String newName) {
        int index = findOpIndex(opName);
        if (index != -1) {
            setOpName(index, newName);
            return true;
        }
        return false;
    }

    protected boolean updateOpPrice(String opName, float newPrice) {
        int index = findOpIndex(opName);
        if (index != -1) {
            setOpPrice(index, newPrice);
            return true;
        }
        return false;
    }

    //updates both name and price at the same time
    protected boolean updateOption(String opName, String newName, float newPrice) {
        int index = findOpIndex(opName);
        if (index != -1) {
            setOpName(index, newName);
            setOpPrice(index, newPrice);
            return true;
        }
        return false;
    }

    protected boolean addOption(String opName, float opPrice) {
        //uses the build in arraylist add method and return boolean
        return options.add(new Option(opName, opPrice));
    }

    protected boolean deleteOption(int index) {
        //uses built in ArrayList's remove method
        if (index < 0 || index >= options.size()) {
            return false;
        }
        options.remove(index);
        return true;
    }

    protected boolean deleteOption(String opname) {
        //null checks and index out of bound performed by findOp and the other deleteOption method
        int deleteIndex = findOpIndex(opname);
        return deleteOption(deleteIndex);
    }

    protected void print() {
        System.out.printf("Option Set Name: %s\n", name);
        for (Option op : options) {
            op.print();
        }
    }
}
