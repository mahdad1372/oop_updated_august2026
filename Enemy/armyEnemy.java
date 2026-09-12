package Enemy;

import Bullet.bullet;
import Bullet.rocketBullet;
import Interfaces.armyEnemyDetails;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class armyEnemy extends enemy implements armyEnemyDetails {
    public armyEnemy(Image enemy_image, int coordinates_x, int coordinates_y, int width, int height, String shootingDirection, rocketBullet rocketBullet){
        super(enemy_image,coordinates_x,coordinates_y,width,height);
        this.rocketBullet = rocketBullet;
        this.shootingDirection = shootingDirection;
    }
    private final String shootingDirection;
    private final rocketBullet rocketBullet;
    private final ArrayList<rocketBullet> rocketBulletList = new ArrayList<>();
    private static final Image ArmyEnemy = new ImageIcon("Assets/military.png").getImage();
    private final static Object[][] armyEnemyCoordinates = {
            {ArmyEnemy,400,130,20,20,"down"}
    };

    public static Object[][] getArmyEnemyCoordinates() {
        return armyEnemyCoordinates;
    }

    @Override
    public void shootingRocket(){
    java.util.Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            rocketBulletList.add(new rocketBullet(rocketBullet.getRocketBulletImg(),rocketBullet.getCoordinatesX(),rocketBullet.getCoordinatesY(),
                    rocketBullet.getWidth(),rocketBullet.getHeight(),
                    rocketBullet.getFinalCoordinatesX(),rocketBullet.getFinalCoordinatesY()));
        }
    };
    timer.schedule(task,0,1500);
    }
    @Override
    public void editRocketList(){
        for (int i=0; i < rocketBulletList.size();i++){
            if (rocketBulletList.get(i).getCoordinatesY() == rocketBulletList.get(i).getFinalCoordinatesY()){
                rocketBulletList.remove(i);
            }
        }
    }
    @Override
    public ArrayList<? extends bullet> getRocketList(){
        return rocketBulletList;
    }
    @Override
    public int killingEnemyScore(){
        return 10;
    }

    @Override
    public int damageShooting(){
        return 5;
    }
    public String getShootingDirection(){
        return shootingDirection;
    }
}
