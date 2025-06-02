import java.util.ArrayList;
import java.util.Scanner;

/**
 * class that creates a game field and adds teams, also plays the soccer game
 */
public class SoccerGame {
    private String[][] field = new String[10][10];
    private Team teamOne;
    private Team teamTwo;
    private int scoreOne;
    private int scoreTwo;
    private Ball ball;

    private String activePlayer;

    /**
     * initializes all the instance variables and assigns the team instance variables, updates the board
     * @param teams list with the two teams for the game
     */
    public SoccerGame(Team[] teams){

        scoreOne = 0;
        scoreTwo = 0;
        teamOne = teams[0];
        teamTwo = teams[1];
        activePlayer = teamOne.getColor();
        ball = new Ball(4,4);
        updateBoard();
     }

    /**
     * prints out the game field with row and col specifiers to minimize confusion
     */
     public void printField() {
         System.out.println("    0  1  2  3  4  5  6  7  8  9");
         for (int i = 0; i < field.length; i++) {
             System.out.print(" " + i + " ");
             for (int j = 0; j < field[0].length; j++) {
                 System.out.print(field[i][j]);
                 if (j == 9) {
                     System.out.println();
                 }
             }
         }
     }


     public static void main(String[] args){

        Team[] teams = SoccerGame.makeTeam();
        SoccerGame blah = new SoccerGame(teams);
        blah.playGame();
     }

    /**
     * create the two teams necessary for the game based off of user input
     * @return the two teams in an array of teams
     */
     public static Team[] makeTeam(){
        Scanner in = new Scanner(System.in);
        Team[] list = new Team[2];
        System.out.println("Player: Red or Blue? (r/b)");
        String color = in.next();
        if(color.equals("r")){
            System.out.println("Player one: your players are marked as R.");
            Team one = new Team(" R ");
            for(int i = 0; i < 3; i++){
                one.addPlayer();
            }
            System.out.println("Player two: your players are marked as B.");
            Team two = new Team(" B ");
            for(int i = 0; i < 3; i++){
                two.addPlayer();
            }
            list[0] = one;
            list[1] = two;
         }
        else if(color.equals("b")){
            System.out.println("Player one: your players are marked as B.");
            Team one = new Team(" B ");
            for(int i= 0; i < 3; i++){
                one.addPlayer();
            }
            System.out.println("Player two: your players are marked as R.");
            Team two = new Team(" R ");
            for(int i = 0; i < 3; i++){
                two.addPlayer();
            }
            list[0] = one;
            list[1] = two;

        }
        return list;

     }

