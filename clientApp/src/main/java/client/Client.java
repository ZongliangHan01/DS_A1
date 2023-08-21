package client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static Socket socket;
    public Client() {

//        Socket socket = null;
        try {
            // Create a stream socket bounded to any port and connect it to the
            // socket bound to localhost on port 4444
            Socket socket = new Socket("localhost", 4444);
            System.out.println("Connection established");
            this.socket = socket;
//            ConnectionMonitor monitor = new ConnectionMonitor(socket);
//            monitor.start();

        } catch (UnknownHostException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    public Socket getSocket() {
        return socket;
    }

    public static String sendRequest(String clientMsg) {
        // Get the input/output streams for reading/writing data from/to the socket

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));

//            Scanner scanner = new Scanner(System.in);
//            String inputStr = null;

            //While the user input differs from "exit"

            // Send the input string to the server by writing to the socket output stream
            out.write(clientMsg + "\n");
            out.flush();
            System.out.println("Message sent");

            // Receive the reply from the server by reading from the socket input stream
            String received = in.readLine(); // This method blocks until there  is something to read from the
            // input stream
            System.out.println("Message received: " + received);
            return received;
        }
        catch (UnsupportedEncodingException ex)
        {
            System.out.println("Error");
            return "Error: Cannot decode the content. Please enter another word.";
        }
        catch (IOException ex)
        {
            System.out.println("Error");
            return "Error: Bad Connection. Please refresh.";
//            throw new RuntimeException(ex);

        }
    }

}
