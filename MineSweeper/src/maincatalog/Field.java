package maincatalog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Field extends JButton implements MouseListener {
	
	int i,j;
	boolean hidden;
	int howManyBombsAround = 0;
	int belongArea = -1;
	//boolean discovered;
	boolean bomb;
	Random r = new Random();
	
	public Field(int i, int j, int bombsAround){
		super();
		setIcon(new ImageIcon("C:\\Users\\Rudy\\eclipse-workspace\\MineSweeper\\src\\images\\Undiscovered_field2.png"));
		setDisabledIcon(new ImageIcon(""));
		addMouseListener(this);
		setMargin(new Insets(1,1,1,1));
		howManyBombsAround = bombsAround;
		this.i = i;
		this.j = j;
		if(r.nextInt(5) == 1) { // if field is a bomb
			Game.howManyBombs++;
			bomb = true;
			howManyBombsAround = -1;
		}
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}
	
	public static int countSurroundingBombs(int i, int j) {
		int count = 0;
		//nad
		if(i>0) {
			if(j>0 && Game.fields[i-1][j-1].bomb) count++;
			if(Game.fields[i-1][j].bomb) count++;
			if(j<Game.fields[i].length-1 && Game.fields[i-1][j+1].bomb) count++;
		}
		//pod
		if(i<Game.fields.length-1) {
			if(j>0 && Game.fields[i+1][j-1].bomb) count++;
			if(Game.fields[i+1][j].bomb) count++;
			if(j<Game.fields[i].length-1 && Game.fields[i+1][j+1].bomb) count++;
		}
		//obok
		if(j>0 && Game.fields[i][j-1].bomb) count++;
		if(j<Game.fields[i].length-1 && Game.fields[i][j+1].bomb) count++;
		
		return count;
	}
	
	public void showEmptyFieldsAndNeighbors(int i, int j){ //for empty field
		Game.fields[i][j].setEnabled(false);
		Game.fieldsLeft--;
		//nad
		if(i>0) {
		    if(j>0 && Game.fields[i-1][j-1].howManyBombsAround == 0 && Game.fields[i-1][j-1].isEnabled()) {
		    	showEmptyFieldsAndNeighbors(i-1,j-1);
		    	Game.fields[i-1][j-1].setEnabled(false);
		    	Game.fieldsLeft--;
		    }
		    if(Game.fields[i-1][j].howManyBombsAround == 0 && Game.fields[i-1][j].isEnabled()) {
		    	showEmptyFieldsAndNeighbors(i-1,j);
		    	Game.fields[i-1][j].setEnabled(false);
		    	Game.fieldsLeft--;
		    }
		    if(j<Game.fields[i].length-1 && Game.fields[i-1][j+1].howManyBombsAround == 0 && Game.fields[i-1][j+1].isEnabled()) {
		    	showEmptyFieldsAndNeighbors(i-1,j+1);
		    	Game.fields[i-1][j+1].setEnabled(false);
		    	Game.fieldsLeft--;
		    }
		}
		//pod
		if(i<Game.fields.length-1) {
			if(j>0 && Game.fields[i+1][j-1].howManyBombsAround == 0 && Game.fields[i+1][j-1].isEnabled()) {
				showEmptyFieldsAndNeighbors(i+1,j-1);
		    	Game.fields[i+1][j-1].setEnabled(false);
		    	Game.fieldsLeft--;
			}
			if(Game.fields[i+1][j].howManyBombsAround == 0 && Game.fields[i+1][j].isEnabled()) {
				showEmptyFieldsAndNeighbors(i+1,j);
		    	Game.fields[i+1][j].setEnabled(false);
		    	Game.fieldsLeft--;
			}
			if(j<Game.fields[i].length-1 && Game.fields[i+1][j+1].howManyBombsAround == 0 && Game.fields[i+1][j+1].isEnabled()) {
				showEmptyFieldsAndNeighbors(i+1,j+1);
		    	Game.fields[i+1][j+1].setEnabled(false);
		    	Game.fieldsLeft--;
			}
		}
		//obok
		if(j>0 && Game.fields[i][j-1].howManyBombsAround == 0 && Game.fields[i][j-1].isEnabled()) {
			showEmptyFieldsAndNeighbors(i,j-1);
	    	Game.fields[i][j-1].setEnabled(false);
	    	Game.fieldsLeft--;
		}
		if(j<Game.fields[i].length-1 && Game.fields[i][j+1].howManyBombsAround == 0 && Game.fields[i][j+1].isEnabled()) { 
			showEmptyFieldsAndNeighbors(i,j+1);
	    	Game.fields[i][j+1].setEnabled(false);
	    	Game.fieldsLeft--;
		}
        showNeighbors(i,j);
	}
	
	public void showNeighbors(int i, int j) {
		//nad
		if(i>0) {
			if(j>0) Game.fields[i-1][j-1].setEnabled(false);;
			Game.fields[i-1][j].setEnabled(false);
			if(j<Game.fields[i].length-1) Game.fields[i-1][j+1].setEnabled(false);;
		}
		//pod
		if(i<Game.fields.length-1) {
			if(j>0) Game.fields[i+1][j-1].setEnabled(false);;
			Game.fields[i+1][j].setEnabled(false);
			if(j<Game.fields[i].length-1) Game.fields[i+1][j+1].setEnabled(false);;
		}
		//obok
		if(j>0) Game.fields[i][j-1].setEnabled(false);
		if(j<Game.fields[i].length-1) Game.fields[i][j+1].setEnabled(false);
		
	}
	
	public void restoreBorder() {
		if(Game.getEmptyPosition().x == i && Game.getEmptyPosition().y == j) {
			setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));	
		}
	}
	
	/*
	 * Mouse Listener
	 */

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(hidden) {
			return;
		}
		if(arg0.getButton() == MouseEvent.BUTTON1 && isEnabled()) {
			setEnabled(false);
			restoreBorder();
			if(bomb) {
				setBackground(Color.RED);
				Game.setAllHidden();
				Game.showBombs();
				//Game.disableAll();
			} else {
				if(howManyBombsAround == 0) showEmptyFieldsAndNeighbors(i,j);
				else Game.fieldsLeft--;
			}
			if(Game.isGameEnd()) System.out.println("Game end");
			System.out.println(Game.fieldsLeft);
		}
		if(arg0.getButton() == MouseEvent.BUTTON3) {
			setIcon(new ImageIcon("C:\\Users\\Rudy\\eclipse-workspace\\MineSweeper\\src\\images\\Flag.png"));
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
