import java.math.*;
import java.util.ArrayList;

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
	int id;
	int direction;
	boolean dispose;
	int radius;
	double time;

	private final int MAX_POWER;
	private double totalFlightTime;
	private double flightTimer = 0;
	private double xVelocity;
	private double yVelocity;
	private final int GRAVITY = 10;
	boolean cannonballFlying;
	private int angle;
	private int totalHorizontalDistanceTraveled;

	public Cannonball(int ystartpos, int xstartpos, int identity, int newangle, int power, int newdirection, int newradius){
		xstart=xstartpos;
		ystart=ystartpos;
		xpos=xstart;
		ypos=ystart;
		direction=newdirection;
		id=identity;
		radius=newradius;
		cannonballFlying=true;
		dispose=false;
		angle=newangle;
		MAX_POWER=power;
		xVelocity = Math.cos(conversion(angle)) * MAX_POWER;
		yVelocity = Math.sin(conversion(angle)) * MAX_POWER;
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

	public boolean movement(){
		int newypos = (int)(ystart + (-(yVelocity * flightTimer)+ (0.5 * GRAVITY * (Math.pow(flightTimer, 2)))));
		int newxpos;
		if (direction==1)
			newxpos = (int)(xstart + (xVelocity * flightTimer));
		else
			newxpos = (int)(xstart - (xVelocity * flightTimer));
		if (!disposecheck(newxpos,newypos)){
			xpos=newxpos;
			ypos=newypos;
			flightTimer *=1000;
			flightTimer += ((double)(10*Tester.interval));
			flightTimer /=1000;
		}else{
			dispose=false;
			flightTimer *=1000;
			flightTimer -= ((double)(10*Tester.interval));
			flightTimer /=1000;
			bakhatsuprep();
		}
		return(cannonballFlying);
	}

	public boolean collision(int xposition, int yposition){
		try{
			if (Tester.board.board[yposition][xposition]!=0&&Tester.board.board[yposition][xposition]!=3){
				cannonballFlying = false;
				dispose=true;
				return true;
			}else
				cannonballFlying = true;
		}catch (Exception E){
			cannonballFlying = false;
			dispose=true;
		}
		return false;
	}

	public void bakhatsuprep(){
		int repeat=0;
		boolean stop=false;
		while (repeat<10&&!stop){
			int newypos = (int)(ystart + (-(yVelocity * flightTimer)+ (0.5 * GRAVITY * (Math.pow(flightTimer, 2)))));
			int newxpos;
			if (direction==1)
				newxpos = (int)(xstart + (xVelocity * flightTimer));
			else
				newxpos = (int)(xstart - (xVelocity * flightTimer));
			flightTimer *=1000;
			flightTimer += ((double)(1*Tester.interval));
			flightTimer /=1000;
			if (!disposecheck(newxpos,newypos)){
				xpos=newxpos;
				ypos=newypos;
			}else{
				stop=true;
			}
			repeat+=1;
		}
		dispose=true;
	}

	public ArrayList<int[]> firingMechanism(int xstart, int ystart, int power, int angle, int weapontype, double[]specialdata){
		ArrayList<int[]> cannonballdata=new ArrayList<int[]>();
		cannonballdata.add(new int[]{xstart, ystart, power, angle});
		return cannonballdata;
	}
	
	public boolean disposecheck(int xpos, int ypos){
		collision(xpos,ypos);
		if (xpos<0||xpos>600)
			dispose=true;
		return dispose;
	}

	public void explosion(){

	}
	
	public double getTime(){
		return time;
	}
}