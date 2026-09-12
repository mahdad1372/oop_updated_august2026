package Bullet;

import javax.swing.*;
import java.awt.*;

public class soldierRocket extends rocketBullet {
    public soldierRocket(Image soldierRocket, int coordinatesX, int coordinatesY,int width,int height, int finalCoordinatesX, int finalCoordinatesY){
        super(soldierRocket,coordinatesX,coordinatesY,finalCoordinatesX,finalCoordinatesY,width,height);
    }
    private final static Image soldierRocketImg = new ImageIcon("Assets/Soldier_rocket.png").getImage();
    private final static Object[][] soldierRocketCoordinates = {
        {soldierRocketImg,660,320,30,30,660,50}
    };
    public static Object[][] getSoldierRocketCoordinates(){
        return soldierRocketCoordinates;
    }
}
