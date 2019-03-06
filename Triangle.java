package ques03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//class that extends the application class
public class Triangle extends Application{
	
	Pane pane = new Pane();
	double width = 400;
	double height = 400;
	
	@Override
	public void start(Stage stage) {
		//create a new circle with desired parameters
		Circle circle = new Circle(width/2,height/2,100);
		pane.getChildren().add(circle);
		//set the properties to the circle
		circle.setFill(Color.TRANSPARENT);
		circle.setStroke(Color.BLACK);
		//create 3 points
		Circle[] circlePoints = new Circle[3];
		//create 3 lines
		Line[] line = new Line[3];
		//create new text areas for the angles
		Text[] texts = new Text[3];
		
		for (int i = 0; i < circlePoints.length; i++) {
			texts[i] = new Text();
			circlePoints[i] = new Circle(0,0,5);
			//call the method to set a random location to the point
			setARandomLocation(circlePoints[i],circle);
			final int index = i;
			//for use in lamba expression
			//create and register the handler
			circlePoints[i].setOnMouseDragged(e->{
				double radValue = Math.atan2(e.getY()-circle.getCenterY(), e.getX()-circle.getCenterX());
				double x = circle.getCenterX() + circle.getRadius() * Math.cos(radValue);
				double y = circle.getCenterY() + circle.getRadius() * Math.sin(radValue);
				circlePoints[index].setCenterX(x);
				circlePoints[index].setCenterY(y);
				updateTheLineLocation(line, circlePoints,texts);
			});
		}
		//iterate over the loop and add up the lines
		for (int i = 0; i < line.length; i++) {
			int circleIndex = (i + 1 >= circlePoints.length)?0:i+1;
			line[i] = new Line(circlePoints[i].getCenterX(),circlePoints[i].getCenterY(),
					circlePoints[circleIndex].getCenterX(),circlePoints[circleIndex].getCenterY());
		}
		
		//call the method to update the new location
		updateTheLineLocation(line,circlePoints,texts);
		pane.getChildren().addAll(line);
		pane.getChildren().addAll(texts);
		pane.getChildren().addAll(circlePoints);
		
		stage.setScene(new Scene(pane,width,height));
		stage.setTitle("Question 3 Solution");
		stage.show();
			
		}
		
	//method that updates the line location
	private void updateTheLineLocation(Line[] line, Circle[] p, Text[] angles) {
		for (int i = 0; i<line.length; i++) {
			int circleIndex = (i+1 >=p.length)?0:i+1;
			line[i].setStartX(p[i].getCenterX());
			line[i].setStartY(p[i].getCenterY());
			line[i].setEndX(p[circleIndex].getCenterX());
			line[i].setEndY(p[circleIndex].getCenterY());
			angles[i].setX(p[i].getCenterX()+5);
			angles[i].setY(p[i].getCenterY()-5);
		}

		//calculate the distance between points
		double a = distanceCalculator(line[0]);
		double b = distanceCalculator(line[1]);
		double c = distanceCalculator(line[2]);
		
		double A = Math.toDegrees(Math.acos((a*a-b*b-c*c)/(-2*b*c)));
		//display the data to the pane
		angles[2].setText(String.format("%.2f", A));
		double B = Math.toDegrees(Math.acos((b*b-a*a-c*c)/(-2*a*c)));
		//display the data to the pane
		angles[0].setText(String.format("%.2f", B));
		double C = Math.toDegrees(Math.acos((-a*a-b*b+c*c)/(-2*b*a)));
		//display the data to the pane
		angles[1].setText(String.format("%.2f", A));
	}
	
	//method that sets a A random location
	private void setARandomLocation(Circle cPoint, Circle c) {
		double angle = Math.random() * 360;
		double x = c.getCenterX() + c.getRadius() * Math.cos(Math.toRadians(angle));
		double y = c.getCenterY() + c.getRadius() * Math.cos(Math.toRadians(angle));
		cPoint.setCenterX(x);
		cPoint.setCenterY(y);
	}
	
	//method the calculates the distances of the lines
	private static double distanceCalculator(Line line) {
		double x1 = line.getStartX();
		double y1 = line.getStartY();
		double x2 = line.getEndX();
		double y2 = line.getEndY();
		
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}
	
	public static void main(String[] args) {launch(args);}
	
} 