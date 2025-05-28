import java.util.ArrayList;
import java.util.Scanner;
public class Team {

    private  int middle = 0;
    private  int right = 0;
    private  int left = 0;
    private SoccerPlayer[] team;
    private String color;
    public Team(String color){
        team = new SoccerPlayer[3];
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public  void addPlayer(){
        Scanner in = new Scanner(System.in);
        String type; String pos; String name; int row; int col;
        String zone;
        while(true) {
            System.out.println("Would you like an attacker or defender? (a/d)");
             type = in.next();
            if (type.equals("a")) {

                System.out.println("Please input the player's name");
                name = in.nextLine();
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
        while(true) {
            System.out.println("Where would you like your player (left, right, middle)?");
            pos = in.next();
            if(pos.equals("right")){
                if(right != 0) {
                    System.out.println("already have a player on the right, pick again");
                }
                else{
                    right++;
                }
                break;
            }
            else if(pos.equals("left")){
                if(left != 0) {
                    System.out.println("already have a player on the left, pick again");
                }
                else{
                    left++;
                }
                break;
            }
            else if(pos.equals("middle")){
                if(middle != 0) {
                    System.out.println("already have a player on the middle, pick again");
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
        if(color.equals("red")){
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
        int index = 0;
        for(SoccerPlayer i: team){
            if(!(i.equals(null))){
                if(type.equals("a")){
                    team[index] = new Attacker(name, row, col, pos, zone);
                    break;
                }
                else{
                    team[index] = new Defender(name,row,col,pos);
                    break;
                }
            }
            index++;
        }
    }
}
