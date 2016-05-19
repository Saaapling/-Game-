
public class PlayerTank extends Tank{

	public PlayerTank(int ystart, int xstart, int identity, String newname) {
		super(ystart, xstart, identity, newname);
	}

	public void control(int keycode){
		 if (keycode==37){							//Movement
			movement(2);
		}if (keycode==39){
			movement(1);
		}if (keycode==32) {							//FIRE!
			fire();
		}if (keycode==38) {							//Rotating the barrel
			barrelrotate(1);
		}if (keycode==40) {
			barrelrotate(-1);
		}if (keycode==81) {							//Adjusting the power
			poweradjust(-1);
		}if (keycode==69) {
			poweradjust(1);
		}if (keycode==49) {							//Switching Weapons
			weaponadjust(1);
		}if (keycode==50) { 
			weaponadjust(2);
		}if (keycode==51) { 
			weaponadjust(3);
		}if (keycode==52) { 
			weaponadjust(4);
		}if (keycode==53) { 
			weaponadjust(5);
		}if (keycode==54) { 
			weaponadjust(6);
		}if (keycode==55) { 
			weaponadjust(7);
		}if (keycode==56) { 
			weaponadjust(8);
		}if (keycode==57) { 
			weaponadjust(9);
		}
	}
}