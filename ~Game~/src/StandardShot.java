
public class StandardShot extends Cannonball{

	public StandardShot(int ystartpos, int xstartpos, int identity,	int newangle, int power, int newdirection, int newradius) {
		super(ystartpos, xstartpos, identity, newangle, power, newdirection);
		time=2;
		radius=newradius;
	}

	public void explosion(){
		for (int x=xpos-radius;x<xpos+radius;x++){
			for (int y=ypos-radius;y<ypos+radius;y++){
				double distance= Math.sqrt(Math.pow(x-xpos,2) + Math.pow(y*2-ypos*2,2));
				if (distance<=radius){
					if (x>=0&&x<600){
						if (y>=0&&y<250){
							if (Math.random()>0.7)
								Tester.board.board[y][x]=3;
							if (Tester.board.board[y][x]==0)
								Tester.board.board[y][x]=3;
						}
					}
				}
			}
		}
	}
}
