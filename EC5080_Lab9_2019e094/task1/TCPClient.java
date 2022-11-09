//add libraries
import java.io.*;
import java.net.*;

public class TCPClient {

    //main method with  try catch to throws Exception
    public static void main(String[] args) throws Exception {

        try{

            //create new socket and give the port number and host IP address
            Socket socket=new Socket("127.0.0.1",8888);

            //make get-input object
            DataInputStream inStream=new DataInputStream(socket.getInputStream());

            //make send-input object
            DataOutputStream outStream=new
                    DataOutputStream(socket.getOutputStream());

            //make write file  object using BufferedReader
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            String clientMessage="",serverMessage="";

            //check whether is there any client Message
            while(!clientMessage.equals("bye"))
            {
                clientMessage=br.readLine();

                //send client massage
                outStream.writeUTF(clientMessage);
                outStream.flush();

                //print the server massage
                serverMessage=inStream.readUTF();
                System.out.println("From Server: "+serverMessage);
            }

            //close all connections
            outStream.close();
            outStream.close();
            socket.close();


        }catch(Exception e){
            // catch exceptions
            System.out.println(e);
        }
    }
}
