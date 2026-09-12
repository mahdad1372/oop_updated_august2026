package Obstacles;

import Interfaces.hitBox;


public abstract class obstacle implements hitBox {
    public obstacle(int coordinatesX, int coordinatesY, int width, int height){
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.width = width;
        this.height = height;
    }
    private int coordinatesX;
    private int coordinatesY;
    private int width;
    private int height;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getCoordinatesX() {
        return coordinatesX;
    }
    public int getCoordinatesY(){
        return coordinatesY;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
