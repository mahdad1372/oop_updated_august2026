package Bullet;

import javax.swing.*;
import java.awt.*;

public class missile extends rocketBullet {
    public missile(Image missileImg, int coordinateX, int coordinatesY,int width,int height , int finalPositionX, int finalPositionY){
        super(missileImg,coordinateX,coordinatesY,width,height,finalPositionX,finalPositionY);
    }

    private final static Image missileImg  = new ImageIcon ("Assets/missile.png").getImage();
    private static final Object[][] missileCoordinatesList = {
            {missileImg,160,310,30,30,270,200}
    };
    public static Object[][] getMissileCoordinatesList(){
        return missileCoordinatesList;
    }
    @Override
    public void shootingDirection(String direction){
        if (direction.equals("up")){
           if (getCoordinatesX() != getFinalCoordinatesX()){
               setCoordinatesX(getCoordinatesX()+5);
           }
           if (getCoordinatesY() != getFinalCoordinatesY()){
               setCoordinatesY(getCoordinatesY()-5);
           }
        }
    }
}
