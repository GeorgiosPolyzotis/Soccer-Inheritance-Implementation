public class Defender extends SoccerPlayer{


    public Defender(String n, int row, int col, String pos){

       super(n,2,row,col,pos);

    }
    public void pass(SoccerPlayer s){
        if(this.hasBall()){

                System.out.println(this.getName() + " passes to " + s.getName());
                this.setBall(false);
                s.setBall(true);


        }
        else{
            System.out.println(this.getName() + " doesn't have the ball");
        }
    }
}
