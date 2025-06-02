import java.util.ArrayList;
import java.util.Scanner;

/**
 * class that represents a soccer team with methods to get and add players
 */
public class Team {

    private  int middle = 0;
    private  int right = 0;
    private  int left = 0;
    private SoccerPlayer[] team;
    private String color;

    /**
     * constructs a Team object and initialzes the SoccerPlayer array with 3 places
     * @param color color of team
     */
    public Team(String color){
        team = new SoccerPlayer[3];
        this.color = color;
    }

    public String getColor(){
        return color;
    }
    public SoccerPlayer[] getTeam(){
        return team;
    }

    /**
     * adds a player to the team list based off of user input
     */
    public  void addPlayer(){
        Scanner in = new Scanner(System.in);
        String type; String pos; String name; int row; int col;
        String zone;
        //player type, name
        while(true) {
            System.out.println("Would you like an attacker or defender? (a/d)");
             type = in.nextLine();
            if (type.equals("a")) {

                System.out.println("Please input the player's name");

                name = in.nextLine();
                //if player is attacker ask for special zone
                System.out.println("Please input the player's special zone to shoot at (top right, bottom left, middle, etc.");
                zone = in.nextLine();
                break;

            } else if (type.equals("d")) {

                System.out.println("Please input the player's name");
                name = in.nextLine();
                zone = "blah";
                break;
            } else {
                System.out.println("Not a valid choice");

            }
        }
        //ask for player position and check if there is players there already
        while(true) {
            System.out.println("Where would you like your player (left, right, middle)?");
            pos = in.nextLine();
            if(pos.equals("right")){
                if(right != 0) {
                    System.out.println("already have a player on the right, pick again");
                    continue;
                }
                else{
                    right++;
                }
                break;
            }
            else if(pos.equals("left")){
                if(left != 0) {
                    System.out.println("already have a player on the left, pick again");
                    continue;
                }
                else{
                    left++;
                }
                break;
            }
            else if(pos.equals("middle")){
                if(middle != 0) {
                    System.out.println("already have a player on the middle, pick again");
                    continue;
                }
                else{
                    middle++;
                }
                break;
            }
            else{
                System.out.println("Not an option, pick again");
            }
        }
        //assign rows and cols
        if(color.equals(" R ")){
             row = 2;
        }
        else{
            row = 7;
        }
        if(pos.equals("left")){
            col = 2;
        }
        else if(pos.equals("right")){
            col = 7;
        }
        else{
            col = 4;
        }

        //initialize and add players to list
        for(int i = 0; i < team.length; i++){
            if(team[i] == null){
                if(type.equals("a")){

                    team[i] = new Attacker(name, row, col, pos, zone);
                    break;
                }
                else{

                    team[i] = new Defender(name,row,col,pos);
                    break;
                }
            }

        }
    }

    /**
     * searches and returns a player with the specified row and col in the list
     *
     * @param row row for player to get
     * @param col col for player to get
     * @return player if exists in list, null if doesn't
     */
    public SoccerPlayer getPlayer(int row, int col){
        for(SoccerPlayer i: team){
            if(i.getRow() == row && i.getCol() == col){
                return i;
            }
        }
        return null;
    }


    /**
     * returns a string specifying all the rows and cols of a team
     * @return the row and column of every player in a string format
     */
    public String toString(){
        String string = "";
        for(SoccerPlayer i: team){
            string += " row: " + i.getRow() + " column: " + i.getCol() + " ";
        }
        return string;
    }
}
