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
	JPanel cputankHud;

	public HUD(Tank newtank, playertankHudPanel playertankHud){
		theTank=newtank;
		this.setPreferredSize(new Dimension(1200,100));
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(playertankHud);

	}

	public void paintComponent(Graphics g) {

	}

}

class playertankHudPanel extends JPanel {

	drawHealthPanel healthbar;
	drawFuelPanel fuelbar;

	Tank theTank;

	JLabel playerName,
	playerHealth, playerHealthPercent, playerWeapons, playerShotTimer, 
	playerFuel, playerFuelNumber, playerAngle, playerPower, playerPowerNumber;

	JLabel cpuName,
	cpuHealth,cpuHealthPercent,cpuWeapons,cpuShotTimer,
	cpuFuel,cpuFuelNumber, cpuAngle, cpuPower, cpuPowerNumber;

	public playertankHudPanel(HUD hud, Tank tank) {
		theTank = tank;
		this.setLayout(new GridBagLayout());

		playerName = new JLabel(theTank.name);
		playerHealth = new JLabel("Health: ");
		playerHealthPercent = new JLabel("" + theTank.health + "%");
		playerWeapons = new JLabel("Weapons: ");
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
		constr.anchor = GridBagConstraints.EAST;
		constr.insets = new Insets(0,0,5,5);
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.fill = GridBagConstraints.NONE;

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

		constr.gridx = 5; constr.gridy = 1;
		this.add(playerShotTimer, constr);

		constr.gridx = 0; constr.gridy = 2;
		this.add(playerFuel, constr);

		constr.gridx = 1; constr.gridy = 2;
		fuelbar = new drawFuelPanel(theTank, constr);
		this.add(fuelbar, constr);

		constr.anchor = GridBagConstraints.WEST;
		constr.gridx = 2; constr.gridy = 2;
		this.add(playerFuelNumber, constr);

		constr.gridx = 3; constr.gridy = 2;
		this.add(playerAngle, constr);

		constr.gridx = 4; constr.gridy = 2;
		this.add(playerPower, constr);

		constr.gridx = 6; constr.gridy = 2;
		this.add(playerPowerNumber, constr);
	}

	public void updateHud() {
		playerName.setText(theTank.name);
		playerHealth.setText("Health: ");
		playerHealthPercent.setText("" + theTank.health + "%");
		playerWeapons.setText("Weapons: ");
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