import java.util.ArrayList;

public class SoccerGame {
    private String[][] field = new String[10][10];
    private Team teamOne;
    private Team teamTwo;

    public SoccerGame(Team one, Team two){
        teamOne = one;
        teamTwo = two;
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
     }

     public void printField(){
        System.out.println("    0  1  2  3  4  5  6  7  8  9");
         for(int i = 0; i < field.length; i++) {
             System.out.print(" " + i + " ");
             for (int j = 0; j < field[0].length; j++) {
                 System.out.print(field[i][j]);
                 if(j == 9){
                     System.out.println();
                 }
             }
         }
     }
     public static void main(String[] args){
        Team one = new Team("red");
        Team two = new Team("blue");
        SoccerGame blah = new SoccerGame(one, two);
        blah.printField();
     }


}
