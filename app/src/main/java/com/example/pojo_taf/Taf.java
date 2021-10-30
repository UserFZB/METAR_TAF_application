
package com.example.pojo_taf;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class Taf implements Serializable {

    @SerializedName("meta")
    @Expose
    private Meta meta;
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
    @SerializedName("forecast")
    @Expose
    private List<Forecast> forecast = null;
    @SerializedName("start_time")
    @Expose
    private StartTime__1 startTime;
    @SerializedName("end_time")
    @Expose
    private EndTime__1 endTime;
    @SerializedName("max_temp")
    @Expose
    private Object maxTemp;
    @SerializedName("min_temp")
    @Expose
    private Object minTemp;
    @SerializedName("alts")
    @Expose
    private Object alts;
    @SerializedName("temps")
    @Expose
    private Object temps;
    @SerializedName("remarks_info")
    @Expose
    private Object remarksInfo;
    @SerializedName("units")
    @Expose
    private Units units;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
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

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public StartTime__1 getStartTime() {
        return startTime;
    }

    public void setStartTime(StartTime__1 startTime) {
        this.startTime = startTime;
    }

    public EndTime__1 getEndTime() {
        return endTime;
    }

    public void setEndTime(EndTime__1 endTime) {
        this.endTime = endTime;
    }

    public Object getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Object maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Object getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Object minTemp) {
        this.minTemp = minTemp;
    }

    public Object getAlts() {
        return alts;
    }

    public void setAlts(Object alts) {
        this.alts = alts;
    }

    public Object getTemps() {
        return temps;
    }

    public void setTemps(Object temps) {
        this.temps = temps;
    }

    public Object getRemarksInfo() {
        return remarksInfo;
    }

    public void setRemarksInfo(Object remarksInfo) {
        this.remarksInfo = remarksInfo;
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
        sb.append(Taf.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("meta");
        sb.append('=');
        sb.append(((this.meta == null)?"<null>":this.meta));
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
        sb.append("forecast");
        sb.append('=');
        sb.append(((this.forecast == null)?"<null>":this.forecast));
        sb.append(',');
        sb.append("startTime");
        sb.append('=');
        sb.append(((this.startTime == null)?"<null>":this.startTime));
        sb.append(',');
        sb.append("endTime");
        sb.append('=');
        sb.append(((this.endTime == null)?"<null>":this.endTime));
        sb.append(',');
        sb.append("maxTemp");
        sb.append('=');
        sb.append(((this.maxTemp == null)?"<null>":this.maxTemp));
        sb.append(',');
        sb.append("minTemp");
        sb.append('=');
        sb.append(((this.minTemp == null)?"<null>":this.minTemp));
        sb.append(',');
        sb.append("alts");
        sb.append('=');
        sb.append(((this.alts == null)?"<null>":this.alts));
        sb.append(',');
        sb.append("temps");
        sb.append('=');
        sb.append(((this.temps == null)?"<null>":this.temps));
        sb.append(',');
        sb.append("remarksInfo");
        sb.append('=');
        sb.append(((this.remarksInfo == null)?"<null>":this.remarksInfo));
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
