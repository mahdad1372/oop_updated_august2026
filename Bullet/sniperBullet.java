package Bullet;

import javax.swing.*;
import java.awt.*;

public class sniperBullet extends rocketBullet {
    public sniperBullet(Image sniperBulletImg, int positionX , int positionY,int width,int height , int finalPositionX, int finalPositionY){
        super(sniperBulletImg,positionX, positionY,width,height,finalPositionX,finalPositionY);
    }

    private final static Image sniperBulletImg  = new ImageIcon("Assets/sniper_bullet.png").getImage();
    private final static Object[][] SniperBulletCoordinates = {
            {sniperBulletImg,470,10,30,30,470,230}
    };
    public static Object[][] getSniperBulletCoordinates(){
        return SniperBulletCoordinates;
    }
}
