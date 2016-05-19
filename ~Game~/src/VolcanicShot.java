
public class VolcanicShot extends Cannonball{

	public VolcanicShot(int ystartpos, int xstartpos, int identity,	int newangle, int power, int newdirection) {
		super(ystartpos, xstartpos, identity, newangle, power, newdirection);
		radius=5;
		time=3.5;
		damage=1;
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
		for (int angle=30;angle<=150;angle+=30){
			Tester.GODtank.cannonballsfired+=1;
			Tester.GODtank.cannonballs.add(new StandardShot(ypos, xpos, Tester.GODtank.cannonballsfired, angle, 20, 1, 10, 0.5));
		}
	}
}
