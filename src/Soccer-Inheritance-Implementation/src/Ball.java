/**
 * class that represents the position of a game ball in a Soccer gam
 */
public class Ball {

    private int row;
    private int col;

    /**
     * constructs ball object
     * @param row starting row pos
     * @param col starting col pos
     */
    public Ball(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public void setRow(int r){
        row = r;
    }
    public void setCol(int c){
        col = c;
    }
}
