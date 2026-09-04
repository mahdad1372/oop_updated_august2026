package Enemy;

import Bullet.*;
import Exceptions.InvalidGameDataException;
import Player.Player;
import Results.resultBoard;
import utils.CollisionUtils;
import java.awt.*;
import static Enemy.thief.getThief_list;

public final class Enemycreation {

    public static void create_TankEnemy() throws InvalidGameDataException {
        Tank_rocket rocket;
        try {
            rocket = new Tank_rocket((Image) Tank_rocket.getTanks_rocket_coordinates()[0][2],(Integer) Tank_rocket.getTanks_rocket_coordinates()[0][0],
                    (Integer) Tank_rocket.getTanks_rocket_coordinates()[0][1],
                    (Integer) Tank_rocket.getTanks_rocket_coordinates()[0][3], (Integer) Tank_rocket.getTanks_rocket_coordinates()[0][4]);
            ArmyEnemy tank = new TankEnemy((Image) TankEnemy.getTank_enemy_coordinates()[0][0],
                    (int) TankEnemy.getTank_enemy_coordinates()[0][1], (int)TankEnemy.getTank_enemy_coordinates()[0][2],
                    (int)TankEnemy.getTank_enemy_coordinates()[0][3], (int)TankEnemy.getTank_enemy_coordinates()[0][4],
                    (String) TankEnemy.getTank_enemy_coordinates()[0][5],rocket);
            new TrackedEnemy<>(tank);
            tank.shootingRocket();
        } catch (ClassCastException e) {
            throw new InvalidGameDataException("Tanks_rocket_coordinates row 0 has a value of the wrong type", e);
        }
    }

    public static void create_thief() throws InvalidGameDataException {
        for (int i = 0; i < getThief_list().length; i++){
            try {
                Enemy thief = new thief((Image) getThief_list()[i][0],(int) getThief_list()[i][1],(int) getThief_list()[i][2],
                        (int) getThief_list()[i][3],(int) getThief_list()[i][4],(String) getThief_list()[i][5],(int) getThief_list()[i][6]);
                new TrackedEnemy<>(thief);
            } catch (ClassCastException e) {
                throw new InvalidGameDataException("thief_coordinates row " + i + " has a value of the wrong type", e);
            }
        }
      }

