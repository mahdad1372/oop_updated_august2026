package Enemy;

import javax.swing.*;
import java.awt.*;
import Results.resultBoard;
public class thief extends enemy {
    public thief(Image enemyImg,int coordinatesX, int coordinatesY ,int width, int height,String direction, int currentPosition,int finalPosition){
        super(enemyImg,coordinatesX,coordinatesY,width,height);
        this.direction= direction;
        this.finalPosition= finalPosition;
        this.currentPosition = currentPosition;
    }
    private final int currentPosition;
    private final String direction;
    private final int finalPosition;
    public final static Image thiefImg = new ImageIcon("Assets/thief.png").getImage();
    private final static Object[][] thiefCoordinatesEasyLevel = {
            {thiefImg,200,70,30,30,"Y",70,320},
            {thiefImg,390,165,30,30,"X",390,120},
    };
    private final static Object[][] thiefCoordinatesMediumLevel = {
            {thiefImg,200,70,30,30,"Y",70,320},
            {thiefImg,390,165,30,30,"X",390,120},
            {thiefImg,350,310,30,30,"Y",310,120},
            {thiefImg,595,140,30,30,"X",595,450},
    };
    private final static Object[][] thiefCoordinatesHardLevel = {
        {thiefImg,200,70,30,30,"Y",70,320},
        {thiefImg,390,165,30,30,"X",390,120},
        {thiefImg,350,310,30,30,"Y",310,120},
        {thiefImg,595,140,30,30,"X",595,450},
        {thiefImg,580,10,30,30,"Y",10,180},
        {thiefImg,665,50,30,30,"Y",50,210}
    };

    private boolean movingToFinal = true;
    public void thiefMovement() {
        int position = direction.equals("Y") ? getCoordinatesY() : getCoordinatesX();
        int target = movingToFinal ? finalPosition : currentPosition;

        if (position == target) {
            movingToFinal = !movingToFinal;
            target = movingToFinal ? finalPosition : currentPosition;
        }
        int next = position + (position < target ? 1 : -1);
        if (direction.equals("Y")) {
            setCoordinatesY(next);
        } else {
            setCoordinatesX(next);
        }
    }
    public static Object[][] getThiefList(){
        String difficulty_level = resultBoard.getDifficulty();
        if (difficulty_level.equals("Easy")){
            return thiefCoordinatesEasyLevel;
        } else if (difficulty_level.equals("Medium")) {
            return thiefCoordinatesMediumLevel;
        }else {
            return thiefCoordinatesHardLevel;
        }
    }
    @Override
    public int killingEnemyScore(){
        return 10;
    }
}
