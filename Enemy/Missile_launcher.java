package Enemy;

import Bullet.Bullet;
import Bullet.Missile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;

public class Missile_launcher extends ArmyEnemy{
    public Missile_launcher(Image launcher_img,int coordinates_x, int coordinates_y, int width , int height,
                            String shooting_direction,Missile missile){
        super(launcher_img,coordinates_x,coordinates_y,width,height,shooting_direction,missile);
        this.missile = missile;
    }

    private Missile missile;
    private ArrayList<Missile> Missile_list = new ArrayList<>();
    private static final Image Missile_launcher = new ImageIcon("Assets/launcher.png").getImage();
    public static Image getMissile_launcher(){
        return Missile_launcher;
    }

    private static final Object[][] missileLauncherCoordinates = {
            {Missile_launcher,160,300,30,30,"up"}
    };

    public static Object[][] getMissileLauncherCoordinates(){
        return missileLauncherCoordinates;
    }

    @Override
    public ArrayList<Missile> getRocketList(){
        return  Missile_list;
    }
    @Override
    public void shootingRocket(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Missile_list.add(new Missile(missile.getRocket_bullet_img(),missile.getPosition_coordinates_x(),missile.getPosition_coordinates_y(),
                        missile.getFinal_coordinates_x(),missile.getFinal_coordinates_y()));
            }
        };
        timer.schedule(task,0,1500);
    }
    @Override
    public void editRocketList(){
        for (int i =0; i< Missile_list.size(); i++){
            if (Missile_list.get(i).getPosition_coordinates_y() == Missile_list.get(i).getFinal_coordinates_y()){
                Missile_list.remove(i);
            }
        }
    }

    @Override
    public int damageShooting(){
        return 3;
    }
    @Override
    public int killing_enemy_score(){
        return 15;
    }
}
