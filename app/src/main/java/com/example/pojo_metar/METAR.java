
package com.example.pojo_metar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class METAR implements Serializable {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("altimeter")
    @Expose
    private Altimeter altimeter;
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
    @SerializedName("raw")
    @Expose
    private String raw;
    @SerializedName("sanitized")
    @Expose
    private String sanitized;
    @SerializedName("station")
    @Expose
    private String station;
    @SerializedName("time")
    @Expose
    private Time time;
    @SerializedName("remarks")
    @Expose
    private String remarks;
    @SerializedName("dewpoint")
    @Expose
    private Dewpoint dewpoint;
    @SerializedName("relative_humidity")
    @Expose
    private Double relativeHumidity;
    @SerializedName("remarks_info")
    @Expose
    private RemarksInfo remarksInfo;
    @SerializedName("runway_visibility")
    @Expose
    private List<Object> runwayVisibility = null;
    @SerializedName("temperature")
    @Expose
    private Temperature temperature;
    @SerializedName("wind_variable_direction")
    @Expose
    private List<Object> windVariableDirection = null;
    @SerializedName("density_altitude")
    @Expose
    private Integer densityAltitude;
    @SerializedName("pressure_altitude")
    @Expose
    private Integer pressureAltitude;
    @SerializedName("units")
    @Expose
    private Units units;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Altimeter getAltimeter() {
        return altimeter;
    }

    public void setAltimeter(Altimeter altimeter) {
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

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Dewpoint getDewpoint() {
        return dewpoint;
    }

    public void setDewpoint(Dewpoint dewpoint) {
        this.dewpoint = dewpoint;
    }

    public Double getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(Double relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public RemarksInfo getRemarksInfo() {
        return remarksInfo;
    }

    public void setRemarksInfo(RemarksInfo remarksInfo) {
        this.remarksInfo = remarksInfo;
    }

    public List<Object> getRunwayVisibility() {
        return runwayVisibility;
    }

    public void setRunwayVisibility(List<Object> runwayVisibility) {
        this.runwayVisibility = runwayVisibility;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public List<Object> getWindVariableDirection() {
        return windVariableDirection;
    }

    public void setWindVariableDirection(List<Object> windVariableDirection) {
        this.windVariableDirection = windVariableDirection;
    }

    public Integer getDensityAltitude() {
        return densityAltitude;
    }

    public void setDensityAltitude(Integer densityAltitude) {
        this.densityAltitude = densityAltitude;
    }

    public Integer getPressureAltitude() {
        return pressureAltitude;
    }

    public void setPressureAltitude(Integer pressureAltitude) {
        this.pressureAltitude = pressureAltitude;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(METAR.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("meta");
        sb.append('=');
        sb.append(((this.meta == null)?"<null>":this.meta));
        sb.append(',');
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
        sb.append("raw");
        sb.append('=');
        sb.append(((this.raw == null)?"<null>":this.raw));
        sb.append(',');
        sb.append("sanitized");
        sb.append('=');
        sb.append(((this.sanitized == null)?"<null>":this.sanitized));
        sb.append(',');
        sb.append("station");
        sb.append('=');
        sb.append(((this.station == null)?"<null>":this.station));
        sb.append(',');
        sb.append("time");
        sb.append('=');
        sb.append(((this.time == null)?"<null>":this.time));
        sb.append(',');
        sb.append("remarks");
        sb.append('=');
        sb.append(((this.remarks == null)?"<null>":this.remarks));
        sb.append(',');
        sb.append("dewpoint");
        sb.append('=');
        sb.append(((this.dewpoint == null)?"<null>":this.dewpoint));
        sb.append(',');
        sb.append("relativeHumidity");
        sb.append('=');
        sb.append(((this.relativeHumidity == null)?"<null>":this.relativeHumidity));
        sb.append(',');
        sb.append("remarksInfo");
        sb.append('=');
        sb.append(((this.remarksInfo == null)?"<null>":this.remarksInfo));
        sb.append(',');
        sb.append("runwayVisibility");
        sb.append('=');
        sb.append(((this.runwayVisibility == null)?"<null>":this.runwayVisibility));
        sb.append(',');
        sb.append("temperature");
        sb.append('=');
        sb.append(((this.temperature == null)?"<null>":this.temperature));
        sb.append(',');
        sb.append("windVariableDirection");
        sb.append('=');
        sb.append(((this.windVariableDirection == null)?"<null>":this.windVariableDirection));
        sb.append(',');
        sb.append("densityAltitude");
        sb.append('=');
        sb.append(((this.densityAltitude == null)?"<null>":this.densityAltitude));
        sb.append(',');
        sb.append("pressureAltitude");
        sb.append('=');
        sb.append(((this.pressureAltitude == null)?"<null>":this.pressureAltitude));
        sb.append(',');
        sb.append("units");
        sb.append('=');
        sb.append(((this.units == null)?"<null>":this.units));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
