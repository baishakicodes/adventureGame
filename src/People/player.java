package People;

public class player implements Person {
    private String firstName;
    private int xLoc, yLoc;
    public player(String firstName, int xLoc, int yLoc){
        this.firstName = firstName;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }
    public String getFirstName(){
        return firstName;
    }
    public int getxLoc(){
        return xLoc;
    }
    public void setxLoc(int xLoc){
        this.xLoc = xLoc;
    }
    public  int getyLoc(){
        return yLoc;
    }
    public void setyLoc(int yLoc){
        this.yLoc = yLoc;
    }
    public String location(){
        return "[ x ]";
    }
}
