
import java.beans.XMLEncoder;
import javax.swing.JOptionPane;
import java.io.ObjectOutputStream;

import java.io.PrintWriter;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.util.ArrayList;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;



@SuppressWarnings("unused")
public class MachineWriter
{
	public boolean writeToText(String fname, ArrayList<Tiles> manyTiles)
	{
		File f = new File(fname);
		return writeToText(f, manyTiles);
	}
	public boolean writeToText(File f, ArrayList<Tiles> manyTiles)
	{
		try
		{
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for(Tiles Tiles: manyTiles)
			{
				pw.println(Tiles);
			}
			pw.close();
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean writeToBin(String fname, ArrayList<Tiles> manyTiles)
	{
		File f = new File(fname);
		return writeToBin(f,manyTiles);
	}
	public boolean writeToBin(File f, ArrayList<Tiles> manyTiles)
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(manyTiles);
			oos.close();
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	public boolean writeToXml(String fname, ArrayList<Tiles> manyTiles)
	{
		File f = new File(fname);
		return writeToXml(f, manyTiles);
	}
	public boolean writeToXml(File f, ArrayList<Tiles> manyTiles)
	{
		try
		{
			XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(f)));
			enc.writeObject(manyTiles);
			enc.close();
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	
	
	
	
	public boolean write(String fname, ArrayList<Tiles> manyTiles)
	{
		File f = new File(fname);
		return write(f, manyTiles);
	}
	public boolean write(File f, ArrayList<Tiles> manyTiles)
	{
		String fname = f.getName().toUpperCase();
		if(fname.endsWith(".TXT"))
		{
			return writeToText(f, manyTiles);
		}
		if(fname.endsWith(".BIN"))
		{
			return writeToBin(f, manyTiles);
		}
		if(fname.endsWith(".XML"))
		{
			return writeToXml(f, manyTiles);
		}
		return false;
	}
}