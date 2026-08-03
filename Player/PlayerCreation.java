package Player;

import Bullet.BulletPlayer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public final class PlayerCreation {
    public static Player create_player(){
        Player player = new Player(0,0);
        return player;
    }

    public static void player_drawing(Graphics g,Player player){
        g.drawImage(Player.getPlayer_img(),player.getCoordinates_x(),player.getCoordinates_y(),null );

    }
    public static void Bullet_player_drawing(Graphics g, ArrayList<BulletPlayer> BulletPlayer_list){
        for (int i=0; i< BulletPlayer_list.size();i++){
            g.drawImage(BulletPlayer_list.get(i).getImg_bullet(),BulletPlayer_list.get(i).getPosition_coordinates_x(),BulletPlayer_list.get(i).getPosition_coordinates_y(),
                    null);
            BulletPlayer_list.get(i).shootingDirection(BulletPlayer.getDirection());
        }
    }

    public static void player_movement(int keyCode){
        if (keyCode == KeyEvent.VK_RIGHT){
            Player.getPlayer().player_move_right();
            BulletPlayer.setDirection("right");
            Player.setPlayer_img_r();
        }else if (keyCode == KeyEvent.VK_LEFT){
            Player.getPlayer().player_move_left();
            BulletPlayer.setDirection("left");
            Player.setPlayer_img_l();
        }else if (keyCode == KeyEvent.VK_UP){
            Player.getPlayer().player_move_up();
            BulletPlayer.setDirection("up");
            Player.setPlayer_img_u();
        }else if (keyCode == KeyEvent.VK_DOWN){
            Player.getPlayer().player_move_down();
            BulletPlayer.setDirection("down");
            Player.setPlayer_img_d();
        }else if (keyCode == KeyEvent.VK_SPACE){
            BulletPlayer.getBullet_player_list().add(new BulletPlayer(Player.getPlayer().getCoordinates_x(),
                    Player.getPlayer().getCoordinates_y(),BulletPlayer.getPlayer_bullet()));
        }
    }
}
