
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

	private static boolean cannonballFlying = false;

	private static int originalX = 100;
	private static int originalY = 200;


	static ActionListener timertask = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {

			if (cannonballFlying) {
				cannonballFlying = cannonball.movement(1, board.board, originalX, originalY);
			} else {
				cannonballFlying = false;
			}

			refresh();
			tank.falling();
		}
	};
	static Timer timer=new Timer(50, timertask)	;

	public Tester(){
		terraingeneration();

		tank=new Tank(149,100,10);
		cannonball = new Cannonball(originalX, originalY,board,1);

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
		//y=-.003(x-300)^2+75
		for (int x=0;x<600;x++){
			int yval=(int)(-.003*Math.pow(x-300, 2)+75);
			if (yval>0){
				for (int y=149;y>149-yval;y--){
					board.board[y][x]=2;
				}
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
			cannonballFlying = true;
		}

	}

	public void keyReleased(KeyEvent keyboard) {

	}

	public static void main (String[]args){
		test =new Tester();
	}
}