package Interfaces;

import Bullet.bullet;

import java.util.ArrayList;

public interface armyEnemyDetails {
    void shootingRocket();
    void editRocketList();
    ArrayList<? extends bullet> getRocketList();
    int damageShooting();
}
