/*
 * Yen Le
 * 20123455
 *
 * Driver4.java
 * Driver class to test multithreading
 * File used is ffw.txt to create a Ford Focus Wagon ZTW 2012 to test out concurrent editing operations.
 * Output of the 4 tests ran are found in textfiles/output.txt
 * */

package driver;

import adapter.BuildAuto;
import exception.AutoException;
import scale.EditThread;

public class driver4 {
    public static void main(String[] args) throws AutoException{
        try {
            String file = "C:\\Users\\Arteh\\IdeaProjects\\CIS35B_HW4\\textfiles\\ffw.txt";
            String autoName = "Ford Focus Wagon ZTW 2012";
            BuildAuto auto = new BuildAuto();
            auto.buildAuto(file);
            System.out.println("Printing Auto after building...");
            auto.printAuto(autoName);
            EditThread sa1 = new BuildAuto();
            System.out.println("Started Thread 1...");
            EditThread sa2 = new BuildAuto();
            System.out.println("Started Thread 2...");
            sa1.updateOptionSetName(1, autoName, "Color", "Colour");
            System.out.println("Editing Option Set name in thread 1...");
            sa2.updateOptionSetName(2, autoName, "Color", "Shade");
            System.out.println("Editing Option Set name in thread 2...");
            System.out.println("Printing Auto after editing...");
            auto.printAuto(autoName);
        } catch (AutoException ae) {

        }
    }
}
