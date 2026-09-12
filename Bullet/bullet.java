package Bullet;

import Interfaces.hitBox;
import Interfaces.bulletMovement;
import java.awt.*;

public abstract class bullet implements bulletMovement, hitBox {
    bullet(Image bulletImage , int x , int y,int width,int height){
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.width =width;
        this.height = height;
        this.img = bulletImage;
    }
    private final int width ;
    private final int height;
    private int coordinatesX;
    private int coordinatesY;
    private Image img;

    public int getWidth(){
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Image getImgBullet(){
        return img;
    }
    public int getCoordinatesX(){
        return coordinatesX;
    }
    public int getCoordinatesY(){
        return coordinatesY;
    }
    public void setCoordinatesX(int coordinatesX){
        this.coordinatesX = coordinatesX;
    }
    public void setCoordinatesY(int coordinatesY){
        this.coordinatesY = coordinatesY;
    }
}
