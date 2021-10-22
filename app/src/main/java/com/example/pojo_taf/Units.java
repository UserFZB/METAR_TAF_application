
package com.example.pojo_taf;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Units {

    @SerializedName("accumulation")
    @Expose
    private String accumulation;
    @SerializedName("altimeter")
    @Expose
    private String altimeter;
    @SerializedName("altitude")
    @Expose
    private String altitude;
    @SerializedName("temperature")
    @Expose
    private String temperature;
    @SerializedName("visibility")
    @Expose
    private String visibility;
    @SerializedName("wind_speed")
    @Expose
    private String windSpeed;

    public String getAccumulation() {
        return accumulation;
    }

    public void setAccumulation(String accumulation) {
        this.accumulation = accumulation;
    }

    public String getAltimeter() {
        return altimeter;
    }

    public void setAltimeter(String altimeter) {
        this.altimeter = altimeter;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Units.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("accumulation");
        sb.append('=');
        sb.append(((this.accumulation == null)?"<null>":this.accumulation));
        sb.append(',');
        sb.append("altimeter");
        sb.append('=');
        sb.append(((this.altimeter == null)?"<null>":this.altimeter));
        sb.append(',');
        sb.append("altitude");
        sb.append('=');
        sb.append(((this.altitude == null)?"<null>":this.altitude));
        sb.append(',');
        sb.append("temperature");
        sb.append('=');
        sb.append(((this.temperature == null)?"<null>":this.temperature));
        sb.append(',');
        sb.append("visibility");
        sb.append('=');
        sb.append(((this.visibility == null)?"<null>":this.visibility));
        sb.append(',');
        sb.append("windSpeed");
        sb.append('=');
        sb.append(((this.windSpeed == null)?"<null>":this.windSpeed));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
