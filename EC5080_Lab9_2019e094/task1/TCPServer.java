//add libraries
import java.net.*;
import java.io.*;

//main class is TCP server
public class TCPServer {

 //main method with  try catch to throws Exception
    public static void main(String[] args) throws Exception {


        try{

            //created and object of ServerSocket
            ServerSocket server=new ServerSocket(8888);

            //acceptation of server - client authentication
            Socket serverClient=server.accept();

            //make get-input object
            DataInputStream inStream=new
                    DataInputStream(serverClient.getInputStream());

            //make send-input object
            DataOutputStream outStream=new
                    DataOutputStream(serverClient.getOutputStream());

            //make read files object using BufferedReader
             BufferedReader reader=new BufferedReader(new
                    InputStreamReader(System.in));

            String clientMessage="", serverMessage="";

            //check whether is there any client Message
            while(!clientMessage.equals("bye"))
            {
                //get client massage
                clientMessage=inStream.readUTF();

                //print client massage
                System.out.println("From Client: "+clientMessage);

                //read server massage
                serverMessage=reader.readLine();

                //send server massage
                outStream.writeUTF(serverMessage);

                //flush the massage
                outStream.flush();
            }

            //close all connections
            inStream.close();
            outStream.close();
            serverClient.close();
            server.close();

        }catch(Exception e){
            // catch exceptions
            System.out.println(e);
        }
    }
}
