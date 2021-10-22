
package com.example.pojo_taf;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StartTime__1 {

    @SerializedName("repr")
    @Expose
    private String repr;
    @SerializedName("dt")
    @Expose
    private String dt;

    public String getRepr() {
        return repr;
    }

    public void setRepr(String repr) {
        this.repr = repr;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StartTime__1.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("repr");
        sb.append('=');
        sb.append(((this.repr == null)?"<null>":this.repr));
        sb.append(',');
        sb.append("dt");
        sb.append('=');
        sb.append(((this.dt == null)?"<null>":this.dt));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
