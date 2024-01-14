package ma.enset.chatapp.presentation.controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class chatController implements Initializable {
    public TextField userName_txt;
    public FontAwesomeIconView subscribe_btn;
    public HBox subscribe_field;
    public TextField chat_txt;
    public FontAwesomeIconView send_btn;
    public ListView<String> listView;

    ObservableList<String> messages = FXCollections.observableArrayList();
    Socket socket;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subscribe_btn.setOnMouseClicked((MouseEvent event) -> onSubscribe());
        send_btn.setOnMouseClicked((MouseEvent e)-> onChat());
        listView.setItems(messages);
        try {
            this.socket = new Socket("localhost", 23211);
            InputStream in = this.socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);




        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void onSubscribe(){
        try{
            OutputStream out = socket.getOutputStream();
            PrintWriter pr = new PrintWriter(out,true);
            String name = userName_txt.getText();
            pr.println(name);

            subscribe_field.setDisable(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void onChat(){
        try{
            OutputStream out = socket.getOutputStream();
            PrintWriter pr = new PrintWriter(out,true);

            String req = chat_txt.getText();
            pr.println(req);
            messages.add(req);
            chat_txt.clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
