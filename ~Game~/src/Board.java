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


public class Board extends JPanel{

	public int[][] board = new int[250][600];  //0-Empty, 1 terrain, 2 shot values, 10+ players

	public Board(){
		super();
		for (int x=0;x<600;x++){
			for (int y=0;y<250;y++){
				board[y][x]=0;
			}
		}
	}

	public void drawtank(Tank tank, Graphics g){
		g.drawLine(tank.xpos*2, tank.ypos*2, tank.xpos*2+10, tank.ypos*2);
		g.drawLine(tank.xpos*2, tank.ypos*2-1, tank.xpos*2+10, tank.ypos*2-1);
		g.drawLine(tank.xpos*2+1, tank.ypos*2-2, tank.xpos*2+10, tank.ypos*2-2);
		g.drawLine(tank.xpos*2+1, tank.ypos*2-3, tank.xpos*2+9, tank.ypos*2-3);
		g.drawLine(tank.xpos*2+2, tank.ypos*2-4, tank.xpos*2+8, tank.ypos*2-4);
		g.drawLine(tank.xpos*2+3, tank.ypos*2-5, tank.xpos*2+15, tank.ypos*2-5);
		g.drawLine(tank.xpos*2+3, tank.ypos*2-6, tank.xpos*2+15, tank.ypos*2-6);
	}

	public void drawCannonball(Cannonball cannonball, Graphics g) {
		g.fillOval(cannonball.xpos,500-cannonball.ypos, 10, 10);
		//g.fillArc(300,100,30,30,60,60);
	}

	public void paintComponent(Graphics g){
		for (int x=0;x<600;x++){
			for (int y=0;y<250;y++){
				if (board[y][x]==1){
					g.setColor(Color.GREEN);
				}else if(board[y][x]==2){
					g.setColor(Color.GRAY);
				}else if(board[y][x]>=10){
					g.setColor(Color.BLUE);
				}else{
					g.setColor(new Color(0,240,240));
				}
				g.drawRect(x*2, y*2, 1, 1);
			}
		}

		g.setColor(Color.black);
		drawtank(Tester.tank, g);
		drawCannonball(Tester.cannonball, g);

		g.setColor(new Color(47,170,42));
		drawtank(Tester.tank, g);
	}

}
