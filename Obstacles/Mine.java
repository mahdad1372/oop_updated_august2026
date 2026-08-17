package Obstacles;

import Interfaces.obstacle_measurement;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Results.resultBoard;
public class Mine extends Obstacle implements obstacle_measurement {
    public Mine(int coordinates_x,int coordinates_y, int width,int height){
        super(coordinates_x,coordinates_y,width,height);

    }
    private static final Image Mine_img = new ImageIcon("Assets/mine.png").getImage();
    private static final int[][] MineCoordinates_HardLevel = {
            {460,300,40,40},
            {300,300,40,40},
            {230,120,40,40},
    };
    private static final int[][] MineCoordinates_EasyLevel = {
            {460,300,40,40},
    };
    private static final int[][] MineCoordinates_MediumLevel = {
            {460,300,40,40},
            {230,120,40,40}
    };
    public static int[][] getMineCoordinates(){
        String difficulty_level = resultBoard.getDifficulty();
        if (difficulty_level.equals("Easy")){
            return MineCoordinates_EasyLevel;
        } else if (difficulty_level.equals("Medium")) {
            return MineCoordinates_MediumLevel;
        }else {
            return MineCoordinates_HardLevel;
        }
    }
    public static Image getMine_img(){
        return Mine_img;
    }
    @Override
    public int damage(){
        return  8;
    }
}
