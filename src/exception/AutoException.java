package exception;

import model.Automotive;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AutoException extends Exception{
    private int errno;
    private String errMessage;
    private Automotive auto;

    //messages for logging purposes
    private static String BAD_FILENAME = "Invalid Filename";
    private static String BAD_AUTO_MAKE = "Invalid Auto Make";
    private static String BAD_AUTO_MODEL = "Invalid Auto Model";
    private static String BAD_AUTO_YEAR = "Invalid Auto Year";
    private static String BAD_BASE = "Invalid Base Price";
    private static String BAD_OPSET_NAME = "Invalid Option Set Name";
    private static String BAD_OP_NAME = "Invalid Option Name";
    private static String UNEXPECTED_EXCEPTION = "Unexpected Exception";

    //constructors
    public AutoException() {
        super();
    }

    public AutoException(int errno) {
        super();
        this.errno = errno;
        switch(errno) {
            case 1:
                errMessage = BAD_FILENAME;
                break;
            case 2:
                errMessage = BAD_AUTO_MAKE;
                break;
            case 3:
                errMessage = BAD_BASE;
                break;
            case 4:
                errMessage = BAD_OPSET_NAME;
                break;
            case 5:
                errMessage = BAD_OP_NAME;
                break;
            case 6:
                errMessage = BAD_AUTO_MODEL;
                break;
            case 7:
                errMessage = BAD_AUTO_YEAR;
                break;
            default:
                errMessage = UNEXPECTED_EXCEPTION;
        }
    }

    //getters
    public int getErrNo() {
        return errno;
    }
    public String getErrMessage() {
        return errMessage;
    }

    //setters
    public void setErrNo(int errno) {
        this.errno = errno;
    }
    public void setErrMessage(String message) {
        errMessage = message;
    }
    public void setAuto(Automotive auto) {this.auto = auto; }

    //for fixing the file in order to build a proper Automotive, calls helper methods
    public void fix(int errno, Automotive car) {
        auto = car;
        FixExceptions fixer = new FixExceptions();
        log();
        switch(errno) {
            case 1:
                break;
            case 2:
                fixer.fix2(errno, car);
                break;
            case 3:
                fixer.fix3(errno, car);
                break;
            case 4:
                fixer.fix4(errno, car);
                break;
            case 5:
                fixer.fix5(errno, car);
                break;
            case 6:
                fixer.fix6(errno, car);
            case 7:
                fixer.fix7(errno, car);
            default:
                log();
        }
    }

    //logger method to write error to a file
    public void log() {
        String filename = "C:\\Users\\Arteh\\IdeaProjects\\CIS35B_HW3\\textfiles\\log.txt";
        try {
            //creates a timestamp
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String formattedTime = formatter.format(date);
            //sets file writer to append mode
            FileWriter fw = new FileWriter(filename, true);
            PrintWriter writer = new PrintWriter(fw);
            writer.printf("\n - Error occurred at [ %s ] Code %d: - %s\n", formattedTime, errno, errMessage);
            writer.close();
            fw.close();
        } catch(IOException e) {
            printStackTrace();
        }
    }
}
