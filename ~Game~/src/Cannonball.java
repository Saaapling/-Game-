import java.math.*;

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction; 

public class Cannonball {

	double ballHorizontalSpeed;
	double ballVerticalSpeed;

	double ballSpeed;
	double ballAngle;

	Cannonball cannonball;
	int xpos;				//Coordinate defined as bottom left hand corner of tank
	int ypos;

	private final int MAX_POWER = 120;
	//private double totalFlightTime = (200 * Math.sqrt(2)) / MAX_POWER;
	private double totalFlightTime;
	private double flightTimer = 0;
	private double finalVelocity = (Math.sqrt(2) / 2) * MAX_POWER;
	private double yVelocity;
	private final int GRAVITY = 10;
	private boolean cannonballFlying = false;
	private int angle = 45;
	private int totalHorizontalDistanceTraveled;
	private double radian = angle * (Math.PI / 180);

	public Cannonball(int xstart, int ystart, int identity){
		xpos=xstart;
		ypos=ystart;
		//id=identity;
		//boardadjust();
	}

	public boolean movement(int direction, int[][] board, int origX, int origY){
		//if (direction==1){
		//if (board[xpos+5][ypos]==0){

		int originalX = origX;
		int originalY = origY;

		System.out.println("Before XPOS: "+xpos);
		System.out.println("Before YPos: "+ ypos);
		System.out.println("In cannonball movement");

		//xpos = (int) ( originalX+ (finalVelocity * flightTimer) ) ;

		System.out.println("XPOS: "+xpos);
		totalHorizontalDistanceTraveled = (int) ( (Math.pow(finalVelocity, 2) * Math.sin(2*radian) ) / (GRAVITY) ) ;
		totalFlightTime = (originalX + totalHorizontalDistanceTraveled) / finalVelocity;
		//ypos = (int) ( originalY + ( 0.5 * (GRAVITY) * ( Math.pow(flightTimer, 2)) ) ) ;
		xpos = (int)  (originalX + ( finalVelocity * flightTimer * Math.cos(radian) ) );
		ypos = (int) (originalY + ( (finalVelocity * flightTimer * Math.sin(radian) ) 
				- 0.5 * GRAVITY * (Math.pow(flightTimer, 2) ) ) );


		
		//yVelocity = Math.sqrt( (2*GRAVITY*originalX) ); no
		//ypos = (int) ( originalY + (yVelocity * flightTimer) ) ; no
		System.out.println("YPos: "+ ypos);
		System.out.println("Finalvel: " +finalVelocity);
		System.out.println("FlightTimer: " + flightTimer);
		System.out.println("Total flight time: " + totalFlightTime);
		System.out.println("TotalHorz " + totalHorizontalDistanceTraveled);
		flightTimer += 0.25;
		System.out.println("sin: " + Math.sin(2*radian));

		
		if (flightTimer >= totalFlightTime) {
			cannonballFlying = false;
			flightTimer = 0;
		} else {
			cannonballFlying  = true;
		}
		return(cannonballFlying);

		//xpos+=1;

		//}
		//}else{
		//if (board[xpos-1][ypos]==0){
		//xpos-=1;
		//}
		//}
	}

}