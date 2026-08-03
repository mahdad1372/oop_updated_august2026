package Bullet;

import javax.swing.*;
import java.awt.*;

public class Rocket_Bullet extends Bullet{
    public Rocket_Bullet(int coordinates_x, int coordinates_y, Image Rocket_bullet_img,int final_coordinates_x, int final_coordinates_y ){
        super(coordinates_x,coordinates_y,Rocket_bullet_img);
        this.final_coordinates_x= final_coordinates_x;
        this.final_coordinates_y= final_coordinates_y;
        this.Rocket_bullet_img = Rocket_bullet_img;
    }
    private final int final_coordinates_x;
    private final int final_coordinates_y;
    private final Image Rocket_bullet_img;

    public Image getRocket_bullet_img(){
        return Rocket_bullet_img;
    }
    public int getFinal_coordinates_x(){
        return final_coordinates_x;
    }
    public int getFinal_coordinates_y(){
        return final_coordinates_y;
    }
    @Override
    public void shootingDirection(String direction) {
        if (direction == "up"){
            setPosition_coordinates_x(getPosition_coordinates_x() != getFinal_coordinates_x()  ? getPosition_coordinates_x() + 5 : getPosition_coordinates_x());
            setPosition_coordinates_y(getPosition_coordinates_y() != getFinal_coordinates_y() ? getPosition_coordinates_y() - 5 : getPosition_coordinates_y());
        } else if(direction == "down"){
            setPosition_coordinates_y(getPosition_coordinates_y() != getFinal_coordinates_y() ? getPosition_coordinates_y() + 5 : getPosition_coordinates_y());
        }
    }
}
