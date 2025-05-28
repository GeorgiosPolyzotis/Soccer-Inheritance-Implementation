public class Attacker extends SoccerPlayer {


    private String specialZone;

    public Attacker(String n, int r, int c, String pos, String zone) {
        super(n,3, r, c,pos);
        specialZone = zone;

    }

    public boolean shoot(String where) {
        int chance;
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