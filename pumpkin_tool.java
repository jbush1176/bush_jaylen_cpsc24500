package pumpkin_Project;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings({ "serial", "unused" })
class DrawingPanel2 extends JPanel{
	private int pumpkinHeight;
	private int pumpkinX;
	private int pumpkinY;
	private int pumpkinWidth;
	private String pknNose;
	private String pknEye;
	private String pknMouth;

	/*
	 * This needed to be move to line 46
	 * { setPumpkinX(pumpkinX);
	 * setPumpkinX(pumpkinY); setPknHeight(pumpkinHeight);
	 * setPknWidth(pumpkinWidth); setpknEye(pknEye); setpknMouth(pknMouth);
	 * setpknNose(pknNose);
	 * 
	 * }
	 */
	public DrawingPanel2(){
		this(200, 100, 100, 100, "C", "C", "O");
	}

	public DrawingPanel2(int i, int j, int k, int l, String string, String string2, String string3){
		setPumpkinX(i); 
		setPumpkinY(j);//Had X instead of Y / Switched to Y
		setPknHeight(k);
		setPknWidth(l);
		setpknEye(string);
		setpknMouth(string2);
		setpknNose(string3);
	}

	/**
	 * If I am not mistaken, this area sets the value of the private variables for
	 * PumpkinX - PknMouth.
	 * 
	 * @param pumpkinX
	 */
	public void setPumpkinX(int PumpkX){
		this.pumpkinX = PumpkX;
	}

	public void setPumpkinY(int PumpkY){
		this.pumpkinY = PumpkY;
	}

	public void setPknHeight(int pumpkinHeight){
		this.pumpkinHeight = pumpkinHeight;
	}

	public void setPknWidth(int pumpkinWidth){
		this.pumpkinWidth = pumpkinWidth;
	}

	public void setpknEye(String pknEye){
		this.pknEye = pknEye;
	}

	public void setpknMouth(String pknMouth){
		this.pknMouth = pknMouth;
	}

	public void setpknNose(String pknNose){
		this.pknNose = pknNose;
	}

	public void pknEyeColor(Graphics g){
		/**
		 * the following area gives the user an option to pick the eye shape
		 */
		if (pknEye.equalsIgnoreCase("C")){
			g.setColor(Color.BLACK);
			g.fillOval((pumpkinX + pumpkinWidth - (pumpkinWidth / 3)), (pumpkinY + (pumpkinHeight / 5)),
					(pumpkinWidth / 10), (pumpkinHeight / 10));
			g.fillOval((pumpkinX + (pumpkinWidth / 4)), (pumpkinY + pumpkinHeight / 5), (pumpkinWidth / 10),
					(pumpkinHeight / 10));
		}

		else if (pknEye.equalsIgnoreCase("S")){
			g.setColor(Color.BLACK);
			g.fillRect((pumpkinX + pumpkinWidth - (pumpkinWidth / 3)), (pumpkinY + (pumpkinHeight / 5)),
					(pumpkinWidth / 10), (pumpkinHeight / 10));
			g.fillRect((pumpkinX + (pumpkinWidth / 4)), (pumpkinY + (pumpkinHeight / 5)), (pumpkinWidth / 10),
					(pumpkinHeight / 10));
		}

		else if (pknEye.equalsIgnoreCase("T")){
			/*
			 * You had the g.setcolor/ g.fillPolygon to early It couldn't see the variables
			 * so it was causing an error Remember java reads line by line, so variable need
			 * to come before using them
			 */
			int new1 = (pumpkinX + pumpkinWidth - (pumpkinWidth / 3));
			int new2 = (pumpkinY + (pumpkinHeight / 5));
			int newX = (pumpkinX + (pumpkinWidth / 4));
			int newY = (pumpkinY + (pumpkinHeight / 5));
			int[] pumpkinCord1 =
			{ (new1 + (pumpkinWidth / 10)), new1, (new1 + ((pumpkinWidth / 10) / 2)) };
			int[] pumpkinCord2 =
			{ (new2 + (pumpkinHeight / 10)), (new2 + (pumpkinHeight / 10)), new2 };
			int[] pumpkinCordX =
			{ (newX + (pumpkinWidth / 10)), newX, (newX + ((pumpkinWidth / 10) / 2)) };
			int[] pumpkinCordY =
			{ (newY + (pumpkinHeight / 10)), (newY + (pumpkinHeight / 10)), newY };

			g.setColor(Color.BLACK);
			g.fillPolygon(pumpkinCord1, pumpkinCord2, 3);
			g.fillPolygon(pumpkinCordX, pumpkinCordY, 3);

		}
		else{
			g.setColor(Color.BLACK);
			// In g.filloval you had a comma where a plus should have been
			g.fillOval((pumpkinX + (pumpkinWidth / 4)), (pumpkinY + (pumpkinHeight / 5)), (pumpkinWidth / 10),
					(pumpkinHeight / 10));
			g.fillOval(pumpkinX + pumpkinWidth - (pumpkinWidth / 3), (pumpkinY + (pumpkinHeight / 5)),
					(pumpkinWidth / 10), pumpkinHeight / 10);
		}
	}

