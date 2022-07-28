package cd.wayupdev.retrofit.tpRetrofit.data.model;

public class Dataseries {
    int transparency;
    int temp2m;
    Wind wind10m;

    public Dataseries() {
    }

    public Dataseries(int transparency, int temp2m, Wind wind10m) {
        this.transparency = transparency;
        this.temp2m = temp2m;
        this.wind10m = wind10m;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public int getTemp2m() {
        return temp2m;
    }

    public void setTemp2m(int temp2m) {
        this.temp2m = temp2m;
    }

    public Wind getWind() {
        return wind10m;
    }

    public void setWind(Wind wind10m) {
        this.wind10m = wind10m;
    }
}
