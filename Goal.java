package model;

import java.awt.Color;

import sedgewick.StdDraw;
import model.ArcadeKeys;

import java.awt.event.KeyEvent;

public class Goal implements Object2 {
	public double length;
	public double width;
	
	public double posX;
	public double posY;
	
	public Color color;
	public double speed;
	
	public Goal(double posX){
		length = 0.055;
		width = 0.07;
		this.posX = posX;
		posY = 0.895;
		color = Color.GREEN;
		speed = 0;
	}
	
	@Override
	public double getposX() {
		return posX;
	}

	@Override
	public double getposY() {
		return posY;
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getLength() {
		return length;
	}
	
	@Override
	public void move() {
	}

	@Override
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledRectangle(posX, posY, width, length);
		StdDraw.picture(posX, posY, "images/rocket 1x.png");
	}
	
	public void stay(){
		StdDraw.setPenColor(color);
		StdDraw.filledRectangle(posX, posY, width, length);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledRectangle(posX, posY, 0.02, 0.02);
	}
}
