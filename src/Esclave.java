import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Esclave extends Thread {
    Socket socket ;
    public Esclave(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("USER '"+bufferedReader.readLine()+"' is now connected to server ...");

            while (true){
                printWriter.println(bufferedReader.readLine()+ "");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