    /**
     * performs an action for the activeplayer based off of user input
     */
     public void move() {
         System.out.println("Active player is " + activePlayer);
         //check for color
         if (activePlayer.equals(teamOne.getColor())) {

             Scanner in = new Scanner(System.in);
             int row;
             int col;
             String action;

             System.out.println("Enter the row position of the player you would like to move");
             row = in.nextInt();
             System.out.println("Enter the col position of the player you would like to move");
             col = in.nextInt();
             //if player exists in that position
             if (field[row][col].equals(teamOne.getColor())) {

                 System.out.println(teamOne);
                 SoccerPlayer active = teamOne.getPlayer(row, col);


                 System.out.println(active);
                 //enter player action
                 System.out.println("Enter the action of the player you would like to take (pass (p), run (r), or shoot (s))");
                 action = in.next();
                 //run action
                 if (action.equals("r")) {
                     int toRow;
                     int toCol;
                     System.out.println("Enter the row  you would like the player to go to");
                     toRow = in.nextInt();
                     System.out.println("Enter the clumn you would like the player to go to");
                     toCol = in.nextInt();
                     active.run(toRow,toCol);
                     //move ball with player if player has ball
                     if (active.hasBall(field)) {

                         ball.setRow(active.getRow() + Math.abs(active.getRow() - ball.getRow()));
                         ball.setCol(active.getCol());
                     }

                     }
                 //pass action
                 else if (action.equals("p")) {
                         int toRow;
                         int toCol;
                         //pass off of input if player has ball
                         if (active.hasBall(field)) {
                             System.out.println("Enter the row of the player you would like to pass to ");
                             toRow = in.nextInt();
                             System.out.println("Etner the col of the player you would like to pass to");
                             toCol = in.nextInt();
                             //check if player to pass to exists
                             if (teamOne.getPlayer(toRow, toCol) != null) {

                                 SoccerPlayer temp = teamOne.getPlayer(toRow, toCol);
                                 if(active.pass(temp, field)) {
                                     ball.setRow(toRow + Math.abs(row - ball.getRow()));
                                     ball.setCol(toCol);
                                 }
                                 else{
                                     ball.setRow(8);
                                     ball.setCol(4);
                                 }

                             } else {
                                 System.out.println("No player where pass was selected");
                             }

                         } else {
                             System.out.println("active player doesn't have the ball");
                         }
                     }
                 //shoot action
                    else if(action.equals("s")){
                        if(active.isAttacker()){
                            if(active.hasBall(field)){
                                System.out.println("Where would you like to shoot?");
                                String target = in.next();
                                if(active.shoot(target)){
                                    //if shoot is successful, add to score
                                    scoreOne ++;
                                    ball.setRow(4);
                                    ball.setCol(4);
                                }
                                else{
                                    ball.setRow(8);
                                    ball.setRow(4);
                                }
                            }
                        }
                 }
                 }
             }
         //otherwise, if player is the different color execute this structure
            else if(activePlayer.equals(teamTwo.getColor())){
             Scanner in = new Scanner(System.in);
             int row;
             int col;
             String action;
             System.out.println("Enter the row of the player you would like to move in the format");
             row = in.nextInt();
             System.out.println("Enter the column of the player you would like to move ");
             col = in.nextInt();
             //if specified player exists
             if (field[row][col].equals(teamTwo.getColor())) {

                 SoccerPlayer active = teamTwo.getPlayer(row, col);
                 System.out.println(active);
                 System.out.println("Enter the action of the player you would like to take (pass (p), run (r), or shoot (s))");
                 action = in.next();
                 //run action
                 if (action.equals("r")) {
                     int toRow;
                     int toCol;
                     System.out.println("Enter the row  you would like the player to go to ");
                     toRow = in.nextInt();
                     System.out.println("Enter the col you would like the player to go to");
                     toCol = in.nextInt();
                     active.run(toRow,toCol);
                     if (active.hasBall(field)) {

                         ball.setRow(active.getRow() + Math.abs(active.getCol() - ball.getRow()));
                         ball.setCol(active.getCol());
                     }

                 }
                 //pass action
                 else if (action.equals("p")) {
                     int toRow;
                     int toCol;
                     if (active.hasBall(field)) {
                         System.out.println("Enter the row of the player you would like to pass to");
                         toRow = in.nextInt();
                         System.out.println("Etner the column ofthe player you would like to pass to");
                         toCol = in.nextInt();
                         if (teamTwo.getPlayer(toRow, toCol) != null) {

                             SoccerPlayer temp = teamTwo.getPlayer(toRow, toCol);
                             if(active.pass(temp, field)) {
                                 ball.setRow(toRow + Math.abs(row - ball.getRow()));
                                 ball.setCol(toCol);
                             }
                             else{
                                 ball.setRow(1);
                                 ball.setCol(4);
                             }


                         } else {
                             System.out.println("No player where pass was selected");
                         }

                     } else {
                         System.out.println("active player doesn't have the ball");
                     }
                 }
                 //shoot action
                 else if(action.equals("s")){
                     if(active.isAttacker()){
                         if(active.hasBall(field)){
                             System.out.println("Where would you like to shoot?");
                             String target = in.next();
                             if(active.shoot(target)){
                                 scoreTwo ++;
                                 ball.setRow(4);
                                 ball.setCol(4);
                             }
                             else{
                                 ball.setRow(1);
                                 ball.setCol(4);
                             }
                         }
                     }
                 }
             }

         }
         //update active player
         System.out.println("active player");
         if(activePlayer.equals(" R ")){
             activePlayer = " B ";
         }
         else{
             activePlayer = " R ";
         }
         }


    /**
     * updates 2D array representing the field with the current positions of the players and ball
     * Red players are represented by " R " while blue players are represented by " B " and ball is " X ",
     * goal is " 1 " and empty space is " - "
     */
         public void updateBoard(){
             for(int i = 0; i < field.length; i++){
                 for(int j = 0; j < field[0].length; j++){
                     field[i][j] = " - ";
                 }
             }
             for(int i = 0; i < field.length; i+= 9){
                 for(int j = 3; j < 7; j++){
                     field[i][j] = " 1 ";
                 }
             }
             field[1][3] = " 1 ";
             field[1][6] = " 1 ";
             field[8][3] = " 1 ";
             field[8][6] = " 1 ";
             SoccerPlayer[] team1 = teamOne.getTeam();
             SoccerPlayer[] team2 = teamTwo.getTeam();
             if(teamOne.getColor().equals(" B ")){
                 for(SoccerPlayer i: team1) {
                     field[i.getRow()][i.getCol()] = " B ";
                 }
                 for(SoccerPlayer i: team2){
                     field[i.getRow()][i.getCol()] = " R ";
                 }
             }
             else{
                 for(SoccerPlayer i: team1) {

                     field[i.getRow()][i.getCol()] = " R ";
                 }
                 for(SoccerPlayer i: team2){
                     field[i.getRow()][i.getCol()] = " B ";
                 }
             }
             field[ball.getRow()][ball.getCol()] = " X ";
         }

    /**
     * play a soccer game until one of the team scores 3 times
     */
         public void playGame(){
            while(scoreOne != 3 && scoreTwo != 3){
                printField();
                System.out.println("Score is Red " + scoreOne + " - Blue " + scoreTwo);
                move();
                updateBoard();
            }
            if(scoreOne == 3){
                System.out.println("Red wins!");

            }
            else{
                System.out.println("Blue wins!");
            }
         }

     }

