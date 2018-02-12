package maincatalog;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

import menu.Level;
import menu.Menu;

public class Main {
	public static final int WIDTH = 631;  
	public static final int HEIGHT = 510;
	public static JFrame frame = new JFrame();
	public static Menu menu = new Menu();
	public static Level level;
	
	public static void main(String args[]){
		//frame.pack();
		/*try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {}
		*/
		
		/*try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) {}
		*/
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setTitle("Minesweeper");
		frame.setIconImage(new ImageIcon("C:\\Users\\Rudy\\eclipse-workspace\\MineSweeper\\src\\images\\Bomb2.png").getImage());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(menu);
		frame.setVisible(true);

	}
}
