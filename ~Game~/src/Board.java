import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Board extends JPanel{
	
	public int[][] board = new int[600][250];  //0-Empty, 1 terrain, 2 shot values, 10+ players
	
	public Board(){
		super();
		for (int x=0;x<600;x++){
			for (int y=0;y<250;y++){
				board[x][y]=0;
			}
		}
	}
	
	public void drawtank(Tank tank, Graphics g){
		g.drawLine(tank.xpos*2, tank.ypos*2, tank.xpos*2+10, tank.ypos*2);
		g.drawLine(tank.xpos*2, tank.ypos*2-1, tank.xpos*2+10, tank.ypos*2-1);
		g.drawLine(tank.xpos*2+1, tank.ypos*2-2, tank.xpos*2+10, tank.ypos*2-2);
		g.drawLine(tank.xpos*2+1, tank.ypos*2-3, tank.xpos*2+9, tank.ypos*2-3);
		g.drawLine(tank.xpos*2+2, tank.ypos*2-4, tank.xpos*2+8, tank.ypos*2-4);
	}
	
	public void paintComponent(Graphics g){
		for (int x=0;x<600;x++){
			for (int y=0;y<250;y++){
				if (board[x][y]==1){
					g.setColor(Color.GREEN);
				}else{
					g.setColor(new Color(0,240,240));
				}
				g.drawRect(x*2, y*2, 1, 1);
			}
		}
		g.setColor(Color.black);
		drawtank(Tester.tank, g);
	}
	
}
