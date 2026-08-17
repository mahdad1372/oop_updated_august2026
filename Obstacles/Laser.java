package Obstacles;

import Interfaces.obstacle_measurement;
import Results.resultBoard;
public class Laser extends Obstacle implements obstacle_measurement {
    public Laser(int coordinates_x, int coordinates_y, int width,int height){
        super(coordinates_x,coordinates_y,width,height);
    }
    private static final int[][] laser_level_hard = {
            {725,250,200,10},
            {430,290,10,50},
    };
    private static final int[][] laser_level_easy = {
            {725,250,200,10},
    };
    private static final int[][] laser_level_medium = {
            {725,250,200,10},
    };
    public static int[][] getLaser_coordinates(){
        String difficulty_level = resultBoard.getDifficulty();
        if (difficulty_level.equals("Easy")){
            return laser_level_easy;
        } else if (difficulty_level.equals("Medium")) {
            return laser_level_medium;
        }else {
            return laser_level_hard;
        }
    }
    @Override
    public int damage(){
        return   5;
    }
}
