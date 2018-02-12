package buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Authors extends JButton implements ActionListener {
	
    String authorsImage = "C:\\Users\\Rudy\\eclipse-workspace\\MineSweeper\\src\\images\\AUTHORS.png";
	
	public Authors() {
		super();
		setIcon(new ImageIcon(authorsImage));
		this.addActionListener(this);
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("ez");
		
	}

}
