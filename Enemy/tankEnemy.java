package Enemy;

import Bullet.tankRocket;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
public class tankEnemy extends armyEnemy {
    public tankEnemy(Image tank_img, int coordinates_x, int coordinates_y, int width, int height, String shooting_direction, tankRocket rocket){
        super(tank_img,coordinates_x,coordinates_y,width,height,shooting_direction,rocket);
        this.tankRocket = rocket;
    }

    private static final Image tankImg = new ImageIcon ("Assets/tank.png").getImage();
    private static final Object[][] tankEnemyCoordinates = {
            {tankImg,580,250,40,40,"up"}
    };
    public static Object[][] getTankEnemyCoordinates(){
        return tankEnemyCoordinates;
    }
    private final tankRocket tankRocket;
    private final ArrayList<tankRocket> tankRocketList = new ArrayList<>();

    @Override
    public ArrayList<tankRocket> getRocketList(){
        return tankRocketList;
    }
    @Override
    public void shootingRocket(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                tankRocketList.add(new tankRocket(tankRocket.getRocketBulletImg(), tankRocket.getCoordinatesX(), tankRocket.getCoordinatesY(),
                        tankRocket.getWidth(),tankRocket.getHeight(),
                        tankRocket.getFinalCoordinatesX(), tankRocket.getFinalCoordinatesY()));

            }
        };
        timer.schedule(task,0,1500);
    }
    @Override
    public void editRocketList(){
        for (int i=0;i < tankRocketList.size();i++){
            if(tankRocketList.get(i).getCoordinatesY() == tankRocketList.get(i).getFinalCoordinatesY()){
                tankRocketList.remove(i);
            }
        }
    }
    @Override
    public int damageShooting(){
        return 6;
    }
}
