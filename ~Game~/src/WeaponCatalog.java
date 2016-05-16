import java.util.ArrayList;

public class WeaponCatalog {

	double time=0;

	public ArrayList<int[]> firingMechanism(int xstart, int ystart, int power, int angle, int weapontype, double[]specialdata){
		ArrayList<int[]> cannonballdata=new ArrayList<int[]>();
		if (weapontype==1)
			cannonballdata.add(new int[]{xstart, ystart, power, angle});
		if (weapontype==2){
			int newx;
			int newy;
			int newpower;
			int newangle;
			while (cannonballdata.size()<6){
				newx=(int)(xstart-4+Math.random()*8+0.5);
				newy=(int)(ystart-4+Math.random()*8+0.5);
				newpower=(int)(power-6+Math.random()*12+0.5);
				newangle=(int)(angle-5+Math.random()*10+0.5);
				boolean proceed=true;
				for (int[] cannonball:cannonballdata){
					if (newx==cannonball[0]&&newy==cannonball[1])
						proceed=false;
				}
				if (proceed)
					cannonballdata.add(new int[]{newx, newy, power,newangle});
			}
		}
		if (weapontype==3){
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
		}
		return cannonballdata;
	}

	public double getTime(int weapontype){
		if (weapontype==1)
			return 1;
		if (weapontype==2)
			return 2.5;
		if (weapontype==3)
			return time;
		return 0;
	}
}
