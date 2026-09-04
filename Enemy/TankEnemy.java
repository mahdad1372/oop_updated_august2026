package Enemy;

import Bullet.Tank_rocket;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
public class TankEnemy extends ArmyEnemy {
    public TankEnemy(Image tank_img, int coordinates_x, int coordinates_y, int width, int height,String shooting_direction,Tank_rocket rocket){
        super(tank_img,coordinates_x,coordinates_y,width,height,shooting_direction,rocket);
        this.tank_rocket = rocket;
    }

    private static final Image tank_img = new ImageIcon ("Assets/tank.png").getImage();
    private static final Object[][] tank_enemy_coordinates = {
            {tank_img,580,250,40,40,"up"}
    };
    public static Object[][] getTank_enemy_coordinates(){
        return tank_enemy_coordinates;
    }
    private final Tank_rocket tank_rocket;
    private final ArrayList<Tank_rocket> TankRocketList = new ArrayList<>();

    @Override
    public ArrayList<Tank_rocket> getRocketList(){
        return TankRocketList;
    }
    @Override
    public void shootingRocket(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                TankRocketList.add(new Tank_rocket(tank_rocket.getRocket_bullet_img(),tank_rocket.getPosition_coordinates_x(),tank_rocket.getPosition_coordinates_y(),
                        tank_rocket.getFinal_coordinates_x(),tank_rocket.getFinal_coordinates_y()));

            }
        };
        timer.schedule(task,0,1500);
    }
    @Override
    public void editRocketList(){
        for (int i=0;i < TankRocketList.size();i++){
            if(TankRocketList.get(i).getPosition_coordinates_y() == TankRocketList.get(i).getFinal_coordinates_y()){
                TankRocketList.remove(i);
            }
        }
    }
    @Override
    public int damageShooting(){
        return 6;
    }
}
