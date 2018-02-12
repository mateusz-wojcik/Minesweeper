package maincatalog;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import menu.Level;
import menu.SmallMenu;

public class Game extends JPanel{
	
	String path = "C:\\Users\\Rudy\\eclipse-workspace\\MineSweeper\\src\\images\\";
	static boolean isFirstClick = true;
	static int fieldsHeight; // = Main.HEIGHT/fieldsHeightNumber; //18;
	static int fieldsWidth; // = Main.WIDTH/fieldsWidthNumber; //25;
	static int howManyBombs;
	static int fieldsLeft;
	static int firstClickX;
	static int firstClickY;
	public static Field[][] fields; //first -> height, second -> width
	static List<List<Position>> areaList;
	
	@Deprecated
	public Game(){
		fields = new Field[fieldsHeight][fieldsWidth];
		constructFields();
		setDisableIcons();
		createAreas();
		pointButton();
		this.setLayout(new FlowLayout(0,0,0));
		System.out.println("Bombs: " + howManyBombs);
	}
	
	public Game(int fieldsNewHeight, int fieldsNewWidth, int frameHeight, int frameWidth) {
		initializeStaticFields(0,-1,-1, fieldsNewHeight, fieldsNewWidth);
		constructFields();
		setDisableIcons();
		createAreas();
		pointButton();
		setFieldsLeft();
		this.setLayout(new FlowLayout(0,0,0));
		System.out.println("Bombs: " + howManyBombs);
		System.out.println("Fields left: " + fieldsLeft);
	}
	
	public static void startNewGame(Level level) {
		Main.frame.getContentPane().removeAll();
		Game newGame;
		switch(level) {
		case EASY:
			newGame = new Game(10,10,312,256);
			Main.frame.add(newGame);
			Main.frame.setSize(256,312);
			Main.level = Level.EASY;
			break;
		case MEDIUM:
			newGame = new Game(15,15,437,381);
			Main.frame.add(newGame);
			Main.frame.setSize(381, 437);
			Main.level = Level.MEDIUM;
			break;
		case HARD:
			newGame = new Game(18,20,562,506);
			Main.frame.add(newGame);
			Main.frame.setSize(506, 512);
			Main.level = Level.HARD;
			break;
		case INSANE:
			newGame = new Game(18,25,631,510);
			Main.frame.add(newGame);
			Main.frame.setSize(631, 510);
			Main.level = Level.INSANE;
			break;
		}
		Main.frame.setJMenuBar(new SmallMenu());
		Main.frame.revalidate();
		Main.frame.repaint();
	}
	
	public static void startNewGame(int fwn, int fhn, int fh, int fw) {
		Main.frame.getContentPane().remove(0);
		Game game = new Game(fwn,fhn,fh,fw);
		Main.frame.add(game);
		Main.frame.setSize(fw, fh);
		Main.frame.setJMenuBar(new SmallMenu());
		Main.frame.revalidate();
		Main.frame.repaint();
	}
	
	public void initializeStaticFields(int howManyBombs, int firstClickX, int firstClickY, int fieldsHeight, int fieldsWidth) {
		Game.howManyBombs = howManyBombs; //default 0
		Game.fieldsLeft = fieldsHeight * fieldsWidth; //default 0
		Game.firstClickX = firstClickX; // default -1
		Game.firstClickY = firstClickY; //default -1
		Game.fieldsHeight = fieldsHeight;
		Game.fieldsWidth = fieldsWidth;
		Game.fields = new Field[fieldsHeight][fieldsWidth];
		areaList = new ArrayList<List<Position>>(); //new List
	}
	
	public void constructFields(){
		for(int i=0; i<fieldsHeight; i++){
			for(int j=0; j<fieldsWidth; j++){
				fields[i][j] = new Field(i,j,0);
				this.add(fields[i][j]);
			}
		}
	}
	
	public void setDisableIcons() {
		for(int i=0; i<fieldsHeight; i++){
			for(int j=0; j<fieldsWidth; j++){
				if(fields[i][j].bomb) {
					 fields[i][j].setDisabledIcon(new ImageIcon(path+"bomb.png"));
					 //fields[i][j].setBackground(Color.RED);
				} else {					
					int number = Field.countSurroundingBombs(i,j);
					if(number>0) {
						fields[i][j].setDisabledIcon(new ImageIcon(path+number+".png"));
					    fields[i][j].howManyBombsAround = number;
					}
				}
			}
		}
	}
	
	public void pointButton() {
		//fields[getEmptyPosition().x][getEmptyPosition().y].setBorder(new LineBorder(Color.lightGray, 13));
		fields[getEmptyPosition().x][getEmptyPosition().y].setIcon(new ImageIcon("C:\\Users\\Rudy\\eclipse-workspace\\MineSweeper\\src\\images\\animation.gif"));
	}
	
	public void addToArea(int i, int j) {
		if(hasEmptyNeighbor(i, j)) {
			int areaIndex = checkAreaAround(i, j);
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
	
	public static Position getEmptyPosition() {
		for(Position p : areaList.get(findLongestAL())) {
			if(fields[p.x][p.y].howManyBombsAround == 0) return p;
		}
		return null;
	}
	
	public static int findLongestAL() {
		int max = 0;
		int index = 0;
		for(List<Position> al : areaList) {
			int current = countEmptyFieldsInArea(al);
			if(current > max) {
				max = current;
				index = areaList.indexOf(al);
			}
		}
		return index;
	}
	
	  public static int countEmptyFieldsInArea(List<Position> list) {
	    	int suma = 0;
	    	for(Position p: list) {
	    		//System.out.println(p.x + " " + p.y);
	    		if(fields[p.x][p.y].howManyBombsAround == 0) suma++;
	    	}
	    	return suma;
	    }
	
	public static void showAllAreas() {
		for(List<Position> al: areaList) {
			//System.out.println("------------------");
			for(Position ls: al) {
				//System.out.println(ls.x + " " + ls.y);
			}
		}
	}
	
	public static void showAllAreas2() {
		for(Field[] f: fields) {
			for(Field fl: f) {
				//System.out.println(fl.i + " " + fl.j + " " + fl.belongArea);
			}
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
	
	public void createAreas() {
		for(int i=0; i<fieldsHeight; i++) {
			for(int j=0; j<fieldsWidth; j++) {
				addToArea(i,j);
			}
		}
	}

	public static void disableAll() {
		for(int i=0; i<Game.fields.length; i++) {
			for(int j=0; j<Game.fields[i].length; j++) {
				Game.fields[i][j].setEnabled(false);
			}
		}
	}

    public static void setAllHidden() {
    	for(int i=0; i<Game.fields.length; i++) {
			for(int j=0; j<Game.fields[i].length; j++) {
				Game.fields[i][j].hidden = true;
			}
		}
    }

    public static void showBombs(){
    	for(int i=0; i<Game.fields.length; i++) {
			for(int j=0; j<Game.fields[i].length; j++) {
				if(Game.fields[i][j].bomb) Game.fields[i][j].setEnabled(false);;
			}
		}
    } 
    
    public boolean isAllEnabled() {
    	for(Field[] f : Game.fields) {
    		for(Field ff: f) {
    			if(!ff.bomb && ff.isEnabled()) return false;
    		}
    	}
    	return true;
    }
    
    public void setFieldsLeft() {
        Game.fieldsLeft = Game.fieldsHeight * Game.fieldsWidth - Game.howManyBombs;
    }
    
    public static boolean isGameEnd()
    {
    	return fieldsLeft == 0;
    }
}
