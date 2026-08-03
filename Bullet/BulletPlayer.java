package Bullet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BulletPlayer extends Bullet{
    public BulletPlayer(int x , int y , Image bullet_img){
        super(x,y,bullet_img);
    }
    private static final ArrayList<BulletPlayer> bullet_player_list = new ArrayList<>();
    private static String playerDirection;

    public static ArrayList<BulletPlayer> getBullet_player_list(){
        return bullet_player_list;
    }
    private final static Image player_bullet  = new ImageIcon("Assets/bulletplayer_right.png").getImage();
    private final static Image player_bullet_L  = new ImageIcon("Assets/bulletplayer_left.png").getImage();
    private final static Image player_bullet_U  = new ImageIcon("Assets/bulletplayer_up.png").getImage();
    private final static Image player_bullet_D  = new ImageIcon("Assets/bulletplayer_down.png").getImage();
    public static void setDirection(String direction){
        playerDirection = direction;
    }
    public static String getDirection(){
        return playerDirection;
    }
    public static Image getPlayer_bullet() {
        if (playerDirection == "right"){
            return player_bullet;
        }else if (playerDirection == "left"){
            return player_bullet_L;
        }else if (playerDirection == "up"){
            return player_bullet_U;
        }else {
            return player_bullet_D;
        }
    }
    public static void remove_bullet(BulletPlayer bulletPlayer){
        bullet_player_list.remove(bulletPlayer);
    }

    @Override
    public void shootingDirection(String direction){
        int speed = 20;

        switch (direction) {
            case "left":
                // Get the current value, subtract speed, then set it back
                int newX = getPosition_coordinates_x() - speed;
                setPosition_coordinates_x(newX);
                break;

            case "right":
                setPosition_coordinates_x(getPosition_coordinates_x() + speed);
                break;

            case "up":
                setPosition_coordinates_y(getPosition_coordinates_y() - speed);
                break;

            case "down":
                setPosition_coordinates_y(getPosition_coordinates_y() + speed);
                break;
        }
    }

}
