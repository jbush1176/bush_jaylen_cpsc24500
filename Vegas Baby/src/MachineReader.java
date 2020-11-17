import java.beans.XMLDecoder;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class MachineReader
{
	public ArrayList<Tiles> readFromText(String fname)
	{
		File f = new File(fname);
		return readFromText(f);
	}
	public ArrayList<Tiles> readFromText(File f)
	{
		try
		{
			ArrayList<Tiles> results = new ArrayList<Tiles>();
			Scanner slotFile = new Scanner(f);
			String line;
			String [] parts;
			int color, shape;
			while(slotFile.hasNextLine())
			{
				line = slotFile.nextLine().trim();
				if(line.length() > 0)
				{
					parts = line.split(" ");
					color = Integer.parseInt(parts[0]);
					shape = Integer.parseInt(parts[1]);
					Tiles tile1 = new Tiles(color,shape);
					results.add(tile1);
				}
			}
			slotFile.close();
			return results;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Tiles> readFromBin(String fname)
	{
		File f = new File(fname);
		return readFromBin(f);
	} 
	@SuppressWarnings("unchecked")
	public ArrayList<Tiles> readFromBin(File f)
	{
		try
		{
			ArrayList<Tiles> tileRead;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			tileRead = (ArrayList<Tiles>)ois.readObject();
			ois.close();
			return tileRead;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public ArrayList<Tiles> readFromXml(String fname)
	{
		File f = new File(fname);
		return readFromXml(f);
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Tiles> readFromXml(File f)
	{
		try {
			ArrayList<Tiles> tileRead;
			XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(f)));
			tileRead = (ArrayList<Tiles>)dec.readObject();
			dec.close();
			return tileRead;
		} catch (Exception ex) {
			return null;
		}
	}
	
	public ArrayList<Tiles> read(String fname)
	{
		File f = new File(fname);
		return read(f);
	}
	public ArrayList<Tiles> read(File f)
	{
		String fname = f.getName().toUpperCase();
		if(fname.endsWith(".TXT"))
		{
			return readFromText(f);
		}
		if(fname.endsWith(".BIN"))
		{
			return readFromBin(f);
		}
		if(fname.endsWith(".XML"))
		{
			return readFromXml(f);
		}
		return null;
	}
}
