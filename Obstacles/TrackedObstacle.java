package Obstacles;

import Enemy.TrackedEnemy;

import java.util.ArrayList;

public class TrackedObstacle<O> {
    private final O obstacle;
    private static final ArrayList<TrackedObstacle<?>> allObstacles = new ArrayList<>();

    public TrackedObstacle(O obstacle) {
        this.obstacle = obstacle;
        allObstacles.add(this);
    }

    public O getObstacle() {
        return obstacle;
    }

    public static ArrayList<TrackedObstacle<?>> getAllObstacles() {
        return allObstacles;
    }
    public static void removeObstacles(TrackedObstacle<?> obstacle){
        allObstacles.remove(obstacle);
    }
}
