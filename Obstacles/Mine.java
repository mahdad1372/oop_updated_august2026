package Obstacles;

import Interfaces.obstacle_measurement;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Mine extends Obstacle implements obstacle_measurement {
    public Mine(int coordinates_x,int coordinates_y, int width,int height){
        super(coordinates_x,coordinates_y,width,height);

    }
    private static final Image Mine_img = new ImageIcon("Assets/mine.png").getImage();
    private static final int[][] MineCoordinates = {
            {460,300,40,40},
            {300,300,40,40},
    };
    public static int[][] getMineCoordinates(){
        return MineCoordinates;
    }
    public static Image getMine_img(){
        return Mine_img;
    }
    @Override
    public int damage(){
        return  8;
    }
}
