package ques04;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Histogram extends Application{
	
	@Override
	public void start(Stage stage) {
		//1. BorderPane
		//	1.1. HBox: Histogram
		//	1.2. GridPane: label, text field, button
		
		BorderPane pane = new BorderPane();
	    pane.setPadding(new Insets(10,10,10,10));
	    
	    GridPane gridP = new GridPane();
	    Label l = new Label("Filename");
	    TextField textfield = new TextField();
	    Button b = new Button("View");
	    gridP.add(l,0,0);
	    gridP.add(textfield,1,0);
	    gridP.add(b,2,0);
	    
	    pane.setBottom(gridP);

	    
	    char [] letters = new char [] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','0','P','R','S','T','U','V','W','X','Y','Z'};
	    
	    HBox hbox = new HBox();
	    pane.setCenter(hbox);
	    
	    Label [] labels = new Label[26];
	    Rectangle [] bar = new Rectangle[26];
	 
	        
	    b.setOnAction(e -> {
	    	int count[] = new int[26];
	    	String text = new String(textfield.getText());
	    	for(int i = 0; i<text.length();i++) {
	    		char character = text.charAt(i);
	    	
		    	if((character >= 'A')&&(character <= 'Z')) {
		    		//counting the letters
		    		count[character - 'A']++;
		    	} else if ((character >= 'a')&&(character <= 'z')) {
		    		//counting the letters
		    		count[character - 'a']++;
		    	}
		    	
		    	for(i=0; i<26; i++) {
		    		bar[i] = new Rectangle(12,count[i]);
		    		bar[i].setFill(Color.WHITE);
		    		bar[i].setStroke(Color.BLACK);
		    		hbox.getChildren().add(bar[i]);

		    		labels[i] = new Label(letters[i]+"",bar[i]);
		    		labels[i].setContentDisplay(ContentDisplay.TOP);
		    		hbox.getChildren().add(labels[i]);
		    		
		    	}
		    	
	    }});
		
		stage.setScene(new Scene(pane));
		stage.setTitle("Question 4 Solution");
		stage.show();
	}
	
		
	public static void main(String[] args) {launch(args);}
}

