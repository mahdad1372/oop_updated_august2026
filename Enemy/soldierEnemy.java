package Enemy;
import Bullet.bullet;
import Bullet.soldierRocket;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
public class soldierEnemy extends armyEnemy {
    public soldierEnemy(Image soldier_img, int coordinates_x, int coordinates_y, int width, int height, String shooting_direction,
                        soldierRocket soldierRocket){
        super(soldier_img,coordinates_x,coordinates_y,width,height,shooting_direction,soldierRocket);
        this.soldierRocket = soldierRocket;
    }
    private static final Image soldierEnemyIcon = new ImageIcon("Assets/Soldier_enemy.png").getImage();
    private final soldierRocket soldierRocket;
    private final ArrayList<soldierRocket> soldierRocketsList = new ArrayList<>();
    private final static Object[][] soldierEnemyCoordinates = {
            {soldierEnemyIcon,660, 320, 40, 40,"up"}
    };
    public static Object[][] getSoldierEnemyCoordinates(){
        return soldierEnemyCoordinates;
    }
    @Override
    public void shootingRocket(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                soldierRocketsList.add(new soldierRocket(soldierRocket.getRocketBulletImg(),soldierRocket.getCoordinatesX(),
                        soldierRocket.getCoordinatesY(),
                        soldierRocket.getWidth(),soldierRocket.getHeight(),soldierRocket.getFinalCoordinatesX(),soldierRocket.getFinalCoordinatesY()));
            }
        };
        timer.schedule(task,0,1500);
    }
    @Override
    public ArrayList<? extends bullet> getRocketList(){
        return soldierRocketsList;
    }
    @Override
    public void editRocketList(){
        for (int i=0; i< soldierRocketsList.size();i++){
            if (soldierRocketsList.get(i).getCoordinatesY() == soldierRocketsList.get(i).getFinalCoordinatesY()){
                soldierRocketsList.remove(i);
            }
        }
    }
    @Override
    public int damageShooting(){
        return 6;
    }
}