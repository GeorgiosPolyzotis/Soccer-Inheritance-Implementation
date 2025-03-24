public class SoccerPlayer {
    private double height;
    private double weight;
    private String name;
    private boolean isGuarded;
    private boolean isGuarding;
    private String posInField;
    public boolean hasBall;

    public SoccerPlayer(double h, double w, String n, boolean guarded, boolean guarding, String p, boolean ball){
        height = h;
        weight = w;
        name = n;
        isGuarded = guarded;
        isGuarding = guarding;
        posInField = p;
        hasBall = ball;
    }
    public double getHeight(){
        return height;
    }
    public boolean hasBall(){
        return hasBall;
    }
    public double getWeight(){
        return weight;
    }
    public String getName(){
        return name;
    }
    public boolean isGuarded(){
        return isGuarded;
    }
    public boolean isGuarding(){
        return isGuarding;
    }
    public String getPosInField(){
        return posInField;
    }

    public void guard(SoccerPlayer s){
        s.isGuarded = true;
        this.isGuarding = true;
        System.out.println(this.name + " is guarding " + s.name);
    }
    public void run(String where){

        System.out.println(this.name + " is making a run from " + this.posInField + " to " + where);
        this.posInField = where;
    }
    public void pass(SoccerPlayer s){
        if(this.hasBall){
            System.out.println(this.name + " passes to " + s.name);
            this.hasBall = false;
            s.hasBall = true;
        }
        else{
            System.out.println(this.name + " doesn't have the ball");
        }
    }
    public boolean shoot(String where){
        if(this.isGuarded && !(this.posInField.equals("goal box"))){
            System.out.println(name + " shoots at " + where + " from " + posInField + " unsuccessfully");
            return false;
        }
        else{
            System.out.println(name + " shoots at " + where + " from " + posInField + " successfully");
            return true;
        }
    }




}
