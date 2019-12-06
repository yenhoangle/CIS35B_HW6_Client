/*
 * Yen Le
 * 20123455
 *
 * SelectCarOptions.java
 * Class to configure the Automotive object received from the client using Automotive methods
 * */

package client;

import model.*;

import java.util.Scanner;

public class SelectCarOptions {

    ////////// PROPERTIES //////////
    private Scanner in = new Scanner(System.in);
    boolean DEBUG = true;

    ////////// CONSTRUCTORS //////////

    public SelectCarOptions() {

    }

    ////////// INSTANCE METHODS //////////

    public void configureAuto(Object obj) {
        Automotive auto;
        auto = (Automotive) obj;
        //added

        if (DEBUG) {
            System.out.println("Configuring Auto: " + auto.getName());
        }

        auto.selectChoices();
        float price = auto.getTotalPrice();
        System.out.println("Total price is: " + price);
        //added
        if (DEBUG) {
            System.out.println("Done Configuring Auto");
        }

    }

    public boolean isAutomotive(Object obj) {

        boolean isAutomotive = false;

        try {
            Automotive a1 = (Automotive) obj;
            isAutomotive = true;
        }
        catch (ClassCastException e) {
            isAutomotive = false;
        }
        return isAutomotive;
    }

}
