package Enemy;

import Bullet.*;
import Exceptions.InvalidGameDataException;
import Player.Player;
import Results.resultBoard;
import utils.CollisionUtils;

import java.awt.*;
import java.util.ArrayList;

import static Enemy.thief.getThief_list;

public final class Enemycreation {

    public static void create_TankEnemy() throws InvalidGameDataException {
        Tank_rocket rocket;
        try {
            rocket = new Tank_rocket((Integer) Tank_rocket.getTanks_rocket_coordinates()[0][0],
                    (Integer) Tank_rocket.getTanks_rocket_coordinates()[0][1], (Image) Tank_rocket.getTanks_rocket_coordinates()[0][2],
                    (Integer) Tank_rocket.getTanks_rocket_coordinates()[0][3], (Integer) Tank_rocket.getTanks_rocket_coordinates()[0][4]);
            ArmyEnemy tank = new TankEnemy(TankEnemy.getTank_img(), 580, 250, 40, 40, rocket, "up");
            new TrackedEntity<>(tank);
            tank.Shooting_Rocket();
        } catch (ClassCastException e) {
            throw new InvalidGameDataException("Tanks_rocket_coordinates row 0 has a value of the wrong type", e);
        }
    }

    public static void create_thief() throws InvalidGameDataException {
        for (int i = 0; i < getThief_list().length; i++){
            try {
                Enemy thief = new thief((Image) getThief_list()[i][0],(int) getThief_list()[i][1],(int) getThief_list()[i][2],
                        (int) getThief_list()[i][3],(int) getThief_list()[i][4],(String) getThief_list()[i][5],(int) getThief_list()[i][6]);
                new TrackedEntity<>(thief);
            } catch (ClassCastException e) {
                throw new InvalidGameDataException("thief_coordinates row " + i + " has a value of the wrong type", e);
            }
        }
      }

    public static void createMissileLauncher() throws InvalidGameDataException{
        try {
            Missile missile = new Missile(160,310,Missile.getmissile_img(),270,200);
            ArmyEnemy missile_launcher = new Missile_launcher(160,300,Missile_launcher.getMissile_launcher(),30,30,missile,"up");
            new TrackedEntity<>(missile_launcher);
            missile_launcher.Shooting_Rocket();
        } catch (ClassCastException e) {
            throw new InvalidGameDataException("thief_coordinates row has a value of the wrong type", e);
        }

    };
    public static void createSniperEnemy() throws InvalidGameDataException{
        try {
            SniperBullet bullet = new SniperBullet(470,10,SniperBullet.getSniperBullet_img(),470,230);
            ArmyEnemy sniper_enemy = new ArmyEnemy(SniperEnemy.getSniperImage(),470,10,20,20,bullet,"down");
            new TrackedEntity<>(sniper_enemy);
            sniper_enemy.Shooting_Rocket();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void drawAllEnemies(Graphics g) {
        for (int i = 0; i < TrackedEntity.getAllEntity().size(); i++) {
            Object content = TrackedEntity.getAllEntity().get(i).getContent();
            if (content instanceof ArmyEnemy armyEnemy) {
                g.drawImage(armyEnemy.getEnemyimage(), armyEnemy.getCoordinates_x(), armyEnemy.getCoordinates_y(), null);
                for (int j = 0; j < armyEnemy.getRocket_List().size(); j++) {
                    armyEnemy.getRocket_List().get(j).shootingDirection(armyEnemy.getShooting_direction());
                    g.drawImage(armyEnemy.getRocket_List().get(j).getImg_bullet(),
                            armyEnemy.getRocket_List().get(j).getPosition_coordinates_x(),
                            armyEnemy.getRocket_List().get(j).getPosition_coordinates_y(), null);
                    if (CollisionUtils.Intersect(armyEnemy.getRocket_List().get(j), Player.getPlayer())) {
                        armyEnemy.getRocket_List().remove(j);
                        resultBoard.setHealth(armyEnemy.damageShooting());
                        Player.getPlayer().player_move_left();
                    }

                    armyEnemy.EditRocket_List();
                }
                for (int j = 0; j < BulletPlayer.getBullet_player_list().size(); j++) {
                    if (CollisionUtils.Intersect(BulletPlayer.getBullet_player_list().get(j), armyEnemy)) {
                        BulletPlayer.remove_bullet(BulletPlayer.getBullet_player_list().get(j));
                        TrackedEntity.removeEntity(TrackedEntity.getAllEntity().get(i));
                        resultBoard.setScore(armyEnemy.killing_enemy_score());
                    }
                }
            }
        }
    }

    public static void drawThiefEnemy(Graphics g){
        System.out.println("Good boy");
        for (int i = 0; i < TrackedEntity.getAllEntity().size(); i++) {
            Object content = TrackedEntity.getAllEntity().get(i).getContent();
            if (content instanceof thief thief) {
                g.drawImage(thief.getEnemyimage(),thief.getCoordinates_x(),thief.getCoordinates_y(),null);
                thief.thief_movement();
                if (CollisionUtils.Intersect(Player.getPlayer(),thief)){
                    Player.getPlayer().setCoordinates_x(Player.getPlayer().getCoordinates_x()-5);
                }
                for (int j=0; j<BulletPlayer.getBullet_player_list().size();j++){
                    if (CollisionUtils.Intersect(BulletPlayer.getBullet_player_list().get(j),thief)){
                        resultBoard.setScore(thief.killing_enemy_score());
                        TrackedEntity.removeEntity(TrackedEntity.getAllEntity().get(i));
                        BulletPlayer.remove_bullet(BulletPlayer.getBullet_player_list().get(j));
                    }
                }
            }
        }

    }
}
