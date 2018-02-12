package buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import maincatalog.Main;
import menu.NewGamePanel;
import menu.SmallMenu;

public class NewGame extends JButton implements ActionListener {
	
	String newGameImage = "C:\\Users\\Rudy\\eclipse-workspace\\MineSweeper\\src\\images\\NEWGAME.png";
		
	public NewGame() {
	    super();
		setIcon(new ImageIcon(newGameImage));
		this.addActionListener(this);
	}

	@Override
	public Dimension getPreferredSize(){
		return new Dimension(this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Main.frame.getContentPane().removeAll();
		Main.frame.add(new NewGamePanel());
		Main.frame.revalidate();
	}
	
}
