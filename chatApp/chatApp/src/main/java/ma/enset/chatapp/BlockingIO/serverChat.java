package ma.enset.chatapp.BlockingIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serverChat{

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(23211);
        Socket socket = serverSocket.accept();

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        int nb = in.read();

        out.write(nb*2);

        socket.close();
    }

}
