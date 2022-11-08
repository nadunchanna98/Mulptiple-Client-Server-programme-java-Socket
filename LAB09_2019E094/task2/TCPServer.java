//add libraries
import java.net.*;
import java.io.*;
import java.util.ArrayList;

//main class is TCP server
public class TCPServer {

 //main method with  try catch to throws Exception
    public static void main(String[] args) throws Exception {

     ArrayList<ServerThread> ThreadList = new ArrayList<ServerThread>();

        try(ServerSocket serverSocket = new ServerSocket(8888);){

            while(true){
                Socket socket=serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket, ThreadList);
                ThreadList.add(serverThread);
                serverThread.start();
            }


        }catch(Exception e){
            // catch exceptions
            System.out.println(e.getStackTrace());
        }
    }
}
