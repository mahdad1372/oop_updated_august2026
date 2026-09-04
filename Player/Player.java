package Player;

import Exceptions.GameStateException;
import Interfaces.Enemy_hit;

import javax.swing.*;
import java.awt.*;

public final class Player implements Enemy_hit {
    public Player(int coordinates_x,int coordinates_y){
        this.coordinates_x= coordinates_x;
        this.coordinates_y= coordinates_y;
    }

    private int coordinates_x;
    private int coordinates_y;
    private static Player player;
    private static final Image player_L = new ImageIcon("Assets/soldier_l.png").getImage();
    private static final Image player_d = new ImageIcon("Assets/soldier_d.png").getImage();
    private static final Image player_u = new ImageIcon("Assets/soldier_u.png").getImage();
    private static final Image player_r = new ImageIcon("Assets/soldier.png").getImage();
    private static Image player_img =  new ImageIcon("Assets/soldier.png").getImage();;
    private final static Object[][] coordinates_player ={
            {0,0}
    };

    public static Object[][] getCoordinates_player(){
        return coordinates_player;
    }
    @Override
    public int getWidth(){
        return 30;
    }
    @Override
    public int getHeight(){
        return 30;
    }
    public static void setPlayer(Player player) {
        Player.player = player;
    }
    public static Player getPlayer(){
        if (player == null){
            throw new GameStateException("Player.getPlayer() was called before Player.setPlayer(...) initialized the player");
        }
        return player;
    }

    public static Image getPlayer_img() {
        return player_img;
    }
    public static void setPlayer_img_r(){
        player_img = player_r;
    }
    public static void setPlayer_img_l(){
        player_img = player_L;
    }
    public static void setPlayer_img_u(){
        player_img = player_u;
    }
    public static void setPlayer_img_d(){
        player_img = player_d;
    }


    public  void setCoordinates_y(int coordinates_y) {
        this.coordinates_y = coordinates_y;
    }

    public int getCoordinates_y() {
        return coordinates_y;
    }

    public int getCoordinates_x() {
        return coordinates_x;
    }

    public void setCoordinates_x(int coordinates_x) {
        this.coordinates_x = coordinates_x;
    }
    public void player_move_right(){
        setCoordinates_x(coordinates_x+=5);
    }
    public void player_move_left(){
        setCoordinates_x(coordinates_x-=5);
    }
    public void player_move_up(){
        setCoordinates_y(coordinates_y-=5);
    }
    public void player_move_down(){
        setCoordinates_y(coordinates_y+=5);
    }
}
