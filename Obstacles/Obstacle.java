package Obstacles;

import Interfaces.Enemy_hit;


public abstract class Obstacle implements Enemy_hit {
    public Obstacle(int coordinates_x,int coordinates_y, int width,int height){
        this.coordinates_x = coordinates_x;
        this.coordinates_y = coordinates_y;
        this.width = width;
        this.height = height;
    }
    private int coordinates_x;
    private int coordinates_y;
    private int width;
    private int height;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getCoordinates_x() {
        return coordinates_x;
    }
    public int getCoordinates_y(){
        return coordinates_y;
    }
    public void setCoordinates_x(int coordinates_x){
        this.coordinates_x = coordinates_x;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setCoordinates_y(int coordinates_y) {
        this.coordinates_y = coordinates_y;
    }
}
