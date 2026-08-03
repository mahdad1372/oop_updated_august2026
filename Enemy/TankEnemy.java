package Enemy;

import Bullet.Tank_rocket;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
public class TankEnemy extends ArmyEnemy {
    public TankEnemy(Image tank_img, int coordinates_x, int coordinates_y, int width, int height, Tank_rocket rocket,String shooting_direction){
        super(tank_img,coordinates_x,coordinates_y,width,height,rocket,shooting_direction);
        this.tank_rocket = rocket;
    }

    private static final Image tank_img = new ImageIcon ("Assets/tank.png").getImage();
    public static Image getTank_img(){
        return tank_img;
    }
    private Tank_rocket tank_rocket;
    private ArrayList<Tank_rocket> TankRocketList = new ArrayList<>();
    private static ArmyEnemy tankEnemy;
    public static void setTankenemy(ArmyEnemy tank){
         tankEnemy = tank;
    }
    public static ArmyEnemy getTankEnemy(){
        return tankEnemy;
    }
    @Override
    public ArrayList<Tank_rocket> getRocket_List(){
        return TankRocketList;
    }
    @Override
    public void Shooting_Rocket(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                TankRocketList.add(new Tank_rocket(tank_rocket.getPosition_coordinates_x(),tank_rocket.getPosition_coordinates_y(),
                        tank_rocket.getRocket_bullet_img(),tank_rocket.getFinal_coordinates_x(),tank_rocket.getFinal_coordinates_y()));

            }
        };
        timer.schedule(task,0,1500);
    }
    @Override
    public void EditRocket_List(){
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
