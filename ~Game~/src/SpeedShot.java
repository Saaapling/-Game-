import java.util.ArrayList;


public class SpeedShot extends Cannonball{

	public SpeedShot(int ystartpos, int xstartpos, int identity,	int newangle, int power, int newdirection, int newradius) {
		super(ystartpos, xstartpos, identity, newangle, power, newdirection, newradius);
		time=0.1;
	}

	public ArrayList<int[]> firingMechanism(int xstart, int ystart, int power, int angle, int weapontype, double[]specialdata){
		ArrayList<int[]> cannonballdata=new ArrayList<int[]>();
		int newpower;
		int newangle;
		newpower=(int)(power-3+Math.random()*6+0.5);
		newangle=(int)(angle-2+Math.random()*4+0.5);
		if (specialdata[0]==0){
			specialdata[0]=1.6;
			specialdata[1]=1;
		}else
			specialdata[1]=0;
		double randomizer=Math.random();
		if (randomizer<specialdata[0]){
			time=0.1;
		}else{
			time=4.0;
			specialdata[0]=0.1;
		}
		cannonballdata.add(new int[]{xstart, ystart, newpower, newangle});
		specialdata[0]-=0.1;
		return cannonballdata;
	}
	
	public void explosion(){
		for (int x=xpos-radius;x<xpos+radius;x++){
			for (int y=ypos-radius;y<ypos+radius;y++){
				double distance= Math.sqrt(Math.pow(x-xpos,2) + Math.pow(y-ypos,2));
				if (distance<=radius){
					if (x>=0&&x<600){
						if (y>=0&&y<250){
							Tester.board.board[y][x]=3;
						}
					}
				}
			}
		}
	}
}
