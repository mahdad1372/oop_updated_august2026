package Enemy;
import Bullet.sniperBullet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class sniperEnemy extends armyEnemy {

    public sniperEnemy(Image launcherImg, int coordinatesX, int coordinatesY, int width , int height, String shootingDirection, sniperBullet bullet){
            super(launcherImg,coordinatesX,coordinatesY,width,height,shootingDirection,bullet);
            this.sniperBullet = bullet;
        }
    private final sniperBullet sniperBullet;
    private final ArrayList<sniperBullet> sniperBulletList = new ArrayList<>();
    private static final Image sniperImg = new ImageIcon("Assets/Sniper.png").getImage();

    private static final Object[][] sniperEnemyCoordinates = {
            {sniperImg,470,10,20,20,"down"}
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
                sniperBulletList.add(new sniperBullet(sniperBullet.getRocketBulletImg(),sniperBullet.getCoordinatesX(),sniperBullet.getCoordinatesY()
                        ,sniperBullet.getWidth(),sniperBullet.getHeight(),sniperBullet.getFinalCoordinatesX(),sniperBullet.getFinalCoordinatesY()));
            }
        };
        timer.schedule(task,0,1500);
    }
    @Override
    public ArrayList<sniperBullet> getRocketList(){
        return sniperBulletList;
    }
    @Override
    public void editRocketList(){
        for (int i=0;i < sniperBulletList.size();i++){
            if(sniperBulletList.get(i).getCoordinatesY() == sniperBulletList.get(i).getFinalCoordinatesY()){
                sniperBulletList.remove(i);
            }
        }
    }
    @Override
    public int damageShooting(){
        return 8;
    }
}
