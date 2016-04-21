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
		clearboard();
		if (direction==1){
			if (Tester.board.board[xpos+5][ypos]==0){
				xpos+=1;
			}else{
				if (Tester.board.board[xpos+5][ypos-1]==0){
					xpos+=1;
					ypos-=1;
				}else{
					if (Tester.board.board[xpos+5][ypos-2]==0){
						xpos+=1;
						ypos-=2;
					}else{
						System.out.println("a");
						System.out.println(Tester.board.board[xpos+5][ypos-3]);
						if (Tester.board.board[xpos+5][ypos-3]==0){
							xpos+=1;
							ypos-=3;
						}
					}
				}
			}
		}else{
			if (Tester.board.board[xpos-1][ypos]==0){
				xpos-=1;
			}
		}

		if (xpos>595)
			xpos=595;
		if (xpos<1)
			xpos=1;
		boardadjust();
	}

	public void clearboard(){
		for (int i=0; i<5;i++){
			Tester.board.board[ypos][xpos+i]=0;
			Tester.board.board[ypos-1][xpos+i]=0;
		}
		for (int i=0; i<4;i++){
			Tester.board.board[ypos-2][xpos+1+i]=0;
		}
	}

	public void falling(){
		clearboard();
		int increase=0;
		inner: while (Tester.board.board[ypos+1][xpos]==0&&Tester.board.board[ypos+1][xpos+1]==0
				&&Tester.board.board[ypos+1][xpos+2]==0&&Tester.board.board[ypos+1][xpos+3]==0
				&&Tester.board.board[ypos+1][xpos+4]==0){
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
		for (int i=0; i<5;i++){
			Tester.board.board[ypos][xpos+i]=id;
			Tester.board.board[ypos-1][xpos+i]=id;
		}
		for (int i=0; i<4;i++){
			Tester.board.board[ypos-2][xpos+1+i]=id;
		}
	}
}