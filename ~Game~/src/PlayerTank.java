
public class PlayerTank extends Tank{

	public PlayerTank(int ystart, int xstart, int identity) {
		super(ystart, xstart, identity);
	}

	public void control(int keycode){
		if (keycode==37){
			movement(2);
		}if (keycode==39){
			movement(1);
		}if (keycode==32) {
			fire();
		}if (keycode==38) {
			barrelrotate(1);
		}if (keycode==40) {
			barrelrotate(-1);
		}if (keycode==81) {
			poweradjust(-1);
		}if (keycode==69) {
			poweradjust(1);
		}
	}
}