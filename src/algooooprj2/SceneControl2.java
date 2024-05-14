package algooooprj2;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class SceneControl2 implements Initializable{

	
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

	@FXML
	private Label Player2Score;
	private Character c2 ;
	@FXML
	private Label PlayerName2;

	@FXML
	private Label currentround;
	private int currentroundint =1;

	@FXML
	private Label numberround;

	@FXML
	private Label playerName1;

	private Stage stage ;
	   
	   public Stage getStage() {
		return stage;
		   
	   }
	
	
//	@FXML
//	void labelSetup(MouseEvent event) {
//
//	}
	
	private String name;
	
	public void setplayername(String name) {  //name
		this.name=name;
	}
	private Character c1 ;
	
	public void setcharplayer1(Character x) {  //char
		this.c1=x;
	}
	
	private String whoFirst;
	public void setFirst(String a) { // start
		this.whoFirst=a;
	}
	
	
	public void setAichar(Character x) {
		this.c2=x;
	}
	
	private int Score1 =0;
	private int Score2 = 0;

	private int gamerounds;
	
	public void setgamenumberRound(int num) {
		this.gamerounds=num;
	}
	boolean  flag =false;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		Parent root;
        try {
             stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InformationScene2.fxml"));
            root = loader.load();
            infoScene2 DPSceneController = loader.getController();
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
			playerName1.setText(name + "    " + String.valueOf(c1));
			System.out.println(c2 + "!@@@@@@@@@@@@@@@@c2");
			PlayerName2.setText("AI" +  "    "  + String.valueOf(c2));
			Player1Score.setText(String.valueOf(Score1));
			Player2Score.setText(String.valueOf(Score2));
			currentround.setText(String.valueOf(currentroundint));
			numberround.setText(String.valueOf(gamerounds));
			if(whoFirst.equals("Ai")) {
				
				SetCharecterForAi();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
			
	}
	
	
	public void setcharecterForPlayer(Label x) {  // set character for player (chose) the label
		// player1 turn
			
		
		
		
			if(currentroundint <= gamerounds) {
	
				
				///////////////////////////////
				System.out.println("c1" + c1);
				x.setText(String.valueOf(c1));
				if(checkWinner() == 10) {
				 SetCharecterForAi();
				}
			       game();
			}else {
				 Alert alert = new Alert(AlertType.INFORMATION);
			        alert.setTitle("the match is over");
			        alert.setHeaderText(null); // You can set the header text if needed
			        if(Score1 > Score2) {
			        	alert.setContentText(" the winner " + name);
					}else if( Score1 == Score2) {
						alert.setContentText(" Draw ");
					}else {
						alert.setContentText(" the winner " + "Ai");
						
					}
	                alert.showAndWait();
			}
	}
	
	
	public void SetCharecterForAi() {  // set character for ai
		Random random = new Random();  
	    int randomNumber = random.nextInt(9) + 1; // random number from 1 to 9
	    System.out.println("Random Number: " + randomNumber);
	    while(true) {
	    	Label x = labelList.get(randomNumber -1);
	    	  if( x.getText().equals("")) {
	            	x.setText(String.valueOf(c2));
	            	break;
	            }else {
	            	randomNumber = random.nextInt(9) + 1;
	            }
	    }
	  
	    
	}
	
	private boolean isodd(int x) {
		if(x%2!=0) {
		return true;}
		else {
		return	false;
		}
		
	}
	
	public void labelSetup(MouseEvent event) {
		Label labell = (Label) event.getSource();
		String id = labell.getId();
		System.out.println("label id ******" + id);
		///
		 boolean f = isodd( gamerounds);
		 int m = gamerounds/2;
		 int d = m+1;
		 System.out.println("mmmmmmmmmmm" + m);
		 System.out.println("hhhhhhhhh" + d);
			if(Score1 == m && flag == false && f==false) {
				Stage x32 = new Stage();
				VBox vb = new VBox(10);
				Label label = new Label(name+" you win do you want to complete the game ?"); 
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
					flag=true;
					x32.close();
				});
				no.setOnAction(e ->{
					System.out.println("mitriiiiiiiiiiiiiiiiiiiiiiiiiii");
                    Stage x = new Stage();
					Parent root;
					try {
						root = FXMLLoader.load(getClass().getResource("Main.fxml"));
						Scene s =new Scene(root);
						x.setScene(s);
						x.show();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				//	stagegame.close();
				});
				Scene c = new Scene(vb,300,200);
				x32.setScene(c);
				x32.show();
				System.out.println("hihihihih");
			}
		 if(Score1 == d && f==true && flag == false){
				Stage x32 = new Stage();
				VBox vb = new VBox(10);
				Label label = new Label(name+" you win do you want to complete the game ?"); 
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
					flag=true;
					x32.close();
				});
				no.setOnAction(e ->{
					System.out.println("mitriiiiiiiiiiiiiiiiiiiiiiiiiii");
					 Stage x = new Stage();
						Parent root;
						try {
							root = FXMLLoader.load(getClass().getResource("Main.fxml"));
							Scene s =new Scene(root);
							x.setScene(s);
							x.show();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				//	stagegame.close();
				});
				Scene c = new Scene(vb,300,200);
				x32.setScene(c);
				x32.show();
				System.out.println("hihihihih");
			}
			
			////
			
		setcharecterForPlayer( labell);
			
	}
	
	public void resttable() {
		for (Label label : labelList) {
		label.setText("");
	}
	}
	
	
	public void checkPlayerorAi() {        ////////////////////
		if(playertern == false) {
			
			SetCharecterForAi();
		}
	}
	
	
	
	public void game() {
		///SetCharecterForAi();                    ////////////////////////
		if(currentroundint <= gamerounds) {
		//	checkPlayerorAi();        ////////////////////
			int number =checkWinner();
		if(number == 1) { // x win
			int numberrr = howx();
			if(numberrr == 1) { // player 1 win 
				
				System.out.println(name + " win the game");
				Score1++;
				Player1Score.setText(String.valueOf(Score1));
			//	playertern=true;  
				resttable();
				currentroundint++;
				currentround.setText(String.valueOf(currentroundint));
				Alert alert = new Alert(AlertType.INFORMATION);
			    alert.setTitle(name  +"win the game");
			    alert.setHeaderText(null); 
				alert.setContentText(" the winner " + name);
			    alert.showAndWait();
			}else {  // ai win
				System.out.println(PlayerName2 + " win the game");
				Score2++;
				Player2Score.setText(String.valueOf(Score2));
			//	playertern=false;
				resttable();
				currentroundint++;
				currentround.setText(String.valueOf(currentroundint));
				Alert alert = new Alert(AlertType.INFORMATION);
			    alert.setTitle("Ai win the game");
			    alert.setHeaderText(null); 
				alert.setContentText(" the winner Ai" );
			    alert.showAndWait();
			}
		}
		if(number == -1) {
		int number12= 	howo();
		if(number12 == 1) { // plaayer 1 win
			System.out.println(name + " win the game");
			Score1++;
			Player1Score.setText(String.valueOf(Score1));
		//	playertern=true;  
			resttable();
			currentroundint++;
			currentround.setText(String.valueOf(currentroundint));
			Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle(name  +"win the game");
		    alert.setHeaderText(null); 
			alert.setContentText(" the winner " + name);
		}else {   // ai
			System.out.println(PlayerName2 + " win the game");
			Score2++;
			Player2Score.setText(String.valueOf(Score2));
		//	playertern=false;
			resttable();
			currentroundint++;
			currentround.setText(String.valueOf(currentroundint));
			Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle("Ai win the game");
		    alert.setHeaderText(null); 
			alert.setContentText(" the winner Ai" );
		    alert.showAndWait();
		}
		}
		if(number == 0) {
			System.out.println("Tie");
			Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle("Draw");
		    alert.setHeaderText(null); 
			alert.setContentText("Draw" );
		    alert.showAndWait();
			currentroundint++;
			currentround.setText(String.valueOf(currentroundint));
			resttable();
		}
		if(number == 10) {
			System.out.println("the match stil runing");
		}
			
		}else {
			for(Label x : labelList) {
				x.setDisable(true);
			}
			System.out.println("the game finsh");
			Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle("the game finsh");
		    alert.setHeaderText(null); 
			alert.setContentText("the game finsh" );
		    alert.showAndWait();
		}
	}
	
	public int howx() {
		if(c1 == 'X') {
			return 1;
		}
		return 2;
	}
	
	public int howo() {
		if(c1 == 'O') {
			return 1;
		}
		return 2;
	}
	
	boolean haveTheSameValueAndNotEmpty(String x, String y, String z) {
		if (x.equals(y) && x.equals(z) && !x.equals("")) {
			return true;
		}
		return false;
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
	
//	 Random random = new Random();
//
//     // Generate a random number between 1 and 9 (inclusive)
//     int randomNumber = random.nextInt(9) + 1;
//
//     // Print the random number
//     System.out.println("Random Number: " + randomNumber);
//	
	
	

}