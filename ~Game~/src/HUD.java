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
		
		theTank=newtank;
		
		this.setPreferredSize(new Dimension(1200,100));

		this.setLayout(new FlowLayout(FlowLayout.LEFT));

		//this.setLayout(new BorderLayout());

		//playertankHud.setLayout(new GridLayout(3,7,10,10));
		//cputankHud.setLayout(new GridLayout(3,7,10,10));

		//this.setLayout(new GridBagLayout());
		playertankHud = new playertankHudPanel(theTank);

		//this.add(BorderLayout.WEST, playertankHud);

		this.add(playertankHud);
		

		//this.add(BorderLayout.EAST, cputankHud);


	}

	public void paintComponent(Graphics g) {

		System.out.println("In hud paintcom");

		g.setColor(Color.red);

		//playertankHud.paintComponent.fillRect(playertankHud.getLocation().x, playertankHud.getLocation().y, playertankHud.getWidth(), playertankHud.getHeight());

		//g.fillRect(this.getLocation().x, this.getLocation().y, 700, 40);

		//g.fillOval(600,30,60,60);

		//g.fillRect(60, 60, 10, 10);

		//g.fillRect(100, 40, 40, 40);

	}

}



class playertankHudPanel extends JPanel {

	drawHealth healthbar;

	Tank theTank;

	public playertankHudPanel(Tank tank) {

		theTank = tank;

		this.setLayout(new GridBagLayout());

		GridBagConstraints constr = new GridBagConstraints();
		constr.gridx = 0;
		constr.gridy = 0;
		constr.gridwidth = 1;
		constr.gridheight = 1;
		//constr.anchor = GridBagConstraints.FIRST_LINE_START;
		constr.anchor = GridBagConstraints.EAST;
		constr.insets = new Insets(0,0,5,5);
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		constr.fill = GridBagConstraints.NONE;

		//playerName = new JLabel(theTank.name);

		//this.add(playerName);

		System.out.println("Tank name: " + theTank.name);
		
		this.add(new JLabel(theTank.name), constr);

		constr.gridx = 0; constr.gridy = 1;
		this.add(new JLabel("Health: "), constr);



		//constr.fill = GridBagConstraints.HORIZONTAL;
		//constr.gridwidth = 4; constr.gridheight = 1;
		constr.gridx = 1; constr.gridy = 1;
		healthbar = new drawHealth(theTank, constr);

		this.add(healthbar, constr);



		constr.gridwidth = 1; constr.gridheight = 1;
		constr.gridx = 2; constr.gridy = 1;
		this.add(new JLabel("" + theTank.health + "%"), constr);

		System.out.println("First constrw " + constr.gridwidth );

		constr.gridx = 3; constr.gridy = 1;
		this.add(new JLabel("Weapons: "), constr);

		constr.gridx = 5; constr.gridy = 1;
		this.add(new JLabel("Shot timer: " + theTank.shottimer + " sec"), constr);

		constr.gridx = 0; constr.gridy = 2;
		this.add(new JLabel("Fuel: "), constr);


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


		g.setColor(Color.red);



		//g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());

	}


}



class drawHealth extends JPanel {

	int width, height;

	Tank theTank;

	public drawHealth(Tank tank, GridBagConstraints constr) {

		theTank = tank;

		this.setPreferredSize(new Dimension(150,20));

		width = constr.gridwidth;

		height = constr.gridheight;

		/*
		 *  panel.setBackground(Color.black);
        panel.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
        panel.setPreferredSize(new Dimension(200, 200)); // for demo purposes only
		 */

		this.setBorder(BorderFactory.createLineBorder(Color.red, 5));

	}

	public void paintComponent(Graphics g) {

		System.out.println("In drawHealth paintcom");

		g.setColor(Color.red);

		System.out.println("theTank.health " + theTank.health);

		double dectankHealth = theTank.health;

		int healthbarWidth = (int) ( (dectankHealth / 100) * this.getWidth() );

		Rectangle healthbar = new Rectangle();
		healthbar.setBounds(0, 0, healthbarWidth, this.getHeight());


		g.fillRect(0, 0, healthbarWidth, this.getHeight());





	}

}
