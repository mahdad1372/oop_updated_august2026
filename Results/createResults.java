package Results;
import Player.Player;
import java.awt.*;
import java.util.ArrayList;
import Panel.panelDetails;
public final class createResults {
    public static ArrayList<resultBoard> creating_result_board (Object[][] resultBoardCoordinates){
        ArrayList<resultBoard> Result_boards = new ArrayList<resultBoard>();
        for (int i=0; i < resultBoardCoordinates.length;i++){
            Result_boards.add(new resultBoard((int) resultBoardCoordinates[i][0],(int)resultBoardCoordinates[i][1],
                    (int)resultBoardCoordinates[i][2],(int)resultBoardCoordinates[i][3],(String) resultBoardCoordinates[i][4]));
        }
        return Result_boards;
    }
    public static void lableDrawing(Graphics graphics , Object[][] lableSpecification){
        graphics.setFont(new Font("Arial", Font.BOLD, 24));
        String lableText;
        for (int i=0; i< lableSpecification.length; i++){
            graphics.setColor((Color) lableSpecification[i][2]);
            if (lableSpecification[i][3] == "Exit"){
                lableText = "Exit";
            }else {
                lableText = (String)lableSpecification[i][3]+" : "+(lableSpecification[i][3] == "score" ? resultBoard.getScore():resultBoard.getHealth());
            }
            graphics.drawString(lableText ,(int)lableSpecification[i][0],(int)lableSpecification[i][1]);
        }
    }
    public static void ResultBoardDrawing(Graphics graphics){
        if (Player.getPlayer().getCoordinates_x() >= 890){
            panelDetails.executing_game_timer.stop();
            panelDetails.Game_Timer.stop();
            resultBoard.setdisplay_menu_winner(true);
        }
        if (resultBoard.getHealth() <= 0){
            panelDetails.executing_game_timer.stop();
            panelDetails.Game_Timer.stop();
            resultBoard.setdisplay_menu_winner(false);
        }

        if (resultBoard.getDisplay_name_menu() || resultBoard.getDisplay_difficulty_menu()
                || resultBoard.getdisplay_menu_winner() || resultBoard.getHealth() <= 0){
            Rectangle clip = graphics.getClipBounds();
            if (clip == null){
                clip = new Rectangle(0, 0, 950, 400);
            }
            graphics.setColor(new Color(0, 0, 0, 160));
            graphics.fillRect(clip.x, clip.y, clip.width, clip.height);
        }

        if (resultBoard.getDisplay_name_menu()){
            for (int i=0 ; i < resultBoard.getResult_boards().size(); i++){
                if (resultBoard.getResult_boards().get(i).get_result_board_type().equals("menu")){
                    resultBoard board = resultBoard.getResult_boards().get(i);
                    int cardX = board.getBoardCoordinates_x();
                    int cardY = board.getBoardCoordinates_y();
                    graphics.setColor(new Color(30, 60, 90));
                    graphics.fillRoundRect(cardX, cardY, board.getWidth(), board.getHeight(), 20, 20);
                    graphics.setColor(Color.CYAN);
                    ((Graphics2D) graphics).setStroke(new BasicStroke(4));
                    graphics.drawRoundRect(cardX, cardY, board.getWidth(), board.getHeight(), 20, 20);
                    graphics.setFont(new Font("Arial", Font.BOLD, 25));
                    graphics.setColor(Color.WHITE);
                    graphics.drawString("Please add your name", 380, cardY + 70);
                    int boxX = cardX + 220, boxY = cardY + 100, boxWidth = 340, boxHeight = 40;
                    graphics.setColor(Color.WHITE);
                    graphics.fillRect(boxX, boxY, boxWidth, boxHeight);
                    graphics.setColor(Color.BLACK);
                    graphics.drawRect(boxX, boxY, boxWidth, boxHeight);
                    graphics.setFont(new Font("Arial", Font.PLAIN, 20));
                    String typed = resultBoard.getTypedName();
                    graphics.drawString(typed , boxX + 8, boxY + 27);
                    graphics.setFont(new Font("Arial", Font.PLAIN, 16));
                    graphics.setColor(Color.WHITE);
                    graphics.drawString("Press Enter to start", boxX + 40, boxY + 75);
                }
            }
        }

        if (resultBoard.getDisplay_difficulty_menu()){
            for (int i=0 ; i < resultBoard.getResult_boards().size(); i++){
                if (resultBoard.getResult_boards().get(i).get_result_board_type().equals("difficulty")){
                    resultBoard board = resultBoard.getResult_boards().get(i);
                    int cardX = board.getBoardCoordinates_x();
                    int cardY = board.getBoardCoordinates_y();
                    graphics.setColor(new Color(30, 60, 90));
                    graphics.fillRoundRect(cardX, cardY, board.getWidth(), board.getHeight(), 20, 20);
                    graphics.setColor(Color.ORANGE);
                    ((Graphics2D) graphics).setStroke(new BasicStroke(4));
                    graphics.drawRoundRect(cardX, cardY, board.getWidth(), board.getHeight(), 20, 20);
                    graphics.setFont(new Font("Arial", Font.BOLD, 25));
                    graphics.setColor(Color.WHITE);
                    graphics.drawString("Choose your difficulty", 330, cardY + 60);
                }
            }
        }

        if (resultBoard.getdisplay_menu_winner()){
            for (int i=0 ; i < resultBoard.getResult_boards().size(); i++){
                if (resultBoard.getResult_boards().get(i).get_result_board_type().equals("winner")){
                    drawEndCard(graphics, resultBoard.getResult_boards().get(i), "Winner",
                            Color.GREEN, new Color(20, 90, 40));
                }
            }
        }
        if (resultBoard.getHealth() <= 0) {
            for (int i = 0; i < resultBoard.getResult_boards().size(); i++) {
                if (resultBoard.getResult_boards().get(i).get_result_board_type().equals("looser")) {
                    drawEndCard(graphics, resultBoard.getResult_boards().get(i), "Looser",
                            Color.RED, new Color(90, 20, 20));
                }
            }
        }
    }

    private static void drawEndCard(Graphics graphics, resultBoard board, String title, Color accentColor, Color cardColor){
        int cardX = board.getBoardCoordinates_x();
        int cardY = board.getBoardCoordinates_y();
        int cardWidth = board.getWidth();
        int cardHeight = board.getHeight();
        graphics.setColor(cardColor);
        graphics.fillRoundRect(cardX, cardY, cardWidth, cardHeight, 20, 20);
        graphics.setColor(accentColor);
        ((Graphics2D) graphics).setStroke(new BasicStroke(4));
        graphics.drawRoundRect(cardX, cardY, cardWidth, cardHeight, 20, 20);
        graphics.setFont(new Font("Arial", Font.BOLD, 25));
        graphics.setColor(Color.WHITE);
        graphics.drawString(title, 380, cardY + 70);
        graphics.setFont(new Font("Arial", Font.BOLD, 20));
        String displayName = resultBoard.getPlayerName().isEmpty() ? "Player" : resultBoard.getPlayerName();
        String difficultySuffix = resultBoard.getDifficulty().isEmpty() ? "" : " on " + resultBoard.getDifficulty();
        graphics.drawString("The " + title.toLowerCase() + " is : " + displayName +
                " with the score of " + resultBoard.getScore() +
                " and the Health of " + resultBoard.getHealth() + difficultySuffix, cardX + 10, cardY + 170);
        graphics.drawString(resultBoard.get_num_enemy_time(resultBoard.getNumber_enemy_killed(), resultBoard.getSeconds_Duration_Game()),
                cardX + 10, cardY + 200);
    }
}
