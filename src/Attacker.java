public class Attacker extends SoccerPlayer {
    public String specialZone;
    public boolean isOffside;

    public Attacker(double h, double w, String n, boolean guarded, boolean guarding, String p, boolean ball, String zone, boolean off){
        super(h,w,n,guarded,guarding,p,ball);
        specialZone = zone;
        isOffside = off;
    }

    public String getSpecialZone(){
        return specialZone;
    }
    public boolean isOffside(){
        return isOffside;
    }
    public void run(String where){
        if(isOffside){
            System.out.println(this.getName() + " is making a run from " + this.getPosInField() + " to " + where);
            System.out.println("Offside, run invalid");
            isOffside = false;
        }
        else{
            super.run(where);
        }
    }
    public boolean shoot(String where){
        if(this.getPosInField().equals("goal box") || this.getPosInField().equals(specialZone)){
            System.out.println(this.getName() + " shoots at " + where + " from " + this.getPosInField() + " successfully");
            return true;

        }
        else{
            System.out.println(this.getName() + " shoots at " + where + " from " + this.getPosInField() + " unsuccessfully");
            return false;
        }
    }
}
