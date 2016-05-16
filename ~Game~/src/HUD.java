import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.text.LayeredHighlighter.LayerPainter;

import java.awt.*;
import java.awt.event.*;


public class HUD extends JPanel{

	Tank theTank; 

	playertankHudPanel playertankHud;
	CPUtankHudPanel CPUtankHud;
	JPanel cputankHud;

	public HUD(Tank newtank, playertankHudPanel playertankHud, CPUtankHudPanel CPUtankHud) {
		theTank=newtank;
		this.setPreferredSize(new Dimension(1200,100));
		BorderLayout tree = new BorderLayout();
		this.setLayout(tree);
		this.add(BorderLayout.WEST, playertankHud);
		this.add(BorderLayout.EAST, CPUtankHud);
	}

	public void paintComponent(Graphics g) {

	}

}

class playertankHudPanel extends JPanel {
	drawHealthPanel healthbar;
	drawFuelPanel fuelbar;
	drawPowerPanel powerbar;

	Tank theTank;

	JLabel playerName,
	playerHealth, playerHealthPercent, playerWeapons, playerWeaponsSlot, playerShotTimer, 
	playerFuel, playerFuelNumber, playerAngle, playerPower, playerPowerNumber;

	public playertankHudPanel(HUD hud, Tank tank) {
		theTank = tank;

		this.setLayout(new GridBagLayout());

		playerName = new JLabel(theTank.name);
		playerHealth = new JLabel("Health: ");
		playerHealthPercent = new JLabel("" + theTank.health + "%");
		playerWeapons = new JLabel("Weapons: ");
		playerWeaponsSlot = new JLabel("" + theTank.weapon);
		playerShotTimer = new JLabel("Shot timer: " + theTank.shottimer + " sec");
		playerFuel = new JLabel("Fuel: ");
		playerFuelNumber = new JLabel("" + theTank.fuel);
		playerAngle = new JLabel("Angle: " + theTank.barrelAngle);
		playerPower = new JLabel("Power: ");
		playerPowerNumber = new JLabel("" + theTank.power);		

		GridBagConstraints constr = new GridBagConstraints();
		constr.gridx = 0;
		constr.gridy = 0;
		constr.gridwidth = 1;
		constr.gridheight = 1;
		//constr.anchor = GridBagConstraints.EAST;
		constr.insets = new Insets(0,0,5,5);
		constr.weightx = 1;
		constr.weighty = 1;
		constr.fill = GridBagConstraints.HORIZONTAL;

		this.add(playerName, constr);

		constr.gridx = 0; constr.gridy = 1;
		this.add(playerHealth, constr);

		constr.gridx = 1; constr.gridy = 1;
		healthbar = new drawHealthPanel(theTank, constr);
		this.add(healthbar, constr);

		constr.gridx = 2; constr.gridy = 1;
		this.add(playerHealthPercent, constr);

		constr.gridx = 3; constr.gridy = 1;
		this.add(playerWeapons, constr);

		constr.gridx = 4; constr.gridy = 1;
		this.add(playerWeaponsSlot, constr);

		constr.gridx = 5; constr.gridy = 1;
		this.add(playerShotTimer, constr);

		constr.gridx = 0; constr.gridy = 2;
		this.add(playerFuel, constr);

		constr.gridx = 1; constr.gridy = 2;
		fuelbar = new drawFuelPanel(theTank, constr);
		this.add(fuelbar, constr);

		constr.gridx = 2; constr.gridy = 2;
		this.add(playerFuelNumber, constr);

		constr.gridx = 3; constr.gridy = 2;
		this.add(playerAngle, constr);

		constr.gridx = 4; constr.gridy = 2;
		this.add(playerPower, constr);

		constr.gridx = 5; constr.gridy = 2;
		powerbar = new drawPowerPanel(theTank, constr);
		this.add(powerbar, constr);

		constr.gridx = 6; constr.gridy = 2;
		this.add(playerPowerNumber, constr);
	}

	public void updateHud() {
		playerName.setText(theTank.name);
		playerHealth.setText("Health: ");
		playerHealthPercent.setText("" + theTank.health + "%");
		playerWeapons.setText("Weapons: ");
		playerWeaponsSlot.setText("" + theTank.weapon);

		playerShotTimer.setText("Shot timer: " + theTank.shottimer + " sec");
		playerFuel.setText("Fuel: ");
		playerFuelNumber.setText("" + theTank.fuel);
		playerAngle.setText("Angle: " + theTank.barrelAngle);
		playerPower.setText("Power: ");
		playerPowerNumber.setText("" + theTank.power);		

		revalidate();
		repaint();
	}



	public void paintComponent(Graphics g) {

	}

}


class CPUtankHudPanel extends JPanel {

	drawHealthPanel healthbar;
	drawFuelPanel fuelbar; 
	drawPowerPanel powerbar;

	Tank theTank;

	JLabel CPUName,
	CPUHealth, CPUHealthPercent, CPUWeapons, CPUWeaponsSlot, CPUShotTimer, 
	CPUFuel, CPUFuelNumber, CPUAngle, CPUPower, CPUPowerNumber;

