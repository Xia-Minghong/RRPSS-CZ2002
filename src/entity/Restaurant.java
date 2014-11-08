package entity;

import java.util.ArrayList;

/**
 * Created by Xia-Minghong on 14-11-7.
 */
public class Restaurant {

    private double GST_RATE;
    private double SERVICE_CHARGE_RATE;

    public double getGST_RATE() {
        return GST_RATE;
    }

    public void setGST_RATE(double GST_RATE) {
        this.GST_RATE = GST_RATE;
    }

    public double getSERVICE_CHARGE_RATE() {
        return SERVICE_CHARGE_RATE;
    }

    public void setSERVICE_CHARGE_RATE(double SERVICE_CHARGE_RATE) {
        this.SERVICE_CHARGE_RATE = SERVICE_CHARGE_RATE;
    }

}
