package Player;

import Bullet.bulletPlayer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import Player.player;
public final class playerCreation {
    public static void createPlayer(){
        player.setPlayer(new player((int) player.getCoordinatesPlayer()[0][0],(int) player.getCoordinatesPlayer()[0][1]
                ,(int) player.getCoordinatesPlayer()[0][2],(int) player.getCoordinatesPlayer()[0][3]));
    }

    public static void draw(Graphics g, player player){
        g.drawImage(player.getPlayerImg(),player.getCoordinatesX(),player.getCoordinatesY(),null );

    }
    public static void draw(Graphics g, ArrayList<bulletPlayer> BulletPlayer_list){
        for (int i=0; i< BulletPlayer_list.size();i++){
            g.drawImage(BulletPlayer_list.get(i).getImgBullet(),BulletPlayer_list.get(i).getCoordinatesX(),BulletPlayer_list.get(i).getCoordinatesY(),
                    null);
            BulletPlayer_list.get(i).shootingDirection(bulletPlayer.getDirection());
        }
    }

    public static void player_movement(int keyCode){
        if (keyCode == KeyEvent.VK_RIGHT){
            player.getPlayer().playerMoveRight();
            bulletPlayer.setDirection("right");
            player.setPlayerImgRight();
        }else if (keyCode == KeyEvent.VK_LEFT){
            player.getPlayer().playerMoveLeft();
            bulletPlayer.setDirection("left");
            player.setPlayerImgLeft();
        }else if (keyCode == KeyEvent.VK_UP){
            player.getPlayer().playerMoveUp();
            bulletPlayer.setDirection("up");
            player.setPlayerImgUp();
        }else if (keyCode == KeyEvent.VK_DOWN){
            player.getPlayer().playerMoveDown();
            bulletPlayer.setDirection("down");
            player.setPlayerImgDown();
        }else if (keyCode == KeyEvent.VK_SPACE){
            bulletPlayer.getBulletPlayerList().add(new bulletPlayer(bulletPlayer.getPlayerBullet(),
                    player.getPlayer().getCoordinatesX(),
                    player.getPlayer().getCoordinatesY(),bulletPlayer.getBulletPlayerDimension()[0][0],
                    bulletPlayer.getBulletPlayerDimension()[0][1]));
        }
    }
}
