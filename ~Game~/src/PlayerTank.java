
public class PlayerTank extends Tank{

	public PlayerTank(int ystart, int xstart, int identity) {
		super(ystart, xstart, identity);
	}

	public void movement(int direction, int[][] board){
		clearboard();
		if (direction==1){
			orientation=1;
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
			orientation=2;
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
	
	
}
