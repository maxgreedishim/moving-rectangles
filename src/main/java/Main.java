import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static String title = "Движущие прямоугольники";
    private final static int width = 1024;
    private final static int height = 640;
    private static int trafficFig0X;
    private static int trafficFig0Y;
    private static int trafficFig1X;
    private static int trafficFig1Y;
    static int getWidth() {

        return width;
    }
    static int getHeight() {

        return height;
    }
    static int getTrafficFig0X() {
        return trafficFig0X;
    }
    static int getTrafficFig0Y() {
        return trafficFig0Y;
    }
    static int getTrafficFig1X() {
        return trafficFig1X;
    }
    static int getTrafficFig1Y() {
        return trafficFig1Y;
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
        Graphics graphics;
        List <Rectangle> rectangleList = new ArrayList<>();
        /*Rectangle rectangle = new Rectangle(new Point(0,0),50,50);
        rectangleList.add(rectangle);*/
        rectangleList.add(new Rectangle(new Point(550,190),50,50));
        rectangleList.add(new Rectangle(new Point(750,300),50,50));
        rectangleList.add(new Rectangle(new Point(50,150),50,50));
        rectangleList.add(new Rectangle(new Point(950,200),50,50));
       /* rectangleList.add(new Rectangle(new Point(100,50),50,50));
        rectangleList.add(new Rectangle(new Point(250,80),50,50));*/

        while (true) {
            trafficFig0X = rectangleList.get(0).getX();
            trafficFig0Y = rectangleList.get(0).getY();
            trafficFig1X = rectangleList.get(1).getX();
            trafficFig1Y = rectangleList.get(1).getY();
            bufferStrategy = canvas.getBufferStrategy();
            graphics = bufferStrategy.getDrawGraphics();
            graphics.clearRect(0, 0, width, height);
            graphics.setColor(Color.GREEN);
            for (Rectangle rect : rectangleList)graphics.drawRect(rect.getX(),
                    rect.getY(), rect.getWidth(),rect.getHeight());
            bufferStrategy.show();
            graphics.dispose();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
