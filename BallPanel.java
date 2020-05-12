//Ketan Richard
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*; //need this for listeners
import java.awt.AWTException; 
import java.awt.Robot; 
import java.awt.event.KeyEvent; 
import java.io.*;
import java.awt.image.*;
public class BallPanel extends JPanel
{
    private Color c;
    //private int x=10;
    //private int y=150;
    //private int xAdd=1;
    //private int yAdd=1;
    //private JButton button;
    private Ball b;
    //private ArrayList<Ball> balls = new ArrayList<Ball>();
    private Color u;
    private BufferedImage back;
    private int test;

    public BallPanel(Color c)
    {
        setBackground(c);
        b = new Ball(0,20,20,4,5,new Color(0,0,255));
        // for(int i=0; i<5; i++)
        // {
        // balls.add(new Ball());
        // }
        //button = new JButton("Add a Ball");
        //button.addActionListener(new MyFirstInnerClass()); //button listener

        isFocusable();
        //setFocusable(true);
        addKeyListener(new MyKeyListener()); //keyboard listener

        //addMouseListener(new MyMouseListener());//mouse listener
    }

    public void paintComponent(Graphics g)
    {
        //calling the paint component method that I overrode
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        if(back == null){
            int w = this.getWidth();
            int h = this.getHeight();
            back = (BufferedImage)(this.createImage(w,h));
            Graphics2D gback = back.createGraphics();
            setFocusable(true);
            gback.setColor(new Color(255,0,0));
            gback.fillRect(0,0,600,600);
            gback.setColor(new Color(0,255,0));        
            gback.fillRect(0,10,100,40);
            gback.fillRect(100,10,40,170);
            gback.fillRect(40,180,100,40);
            gback.fillRect(40,120,40,180);
            gback.fillRect(80,240,60,40);
            gback.fillRect(40,300,360,40);
        }
         g2.drawImage(back,null,0,0);
        
        

        //g.fillOval(x,y,30,30);
        //g.fillOval(x,60,30,30);
        //g.fillOval(80,y,30,30);
        //this.add(button);
        b.draw(g2);
        // for(Ball blah: balls)
        // {
        // blah.draw(g); //draws each ball
        // blah.move();
        // blah.bounce(this);
        // }
        Color k = new Color(back.getRGB((int)b.getCeX(), (int)b.getCeY()));
        if(k.equals(Color.RED)) test = 0;
        else  test = 1;
        
        try //delay loop
        {
            Thread.sleep(5);//pauses the computer; you pass milliseconds
        }
        catch(Exception e)
        {
        }
        this.repaint();//refreshes the screen
    }
    public class MyKeyListener extends KeyAdapter
    {
        public void keyPressed(KeyEvent e) 
        {
            //System.out.println(e.getKeyCode());              
            if(test == 1){
            if(e.getKeyCode() == 40) 
                {
                    b.moveDown(BallPanel.this);
                }
            if(e.getKeyCode() == 38) 
                {
                    b.moveUp(BallPanel.this);
                }
            if(e.getKeyCode() == 37) 
                {
                    b.moveLeft(BallPanel.this);

                }
            if(e.getKeyCode() == 39) 
                {
                    b.moveRight(BallPanel.this);
                }    
            }
        }
    }
    // public class MyFirstInnerClass implements ActionListener
    // {
    // public void actionPerformed(ActionEvent e)
    // {
    // balls.add(new Ball());
    // }
    // }
    
    // public class MyMouseListener extends MouseAdapter
    // {
    // public void mousePressed(MouseEvent ev)
    // {
    // //System.out.println("clicked");
    // //b.setX(ev.getX());
    // //b.setY(ev.getY());

    // try
    // {
    // for(Ball ke: balls)
    // {
    // if( ke.deleteball(ev.getX(),ev.getY())== true)
    // {
    // balls.remove(ke);
    // }
    // }
    // }
    // catch(Exception e)
    // {
    // }
    // }
    // }
}
