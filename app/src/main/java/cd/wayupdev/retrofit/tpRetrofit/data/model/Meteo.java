package cd.wayupdev.retrofit.tpRetrofit.data.model;

import java.util.List;

public class Meteo {
    String product;
    String init;
    List<Dataseries> dataseries;

    public Meteo(){}

    public Meteo(String product, String init, List<Dataseries> dataseries) {
        this.product = product;
        this.init = init;
        this.dataseries = dataseries;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getInit() {
        return init;
    }

    public void setInit(String init) {
        this.init = init;
    }

    public List<Dataseries> getDataseries() {
        return dataseries;
    }

    public void setDataseries(List<Dataseries> dataseries) {
        this.dataseries = dataseries;
    }
}
