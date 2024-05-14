package algooooprj2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class InfoScene1  implements Initializable{

    // public	 InfoScene1 obj = this;
	
	private SceneControl1p controlSetter;
	
	  @FXML
	   private Button StartMatch= new Button();

    @FXML
    private ComboBox<Character> ComboPlayer1 = new ComboBox<>();

    @FXML
    private TextField TFName1 = new TextField();

    @FXML
    private TextField TfName2 = new TextField();

    @FXML
    private ComboBox<Character> comboPlayer2 = new ComboBox<>();

    @FXML
    private ComboBox<String> comboWhoStartFirst = new ComboBox<>();

    @FXML
    private TextField tfNumberMatches = new TextField();

    public Character getComboPlayer1data() {
		return ComboPlayer1.getValue();
	}

	public String getTFName1value() {
		return TFName1.getText();
	}


	public String getTfName2() {
		return TfName2.getText();
	}



	public Character getComboPlayer2value() {
		return comboPlayer2.getValue();
	}

	public String getComboWhoStartFirstValue() {
		return comboWhoStartFirst.getValue();
	}




	public String getTfNumberMatchesValue() {
		return tfNumberMatches.getText();
	}


	public void setTfNumberMatches(TextField tfNumberMatches) {
		this.tfNumberMatches = tfNumberMatches;
	}
   //"playerScene.fxml"

	public void setercontroler(SceneControl1p gggg) {
		this.controlSetter=gggg;
	}
	
	@FXML
    void startevent(ActionEvent event) {
    	
		try {
			controlSetter.tfn1(TFName1.getText());
			controlSetter.setPname2(TfName2.getText());
			controlSetter.setnumbermatch( Integer.valueOf(tfNumberMatches.getText()) ); // number of match delivered  to controls scene
			controlSetter.setwhoStf(comboWhoStartFirst.getValue()); // 
			controlSetter.setchplayer1(ComboPlayer1.getValue());  
			controlSetter.setchplayer2(comboPlayer2.getValue());  //
			Stage x = controlSetter.getStage();
			x.close();
		} catch (Exception e) {
			 Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("the match is over");
		        alert.setHeaderText(null); // You can set the header text if needed
		        alert.setContentText("invalid input");
                alert.showAndWait();
      
		}
		
		
		
    }

    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ComboPlayer1.getItems().addAll('X','O');
		comboPlayer2.getItems().addAll('X','O');
		comboWhoStartFirst.getItems().addAll("Player1" , "Player2");
	}

}