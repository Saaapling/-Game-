public class Cannonball {

	double ballHorizontalSpeed;
	double ballVerticalSpeed;

	double ballSpeed;
	double ballAngle;

	Cannonball cannonball;

	Board board;

	int xpos;				//Coordinate defined as bottom left hand corner of tank
	int ypos;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Cannonball(int xstart, int ystart, Board newboard, int identity){
		xpos=xstart;
		ypos=ystart;
		//id=identity;
		board=newboard;
		//boardadjust();
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

}