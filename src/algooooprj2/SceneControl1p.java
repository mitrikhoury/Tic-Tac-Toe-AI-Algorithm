package algooooprj2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

 


public class SceneControl1p implements Initializable {

    private InfoScene1 obj = null;

    private String pname1;
    
    private String pname2;
    
    private String whoStarttt;
    	
    private Character c1;
    private Character c2;
    
	
    private int numberofmatch;
    
   private Stage stage ;
   
   public Stage getStage() {
	return stage;
	   
   }

	public void setPname2(String pname2) {   // set the name
		this.pname2 = pname2;
	}
	
	public void setwhoStf(String whsf) {   /// who start from info
		 this.whoStarttt=whsf;
	}
	
	public void setnumbermatch(int num) {  //set the number of match
		this.numberofmatch=num; 
	}
	
	public void setchplayer1(Character x) { // get the character from info scene
		this.c1=x;
	}
	
	public void setchplayer2(Character x) {  // get the character from info scene
		this.c2=x;
	}

	LinkedList<Label> labelList = new LinkedList<>();

	Boolean playertern; // if true == player1 , else == player2

	@FXML
	private Label L1;

	@FXML
	private Label L2;

	@FXML
	private Label L3;

	@FXML
	private Label L4;

	@FXML
	private Label L5;

	@FXML
	private Label L6;

	@FXML
	private Label L7;

	@FXML
	private Label L8;

	@FXML
	private Label L9;

	@FXML
	private Pane Paneeee;

	@FXML
	private Label Player1Score;

	private int score1 =0;
	private int score2 =0;
	
	@FXML
	private Label Player2Score;

	@FXML
	private Label currentround;

	private int currentroundffff  = 1;
	
	@FXML
	private Label numberround;

	@FXML
	private Label playerName1;
	@FXML
	private Label PlayerName2;
	
	 
	
	public void setinfoscene(InfoScene1 obj) {
		   this.obj=obj;
		}
	
	
	public SceneControl1p geterscenep1() {
		return this;
	}
	
	public void tfn1(String x) {  // set player1 the name
	  
		 this.pname1=x;
	}

	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//"InformationScene1.fxml"
		Stage gg  = new Stage();
		
