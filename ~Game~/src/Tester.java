import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Tester implements KeyListener{

	static Tester test;
	static JFrame frame=new JFrame("Garn");
	static Board board=new Board();
	static Tank tank;
	static Cannonball cannonball;

	static ActionListener timertask = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			refresh();
		}
	};
	static Timer timer=new Timer(50, timertask)	;
	
	public Tester(){
		terraingeneration();

		tank=new Tank(149,300, board, 1);
		cannonball = new Cannonball(300,200,board,1);
		//tank=new Tank(300,149, board, 10);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board.setPreferredSize(new Dimension(1200,500));
		frame.addKeyListener(this);

		frame.add(board);
		frame.pack();
		frame.setVisible(true);
		
		timer.start();
	}

	public  void terraingeneration(){
		for (int x=0;x<600;x++){
			for (int y=150;y<250;y++){
				board.board[y][x]=1;
			}
		}
	}
	
	public static void refresh(){
		frame.remove(board);
		int[][] tempboard=new int[250][600];
		for (int x=0;x<600;x++)											//Copying the board over
			for (int y=0;y<250;y++)
				tempboard[y][x]=board.board[y][x];
		board=new Board();
		board.setPreferredSize(new Dimension(1200,500));
		board.board=tempboard;
		frame.add(board);
		frame.pack();
	}
	
	public void keyTyped(KeyEvent keyboard) {

	}

	public void keyPressed(KeyEvent keyboard) {
		/* -> 39
		 * <- 37
		 * down 40
		 * up 38
		 * space 32
		 */
		if (keyboard.getKeyCode()==37){
			tank.movement(2, board.board);
		}else if (keyboard.getKeyCode()==39){
			tank.movement(1, board.board);

		} else if (keyboard.getKeyCode()==32) {
			cannonball.movement(1, board.board);

		}
		
	}

	public void keyReleased(KeyEvent keyboard) {

	}

	public static void main (String[]args){
		test =new Tester();
	}
}
