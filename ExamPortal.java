import java.util.*;
import java.awt.event.*;
import javax.swing.*;

class ExamPortal extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	ExamPortal(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,1000,20);
		jb[0].setBounds(50,80,1000,20);
		jb[1].setBounds(50,110,1000,20);
		jb[2].setBounds(50,140,1000,20);
		jb[3].setBounds(50,170,1000,20);
		b1.setBounds(290,240,100,30);
		b2.setBounds(400,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(1000,370);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(900,25+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			JOptionPane.showMessageDialog(this,"correct ans="+count);
			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Q1: For 'C' programming language:");
			jb[0].setText("Constant expressions are evaluated at compile");jb[1].setText("String constants can be concatenated at compile time");jb[2].setText("Size of array should be known at compile time");jb[3].setText("All of these");	
		}
		if(current==1)
		{
			l.setText("Q2:  What is the maximun number of dimensions an array in C may have?");
			jb[0].setText("Two");jb[1].setText("Eight");jb[2].setText("Twenty");jb[3].setText("Theoratically no limit. The only practical limits are memory size and compilers");
		}
		if(current==2)
		{
			l.setText("Q3: If x is an array of interger, then the value of &x[i] is same as ?");
			jb[0].setText("&x[i-1] + sizeof (int)");jb[1].setText("x + sizeof (int) * i");jb[2].setText("x+i");jb[3].setText("none of these");
		}
		if(current==3)
		{
			l.setText("Q4: If S is an array of 80 characters, then the value assigned to S through the statement scanf(\"%s\",S) with input 12345 would be?");
			jb[0].setText("\"12345\"");jb[1].setText("nothing since 12345 is an integer");jb[2].setText("S is an illegal name for string");jb[3].setText("%s cannot be used for reading in values of S");
		}
		if(current==4)
		{
			l.setText("Q5: Size of the array need not be specified, when ?");
			jb[0].setText("Initialization is a part of definition");jb[1].setText("It is a declaratrion");jb[2].setText("It is a formal parameter");jb[3].setText("All of these");
		}
		if(current==5)
		{
			l.setText("Q6: Which of the following is an illegal array definition ?");
			jb[0].setText("Type COLOGNE:(LIME,PINE,MUSK,MENTHOL); var a:array[COLOGNE]of REAL;");jb[1].setText("var a:array[REAL]of REAL;");jb[2].setText("var a:array['A'..'Z']of REAL;");jb[3].setText("var a:array[BOOLEAN]of REAL;");
		}
		if(current==6)
		{
			l.setText("Q7: The  const  feature can be applied to ? ");
			jb[0].setText("an identifier ");jb[1].setText("an array");jb[2].setText("an array argument");jb[3].setText("All of these");
		}
		if(current==7)
		{
			l.setText("Q8: While passing an array as an actual argument, the function call must have the array name ? ");
			jb[0].setText("with empty brackets");jb[1].setText("with its size");jb[2].setText("alone");jb[3].setText("none of the above ");		
		}
		if(current==8)
		{
			l.setText("Q9: The parameter passing mechanism for an array is ?");
			jb[0].setText("call by value");jb[1].setText("call by value-result");jb[2].setText("call by reference");jb[3].setText("none of these");
		}
		if(current==9)
		{
			l.setText("Q10: The maximum number of dimension an array can have in C is ?");
			jb[0].setText("3");jb[1].setText("4");jb[2].setText("5");jb[3].setText("compiler dependent");
		}
		l.setBounds(30,40,1000,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,1000,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[3].isSelected());
		if(current==1)
			return(jb[3].isSelected());
		if(current==2)
			return(jb[0].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[0].isSelected());
		if(current==5)
			return(jb[3].isSelected());
		if(current==6)
			return(jb[2].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[2].isSelected());
		if(current==9)
			return(jb[3].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new ExamPortal("Online Exam");
	}


}
