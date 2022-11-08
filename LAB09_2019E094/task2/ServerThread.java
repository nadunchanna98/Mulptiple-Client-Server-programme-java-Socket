import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {

    private Socket socket;
    private ArrayList<ServerThread> ThreadList;
    private PrintWriter output;

    public ServerThread(Socket socket, ArrayList<ServerThread> ThreadList) {
        this.socket = socket;
        this.ThreadList = ThreadList;
    }

    private void printTotalClients(String clientMessage) {
        for (ServerThread serverThread : ThreadList) {
            serverThread.output.println(clientMessage);
        }
    }

    public void run() {

        try {

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            output = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String clientMessage = input.readLine();
                if (clientMessage.equals("bye")) {
                    break;
                }
                printTotalClients(clientMessage);
                System.out.println("Server received: " + clientMessage);
            }
        } catch (Exception e) {
            System.out.println("Error occured :" +e.getStackTrace());
        }
    }


}
