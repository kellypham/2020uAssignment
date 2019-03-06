package ques02;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application{
	
	public void start(Stage stage){
		
		GridPane pane = new GridPane();
	    pane.setAlignment(Pos.CENTER);
	    pane.setHgap(5);
	    pane.setVgap(5);
	
		Label InAmountLabel = new Label("Investment Amount");
	    TextField InAmountTextField = new TextField();
	    
	    Label YearsLabel = new Label("Years");
	    TextField YearsTextField = new TextField();
	    
	    Label InRateLabel = new Label("Annual Interest Rate");
	    TextField InRateTextField = new TextField();
	    
	    Label FValueLabel = new Label("Future Value");
	    TextField FValueTextField = new TextField();  
	    
	    pane.add(InAmountLabel,0,0);
	    pane.add(InAmountTextField,1,0);
	    pane.add(YearsLabel,0,1);
	    pane.add(YearsTextField,1,1);
	    pane.add(InRateLabel,0,2);
	    pane.add(InRateTextField,1,2);
	    pane.add(FValueLabel,0,3);
	    pane.add(FValueTextField,1,3);	    
	    
	    //Add Button
        Button calButton = new Button("Calculate");
        pane.add(calButton, 1, 4);
		
	
		// Action handler
        calButton.setOnAction(e -> {
        	double inv = Double.parseDouble(InAmountTextField.getText());
			int yr = Integer.parseInt(YearsTextField.getText());
			double rt = Double.parseDouble(InRateTextField.getText());
			if(e.getSource() == calButton)
			{
				double res = inv * Math.pow((1 + rt/1200), (yr * 12));
				FValueTextField.setText(String.valueOf(res));
			}
        });
        
                
        Scene scene = new Scene(pane);
	    stage.setTitle("Question 2 Solution");
	    stage.setScene(scene);
	    
	    stage.show();
        
	}
	
	
	public static void main(String[] args) { launch(args); }

}