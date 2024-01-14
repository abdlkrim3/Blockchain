package ma.enset.chatapp.NoBlockingIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SingleThreadServer {

    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.bind(new InetSocketAddress("localhost", 8090));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(true){
            int readyCount = selector.select();
            if(readyCount==0) continue;
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keys = selectionKeys.iterator();
            while (keys.hasNext()){
                SelectionKey selectionKey = keys.next();
                if(selectionKey.isAcceptable()) handelAccept(selector,selectionKey);
                if(selectionKey.isReadable()) randleReadWrite(selectionKey);
                keys.remove();
            }
        }
    }

    private static void randleReadWrite(SelectionKey selectionKey) {

    }

    private static void handelAccept(Selector selector, SelectionKey selectionKey) {
    }
}
