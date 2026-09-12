package Obstacles;

import Bullet.bulletPlayer;
import Exceptions.InvalidGameDataException;
import Player.player;
import Results.resultBoard;
import utils.collisionUtils;

import java.awt.*;


public final class obstacleCreation {
    public static void createObstacle() throws InvalidGameDataException {
            try {
                for (int i=0; i< wall.getWallCoordinates().length;i++){
                    obstacle obstacle = new wall(wall.getWallCoordinates()[i][0],wall.getWallCoordinates()[i][1],
                            wall.getWallCoordinates()[i][2],wall.getWallCoordinates()[i][3]);
                    new trackedObstacle<>(obstacle);
                }
                for (int j=0; j< mine.getMineCoordinates().length;j++){
                    obstacle obstacle = new mine(mine.getMineCoordinates()[j][0],mine.getMineCoordinates()[j][1],
                            mine.getMineCoordinates()[j][2],mine.getMineCoordinates()[j][3]);
                    new trackedObstacle<>(obstacle);
                }
                for (int j=0; j< laser.getLaserCoordinates().length;j++){
                    obstacle obstacle = new laser(laser.getLaserCoordinates()[j][0],laser.getLaserCoordinates()[j][1],
                            laser.getLaserCoordinates()[j][2],laser.getLaserCoordinates()[j][3]);
                    new trackedObstacle<>(obstacle);
                }
            } catch (Exception e) {
                throw new InvalidGameDataException("The obstacle type is Invalid",e);
            }
    }

    public static void obstacleDrawing(Graphics graphic){
        for (int i = 0; i < trackedObstacle.getAllObstacles().size(); i++){
            Object content = trackedObstacle.getAllObstacles().get(i).getObstacle();
            if (content instanceof mine mine){
                graphic.setColor(Color.yellow);
                graphic.fillOval(mine.getCoordinatesX(),mine.getCoordinatesY(),
                        mine.getWidth(),mine.getHeight());
                graphic.drawImage(Obstacles.mine.getMineImg(),mine.getCoordinatesX()+mine.getWidth()/4
                        ,mine.getCoordinatesY(),null);
                if (collisionUtils.Intersect(player.getPlayer(), mine)){
                    resultBoard.setHealth(mine.damage());
                    trackedObstacle.removeObstacles(trackedObstacle.getAllObstacles().get(i));
                }
                for (int j = 0; j< bulletPlayer.getBulletPlayerList().size(); j++){
                    if (collisionUtils.Intersect(bulletPlayer.getBulletPlayerList().get(j), mine)){
                        bulletPlayer.removeBullet(bulletPlayer.getBulletPlayerList().get(j));
                    }
                }
            }else if (content instanceof obstacle obstacle )
                {
                    if (obstacle instanceof laser){
                        graphic.setColor(Color.red);
                    }else {
                        graphic.setColor(Color.blue);
                    }
                    graphic.fillRect(obstacle.getCoordinatesX(), obstacle.getCoordinatesY(),
                        obstacle.getWidth(), obstacle.getHeight());
                if (collisionUtils.Intersect(player.getPlayer(), obstacle)) {
                    player.getPlayer().setCoordinatesX(player.getPlayer().getCoordinatesX() - 15);
                    if (obstacle instanceof laser laser){
                        resultBoard.setHealth(laser.damage());
                    }
                }
                for (int j = 0; j < bulletPlayer.getBulletPlayerList().size(); j++) {
                    if (collisionUtils.Intersect(bulletPlayer.getBulletPlayerList().get(j),obstacle)) {
                        bulletPlayer.removeBullet(bulletPlayer.getBulletPlayerList().get(j));
                    }
                }
            } }
    }

}
