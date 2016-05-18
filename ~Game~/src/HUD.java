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
		this.setLayout(new BorderLayout());
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
	drawShotTimerPanel shottimerbar;

	Tank theTank;

	JLabel playerName,
	playerHealth, playerWeapons, playerShotTimer, 
	playerFuel, playerAngle, playerPower;

	public playertankHudPanel(HUD hud, Tank tank) {
		theTank = tank;

		this.setLayout(new GridBagLayout());

		playerName = new JLabel(theTank.name);
		playerHealth = new JLabel("Health: ");
		playerWeapons = new JLabel("Weapons: " + theTank.weapon);
		playerShotTimer = new JLabel("Shot timer: " + theTank.shottimer + " sec");
		playerFuel = new JLabel("Fuel: ");
		playerAngle = new JLabel("Angle: " + theTank.barrelAngle);
		playerPower = new JLabel("Power: ");

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
		this.add(playerWeapons, constr);

		constr.gridx = 3; constr.gridy = 1;
		this.add(playerShotTimer, constr);

		constr.gridx = 4; constr.gridy = 1;
		shottimerbar = new drawShotTimerPanel(theTank, constr);
		this.add(shottimerbar, constr);

		constr.gridx = 0; constr.gridy = 2;
		this.add(playerFuel, constr);

		constr.gridx = 1; constr.gridy = 2;
		fuelbar = new drawFuelPanel(theTank, constr);
		this.add(fuelbar, constr);

		constr.gridx = 2; constr.gridy = 2;
		this.add(playerAngle, constr);

		constr.gridx = 3; constr.gridy = 2;
		this.add(playerPower, constr);

		constr.gridx = 4; constr.gridy = 2;
		powerbar = new drawPowerPanel(theTank, constr);
		this.add(powerbar, constr);

	}

	public void updateHud() {
		playerName.setText(theTank.name);
		playerHealth.setText("Health: ");
		playerWeapons.setText("Weapons: " + theTank.weapon);
		playerShotTimer.setText("Shot timer: ");
		playerFuel.setText("Fuel: ");
		playerAngle.setText("Angle: " + theTank.barrelAngle);
		playerPower.setText("Power: ");

	}



	public void paintComponent(Graphics g) {

	}

}


class CPUtankHudPanel extends JPanel {

	drawHealthPanel healthbar;
	drawFuelPanel fuelbar; 
	drawPowerPanel powerbar;
	drawShotTimerPanel shottimerbar;

	Tank theTank;

	JLabel CPUName,
	CPUHealth, CPUWeapons, CPUShotTimer,
	CPUFuel, CPUAngle, CPUPower;

	JProgressBar shottimerprogressbar;

	int intMaxShotTimer, intShotTimer;

	public CPUtankHudPanel(HUD hud, Tank tank) {
		theTank = tank;

		intMaxShotTimer = (int) theTank.maxshottimer;
		intShotTimer = (int) theTank.shottimer;

		this.setLayout(new GridBagLayout());

		CPUName = new JLabel(theTank.name);
		CPUHealth = new JLabel("Health: ");
		CPUWeapons = new JLabel("Weapons: " + theTank.weapon);
		CPUShotTimer = new JLabel("Shot timer: ");
		CPUFuel = new JLabel("Fuel: ");
		CPUAngle = new JLabel("Angle: " + theTank.barrelAngle);
		CPUPower = new JLabel("Power: ");

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
		this.add(CPUWeapons, constr);

		constr.gridx = 3; constr.gridy = 1;
		this.add(CPUShotTimer, constr);

		constr.gridx = 4; constr.gridy = 1;
		shottimerbar = new drawShotTimerPanel(theTank, constr);
		this.add(shottimerbar, constr);

		constr.gridx = 0; constr.gridy = 2;
		this.add(CPUFuel, constr);

		constr.gridx = 1; constr.gridy = 2;
		fuelbar = new drawFuelPanel(theTank, constr);
		this.add(fuelbar, constr);

		constr.gridx = 2; constr.gridy = 2;
		this.add(CPUAngle, constr);

		constr.gridx = 3; constr.gridy = 2;
		this.add(CPUPower, constr);

		constr.gridx = 4; constr.gridy = 2;
		powerbar = new drawPowerPanel(theTank, constr);
		this.add(powerbar, constr);

	}