    public static void createMissileLauncher() throws InvalidGameDataException{
        try {
            Missile missile = new Missile((Image) Missile.getMissile_coordinates()[0][0],(int) Missile.getMissile_coordinates()[0][1],(int) Missile.getMissile_coordinates()[0][2]
            ,(int) Missile.getMissile_coordinates()[0][3],(int) Missile.getMissile_coordinates()[0][4]);
            ArmyEnemy missile_launcher = new Missile_launcher((Image) Missile_launcher.getMissileLauncherCoordinates()[0][0],
                    (int) Missile_launcher.getMissileLauncherCoordinates()[0][1],(int) Missile_launcher.getMissileLauncherCoordinates()[0][2],
                    (int) Missile_launcher.getMissileLauncherCoordinates()[0][3],
                    (int) Missile_launcher.getMissileLauncherCoordinates()[0][4], (String) Missile_launcher.getMissileLauncherCoordinates()[0][5],missile);
            new TrackedEnemy<>(missile_launcher);
            missile_launcher.shootingRocket();
        } catch (ClassCastException e) {
            throw new InvalidGameDataException("thief_coordinates row has a value of the wrong type", e);
        }

    };
    public static void createSniperEnemy() throws InvalidGameDataException{
        try {
            SniperBullet bullet = new SniperBullet((Image) SniperBullet.getSniperBulletCoordinates()[0][0],(int) SniperBullet.getSniperBulletCoordinates()[0][1],
                    (int) SniperBullet.getSniperBulletCoordinates()[0][2],(int) SniperBullet.getSniperBulletCoordinates()[0][3],(int) SniperBullet.getSniperBulletCoordinates()[0][4]);
            ArmyEnemy sniper_enemy = new ArmyEnemy((Image) SniperEnemy.getSniperEnemyCoordinates()[0][0],
                    (int) SniperEnemy.getSniperEnemyCoordinates()[0][1],(int) SniperEnemy.getSniperEnemyCoordinates()[0][2],(int) SniperEnemy.getSniperEnemyCoordinates()[0][3],
            (int) SniperEnemy.getSniperEnemyCoordinates()[0][4],(String) SniperEnemy.getSniperEnemyCoordinates()[0][5]
                    ,bullet);
            new TrackedEnemy<>(sniper_enemy);
            sniper_enemy.shootingRocket();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void createSoldierEnemy() throws InvalidGameDataException{
        try {
            Soldier_rocket soldier_rocket = new Soldier_rocket((Image) Soldier_rocket.getSoldierRocketCoordinates()[0][0],
                    (int) Soldier_rocket.getSoldierRocketCoordinates()[0][1],(int)Soldier_rocket.getSoldierRocketCoordinates()[0][2],
                    (int)Soldier_rocket.getSoldierRocketCoordinates()[0][3],(int)Soldier_rocket.getSoldierRocketCoordinates()[0][4]);

            ArmyEnemy soldierEnemy = new SoldierEnemy((Image) SoldierEnemy.getSoldierEnemyCoordinates()[0][0],
                    (int) SoldierEnemy.getSoldierEnemyCoordinates()[0][1],(int) SoldierEnemy.getSoldierEnemyCoordinates()[0][2],
                    (int) SoldierEnemy.getSoldierEnemyCoordinates()[0][3],(int) SoldierEnemy.getSoldierEnemyCoordinates()[0][4],
                    (String) SoldierEnemy.getSoldierEnemyCoordinates()[0][5],soldier_rocket);
            soldierEnemy.shootingRocket();
            new TrackedEnemy<>(soldierEnemy);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void drawAllEnemies(Graphics g) {
        for (int i = 0; i < TrackedEnemy.getAllEnemies().size(); i++) {
            Object enemy = TrackedEnemy.getAllEnemies().get(i).getEnemy();
            if (enemy instanceof ArmyEnemy armyEnemy) {
                g.drawImage(armyEnemy.getEnemyimage(), armyEnemy.getCoordinates_x(), armyEnemy.getCoordinates_y(), null);
                for (int j = 0; j < armyEnemy.getRocketList().size(); j++) {
                    armyEnemy.getRocketList().get(j).shootingDirection(armyEnemy.getShooting_direction());
                    g.drawImage(armyEnemy.getRocketList().get(j).getImg_bullet(),
                            armyEnemy.getRocketList().get(j).getPosition_coordinates_x(),
                            armyEnemy.getRocketList().get(j).getPosition_coordinates_y(), null);
                    if (CollisionUtils.Intersect(armyEnemy.getRocketList().get(j), Player.getPlayer())) {
                        armyEnemy.getRocketList().remove(j);
                        resultBoard.setHealth(armyEnemy.damageShooting());
                        Player.getPlayer().player_move_left();
                    }

                    armyEnemy.editRocketList();
                }
                for (int j = 0; j < BulletPlayer.getBullet_player_list().size(); j++) {
                    if (CollisionUtils.Intersect(BulletPlayer.getBullet_player_list().get(j), armyEnemy)) {
                        BulletPlayer.remove_bullet(BulletPlayer.getBullet_player_list().get(j));
                        TrackedEnemy.removeEnemy(TrackedEnemy.getAllEnemies().get(i));
                        resultBoard.setScore(armyEnemy.killing_enemy_score());
                        resultBoard.setNumber_enemy_killed(1);
                    }
                }
            }
        }
    }

    public static void drawThiefEnemy(Graphics g){
        for (int i = 0; i < TrackedEnemy.getAllEnemies().size(); i++) {
            Object enemy = TrackedEnemy.getAllEnemies().get(i).getEnemy();
            if (enemy instanceof thief thief) {
                g.drawImage(thief.getEnemyimage(),thief.getCoordinates_x(),thief.getCoordinates_y(),null);
                thief.thief_movement();
                if (CollisionUtils.Intersect(Player.getPlayer(),thief)){
                    Player.getPlayer().setCoordinates_x(Player.getPlayer().getCoordinates_x()-5);
                }
                for (int j=0; j<BulletPlayer.getBullet_player_list().size();j++){
                    if (CollisionUtils.Intersect(BulletPlayer.getBullet_player_list().get(j),thief)){
                        resultBoard.setScore(thief.killing_enemy_score());
                        TrackedEnemy.removeEnemy(TrackedEnemy.getAllEnemies().get(i));
                        BulletPlayer.remove_bullet(BulletPlayer.getBullet_player_list().get(j));
                        resultBoard.setNumber_enemy_killed(1);
                    }
                }
            }
        }

    }
}
