package buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import maincatalog.Game;
import maincatalog.Main;
import menu.Level;
import menu.SmallMenu;

public class Medium extends JButton implements ActionListener {
	
String mediumImage = "C:\\Users\\Rudy\\eclipse-workspace\\MineSweeper\\src\\images\\MEDIUM.png";
	
	public Medium() {
		super();
		setIcon(new ImageIcon(mediumImage));
		this.addActionListener(this);
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("medium");
		Game.startNewGame(Level.MEDIUM);
	}

}
