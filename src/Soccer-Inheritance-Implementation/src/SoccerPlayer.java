/**
 * class representing players in a Soccer game, with basic soccer actions as methods (pass,shoot,run)
 */
public class SoccerPlayer {


    private String name;
    private boolean hasBall;
    private int pace;
    private int row;
    private int col;
    private String pos;

    /**
     * creates a SoccerPlayer object with the specified parameters (except for pace, max pace is 3)
     * @param n name of player
     * @param pace pace of player
     * @param row row pos of player
     * @param col col pos of player
     * @param pos literal position of player on field
     */
    public SoccerPlayer(String n, int pace, int row, int col, String pos){

        if(pace > 3){
            this.pace = 3;
        }
        else{
            this.pace = pace;
        }
        name = n;
        hasBall = false;
        this.row = row;
        this.col = col;
        this.pos = pos;
    }

    /**
     * gets literal position of player
     * @return pos of player
     */
    public String getPos(){return pos;}

    /**
     * returns false every time, unless is in Attacker class
     * @return false
     */
    public boolean isAttacker(){
        return false;
    }

    /**
     * method that returns whether or not the player has the ball according to the parameter array
     * @param arr specified array to search
     * @return if player has ball or not
     */
    public boolean hasBall(String[][] arr){
        if(arr[this.row+1][this.col].equals(" X ")||arr[this.row-1][this.col].equals(" X ")){
            return true;
        }
        return false;
    }


    /**
     * returns player's name
     * @return player's name
     */
    public String getName(){
        return name;
    }


    /**
     * method that gets player's row
     * @return player's row pos
     */
    public int getRow(){ return row;}

    /**
     * method that gets player's col
     * @return player's col pos
     */
    public int getCol(){ return col;}


    /**
     * assigns true or false to if the player has the ball
     * @param a whether the player has the ball or not
     */
    public void setBall(boolean a){
        hasBall = a;
    }


    /**
     * method that lets the player run to a position, checks if pace allows them to first and then runs the max amount of spaces their pace allows
     *
     * @param toRow row the player is running to
     * @param toCol col the player is running to
     */
    public void run(int toRow, int toCol){

        System.out.println(this.name + " is making a run from " +row + ","+ col + " to " + toRow+","+toCol);
        //check if pace allows player to move to that pos
        if(Math.abs(toRow-row) > pace){
           if(row < toRow){
               row += pace;
           }
           else{
               row-= pace;
           }
        }
        else{
            row = toRow;
        }
        if(Math.abs(toCol-col) > pace){
            if(col < toCol){
                col += pace;
            }
            else{
                col -= pace;
            }
        }
        else{
            col = toCol;
        }

    }

    /**
     * method that lets the player pass the ball to another player if they have the ball and the other player exists
     *
     * @param s player they are passing to
     * @param arr array the players are located on
     * @return if pass was successful
     */
    public boolean pass(SoccerPlayer s, String[][] arr){
        if(this.hasBall(arr)){
            int chance = 1 + (int) Math.random()*3;
            if(chance == 1) {
                System.out.println(this.name + " passes to " + s.name);
                this.hasBall = false;
                s.hasBall = true;
                return true;
            }
            else{
                System.out.println("Pass unsuccessful.");
                this.hasBall = false;
                return false;
            }
        }
        else{
            System.out.println(this.name + " doesn't have the ball");
            return false;
        }
    }

    /**
     * method that lets the player shoot the ball, which is scored based on a random number
     * @param where where the player is shooting
     * @return if ball was shot successfully
     */
    public boolean shoot(String where){
        this.hasBall = false;
        int chance = 1 + (int) Math.random() * 6;
        if(chance == 1) {
            System.out.println(name + " shoots at " + where +   " successfully");
            return true;
        }

        return false;
    }

    /**
     * returns a string specifying "PLAYERPLAYERPLAYER"
     *
     * @return a string "PLAYERPLAYERPLAYER"
     */
    public String toString(){
        return "PLAYERPLAYERPLAYER";
    }




}