	public void nosePaint(Graphics g){
		if (pknNose.equalsIgnoreCase("C")){
			g.setColor(Color.WHITE);
			g.fillOval((pumpkinX + (pumpkinWidth / 2) - 5), (pumpkinY + (pumpkinHeight / 2) - 5), (pumpkinWidth / 10),
					(pumpkinHeight / 10));
		}
		else if (pknNose.equalsIgnoreCase("S")){
			g.setColor(Color.WHITE);
			g.fillRect((pumpkinX + (pumpkinWidth / 2) - 5), (pumpkinY + (pumpkinHeight / 2) - 5), (pumpkinWidth / 10),
					(pumpkinHeight / 10));
		} 
		else if (pknNose.equalsIgnoreCase("T")){
			int newX = (pumpkinX + (pumpkinWidth / 2) - 5);
			int newY = (pumpkinY + (pumpkinHeight / 2) - 5);
			int[] pumpCordX =
			{ (newX + (pumpkinWidth / 10)), newX, (newX + ((pumpkinWidth / 10) / 2)) };
			int[] pumpCordY =
			{ (newY + (pumpkinHeight / 10)), (newY + (pumpkinHeight / 10)), newY };
			g.setColor(Color.WHITE);
			g.fillPolygon(pumpCordX, pumpCordY, 3);
		} 
		else{
			g.setColor(Color.WHITE);
			g.fillOval((pumpkinX + (pumpkinWidth / 2) - 5), (pumpkinY + (pumpkinHeight / 2) - 5), (pumpkinWidth / 10),
					(pumpkinHeight / 10));
		}
	}

	public void pknMouthColor(Graphics g){
		if (pknMouth.equalsIgnoreCase("o")){
			g.setColor(Color.BLACK);
			g.fillOval((pumpkinX + (pumpkinWidth / 2) - (pumpkinWidth / 6)),(pumpkinY + (pumpkinWidth / 2) + (pumpkinWidth / 5)), (pumpkinWidth / 3), (pumpkinHeight / 10));
		}
		else if (pknMouth.equalsIgnoreCase("R")){
			g.setColor(Color.BLACK);
			g.fillOval((pumpkinX + (pumpkinWidth / 2) - (pumpkinWidth / 6)),(pumpkinY + (pumpkinWidth / 2) + (pumpkinWidth / 5)), (pumpkinWidth / 3), (pumpkinHeight / 10));
		}
		else {
			g.setColor(Color.BLACK);
			g.fillOval((pumpkinX + (pumpkinWidth / 2) - (pumpkinWidth / 6)),(pumpkinY + (pumpkinWidth / 2) + (pumpkinWidth / 5)), (pumpkinWidth / 3), (pumpkinHeight / 10));
		}
	}
	@Override //ADDED
	public void paintComponent(Graphics g) //Changed from color to paint / This overrides the paintcomponent feature so it must be this name
	{
		super.paintComponent(g);//ADDED
		g.setColor(Color.ORANGE); // this is the color for the pumpkin
		System.out.println(pumpkinY);
		g.fillOval(pumpkinX, pumpkinY, pumpkinWidth, pumpkinHeight);
		
		g.setColor(Color.GREEN);
		g.fillRect((pumpkinX + (pumpkinWidth / 2) - (pumpkinWidth / 20)), (pumpkinY - (pumpkinHeight / 10)), (pumpkinWidth / 10), (pumpkinHeight / 10));
		pknMouthColor(g);
		pknEyeColor(g);
		nosePaint(g);
	}
}
/*
 * So you had your DrawingPanel2 class and the MyCustom frame class as one
 * I added a } to fix that
 */
@SuppressWarnings("serial")
class MyCustomFrame extends JFrame
{
	public MyCustomFrame(String title, int left, int top, int width, int height, int closeOp)
	{
		System.out.println("customframe");
		setLook(title, left, top, width, height);
		setDefaultCloseOperation(closeOp);
	}

