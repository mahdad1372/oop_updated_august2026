package Results;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import Obstacles.Wall;
import Obstacles.obstacleCreation;
import Panel.MyPanel;
public class resultBoard {
    private static JButton easyButton;
    private static JButton mediumButton;
    private static JButton hardButton;
    public resultBoard(int x , int y , int width, int height, String result_board_type){
        this.boardCoordinates_x = x;
        this.boardCoordinates_y = y;
        this.width = width;
        this.height = height;
        this.result_board_type = result_board_type;
    }
    private int boardCoordinates_x;
    private int boardCoordinates_y;
    private final int width;
    private int height;
    private static int Seconds_Duration_Game;
    private static int score;
    private static int health = 100;
    private static boolean display_menu_winner;
    private static boolean display_name_menu = true;
    private static boolean display_difficulty_menu = false;
    private static int number_enemy_killed = 0;
    private static String playerName = "";
    private static String difficulty = "";
    private static StringBuilder typedName = new StringBuilder();
    private static ArrayList<resultBoard> Result_boards = new ArrayList<resultBoard>();
    private final String result_board_type ;
    private static final Object[][] labelCoordinates = {
            {750,100, Color.blue,"score"},
            {750,130, Color.red,"health"},
            {890,230, Color.green,"Exit"}
    };
    private static final Object[][] resultBoardCoordinates = {
            {70,40,780,250,"winner"},
            {70,40,780,250,"looser"},
            {70,40,780,250,"menu"},
            {70,40,780,250,"difficulty"},
    };
    public static void setupDifficultyButtons(JComponent panel){
        easyButton = new JButton("Easy");
        easyButton.setBounds(160, 150, 150, 50);
        mediumButton = new JButton("Medium");
        mediumButton.setBounds(390, 150, 150, 50);
        hardButton = new JButton("Hard");
        hardButton.setBounds(620, 150, 150, 50);

        // hidden until the name has been entered - shown by showDifficultyButtons() below
        easyButton.setVisible(false);
        mediumButton.setVisible(false);
        hardButton.setVisible(false);
        easyButton.addActionListener(e -> chooseDifficulty("Easy", 150));
        mediumButton.addActionListener(e -> chooseDifficulty("Medium", 100));
        hardButton.addActionListener(e -> chooseDifficulty("Hard", 70));
        panel.add(easyButton);
        panel.add(mediumButton);
        panel.add(hardButton);
    }

    public static void showDifficultyButtons(){
        easyButton.setVisible(true);
        mediumButton.setVisible(true);
        hardButton.setVisible(true);
    }

    private static void chooseDifficulty(String difficultyName, int startingHealth){
        resultBoard.setDifficulty(difficultyName, startingHealth);
        resultBoard.setDisplay_difficulty_menu(false);
        easyButton.setVisible(false);
        mediumButton.setVisible(false);
        hardButton.setVisible(false);
    }

    public static Object[][] getLabelCoordinates(){
        return labelCoordinates;
    }
    public static Object[][] getResultBoardCoordinates(){
        return resultBoardCoordinates;
    }
    public static int getHealth() {
        return health;
    }

    public static int getScore() {
        return score;
    }

    public static void setHealth(int damage) {
        health -= damage;
    }

    public static void setScore(int points) {
        score += points;
    }

    public int getHeight() {
        return height;
    }

    public int getBoardCoordinates_x() {
        return boardCoordinates_x;
    }

    public int getBoardCoordinates_y() {
        return boardCoordinates_y;
    }

    public void setBoardCoordinates_x(int boardCoordinates_x) {
        this.boardCoordinates_x = boardCoordinates_x;
    }

    public void setBoardCoordinates_y(int boardCoordinates_y) {
        this.boardCoordinates_y = boardCoordinates_y;
    }
    public static boolean getdisplay_menu_winner() {
        return display_menu_winner;
    }
    public static void setdisplay_menu_winner(Boolean status) {
        display_menu_winner = status;
    }
    public static boolean getDisplay_name_menu() {
        return display_name_menu;
    }
    public static void setDisplay_name_menu(boolean status) {
        display_name_menu = status;
    }
    public static String getPlayerName() {
        return playerName;
    }
    public static void setPlayerName(String name) {
        playerName = name;
    }
    public static String getTypedName() {
        return typedName.toString();
    }
    public static void appendTypedNameChar(char c) {
        if (typedName.length() < 20){
            typedName.append(c);
        }
    }
    public static void removeLastTypedNameChar() {
        if (typedName.length() > 0){
            typedName.deleteCharAt(typedName.length() - 1);
        }
    }
    public static boolean getDisplay_difficulty_menu() {
        return display_difficulty_menu;
    }
    public static void setDisplay_difficulty_menu(boolean status) {
        display_difficulty_menu = status;
    }
    public static String getDifficulty() {
        return difficulty;
    }
    // Sets the difficulty label AND the game's starting health in one call, since
    // the two are meant to move together. Distinct from setHealth(int damage),
    // which subtracts damage rather than assigning a value directly.
    public static void setDifficulty(String difficultyName, int startingHealth) {
        difficulty = difficultyName;
        health = startingHealth;
        MyPanel.creation();
    }
    public static int getSeconds_Duration_Game() {
        return Seconds_Duration_Game;
    }
    public static int getNumber_enemy_killed() {
        return number_enemy_killed;
    }
    public String get_result_board_type() {
        return result_board_type;
    }
    public static void setNumber_enemy_killed(int number) {
        number_enemy_killed = number;
    }
    public static void setSeconds_Duration_Game(int seconds_Duration_Game) {
        Seconds_Duration_Game = seconds_Duration_Game;
    }
    public static ArrayList<resultBoard> getResult_boards() {
        return Result_boards;
    }

    public static void setResult_boards(ArrayList<resultBoard> result_boards) {
        Result_boards = result_boards;
    }
    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public static String get_num_enemy_time(int enemy_num , int time){
        return  "In the " + time + " seconds you have killed " + enemy_num + " enemies" ;
    }
    public static String get_num_enemy_time(double enemy_num , double time){
        return  "In the " + time + " seconds you have killed " + enemy_num + " enemies" ;
    }
}
