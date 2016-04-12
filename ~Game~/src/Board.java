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
	
	public  void terraingeneration(){
		for (int x=0;x<600;x++){
			for (int y=150;y<250;y++){
				board[x][y]=1;
			}
		}
	}
	
	public void paintComponent(Graphics g){
		terraingeneration();
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
	}
	
}
