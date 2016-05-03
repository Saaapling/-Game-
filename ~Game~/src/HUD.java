import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


public class HUD extends JPanel{
	
	Tank tank;
	
	public HUD(Tank newtank){
		this.setPreferredSize(new Dimension(1200,100));
	}
	
	public void paintComponent(Graphics g){
		
	}
	
}
