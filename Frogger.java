/**
 * John Lu (johnlu), Guanyu Chen (guanyu)
 * Extra Credit: Stream (20pts), Multiplayer (20pts), ...
 * ... Title/GameOver Screen(10pts), Faster Cars (10pts)
 */

package model;

import java.awt.Color;

import sedgewick.StdAudio;
//import java.awt.event.KeyEvent;
//import java.util.LinkedList;
import sedgewick.StdDraw;
//import lab10.ArcadeKeys;
import model.FroggerGame;

public class Frogger implements FroggerGame {
	
	public int score;
	public int score2;
	public int lives;
	public int lives2;
	public boolean hasDied;
	public boolean hasDied2;
	public boolean hasMet;
	public boolean hasMet2;
	public boolean hasCollided;
	public boolean hasCollided2;

	public Frogger() {
	}

	@Override
	public void playGame() {
		Frog f = new Frog(0.4, 0.025, Color.CYAN);
		Frog f2 = new Frog(0.6, 0.025, Color.ORANGE);
		Goal [] goals = new Goal[5];
 
		Goal g1 = new Goal(0.1);
		Goal g2 = new Goal(0.3);
		Goal g3 = new Goal(0.5);
		Goal g4 = new Goal(0.7);
		Goal g5 = new Goal(0.9);
		
		goals [0] = g1;
		goals [1] = g2;
		goals [2] = g3;
		goals [3] = g4;
		goals [4] = g5;
		
		boolean [] met = new boolean[5];
		
		met[0] = false;
		met[1] = false;
		met[2] = false;
		met[3] = false;
		met[4] = false;
		
		int score = 0;
		int score2 = 0;
		int lives = 5;
		int lives2 = 5;
		double tlength = 0.5;
		double t2length = 0.5;
		
		boolean shot1 = false;
		boolean shot2 = false;
		int playTime = 0;
		while (lives>0 || lives2>0){
			StdDraw.clear();
			StdDraw.setPenColor();
			StdDraw.filledSquare(0.5, 0.5, 1);
			
			if(playTime==0){
				StdAudio.play("sound/Fix It Felix.wav");
			}
			
			if(playTime<200){//the file is 10 seconds long and loop updates every 50ms
				playTime++;	 //so the entire song will replay after playTime goes up to 200 = 10000/50
//				System.out.println(playTime);
				if(playTime==200){playTime=0;}
			}
			
			if(lives>0 && !shot2){f.move();} // the other player cannot move while missile is shot
			if(lives2>0 && !shot1){f2.move2();}
			
			hasDied = false;
			hasDied2 = false;
			hasCollided = false;
			hasCollided2 = false;
			
			hasMet= false;
			hasMet2 = false;
			boolean y = false;
			boolean z = false;
			for(int i=0; i<goals.length; i++){
				goals[i].draw();
				y = f.collide(goals[i]);
				z = f2.collide(goals[i]);
				if(y && !met[i]){ // there must be a collision and the goal must be empty
					hasMet = true;
					met[i] = true;
				}
				if(z && !met[i]){
					hasMet2 = true;
					met[i] = true;
				}
			}
			
			for(int i=0; i<met.length;i++){
				if(met[i]){
					goals[i].stay(); // changes the appearance of a goal after a collision
				}
			}
			if(lives>0){f.draw();} // if frog is alive, draw it
			if(lives2>0){f2.draw2();}
			

			if (hasDied || tlength<0.003){ // frog either runs out of time or runs into something to die
				f = new Frog(0.5, 0.025, Color.CYAN);
				tlength = 0.5;
				lives--;
			}
			
			if (hasDied2 || t2length<0.003){
				f2 = new Frog(0.7, 0.025, Color.ORANGE);
				t2length = 0.5;
				lives2--;
			}
			
			if(lives<0){lives = 0;} // keeps lives at zero, even if actually negative
			if(lives2<0){lives2 = 0;}
			if(score==300 || score2 ==300){lives=0; lives2=0;}
			StdDraw.setPenColor(Color.WHITE);
			StdDraw.text(0.09, 1.00, "Player 1 Lives: " + lives); // informs players of frog's status
			StdDraw.text(0.64, 1.00, "Player 2 Lives: " + lives2);
			StdDraw.text(0.1, 0.97, "Player 1 Score: " + score);
			StdDraw.text(0.65, 0.97, "Player 2 Score: " + score2);
			if(lives>0){
				StdDraw.setPenColor(Color.CYAN);
				StdDraw.filledRectangle(0.5, 0.005, tlength, 0.01); // time limit as a bar
				tlength-=0.001; // gradually decreases time
			}
			if(lives2>0){
				StdDraw.setPenColor(Color.ORANGE);
				StdDraw.filledRectangle(0.5, -0.025,t2length, 0.01);
				t2length-=0.001;
			}
			
			StdDraw.show(50);
			
			int count=0;
			for(int i=0; i<met.length;i++){
				if(met[i]){count++;}
			}
			if(count==5){ // if all five goals are filled, the game ends
				lives=0;
				lives2=0;
			}
		}
		StdDraw.clear();
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0.5, 0.5, "Game Over"); // final game over screen
		StdDraw.text(0.5, 0.95, "Player 1 Score: " + score);
		StdDraw.text(0.5, 0.85, "Player 2 Score: " + score2);
		StdDraw.show(50);
	}
	
	@Override
	public String getGameName() {
		return "Frogger";
	}

	@Override
	public String[] getTeamMembers() {
		String[] byline = { "John Lu", "Guanyu Chen" };
		return byline;
	}

	public static void main(String[] args) {
		Frogger f = new Frogger();
		f.playGame();
	}
}