		Parent root;
        try {
             stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InformationScene1.fxml"));
            root = loader.load();
            InfoScene1 DPSceneController = loader.getController();
            DPSceneController.setercontroler(this);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		
		
		Collection<Label> labelCollection = Arrays.asList(L1, L2, L3, L4, L5, L6, L7, L8, L9);
		labelList.addAll(labelCollection);
		
		try {
			playerName1.setText(pname1 + "      " + String.valueOf(c1));
			PlayerName2.setText(pname2 + "      " + String.valueOf(c2));
			numberround.setText(String.valueOf(numberofmatch));
			currentround.setText(String.valueOf(currentroundffff));
			Player1Score.setText(String.valueOf(score1));
			Player2Score.setText(String.valueOf(score2));
			if (whoStarttt.equals("Player1")) {
				System.out.println("mitriiiiiii");
				playertern = true;
			} else {
				System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
				playertern = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		

	}
	private Stage stagegame ;
	
	public void setstage(Stage x) {
		this.stagegame=x;
	}
	
	
	private boolean isodd(int x) {
		if(x%2!=0) {
		return true;}
		else {
		return	false;
		}
		
	}

	public void labelSetup(MouseEvent event) {
         int m = numberofmatch/2;
         boolean f = isodd( numberofmatch);
         int d = m+1; 
		if(score1 == m &&  f==false) {
			Stage x = new Stage();
			VBox vb = new VBox(10);
			Label label = new Label(pname1+" you win do you want to complete the game ?"); 
			label.setTextFill(Color.BLACK);
			label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
			vb.getChildren().add(label);
			vb.setAlignment(Pos.CENTER);
			HBox hb = new HBox(20);
			Button yes = new Button("yes");
			Button no = new Button("No");
			hb.getChildren().addAll(yes,no);
			vb.getChildren().add(hb);
			hb.setAlignment(Pos.CENTER);
			yes.setOnAction(e ->{
				System.out.println("yayayayayayayay");
				x.close();
			});
			no.setOnAction(e ->{
				System.out.println("mitriiiiiiiiiiiiiiiiiiiiiiiiiii");
				System.exit(0);
			//	stagegame.close();
			});
			Scene c = new Scene(vb,300,200);
			x.setScene(c);
			x.show();
			System.out.println("hihihihih");
		}
		
		if(score1 == d && f==true) {
			Stage x = new Stage();
			VBox vb = new VBox(10);
			Label label = new Label(pname1+" you win do you want to complete the game ?"); 
			label.setTextFill(Color.BLACK);
			label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
			vb.getChildren().add(label);
			vb.setAlignment(Pos.CENTER);
			HBox hb = new HBox(20);
			Button yes = new Button("yes");
			Button no = new Button("No");
			hb.getChildren().addAll(yes,no);
			vb.getChildren().add(hb);
			hb.setAlignment(Pos.CENTER);
			yes.setOnAction(e ->{
				System.out.println("yayayayayayayay");
				x.close();
			});
			no.setOnAction(e ->{
				System.out.println("mitriiiiiiiiiiiiiiiiiiiiiiiiiii");
				System.exit(0);
			//	stagegame.close();
			});
			Scene c = new Scene(vb,300,200);
			x.setScene(c);
			x.show();
			System.out.println("hihihihih");
		}
		  
		
		if(currentroundffff <= numberofmatch) {
			Label labell = (Label) event.getSource();
			String id = labell.getId();
			System.out.println("label id ******" + id);
			setcharecter(labell);
			int numberrr = checkWinner();
			System.out.println("number #@#@#@#@   " + numberrr);
		if (numberrr == 1) {
			
			int howx = Howx();
			if(howx == 1) { // player 1 win 
				System.out.println(pname1 + " win the game");
				score1++;
				Player1Score.setText(String.valueOf(score1));
				playertern=true;
				resttable();
				currentroundffff++;
				currentround.setText(String.valueOf(currentroundffff));
			}else { // player 2 win
				System.out.println(pname2+ " win the game");
				++currentroundffff;
				currentround.setText(String.valueOf(currentroundffff));
				score2++;
			    Player2Score.setText(String.valueOf(score2));
				playertern=false;
				resttable();
			}
			
			
		}
		if (numberrr == -1) {
			int howO =howO();
			if(howO == 1) {  // player 1 win
				System.out.println(pname1 + " win the game");
				score1++;
				Player1Score.setText(String.valueOf(score1));
				playertern=true;
				resttable();
				currentroundffff++;
				currentround.setText(String.valueOf(currentroundffff));
			}else {  // player 2 win
				System.out.println(pname2+ " win the game");
				++currentroundffff;
				currentround.setText(String.valueOf(currentroundffff));
				score2++;
			    Player2Score.setText(String.valueOf(score2));
				playertern=false;
				resttable();
			}
			
		}
		if (numberrr == 0) {
			System.out.println("Tie");
			if(score1 >= score2) {
				playertern=true;
			}else {
				playertern=false;
			}
			++currentroundffff;
			currentround.setText(String.valueOf(currentroundffff));
			resttable();
		}
		if (numberrr == 10) {
			System.out.println("the match stil runing");
		}
		}else {
			System.out.println("the match finsch");
			 Alert alert = new Alert(AlertType.CONFIRMATION);
		        alert.setTitle("the match is over");
		        alert.setHeaderText(null); // You can set the header text if needed
		        if(score1 > score2) {
		        	alert.setContentText(" the winner " + pname1);
				}else if( score1 == score2) {
					alert.setContentText(" Draw ");
				}else {
					alert.setContentText(" the winner " + pname2);
					
				}
		        
		        alert.showAndWait();
		      
		}

		// System.out.println("number " + numberrr);
	}

	public void resttable() {
		for (Label label : labelList) {
		label.setText("");
	}
	}
	
	public void setcharecter(Label x) {
		if (playertern) { // player1 turn
			System.out.println("c1" + c1);
			x.setText(String.valueOf(c1));
			playertern = false; // change to player2
		} else { // player 2
			System.out.println("c2" + c2);
			x.setText(String.valueOf(c2));
			playertern = true; // change to player1
		}
	}

	boolean haveTheSameValueAndNotEmpty(String x, String y, String z) {
		if (x.equals(y) && x.equals(z) && !x.equals("")) {
			return true;
		}
		return false;
	}
	
	public int howO() {
		if(c1 == 'O') {
			return 1;
		}
		return 2;
	}
	
	public int Howx() {
		if(c1 == 'X') {
			return 1;
		}
		return 2;
	}
	

	public int checkWinner() {
		// 1 x win
		// 0 tie
		// -1 o win
		// 10
		int num = 0;

		Boolean tie = true;
		for (Label label : labelList) {
			if (label.getText().equals("")) {
				tie = false;
			}
		}

		if (tie) {
			num = 0;
		} else {
			num = 10; // mean the game not end
		}

		if (haveTheSameValueAndNotEmpty(L1.getText(), L2.getText(), L3.getText())) { // row1
			num = L1.getText().equals("X") ? 1 : -1;
		}
		if (haveTheSameValueAndNotEmpty(L4.getText(), L5.getText(), L6.getText())) { // row2
			num = L4.getText().equals("X") ? 1 : -1;
		}
		if (haveTheSameValueAndNotEmpty(L7.getText(), L8.getText(), L9.getText())) { // row3
			num = L7.getText().equals("X") ? 1 : -1;
		}
		if (haveTheSameValueAndNotEmpty(L1.getText(), L4.getText(), L7.getText())) { // col1
			num = L1.getText().equals("X") ? 1 : -1;
		}
		if (haveTheSameValueAndNotEmpty(L2.getText(), L5.getText(), L8.getText())) { // col2
			num = L2.getText().equals("X") ? 1 : -1;
		}
		if (haveTheSameValueAndNotEmpty(L3.getText(), L6.getText(), L9.getText())) { // col3
			num = L3.getText().equals("X") ? 1 : -1;
		}
		if (haveTheSameValueAndNotEmpty(L1.getText(), L5.getText(), L9.getText())) { // Delimiter 1
			num = L1.getText().equals("X") ? 1 : -1;
		}
		if (haveTheSameValueAndNotEmpty(L3.getText(), L5.getText(), L7.getText())) { // Delimiter 2
			num = L3.getText().equals("X") ? 1 : -1;
		}

		System.out.println(num);

		return num;
	}

}
