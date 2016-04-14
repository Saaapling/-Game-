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
		System.out.println("why garn?");
		if (direction==1){
			System.out.println("HA!");
			//if (board[xpos+5][ypos]==0){
				System.out.println("Whatta joke");
				xpos+=1;
			//}
		}else{
			System.out.println("Hm...");
			//if (board[xpos-1][ypos]==0){
				System.out.println("Cuz he's a scrub");
				xpos-=1;
			//}
		}
	}
	
	public void boardadjust(){
		for (int i=0; i<10;i++){
			board.board[xpos][ypos+i]=id;
			board.board[xpos+1][ypos+i]=id;
		}
		for (int i=0; i<9;i++){
			board.board[xpos+2][ypos+i+1]=id;
		}
		for (int i=0; i<8;i++){
			board.board[xpos+3][ypos+i+1]=id;
		}
		for (int i=0; i<6;i++){
			board.board[xpos+4][ypos+i+2]=id;
		}
	}
}
