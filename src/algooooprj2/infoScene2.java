package algooooprj2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class infoScene2 implements Initializable{

	
	private SceneControl2 control2Setter;
	
    @FXML
    private ComboBox<Character> ComboPlayer1 = new ComboBox<>();

    @FXML
    private Button StartMatch = new Button();

    @FXML
    private TextField TfName1 = new TextField();

    @FXML
    private ComboBox<String> comboWhoStartFirst = new ComboBox<>();

    @FXML
    private TextField tfNumberMatches = new TextField();
   
    public void setercontroler(SceneControl2 gggg) {
		this.control2Setter= gggg;
	}
    
    
    @FXML
    void startevent(ActionEvent event) {
       
    	try {
    		control2Setter.setplayername(TfName1.getText());
        	control2Setter.setcharplayer1(ComboPlayer1.getValue());
        	control2Setter.setFirst(comboWhoStartFirst.getValue());
        	control2Setter.setgamenumberRound(Integer.valueOf(tfNumberMatches.getText()));  
        	if(ComboPlayer1.getValue() == 'X') {
        		System.out.println("mitriiiiiiiiiiiii");
        		control2Setter.setAichar('O');
        	}else {
        		System.out.println("@#@#@@#@#@#@@@@@@@@@@@@@@@@@@@@@@@@");
        		control2Setter.setAichar('X');
        	}
        	Stage x = control2Setter.getStage();
        	x.close();
		} catch (Exception e) {
			// TODO: handle exception
			 Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("erorr");
		        alert.setHeaderText(null); // You can set the header text if needed
		        alert.setContentText("invalid input");
             alert.showAndWait();
		}
    	
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ComboPlayer1.getItems().addAll('X' , 'O');
		comboWhoStartFirst.getItems().addAll("Player1" , "Ai");
	}

}