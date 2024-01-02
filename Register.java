import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class Register extends Frame implements ActionListener
{
TextField tf1,tf2,tf3;
Button b1,b2,b3;
Label l1,l2,l3,h1;
int count,i,flag;
String b,check;
private Image img;
public Register()
{
    //new FlowLayout(FlowLayout.CENTER,20,20)
    setLayout(null);
    setTitle("Register:->");
    img = Toolkit.getDefaultToolkit().createImage("login-bg.jpg");
    setSize(500,500);


    h1 =  new Label("Register here :");
    h1.setBounds(25,50,100,20);
    h1.setForeground(Color.white);
    h1.setBackground(new Color(68,65,68));   
    h1.setFont(new Font("Paris Van", Font.BOLD,15)); 

    l1 = new Label("Please Enter your Username: ");
    tf1 = new TextField(10);
    l2 = new Label("Please Enter your Password: ");
    tf2 = new TextField(10);
    tf2.setEchoChar('*');
    l3 = new Label("Please Enter confirm Password: ");
    tf3 = new TextField(10);
    tf3.setEchoChar('*');
    b1 = new Button("Sign-in");
    b2 = new Button("Reset");
    b3 = new Button("Log-in");
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
    
    l3.setBounds(105,300,180,25);
    l3.setFont(new Font("Times New Roman", Font.BOLD,12));
    l3.setForeground(Color.white);
    l3.setBackground(new Color(68,65,68));
    
    tf3.setBounds(290,300,100,25);

    b2.setBounds(110,350,70,25);
    b1.setBounds(210,350,70,25);
    b3.setBounds(310,350,70,25);

    add(h1);
    add(l1);
    add(tf1);
    add(l2);
    add(tf2);
    add(l3);
    add(tf3);
    add(b1);
    add(b2);
    add(b3);
    b1.addActionListener(this); 
    b2.addActionListener(this);
    b3.addActionListener(this);
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
public void reader()
{  
    try{ 
            
            File f=new File("data.txt");
            FileReader fr=new FileReader(f);
            Scanner myReader = new Scanner(fr);
            while (myReader.hasNextLine()) //&& (!(tf1.getSource()).equals())) 
            {
                b=" ";
            String data = myReader.nextLine();
            System.out.println(myReader.hasNextLine());
            if((tf1.getText()).equals(data))
            {   
                b=data;
                System.out.println(data);
                 break;
            }
            data = myReader.nextLine();
                
            }
            fr.close();                

    }catch(IOException x){
    System.out.println("harish "+x);
    }
}




public  void actionPerformed(ActionEvent ae)
{
    while(true){
       flag=0;
    if(ae.getSource()==b1)
    {
        if(((tf1.getText()).length())<=0)
        {
            alert a=new alert(1);
            // a.setSize(400,250);
            // a.setVisible(true);  
            break;    
        }
        if(((tf2.getText()).length())<=0 || ((tf3.getText()).length())<=0)
        {
            alert a=new alert(2);
            //a.setSize(400,250);
            //a.setVisible(true);    
            break;
        }
        
             
            try{
                      if((tf2.getText()).equals((tf3.getText())))
                    {
                    File f=new File("data.txt");
                    FileWriter fw=new FileWriter(f,true);
                    reader();
                    if((tf1.getText()).equals(b)){ break;}  
                    fw.write((tf1.getText())+"\n");
                    fw.write((tf2.getText())+"\n"); 
                    System.out.println(tf2.getText()+" "+tf3.getText());
                    new Login();
                    fw.close();
                    break;
                    }
                    else{
                        flag=1;   
                        break; 
                    }
                
                } catch(IOException x)
                {
                    System.out.println("harish "+x);
                }
          
       }
            if(flag==1){break;}
         if((tf1.getText()).equals(b)){ break;} 


        if(ae.getSource()==b2)
    {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        break;
    }
    if(ae.getSource()==b3)
    {
        new Login();
        break;
    }                

    }
    if(flag==1)
    {
        alert a=new alert(4);
        // a.setSize(300,300);
        // a.setVisible(true); 
    }
    if((tf1.getText()).equals(b))
    { 
        alert a=new alert(3);
        // a.setSize(300,300);
        // a.setVisible(true);
        // break;
    }
    
    
    

}



public static void main(String args[])
{
    Register r=new Register();
}


}
class MyWindowAdapter extends WindowAdapter
{
    public void windowClosing(WindowEvent we)
    {
        System.exit(0);
    }
}




 //  while((i=fr.read())!=-1)
            // {
            //     if(((char) i).equals(c))
            //     {
            //         String s = new String(((char)i));
            //          System.out.println(s);
            //     }
               
                // if(((char) i).equals(tf1.getText()))
                // {
                //     System.out.println("This Username is already register");
                //     Login l=new Login();
                //     l.setSize(500,500);
                //     l.setVisible(true);
                // }