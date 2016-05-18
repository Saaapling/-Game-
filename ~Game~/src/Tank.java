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
	int weapon;				//1-Standard, 2-Shotgun, 3-Machine-Gun
	double shottimer;
	double maxshottimer;

	WeaponCatalog catalog;
	double[] specialdata;
	Cannonball standard;
	ArrayList<Cannonball> cannonballs=new ArrayList<Cannonball>();

	public Tank(int ystart, int xstart, int identity){
		if (identity!=100){
			catalog=new WeaponCatalog();
			xpos=xstart;
			ypos=ystart;
			id=identity;
			orientation=2;
			boardadjust();
			barrelAngle=0;
			power=100;
			cannonballsfired=0;
			fuel=250;
			weapon=8;
			specialdata=new double[]{0,0};
		}
	}

	public double conversion(double angle){
		return angle/180*Math.PI;
	}

	public void control(){

	}

	public void fire(){
		if (shottimer<=0){
			int xstart;
			int ystart;
			if (orientation==1){
				xstart=(int)((xpos*2+12+(9*Math.cos(conversion(barrelAngle)))+.5)/2);
				ystart=(int)((ypos*2-6-(9*Math.sin(conversion(barrelAngle))-.5))/2);
			}else{
				xstart=(int)((xpos*2+(16-(12+(9*Math.cos(conversion(barrelAngle)))))+.5)/2);
				ystart=(int)((ypos*2-6-(9*Math.sin(conversion(barrelAngle))-.5))/2);
			}
			weaponMechanism(xstart, ystart);
		}
	}

	public void weaponMechanism(int xstart, int ystart){
		ArrayList<int[]> cannonballdata;
		if (weapon==1){
			standard=new StandardShot(1, 1, 1, 1, 1, 1, 10);
			cannonballdata=standard.firingMechanism(xstart, ystart, power, barrelAngle, weapon, specialdata);
			if (specialdata[1]!=1){
				for (int[] cannonball:cannonballdata){
					cannonballsfired+=1;
					cannonballs.add(new StandardShot(cannonball[1], cannonball[0], cannonballsfired, barrelAngle, cannonball[2]*63/100, orientation, 10));
				}
			}
		}else if (weapon==2){
			standard=new BuckShot(1, 1, 1, 1, 1, 1);
			cannonballdata=standard.firingMechanism(xstart, ystart, power, barrelAngle, weapon, specialdata);
			if (specialdata[1]!=1){
				for (int[] cannonball:cannonballdata){
					cannonballsfired+=1;
					cannonballs.add(new BuckShot(cannonball[1], cannonball[0], cannonballsfired, barrelAngle, cannonball[2]*63/100, orientation));
				}
			}
		}else if (weapon==3){
			standard=new SpreadShot(1, 1, 1, 1, 1, 1);
			cannonballdata=standard.firingMechanism(xstart, ystart, power, barrelAngle, weapon, specialdata);
			if (specialdata[1]!=1){
				for (int[] cannonball:cannonballdata){
					cannonballsfired+=1;
					cannonballs.add(new SpreadShot(cannonball[1], cannonball[0], cannonballsfired, barrelAngle, cannonball[2]*63/100, orientation));
				}
			}
		}else if (weapon==4){
			standard=new WideShot(1, 1, 1, 1, 1, 1);
			cannonballdata=standard.firingMechanism(xstart, ystart, power, barrelAngle, weapon, specialdata);
			if (specialdata[1]!=1){
				for (int[] cannonball:cannonballdata){
					cannonballsfired+=1;
					cannonballs.add(new WideShot(cannonball[1], cannonball[0], cannonballsfired, barrelAngle, cannonball[2]*63/100, orientation));
				}
			}
		}else if (weapon==5){
			standard=new AtomicShot(1, 1, 1, 1, 1, 1);
			cannonballdata=standard.firingMechanism(xstart, ystart, power, barrelAngle, weapon, specialdata);
			if (specialdata[1]!=1){
				for (int[] cannonball:cannonballdata){
					cannonballsfired+=1;
					cannonballs.add(new AtomicShot(cannonball[1], cannonball[0], cannonballsfired, barrelAngle, cannonball[2]*63/100, orientation));
				}
			}
		}else if (weapon==6){
			standard=new LevelingShot(1, 1, 1, 1, 1, 1);
			cannonballdata=standard.firingMechanism(xstart, ystart, power, barrelAngle, weapon, specialdata);
			if (specialdata[1]!=1){
				for (int[] cannonball:cannonballdata){
					cannonballsfired+=1;
					cannonballs.add(new LevelingShot(cannonball[1], cannonball[0], cannonballsfired, barrelAngle, cannonball[2]*63/100, orientation));
				}
			}
		}else if (weapon==7){
			standard=new VolcanicShot(1, 1, 1, 1, 1, 1);
			cannonballdata=standard.firingMechanism(xstart, ystart, power, barrelAngle, weapon, specialdata);
			if (specialdata[1]!=1){
				for (int[] cannonball:cannonballdata){
					cannonballsfired+=1;
					cannonballs.add(new VolcanicShot(cannonball[1], cannonball[0], cannonballsfired, barrelAngle, cannonball[2]*63/100, orientation));
				}
			}
		}else if (weapon==8){
			standard=new AirStrikeFlare(1, 1, 1, 1, 1, 1);
			cannonballdata=standard.firingMechanism(xstart, ystart, power, barrelAngle, weapon, specialdata);
			if (specialdata[1]!=1){
				for (int[] cannonball:cannonballdata){
					cannonballsfired+=1;
					cannonballs.add(new AirStrikeFlare(cannonball[1], cannonball[0], cannonballsfired, barrelAngle, cannonball[2]*63/100, orientation));
				}
			}
		}
		shottimer=standard.getTime();
		maxshottimer=standard.getTime();
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
		if(fuel>0){
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

			if (xpos>591)
				xpos=591;
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

	public void weaponadjust(int i){
		weapon+=i;
		if (weapon>9)
			weapon=9;
		if (weapon<1)
			weapon=1;
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
