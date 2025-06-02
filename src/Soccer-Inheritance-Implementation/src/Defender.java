/**
 * subclass of SoccerPlayer that has 100% successful passes but lower pace
 */
public class Defender extends SoccerPlayer{


    /**
     * creates Defender object
     * @param n name
     * @param row row pos
     * @param col col pos
     * @param pos starting literal position
     */
    public Defender(String n, int row, int col, String pos){

       super(n,2,row,col,pos);

    }

    /**
     * passes with 100% accuracy if player has the ball
     * @param s   player they are passing to
     * @param arr array the players are located on
     * @return if pass was successful
     */
    public boolean pass(SoccerPlayer s, String[][] arr){

        if(this.hasBall(arr)) {
            System.out.println(this.getName() + " passes to " + s.getName());
            this.setBall(false);
            s.setBall(true);
            return true;
        }
        else{
            System.out.println("Player doesn't have ball");
            return false;
        }



    }
}
