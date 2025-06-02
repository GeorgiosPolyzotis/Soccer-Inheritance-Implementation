/**
 * Subclass of SoccerPlayer with greater pace and better shooting skills
 */
public class Attacker extends SoccerPlayer {


    private String specialZone;

    /**
     * constructs Attacker object with 3 pace by default
     * @param n name
     * @param r row pos
     * @param c col pos
     * @param pos literal position
     * @param zone special shooting zone
     */
    public Attacker(String n, int r, int c, String pos, String zone) {
        super(n,3, r, c,pos);
        specialZone = zone;

    }
    public boolean isAttacker(){
        return true;
    }

    /**
     * allows for player to shoot the ball based on chance and where they are shooting, more of an odd to make it than normal players
     * @param where where the player is shooting
     * @return if the shot is successful or not
     */
    public boolean shoot(String where) {
        int chance;
        this.setBall(false);
        if (where.equals(specialZone)) {
            chance = 1 + (int) Math.random() * 3;
            if (chance == 1) {
                System.out.println(this.getName() + " shoots at " + where + " successfully");

                return true;
            }

        } else {
            chance = 1 + (int) Math.random() * 5;
            if(chance == 1){
                System.out.println(this.getName() + " shoots at " + where + " successfully");
                return true;
            }

        }
        System.out.println(this.getName() + " shoots at " + where  + " unsuccessfully");
        return false;

    }
}