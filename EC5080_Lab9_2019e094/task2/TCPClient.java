//add libraries
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {


    public static void main(String[] args)  {

        try (Socket socket = new Socket("localhost", 8888);) {

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String userInput = "";
            String response = "";

            String clientName = "empty";
            ClientThread clientThread = new ClientThread(socket);
            clientThread.start();

            do{
                if(clientName.equals("empty")){
                    System.out.print("Enter your name : ");
                    userInput = scanner.nextLine();
                    clientName = userInput;
                    output.println(userInput);
                    if(userInput.equals("bye")){
                        break;
                    }
                }else{
                    String massage = (" ( "+clientName + ") : " );
                    System.out.print(massage);
                    userInput = scanner.nextLine();

                  output.println(massage + " " + userInput);
                    if(userInput.equals("bye")){
                        break;
                    }


                }

            }
            while(!userInput.equals("bye"));

        }catch(Exception e){
            // catch exceptions
            System.out.println("Exception occurred in client main: " + e.getStackTrace());
        }
    }
}
