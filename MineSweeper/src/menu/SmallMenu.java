package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import maincatalog.Game;
import maincatalog.Main;

public class SmallMenu extends JMenuBar{
	
	public SmallMenu(){
		
		JMenu game = new JMenu("Game");
		JMenu back = new JMenu("Back to menu");
		
		JMenuItem newgame = new JMenuItem("New Game");
		JMenuItem help = new JMenuItem("Help");
		JMenuItem showfields = new JMenuItem("Show All");

		
		//JMenuItem pause = new JMenuItem("Pause");
		/*JMenuItem scores = new JMenuItem("Scores");
		JMenuItem exit = new JMenuItem("Exit");
		game.add(newgame);
		game.add(pause);
		game.add(scores);
		game.add(exit);
		newgame.setSize(getPreferredSize());
		help.setSize(getPreferredSize());
		
		back.setSize(getPreferredSize());
		help.addMouseListener(new HelpMListener());
		//authors.addMouseListener(new AuthorsMListener());
		
		newgame.setToolTipText("Ustawienia gry");
		help.setToolTipText("Pomoc");
		//authors.setToolTipText("Autorzy");
		showfields.setToolTipText("Zobacz wszystkie pola");
		back.setToolTipText("Powrot do menu glownego");
		*/
		
		newgame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Game.startNewGame(Main.level);
			}
		});
		
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				//Object[] options = {"Rozumiem", "Ne rosume" };
				//JOptionPane.showOptionDialog(null, "Wszystko jak w normalnym saperze", "Help", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				try {
					Runtime.getRuntime().exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe \"http://gra-saper.pl/zasady\"");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		help.setToolTipText("Click to see the rules");
		
		showfields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Game.disableAll();
			}
		});
		
		back.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				NewGamePanel.backToMenu();
				back.setSelected(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		back.setToolTipText("Back to main menu");
		
		game.add(newgame);
		game.add(help);
		game.add(showfields);
		
		this.add(game);
        this.add(back);
		
        //this.setLayout(new FlowLayout(FlowLayout.LEADING,0,1));
	}
}
