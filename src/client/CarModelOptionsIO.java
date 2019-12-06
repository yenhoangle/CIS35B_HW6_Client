/*
 * Yen Le
 * 20123455
 *
 * CarModelOptionsIO.java
 * Class which handles loading of the content of a properties or text file to send to the server
 * */

package client;

import java.io.*;
import java.util.Properties;

public class CarModelOptionsIO {

    ////////// PROPERTIES //////////


    ////////// CONSTRUCTORS //////////

    public CarModelOptionsIO() {

    }

    ////////// INSTANCE METHODS //////////

    public Object loadPropsFile(String fname) {
        //String fpath = "C:\\Users\\Arteh\\IdeaProjects\\CIS35B_HW5_Client\\textfiles\\";
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(fname));
        }
        catch (FileNotFoundException e) {
            System.err.println("Error in file directory ... ");
            System.exit(1);
        }
        catch (IOException e) {
            System.err.println("Error reading file from directory ... ");
            System.exit(1);
        }

        return props;
    }

    public Object loadTextFile(String fname) {
        StringBuffer sbuff = new StringBuffer();
        try {
            BufferedReader buff = new BufferedReader(new FileReader(fname));
            boolean eof = false;
            int counter = 0;
            while (!eof) {
                String line = buff.readLine();
                if (line == null)
                    eof = true;
                else {
                    if (counter == 0)
                        sbuff.append(line);
                    else
                        sbuff.append("\n" + line);
                }
                counter++;
            }
            buff.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("Error in file directory ... ");
            System.exit(1);
        }
        catch (IOException e) {
            System.err.println("Error reading file from directory ... ");
            System.exit(1);
        }

        return sbuff;
    }

}
