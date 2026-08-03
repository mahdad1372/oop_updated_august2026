package Bullet;

import javax.swing.*;
import java.awt.*;

public class SniperBullet extends Rocket_Bullet {
    public SniperBullet(int position_x , int position_y , Image sniperBullet_img, int finalPosition_x,int final_position_y){
        super(position_x, position_y,sniperBullet_img,finalPosition_x,final_position_y);
    }

    private final static Image sniperBullet_img  = new ImageIcon("Assets/sniper_bullet.png").getImage();

    public static Image getSniperBullet_img(){
        return sniperBullet_img;
    }
    private static final Object[][] sniper_bullet_coordinates = {
            {470,10,sniperBullet_img , 470,230}
    };
    public static Object[][] getSniper_bullet_coordinates(){
        return sniper_bullet_coordinates;
    }
}
