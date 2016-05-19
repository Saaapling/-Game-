import java.util.ArrayList;


public class BuckShot extends Cannonball{

	public BuckShot(int ystartpos, int xstartpos, int identity,	int newangle, int power, int newdirection) {
		super(ystartpos, xstartpos, identity, newangle, power, newdirection);
		time=2.5;
		radius=3;
		damage=5;
	}

	public ArrayList<int[]> firingMechanism(int xstart, int ystart, int power, int angle, int weapontype, double[]specialdata){
		ArrayList<int[]> cannonballdata=new ArrayList<int[]>();
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
				cannonballdata.add(new int[]{newx, newy, newpower,newangle});
		}
		return cannonballdata;
	}

	public void explosion(){
		for (int x=xpos-radius;x<xpos+radius;x++){
			for (int y=ypos-radius;y<ypos+radius;y++){
				double distance= Math.sqrt(Math.pow(x-xpos,2) + Math.pow(y-ypos,2));
				if (distance<=radius){
					if (x>=0&&x<600){
						if (y>=0&&y<250){
							if (Math.random()>0.35)
								Tester.board.board[y][x]=3;
							if (Tester.board.board[y][x]==0)
								Tester.board.board[y][x]=3;
							inflictDMG(Tester.board.board[y][x]);
						}
					}
				}
			}
		}
	}
}
