package buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import maincatalog.Main;
import menu.Menu;
import menu.NewGamePanel;

public class Back extends JButton implements ActionListener {
	
	String backImage = "C:\\Users\\Rudy\\eclipse-workspace\\MineSweeper\\src\\images\\BACK.png";
	
	public Back() {
		super();
		setIcon(new ImageIcon(backImage));
		this.addActionListener(this);
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("back");
		NewGamePanel.backToMenu();
	}

}
