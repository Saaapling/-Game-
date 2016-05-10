import java.awt.Color;
import java.util.ArrayList;


public class Tank {

	Color tankColor;

	int xpos;				 //Coordinate defined as bottom left hand corner of tank
	int ypos;
	int id;
	int cannonballsfired;
	int orientation;

	//FOR THE HUD
	int health;
	int fuel;
	String name;
	int barrelAngle;
	int power;
	int weapon;
	int shottimer;

	ArrayList<Cannonball> cannonballs=new ArrayList<Cannonball>();

	public Tank(int ystart, int xstart, int identity){
		xpos=xstart;
		ypos=ystart;
		id=identity;
		orientation=1;
		boardadjust();
		barrelAngle=0;
		power=100;
		cannonballsfired=0;
		fuel=250;
	}

	public double conversion(double angle){
		return angle/180*Math.PI;
	}

	public void fire(){
		cannonballsfired+=1;
		if (orientation==1)
			cannonballs.add(new Cannonball((int)((ypos*2-6-(9*Math.sin(conversion(barrelAngle))-.5))/2),
					(int)((xpos*2+12+(9*Math.cos(conversion(barrelAngle)))+.5)/2), cannonballsfired, barrelAngle, power*63/100, orientation));
		else
			cannonballs.add(new Cannonball((int)((ypos*2-6-(9*Math.sin(conversion(barrelAngle))-.5))/2),
					(int)((xpos*2+(16-(12+(9*Math.cos(conversion(barrelAngle)))))+.5)/2), cannonballsfired, barrelAngle, power*63/100, orientation));
	}

	public void disposal(){
		ArrayList<Integer> tobedisposed=new ArrayList<Integer>();
		for (Cannonball cannonball:this.cannonballs){
			if (cannonball.dispose)
				tobedisposed.add(cannonball.id);
		}
		for (int tag:tobedisposed)
			for (int i=cannonballs.size()-1;i>=0;i--){
				if (cannonballs.get(i).id==tag){
					cannonballs.get(i).explosion();
					cannonballs.remove(i);
				}
			}
	}

	public void movement(int direction){
		if(fuel<260){
			fuel-=1;
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

	public void barrelrotate(int angledisplacement){
		barrelAngle+=angledisplacement;
		if (barrelAngle>40)
			barrelAngle=40;
		else if(barrelAngle<0)
			barrelAngle=0;
	}

	public void poweradjust(int i){
		power+=i;
		if (power>100)
			power=100;
		if (power<0)
			power=0;
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
		boardadjust();
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
