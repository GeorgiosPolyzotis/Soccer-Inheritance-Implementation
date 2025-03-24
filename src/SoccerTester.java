public class SoccerTester {
    public static void main(String[] args){
        SoccerPlayer messi = new SoccerPlayer(5.4, 180, "Messi", false, false, "left wing", false);
        SoccerPlayer ronaldo = new Attacker(6.3, 210, "Ronaldo", true, false, "front court", true, "right elbow", true);
        SoccerPlayer random = new Attacker(6.0, 200, "Arnold", false, true, "left back", false, "top of the box", false);
        random.guard(messi);
        ronaldo.pass(messi);
        ronaldo.run("left elbow");
        ronaldo.run("right elbow");
        messi.pass(ronaldo);
        messi.run("top of box");
        ronaldo.pass(messi);
        messi.shoot("top corner");
        messi.pass(ronaldo);
        random.guard(ronaldo);
        ronaldo.shoot("bottom left");


    }
}
