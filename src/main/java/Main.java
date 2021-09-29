import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static String title = "Движущие прямоугольники";
    private final static int width = 1024;
    private final static int height = 640;
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
        Rectangle testRect = new Rectangle(new Point(0,0),100,100);
        rectangleList.add(new Rectangle(new Point(100,0),50,50));
        rectangleList.add(testRect);
        while (true) {
            bufferStrategy = canvas.getBufferStrategy();
            graphics = bufferStrategy.getDrawGraphics();
            graphics.clearRect(0, 0, width, height);
            graphics.setColor(Color.GREEN);
            for (Rectangle rect : rectangleList)graphics.drawRect(rect.getX(),
                    rect.getY(), rect.getWidth(),rect.getHeight());
            bufferStrategy.show();
            graphics.dispose();
        }
    }
}
