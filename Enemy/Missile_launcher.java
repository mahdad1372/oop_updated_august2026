package Enemy;

import Bullet.Bullet;
import Bullet.Missile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;

public class Missile_launcher extends ArmyEnemy{
    public Missile_launcher(int coordinates_x, int coordinates_y, Image launcher_img, int width , int height, Missile missile,
                            String shooting_direction){
        super(launcher_img,coordinates_x,coordinates_y,width,height,missile,shooting_direction);
        this.missile = missile;
    }

    private Missile missile;
    private ArrayList<Missile> Missile_list = new ArrayList<>();
    private static final Image Missile_launcher = new ImageIcon("Assets/launcher.png").getImage();
    public static Image getMissile_launcher(){
        return Missile_launcher;
    }
    @Override
    public ArrayList<Missile> getRocket_List(){
        return  Missile_list;
    }
    @Override
    public void Shooting_Rocket(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Missile_list.add(new Missile(missile.getPosition_coordinates_x(),missile.getPosition_coordinates_y(),
                        missile.getRocket_bullet_img(),missile.getFinal_coordinates_x(),missile.getFinal_coordinates_y()));
            }
        };
        timer.schedule(task,0,1500);
    }
    @Override
    public void EditRocket_List(){
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
