import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.setProperty("javax.net.ssl.keyStore","adlane.store");
        System.setProperty("javax.net.ssl.keyStorePassword","kadri2016");
        ServerSocket serverSocket = ((SSLServerSocketFactory) SSLServerSocketFactory.getDefault()).createServerSocket(4444);
        System.out.println("server  up & ready for conenexion");
        while (true){
            new Esclave(serverSocket.accept()).start();
        }
    }
}
