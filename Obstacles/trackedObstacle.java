package Obstacles;

import java.util.ArrayList;

public class trackedObstacle<obstacle> {
    private final obstacle obstacle;
    private static final ArrayList<trackedObstacle<?>> allObstacles = new ArrayList<>();

    public trackedObstacle(obstacle obstacle) {
        this.obstacle = obstacle;
        allObstacles.add(this);
    }

    public obstacle getObstacle() {
        return obstacle;
    }

    public static ArrayList<trackedObstacle<?>> getAllObstacles() {
        return allObstacles;
    }
    public static void removeObstacles(trackedObstacle<?> obstacle){
        allObstacles.remove(obstacle);
    }
}
