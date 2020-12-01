import java.util.ArrayList;

import usethiscode.Tiles;

public class MachineChecker{
	private ArrayList<Tiles> tiles;
	/**
	 * checkerTile transcends the program. 
	 * @param drawSlots is used to access the tiles already created
	 * @return returns both( if both color and shape are match) or color(if only color is matched) and if none match is present the returns nothing
	 */
	
	public String checkerTile(SlotDrawing drawSlots)
	{
    	tiles = drawSlots.getTiles();
    	ArrayList<Integer> tileColor = new ArrayList<Integer>();
    	ArrayList<Integer> tileShape = new ArrayList<Integer>();
    	for(Tiles tile: tiles)
    	{
    		tileColor.add(tile.getColor());
    		tileShape.add(tile.getShape());
    	}
    	
    	for(int i = 0; i < tiles.size(); i++)
    	{
    		if(tileColor.get(0) == i)
        	{
        		if(tileColor.get(1) == i)
        		{
        			if(tileColor.get(2) == i)
        			{
        				if(tileColor.get(3) == i)
        				{
        					boolean win = shapeCheck(tileShape);
        					if(win == true)
        					{
        						return "Both";
        					}
        					else if(win == false)
        					{
        						return "Color";
        					}
        				}
        			}
        		}
        	}
    	}
    	return "none";
    	//All shapes and colors = x100
    	//Just colors = x25
	}
	public boolean shapeCheck(ArrayList<Integer> tileShape)
	{
		boolean win = false;
		for(int j = 0; j < 2; j++)
		{
			if(tileShape.get(0) == j)
			{
				if(tileShape.get(1) == j)
				{
					if(tileShape.get(2) == j)
					{
						if(tileShape.get(3) == j)
    					{
    						win = true;
    						return win;
    					}
					}
				}
			}
		}
		return win;
	}

}
