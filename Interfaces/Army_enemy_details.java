package Interfaces;

import Bullet.Bullet;
import Bullet.Rocket_Bullet;

import java.util.ArrayList;

public interface Army_enemy_details {
    void Shooting_Rocket();
    void EditRocket_List();
    ArrayList<? extends Bullet> getRocket_List();
    int damageShooting();
}
