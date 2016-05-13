
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class HUD extends JPanel{

	Tank theTank; 
	playertankHudPanel playertankHud;
	JPanel cputankHud;

	JLabel playerName,
	playerHealth, playerHealthPercent, playerWeapons, playerShotTimer, 
	playerFuel, playerFuelNumber, playerAngle, playerPower, playerPowerNumber;

	JLabel cpuName,
	cpuHealth,cpuHealthPercent,cpuWeapons,cpuShotTimer,
	cpuFuel,cpuFuelNumber, cpuAngle, cpuPower, cpuPowerNumber;

	public HUD(Tank newtank){
		System.out.println("b");
		theTank=newtank;
		
		this.setPreferredSize(new Dimension(1200,100));
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		playertankHud = new playertankHudPanel(theTank);
		this.add(playertankHud);
	}

	public void paintComponent(Graphics g) {

	}

}

class playertankHudPanel extends JPanel {

	drawHealthPanel healthbar;
	drawFuelPanel fuelbar;

	Tank theTank;

	public playertankHudPanel(Tank tank) {
		System.out.println("c");
		theTank = tank;
		
		this.setLayout(new GridBagLayout());

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

		this.add(new JLabel(theTank.name), constr);

		constr.gridx = 0; constr.gridy = 1;
		this.add(new JLabel("Health: "), constr);

		constr.gridx = 1; constr.gridy = 1;
		healthbar = new drawHealthPanel(theTank, constr);
		this.add(healthbar, constr);

		constr.gridx = 2; constr.gridy = 1;
		this.add(new JLabel("" + theTank.health + "%"), constr);

		constr.gridx = 3; constr.gridy = 1;
		this.add(new JLabel("Weapons: "), constr);

		constr.gridx = 5; constr.gridy = 1;
		this.add(new JLabel("Shot timer: " + theTank.shottimer + " sec"), constr);

		constr.gridx = 0; constr.gridy = 2;
		this.add(new JLabel("Fuel: "), constr);

		constr.gridx = 1; constr.gridy = 2;
		fuelbar = new drawFuelPanel(theTank, constr);
		this.add(fuelbar, constr);

		constr.anchor = GridBagConstraints.WEST;
		constr.gridx = 2; constr.gridy = 2;
		this.add(new JLabel("" + theTank.fuel), constr);

		constr.gridx = 3; constr.gridy = 2;
		this.add(new JLabel("Angle: " + theTank.barrelAngle), constr);

		constr.gridx = 4; constr.gridy = 2;
		this.add(new JLabel("Power: "), constr);

		constr.gridx = 6; constr.gridy = 2;
		this.add(new JLabel("" + theTank.power), constr);

	}

	public void paintComponent(Graphics g) {

	}


}



class drawHealthPanel extends JPanel {

	int width, height;

	Tank theTank;

	public drawHealthPanel(Tank tank, GridBagConstraints constr) {
		System.out.println("d");
		theTank = tank;
		this.setPreferredSize(new Dimension(150,20));
		width = constr.gridwidth;
		height = constr.gridheight;

		/*
		 *  panel.setBackground(Color.black);
        panel.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
        panel.setPreferredSize(new Dimension(200, 200)); // for demo purposes only
		 */

		this.setBorder(BorderFactory.createLineBorder(Color.red, 1));

	}

	public void paintComponent(Graphics g) {
		System.out.println("a");
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
		System.out.println("e");
		theTank = tank;
		this.setPreferredSize(new Dimension(150,20));
		width = constr.gridwidth;
		height = constr.gridheight;
		this.setBorder(BorderFactory.createLineBorder(Color.green, 1));

	}

	public void paintComponent(Graphics g) {
		System.out.println("f");
		g.setColor(Color.green);
		double dectankFuel = theTank.fuel;
		int fuelbarWidth = (int) ( (dectankFuel / 250) * this.getWidth() );
		g.fillRect(0, 0, fuelbarWidth, this.getHeight());

	}

}