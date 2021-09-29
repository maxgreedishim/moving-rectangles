import java.awt.Graphics;

class Rectangle implements Runnable {
    private Vector vector;
    private Point currentPoint;
    private int width;
    private int height;
    private Graphics graphics;

    Rectangle(Point startPoint, int width, int height) {
        this.height = height;
        this.currentPoint = startPoint;
        this.width = width;
        this.vector = new Vector(DirectionsV.DOWN, DirectionsH.RIGHT, 2, 3, startPoint);
        new Thread(this).start();
    }
    void setGraphics (Graphics graphics){
        this.graphics = graphics;
    }
    int getWidth() {
        return width;
    }
    int getHeight() {
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

        for (int i = 0; i < 50 ; i++){
            System.out.println("x = " + currentPoint.x + " y = " + currentPoint.y);
            Point next = this.vector.nextStep();
            currentPoint = next;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}