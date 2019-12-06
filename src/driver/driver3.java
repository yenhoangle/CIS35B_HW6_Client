package driver;

import adapter.BuildAuto;
import adapter.ConfigureAuto;
import adapter.UpdateAuto;
import exception.AutoException;
import util.FileIO;

public class driver3 {
    public static void main(String[] args) throws AutoException {
        try {
            boolean complete = false;
            //String file = "C:\\Users\\Arteh\\IdeaProjects\\CIS35B_HW3\\textfiles\\ffw.txt";
            String file = "C:\\Users\\Arteh\\IdeaProjects\\CIS35B_HW3\\textfiles\\fes.txt";
            //a different file for a new car
            String file2 = "C:\\Users\\Arteh\\IdeaProjects\\CIS35B_HW3\\textfiles\\ffrs.txt";
            BuildAuto a1 = new BuildAuto();
            BuildAuto a2 = new BuildAuto();
            UpdateAuto ua = new BuildAuto();
            ConfigureAuto ca = new BuildAuto();
            //String name1 = "Ford Focus Wagon ZTW 2012"; //name of first car
            String name1 = "Ford Electric Scooter XL 2020"; //name of the first car
            String name2 = "Ford Focus RS 2017"; //name of second car

            FileIO fileIO = new FileIO();
            //attempting to build the car
            System.out.println("Attempting to build the cars...");
            a1.buildAuto(file);
            a2.buildAuto(file2);
            System.out.println("Printing the first car after building...");
            a1.printAuto(name1);
            System.out.println("\nPrinting the second car after building...");
            a2.printAuto(name2);

            // update the Automobile's options
            System.out.println("\nUpdating car's option set name...");
            ua.updateOptionSetName(name2, "Color", "Colour");
            System.out.println("Updating the second car's option price...");
            ua.updateOptionPrice(name2,
                    "Transmission", "Manual", -800);
            System.out.println("\nPrinting the second car after updating...");
            a2.printAuto(name2);

            //choice operations
            System.out.println("\nTesting choice operations on the first car...");
            ca.selectChoices(name1);
            ca.printChoices(name1);
            float price = ca.calculatePrice(name1);
            System.out.println("\nTotal cost after selecting options is: " + price);
        } catch (AutoException ae) {

        }
    }
}
