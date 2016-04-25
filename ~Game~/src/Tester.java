
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

		tank=new Tank(49,300,10);
		cannonball = new Cannonball(originalX, originalY,1);

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
		//printgrid();
	}

	public static void printgrid(){
		for (int y=0;y<250;y++){
			for (int x=0;x<600;x++){
				System.out.print(board.board[y][x]);
			}
			System.out.println();
		}
	}

	public void keyTyped(KeyEvent keyboard) {

	}

	/*
	public void keyPressed(KeyEvent keyboard) {

		if (keyboard.getKeyCode()==37){
			tank.movement(2, board.board);
		}else if (keyboard.getKeyCode()==39){
			tank.movement(1, board.board);

		} else if (keyboard.getKeyCode()==32) {
			cannonballFlying = true;
		}

	}
	 */

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		int keyCode = e.getKeyCode();

		System.out.println("In keypressed: "+keyCode);

		switch( keyCode ) { 
		case KeyEvent.VK_LEFT:
			// handle left
			tank.movement(2, board.board);
			break;
		case KeyEvent.VK_RIGHT :
			tank.movement(1, board.board);
			break;
		case KeyEvent.VK_SPACE : 
			cannonballFlying = true;
			break;
		}
	}





	public void keyReleased(KeyEvent keyboard) {

	}

	public static void main (String[]args){
		test =new Tester();
	}
}