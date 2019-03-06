package ques01;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.util.Random;

public class DisplayCard3 extends Application {
	
	public void start(Stage stage){
		
		GridPane pane = new GridPane();
	    pane.setAlignment(Pos.CENTER);
	    pane.setHgap(5);
	    pane.setVgap(5);
	    
		Random rand = new Random();
		
		int img_no1 = rand.nextInt(54) + 1;
		ImageView imageView1 = new ImageView(new Image("file:img/"+img_no1+".png"));
		Label label1 = new Label("Image : "+img_no1);
		  
		int img_no2 = rand.nextInt(54) + 1;
		ImageView imageView2 = new ImageView(new Image("file:img/"+img_no2+".png"));
		Label label2 = new Label("Image : "+img_no2);
		  
		int img_no3 = rand.nextInt(54) + 1;
		ImageView imageView3 = new ImageView(new Image("file:img/"+img_no3+".png"));
		Label label3 = new Label("Image : "+img_no3);
		
		
		pane.add(label1,0,0);
		pane.add(imageView1,0,1);
		
		pane.add(label2,1,0);
		pane.add(imageView2,1,1);
		
		pane.add(label3,2,0);
		pane.add(imageView3,2,1);		
		
		Scene scene = new Scene(pane);
	    stage.setTitle("Question 1 Solution");
	    stage.setScene(scene);
	    
	    stage.show();

	}
		
	public static void main(String[] args) { launch(args); }
}