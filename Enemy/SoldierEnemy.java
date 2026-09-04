package Enemy;

import Bullet.Bullet;
import Bullet.Soldier_rocket;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
public class SoldierEnemy extends ArmyEnemy {
    public SoldierEnemy(Image soldier_img, int coordinates_x, int coordinates_y, int width, int height, String shooting_direction,
                        Soldier_rocket soldierRocket){
        super(soldier_img,coordinates_x,coordinates_y,width,height,shooting_direction,soldierRocket);
        this.soldierRocket = soldierRocket;
    }
    private static final Image Soldier_enemy_icon = new ImageIcon("Assets/Soldier_enemy.png").getImage();
    private final Soldier_rocket soldierRocket;
    private final ArrayList<Soldier_rocket> SoldierRockets_list = new ArrayList<>();
    private final static Object[][] SoldierEnemyCoordinates = {
            {Soldier_enemy_icon,660, 320, 40, 40,"up"}
    };
    public static Object[][] getSoldierEnemyCoordinates(){
        return SoldierEnemyCoordinates;
    }
    @Override
    public void shootingRocket(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                SoldierRockets_list.add(new Soldier_rocket(soldierRocket.getRocket_bullet_img(),soldierRocket.getCoordinates_x(),
                        soldierRocket.getCoordinates_y(),soldierRocket.getFinal_coordinates_x(),soldierRocket.getFinal_coordinates_y()));
            }
        };
        timer.schedule(task,0,1500);
    }
    @Override
    public ArrayList<? extends Bullet> getRocketList(){
        return SoldierRockets_list;
    }
    @Override
    public void editRocketList(){
        for (int i=0; i< SoldierRockets_list.size();i++){
            if (SoldierRockets_list.get(i).getCoordinates_y() == SoldierRockets_list.get(i).getFinal_coordinates_y()){
                SoldierRockets_list.remove(i);
            }
        }
    }
    @Override
    public int damageShooting(){
        return 6;
    }
}