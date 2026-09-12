package Enemy;

import Bullet.*;
import Exceptions.InvalidGameDataException;
import Player.player;
import Results.resultBoard;
import utils.collisionUtils;
import java.awt.*;
import static Enemy.thief.getThiefList;

public final class enemyCreation {

    public static void createTankEnemy() throws InvalidGameDataException {
        tankRocket rocket;
        try {
            rocket = new tankRocket((Image) tankRocket.getTanksRocketCoordinates()[0][0],(Integer) tankRocket.getTanksRocketCoordinates()[0][1],
                    (Integer) tankRocket.getTanksRocketCoordinates()[0][2],
                    (Integer) tankRocket.getTanksRocketCoordinates()[0][3], (Integer) tankRocket.getTanksRocketCoordinates()[0][4],
                    (Integer) tankRocket.getTanksRocketCoordinates()[0][5], (Integer) tankRocket.getTanksRocketCoordinates()[0][6]);
            armyEnemy tank = new tankEnemy((Image) tankEnemy.getTankEnemyCoordinates()[0][0],
                    (int) tankEnemy.getTankEnemyCoordinates()[0][1], (int) tankEnemy.getTankEnemyCoordinates()[0][2],
                    (int) tankEnemy.getTankEnemyCoordinates()[0][3], (int) tankEnemy.getTankEnemyCoordinates()[0][4],
                    (String) tankEnemy.getTankEnemyCoordinates()[0][5],rocket);
            new trackedEnemy<>(tank);
            tank.shootingRocket();
        } catch (ClassCastException e) {
            throw new InvalidGameDataException("Tanks_rocket_coordinates row 0 has a value of the wrong type", e);
        }
    }

    public static void createThief() throws InvalidGameDataException {
        for (int i = 0; i < getThiefList().length; i++){
            try {
                enemy thief = new thief((Image) getThiefList()[i][0],(int) getThiefList()[i][1],(int) getThiefList()[i][2],
                        (int) getThiefList()[i][3],(int) getThiefList()[i][4],(String) getThiefList()[i][5],(int) getThiefList()[i][6],(int) getThiefList()[i][7]);
                new trackedEnemy<>(thief);
            } catch (ClassCastException e) {
                throw new InvalidGameDataException("thief_coordinates row " + i + " has a value of the wrong type", e);
            }
        }
      }

    public static void createMissileLauncher() throws InvalidGameDataException{
        try {
            missile missile = new missile((Image) Bullet.missile.getMissileCoordinatesList()[0][0],(int) Bullet.missile.getMissileCoordinatesList()[0][1],(int) Bullet.missile.getMissileCoordinatesList()[0][2]
            ,(int) Bullet.missile.getMissileCoordinatesList()[0][3],(int) Bullet.missile.getMissileCoordinatesList()[0][4],
            (int) Bullet.missile.getMissileCoordinatesList()[0][5],(int) Bullet.missile.getMissileCoordinatesList()[0][6]);
            armyEnemy missile_launcher = new missileLauncher((Image) missileLauncher.getMissileLauncherCoordinates()[0][0],
                    (int) missileLauncher.getMissileLauncherCoordinates()[0][1],(int) missileLauncher.getMissileLauncherCoordinates()[0][2],
                    (int) missileLauncher.getMissileLauncherCoordinates()[0][3],
                    (int) missileLauncher.getMissileLauncherCoordinates()[0][4], (String) missileLauncher.getMissileLauncherCoordinates()[0][5],missile);
            new trackedEnemy<>(missile_launcher);
            missile_launcher.shootingRocket();
        } catch (ClassCastException e) {
            throw new InvalidGameDataException("Missile launcher row has a value of the wrong type", e);
        }

    };
    public static void createSniperEnemy() throws InvalidGameDataException{
        try {
            sniperBullet bullet = new sniperBullet((Image) sniperBullet.getSniperBulletCoordinates()[0][0],(int) sniperBullet.getSniperBulletCoordinates()[0][1],
                    (int) sniperBullet.getSniperBulletCoordinates()[0][2],
                    (int) sniperBullet.getSniperBulletCoordinates()[0][3],
                    (int) sniperBullet.getSniperBulletCoordinates()[0][4],
                    (int) sniperBullet.getSniperBulletCoordinates()[0][5],
                    (int) sniperBullet.getSniperBulletCoordinates()[0][6]);
            armyEnemy sniper_enemy = new sniperEnemy((Image) sniperEnemy.getSniperEnemyCoordinates()[0][0],
                    (int) sniperEnemy.getSniperEnemyCoordinates()[0][1],(int) sniperEnemy.getSniperEnemyCoordinates()[0][2],(int) sniperEnemy.getSniperEnemyCoordinates()[0][3],
            (int) sniperEnemy.getSniperEnemyCoordinates()[0][4],(String) sniperEnemy.getSniperEnemyCoordinates()[0][5]
                    ,bullet);
            new trackedEnemy<>(sniper_enemy);
            sniper_enemy.shootingRocket();
        } catch (ClassCastException e) {
            throw new InvalidGameDataException("Sniper enemy row has a value of the wrong type", e);
        }
    }

