package menu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import buttons.Authors;
import buttons.NewGame;
import buttons.Quit;
import maincatalog.Game;
import maincatalog.Main;

public class Menu extends JPanel {
	
	String background = "/images/Minesweeper_glassy.png";
	Authors authors = new Authors();
	NewGame newGame = new NewGame();
	Quit quit = new Quit();
	
	public Menu() {
		setLayout(null);
		addAllButtons();
	}
	
	public void addAllButtons() {
		authors.setLayout(null);
		newGame.setLayout(null);
		quit.setLayout(null);
		authors.setBounds(30, 230, 130, 34);
		newGame.setBounds(30, 190, 130, 34);
		quit.setBounds(30, 270, 130, 34);
		add(authors);
		add(newGame);
		add(quit);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(getBackgroundImage(), -9, -5, this);
	}
	
	public Image getBackgroundImage(){
		ImageIcon i = new ImageIcon(getClass().getResource(background));
		return i.getImage();
	}

}