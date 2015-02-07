package froggerScrap;

import java.awt.Color;

import sedgewick.StdAudio;
import sedgewick.StdDraw;

import java.awt.event.KeyEvent;

import froggerScrap.ArcadeKeys;

//import static org.junit.Assert.*;

public class Frog implements Object2{
	
	public double length;
	public double width;
	
	public double posX;
	public double posY;
	
	public Color color;
	public double speed;
	
	public Frog(double posX, double posY, Color color){
		length = 0.02;
		width = 0.02;
		this.posX = posX;
		this.posY = posY;
		this.color = color;
		speed = 0.04;
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
		if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_UP)) {
			StdDraw.clear();
			StdDraw.filledRectangle(0.5, 0.5, 1.0, 1.0);
			StdDraw.picture(posX, posY, "images/(rr)greenFrogRest.png");
			posY += speed;
			StdAudio.play("sound/Frog Croak (One Click).wav");
			if (posY >= 1.0){posY = 1.0;}
		}
		else if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_DOWN)) {
			posY -= speed;
			StdAudio.play("sound/Frog Croak (One Click).wav");
			if (posY <= 0.0){posY = 0.0;}
		}
		else if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_RIGHT)) {
			posX += speed;
			StdAudio.play("sound/Frog Croak (One Click).wav");
			if (posX >= 1.0){posX = 1.0;}
		}

		else if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_LEFT)) {
			posX -= speed;
			StdAudio.play("sound/Frog Croak (One Click).wav");
			if (posX <= 0.0){posX = 0.0;}
		}
	}
	
	public void move2() {
		if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_UP)){
			StdDraw.clear();
			StdDraw.filledRectangle(0.5, 0.5, 1.0, 1.0);
			StdDraw.picture(posX, posY, "images/(rr)orangeFrogRest.png");
			posY += speed;
			StdAudio.play("sound/Frog Croak (One Click).wav");
			if (posY >= 1.0){posY = 1.0;}
		}
		else if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_DOWN)) {
			posY -= speed;
			StdAudio.play("sound/Frog Croak (One Click).wav");
			if (posY <= 0.0){posY = 0.0;}
		}
		else if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_RIGHT)) {
			posX += speed;
			StdAudio.play("sound/Frog Croak (One Click).wav");
			if (posX >= 1.0){posX = 1.0;}
		}

		else if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_LEFT)) {
			posX -= speed;
			StdAudio.play("sound/Frog Croak (One Click).wav");
			if (posX <= 0.0){posX = 0.0;}
		}
	}

	@Override
	public void draw() {
		StdDraw.picture(posX, posY, "images/(rr)greenFrogMove.png");
//		StdDraw.setPenColor(color);
//		StdDraw.filledRectangle(posX, posY, width, length);
	}
	
	public void draw2() {
		StdDraw.picture(posX, posY, "images/(rr)orangeFrogMove.png");
//		StdDraw.setPenColor(color);
//		StdDraw.filledRectangle(posX, posY, width, length);
	}
	
	public boolean collide(Object2 o){
		double a = this.getposX()+this.getWidth();
		double b = o.getposX()+o.getWidth();
		double c = this.getposX()-this.getWidth();
		double d = o.getposX()-o.getWidth();
		
		double e = this.getposY()+this.getWidth();
		double f = o.getposY()+o.getLength();
		double g = this.getposY()-this.getWidth();
		double h = o.getposY()-o.getLength();
		
		boolean m = (a>d) && (a<b); // right edge
		boolean n = (c>d) && (c<b); // left edge
		boolean x = (e>h) && (e<f); // top edge
		boolean y = (g>h) && (g<f); // bottom edge
		
		if ((m || n) && (x || y)){return true;}
		else {return false;}
	}
}
