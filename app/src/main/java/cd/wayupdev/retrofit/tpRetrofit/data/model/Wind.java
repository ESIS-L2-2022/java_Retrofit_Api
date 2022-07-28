package cd.wayupdev.retrofit.tpRetrofit.data.model;

public class Wind {
    String direction;
    int speed;

    public Wind() {
    }

    public Wind(String direction, int speed) {
        this.direction = direction;
        this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
