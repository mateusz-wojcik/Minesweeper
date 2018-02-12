package buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import maincatalog.Game;
import maincatalog.Main;
import menu.Level;

public class Easy extends JButton implements ActionListener {
	
    String easyImage = "C:\\Users\\Rudy\\eclipse-workspace\\MineSweeper\\src\\images\\EASY.png";
	
	public Easy() {
		super();
		setIcon(new ImageIcon(easyImage));
		this.addActionListener(this);
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("ez");
		Game.startNewGame(Level.EASY);
	    //Game.startNewGame(Main.level);
	}
}
