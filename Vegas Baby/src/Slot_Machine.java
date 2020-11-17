import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;

//package tiles;

@SuppressWarnings("unused")
class Tile_Data {
	private String tileRightColor;
	private String tileRightShape;
	private String tileRightMiddleColor;
	private String tileLeftColor;
	private String tileLeftShape;
	private String tileLeftMiddleColor;
	private String tileLeftMiddleShape;
	private String tileRightMiddleShape;

	public Tile_Data() {
		this("red", "square", "red", "square", "red", "square", "red", "square");
	}

	public Tile_Data(String LeftColor, String LeftShape, String LeftMiddleColor, String LeftMiddleShape,
			String RightColor, String RightShape, String RightMiddleColor, String RightMiddleShape) {
		setTileLeftColor(LeftColor);
		setTileLeftShape(LeftShape);
		//
		setTileLeftMiddleColor(LeftMiddleColor);
		setTileLeftMiddleShape(LeftMiddleShape);
		//
		setTileRightColor(RightColor);
		setTileRightShape(RightShape);
		//
		setTileRightMiddleColor(RightMiddleColor);
		setTileRightMiddleShape(RightMiddleShape);
	}

	public void setTileLeftColor(String Color) {
		this.tileLeftColor = Color;// The variabel you bring in must match/ changed leftcolor to Color
	}

	public String getTileLeftColor1()// There was a lot of weirdness here, I am not sure what happened.
	{
		return tileLeftColor;
	}

	public void setTileLeftShape(String leftShape) {
		this.tileLeftShape = leftShape;
	}

	public String getTileLeftShape() {
		return tileLeftShape;
	}

	public void setTileRightColor(String rightColor) {
		this.tileRightColor = rightColor;
	}

	public String getTileRightColor() {
		return tileRightColor;
	}

	public void setTileRightShape(String rightShape) {
		this.tileRightShape = rightShape;
	}

	public String getTileRightShape() {
		return tileRightShape;
	}

	public void setTileLeftMiddleColor(String LeftMiddleColor) {
		this.tileLeftMiddleColor = LeftMiddleColor;
	}

	public String getTileLeftMiddleColor() {
		return tileLeftMiddleColor;
	}

	public void setTileLeftMiddleShape(String leftMiddleShape) {
		this.tileLeftMiddleShape = leftMiddleShape;
	}

	public String getTileLeftMiddleShape() {
		return tileLeftMiddleShape;
	}

	//

	public void setTileRightMiddleColor(String rightMiddleColor) {
		this.tileRightMiddleColor = rightMiddleColor;
	}

	public String getTileRightMiddleColor() {
		return tileRightMiddleColor;
	}

	public void setTileRightMiddleShape(String rightMiddleShape) {
		this.tileRightMiddleShape = rightMiddleShape;
	}

	public String getTileRightMiddleShape() {
		return tileRightMiddleShape;
	}

}

@SuppressWarnings("serial")
class SlotsDrawing extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		Tile_Data tileInfo = new Tile_Data();
		super.paintComponent(g);
		g.setColor(Color.getColor(tileInfo.getTileLeftColor1().toUpperCase(), Color.RED)); // Test
		g.fillRect(50, 120, 130, 115);

		g.setColor(Color.getColor(tileInfo.getTileLeftMiddleColor().toUpperCase(), Color.RED)); // Test
		g.fillRect(250, 120, 130, 115);

		g.setColor(Color.getColor(tileInfo.getTileRightMiddleColor().toUpperCase(), Color.RED)); // Test
		g.fillRect(450, 120, 130, 115);

		g.setColor(Color.getColor(tileInfo.getTileRightColor().toUpperCase(), Color.RED)); // Test
		g.fillRect(650, 120, 130, 115);
	}

	public void setTiles(ArrayList<Tiles> tileRead) {
		// TODO Auto-generated method stub
		
	}

	public void RandomizerTile() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Tiles> getTiles() {
		// TODO Auto-generated method stub
		return null;
	}
}

class TileWriter {
	public void write() {
		Tile_Data tileInfo = new Tile_Data();
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("TileData.txt"))));
			pw.println(tileInfo.getTileLeftColor1() + "\t" + tileInfo.getTileLeftShape());
			pw.println(tileInfo.getTileLeftMiddleColor() + "\t" + tileInfo.getTileLeftMiddleShape());
			pw.println(tileInfo.getTileRightColor() + "\t" + tileInfo.getTileRightShape());
			pw.println(tileInfo.getTileRightMiddleColor() + "\t" + tileInfo.getTileRightMiddleShape());
			pw.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "There has been an error");
		}
	}
}

@SuppressWarnings("serial")
class SlotsFrame extends JFrame {
	public void setupMenu() {
		JMenuBar slotBar = new JMenuBar();
		JMenu slotMenu = new JMenu("File");
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TileWriter tilewrite = new TileWriter();
				tilewrite.write();
			}
		});
		slotMenu.add(menuSave);
		slotBar.add(slotMenu);

		JMenu slotHelp = new JMenu("Help");
		JMenuItem helpAbout = new JMenuItem("About");
		helpAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Slot Machine Program made by Jaylen Bush");
			}
		});
		slotHelp.add(helpAbout);
		slotBar.add(slotHelp);
		setJMenuBar(slotBar);
	}

	public SlotsFrame(String title, int left, int top, int width, int height, int closeOp)// non-default constructor,
																							// takes in settings
	{
		setLook(title, left, top, width, height);
		setDefaultCloseOperation(closeOp);
	}

	public void setLook(String title, int left, int top, int width, int height) {
		setTitle(title);
		setBounds(left, top, width, height);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panelSouth = new JPanel();

		SlotsDrawing drawSlots = new SlotsDrawing();
		c.add(drawSlots, BorderLayout.CENTER);

		JButton btnMax = new JButton("MAX");
		btnMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		panelSouth.add(btnMax);

		JButton btnMid = new JButton("MID");
		btnMid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		panelSouth.add(btnMid);

		JButton btnMin = new JButton("MIN");
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		panelSouth.add(btnMin);

		panelSouth.add(new JLabel("$$$"));
		JTextField txtDollar = new JTextField(6);
		panelSouth.add(txtDollar);

		c.add(panelSouth, BorderLayout.SOUTH);
		setupMenu();

	}
}

public class Slot_Machine {
		public static void main(String[] args) {
			SlotsFrame frm1 = new SlotsFrame("$$Vegas Baby Vegas Slot Machine$$", 150, 150, 800, 380,
					JFrame.EXIT_ON_CLOSE);
			frm1.setVisible(true);
		}
	}
