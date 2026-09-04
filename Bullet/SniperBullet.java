package Bullet;

import javax.swing.*;
import java.awt.*;

public class SniperBullet extends Rocket_Bullet {
    public SniperBullet(Image sniperBullet_img,int position_x , int position_y ,  int finalPosition_x,int final_position_y){
        super(sniperBullet_img,position_x, position_y,finalPosition_x,final_position_y);
    }

    private final static Image sniperBullet_img  = new ImageIcon("Assets/sniper_bullet.png").getImage();
    private final static Object[][] SniperBulletCoordinates = {
            {sniperBullet_img,470,10,470,230}
    };
    public static Object[][] getSniperBulletCoordinates(){
        return SniperBulletCoordinates;
    }
}
