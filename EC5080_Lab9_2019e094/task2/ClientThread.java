import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread {

    private final BufferedReader input;


    public ClientThread(Socket s) throws  IOException {
        this.input = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    public void run() {
        try {
            while (true) {
                String response = input.readLine();
                System.out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                input.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
