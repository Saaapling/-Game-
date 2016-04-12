import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class Tester implements KeyListener{

	static Tester test;
	JFrame frame=new JFrame("Gottem");
	static Board board=new Board();

	public Tester(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board.setPreferredSize(new Dimension(1200,500));
		frame.addKeyListener(this);

		frame.add(board);
		frame.pack();
		frame.setVisible(true);
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
		if (keyboard.getKeyCode()==39){
			
		}
		
	}

	public void keyReleased(KeyEvent keyboard) {

	}

	public static void main (String[]args){
		test =new Tester();
	}
}
