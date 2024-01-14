package ma.enset.chatapp.presentation.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewFactory {

    public void showChatApp() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ChatView.fxml"));
        createScene(fxmlLoader);
    }

    private void createScene(FXMLLoader loader){
            Scene scene= null;
            try{
                scene = new Scene(loader.load());
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }catch (Exception e){
                e.printStackTrace();
            }
    }


}
