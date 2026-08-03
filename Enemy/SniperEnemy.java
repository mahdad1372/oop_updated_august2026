package Enemy;

import Bullet.Bullet;
import Bullet.Rocket_Bullet;

import Bullet.Missile;
import Bullet.SniperBullet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SniperEnemy extends ArmyEnemy{

    public SniperEnemy(int coordinates_x, int coordinates_y, Image launcher_img, int width , int height, SniperBullet bullet,String shooting_direction){
            super(launcher_img,coordinates_x,coordinates_y,width,height,bullet,shooting_direction);
            this.sniperBullet = bullet;
        }
    private SniperBullet sniperBullet;
    private ArrayList<SniperBullet> sniper_bullet_list = new ArrayList<>();
    private static final Image sniper_img = new ImageIcon("Assets/Sniper.png").getImage();
    public static Image getSniperImage(){
        return sniper_img;
    }
    private static ArmyEnemy sniper_enemy;
    public static void setSniperEnemy(ArmyEnemy sniper){
        sniper_enemy =sniper;
    }
    public static ArmyEnemy getSniper_enemy(){
        return sniper_enemy;
    }

    @Override
    public void Shooting_Rocket(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                sniper_bullet_list.add(new SniperBullet(sniperBullet.getPosition_coordinates_x(),sniperBullet.getPosition_coordinates_y()
                        ,sniperBullet.getSniperBullet_img(),sniperBullet.getFinal_coordinates_x(),sniperBullet.getFinal_coordinates_y()));
            }
        };
        timer.schedule(task,0,1500);
    }
    @Override
    public ArrayList<SniperBullet> getRocket_List(){
        return sniper_bullet_list;
    }
    @Override
    public void EditRocket_List(){
        for (int i=0;i < sniper_bullet_list.size();i++){
            if(sniper_bullet_list.get(i).getPosition_coordinates_y() == sniper_bullet_list.get(i).getFinal_coordinates_y()){
                sniper_bullet_list.remove(i);
            }
        }
    }
    @Override
    public int damageShooting(){
        return 8;
    }
}