	public void updateHud() {

		intMaxShotTimer = (int) theTank.maxshottimer;
		intShotTimer = (int) theTank.shottimer;

		CPUName.setText(theTank.name);
		CPUHealth.setText("Health: ");
		CPUWeapons.setText("Weapons: " + theTank.weapon);
		CPUFuel.setText("Fuel: ");
		CPUAngle.setText("Angle: " + theTank.barrelAngle);
		CPUPower.setText("Power: ");

	}



	public void paintComponent(Graphics g) {

	}

}


class drawHealthPanel extends JPanel {

	int width, height;
	Tank theTank;

	JLabel healthLabel = new JLabel();

	public drawHealthPanel(Tank tank, GridBagConstraints constr) {
		theTank = tank;
		this.setPreferredSize(new Dimension(150,20));
		this.setBorder(BorderFactory.createLineBorder(Color.red, 1));
		this.add(healthLabel);
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.red);
		double dectankHealth = theTank.health;
		int healthbarWidth = (int) ( (dectankHealth / 100) * this.getWidth() );
		g.fillRect(0, 0, healthbarWidth, this.getHeight());
		healthLabel.setText("" + theTank.health);
	}
}


class drawFuelPanel extends JPanel {

	int width, height;
	Tank theTank;

	JLabel fuelLabel = new JLabel();

	public drawFuelPanel(Tank tank, GridBagConstraints constr) {
		theTank = tank;
		this.setPreferredSize(new Dimension(150,20));
		this.setBorder(BorderFactory.createLineBorder(Color.green, 1));
		this.add(fuelLabel);

	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.green);
		double dectankFuel = theTank.fuel;
		int fuelbarWidth = (int) ( (dectankFuel / 250) * this.getWidth() );
		g.fillRect(0, 0, fuelbarWidth, this.getHeight());
		fuelLabel.setText("" + theTank.fuel);
	}
}

class drawPowerPanel extends JPanel {

	int width, height;
	Tank theTank;

	JLabel powerLabel = new JLabel();

	public drawPowerPanel(Tank tank, GridBagConstraints constr) {
		theTank = tank;
		this.setPreferredSize(new Dimension(150,20));
		this.setBorder(BorderFactory.createLineBorder(Color.pink, 1));
		this.add(powerLabel);

	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.pink);
		double decpower = theTank.power;
		int powerbarWidth = (int) ( (decpower / 100) * this.getWidth() );
		g.fillRect(0, 0, powerbarWidth, this.getHeight());
		powerLabel.setText("" + theTank.power);
	}

}


class drawShotTimerPanel extends JPanel {

	int width, height;
	Tank theTank;

	int intMaxShotTimer;
	int intShotTimer;
	JLabel shotTimerLabel = new JLabel();

	public drawShotTimerPanel(Tank tank, GridBagConstraints constr) {
		theTank = tank;
		this.setPreferredSize(new Dimension(150,20));
		this.setBorder(BorderFactory.createLineBorder(Color.orange, 1));
		this.add(shotTimerLabel);

	}

	public void paintComponent(Graphics g) {

		intMaxShotTimer = (int) theTank.maxshottimer;
		intShotTimer = (int) theTank.shottimer;

		g.setColor(Color.orange);
		double decpower = theTank.shottimer;
		int shottimerbarWidth = (int) ( (decpower / intMaxShotTimer) * this.getWidth() );
		g.fillRect(0, 0, shottimerbarWidth, this.getHeight());
		shotTimerLabel.setText("" + intShotTimer);

	}

}




