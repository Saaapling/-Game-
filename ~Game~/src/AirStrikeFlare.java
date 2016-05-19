
public class AirStrikeFlare extends Cannonball{

	public AirStrikeFlare(int ystartpos, int xstartpos, int identity,	int newangle, int power, int newdirection) {
		super(ystartpos, xstartpos, identity, newangle, power, newdirection);
		radius=0;
		time=10;
		damage=0;
	}

	public void explosion(){
		for (int x=xpos-radius;x<xpos+radius;x++){
			for (int y=ypos-radius;y<ypos+radius;y++){
				double distance= Math.sqrt(Math.pow(x-xpos,2) + Math.pow(y-ypos,2));
				if (distance<=radius){
					if (x>=0&&x<600){
						if (y>=0&&y<250){
							Tester.board.board[y][x]=3;
							inflictDMG(Tester.board.board[y][x]);
						}
					}
				}
			}
		}
		for (int y=-60;y<=-30;y+=10){
			for (int x=-21;x<=21;x+=7){
				Tester.GODtank.cannonballsfired+=1;
				Tester.GODtank.cannonballs.add(new StandardShot(y, xpos-x, Tester.GODtank.cannonballsfired, 0, 0, 1, 4, 1));
			}
		}
	}
}
