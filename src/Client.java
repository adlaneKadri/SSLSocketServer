import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.setProperty("javax.net.ssl.trustStore","adlane.store");
        Socket socket = ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket("localhost",4444);
        BufferedReader socketBufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader commonPromptBufferReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Entre your name");
        printWriter.println(commonPromptBufferReader.readLine());
        String message = null  ;
        while (true){
            System.out.println("message to send to the server : ");
            message = commonPromptBufferReader.readLine();
            if (message.equals("quit") || message.equals("exit")){
                printWriter.println("User is now disconnected");
                socket.close();
                break;
            }
            printWriter.println(message);
            System.out.println("replay from server : ");
            System.out.println(socketBufferReader.readLine());
        }
    }
}
