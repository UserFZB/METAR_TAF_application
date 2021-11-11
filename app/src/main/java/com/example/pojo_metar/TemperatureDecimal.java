
package com.example.pojo_metar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TemperatureDecimal implements Serializable {

    @SerializedName("repr")
    @Expose
    private String repr;
    @SerializedName("value")
    @Expose
    private Double value;
    @SerializedName("spoken")
    @Expose
    private String spoken;

    public String getRepr() {
        return repr;
    }

    public void setRepr(String repr) {
        this.repr = repr;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getSpoken() {
        return spoken;
    }

    public void setSpoken(String spoken) {
        this.spoken = spoken;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TemperatureDecimal.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("repr");
        sb.append('=');
        sb.append(((this.repr == null)?"<null>":this.repr));
        sb.append(',');
        sb.append("value");
        sb.append('=');
        sb.append(((this.value == null)?"<null>":this.value));
        sb.append(',');
        sb.append("spoken");
        sb.append('=');
        sb.append(((this.spoken == null)?"<null>":this.spoken));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
