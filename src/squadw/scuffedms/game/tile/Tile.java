package squadw.scuffedms.game.tile;

import squadw.scuffedms.game.button.GButton;

import javax.swing.*;

public class Tile {

    //State of the tile 0 = closed, 1 = opened, 2 = marked
    public static final int CLOSED = 0;
    public static final int OPENED = 1;
    public static final int MARKED = 2;
    private int tileState;
    private int numBombs;
    private int x;
    private int y;
    private GButton button = new GButton();

    public Tile() {
        setClosed();
    }

    public void setNumBombs(int numBombs) {
        this.numBombs = numBombs;
    }

    public int getNumBombs() {
        return numBombs;
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getCoords() {
        return new int[] {x, y};
    }

    public void setImage() {
        button.setIcon(new ImageIcon(getClass().getResource("/squadw/scuffedms/resources/images/tile.png")));
        if (tileState == OPENED)
            button.setIcon(new ImageIcon(getClass().getResource("/squadw/scuffedms/resources/images/flat.png")));
        else if (tileState == MARKED)
            button.setIcon(new ImageIcon(getClass().getResource("/squadw/scuffedms/resources/images/flag.png")));
        if (tileState == OPENED && numBombs != 0) {
            button.setIcon(new ImageIcon(getClass().getResource("/squadw/scuffedms/resources/images/" + numBombs + ".png")));
        }
    }

    public void setImage(int i) {
        if (i == CLOSED)
            button.setIcon(new ImageIcon(getClass().getResource("/squadw/scuffedms/resources/images/tile.png")));
        else if (i == OPENED)
            button.setIcon(new ImageIcon(getClass().getResource("/squadw/scuffedms/resources/images/flat.png")));
        else if (i == MARKED)
            button.setIcon(new ImageIcon(getClass().getResource("/squadw/scuffedms/resources/images/flag.png")));
    }

    public GButton getButton() {
        return button;
    }

    public void setClosed() {
        setTileState(CLOSED);
        setImage();
    }

    public void setOpened() {
        setTileState(OPENED);
        setImage();
    }

    public void setMarked() {
        setTileState(MARKED);
        setImage();
    }

    private void setTileState(int s) {
        this.tileState = s;
    }

    public int getTileState() {
        return tileState;
    }

    @Override
    public String toString() {
        return ".";
    }
}
