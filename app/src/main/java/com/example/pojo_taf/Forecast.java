
package com.example.pojo_taf;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class Forecast implements Serializable {

    @SerializedName("altimeter")
    @Expose
    private Object altimeter;
    @SerializedName("clouds")
    @Expose
    private List<Cloud> clouds = null;
    @SerializedName("flight_rules")
    @Expose
    private String flightRules;
    @SerializedName("other")
    @Expose
    private List<Object> other = null;
    @SerializedName("visibility")
    @Expose
    private Visibility visibility;
    @SerializedName("wind_direction")
    @Expose
    private WindDirection windDirection;
    @SerializedName("wind_gust")
    @Expose
    private Object windGust;
    @SerializedName("wind_speed")
    @Expose
    private WindSpeed windSpeed;
    @SerializedName("wx_codes")
    @Expose
    private List<Object> wxCodes = null;
    @SerializedName("end_time")
    @Expose
    private EndTime endTime;
    @SerializedName("icing")
    @Expose
    private List<Object> icing = null;
    @SerializedName("probability")
    @Expose
    private Object probability;
    @SerializedName("raw")
    @Expose
    private String raw;
    @SerializedName("sanitized")
    @Expose
    private String sanitized;
    @SerializedName("start_time")
    @Expose
    private StartTime startTime;
    @SerializedName("transition_start")
    @Expose
    private Object transitionStart;
    @SerializedName("turbulence")
    @Expose
    private List<Object> turbulence = null;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("wind_shear")
    @Expose
    private Object windShear;
    @SerializedName("summary")
    @Expose
    private String summary;

    public Object getAltimeter() {
        return altimeter;
    }

    public void setAltimeter(Object altimeter) {
        this.altimeter = altimeter;
    }

    public List<Cloud> getClouds() {
        return clouds;
    }

    public void setClouds(List<Cloud> clouds) {
        this.clouds = clouds;
    }

    public String getFlightRules() {
        return flightRules;
    }

    public void setFlightRules(String flightRules) {
        this.flightRules = flightRules;
    }

    public List<Object> getOther() {
        return other;
    }

    public void setOther(List<Object> other) {
        this.other = other;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public WindDirection getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(WindDirection windDirection) {
        this.windDirection = windDirection;
    }

    public Object getWindGust() {
        return windGust;
    }

    public void setWindGust(Object windGust) {
        this.windGust = windGust;
    }

    public WindSpeed getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(WindSpeed windSpeed) {
        this.windSpeed = windSpeed;
    }

    public List<Object> getWxCodes() {
        return wxCodes;
    }

    public void setWxCodes(List<Object> wxCodes) {
        this.wxCodes = wxCodes;
    }

    public EndTime getEndTime() {
        return endTime;
    }

    public void setEndTime(EndTime endTime) {
        this.endTime = endTime;
    }

    public List<Object> getIcing() {
        return icing;
    }

    public void setIcing(List<Object> icing) {
        this.icing = icing;
    }

    public Object getProbability() {
        return probability;
    }

    public void setProbability(Object probability) {
        this.probability = probability;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getSanitized() {
        return sanitized;
    }

    public void setSanitized(String sanitized) {
        this.sanitized = sanitized;
    }

    public StartTime getStartTime() {
        return startTime;
    }

    public void setStartTime(StartTime startTime) {
        this.startTime = startTime;
    }

    public Object getTransitionStart() {
        return transitionStart;
    }

    public void setTransitionStart(Object transitionStart) {
        this.transitionStart = transitionStart;
    }

    public List<Object> getTurbulence() {
        return turbulence;
    }

    public void setTurbulence(List<Object> turbulence) {
        this.turbulence = turbulence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getWindShear() {
        return windShear;
    }

    public void setWindShear(Object windShear) {
        this.windShear = windShear;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Forecast.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("altimeter");
        sb.append('=');
        sb.append(((this.altimeter == null)?"<null>":this.altimeter));
        sb.append(',');
        sb.append("clouds");
        sb.append('=');
        sb.append(((this.clouds == null)?"<null>":this.clouds));
        sb.append(',');
        sb.append("flightRules");
        sb.append('=');
        sb.append(((this.flightRules == null)?"<null>":this.flightRules));
        sb.append(',');
        sb.append("other");
        sb.append('=');
        sb.append(((this.other == null)?"<null>":this.other));
        sb.append(',');
        sb.append("visibility");
        sb.append('=');
        sb.append(((this.visibility == null)?"<null>":this.visibility));
        sb.append(',');
        sb.append("windDirection");
        sb.append('=');
        sb.append(((this.windDirection == null)?"<null>":this.windDirection));
        sb.append(',');
        sb.append("windGust");
        sb.append('=');
        sb.append(((this.windGust == null)?"<null>":this.windGust));
        sb.append(',');
        sb.append("windSpeed");
        sb.append('=');
        sb.append(((this.windSpeed == null)?"<null>":this.windSpeed));
        sb.append(',');
        sb.append("wxCodes");
        sb.append('=');
        sb.append(((this.wxCodes == null)?"<null>":this.wxCodes));
        sb.append(',');
        sb.append("endTime");
        sb.append('=');
        sb.append(((this.endTime == null)?"<null>":this.endTime));
        sb.append(',');
        sb.append("icing");
        sb.append('=');
        sb.append(((this.icing == null)?"<null>":this.icing));
        sb.append(',');
        sb.append("probability");
        sb.append('=');
        sb.append(((this.probability == null)?"<null>":this.probability));
        sb.append(',');
        sb.append("raw");
        sb.append('=');
        sb.append(((this.raw == null)?"<null>":this.raw));
        sb.append(',');
        sb.append("sanitized");
        sb.append('=');
        sb.append(((this.sanitized == null)?"<null>":this.sanitized));
        sb.append(',');
        sb.append("startTime");
        sb.append('=');
        sb.append(((this.startTime == null)?"<null>":this.startTime));
        sb.append(',');
        sb.append("transitionStart");
        sb.append('=');
        sb.append(((this.transitionStart == null)?"<null>":this.transitionStart));
        sb.append(',');
        sb.append("turbulence");
        sb.append('=');
        sb.append(((this.turbulence == null)?"<null>":this.turbulence));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("windShear");
        sb.append('=');
        sb.append(((this.windShear == null)?"<null>":this.windShear));
        sb.append(',');
        sb.append("summary");
        sb.append('=');
        sb.append(((this.summary == null)?"<null>":this.summary));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
