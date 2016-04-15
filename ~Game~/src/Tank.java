import java.awt.Color;


public class Tank {

	Color tankColor;
	
	//double tankHorizontalSpeed;
	//double tankVerticalSpeed;
	
	double barrelSpeed;
	double barrelAngle;
	Board board;
	
	int xpos;				//Coordinate defined as bottom left hand corner of tank
	int ypos;
	
	int id;
	
	public Tank(int xstart, int ystart, Board newboard, int identity){
		xpos=xstart;
		ypos=ystart;
		id=identity;
		board=newboard;
		boardadjust();
	}
	
	public void movement(int direction, int[][] board){
		if (direction==1){
			//if (board[xpos+5][ypos]==0){
				xpos+=1;
			//}
		}else{
			//if (board[xpos-1][ypos]==0){
				xpos-=1;
			//}
		}
	}
	
	public void boardadjust(){
		for (int i=0; i<5;i++){
			board.board[xpos][ypos+i]=id;
			board.board[xpos-1][ypos+i]=id;
		}
		for (int i=0; i<4;i++){
			board.board[xpos-2][ypos+i+1]=id;
		}
	}
}
