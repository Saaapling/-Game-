import java.math.*;

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;  

public class Cannonball {

	double ballHorizontalSpeed;
	double ballVerticalSpeed;

	double ballSpeed;
	double ballAngle;

	Cannonball cannonball;
	int xstart;
	int ystart;
	int xpos;				//Coordinate defined as bottom left hand corner of tank
	int ypos;

	private final int MAX_POWER;
	private double totalFlightTime;
	private double flightTimer = 0;
	private double xVelocity;
	private double yVelocity;
	private final int GRAVITY = 10;
	private boolean cannonballFlying = false;
	private int angle;
	private int totalHorizontalDistanceTraveled;
	private double radian = angle * (Math.PI / 180);

	public Cannonball(int ystartpos, int xstartpos, int identity, int newangle, int power){
		xstart=xstartpos;
		ystart=ystartpos;
		xpos=xstart;
		ypos=ystart;
		angle=newangle;
		MAX_POWER=power;
		xVelocity = Math.cos(conversion(angle)) * MAX_POWER;
		yVelocity = Math.sin(conversion(angle)) * MAX_POWER;
		//yVelocity=50;
		totalFlightTime = (2*yVelocity/GRAVITY);
		totalHorizontalDistanceTraveled = (int) (xVelocity*totalFlightTime+.5);
	}

	//http://www.wired.com/2010/09/maximum-range-in-projectile-motion/

	public double conversion(double angle){
		return angle/180*Math.PI;
	}

	public void debugstats(){
		System.out.println("XPOS: "+xpos);
		System.out.println("YPos: "+ ypos);
		System.out.println("xVel: " +xVelocity);
		System.out.println("FlightTimer: " + flightTimer);
		System.out.println("Total flight time: " + totalFlightTime);
		System.out.println("TotalHorz " + totalHorizontalDistanceTraveled);
		System.out.println("\n\n\n");
	}

	public boolean movement(int direction, int[][] board){
		int newxpos = (int)(xstart + (xVelocity * flightTimer));
		int newypos = (int)(ystart + (-(yVelocity * flightTimer)+ (0.5 * GRAVITY * (Math.pow(flightTimer, 2)))));

		flightTimer *=1000;
		flightTimer += ((double)(Tester.interval));
		flightTimer /=1000;

		if (!collision(newxpos,newypos)){
			xpos=newxpos;
			ypos=newypos;
		}
		return(cannonballFlying);
	}

	public boolean collision(int xposition, int yposition){
		if (Tester.board.board[yposition][xposition]!=0){
			cannonballFlying = false;
			return true;
		}else
			cannonballFlying = true;
		return false;
	}
}