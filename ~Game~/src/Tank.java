import java.awt.Color;
  

public class Tank {

	Color tankColor;

	//double tankHorizontalSpeed;
	//double tankVerticalSpeed;

	double barrelSpeed;
	double barrelAngle;

	int xpos;				 //Coordinate defined as bottom left hand corner of tank
	int ypos;

	int id;

	public Tank(int ystart, int xstart, int identity){
		xpos=xstart;
		ypos=ystart;
		id=identity;
		boardadjust();
		barrelAngle=0;
	}

	public double conversion(double angle){
		return angle/180*Math.PI;
	}
	
	public void movement(int direction, int[][] board){
		clearboard();
		if (direction==1){
			if (Tester.board.board[ypos][xpos+8]==0){
				xpos+=1;
			}else{
				if (Tester.board.board[ypos-1][xpos+8]==0){
					xpos+=1;
					ypos-=1;
				}else{
					if (Tester.board.board[ypos-2][xpos+8]==0){
						xpos+=1;
						ypos-=2;
					}else{
						if (Tester.board.board[ypos-3][xpos+8]==0){
							xpos+=1;
							ypos-=3;
						}
					}
				}
			}
		}else{
			if (Tester.board.board[ypos][xpos-1]==0){
				xpos-=1;
			}else{
				if (Tester.board.board[ypos-1][xpos-1]==0){
					xpos-=1;
					ypos-=1;
				}else{
					if (Tester.board.board[ypos-2][xpos-1]==0){
						xpos-=1;
						ypos-=2;
					}else{
						if (Tester.board.board[ypos-3][xpos-1]==0){
							xpos-=1;
							ypos-=3;
						}
					}
				}
			}
		}

		if (xpos>595)
			xpos=595;
		if (xpos<1)
			xpos=1;
		boardadjust();
	}

	public void barrelrotate(int angledisplacement){
		barrelAngle+=angledisplacement;
		if (barrelAngle>40)
			barrelAngle=40;
		else if(barrelAngle<0)
			barrelAngle=0;
	}
	
	public void clearboard(){
		for (int i=0; i<8;i++){
			Tester.board.board[ypos][xpos+i]=0;
			Tester.board.board[ypos-1][xpos+i]=0;
		}
		for (int i=0; i<6;i++){
			Tester.board.board[ypos-2][xpos+2+i]=0;
			Tester.board.board[ypos-3][xpos+2+i]=0;

		}
	}

	public void falling(){
		clearboard();
		int increase=0;
		inner: while (Tester.board.board[ypos+1][xpos]==0&&Tester.board.board[ypos+1][xpos+1]==0
				&&Tester.board.board[ypos+1][xpos+2]==0&&Tester.board.board[ypos+1][xpos+3]==0
				&&Tester.board.board[ypos+1][xpos+4]==0&&Tester.board.board[ypos+1][xpos+5]==0
				&&Tester.board.board[ypos+1][xpos+6]==0&&Tester.board.board[ypos+1][xpos+7]==0){
			ypos+=1;
			increase+=1;
			if (ypos>248){
				ypos=248;
				break inner;
			}
			if (increase>3)
				break inner;
		}
	}

	public void boardadjust(){
		for (int i=0; i<8;i++){
			Tester.board.board[ypos][xpos+i]=id;
			Tester.board.board[ypos-1][xpos+i]=id;
		}
		for (int i=0; i<6;i++){
			Tester.board.board[ypos-2][xpos+2+i]=id;
			Tester.board.board[ypos-3][xpos+2+i]=id;

		}
	}
}
