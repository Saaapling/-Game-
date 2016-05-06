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
		barrelAngle=60;
	}
	
	public void aimbot(int xtarget, int ytarget){
		int x=xtarget-xpos;
		power=(int)Math.sqrt((10*Math.pow(x, 2))/(ypos-ytarget+x));
	}
}
