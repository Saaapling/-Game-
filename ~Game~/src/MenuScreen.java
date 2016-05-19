import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuScreen implements ActionListener {

	JFrame frame;
	JPanel panel;
	JLabel intro;
	JButton button1;
	JButton button2;
	JButton button3;
	Tester game;

	public MenuScreen(){
		frame= new JFrame("Tanks");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		panel=new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		
		intro=new JLabel("Welcome to the game of Tanks.");
		intro.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.add(intro);
		
		button1=new JButton("Play");
		button1.setActionCommand("Play");
		button1.addActionListener(this);
		panel.add(button1);
		button2=new JButton("Instructions");
		button2.setActionCommand("Instructions");
		button2.addActionListener(this);
		panel.add(button2);
		button3=new JButton("Weapon Catalog");
		button3.setActionCommand("Weapon Catalog");
		button3.addActionListener(this);
		panel.add(button3);
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		String eventName=event.getActionCommand();
		if (eventName.equals("Play")){
			game=new Tester();
		}else if(eventName.equals("Instructions")){

		}else if(eventName.equals("Weapon Catalog")){

		}
	}

	private static void runGUI(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		MenuScreen test=new MenuScreen();
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                              

	public static void main(String[]args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				runGUI();
			}
		});
	}

}
