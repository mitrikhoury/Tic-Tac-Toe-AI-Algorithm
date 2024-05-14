package algooooprj2;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class advanceScene implements Initializable{

	LinkedList<Label> labelList = new LinkedList<>();
	char[][] bord = new char[3][3];
	 int row =-1;
	 int colum =-1;
//	advanceScene x122 = new advanceScene();
	 
	 @FXML
	    private TextArea TextArea1;

	    @FXML
	    private Button buttuntotextAre;
	    @FXML
	    private Label labelTextArea;
    @FXML
    private Label Ai;

    @FXML
    private Label AiScore;

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
    private Label currentround;

    @FXML
    private Label numberround;

    @FXML
    private Label playerName1;

    private String NamePlayer1;
    
    public void setName1(String x) {
    	this.NamePlayer1 =x;
    }
    private String whoFirst;
    
    public void whoStart(String x) {
    	this.whoFirst=x;
    }
    Character c1;
    Character c2;
    
    public void setC1(Character x) {
    	this.c1=x;
    }
    
    public void setC2(Character x) {
    	this.c2=x;
    }
    private int numberofmatches;
    public void setnumberofmatches(int x) {
    	this.numberofmatches=x;
    }
    
    private int Score1 =0;
	private int Score2 = 0;
	private int currentroundint =1;
    private Stage stage ;
	   
	   public Stage getStage() {
		return stage;
		   
	   }
	   
    
	   @FXML
	    void ShowTextAreabt(ActionEvent event) {
            TextArea1.setVisible(true);
            labelTextArea.setVisible(true);
	    }
	   
	   
	   @FXML
	    void closeTextArea(ActionEvent event) {
		   labelTextArea.setVisible(false);
		   TextArea1.setVisible(false);
	    }

	   @FXML
	    private Button close;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Parent root;
        try {
             stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InformationScene3.fxml"));
            root = loader.load();
            infoScene3 DPSceneController = loader.getController();
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
			playerName1.setText(NamePlayer1 + "    " + String.valueOf(c1));
			System.out.println(c2 + "!@@@@@@@@@@@@@@@@c2");
			Ai.setText("AI" +  "    "  + String.valueOf(c2));
			Player1Score.setText(String.valueOf(Score1));
			AiScore.setText(String.valueOf(Score2));
			currentround.setText(String.valueOf(currentroundint));
			numberround.setText(String.valueOf(numberofmatches));
			
			TextArea1.setVisible(false);
			labelTextArea.setVisible(false);
			
			for (int i = 0; i < bord.length; i++) {
				for (int j = 0; j < bord.length; j++) {
					bord[i][j]=' ';
				}
			}
			
			
	            if(whoFirst.equals("Ai")) {
				
	            	bord[0][0] =c2;
	            	Label x = labelList.get(0);
				    x.setText(String.valueOf(c2));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public void labelSetup(MouseEvent event) {
		Label labell = (Label) event.getSource();
		String id = labell.getId();
		//System.out.println("label id ******" + id);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(bord[i][j]  + " row"+ i);
		//	sbord[i][j]
			}
		}
		setcharecterForPlayer( labell);
		
		
	}
	
	public void setcharecterForPlayer(Label x) {  // set character for player (chose) the label
		// player1 turn
			
			if(currentroundint <= numberofmatches) {
				System.out.println("c1" + c1);
				String id = x.getId();
				System.out.println(id+"id");
				int i = Character.getNumericValue(id.charAt(0)) ;
				int j =    Character.getNumericValue(id.charAt(1))       ;
				System.out.println(i +"wWWW");
				System.out.println(j +"wWWW");
				//System.out.println(id+"iddddddd");
				//System.out.println(id.charAt(0) + "chartat0");
				//System.out.println(id.charAt(1) + "chartat1");
				bord[i][j] =c1;  // add character player in the bored
				x.setText(String.valueOf(c1));  // add character player in the fx
				game();
				if(checkWinner(bord) == 10) {
					setcharecterforAi(bord);
				}
				game();
			}else {
				 Alert alert = new Alert(AlertType.INFORMATION);
			        alert.setTitle("the match is over");
			        alert.setHeaderText(null); // You can set the header text if needed
			        if(Score1 > Score2) {
			        	alert.setContentText(" the winner " + NamePlayer1);
					}else if( Score1 == Score2) {
						alert.setContentText(" Draw ");
					}else {
						alert.setContentText(" the winner " + "Ai");
						
					}
	                alert.showAndWait();
			}
	}
	
	
	public void resttable() {
		for (Label label : labelList) {
		label.setText("");
	}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				bord[i][j]=' ';
			}
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
	
	public int checkWinner( char[][] bord) {
		// 1 Ai win
		// 0 tie
		// -1 human win
		// 10
		
		
		for (int i = 0; i < 3; i++) {
			String l=String.valueOf(bord[i][0])+String.valueOf(bord[i][1])+String.valueOf(bord[i][2]);
			if(l.equals("XXX") || l.equals("OOO") ) {
				if(bord[i][0] == c2) {
					return 1;
				}else if(bord[i][0] == c1){
					return -1;
				}
			}
		}
		
		for (int i = 0; i < 3; i++) {
			String l=String.valueOf(bord[0][i])+String.valueOf(bord[1][i])+String.valueOf(bord[2][i]);
			if(l.equals("XXX") || l.equals("OOO")) {
				if(bord[0][i] == c2) {
					return 1;
				}else if(bord[0][i] == c1){
					return -1;
				}
			}
		}
		
		String l=String.valueOf(bord[0][0])+String.valueOf(bord[1][1])+String.valueOf(bord[2][2]);
		if(l.equals("XXX") || l.equals("OOO")) {
			if(bord[0][0] == c2) {
				return 1;
			}else if(bord[0][0] == c1){
				return -1;
			}
		}
		
		String l1=String.valueOf(bord[0][2])+String.valueOf(bord[1][1])+String.valueOf(bord[2][0]);
		if(l1.equals("XXX") || l1.equals("OOO")) {
			if(bord[0][2] == c2) {
				return 1;
			}else if(bord[0][2] == c1){
				return -1;
			}
		}
		
		  // For Tie Case
	    boolean tie = true;
	    for(int i = 0; i < 3; i++) {
	        for(int j = 0; j < 3; j++) {
	            if(bord[i][j] == ' ') {
	                tie = false;
	            }
	        }   
	    }
	    if(tie) {
	    	return 0;
	    }
	    
	    return 10;

	}
	
	
	public void game() {
		///SetCharecterForAi();                    ////////////////////////
		if(currentroundint <= numberofmatches) {
		//	checkPlayerorAi();        ////////////////////
			int number =checkWinner(bord);
		if(number == 1) { //  Ai
		
				System.out.println("Ai" + " win the game");
				Score2++;
				AiScore.setText(String.valueOf(Score2));
				resttable();
				currentroundint++;
				currentround.setText(String.valueOf(currentroundint));
				Alert alert = new Alert(AlertType.INFORMATION);
			    alert.setTitle("Ai win the game");
			    alert.setHeaderText(null); 
				alert.setContentText(" the winner Ai" );
				TextArea1.clear();
			    alert.showAndWait();
			}
		
		if(number == -1) {
		
		// plaayer 1 win
			System.out.println(NamePlayer1 + " win the game");
			Score1++;
			Player1Score.setText(String.valueOf(Score1));
		//	playertern=true;  
			resttable();
			currentroundint++;
			currentround.setText(String.valueOf(currentroundint));
			Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle(NamePlayer1  +"win the game");
		    alert.setHeaderText(null); 
			alert.setContentText(" the winner " + NamePlayer1);
			TextArea1.clear();
		    alert.showAndWait();
		
		}
		if(number == 0) {
			System.out.println("Tie");

			currentroundint++;
			currentround.setText(String.valueOf(currentroundint));
			resttable();
			Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle("Draw");
		    alert.setHeaderText(null); 
			alert.setContentText("Draw" );
			TextArea1.clear();
		    alert.showAndWait();
		}
		if(number == 10) {
			System.out.println("the match stil runing");
		}
			
		}else {
			for(Label x : labelList) {
				x.setDisable(true);
			}
			 Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle("the match is over");
		        alert.setHeaderText(null); // You can set the header text if needed
		        if(Score1 > Score2) {
		        	alert.setContentText(" the winner " + NamePlayer1);
				}else if( Score1 == Score2) {
					alert.setContentText(" Draw ");
				}else {
					alert.setContentText(" the winner " + "Ai");
					
				}
             alert.showAndWait();
			System.out.println("the game finsh");
		}
	}
	  public boolean ismoveleft(char[][] bord) {
		   for (int i = 0; i < 3; i++) {
	           for (int j = 0; j < 3; j++) {
	               if (bord[i][j] == ' ') {
	                   return true;
	               }

	           }
	       }
	       return false;
	   }
	
	private int[] bestmoveforAi(char[][] board) {

	    int res = Integer.MIN_VALUE;
	    int row = -1;
        int colum = -1;
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (board[i][j] == ' ') { // Check if the cell is empty
	                board[i][j] = c2; // the ai put the character
	                int score = minimaxAlgo(board,false); // make false to maxai for the human turn
	                TextArea1.appendText("\n");
	                System.out.println("score :" + i + "," + j + ": "+  score);
	                TextArea1.appendText(" row , cloum " + i + ", " + j + ": "+ "Score: "+"( "+ score +" )" + (score == 1 ? "AI wins" : (score == -1 ? "Human wins" : "Draw")));
	                TextArea1.appendText("\n"); //append the scores to text area
	                
	                board[i][j] = ' '; // Undo the move

	                if (score > res) {  // get the 1 (Ai win)
	                    row = i;
	                    colum = j;
	                    res = score;
	                }
	            }
	        }
	    }

	    return new int[]{row, colum};   // return the best score
	}
	
 

	 private int minimaxAlgo(char[][] board, boolean MaxAi) {
	        int score = checkWinner(bord);
	        if(score== 1) {
	        	return score;
	        }
	        if(score== -1) {
	        	return score;
	        }
	        
	        if(!ismoveleft(board)) {
	        	return 0;
	        }

	        if (MaxAi) { // Ai the maximum
	            int maxScore = Integer.MIN_VALUE;
	            for (int i = 0; i < 3; i++) {
	                for (int j = 0; j < 3; j++) {
	                    if (board[i][j] == ' ') {
	                        board[i][j] = c2;   // the ai put his character
	                        int currentScore = minimaxAlgo(board , false); // Recessive with human turn
	                        maxScore = Math.max(maxScore, currentScore); // get the max
	                        board[i][j] = ' '; // Undo the move
	                    }
	                }
	            }
	            return maxScore;
	        } else {            // when human (minimum)
	            int minScore = Integer.MAX_VALUE;
	            for (int i = 0; i < 3; i++) {
	                for (int j = 0; j < 3; j++) {
	                    if (board[i][j] == ' ') {
	                        board[i][j] = c1;    // set character for human
	                        int currentScore = minimaxAlgo(board , true);  // Recessive with ai turn
	                        minScore = Math.min(minScore, currentScore);  // get the min score
	                        board[i][j] = ' '; // Undo the move
	                    }
	                }
	            }
	            return minScore;
	        }
	    }

	    public void setcharecterforAi(char[][] board) {
	        int[] result = bestmoveforAi(board);   // get the best score for ai after possibility
	        TextArea1.appendText("******************");
	        int row = result[0];
	        int col = result[1];
            String row2=String.valueOf(row);
            String col2 = String.valueOf(col);
            String k = row2+col2;
            System.out.println(k +"KKKK");
            
	        // Make the best move for AI
	        bord[row][col] = c2;             // set the character for ai in the board and the fx
	        for(Label fg : labelList) {
	        	if(fg.getId().equals(k)) {
	        		System.out.println(fg);
	        		fg.setText(String.valueOf(c2));
	        	}
	        }
         
	      
	    }
	

}
	 


    
 //algooooprj2.advanceScene AdvanceeScene