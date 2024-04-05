import utilities.TableGenerator;

import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientTableHandler implements Runnable {

    private ObjectOutputStream outputStream;
    private Socket socket;
    private BufferedReader in;


    public ClientTableHandler (Socket socket) throws IOException {
        this.socket = socket;
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (true) {
                String request = in.readLine();
                System.out.println("客户端请求-->表格刷新服务器 >>> " + request);
                if (request == null) {
                    // 客户端断开连接
                    break;
                }
                switch (request) {
                    case "tableFlush":
                        handleResetTable();
                        break;
                    case null, default:
                        System.out.println(" 未知请求<---表格服务器 ");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
                System.out.println(">>>==== 表格socket close ====<<<");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    private void handleResetTable() throws IOException {
        String user_ID = in.readLine();
        DefaultTableModel defaultTableModel = (DefaultTableModel) TableGenerator.generateComingMeetingTable(user_ID);
        DefaultTableModel defaultTableModel1 = (DefaultTableModel) TableGenerator.generateMeetingInfoTable(user_ID);
        outputStream.writeObject(defaultTableModel);
        outputStream.writeObject(defaultTableModel1);
        outputStream.flush();
    }
}
