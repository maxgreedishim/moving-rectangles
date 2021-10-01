import java.awt.Graphics;

public class Rectangle implements Runnable {
    private Vector vector;
    private Point currentPoint;
    private static int width;
    private static int height;
    private Graphics graphics;

    Rectangle(Point startPoint, int width, int height) {
        this.height = height;
        this.width = width;
        this.currentPoint = startPoint;
        this.vector = new Vector(DirectionsV.UP, DirectionsH.RIGHT, 1, 1, startPoint);
        new Thread(this).start();
    }


    void setGraphics (Graphics graphics){

        this.graphics = graphics;
    }
    static int getWidth() {

        return width;
    }
    static int getHeight() {

        return height;
    }
    int getX() {
        return currentPoint.x;
    }
    int getY() {

        return currentPoint.y;
    }

    @Override
    public void run() {

        for (; ;){
            System.out.println("x = " + currentPoint.x + " y = " + currentPoint.y);
            Point next = this.vector.nextStep();
            currentPoint = next;
            FieldWalls fieldWalls = new FieldWalls();
            if (currentPoint.y >= fieldWalls.getHeight() ||
                    currentPoint.y <= 0 ) vector.toggleV();
            else if (currentPoint.x >= fieldWalls.getWidth()||
                    currentPoint.x <= 0) vector.toggleH();
            System.out.println("Объект0 "+ "X= " + Main.getTrafficFig0X() + " " + " Y= " + Main.getTrafficFig0Y() );
            System.out.println("Объект1 "+ "X= " + Main.getTrafficFig1X() + " " + " Y= " + Main.getTrafficFig1Y() );
            if (Main.getTrafficFig0Y() == Main.getTrafficFig1Y()  &&
                    Main.getTrafficFig0X() == Main.getTrafficFig1X() ) {
                System.out.println("СТОЛКНОВЕНИЕ СТОЛКНОВЕНИЕ!!!");
                vector.toggleV();
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}