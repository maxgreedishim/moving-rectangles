class FieldWalls {
    private int width;
    private int height;
    private int errorW = 17;
    private int errorH = 38;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public FieldWalls() {
        width = Main.getWidth() - Rectangle.getWidth() - errorW;
        height = Main.getHeight() - Rectangle.getHeight() - errorH;
    }
}
