import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JPanel;

import usethiscode.Tiles;

@SuppressWarnings("serial" )
class SlotDrawing extends JPanel implements MouseListener
{
	private ArrayList<Tiles> tiles;
	private Random ran; 
	
	/**
	 * This function allows other class to edit the private tiles arrayList
	 * @param tile and arrayList provided by another class
	 */
	public void setTiles(ArrayList<Tiles> tile)
	{
		this.tiles = tile;
	}
	/**
	 * This function allows other class to read the private arrayList tiles
	 * @return an ArrayList<Tile> for other class to use
	 */
	public ArrayList<Tiles> getTiles()
	{
		return tiles;
	}
	public SlotDrawing(){
		addMouseListener(this);
		tiles = new ArrayList<Tiles>();
		ran = new Random();
		Tiles tile;
		for(int i = 0; i < 4; i++)
		{
			tile = new Tiles();
			tile.setTileRandom(ran);
			tiles.add(tile);
		}
	}

	public void tileDrawRan()
	{
		Tiles tile;
		for(int i = 0; i < tiles.size(); i++)
		{
			tile = new Tiles();
			tile.setTileRandom(ran);
			tiles.set(i, tile);
		}
		repaint();
	}

	/**
	 * Taken from Solution
	 * uses the width of the cell to dynamically size the tiles
	 * loops the number of tiles and gets the color and shape then sets it
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int cellWidth = this.getWidth()/4;
		int tileSize = 4 * cellWidth/5;
		int shape;
		Color color;
		Tiles tile;
		for(int i = 0; i < tiles.size(); i++)
		{
			tile = tiles.get(i);
			shape = tile.getShape();
			color = tile.getActualColor();
			g.setColor(color);
			if(shape == 0)
			{
				g.fillOval(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize);
			}
			else if (shape == 1)
			{
				g.fillRect(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize);
			}	
		}
	
	}
	/**
	 * Taken from Solution
	 * finds which tile is clicked
	 * then call the setTileRandom to randomize the tile
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int whichTile = e.getX()/(this.getWidth()/4);
		Tiles tile = tiles.get(whichTile);
		tile.setTileRandom(ran);
		repaint();
	
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