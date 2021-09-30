enum DirectionsV {
    UP,
    DOWN
}
enum DirectionsH {
    LEFT,
    RIGHT
}

class Vector {
    private DirectionsV dirV = DirectionsV.DOWN;
    private DirectionsH dirH = DirectionsH.RIGHT;
    private int speedH;
    private int speedV;
    private Point currentPoint;

    Vector(DirectionsV dirV, DirectionsH dirH, int speedH, int speedV, Point currentPoint) {
        this.dirV = dirV;
        this.dirH = dirH;
        this.speedH = speedH;
        this.speedV = speedV;
        this.currentPoint = currentPoint;
    }

   void toggleV() {
         if (dirV == DirectionsV.DOWN) dirV = DirectionsV.UP;
         else dirV = DirectionsV.DOWN;
    }

    void toggleH() {
        if (dirH == DirectionsH.RIGHT) dirH = DirectionsH.LEFT;
        else dirH = DirectionsH.RIGHT;
    }


    Point nextStep(){
        currentPoint.x += (dirH == DirectionsH.RIGHT ? speedH : speedH * -1 );
        currentPoint.y += (dirV == DirectionsV.DOWN ? speedV : speedV * -1 );

        return currentPoint;
    }

}
