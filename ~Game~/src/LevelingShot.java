
public class LevelingShot extends Cannonball{

	public LevelingShot(int ystartpos, int xstartpos, int identity,	int newangle, int power, int newdirection) {
		super(ystartpos, xstartpos, identity, newangle, power, newdirection);
		radius=5;
		time=8;
		damage=0;
	}

	public void explosion(){
		for (int x=xpos-radius-20;x<xpos+radius-20;x++){
			for (int y=ypos-radius;y<ypos+radius;y++){
				double distance= Math.sqrt(Math.pow(x-xpos+20,2) + Math.pow(y-ypos,2));
				if (distance<=radius){
					if (x>=0&&x<600){
						if (y>=0&&y<250){
							if (Math.random()>0.1)
								Tester.board.board[y][x]=3;
							if (Tester.board.board[y][x]==0)
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
							if (Math.random()>0.1)
								Tester.board.board[y][x]=3;
							if (Tester.board.board[y][x]==0)
								Tester.board.board[y][x]=3;
							inflictDMG(Tester.board.board[y][x]);
						}
					}
				}
			}
		}
		for (int x=xpos-20;x<xpos+20;x++){
			for (int y=ypos-radius;y<ypos+radius;y++){
				if (x>=0&&x<600){
					if (y>=0&&y<250){
						if (Math.random()>0.1)
							Tester.board.board[y][x]=3;
						if (Tester.board.board[y][x]==0)
							Tester.board.board[y][x]=3;
					}
				}
			}
		}
	}
}