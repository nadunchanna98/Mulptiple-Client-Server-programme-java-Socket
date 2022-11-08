//add libraries
import java.net.*;
import java.util.ArrayList;

public class TCPServer {

    public static void main(String[] args)  {

     ArrayList<ServerThread> ThreadList = new ArrayList<>();


        try(ServerSocket serverSocket = new ServerSocket(8888)){


            while (true){

                Socket socket=serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket, ThreadList);
                ThreadList.add(serverThread);
                serverThread.start();
            }

        }catch(Exception e){
            // catch exceptions
            System.out.println("Error occured : "+ e.getStackTrace());
        }
    }
}
