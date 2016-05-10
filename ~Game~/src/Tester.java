
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
	static Tank playertank;
	static CPUTank CPUtank;
	static int frames=0;
	private static boolean cannonballFlying = false;


	static ActionListener timertask = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			frames+=1;
			for (Cannonball cannonball:Tester.playertank.cannonballs){
				if (cannonball.cannonballFlying)
					cannonball.movement();
			}
			for (Cannonball cannonball:Tester.CPUtank.cannonballs){
				if (cannonball.cannonballFlying)
					cannonball.movement();
			}
			if (frames%2==0)
				board.BakahutsuClear();
			playertank.falling();
			playertank.disposal();
			CPUtank.falling();
			CPUtank.AIcontrol(playertank.xpos,playertank.ypos,frames);
			CPUtank.disposal();
			if (frames%5==0){
				if (playertank.fuel<250)
					playertank.fuel+=1;
				if (CPUtank.fuel<250)
					CPUtank.fuel+=1;
			}
			refresh();
		}
	};
	static int interval=10;
	static Timer timer=new Timer(interval, timertask);

	public Tester(){
		terraingeneration();
		playertank=new PlayerTank(149,50,10);
		//playertank=new PlayerTank(74,300,10);
		CPUtank=new CPUTank(149,550,11);

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

	
	public void keyPressed(KeyEvent keyboard) {
		//System.out.println("In keypressed: "+keyboard.getKeyCode());
		if (keyboard.getKeyCode()==37){
			playertank.movement(2);
		}if (keyboard.getKeyCode()==39){
			playertank.movement(1);
		}if (keyboard.getKeyCode()==32) {
			playertank.fire();
		}if (keyboard.getKeyCode()==38) {
			playertank.barrelrotate(1);
		}if (keyboard.getKeyCode()==40) {
			playertank.barrelrotate(-1);
		}if (keyboard.getKeyCode()==81) {
			playertank.poweradjust(-1);
		}if (keyboard.getKeyCode()==69) {
			playertank.poweradjust(1);
		}
	}
	 
/*
	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();

		switch( keyCode ) { 
		case KeyEvent.VK_LEFT:
			tank.movement(2, board.board);
			break;
		case KeyEvent.VK_RIGHT :
			tank.movement(1, board.board);
			break;
		case KeyEvent.VK_SPACE : 
			cannonballFlying = true;
			break;
		case KeyEvent.VK_Q : 
			tank.barrelrotate(1);
			break;
		case KeyEvent.VK_E : 
			tank.barrelrotate(-1);
			break;
		}
	}
*/

	public void keyReleased(KeyEvent keyboard){

	}

	public static void main (String[]args){
		test =new Tester();
	}
}