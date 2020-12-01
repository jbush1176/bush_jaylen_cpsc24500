import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import usethiscode.MachineChecker;
import usethiscode.MachineReader;
import usethiscode.MachineWriter;

import usethiscode.Tiles;


@SuppressWarnings({ "unused", "serial" })
public class SlotFrame extends JFrame
{
	private Random random;
	private ArrayList<Tiles> tiles;
	private SlotDrawing drawSlots;
	
	public void setupMenu(JTextField txtDollar)
	{
		Tiles tileInfo = new Tiles();
		JMenuBar slotBar = new JMenuBar();
		JMenu slotMenu = new JMenu("File");
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				MachineWriter tileWrite = new MachineWriter();
				if(jfc.showSaveDialog(null)== JFileChooser.APPROVE_OPTION)
				{
					if(tileWrite.write(jfc.getSelectedFile(), drawSlots.getTiles()))
					{
						JOptionPane.showMessageDialog(null, "Wrote Tiles to file");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Failed to write Tiles");
					}
				}
			}
		});
		slotMenu.add(menuSave);
		JMenuItem menuLoad = new JMenuItem("Load");
		menuLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineReader sr = new MachineReader();
				JFileChooser jfc = new JFileChooser();
				if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					ArrayList<Tiles> TileRead = sr.read(jfc.getSelectedFile());
					if(TileRead == null)
					{
						JOptionPane.showMessageDialog(null, "Could not read Tiles From File.");
					}
					else
					{
						drawSlots.setTiles(TileRead);
						repaint();
					}
				}

			}
		});
		slotMenu.add(menuLoad);
		JMenuItem menuRestart = new JMenuItem("Restart");
		menuRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawSlots.tileDrawRan();
				repaint();
			}
		});
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		slotMenu.add(menuRestart);
		slotMenu.add(menuExit);
		slotBar.add(slotMenu);
		
		JMenu slotHelp = new JMenu("Help");
		JMenuItem helpAbout = new JMenuItem("About");
		helpAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Slot Machine Program made by ~~~");// Add your info here!!!!
			}
		});
		slotHelp.add(helpAbout);
		slotBar.add(slotHelp);
		setJMenuBar(slotBar);
	}
	public void SlotsFrame()
	{
		setLook();
	}

	public void setLook() {
	    setTitle("Vegas Baby Vegas Slot Machine");
	    setBounds(150,150,850,400);
	    
	    Container c = getContentPane();
	    
	    c.setLayout(new BorderLayout());
	    
	    drawSlots = new SlotDrawing();
	    c.add(drawSlots, BorderLayout.CENTER);
	    
	    JPanel panelSouth = new JPanel();
	    panelSouth.setLayout(new FlowLayout());
	    
	    JButton btnMin = new JButton("MIN");
	    
	    JButton btnMid = new JButton("MID");
	    
	    JButton btnMax = new JButton("MAX");
	    

	    JLabel labBal = new JLabel("$$$");
	    panelSouth.add(labBal);
	    JTextField txtDollar = new JTextField(6);
	    txtDollar.setEditable(false);
	    txtDollar.setText(String.format("%.2s", "5.00"));
	    panelSouth.add(txtDollar);
	    
	    btnMax.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {
	          	double Dollar = Double.parseDouble(txtDollar.getText());
	          	drawSlots.tileDrawRan();
	          	MachineChecker check = new MachineChecker();
	          	String win = check.checkerTile(drawSlots);
	          	if(win.equalsIgnoreCase("BOTH"))
	          	{
	          		System.out.println("YOU MATCH BOTH COLOR AND SHAPE :)- MAX");
	        		Dollar = Dollar * 100;
					txtDollar.setText(String.format("%d", Dollar));
	          	}
	          	else if(win.equalsIgnoreCase("COLOR"))
	        	{
	        		System.out.println("YOU MATCHED COLOR- MAX");
	        		Dollar = Dollar * 25;
	        		txtDollar.setText(String.format("%d", Dollar));
	        	}
	          	else {
	          		txtDollar.setText(String.format("%s", "0"));
	          		if(Double.parseDouble(txtDollar.getText()) < 0.01)
	                {
	                	btnMax.setEnabled(false);
	                	btnMid.setEnabled(false);
	                	btnMin.setEnabled(false);
	                }
	        	}
	        }
	    });
	    btnMid.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	double Dollar = Double.parseDouble(txtDollar.getText())/2;
	        	drawSlots.tileDrawRan();
	        	MachineChecker check = new MachineChecker();
	        	String win = check.checkerTile(drawSlots);
	        	if(win.equalsIgnoreCase("BOTH"))
	        	{
	        		System.out.println("YOU MATCH BOTH COLOR AND SHAPE- MID");
	        		Dollar = Dollar * 50;
					txtDollar.setText(String.format("%d", Dollar));
	        	}
	        	else if(win.equalsIgnoreCase("COLOR"))
	        	{
	        		Dollar = Dollar * 10;
					txtDollar.setText(String.format("%d", Dollar));
	        		System.out.println("YOU MATCHED COLOR- MID");
	        	}
	        	else {
	        		if(Double.parseDouble(txtDollar.getText()) <= 0.01)
	        		txtDollar.setText(String.format("%.2f", Dollar));
	                {
	                	btnMax.setEnabled(false);
	                	btnMid.setEnabled(false);
	                	btnMin.setEnabled(false);
	        			txtDollar.setText("0");
	                }
	          	
	        }
	    }  
	});
	    btnMin.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	double Dollar = Double.parseDouble(txtDollar.getText())*0.9;
	        	drawSlots.tileDrawRan();
	        	MachineChecker check = new MachineChecker();// Need Tile Checker
	        	String win = check.checkerTile(drawSlots);
	        	if(win.equalsIgnoreCase("BOTH"))
	        	{
	        		System.out.println("YOU MATCH BOTH COLOR AND SHAPE- MIN");
	        		Dollar = Dollar * 10;
					txtDollar.setText(String.format("%.2f", Dollar));
	        	}
	        	else if(win.equalsIgnoreCase("COLOR"))
	        	{
	        		Dollar = Dollar * 5;
					txtDollar.setText(String.format("%.2f", Dollar));
	        		System.out.println("YOU MATCHED COLOR- MIN");
	        	}
	        	else {
	        		txtDollar.setText(String.format("%.2f", Dollar));
	        		if(Double.parseDouble(txtDollar.getText()) <= 0.05)
	        		{
	        		txtDollar.setText("0");
	            	btnMax.setEnabled(false);
	            	btnMid.setEnabled(false);
	            	btnMin.setEnabled(false);
	            }
	    	}
	    }
	});
	    panelSouth.add(btnMax);
	    panelSouth.add(btnMid);
	    panelSouth.add(btnMin);
	    c.add(panelSouth,BorderLayout.SOUTH);
	    setupMenu(txtDollar);
	    
	}
	
	public SlotFrame(String title, int left, int top, int width, int height)//non-default constructor, takes in settings
	{
		setLook(title,left,top,width,height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	public void setLook(String title, int left, int top, int width, int height) {
        setTitle(title);
        setBounds(left,top,width,height);
        Container c = getContentPane();
        
        c.setLayout(new BorderLayout());
        
        drawSlots = new SlotDrawing();
        c.add(drawSlots, BorderLayout.CENTER);
        
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());

        
        //Max Button
        JButton btnMax = new JButton("Max");
        btnMax.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	drawSlots.tileDrawRan();
                repaint();
            }
        });
        panelSouth.add(btnMax);
        
        //Mid Button
        JButton btnMid = new JButton("Mid");
        btnMid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	drawSlots.tileDrawRan();
                repaint();
            }
        });
        panelSouth.add(btnMid);
        
        //Min Button
        JButton btnMin = new JButton("Min");
        btnMin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	drawSlots.tileDrawRan();
                repaint();
            }
        });
        panelSouth.add(btnMin);
        
        //Dollar button
        panelSouth.add(new JLabel("$"));
        JTextField txtDollar = new JTextField(6);
        double startvalue = 5.00;
        txtDollar.setText(String.format("%.2f", startvalue));
        panelSouth.add(txtDollar);
        c.add(panelSouth, BorderLayout.SOUTH);
        setupMenu(txtDollar);
        
	}
}