	public CPUtankHudPanel(HUD hud, Tank tank) {
		theTank = tank;

		GridBagLayout tree = new GridBagLayout();
		this.setLayout(tree);

		CPUName = new JLabel(theTank.name);
		CPUHealth = new JLabel("Health: ");
		CPUHealthPercent = new JLabel("" + theTank.health + "%");
		CPUWeapons = new JLabel("Weapons: ");
		CPUWeaponsSlot = new JLabel("" + theTank.weapon);
		CPUShotTimer = new JLabel("Shot timer: " + theTank.shottimer + " sec");
		CPUFuel = new JLabel("Fuel: ");
		CPUFuelNumber = new JLabel("" + theTank.fuel);
		CPUAngle = new JLabel("Angle: " + theTank.barrelAngle);
		CPUPower = new JLabel("Power: ");
		CPUPowerNumber = new JLabel("" + theTank.power);	


		GridBagConstraints constr = new GridBagConstraints();
		constr.gridx = 0;
		constr.gridy = 0;
		constr.gridwidth = 1;
		constr.gridheight = 1;
		//constr.anchor = GridBagConstraints.EAST;
		constr.insets = new Insets(0,0,5,5);
		constr.weightx = 5;
		constr.weighty = 5;
		constr.fill = GridBagConstraints.HORIZONTAL;

		this.add(CPUName, constr);

		constr.gridx = 0; constr.gridy = 1;
		this.add(CPUHealth, constr);

		constr.gridx = 1; constr.gridy = 1;
		healthbar = new drawHealthPanel(theTank, constr);
		this.add(healthbar, constr);

		constr.gridx = 2; constr.gridy = 1;
		this.add(CPUHealthPercent, constr);

		constr.gridx = 3; constr.gridy = 1;
		this.add(CPUWeapons, constr);

		constr.gridx = 4; constr.gridy = 1;
		this.add(CPUWeaponsSlot, constr);

		constr.gridx = 5; constr.gridy = 1;
		this.add(CPUShotTimer, constr);

		constr.gridx = 0; constr.gridy = 2;
		this.add(CPUFuel, constr);

		constr.gridx = 1; constr.gridy = 2;
		fuelbar = new drawFuelPanel(theTank, constr);
		this.add(fuelbar, constr);

		constr.gridx = 2; constr.gridy = 2;
		this.add(CPUFuelNumber, constr);

		constr.gridx = 3; constr.gridy = 2;
		this.add(CPUAngle, constr);

		constr.gridx = 4; constr.gridy = 2;
		this.add(CPUPower, constr);

		constr.gridx = 5; constr.gridy = 2;
		powerbar = new drawPowerPanel(theTank, constr);
		this.add(powerbar, constr);

		constr.gridx = 6; constr.gridy = 2;
		this.add(CPUPowerNumber, constr);

	}

	public void updateHud() {
		CPUName.setText(theTank.name);
		CPUHealth.setText("Health: ");
		CPUHealthPercent.setText("" + theTank.health + "%");
		CPUWeapons.setText("Weapons: ");
		CPUWeaponsSlot.setText("" + theTank.weapon);
		CPUShotTimer.setText("Shot timer: " + theTank.shottimer + " sec");
		CPUFuel.setText("Fuel: ");
		CPUFuelNumber.setText("" + theTank.fuel);
		CPUAngle.setText("Angle: " + theTank.barrelAngle);
		CPUPower.setText("Power: ");
		CPUPowerNumber.setText("" + theTank.power);		

		revalidate();
		repaint();
	}



	public void paintComponent(Graphics g) {

	}

}




class drawHealthPanel extends JPanel {

	int width, height;
	Tank theTank;

	public drawHealthPanel(Tank tank, GridBagConstraints constr) {
		theTank = tank;
		this.setPreferredSize(new Dimension(150,20));
		width = constr.gridwidth;
		height = constr.gridheight;
		/* panel.setBackground(Color.black);
        panel.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
        panel.setPreferredSize(new Dimension(200, 200)); // for demo purposes only
		 */
		this.setBorder(BorderFactory.createLineBorder(Color.red, 1));
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.red);
		double dectankHealth = theTank.health;
		int healthbarWidth = (int) ( (dectankHealth / 100) * this.getWidth() );
		g.fillRect(0, 0, healthbarWidth, this.getHeight());
	}
}


class drawFuelPanel extends JPanel {

	int width, height;
	Tank theTank;

	public drawFuelPanel(Tank tank, GridBagConstraints constr) {
		theTank = tank;
		this.setPreferredSize(new Dimension(150,20));
		width = constr.gridwidth;
		height = constr.gridheight;
		this.setBorder(BorderFactory.createLineBorder(Color.green, 1));

	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.green);
		double dectankFuel = theTank.fuel;
		int fuelbarWidth = (int) ( (dectankFuel / 250) * this.getWidth() );
		g.fillRect(0, 0, fuelbarWidth, this.getHeight());
	}
}

class drawPowerPanel extends JPanel {

	int width, height;
	Tank theTank;

	public drawPowerPanel(Tank tank, GridBagConstraints constr) {
		theTank = tank;
		this.setPreferredSize(new Dimension(150,20));
		width = constr.gridwidth;
		height = constr.gridheight;
		this.setBorder(BorderFactory.createLineBorder(Color.black, 1));

	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		double decpower = theTank.power;
		int powerbarWidth = (int) ( (decpower / 100) * this.getWidth() );
		g.fillRect(0, 0, powerbarWidth, this.getHeight());
	}

}