import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String title;
    private final static int width = 1024;
    private final static int height = 640;
    static {
        title = "Движущие прямоугольники";
    }
    static int getWidth() {

        return width;
    }
    static int getHeight() {

        return height;
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLACK);
        Canvas canvas = new Canvas();
        frame.add(canvas);
        canvas.createBufferStrategy(3);
        BufferStrategy bufferStrategy;
        Graphics graphics,graphicsStick;
        List <Rectangle> rectangleList = new ArrayList<>();

        /*Rectangle rectangle = new Rectangle(new Point(0,0),50,50);
        rectangleList.add(rectangle);*/
        rectangleList.add(new Rectangle(new Point(550,190),50,50));
        rectangleList.add(new Rectangle(new Point(450,290),50,50));

        //rectangleList.add(new Stick( new Point(10,10),12,190));
       /* rectangleList.add(new Rectangle(new Point(100,50),50,50));
        rectangleList.add(new Rectangle(new Point(250,80),50,50));*/

        while (true) {
            bufferStrategy = canvas.getBufferStrategy();
            graphics = bufferStrategy.getDrawGraphics();
            graphics.clearRect(0, 0, width, height);
            graphics.setColor(Color.GREEN);


            for (Rectangle rect : rectangleList)graphics.drawRect(rect.getX(),
                    rect.getY(), rect.getWidth(),rect.getHeight());


            bufferStrategy.show();
            graphics.dispose();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
