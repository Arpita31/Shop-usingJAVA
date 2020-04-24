import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

/* Html code
<applet code = "Shop.class" width=500 height=500>
</applet>
*/

public class Shop extends JApplet implements ActionListener {
	JTextField book1,book2,book3,book4,book5,tolcost;
	JButton buy;
	
	NumberFormat nf;

	
	float bk1=300;
	float bk2=400;
	float bk3=500;
	float bk4=600;
	float bk5=700;
	
	public void init() {
	try {
	SwingUtilities.invokeAndWait(new Runnable() {
	public void run() {makeGUI();}
	});
	}
	catch (Exception exc) {
		System.out.println("cant create because of "+exc);
	}
	}
	

	private void makeGUI() {
	
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc=new GridBagConstraints();
		setLayout(gbag);
		
		JLabel heading= new JLabel(" Online Book Shop .");


		

		JLabel buk1=new JLabel("1.       GRE .          cost = "+ bk1); 
		JLabel buk2=new JLabel("2.       TOFEL .        cost = "+bk2);
		JLabel buk3=new JLabel("3.       CAT .          cost = "+ bk3);
		JLabel buk4=new JLabel("4.       GATE .         cost = "+bk4);
		JLabel buk5=new JLabel("5.       SAT .          cost = "+bk5);
		
		book1= new JTextField(5);
		book2= new JTextField(5);		
		book3= new JTextField(5);
		book4= new JTextField(5);
		book5= new JTextField(5);
		tolcost=new JTextField(20);
		
		JLabel costlab = new JLabel("Total cost ");
		tolcost.setEditable(false);

		buy=new JButton("Buy");
		
//the grid bag

		gbc.weighty=1.0;//use a row weight of 1
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbc.anchor=GridBagConstraints.NORTH;
		gbag.setConstraints(heading, gbc);
	
//Anchor most components to the right
		gbc.anchor=GridBagConstraints.EAST;
		

		gbc.gridwidth=GridBagConstraints.RELATIVE;
		gbag.setConstraints(buk1, gbc);
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbag.setConstraints(book1, gbc);
		
		gbc.gridwidth=GridBagConstraints.RELATIVE;
		gbag.setConstraints(buk2, gbc);
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbag.setConstraints(book2, gbc);
	
		gbc.gridwidth=GridBagConstraints.RELATIVE;
		gbag.setConstraints(buk3, gbc);
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbag.setConstraints(book3, gbc);

		gbc.gridwidth=GridBagConstraints.RELATIVE;
		gbag.setConstraints(buk4, gbc);
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbag.setConstraints(book4, gbc);

		gbc.gridwidth=GridBagConstraints.RELATIVE;
		gbag.setConstraints(buk5, gbc);
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbag.setConstraints(book5, gbc);
		
		gbc.gridwidth=GridBagConstraints.RELATIVE;
		gbag.setConstraints(costlab, gbc);
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbag.setConstraints(tolcost, gbc);

		gbc.anchor=GridBagConstraints.CENTER;
		gbag.setConstraints(buy, gbc);

//Add all the components

		add(heading);
		add(buk1);
		add(book1);
		add(buk2);
		add(book2);
		add(buk3);
		add(book3);
		add(buk4);
		add(book4);
		add(buk5);
		add(book5);
		add(costlab);
		add(tolcost);
		add(buy);
//Register to recive action events
		
		book1.addActionListener(this);
		book2.addActionListener(this);
		book3.addActionListener(this);		
		book4.addActionListener(this);
		book5.addActionListener(this);
		buy.addActionListener(this);
		
//create a number format
		nf=NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		
	}
	
/* User pressed Buy .Display the results if all fields are computed. */

	public void actionPerformed(ActionEvent ae) {
	
		double totalcost=0.0;
		double bno;
		String buks1=book1.getText();
		String buks2=book2.getText();
		String buks3=book3.getText();
		String buks4=book4.getText();
		String buks5=book5.getText();
		
		try {
			if(buks1.length() !=0 )
			{
					bno=Double.parseDouble(buks1);
					
					
					totalcost += bk1*bno;
						
			} 
			if(buks2.length() !=0 )
			{
					bno=Double.parseDouble(buks2);
					
					
					totalcost += bk2*bno;
					
			}
			if(buks3.length() !=0 )
			{
					bno=Double.parseDouble(buks3);
										
					
					totalcost += bk3*bno;
			}		
			if(buks4.length() !=0 )
			{		
					bno=Double.parseDouble(buks4);
					
					
					totalcost += bk4*bno;
			}
			if(buks5.length() !=0 )
			{		
					bno=Double.parseDouble(buks5);
					
					
					totalcost += bk5*bno;
			}
			
			tolcost.setText(nf.format(totalcost));
			showStatus(" ");
		}
		catch(NumberFormatException exc) {
			showStatus("Invalid Data");
			tolcost.setText(" ");
		}	
	}
}	
