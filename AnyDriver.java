//Ketan Richard
import javax.swing.*;
import java.awt.*;
public class AnyDriver
{
    public static void main(String[] args)
    {
        JFrame frame1 = new JFrame();
        //DrawingPanel ball1 = new DrawingPanel(Color.RED);
        BallPanel ball1 = new BallPanel(Color.RED);
        ball1.setPreferredSize(new Dimension(500,500));
        frame1.add(ball1);
        frame1.pack();
        frame1.setVisible(true);
    }
}