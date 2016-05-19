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

	int movement=0;

	public CPUTank(int xstart, int ystart, int identity, String newname){
		super(xstart, ystart, identity, newname);
		orientation=2;
		barrelAngle=45;
	}

	public void control(int xtarget, int ytarget, int frames){
		aimbot(xtarget, ytarget);
		if(movement==0){
			if(xtarget<xpos)
				orientation=2;
			else
				orientation=1;
			if(fuel>50){
				if(power>99){
					movement=(int)(Math.random()*fuel);
				}else if(Math.random()<0.05){
					orientation=(int)(Math.random()*2+0.5);
					movement=(int)(Math.random()*fuel/2);
				}
			}
			if (weapon==3&&shottimer<1)
				fire();
			if (movement==0&&shottimer==0){
				weaponadjust((int)(1+Math.random()*8+0.5));
				fire();
			}
		}else{
			movement(orientation);
			movement-=1;
		}
	}

	private void aimbot(int xtarget, int ytarget){
		//To Make it Random;
		int x=Math.abs(xtarget-xpos);
		xtarget=xtarget-x/10+(int)(Math.random()*x/5+0.5);
		x=Math.abs(xtarget-xpos);
		int y=ypos-ytarget;		
		power=(int)(Math.sqrt((10*Math.pow(x, 2))/(x-y))+0.5);
		power=power*100/63;
		if (power>100)
			power=100;
	}

}
