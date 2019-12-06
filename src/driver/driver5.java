/*
 * Yen Le
 * 20123455
 *
 * driver5.java
 * Driver class to test client implementation. Output of client-server interaction is located in output.txt
 * */

package driver;

import client.DefaultSocketClient;

public class driver5 {
     public static void main(String[] args) {
         String localHost = "127.0.0.1"; //host is located on same machine so we can use localHost for testing
         int portNum = 4444; //port number matches server's port number
         DefaultSocketClient client = new DefaultSocketClient(localHost, portNum);
         client.start();
     }
}
