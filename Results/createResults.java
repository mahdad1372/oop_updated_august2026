package Results;
import Player.player;
import java.awt.*;
import java.util.ArrayList;
import Panel.panelDetails;
public final class createResults {
    public static void creatingResultBoard (){
        ArrayList<resultBoard> Result_boards = new ArrayList<resultBoard>();
        for (int i=0; i < resultBoard.getResultBoardCoordinates().length;i++){
            Result_boards.add(new resultBoard((int) resultBoard.getResultBoardCoordinates()[i][0],(int)resultBoard.getResultBoardCoordinates()[i][1],
                    (int)resultBoard.getResultBoardCoordinates()[i][2],(int)resultBoard.getResultBoardCoordinates()[i][3],(String) resultBoard.getResultBoardCoordinates()[i][4]));
        }
        resultBoard.setResult_boards(Result_boards);

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
    public static void resultBoardDrawing(Graphics graphics){
        if (player.getPlayer().getCoordinatesX() >= 890){
            panelDetails.getExecutingGameTimer().stop();
            panelDetails.getGameTimer().stop();
            resultBoard.setDisplayMenuWinner(true);
        }
        if (resultBoard.getHealth() <= 0){
            panelDetails.getExecutingGameTimer().stop();
            panelDetails.getGameTimer().stop();
            resultBoard.setDisplayMenuWinner(false);
        }

        if (resultBoard.getDisplayNameMenu() || resultBoard.getDisplayDifficultyMenu()
                || resultBoard.getDisplayMenuWinner() || resultBoard.getHealth() <= 0){
            Rectangle clip = graphics.getClipBounds();
            if (clip == null){
                clip = new Rectangle(0, 0, 950, 400);
            }
            graphics.setColor(new Color(0, 0, 0, 160));
            graphics.fillRect(clip.x, clip.y, clip.width, clip.height);
        }

        if (resultBoard.getDisplayNameMenu()){
            for (int i=0 ; i < resultBoard.getResult_boards().size(); i++){
                if (resultBoard.getResult_boards().get(i).getResultBoardType().equals("menu")){
                    resultBoard board = resultBoard.getResult_boards().get(i);
                    int cardX = board.getBoardCoordinatesX();
                    int cardY = board.getBoardCoordinatesY();
                    graphics.setColor(new Color(30, 60, 90));
                    graphics.fillRect(cardX, cardY, board.getWidth(), board.getHeight());
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

        if (resultBoard.getDisplayDifficultyMenu()){
            for (int i=0 ; i < resultBoard.getResult_boards().size(); i++){
                if (resultBoard.getResult_boards().get(i).getResultBoardType().equals("difficulty")){
                    resultBoard board = resultBoard.getResult_boards().get(i);
                    int cardX = board.getBoardCoordinatesX();
                    int cardY = board.getBoardCoordinatesY();
                    graphics.setColor(new Color(30, 60, 90));
                    graphics.fillRect(cardX, cardY, board.getWidth(), board.getHeight());
                    graphics.setFont(new Font("Arial", Font.BOLD, 25));
                    graphics.setColor(Color.WHITE);
                    graphics.drawString("Choose your difficulty", 330, cardY + 60);
                }
            }
        }

        if (resultBoard.getDisplayMenuWinner()){
            for (int i=0 ; i < resultBoard.getResult_boards().size(); i++){
                if (resultBoard.getResult_boards().get(i).getResultBoardType().equals("winner")){
                    drawEndCard(graphics, resultBoard.getResult_boards().get(i), "Winner",
                            Color.GREEN);
                }
            }
        }
        if (resultBoard.getHealth() <= 0) {
            for (int i = 0; i < resultBoard.getResult_boards().size(); i++) {
                if (resultBoard.getResult_boards().get(i).getResultBoardType().equals("looser")) {
                    drawEndCard(graphics, resultBoard.getResult_boards().get(i), "Looser",
                            Color.RED);
                }
            }
        }
    }

    private static void drawEndCard(Graphics graphics, resultBoard board, String title, Color cardColor){
        int cardX = board.getBoardCoordinatesX();
        int cardY = board.getBoardCoordinatesY();
        int cardWidth = board.getWidth();
        int cardHeight = board.getHeight();
        graphics.setColor(cardColor);
        graphics.fillRoundRect(cardX, cardY, cardWidth, cardHeight, 20, 20);
        graphics.setFont(new Font("Arial", Font.BOLD, 25));
        graphics.setColor(Color.WHITE);
        graphics.drawString(title, 380, cardY + 70);
        graphics.setFont(new Font("Arial", Font.BOLD, 20));
        String displayName = resultBoard.getPlayerName().isEmpty() ? "Player" : resultBoard.getPlayerName();
        String difficultySuffix = resultBoard.getDifficulty().isEmpty() ? "" : " on " + resultBoard.getDifficulty();
        graphics.drawString("The " + title.toLowerCase() + " is : " + displayName +
                " with the score of " + resultBoard.getScore() +
                " and the difficulty level is " + difficultySuffix, cardX + 10, cardY + 170);
        graphics.drawString("In the "+ resultBoard.getSecondsDurationGame() + " second you have killed " + resultBoard.getNumberEnemyKilled(),
                cardX + 10, cardY + 200);
    }
}
