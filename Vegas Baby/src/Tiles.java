import java.util.Random;
import java.io.Serializable;


public class Tiles implements Serializable
{
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
		this.color = color;
	}
	

	public void setShape(int shape)
	{
		this.shape = shape;
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
	
	
}