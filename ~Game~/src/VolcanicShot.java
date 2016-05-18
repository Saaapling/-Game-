
public class VolcanicShot extends Cannonball{

	public VolcanicShot(int ystartpos, int xstartpos, int identity,	int newangle, int power, int newdirection) {
		super(ystartpos, xstartpos, identity, newangle, power, newdirection);
		radius=5;
		time=7;
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
		Tester.GODtank.cannonballsfired+=1;
		Tester.GODtank.cannonballs.add(new StandardShot(ypos, xpos, Tester.GODtank.cannonballsfired, 30, 20, 1, 10));
		Tester.GODtank.cannonballsfired+=1;
		Tester.GODtank.cannonballs.add(new StandardShot(ypos, xpos, Tester.GODtank.cannonballsfired, 60, 20, 1, 10));
		Tester.GODtank.cannonballsfired+=1;
		Tester.GODtank.cannonballs.add(new StandardShot(ypos, xpos, Tester.GODtank.cannonballsfired, 90, 20, 1, 10));
		Tester.GODtank.cannonballsfired+=1;
		Tester.GODtank.cannonballs.add(new StandardShot(ypos, xpos, Tester.GODtank.cannonballsfired, 120, 20, 1, 10));
		Tester.GODtank.cannonballsfired+=1;
		Tester.GODtank.cannonballs.add(new StandardShot(ypos, xpos, Tester.GODtank.cannonballsfired, 150, 20, 1, 10));
	}
}
