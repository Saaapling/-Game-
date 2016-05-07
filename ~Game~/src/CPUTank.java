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
	
	public void aimbot(int xtarget, int ytarget){
		//To Make it Random;
		int x=Math.abs(xtarget-xpos);
		xtarget=xtarget-x/10+(int)(Math.random()*x/5+0.5);
		x=Math.abs(xtarget-xpos);
		int y=ypos-ytarget;
//		System.out.println(xtarget);
//		System.out.println(ytarget);
//		System.out.println(xpos);
//		System.out.println(ypos);
		//System.out.println(x);
		//System.out.println(y);
		
		power=(int)(Math.sqrt((10*Math.pow(x, 2))/(x-y))+0.5);
		//System.out.println(power);
		power=power*100/63;
		//System.out.println(power*Math.sqrt(2)/10);
		//System.out.println(10*Math.pow(x, 2));
		//System.out.println((y+x));
		fire();
	}
}
