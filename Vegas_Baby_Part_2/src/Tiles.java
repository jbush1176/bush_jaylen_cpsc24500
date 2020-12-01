import java.util.Random;


import java.awt.Color;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Tiles implements Serializable
{
	private static final String[] shapes = {"circle","square"};
	private static final String[] colorNames = {"yellow","green","orange","red","blue"};
	private static final Color[] colors = {Color.YELLOW, Color.GREEN, Color.ORANGE, Color.RED, Color.BLUE};
	
	private int color;
	private int shape;
	public Tiles()
	{
		color = 0;
		shape = 0;
	}
	
	
	public int getColor()
	{
		return color;
	}
	
	/**
	 * You can access other files with the code below.
	 */
	public int getShape()
	{
		return shape;
	}
	
	public void setColor(int color)
	{
		if (color < 0)
		{
			this.color = 0;
		}
		else if (color > 4)
		{
			this.color = 4;
		}else
		{
			this.color = color;
		}

	}
	
	

	public void setShape(int shape)
	{
		if (shape < 0)
		{
			this.shape = 0;
		}
		else if (shape > 1)
		{
			this.shape = 1;
		}
		else
		{
			this.shape = shape;
		}
	}
	
	public Tiles tileRandom()
	{
		Random rand = new Random();
		int colorRand = rand.nextInt(5);
		int shapeRand = rand.nextInt(2);
		Tiles tileRand = new Tiles(colorRand,shapeRand);
		return tileRand;
	}
	
	public Tiles(int color, int shape)
	{
		setColor(color);
		setShape(shape);
	}
	
	@Override
	public String toString()
	{
		return String.format("%d %d",color,shape);
	}
	public String toStringFancy()
	{
		return String.format("%s %s", getColorName(), getShapeAsString());
	}
	public void setTileRandom(Random ran)
	{
		color = ran.nextInt(colors.length);
		shape = ran.nextInt(shapes.length);
	}
	public Color getActualColor()
	{
		return colors[color];
	}
	public String getColorName()
	{
		return colorNames[color];
	}
	public String getShapeAsString()
	{
		return shapes[shape];
	}
}