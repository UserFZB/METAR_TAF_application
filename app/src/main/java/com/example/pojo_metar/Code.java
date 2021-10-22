
package com.example.pojo_metar;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Code {

    @SerializedName("repr")
    @Expose
    private String repr;
    @SerializedName("value")
    @Expose
    private String value;

    public String getRepr() {
        return repr;
    }

    public void setRepr(String repr) {
        this.repr = repr;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Code.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("repr");
        sb.append('=');
        sb.append(((this.repr == null)?"<null>":this.repr));
        sb.append(',');
        sb.append("value");
        sb.append('=');
        sb.append(((this.value == null)?"<null>":this.value));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
