import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
// C:\Program Files\Java\jdk1.8.0_181\bin

class Login extends Frame implements ActionListener
{
TextField tf1,tf2;
Button b1,b2;
Label l1,l2,h1;
private Image img;
public Login()
{
    setLayout(null);
    setTitle("Login<-:");
    img = Toolkit.getDefaultToolkit().createImage("login-bg.jpg");
    setSize(500,500);

    h1 =  new Label(" H&M Airline");
    h1.setBounds(150,350,200,65);
    h1.setForeground(Color.white);
    h1.setBackground(new Color(68,65,68));   
    h1.setFont(new Font("Paris Van", Font.BOLD,30)); 



    l1 = new Label("Please Enter your Username: ");
    tf1 = new TextField(10);
    l2 = new Label("Please Enter your Password: ");
    tf2 = new TextField(10);
    tf2.setEchoChar('*');
    b1 = new Button("Login-in");
    b2 = new Button("Reset");
    l1.setBounds(110,200,165,25);
    l1.setFont(new Font("Times New Roman", Font.BOLD,12));
    l1.setForeground(Color.white);
    l1.setBackground(new Color(68,65,68));
    tf1.setBounds(280,200,100,25);
    l2.setBounds(110,250,165,25);
    l2.setFont(new Font("Times New Roman", Font.BOLD,12));
    l2.setForeground(Color.white);
    l2.setBackground(new Color(68,65,68));
    tf2.setBounds(280,250,100,25);

    b2.setBounds(170,300,70,25);
    b1.setBounds(270,300,70,25);
    
    add(h1);
    add(l1);
    add(tf1);
    add(l2);
    add(tf2);
    add(b1);
    add(b2);
    b1.addActionListener(this); 
    b2.addActionListener(this);
    addWindowListener(new MyWindowAdapter());
     Dimension size = getToolkit().getScreenSize();
    setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
    setVisible(true);

}
 public void paint(Graphics g) 
 {
    // Draw the image on the frame
    g.drawImage(img, 0, 0,500,500, this);    
}
public  void actionPerformed(ActionEvent ae)
{   int i;

    if(ae.getSource()==b1)
    {   
        if(((tf1.getText()).length())<=0)
        {
            alert a=new alert(6);
        }
        else if(((tf2.getText()).length())<=0)
        {
            alert a=new alert(7);
            //a.setSize(400,250);
            //a.setVisible(true);    
            // break;
        }
        try{
        int flag=0;
        File f=new File("data.txt");
        FileReader fr=new FileReader(f);
        Scanner myReader = new Scanner(fr);
        while (myReader.hasNextLine()) 
        {
        String LoginName = myReader.nextLine();
        if((tf1.getText()).equals(LoginName))
        {
            String LoginPassword = myReader.nextLine();
            if((tf2.getText()).equals(LoginPassword))
            {
               System.out.println("Congrats");
               new Booking();
            //    break;
            }
            else
            {
                flag=1;
                break;
            }
        }
        }
        if(flag==1)
        {
            alert a=new alert(5);
            //a.setSize(300,300);
            //a.setVisible(true);
            // break;
            //System.out.print("Invaild credentails!!");

        }
        }catch(IOException x){
        System.out.println("harish "+x);
        }
    }
    if(ae.getSource()==b2)
    {
        tf1.setText("");
        tf2.setText("");
    }
    }
    
}

