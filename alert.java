import java.awt.*;
import java.awt.event.*;
import java.io.*;

class alert extends Frame implements ActionListener
{
Button b1,b2;
Label l1,l2;
int cl;
public alert(int cl)
{
    this.cl=cl;
    setLayout(null);
    setSize(400,250);
    setTitle("Alert!!!!!.....");
    b1 = new Button("Okay");
    b2 = new Button("Okay"); 
    b1.setBounds(150,150,70,25);
    b2.setBounds(150,150,70,25);
    switch (cl){
        case 1:
                l1 = new Label("Please write a your Username");
                l1.setBounds(110,100,180,25);
                l1.setFont(new Font("Times New Roman", Font.BOLD,12));
                l1.setForeground(Color.white);
                l1.setBackground(new Color(68,65,68));
                add(l1);add(b1);
                break;
        case 2:
                l1 = new Label("Please create a password");
                l1.setBounds(110,100,180,25);
                l1.setFont(new Font("Times New Roman", Font.BOLD,12));
                l1.setForeground(Color.white);
                l1.setBackground(new Color(68,65,68));
                add(l1);add(b1);
                break;
        case 3:
                l1 = new Label("Please select a unique Username");
                l1.setBounds(110,100,180,25);
                l1.setFont(new Font("Times New Roman", Font.BOLD,12));
                l1.setForeground(Color.white);
                l1.setBackground(new Color(68,65,68));
                add(l1);add(b1);
                break;
        case 4:
                l1 = new Label("Please do enter the same password");
                l1.setBounds(110,100,180,25);
                l1.setFont(new Font("Times New Roman", Font.BOLD,12));
                l1.setForeground(Color.white);
                l1.setBackground(new Color(68,65,68));
                add(l1);add(b1);
                break;
        case 5:
                l1 = new Label("Invaild credentails!!");
                l1.setBounds(110,100,180,25);
                l1.setFont(new Font("Times New Roman", Font.BOLD,12));
                l1.setForeground(Color.white);
                l1.setBackground(new Color(68,65,68));
                add(l1);add(b2);
                break;
        case 6:
                l1 = new Label("Please write a your Username");
                l1.setBounds(110,100,180,25);
                l1.setFont(new Font("Times New Roman", Font.BOLD,12));
                l1.setForeground(Color.white);
                l1.setBackground(new Color(68,65,68));
                add(l1);add(b2);
                break;
        case 7:
                l1 = new Label("Please enter a password");
                l1.setBounds(110,100,180,25);
                l1.setFont(new Font("Times New Roman", Font.BOLD,12));
                l1.setForeground(Color.white);
                l1.setBackground(new Color(68,65,68));
                add(l1);add(b2);
                break;
        
    }
    b1.addActionListener(this); 
    b2.addActionListener(this);
    addWindowListener(new MyWindowAdapter());
    Dimension size = getToolkit().getScreenSize();
    setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
    setVisible(true);
}
public  void actionPerformed(ActionEvent ae)
{   
    try{
    if(ae.getSource()==b1)
    {
        Register r=new Register();
        // r.setSize(500,500);
        // r.setVisible(true);
    }
    if(ae.getSource()==b2)
    {
        new Login();
        // l.setSize(500,500);
        // l.setVisible(true);
    }
    }catch(Exception x){
        System.out.println("ggdgh"+x);
    }

}

}



// class MyWindowAdapter extends WindowAdapter
// {
// public void windowClosing(WindowEvent we)
// {
// System.exit(0);
// }
// }