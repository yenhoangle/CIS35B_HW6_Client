package exception;

import model.Automotive;

import java.util.Scanner;

public class FixExceptions {
    String fileFolder = "/textfiles/";
    //constructor
    public FixExceptions() {
    }

    //fix for invalid auto make - error num: 2
    public void fix2(int errno, Automotive auto) {
        boolean valid = false;
        while(!valid) {
            System.out.println("Please enter the Automotive make: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }
            valid = true;
            //autoname = input;
            auto.setMake(input);
        }
    }
    //fix for invalid base price - error num: 3
    public void fix3(int errno, Automotive auto ) {
        boolean valid = false;
        while(!valid) {
            System.out.println("Please enter a valid base price for the Automotive: ");
            Scanner scanner = new Scanner(System.in);
            //conversion to check for negative value
            Float price = scanner.nextFloat();
            //base price cannot be negative
            if (price < 0) {
                continue;
            }
            valid = true;
            auto.setBaseprice(price);
        }
    }

    //fix for invalid option set name - error num: 4
    public void fix4(int errno, Automotive car) {
        boolean valid = false;
        while(!valid) {
            System.out.println("Please enter valid option set name: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            if (input.isEmpty() || input.equals("")) {
                continue;
            }
            valid = true;
            car.updateOpsetName("", input);
        }
    }

    //fix for invalid option name - error num: 5
    public void fix5(int errno, Automotive car) {
        boolean valid = false;
        while (!valid) {
            System.out.println("Invalid option name.");
            System.out.println("Please check the file and enter the option set name:");
            Scanner scanner = new Scanner(System.in);
            String optionset = scanner.nextLine().trim();
            if (optionset.isEmpty()) {
                continue;
            }
            System.out.println("Please enter the missing option name: ");
            String option = scanner.nextLine().trim();
            car.updateOpname(optionset,"", option);
            valid = true;
        }
    }

    //fix for invalid auto model - error num: 6
    public void fix6(int errno, Automotive auto) {
        boolean valid = false;
        while(!valid) {
            System.out.println("Please enter the Automotive model: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }
            valid = true;
            auto.setModel(input);
        }
    }

    //fix for invalid auto year - error num: 7
    public void fix7(int errno, Automotive auto) {
        boolean valid = false;
        while(!valid) {
            System.out.println("Please enter the Automotive year: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }
            valid = true;
            auto.setYear(input);
        }
    }
}
