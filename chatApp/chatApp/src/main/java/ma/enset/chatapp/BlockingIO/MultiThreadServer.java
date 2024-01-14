package ma.enset.chatapp.BlockingIO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MultiThreadServer extends Thread{
    static int counter;
    String name;
    List<Conversation> clients = new ArrayList<>();

    public static void main(String[] args) {
        new MultiThreadServer().start();
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            while(true){
                Socket socket = serverSocket.accept();
                counter++;
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);
                this.name = br.readLine();
                Conversation conversation = new Conversation(socket, counter, clients ,name);
                clients.add(conversation);
                conversation.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    class Conversation extends Thread{
        Socket socket;
        int clientId;
        String name;
        List<Conversation> conversations;
        public  Conversation( Socket socket, int id ,List<Conversation> clients,String name){
            this.socket = socket;
            this.clientId = id;
            this.conversations = clients;
            this.name= name;
        }
        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);
                OutputStream out = socket.getOutputStream();
                PrintWriter pr = new PrintWriter(out,true);
                String ip = socket.getRemoteSocketAddress().toString();
                System.out.println("New Client ==>"+clientId+" - "+name+" IP : "+ip);


                String req;

                while ((req = br.readLine())!=null){
                    System.out.println(req);
                    List<Integer> clientsId = new ArrayList<>();
                    String msg ="";
                    if(req.contains("=>")){

                        String[] items = req.split("=>");
                        String clients= items[0];
                        msg= items[1];

                        if(clients.contains(",")){
                            String[] idsList = clients.split(",");

                            for (String s : idsList){
                                clientsId.add(Integer.parseInt(s));
                            }
                        }else{
                            clientsId.add(Integer.parseInt(clients));
                        }
                    }else{
                        clientsId = conversations.stream().map(c->c.clientId).collect(Collectors.toList());
                        msg = req;
                    }
                    broadCastMessages(this,msg,clientsId);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private void broadCastMessages(Conversation from,String msg, List<Integer> clientsId){
            try {
                for(Conversation conversation : conversations){
                    OutputStream out = conversation.socket.getOutputStream();
                    PrintWriter pr = new PrintWriter(out,true);
                    if(conversation!=from && clientsId.contains(conversation.clientId)) {
                        pr.println(msg);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
