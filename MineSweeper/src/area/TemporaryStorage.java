package area;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import menu.Level;
import menu.Menu;

public class TemporaryStorage {
	
	/*public void addToArea(int i, int j) {
		if(fields[i][j].hasEmptyNeighbor(i, j)) {
			int areaIndex = fields[i][j].checkAreaAround(i, j);
			if(areaIndex == -1) {
				areaList.add(new ArrayList<Position>());
				areaList.get(areaList.size()-1).add(new Position(i,j));
				fields[i][j].belongArea = areaList.size()-1;
			} else {
				areaList.get(areaIndex).add(new Position(i,j));
				fields[i][j].belongArea = areaIndex;
			}
		}
	}
	
	public void createAreas() {
		for(int i=0; i<fieldsHeight; i++) {
			for(int j=0; j<fieldsWidth; j++) {
				addToArea(i,j);
			}
		}
	}
	
	public static void showArea(int areaIndex) {
		Iterator<Position> it = areaList.get(areaIndex).iterator();
		while(it.hasNext()) {
		    Position current = it.next();
		    fields[current.x][current.y].setEnabled(false);
		    System.out.println(current.x +" "+current.y);
		}
	}
	
	public boolean hasEmptyNeighbor(int i, int j) {
		if(Game.fields[i][j].howManyBombsAround == 0) {
			return true;
		}
		//nad
		if(i>0) {
		    if(j>0 && Game.fields[i-1][j-1].howManyBombsAround == 0) return true;
		    if(Game.fields[i-1][j].howManyBombsAround == 0) return true;
		    if(j<Game.fields[i].length-1 && Game.fields[i-1][j+1].howManyBombsAround == 0) return true;
		}
		//pod
		if(i<Game.fields.length-1) {
			if(j>0 && Game.fields[i+1][j-1].howManyBombsAround == 0) return true;
			if(Game.fields[i+1][j].howManyBombsAround == 0) return true;
			if(j<Game.fields[i].length-1 && Game.fields[i+1][j+1].howManyBombsAround == 0) return true;
		}
		//obok
		if(j>0 && Game.fields[i][j-1].howManyBombsAround == 0) return true;
		if(j<Game.fields[i].length-1 && Game.fields[i][j+1].howManyBombsAround == 0) return true;
	    
		return false;
	}
	
	public int checkAreaAround(int i, int j) {
		if(i>0) {
		    if(j>0 && Game.fields[i-1][j-1].belongArea != -1) return Game.fields[i-1][j-1].belongArea;
		    if(Game.fields[i-1][j].belongArea != -1) return Game.fields[i-1][j].belongArea;
		    if(j<Game.fields[i].length-1 && Game.fields[i-1][j+1].belongArea != -1) return Game.fields[i-1][j+1].belongArea;
		}
		//pod
		if(i<Game.fields.length-1) {
			if(j>0 && Game.fields[i+1][j-1].belongArea != -1) return Game.fields[i+1][j-1].belongArea;
			if(Game.fields[i+1][j].belongArea != -1) return Game.fields[i+1][j].belongArea;
			if(j<Game.fields[i].length-1 && Game.fields[i+1][j+1].belongArea != -1) return Game.fields[i+1][j+1].belongArea;
		}
		//obok
		if(j>0 && Game.fields[i][j-1].belongArea != -1) return Game.fields[i][j-1].belongArea;
		if(j<Game.fields[i].length-1 && Game.fields[i][j+1].belongArea != -1) return Game.fields[i][j+1].belongArea;
	 
		return -1;
	}
	
	//lepiej utworzyæ i przeszukiwac obszary
	
	public static void lookForFreeSpace(int i, int j) {	
		if(!fields[i][j].bomb && countSurroundingBombs(i,j) == 0) {
			//fields[i][j].doClick();
			if(i>0) {
				lookForFreeSpace(i-1,j);
			}
			if(i<fields.length-1) {
				lookForFreeSpace(i+1,j);
			}
			if(j>0) {
				lookForFreeSpace(i,j-1);	
			}
			if(j<fields[i].length-1) {
				lookForFreeSpace(i,j+1);
			}
		}
		
		
	}*/

	//JMenu newgame = new JMenu("New game");
			//JMenuItem help = new JMenuItem("Help");
			//JMenuItem authors = new JMenuItem("Authors");
			//JMenuItem showfields = new JMenuItem("Show All");
			
			
			//JMenuItem newgame = new JMenuItem("New Game");
			//JMenuItem back = new JMenuItem("Back to menu");
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
			showfields.addMouseListener(new ShowFieldsMListener());
			newgame.addMouseListener(new StartGameMListener());
			help.addMouseListener(new HelpMListener());
			back.addMouseListener(new BackMListener());
			//authors.addMouseListener(new AuthorsMListener());
			
			newgame.setToolTipText("Ustawienia gry");
			help.setToolTipText("Pomoc");
			//authors.setToolTipText("Autorzy");
			showfields.setToolTipText("Zobacz wszystkie pola");
			back.setToolTipText("Powrot do menu glownego");
			
	        this.add(newgame);
	        this.add(help);
	       // this.add(authors);
	        this.add(showfields);
	        this.add(back); */
	
	/*
	 * public static final int WIDTH = 631;  //656  25 fields 6 pikseli rezerwy
	public static final int HEIGHT = 510; //     20 fields; 18 realnie (menu i ramka u góry) 62 piksele rezerwy
	//631/25 = 25,24      510/25 = 20,4
	public static JFrame frame = new JFrame();
	public static Menu menu = new Menu();
	public static Level level;
	 */
	  
}
