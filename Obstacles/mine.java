package Obstacles;

import Interfaces.obstacleHit;

import javax.swing.*;
import java.awt.*;
import Results.resultBoard;
public class mine extends obstacle implements obstacleHit {
    public mine(int coordinatesX, int coordinatesY, int width, int height){
        super(coordinatesX,coordinatesY,width,height);

    }
    private static final Image mineImg = new ImageIcon("Assets/mine.png").getImage();
    private static final int[][] mineCoordinatesHardLevel = {
            {460,300,40,40},
            {300,300,40,40},
            {230,120,40,40},
    };
    private static final int[][] mineCoordinatesEasyLevel = {
            {460,300,40,40},
    };
    private static final int[][] mineCoordinatesMediumLevel = {
            {460,300,40,40},
            {230,120,40,40}
    };
    public static int[][] getMineCoordinates(){
        String difficultyLevel = resultBoard.getDifficulty();
        if (difficultyLevel.equals("Easy")){
            return mineCoordinatesEasyLevel;
        } else if (difficultyLevel.equals("Medium")) {
            return mineCoordinatesMediumLevel;
        }else {
            return mineCoordinatesHardLevel;
        }
    }
    public static Image getMineImg(){
        return mineImg;
    }
    @Override
    public int damage(){
        return  8;
    }
}
