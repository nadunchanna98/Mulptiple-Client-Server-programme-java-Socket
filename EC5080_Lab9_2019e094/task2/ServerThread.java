import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {

    private final Socket socket;
    private final ArrayList<ServerThread> threadList;
    private PrintWriter output;

    public ServerThread(Socket socket, ArrayList<ServerThread> thread) {
        this.socket = socket;
        this.threadList = thread;
    }

    private void printTotalClients(String clientMessage) {
        for (ServerThread serverThread : threadList) {
            serverThread.output.println(clientMessage);
        }
    }

    public void run() {

        try {

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);


            output = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String outputString = input.readLine();
                if (outputString.equals("bye")) {
                    break;
                }
                printTotalClients(outputString);
                System.out.println("Server received : " + outputString);
            }
        } catch (Exception e) {
            System.out.println("Error occurred. Error :" + e.getStackTrace());
        }
    }


}