    public static void createSoldierEnemy() throws InvalidGameDataException{
        try {
            soldierRocket rockets = new soldierRocket((Image) soldierRocket.getSoldierRocketCoordinates()[0][0],
                    (int) soldierRocket.getSoldierRocketCoordinates()[0][1],(int) soldierRocket.getSoldierRocketCoordinates()[0][2],
                    (int) soldierRocket.getSoldierRocketCoordinates()[0][3],(int) soldierRocket.getSoldierRocketCoordinates()[0][4],
                    (int) soldierRocket.getSoldierRocketCoordinates()[0][5],(int) soldierRocket.getSoldierRocketCoordinates()[0][6]);

            armyEnemy soldierEnemy = new soldierEnemy((Image) Enemy.soldierEnemy.getSoldierEnemyCoordinates()[0][0],
                    (int) Enemy.soldierEnemy.getSoldierEnemyCoordinates()[0][1],(int) Enemy.soldierEnemy.getSoldierEnemyCoordinates()[0][2],
                    (int) Enemy.soldierEnemy.getSoldierEnemyCoordinates()[0][3],(int) Enemy.soldierEnemy.getSoldierEnemyCoordinates()[0][4],
                    (String) Enemy.soldierEnemy.getSoldierEnemyCoordinates()[0][5], rockets);
            soldierEnemy.shootingRocket();
            new trackedEnemy<>(soldierEnemy);
        } catch (ClassCastException e) {
            throw new InvalidGameDataException("Soldier enemy row has a value of the wrong type", e);
        }
    }
    public static void createArmyEnemy() throws InvalidGameDataException{
        try {
            rocketBullet rocket = new rocketBullet((Image) rocketBullet.getRocketCoordinatesList()[0][0],
                    (int) rocketBullet.getRocketCoordinatesList()[0][1],(int) rocketBullet.getRocketCoordinatesList()[0][2],
                    (int) rocketBullet.getRocketCoordinatesList()[0][3],(int) rocketBullet.getRocketCoordinatesList()[0][4],
                    (int) rocketBullet.getRocketCoordinatesList()[0][5],(int) rocketBullet.getRocketCoordinatesList()[0][6]);
            armyEnemy armyEnemy = new armyEnemy((Image) Enemy.armyEnemy.getArmyEnemyCoordinates()[0][0],
                    (int) Enemy.armyEnemy.getArmyEnemyCoordinates()[0][1],(int) Enemy.armyEnemy.getArmyEnemyCoordinates()[0][2],
                    (int) Enemy.armyEnemy.getArmyEnemyCoordinates()[0][3],(int) Enemy.armyEnemy.getArmyEnemyCoordinates()[0][4],
                    (String) Enemy.armyEnemy.getArmyEnemyCoordinates()[0][5],rocket);
            armyEnemy.shootingRocket();
            new trackedEnemy<>(armyEnemy);
        } catch (ClassCastException e) {
            throw new InvalidGameDataException("Soldier enemy row has a value of the wrong type", e);
        }
    }


    public static void drawAllEnemies(Graphics g) {
        for (int i = 0; i < trackedEnemy.getAllEnemies().size(); i++) {
            Object enemy = trackedEnemy.getAllEnemies().get(i).getEnemy();
            if (enemy instanceof armyEnemy armyEnemy) {
                g.drawImage(armyEnemy.getEnemyImage(), armyEnemy.getCoordinatesX(), armyEnemy.getCoordinatesY(), null);
                for (int j = 0; j < armyEnemy.getRocketList().size(); j++) {
                    armyEnemy.getRocketList().get(j).shootingDirection(armyEnemy.getShootingDirection());
                    g.drawImage(armyEnemy.getRocketList().get(j).getImgBullet(),
                            armyEnemy.getRocketList().get(j).getCoordinatesX(),
                            armyEnemy.getRocketList().get(j).getCoordinatesY(), null);
                    if (collisionUtils.Intersect(armyEnemy.getRocketList().get(j), player.getPlayer())) {
                        armyEnemy.getRocketList().remove(j);
                        resultBoard.setHealth(armyEnemy.damageShooting());
                        player.getPlayer().playerMoveLeft();
                    }
                    armyEnemy.editRocketList();
                }
                for (int j = 0; j < bulletPlayer.getBulletPlayerList().size(); j++) {
                    if (collisionUtils.Intersect(bulletPlayer.getBulletPlayerList().get(j), armyEnemy)) {
                        bulletPlayer.removeBullet(bulletPlayer.getBulletPlayerList().get(j));
                        trackedEnemy.removeEnemy(trackedEnemy.getAllEnemies().get(i));
                        resultBoard.setScore(armyEnemy.killingEnemyScore());
                        resultBoard.setNumberEnemyKilled(1);
                    }
                }
            }
        }
    }

    public static void drawThiefEnemy(Graphics g){
        for (int i = 0; i < trackedEnemy.getAllEnemies().size(); i++) {
            Object enemy = trackedEnemy.getAllEnemies().get(i).getEnemy();
            if (enemy instanceof thief thief) {
                g.drawImage(thief.getEnemyImage(),thief.getCoordinatesX(),thief.getCoordinatesY(),null);
                thief.thiefMovement();
                if (collisionUtils.Intersect(player.getPlayer(),thief)){
                    player.getPlayer().setCoordinatesX(player.getPlayer().getCoordinatesX()-5);
                }
                for (int j = 0; j< bulletPlayer.getBulletPlayerList().size(); j++){
                    if (collisionUtils.Intersect(bulletPlayer.getBulletPlayerList().get(j),thief)){
                        resultBoard.setScore(thief.killingEnemyScore());
                        trackedEnemy.removeEnemy(trackedEnemy.getAllEnemies().get(i));
                        bulletPlayer.removeBullet(bulletPlayer.getBulletPlayerList().get(j));
                        resultBoard.setNumberEnemyKilled(1);
                    }
                }
            }
        }

    }
}
