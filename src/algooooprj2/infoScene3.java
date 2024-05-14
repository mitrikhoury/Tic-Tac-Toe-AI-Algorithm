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

public class infoScene3 implements Initializable{

	
	private advanceScene advanceControler;
	
    @FXML
    private ComboBox<Character> ComboPlayer1;

    @FXML
    private Button StartMatch;

    @FXML
    private TextField TfName1;

    @FXML
    private ComboBox<String> comboWhoStartFirst;

    @FXML
    private TextField tfNumberMatches;

    
    public void setercontroler(advanceScene gggg) {
		this.advanceControler= gggg;
	}
    
    @FXML
    void startevent(ActionEvent event) {
     
    	try {
    		advanceControler.setName1(TfName1.getText());
        	advanceControler.setC1(ComboPlayer1.getValue());
        	advanceControler.setnumberofmatches( Integer.valueOf( tfNumberMatches.getText()));
        	advanceControler.whoStart(comboWhoStartFirst.getValue());
        	if(ComboPlayer1.getValue() == 'X') {
        		System.out.println("mitriiiiiiiiiiiii");
        		advanceControler.setC2('O');
        	}else {
        		System.out.println("@#@#@@#@#@#@@@@@@@@@@@@@@@@@@@@@@@@");
        		advanceControler.setC2('X');
        	}
        	Stage x = advanceControler.getStage();
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
		ComboPlayer1.getItems().addAll('X' , 'O');
		comboWhoStartFirst.getItems().addAll("Player1" , "Ai");
	}

}

//algooooprj2.infoScene3
