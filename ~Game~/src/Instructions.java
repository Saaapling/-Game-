import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Instructions{
	static JFrame frame=new JFrame("Instructions");
	static Display2 panel=new Display2();

	public Instructions(){
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new GridLayout(0, 1));

		panel.setPreferredSize(new Dimension(800,800));
		panel.setBackground(Color.white);

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	public static void refresh(){
		frame.remove(panel);
		panel=new Display2();
		panel.setPreferredSize(new Dimension(800,800));
		frame.add(panel);
		frame.pack();
	}
	
	public static void run(){
		Instructions test=new Instructions();
	}

	public static void main(String[]args){
		Instructions test=new Instructions();
	}

}class Display2 extends JPanel{

		BufferedImage img;
	
	static ArrayList<BufferedImage> images=new ArrayList<BufferedImage>();

	public void paintComponent(Graphics g){	
		super.paintComponent(g);
		try {
			BufferedImage img =ImageIO.read(new File("Pictures//Instructions.PNG"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
		}catch (Exception e){}
	}
}