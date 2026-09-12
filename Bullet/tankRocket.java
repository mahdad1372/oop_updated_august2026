package Bullet;

import javax.swing.*;
import java.awt.*;

public class tankRocket extends rocketBullet {
    public tankRocket(Image tankRocket, int coordinateX , int coordinateY, int width,int height,int finalPositionX, int finalPositionY){
        super(tankRocket,coordinateX,coordinateY,width,height,finalPositionX,finalPositionY);
    }

    private static final Image tankRocketImg = new ImageIcon("Assets/tank_rocket.png").getImage();
    private static final Object[][] tanksRocketCoordinates = {
            {tankRocketImg,580,230,30,30,580,50}
    };
    public static Object[][] getTanksRocketCoordinates(){
        return tanksRocketCoordinates;
    }
}
