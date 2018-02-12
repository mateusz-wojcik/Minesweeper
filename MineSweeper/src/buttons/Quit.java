package buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import maincatalog.Main;

public class Quit extends JButton implements ActionListener {
	
    String quitImage = "C:\\Users\\Rudy\\eclipse-workspace\\MineSweeper\\src\\images\\QUIT.png";
	
	public Quit() {
		super();
		setIcon(new ImageIcon(quitImage));
		this.addActionListener(this);
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure?", "Quit", JOptionPane.YES_NO_OPTION);
		if(confirmed == JOptionPane.YES_OPTION) {
			Main.frame.dispatchEvent(new WindowEvent(Main.frame, WindowEvent.WINDOW_CLOSING));
		}
	}

}
