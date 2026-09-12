package Enemy;

import Bullet.missile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;

public class missileLauncher extends armyEnemy {
    public missileLauncher(Image launcherImg, int coordinatesX, int coordinatesY, int width , int height,
                           String shootingDirection, missile missile){
        super(launcherImg,coordinatesX,coordinatesY,width,height,shootingDirection,missile);
        this.missile = missile;
    }

    private missile missile;
    private ArrayList<missile> missileList = new ArrayList<>();
    private static final Image missileLauncherImg = new ImageIcon("Assets/launcher.png").getImage();
    private static final Object[][] missileLauncherCoordinates = {
            {missileLauncherImg,160,300,30,30,"up"}
    };

    public static Object[][] getMissileLauncherCoordinates(){
        return missileLauncherCoordinates;
    }

    @Override
    public ArrayList<missile> getRocketList(){
        return missileList;
    }
    @Override
    public void shootingRocket(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                missileList.add(new missile(missile.getRocketBulletImg(),missile.getCoordinatesX(),missile.getCoordinatesY(),
                        missile.getWidth(),missile.getHeight(),missile.getFinalCoordinatesX(),missile.getFinalCoordinatesY()));
            }
        };
        timer.schedule(task,0,1500);
    }
    @Override
    public void editRocketList(){
        for (int i = 0; i< missileList.size(); i++){
            if (missileList.get(i).getCoordinatesY() == missileList.get(i).getFinalCoordinatesY()){
                missileList.remove(i);
            }
        }
    }

    @Override
    public int damageShooting(){
        return 3;
    }
    @Override
    public int killingEnemyScore(){
        return 15;
    }
}
