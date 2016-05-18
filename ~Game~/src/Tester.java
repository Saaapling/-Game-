import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.Timer;


public class Tester implements KeyListener{

	static Tester test;
	static JFrame frame=new JFrame("Ooooohhhdyr, ~Garn");
	static Board board=new Board();
	static HUD hud;
	static PlayerTank playertank;
	static CPUTank CPUtank;
	static Tank GODTank;
	static int frames=0;
	private static boolean cannonballFlying = false;

	static playertankHudPanel playertankHud;
	static CPUtankHudPanel CPUtankHud;

	static JPanel bothBoardAndHud = new JPanel();

	static ActionListener timertask = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			frames+=1;
			cannonballcontrol();
			tankmonitor();
			tankvariables();
			refresh();
		}
	};
	static int interval=10;
	static Timer timer=new Timer(interval, timertask);

	public static void cannonballcontrol(){
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
	}

	public static void tankmonitor(){
		playertank.falling();
		playertank.disposal();
		CPUtank.falling();
		CPUtank.control(playertank.xpos,playertank.ypos,frames);
		CPUtank.disposal();
	}

	public static void tankvariables(){
		if (frames%5==0){
			if (playertank.fuel<250)
				playertank.fuel+=1;
			if (CPUtank.fuel<250)
				CPUtank.fuel+=1;
		}
		if (playertank.shottimer>0)
			playertank.shottimer-=0.1;
		else
			playertank.shottimer=0;
		if (CPUtank.shottimer>0)
			CPUtank.shottimer-=0.1;
		else
			CPUtank.shottimer=0;
	}

	public Tester(){
		terraingeneration();
		playertank=new PlayerTank(149,550,10);
		//playertank=new PlayerTank(74,300,10);
		CPUtank=new CPUTank(149,50,11);
		GODTank=new Tank(1,1,100);
		
		playertankHud = new playertankHudPanel(hud, playertank);
		CPUtankHud = new CPUtankHudPanel(hud, CPUtank);
		hud=new HUD(playertank, playertankHud, CPUtankHud);

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
		for (int x=0;x<600;x++) //Copying the board over
			for (int y=0;y<250;y++)
				tempboard[y][x]=board.board[y][x];
		board=new Board();
		board.setPreferredSize(new Dimension(1200,500));
		board.board=tempboard;
		playertankHud.updateHud();
		CPUtankHud.updateHud();
		bothBoardAndHud.setLayout(new BoxLayout(bothBoardAndHud, BoxLayout.PAGE_AXIS));
		bothBoardAndHud.add(hud);
		bothBoardAndHud.add(board);

		frame.setContentPane(bothBoardAndHud);
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
		//.out.println("In keypressed: "+keyboard.getKeyCode());
		playertank.control(keyboard.getKeyCode());
	}

	public void keyReleased(KeyEvent keyboard){

	}

	public static void main (String[]args){
		test =new Tester();
	}
}
