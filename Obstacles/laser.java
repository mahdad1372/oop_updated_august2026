package Obstacles;

import Interfaces.obstacleHit;
import Results.resultBoard;
public class laser extends obstacle implements obstacleHit {
    public laser(int coordinatesX, int coordinatesY, int width, int height){
        super(coordinatesX,coordinatesY,width,height);
    }
    private static final int[][] laserCoordinatesHardLevel = {
            {725,250,200,10},
            {430,290,10,50},
    };
    private static final int[][] laserCoordinatesEasyLevel = {
            {725,250,200,10},
    };
    private static final int[][] laserCoordinatesMediumLevel = {
            {725,250,200,10},
    };
    public static int[][] getLaserCoordinates(){
        String difficultyLevel = resultBoard.getDifficulty();
        if (difficultyLevel.equals("Easy")){
            return laserCoordinatesEasyLevel;
        } else if (difficultyLevel.equals("Medium")) {
            return laserCoordinatesMediumLevel;
        }else {
            return laserCoordinatesHardLevel;
        }
    }
    @Override
    public int damage(){
        return   5;
    }
}
