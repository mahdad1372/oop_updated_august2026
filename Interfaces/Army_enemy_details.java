package Interfaces;

import Bullet.Bullet;
import Bullet.Rocket_Bullet;

import java.util.ArrayList;

public interface Army_enemy_details {
    void shootingRocket();
    void editRocketList();
    ArrayList<? extends Bullet> getRocketList();
    int damageShooting();
}
