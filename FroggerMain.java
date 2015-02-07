package model;

//import lab10.ControlDemo;
/*
 * Grader: Doug Shook
 * Result: Your back story is hilarious! I love it. Your game was hard as hell though.
 * 			+20 for two players
 * 			+10 for increased difficulty
 * 			+20 for logs
 * 			-10 for missing javadoc
 * Total: 140 / 100
 */
public class FroggerMain {
	public static void main(String[] args) {
//		FroggerGame g = new ControlDemo();
		FroggerGame g = new Frogger();
		g.playGame();
		System.exit(0);
	}
}
