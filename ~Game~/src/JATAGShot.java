import java.util.ArrayList;

public class JATAGShot extends Cannonball{

	public JATAGShot(int ystartpos, int xstartpos, int identity,	int newangle, int power, int newdirection) {
		super(ystartpos, xstartpos, identity, newangle, power, newdirection);
		radius=0;
		time=7.5;
		damage=0;
	}

	public void explosion(){
		for (int x=xpos-radius;x<xpos+radius;x++){
			for (int y=ypos-radius;y<ypos+radius;y++){
				double distance= Math.sqrt(Math.pow(x-xpos,2) + Math.pow(y-ypos,2));
				if (distance<=radius){
					if (x>=0&&x<600){
						if (y>=0&&y<250){
							if (Math.random()>0.7)
								Tester.board.board[y][x]=3;
							if (Tester.board.board[y][x]==0)
								Tester.board.board[y][x]=3;
							inflictDMG(Tester.board.board[y][x]);
						}
					}
				}
			}
		}
		ArrayList<int[]> cannonballdata=new ArrayList<int[]>();
		int newpower;
		int newangle;
		int newx;
		int newy;

		while (cannonballdata.size()<40){
			newx=(int)(xpos-5+Math.random()*10+0.5);
			newy=(int)(ypos-Math.random()*8+0.5);
			newpower=(int)(40+Math.random()*30+0.5);
			newangle=(int)(45+Math.random()*100+0.5);
			boolean proceed=true;
			for (int[] cannonball:cannonballdata){
				if (newx==cannonball[0]&&newy==cannonball[1])
					proceed=false;
			}
			if (proceed)
				cannonballdata.add(new int[]{newx, newy, newpower,newangle});
		}
		for (int[] cannonball:cannonballdata){
			Tester.GODtank.cannonballsfired+=1;
			Tester.GODtank.cannonballs.add(new StandardShot(cannonball[1], cannonball[0], Tester.GODtank.cannonballsfired, cannonball[3], cannonball[2]*63/100, 1, 5, 1));

		}
	}
}
