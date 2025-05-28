public class SoccerPlayer {


    private String name;
    private boolean hasBall;
    private int pace;
    private int row;
    private int col;
    private String pos;

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

    public boolean hasBall(){
        return hasBall;
    }

    public String getName(){
        return name;
    }

    public int getPace(){
        return pace;
    }
    public int getRow(){ return row;}
    public int getCol(){ return col;}

    public void setRow(int r){
        row = r;
    }
    public void setCol(int c){
        col = c;
    }
    public void setBall(boolean a){
        hasBall = a;
    }


    public void run(int toRow, int toCol){

        System.out.println(this.name + " is making a run from " +row + ","+ col + " to " + toRow+","+toCol);
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
    public void pass(SoccerPlayer s){
        if(this.hasBall){
            int chance = 1 + (int) Math.random()*3;
            if(chance == 1) {
                System.out.println(this.name + " passes to " + s.name);
                this.hasBall = false;
                s.hasBall = true;
            }
            else{
                System.out.println("Pass unsuccessful.");
                this.hasBall = false;
            }
        }
        else{
            System.out.println(this.name + " doesn't have the ball");
        }
    }
    public boolean shoot(String where){
        int chance = 1 + (int) Math.random() * 6;
        if(chance == 1) {
            System.out.println(name + " shoots at " + where +   " successfully");
            return true;
        }

        return false;
    }




}
