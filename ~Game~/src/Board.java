import java.awt.Graphics;
import javax.swing.JPanel;


public class Board extends JPanel{
	
	public int[][] board = new int[1200][500];  //0-Empty, 1 terrain, 2 shot values, 10+ players
	
	public Board(){
		super();
		for (int x=0;x<1200;x++){
			for (int y=0;y<500;y++){
				board[x][y]=0;
			}
		}
	}
	
	public  void terraingeneration(){
		for (int x=0;x<200;x++){
			for (int y=0;y<1200;y++){
				board[x][y]=1;
			}
		}
	}
	
	public void paintComponent(Graphics g){
		
	}
	
}
