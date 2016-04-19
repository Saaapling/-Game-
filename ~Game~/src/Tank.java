import java.awt.Color;


public class Tank {

	Color tankColor;
	
	//double tankHorizontalSpeed;
	//double tankVerticalSpeed;
	
	double barrelSpeed;
	double barrelAngle;
	
	int xpos;				//Coordinate defined as bottom left hand corner of tank
	int ypos;
	
	int id;
	
	public Tank(int ystart, int xstart, int identity){
		xpos=xstart;
		ypos=ystart;
		id=identity;
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
		if (xpos>600)
			xpos=600;
		if (xpos<0)
			xpos=0;
		boardadjust();
	}
	
	public void boardadjust(){
		for (int i=0; i<5;i++){
			Tester.board.board[ypos][xpos+i]=id;
			Tester.board.board[ypos-1][xpos+i]=id;
		}
		for (int i=0; i<4;i++){
			Tester.board.board[ypos-2][xpos+1+i]=id;
		}
	}
}
