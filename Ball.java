//Ketan Richard
import java.awt.*;
import javax.swing.*;
public class Ball
{
    private int x,y,diameter,speedx,speedy;
    private Color c;
    public Ball(int x, int y, int diameter, int speedx, int speedy, Color c)
    {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.speedx = speedx;
        this.speedy = speedy;
        this.c = c;
    }

    public Ball()
    {
        x = (int)(Math.random()*400 + 2);
        y = (int)(Math.random()*400 + 2);
        diameter = (int)(Math.random()*50 +10);
        speedx = (int)(Math.random()*2 +1);
        speedy = (int)(Math.random()*4 +1);
        c = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
    }

    public void draw(Graphics blah)
    {
        blah.setColor(c);
        blah.fillOval(x,y,diameter,diameter);
    }

    public void move()
    {
        x+=speedx;
        y+=speedy;
    }

    public void bounce(BallPanel p)
    {
        if(x<=0 || x>=p.getWidth()-diameter)
        {
            speedx*=-1;
        }
        if(y<=0 || y>=p.getHeight()-diameter)
        {
            speedy*=-1;
        }
    }

    public void moveDown(BallPanel p)
    {
        if(y+diameter<p.getHeight())
        {
            y+=4;
        }
    }

    public void moveUp(BallPanel p)
    {
        if(y>0 && y<p.getHeight())
        {
            y-=4;
        }
    }

    public void moveRight(BallPanel p)
    {
        x+=4;
        if(x > p.getWidth())
        {
            x=1-diameter;
        }
    }

    public void moveLeft(BallPanel p)
    {
        x-=4;
        if(x<0-diameter)
        {
            x=p.getWidth();
        }
    }

    public void setX(int inX)
    {
        x=inX-(int)(0.5*diameter);
    }

    public void setY(int inY)
    {
        y=inY-(int)(0.5*diameter);
    }

    public double getCeX()
    {
        double centX= x+(diameter/2);
        
        return centX;
    }
    public double getCeY()
    {
        double centY= y+(diameter/2);
        return centY;
    }
    public boolean deleteball(int xin, int yin)
    {
        double centerX, centerY,radius;
        radius = diameter/2;
        //centerX = x+radius;
        //centerY = y+radius;
        double distance = Math.sqrt(Math.pow((xin-getCeX()),2) + Math.pow((yin-getCeY()),2));
        if(radius >= distance)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}