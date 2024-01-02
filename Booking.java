import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class Booking extends Frame implements ActionListener,ItemListener
{
TextField[] txt1= new TextField[6];
Label[] la1= new Label[6];
TextField[] txt2= new TextField[6];
Label[] la2= new Label[6];
TextField tf1,tf2,tf3,tf4;
Choice c1,c2,c3,c4,c5;
Button b1,b2,b3,b4;
Label l1,l2,l3,l4,l5,h1;
private Image img;
int j;
String s1,s2,s3,s4;
public Booking()
{
    // tf1.setText((String.valueOf(n)));
    setLayout(null);
    img = Toolkit.getDefaultToolkit().createImage("booking.png");
    setSize(900,600);

    h1 =  new Label("H&M Airline");
    h1.setBounds(80,80,400,65);
    h1.setForeground(Color.white);
    h1.setBackground(new Color(255,128,67));   
    h1.setFont(new Font("Paris Van", Font.BOLD,65)); 


    //FROM
    l4 =  new Label("From: ");
    l4.setBounds(80,200,55,25);
    l4.setForeground(Color.white);
    l4.setBackground(new Color(255,128,67));   
    l4.setFont(new Font("Times New Roman", Font.BOLD,15)); 
    c3=new Choice();
    // c3.add("");
    c3.add("Mumbai");
    c3.add("Chennai");
    c3.add("Hyderabad");
    c3.add("Bangalore");
    c3.add("Kolkata");
    c3.setBounds(140,200,100,25);

    //TO
    l5 =  new Label("To: ");
    l5.setBounds(250,200,30,25);
    l5.setForeground(Color.white);
    l5.setBackground(new Color(255,128,67));
    l5.setFont(new Font("Times New Roman", Font.BOLD,15));
    c4 = new Choice();
    c4.add("");
    c4.add("Chennai");
    c4.add("Hyderabad");
    c4.add("Bangalore");
    c4.add("Kolkata");
    c4.setBounds(290,200,100,25);




    l1 = new Label("Select Flight: ");
    l1.setBounds(110,250,105,25);
    l1.setForeground(Color.white);
    l1.setBackground(new Color(255,128,67));    
    l1.setFont(new Font("Times New Roman", Font.BOLD,15));
    c1=new Choice();
    c1.add("");
    c1.add("Emirates");
    c1.add("Air India");
    c1.add("Indigo");
    c1.add("Spicejet");
    c1.setBounds(250,250,100,25);

    l2 = new Label("Select Class: ");
    l2.setForeground(Color.white);
    l2.setBounds(110,300,105,25);
    l2.setFont(new Font("Times New Roman", Font.BOLD,15));
    l2.setBackground(new Color(255,128,67));
    c2=new Choice();
    c2.add("");
    c2.add("Economic");
    c2.add("Bussiness");
    c2.add("First Class");
    c2.setBounds(250,300,100,25);

    l3 = new Label("Enter No. of Seats: ");
    l3.setBounds(110,350,138,25);
    l3.setFont(new Font("Times New Roman", Font.BOLD,15));
    l3.setForeground(Color.white);
    l3.setBackground(new Color(255,128,67));
   
    tf1 = new TextField(10);
    tf1.setBounds(250,350,100,25);

    b1=new Button("Load");
    b1.setBounds(352,352,40,20);
    // Integer.parseInt(tf1.getText())



    j=0;
     for(int i=1;i<=5;i++)
    {   
        la1[i]=new Label("Name:");
        la1[i].setBounds(110,400+j,50,25);
        la1[i].setFont(new Font("Times New Roman", Font.BOLD,15));
        la1[i].setForeground(Color.white);
        la1[i].setBackground(new Color(255,128,67));
        txt1[i]=new TextField(10);
        txt1[i].setBounds(165,400+j,100,25);
        la2[i]=new Label("Age:");
        la2[i].setBounds(280,400+j,30,25);
        la2[i].setFont(new Font("Times New Roman", Font.BOLD,15));
        la2[i].setForeground(Color.white);
        la2[i].setBackground(new Color(255,128,67));
        txt2[i]=new TextField(10);
        txt2[i].setBounds(315,400+j,25,25);
        j=j+50;
    }




    // b1 = new Button("Book");
    b2 = new Button("Book-now");
    b2.setBounds(750,520,100,35);


    add(h1);
    add(l1);
    add(c1);

    add(l2);
    add(c2);

    add(l3);
    add(tf1);

    add(b1);
    add(l4);
    add(l5);
    add(c3);
    add(c4);
    
    c1.addItemListener(this);
    c2.addItemListener(this);
    c3.addItemListener(this);
    c4.addItemListener(this);
    b1.addActionListener(this); 
    b2.addActionListener(this);
    addWindowListener(new MyWindowAdapter());
    Dimension size = getToolkit().getScreenSize();
    setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
    setVisible(true);

}

public void addActionListener(ActionListener i)
{
     
}
public void itemStateChanged(ItemEvent ie)
{  
    s1=c3.getSelectedItem();
    s2=c4.getSelectedItem();
    s3=c1.getSelectedItem();
    s4=c2.getSelectedItem();
    // System.out.println(s1);
}
public  void actionPerformed(ActionEvent ae)
{   
    if(ae.getSource()==b1)
    {
        for(int i=1;i<=(Integer.parseInt(tf1.getText()));i++)
        { 
            add(la1[i]);
            add(txt1[i]);
            add(la2[i]);
            add(txt2[i]);
        }
        add(b2); 
    }
    if(ae.getSource()==b2)
    {
        try{
          File f=new File("Booking.txt");
          FileWriter fw1=new FileWriter(f,true);
          
          fw1.write("H&M Airlines\n");
          fw1.write("From: "+s1+"    To: "+s2+"\n");
          fw1.write("Select Fight: "+s3+"\n");
          fw1.write("Select Class: "+s4+"\n");
          fw1.write("No. of Seats: "+(tf1.getText())+"\n");

          for(int i=1;i<=(Integer.parseInt(tf1.getText()));i++)
          { 
            fw1.write("Name: "+(txt1[i].getText())+"     ");
            fw1.write("Age: "+(txt2[i].getText())+"\n");
          }

        //   System.out.println(tf2.getText()+" "+tf3.getText());
        //   new Login();
        fw1.write("\n\n\n");
          fw1.close();
      } catch(IOException x)
      {
          System.out.println("harish "+x);
      }
    }
}
 public void paint(Graphics g) 
 {
    // Draw the image on the frame
    g.drawImage(img, 0, 0,900,600, this);   
 
}
  
//   public static void main(String args[])
// {
//     Booking b=new Booking();
// }

}



class MyWindowAdapter extends WindowAdapter
{
    public void windowClosing(WindowEvent we)
    {
        System.exit(0);
    }
}




