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
	public ArrayList<int[]> bakahatsu=new ArrayList<int[]>();
	
	public Board(){
		super();
		for (int x=0;x<600;x++){ 
			for (int y=0;y<250;y++){
				board[y][x]=0;
			}
		}
	}

	public void BakahutsuClear(){
		for (int x=599;x>=0;x--)
			for (int y=249;y>=0;y--)
				if (board[y][x]==3)
					board[y][x]=0;
	}
	
	public void updatebackground(int xpos, int ypos, int id){
		int fallen=0;
		if (ypos<249){
			inner: while (Tester.board.board[ypos+1][xpos]==0){
				ypos+=1;
				if (ypos>248){
					ypos=248;
					break inner;
				}else if (fallen>=3){
					break inner;
				}
				Tester.board.board[ypos-1][xpos]=0;
				Tester.board.board[ypos][xpos]=id;
				fallen+=1;
			}
		}
	}

	public void drawbackground(Graphics g){
		for (int x=599;x>=0;x--)
			for (int y=249;y>=0;y--)
				if (board[y][x]>0&&board[y][x]<10)
					updatebackground(x, y, board[y][x]);
		for (int x=0;x<600;x++){
			for (int y=0;y<250;y++){
				if (board[y][x]==1){
					g.setColor(Color.GREEN);
				}else if(board[y][x]==2){
					g.setColor(Color.GRAY);
				}else if(board[y][x]==3){
					g.setColor(new Color(255, 153, 51, 20));
				}else if(board[y][x]>=10){
					//g.setColor(Color.BLUE);
				}else{
					g.setColor(new Color(0,240,240));
				}
				g.drawRect(x*2, y*2, 1, 1);
			}
		}
	}

	public void drawtank(Tank tank, Graphics g){
		if (tank.orientation==1){
			g.drawLine(tank.xpos*2+3, tank.ypos*2+1, tank.xpos*2+15, tank.ypos*2+1);
			g.drawLine(tank.xpos*2+2, tank.ypos*2, tank.xpos*2+16, tank.ypos*2);
			g.drawLine(tank.xpos*2+1, tank.ypos*2-1, tank.xpos*2+16, tank.ypos*2-1);
			g.drawLine(tank.xpos*2+1, tank.ypos*2-2, tank.xpos*2+16, tank.ypos*2-2);
			g.drawLine(tank.xpos*2+3, tank.ypos*2-3, tank.xpos*2+15, tank.ypos*2-3);
			g.drawLine(tank.xpos*2+5, tank.ypos*2-4, tank.xpos*2+14, tank.ypos*2-4);
			g.drawLine(tank.xpos*2+5, tank.ypos*2-5, tank.xpos*2+14, tank.ypos*2-5);
			g.drawLine(tank.xpos*2+8, tank.ypos*2-6, tank.xpos*2+14, tank.ypos*2-6);
			//Drawing the barrel
			g.drawLine(tank.xpos*2+12, tank.ypos*2-6, (int)(tank.xpos*2+12+(9*Math.cos(tank.conversion(tank.barrelAngle)))+.5),
					(int)(tank.ypos*2-6-(9*Math.sin(tank.conversion(tank.barrelAngle))-.5)));
		}else{
			g.drawLine(tank.xpos*2+1, tank.ypos*2+1, tank.xpos*2+13, tank.ypos*2+1);
			g.drawLine(tank.xpos*2, tank.ypos*2, tank.xpos*2+14, tank.ypos*2);
			g.drawLine(tank.xpos*2, tank.ypos*2-1, tank.xpos*2+15, tank.ypos*2-1);
			g.drawLine(tank.xpos*2, tank.ypos*2-2, tank.xpos*2+15, tank.ypos*2-2);
			g.drawLine(tank.xpos*2+1, tank.ypos*2-3, tank.xpos*2+13, tank.ypos*2-3);
			g.drawLine(tank.xpos*2+2, tank.ypos*2-4, tank.xpos*2+11, tank.ypos*2-4);
			g.drawLine(tank.xpos*2+2, tank.ypos*2-5, tank.xpos*2+11, tank.ypos*2-5);
			g.drawLine(tank.xpos*2+2, tank.ypos*2-6, tank.xpos*2+8, tank.ypos*2-6);
			//Drawing the barrel
			g.drawLine(tank.xpos*2+4, tank.ypos*2-6, (int)(tank.xpos*2+(16-(12+(9*Math.cos(tank.conversion(tank.barrelAngle)))))+.5),
					(int)(tank.ypos*2-6-(9*Math.sin(tank.conversion(tank.barrelAngle))-.5)));
		}
	}

	public void drawCannonball(Cannonball cannonball, Graphics g){
		g.setColor(Color.black);
		g.fillRect(cannonball.xpos*2,cannonball.ypos*2, 2, 2);
		//System.out.println(cannonball.xpos*2+", "+cannonball.ypos*2);
	}

	public void paintComponent(Graphics g){
		drawbackground(g);
		for (Cannonball cannonball:Tester.playertank.cannonballs){
			drawCannonball(cannonball, g);
		}
		g.setColor(new Color(47,170,42));
		drawtank(Tester.playertank, g);
	}

}
