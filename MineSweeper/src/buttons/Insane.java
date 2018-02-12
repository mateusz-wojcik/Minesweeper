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

public class Insane extends JButton implements ActionListener {

   String insaneImage = "C:\\Users\\Rudy\\eclipse-workspace\\MineSweeper\\src\\images\\INSANE.png";
	
	public Insane() {
		super();
		setIcon(new ImageIcon(insaneImage));
		this.addActionListener(this);
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Game.startNewGame(Level.INSANE);
	}
}
