package menu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import buttons.Back;
import buttons.Easy;
import buttons.Hard;
import buttons.Insane;
import buttons.Medium;
import maincatalog.Main;

public class NewGamePanel extends JPanel {
	
	String panel = "/images/Minesweeper_newgame.png";
	Back back = new Back();
	Easy easy = new Easy();
	Medium medium = new Medium();
	Hard hard = new Hard();
	Insane insane = new Insane();
	
	public NewGamePanel() {
		setLayout(null);
		addAllButtons();
	}
	
	public void addAllButtons() {
		back.setLayout(null);
		easy.setLayout(null);
		medium.setLayout(null);
		hard.setLayout(null);
		insane.setLayout(null);
	    back.setBounds(30, 360, 130, 34);
	    easy.setBounds(30, 180, 130, 34);
	    medium.setBounds(30, 220, 130, 34);
	    hard.setBounds(30, 260, 130, 34);
	    insane.setBounds(30, 300, 130, 34);
		add(back);
		add(easy);
		add(medium);
		add(hard);
		add(insane);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    	g2d.drawImage(getBackgroundImage(), -9, -5, this);
	}
	
	public Image getBackgroundImage(){
		ImageIcon i = new ImageIcon(getClass().getResource(panel));
		return i.getImage();
	}
	
	public static void backToMenu() {
		Main.frame.getContentPane().removeAll();
		Main.frame.add(new Menu());
		Main.frame.setSize(Main.WIDTH, Main.HEIGHT);
		Main.frame.revalidate();
	}
	
}
