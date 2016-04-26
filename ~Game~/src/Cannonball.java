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

	public Cannonball(int xstartpos, int ystartpos, int identity, int newangle, int power){
		xstart=xstartpos;
		ystart=ystartpos;
		xpos=xstart;
		ypos=ystart;
		angle=newangle;
		MAX_POWER=power;
		xVelocity = Math.cos(conversion(angle)) * MAX_POWER;
		//yVelocity = Math.sin(conversion(angle)) * MAX_POWER;
		yVelocity=50;
		totalFlightTime = (2*yVelocity/GRAVITY);
		totalHorizontalDistanceTraveled = (int) (xVelocity*totalFlightTime+.5);
	}

	//http://www.wired.com/2010/09/maximum-range-in-projectile-motion/
	
	public double conversion(double angle){
		return angle/180*Math.PI;
	}
	
	public boolean movement(int direction, int[][] board){
		//System.out.println("Before XPOS: "+xpos);
		//System.out.println("In cannonball movement");
		//System.out.println("XPOS: "+xpos);

		xpos = (int)(xstart + (xVelocity * flightTimer));
		ypos = (int)(ystart + (-(yVelocity * flightTimer)+ (0.5 * GRAVITY * (Math.pow(flightTimer, 2)))));
		
		System.out.println("\n\n\n");
		System.out.println("XPOS: "+xpos);
		System.out.println("YPos: "+ ypos);
		System.out.println("xVel: " +xVelocity);
		System.out.println("FlightTimer: " + flightTimer);
		System.out.println("Total flight time: " + totalFlightTime);
		System.out.println("TotalHorz " + totalHorizontalDistanceTraveled);
		//flightTimer += (Tester.interval/1000);
		flightTimer += 1;
		System.out.println("sin: " + Math.sin(2*radian));

		
		if (flightTimer > totalFlightTime) {
			cannonballFlying = false;
			flightTimer = 0;
		} else {
			cannonballFlying  = true;
		}
		
		return(cannonballFlying);
	}

}