package Bullet;

import javax.swing.*;
import java.awt.*;

public class Soldier_rocket extends Rocket_Bullet{
    public Soldier_rocket(int coordinates_x, int coordinates_y, Image soldier_rocket, int final_coordinates_x,int final_coordinates_y){
        super(coordinates_x,coordinates_y,soldier_rocket,final_coordinates_x,final_coordinates_y);
    }
    private final static Image soldier_rocket = new ImageIcon("Assets/Soldier_rocket.png").getImage();
    public static Image getSoldier_rocket(){
        return soldier_rocket;
    }
}
