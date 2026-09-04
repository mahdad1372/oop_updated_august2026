package Enemy;
import Bullet.SniperBullet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SniperEnemy extends ArmyEnemy{

    public SniperEnemy(Image launcher_img,int coordinates_x, int coordinates_y,  int width , int height,String shooting_direction,SniperBullet bullet){
            super(launcher_img,coordinates_x,coordinates_y,width,height,shooting_direction,bullet);
            this.sniperBullet = bullet;
        }
    private final SniperBullet sniperBullet;
    private final ArrayList<SniperBullet> sniper_bullet_list = new ArrayList<>();
    private static final Image sniper_img = new ImageIcon("Assets/Sniper.png").getImage();

    private static final Object[][] sniperEnemyCoordinates = {
            {sniper_img,470,10,20,20,"down"}
    };

    public static Object[][] getSniperEnemyCoordinates() {
        return sniperEnemyCoordinates;
    }



    @Override
    public void shootingRocket(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                sniper_bullet_list.add(new SniperBullet(sniperBullet.getRocket_bullet_img(),sniperBullet.getPosition_coordinates_x(),sniperBullet.getPosition_coordinates_y()
                        ,sniperBullet.getFinal_coordinates_x(),sniperBullet.getFinal_coordinates_y()));
            }
        };
        timer.schedule(task,0,1500);
    }
    @Override
    public ArrayList<SniperBullet> getRocketList(){
        return sniper_bullet_list;
    }
    @Override
    public void editRocketList(){
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
