import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected...");
                // 创建新线程处理客户端连接
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                //ClientTableHandler clientTableHandler = new ClientTableHandler(clientSocket);
                //Thread clientTableThread = new Thread(clientTableHandler);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
                //clientTableThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
