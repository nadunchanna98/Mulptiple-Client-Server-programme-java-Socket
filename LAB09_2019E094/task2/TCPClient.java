//add libraries
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {

    //main method with  try catch to throws Exception
    public static void main(String[] args) throws Exception {

        try (Socket clientSocket = new Socket("localhost", 8888);) {

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String clientMessage = "";
            String serverMessage = "";
            String ClientName = "null";
            ClientThread clientThread = new ClientThread(clientSocket, ClientName);
            clientThread.start();

            do{
                if(ClientName.equals("null")){
                    System.out.println("Enter your name: ");
                    ClientName = scanner.nextLine();
                    ClientName = clientMessage;
                    output.println(clientMessage);
                    if(clientMessage.equals("bye")){
                        break;
                    }
                }else{
                    String massage = (ClientName + ": " + clientMessage);
                    System.out.println("Client: " + massage);
                    clientMessage = scanner.nextLine();
                    output.println(massage + " " + clientMessage);
                    if(clientMessage.equals("bye")){
                        break;
                    }


                }

            }
            while(!clientMessage.equals("bye"));

        }catch(Exception e){
            // catch exceptions
            System.out.println(e);
        }
    }
}
