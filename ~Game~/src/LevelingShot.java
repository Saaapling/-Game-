
public class LevelingShot extends Cannonball{

	public LevelingShot(int ystartpos, int xstartpos, int identity,	int newangle, int power, int newdirection) {
		super(ystartpos, xstartpos, identity, newangle, power, newdirection);
		radius=5;
		time=10;
	}

	public void explosion(){
		for (int x=xpos-radius-20;x<xpos+radius-20;x++){
			for (int y=ypos-radius;y<ypos+radius;y++){
				double distance= Math.sqrt(Math.pow(x-xpos+20,2) + Math.pow(y-ypos,2));
				if (distance<=radius){
					if (x>=0&&x<600){
						if (y>=0&&y<250){
							Tester.board.board[y][x]=3;
						}
					}
				}
			}
		}
		for (int x=xpos-radius+20;x<xpos+radius+20;x++){
			for (int y=ypos-radius;y<ypos+radius;y++){
				double distance= Math.sqrt(Math.pow(x-xpos-20,2) + Math.pow(y-ypos,2));
				if (distance<=radius){
					if (x>=0&&x<600){
						if (y>=0&&y<250){
							Tester.board.board[y][x]=3;
						}
					}
				}
			}
		}
		for (int x=xpos-20;x<xpos+20;x++){
			for (int y=ypos-radius;y<ypos+radius;y++){
				Tester.board.board[y][x]=3;
			}
		}
	}
}
