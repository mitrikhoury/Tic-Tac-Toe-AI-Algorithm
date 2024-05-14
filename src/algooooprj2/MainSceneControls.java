package algooooprj2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainSceneControls {
    SceneControl1p cc ;
    @FXML
    private Button btAdvance;

    @FXML
    private Button btRandom;

    @FXML
    private Button vsBt;

    @FXML
    void AdvanceAction(ActionEvent event) {
    	Stage x1 = new Stage();
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("AdvanceeScene.fxml"));
			Scene s =new Scene(root);
			x1.setScene(s);
			x1.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void RandomAction(ActionEvent event) {
    	Stage x = new Stage();
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("RandomScene.fxml"));
			Scene s =new Scene(root);
			x.setScene(s);
			x.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

    @FXML
    void vsAction(ActionEvent event) {
      Stage x = new Stage();
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("playerScene.fxml"));
			Scene s =new Scene(root);
			x.setScene(s);
			x.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	
    }

}
//algooooprj2.MainSceneControls