import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI.TreeIncrementAction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.util.ArrayList;

public class CPUTank extends Tank{

	public CPUTank(int xstart, int ystart, int identity){
		super(xstart, ystart, identity);
		orientation=2;
		barrelAngle=45;
	}
	
	public void AIcontrol(int xtarget, int ytarget, int frames){
		if (frames%1==0)
			aimbot(xtarget, ytarget);
	}
	
	public void aimbot(int xtarget, int ytarget){
		//To Make it Random;
		int x=Math.abs(xtarget-xpos);
		xtarget=xtarget-x/10+(int)(Math.random()*x/5+0.5);
		x=Math.abs(xtarget-xpos);
		int y=ypos-ytarget;		
		power=(int)(Math.sqrt((10*Math.pow(x, 2))/(x-y))+0.5);
		power=power*100/63;
		fire();
	}
	
}
