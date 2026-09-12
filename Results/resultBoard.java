package Results;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import Panel.myPanel;
public class resultBoard {
    private static JButton easyButton;
    private static JButton mediumButton;
    private static JButton hardButton;
    public resultBoard(int x , int y , int width, int height, String resultBoardType){
        this.boardCoordinatesX = x;
        this.boardCoordinatesY = y;
        this.width = width;
        this.height = height;
        this.resultBoardType = resultBoardType;
    }
    private final int boardCoordinatesX;
    private final int boardCoordinatesY;
    private final int width;
    private int height;
    private static int secondsDurationGame;
    private static int score;
    private static int health = 100;
    private static boolean displayMenuWinner;
    private static boolean displayNameMenu = true;
    private static boolean displayDifficultyMenu = false;
    private static int numberEnemyKilled = 0;
    private static String playerName = "";
    private static String difficulty = "";
    private final static StringBuilder typedName = new StringBuilder();
    private static ArrayList<resultBoard> resultBoards = new ArrayList<>();
    private final String resultBoardType ;
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
        resultBoard.setDisplayDifficultyMenu(false);
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

    public int getBoardCoordinatesX() {
        return boardCoordinatesX;
    }

    public int getBoardCoordinatesY() {
        return boardCoordinatesY;
    }
    public static boolean getDisplayMenuWinner() {
        return displayMenuWinner;
    }
    public static void setDisplayMenuWinner(Boolean status) {
        displayMenuWinner = status;
    }
    public static boolean getDisplayNameMenu() {
        return displayNameMenu;
    }
    public static void setDisplayNameMenu(boolean status) {
        displayNameMenu = status;
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
        if (!typedName.isEmpty()){
            typedName.deleteCharAt(typedName.length() - 1);
        }
    }
    public static boolean getDisplayDifficultyMenu() {
        return displayDifficultyMenu;
    }
    public static void setDisplayDifficultyMenu(boolean status) {
        displayDifficultyMenu = status;
    }
    public static String getDifficulty() {
        return difficulty;
    }
    public static void setDifficulty(String difficultyName, int startingHealth) {
        difficulty = difficultyName;
        health = startingHealth;
        myPanel.creation();
    }
    public static int getSecondsDurationGame() {
        return secondsDurationGame;
    }
    public static int getNumberEnemyKilled() {
        return numberEnemyKilled;
    }
    public String getResultBoardType() {
        return resultBoardType;
    }
    public static void setNumberEnemyKilled(int number) {
        numberEnemyKilled += number;
    }
    public static void setSecondsDurationGame(int seconds_Duration_Game) {
        secondsDurationGame = seconds_Duration_Game;
    }
    public static ArrayList<resultBoard> getResult_boards() {
        return resultBoards;
    }

    public static void setResult_boards(ArrayList<resultBoard> result_boards) {
        resultBoards = result_boards;
    }
    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
//    public static String getFinalResult(int enemy_num , int time){
//        return  "In the " + time + " seconds you have killed " + enemy_num + " enemies" ;
//    }
}
