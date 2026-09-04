package Enemy;

import Bullet.Bullet;
import Bullet.Missile;
import Bullet.Rocket_Bullet;
import Interfaces.Army_enemy_details;
import Interfaces.Enemy_hit;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ArmyEnemy extends Enemy implements Army_enemy_details {
    public ArmyEnemy(Image enemy_image, int coordinates_x, int coordinates_y,  int width, int height,String shooting_direction,Rocket_Bullet rocketBullet){
        super(enemy_image,coordinates_x,coordinates_y,width,height);
        this.rocketBullet = rocketBullet;
        this.shooting_direction = shooting_direction;
    }
    private final String shooting_direction;
    private final Rocket_Bullet rocketBullet;
    private final ArrayList<Rocket_Bullet> Rocketbullet_List = new ArrayList<>();

    @Override
    public void shootingRocket(){
    java.util.Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Rocketbullet_List.add(new Rocket_Bullet(rocketBullet.getRocket_bullet_img(),rocketBullet.getPosition_coordinates_x(),rocketBullet.getPosition_coordinates_y(),
                    rocketBullet.getFinal_coordinates_x(),rocketBullet.getFinal_coordinates_y()));
        }
    };
    timer.schedule(task,0,1500);
    }
    @Override
    public void editRocketList(){
        for (int i=0; i < Rocketbullet_List.size();i++){
            if (Rocketbullet_List.get(i).getPosition_coordinates_y() == Rocketbullet_List.get(i).getFinal_coordinates_y()){
                Rocketbullet_List.remove(i);
            }
        }
    }
    @Override
    public ArrayList<? extends Bullet> getRocketList(){
        return Rocketbullet_List;
    }
    @Override
    public int killing_enemy_score(){
        return 10;
    }

    @Override
    public int damageShooting(){
        return 5;
    }
    public String getShooting_direction(){
        return shooting_direction;
    }
}
