
package com.example.pojo_station;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Runway {

    @SerializedName("length_ft")
    @Expose
    private Integer lengthFt;
    @SerializedName("width_ft")
    @Expose
    private Integer widthFt;
    @SerializedName("surface")
    @Expose
    private String surface;
    @SerializedName("lights")
    @Expose
    private Boolean lights;
    @SerializedName("ident1")
    @Expose
    private String ident1;
    @SerializedName("ident2")
    @Expose
    private String ident2;
    @SerializedName("bearing1")
    @Expose
    private Double bearing1;
    @SerializedName("bearing2")
    @Expose
    private Double bearing2;

    public Integer getLengthFt() {
        return lengthFt;
    }

    public void setLengthFt(Integer lengthFt) {
        this.lengthFt = lengthFt;
    }

    public Integer getWidthFt() {
        return widthFt;
    }

    public void setWidthFt(Integer widthFt) {
        this.widthFt = widthFt;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public Boolean getLights() {
        return lights;
    }

    public void setLights(Boolean lights) {
        this.lights = lights;
    }

    public String getIdent1() {
        return ident1;
    }

    public void setIdent1(String ident1) {
        this.ident1 = ident1;
    }

    public String getIdent2() {
        return ident2;
    }

    public void setIdent2(String ident2) {
        this.ident2 = ident2;
    }

    public Double getBearing1() {
        return bearing1;
    }

    public void setBearing1(Double bearing1) {
        this.bearing1 = bearing1;
    }

    public Double getBearing2() {
        return bearing2;
    }

    public void setBearing2(Double bearing2) {
        this.bearing2 = bearing2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Runway.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lengthFt");
        sb.append('=');
        sb.append(((this.lengthFt == null)?"<null>":this.lengthFt));
        sb.append(',');
        sb.append("widthFt");
        sb.append('=');
        sb.append(((this.widthFt == null)?"<null>":this.widthFt));
        sb.append(',');
        sb.append("surface");
        sb.append('=');
        sb.append(((this.surface == null)?"<null>":this.surface));
        sb.append(',');
        sb.append("lights");
        sb.append('=');
        sb.append(((this.lights == null)?"<null>":this.lights));
        sb.append(',');
        sb.append("ident1");
        sb.append('=');
        sb.append(((this.ident1 == null)?"<null>":this.ident1));
        sb.append(',');
        sb.append("ident2");
        sb.append('=');
        sb.append(((this.ident2 == null)?"<null>":this.ident2));
        sb.append(',');
        sb.append("bearing1");
        sb.append('=');
        sb.append(((this.bearing1 == null)?"<null>":this.bearing1));
        sb.append(',');
        sb.append("bearing2");
        sb.append('=');
        sb.append(((this.bearing2 == null)?"<null>":this.bearing2));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
