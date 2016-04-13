import java.awt.Color;


public class Tank {

	Color tankColor;
	
	//double tankHorizontalSpeed;
	//double tankVerticalSpeed;
	
	double barrelSpeed;
	double barrelAngle;
	
	int xpos;			//Coordinate defined as bottom left hand corner of tank
	int ypos;
	
	int id;
	
	public Tank(int xstart, int ystart, Board board, int identity){
		xpos=xstart;
		ypos=ystart;
		id=identity;
		for (int i=0; i<10;i++){
			board.board[xpos+i][ypos]=id;
			board.board[xpos+i][ypos+1]=id;
		}
		for (int i=0; i<9;i++){
			board.board[xpos+i+1][ypos+2]=id;
			board.board[xpos+i+1][ypos+3]=id;
		}
		for (int i=0; i<6;i++){
			board.board[xpos+i+2][ypos+4]=id;
		}
	}
	
	public void movement(int direction, int[][] board){
		if (direction==1){
			if (board[xpos+5][ypos]==0){
				xpos+=1;
			}
		}else{
			if (board[xpos-1][ypos]==0){
				xpos-=1;
			}
		}
	}
}