	public void setLook(String title, int left, int top, int width, int height)
	{
		System.out.println("setlook");
		//
		setTitle(title);
		setBounds(left, top, width, height);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panelSouth = new JPanel();

		DrawingPanel2 drawPanel = new DrawingPanel2();
		c.add(drawPanel, BorderLayout.CENTER);

//This section shows the parts of the pumpkin: Eye, Nose, Mouth in that order
		panelSouth.add(new JLabel("Eye (C S T): "));
		JTextField txtEye = new JTextField(1);
		panelSouth.add(txtEye);

		panelSouth.add(new JLabel("Nose (C S T): "));
		JTextField txtNose = new JTextField(1);
		panelSouth.add(txtNose);

		panelSouth.add(new JLabel("Mouth (O R): "));
		JTextField txtMouth = new JTextField(1);
		panelSouth.add(txtMouth);
		panelSouth.setLayout(new FlowLayout());

		/*
		 * These are the dimensions from left, top, width, and height.
		 * 
		 */
		panelSouth.add(new JLabel("Left: "));
		JTextField txtLeft = new JTextField(3);
		panelSouth.add(txtLeft);
//Top
		panelSouth.add(new JLabel("Top: "));
		JTextField txtTop = new JTextField(3);
		panelSouth.add(txtTop);
//Width
		panelSouth.add(new JLabel("Width: "));
		JTextField txtWidth = new JTextField(3);
		panelSouth.add(txtWidth);
//Height
		panelSouth.add(new JLabel("Height: "));
		JTextField txtHeight = new JTextField(3);
		panelSouth.add(txtHeight);

		JButton btnDraw = new JButton("Draw");
		btnDraw.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				drawPanel.setPumpkinX(errorCheckInt(txtLeft, "Left"));
				drawPanel.setPumpkinY(errorCheckInt(txtTop, "Top"));//You called X here again / switched to calling Y
				drawPanel.setPknWidth(errorCheckInt(txtWidth, "Width"));
				drawPanel.setPknHeight(errorCheckInt(txtHeight, "Height"));

				drawPanel.setpknEye(errorCheckString(txtEye, "Eye"));
				drawPanel.setpknNose(errorCheckString(txtNose, "Nose"));
				drawPanel.setpknMouth(errorCheckString(txtMouth, "Mouth"));
				repaint();
			}
		});
		panelSouth.add(btnDraw);
		c.add(panelSouth, BorderLayout.SOUTH);

	}

	public int errorCheckInt(JTextField txtOp, String name)
	{
		String setString = txtOp.getText().trim();
		int setSize;
		try
		{
			setSize = Integer.parseInt(txtOp.getText());
		} catch (Exception ex)
		{
			setSize = -1;
		}
		if (setString.length() == 0)
		{
			JOptionPane.showMessageDialog(null, "You can't leave the " + name + " field blank");
			setSize = 100;
		} else if (setSize == -1)
		{
			JOptionPane.showMessageDialog(null, "The " + name + " must be an Integer");
			setSize = 100;
		} else
		{
			return setSize;
		}
		return setSize;
	}

	public String errorCheckString(JTextField txtOp, String name)
	{
		String setString = txtOp.getText().trim();
		int checkting;
		boolean stringCheck = false;
		try{
			checkting = Integer.parseInt(setString);
			JOptionPane.showMessageDialog(null, "The " + name + " must be a String");
		} catch (Exception ex){
			stringCheck = true;
		}

		if (setString.length() == 0){
			JOptionPane.showMessageDialog(null, "You can't Leave the " + name + " field blank");
		}
		else if (stringCheck = false){
			JOptionPane.showMessageDialog(null, name + " must be a String");
		} 
		else{
			if (name.equalsIgnoreCase("Eye")){
				if (!setString.equalsIgnoreCase("C") & !setString.equalsIgnoreCase("S")& !setString.equalsIgnoreCase("T")){
					JOptionPane.showMessageDialog(null, setString + " is not an option for Eye (C, S, T)");
				}
			} 
			else if (name.equalsIgnoreCase("Nose")){
				if (!setString.equalsIgnoreCase("C") & !setString.equalsIgnoreCase("S")& !setString.equalsIgnoreCase("T")){
					JOptionPane.showMessageDialog(null, setString + " is not an option for Nose (C, S, T)");
				}
			} 
			else if (name.equalsIgnoreCase("Mouth")){
				if (!setString.equalsIgnoreCase("R") & !setString.equalsIgnoreCase("O")){
					JOptionPane.showMessageDialog(null, setString + " is not an option for mouth (O, R)");
				}
			}
			return setString;
		}
		return setString;
	}
}


public class pumpkin_tool 
{
	public static void main(String [] args)
	{
		MyCustomFrame frm1 = new MyCustomFrame("PUMPKIN MAKER YEAH!!", 100,100,800,480,JFrame.EXIT_ON_CLOSE);
		frm1.setVisible(true);
	}

}
