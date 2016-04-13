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
	JFrame frame=new JFrame("Garn");
	static Board board=new Board();
	Tank tank;

	static ActionListener timertask = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			
		}
	};
	static Timer timer=new Timer(50, timertask)	;
	
	public Tester(){
		terraingeneration();
		tank=new Tank(300,151, board, 1);
		
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
				board.board[x][y]=1;
			}
		}
	}
	
	public void refresh(){
		frame.remove(board);
		int[][] tempboard=new int[200][200];
		for (int x=0;x<600;x++)											//Copying the board over
			for (int y=0;y<250;y++)
				tempboard[x][y]=board.board[x][y];
		board=new Board();
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
			
		}else if (keyboard.getKeyCode()==39){

		}
		
	}

	public void keyReleased(KeyEvent keyboard) {

	}

	public static void main (String[]args){
		test =new Tester();
	}
}
