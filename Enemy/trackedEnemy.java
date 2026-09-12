package Enemy;

import java.util.ArrayList;

public class trackedEnemy<Enemy> {
    private final Enemy enemy;
    private static final ArrayList<trackedEnemy<?>> allEnemies = new ArrayList<>();

    public trackedEnemy(Enemy enemy) {
        this.enemy = enemy;
        allEnemies.add(this);
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public static ArrayList<trackedEnemy<?>> getAllEnemies() {
        return allEnemies;
    }
    public static void removeEnemy(trackedEnemy<?> enemy){
        allEnemies.remove(enemy);
    }
}