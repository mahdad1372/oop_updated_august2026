package Bullet;

import Interfaces.Enemy_hit;
import Interfaces.bullet_movement;

import java.awt.*;
import java.util.ArrayList;

public abstract class Bullet implements bullet_movement, Enemy_hit {
    Bullet(int x , int y , Image bullet_image){
        this.position_coordinates_x = x;
        this.position_coordinates_y = y;
        this.img = bullet_image;
    }
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    public int getWidth(){
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    private int position_coordinates_x;
    private int position_coordinates_y;
    private Image img;
    public Image getImg_bullet(){
        return img;
    }
    public int getPosition_coordinates_x(){
        return position_coordinates_x;
    }
    public int getPosition_coordinates_y(){
        return position_coordinates_y;
    }
    public void setPosition_coordinates_x(int coordinates_x){
        this.position_coordinates_x = coordinates_x;
    }
    public void setPosition_coordinates_y(int coordinates_y){
        this.position_coordinates_y = coordinates_y;
    }
    @Override
    public int getCoordinates_x() {
        return getPosition_coordinates_x();
    }
    @Override
    public int getCoordinates_y() {
        return getPosition_coordinates_y();
    }
}
