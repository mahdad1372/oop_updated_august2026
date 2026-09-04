package Obstacles;

import Bullet.BulletPlayer;
import Exceptions.InvalidGameDataException;
import Player.Player;
import Results.resultBoard;
import utils.CollisionUtils;

import java.awt.*;


public final class obstacleCreation {
    public static void create_obstacle(int[][] coordinates , String obstacle_type) throws InvalidGameDataException {
        for (int i=0 ; i < coordinates.length ; i++){
            try {
                if (obstacle_type.equals("Wall")){
                    new TrackedObstacle<>(new Wall(coordinates[i][0], coordinates[i][1], coordinates[i][2], coordinates[i][3]));
                }else if (obstacle_type.equals("Laser")){
                    new TrackedObstacle<>(new Laser(coordinates[i][0], coordinates[i][1], coordinates[i][2], coordinates[i][3]));
                }else if (obstacle_type.equals("Mine")){
                    new TrackedObstacle<>(new Mine(coordinates[i][0], coordinates[i][1], coordinates[i][2], coordinates[i][3]));
                }else {
                    throw new IllegalArgumentException("Unknown obstacle_type \"" + obstacle_type + "\" - expected \"Wall\", \"Laser\", or \"Mine\"");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void obstacle_drawing(Graphics graphic){
        for (int i=0; i < TrackedObstacle.getAllObstacles().size();i++){
            Object content = TrackedObstacle.getAllObstacles().get(i).getObstacle();
            if (content instanceof Mine mine){
                graphic.setColor(Color.yellow);
                graphic.fillOval(mine.getCoordinates_x(),mine.getCoordinates_y(),
                        mine.getWidth(),mine.getHeight());
                graphic.drawImage(Mine.getMine_img(),mine.getCoordinates_x()+mine.getWidth()/4
                        ,mine.getCoordinates_y(),null);
                if (CollisionUtils.Intersect(Player.getPlayer(), mine)){
                    resultBoard.setHealth(mine.damage());
                    TrackedObstacle.removeObstacles(TrackedObstacle.getAllObstacles().get(i));
                }
                for (int j = 0; j< BulletPlayer.getBullet_player_list().size(); j++){
                    if (CollisionUtils.Intersect(BulletPlayer.getBullet_player_list().get(j), mine)){
                        BulletPlayer.remove_bullet(BulletPlayer.getBullet_player_list().get(j));
                    }
                }
            }else if (content instanceof Obstacle obstacle )
                {
                    if (obstacle instanceof Laser){
                        graphic.setColor(Color.red);
                    }else {
                        graphic.setColor(Color.blue);
                    }
                    graphic.fillRect(obstacle.getCoordinates_x(), obstacle.getCoordinates_y(),
                        obstacle.getWidth(), obstacle.getHeight());
                if (CollisionUtils.Intersect(Player.getPlayer(), obstacle)) {
                    Player.getPlayer().setCoordinates_x(Player.getPlayer().getCoordinates_x() - 15);
                    if (obstacle instanceof Laser laser){
                        resultBoard.setHealth(laser.damage());
                    }
                }
                for (int j = 0; j < BulletPlayer.getBullet_player_list().size(); j++) {
                    if (CollisionUtils.Intersect(BulletPlayer.getBullet_player_list().get(j),obstacle)) {
                        BulletPlayer.remove_bullet(BulletPlayer.getBullet_player_list().get(j));
                    }
                }
            } }
    }

}
