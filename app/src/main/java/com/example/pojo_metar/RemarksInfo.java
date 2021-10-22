
package com.example.pojo_metar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RemarksInfo {

    @SerializedName("maximum_temperature_6")
    @Expose
    private Object maximumTemperature6;
    @SerializedName("minimum_temperature_6")
    @Expose
    private Object minimumTemperature6;
    @SerializedName("pressure_tendency")
    @Expose
    private Object pressureTendency;
    @SerializedName("precip_36_hours")
    @Expose
    private Object precip36Hours;
    @SerializedName("precip_24_hours")
    @Expose
    private Object precip24Hours;
    @SerializedName("sunshine_minutes")
    @Expose
    private Object sunshineMinutes;
    @SerializedName("codes")
    @Expose
    private List<Code> codes = null;
    @SerializedName("dewpoint_decimal")
    @Expose
    private DewpointDecimal dewpointDecimal;
    @SerializedName("maximum_temperature_24")
    @Expose
    private Object maximumTemperature24;
    @SerializedName("minimum_temperature_24")
    @Expose
    private Object minimumTemperature24;
    @SerializedName("precip_hourly")
    @Expose
    private Object precipHourly;
    @SerializedName("sea_level_pressure")
    @Expose
    private SeaLevelPressure seaLevelPressure;
    @SerializedName("snow_depth")
    @Expose
    private Object snowDepth;
    @SerializedName("temperature_decimal")
    @Expose
    private TemperatureDecimal temperatureDecimal;

    public Object getMaximumTemperature6() {
        return maximumTemperature6;
    }

    public void setMaximumTemperature6(Object maximumTemperature6) {
        this.maximumTemperature6 = maximumTemperature6;
    }

    public Object getMinimumTemperature6() {
        return minimumTemperature6;
    }

    public void setMinimumTemperature6(Object minimumTemperature6) {
        this.minimumTemperature6 = minimumTemperature6;
    }

    public Object getPressureTendency() {
        return pressureTendency;
    }

    public void setPressureTendency(Object pressureTendency) {
        this.pressureTendency = pressureTendency;
    }

    public Object getPrecip36Hours() {
        return precip36Hours;
    }

    public void setPrecip36Hours(Object precip36Hours) {
        this.precip36Hours = precip36Hours;
    }

    public Object getPrecip24Hours() {
        return precip24Hours;
    }

    public void setPrecip24Hours(Object precip24Hours) {
        this.precip24Hours = precip24Hours;
    }

    public Object getSunshineMinutes() {
        return sunshineMinutes;
    }

    public void setSunshineMinutes(Object sunshineMinutes) {
        this.sunshineMinutes = sunshineMinutes;
    }

    public List<Code> getCodes() {
        return codes;
    }

    public void setCodes(List<Code> codes) {
        this.codes = codes;
    }

    public DewpointDecimal getDewpointDecimal() {
        return dewpointDecimal;
    }

    public void setDewpointDecimal(DewpointDecimal dewpointDecimal) {
        this.dewpointDecimal = dewpointDecimal;
    }

    public Object getMaximumTemperature24() {
        return maximumTemperature24;
    }

    public void setMaximumTemperature24(Object maximumTemperature24) {
        this.maximumTemperature24 = maximumTemperature24;
    }

    public Object getMinimumTemperature24() {
        return minimumTemperature24;
    }

    public void setMinimumTemperature24(Object minimumTemperature24) {
        this.minimumTemperature24 = minimumTemperature24;
    }

    public Object getPrecipHourly() {
        return precipHourly;
    }

    public void setPrecipHourly(Object precipHourly) {
        this.precipHourly = precipHourly;
    }

    public SeaLevelPressure getSeaLevelPressure() {
        return seaLevelPressure;
    }

    public void setSeaLevelPressure(SeaLevelPressure seaLevelPressure) {
        this.seaLevelPressure = seaLevelPressure;
    }

    public Object getSnowDepth() {
        return snowDepth;
    }

    public void setSnowDepth(Object snowDepth) {
        this.snowDepth = snowDepth;
    }

    public TemperatureDecimal getTemperatureDecimal() {
        return temperatureDecimal;
    }

    public void setTemperatureDecimal(TemperatureDecimal temperatureDecimal) {
        this.temperatureDecimal = temperatureDecimal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RemarksInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("maximumTemperature6");
        sb.append('=');
        sb.append(((this.maximumTemperature6 == null)?"<null>":this.maximumTemperature6));
        sb.append(',');
        sb.append("minimumTemperature6");
        sb.append('=');
        sb.append(((this.minimumTemperature6 == null)?"<null>":this.minimumTemperature6));
        sb.append(',');
        sb.append("pressureTendency");
        sb.append('=');
        sb.append(((this.pressureTendency == null)?"<null>":this.pressureTendency));
        sb.append(',');
        sb.append("precip36Hours");
        sb.append('=');
        sb.append(((this.precip36Hours == null)?"<null>":this.precip36Hours));
        sb.append(',');
        sb.append("precip24Hours");
        sb.append('=');
        sb.append(((this.precip24Hours == null)?"<null>":this.precip24Hours));
        sb.append(',');
        sb.append("sunshineMinutes");
        sb.append('=');
        sb.append(((this.sunshineMinutes == null)?"<null>":this.sunshineMinutes));
        sb.append(',');
        sb.append("codes");
        sb.append('=');
        sb.append(((this.codes == null)?"<null>":this.codes));
        sb.append(',');
        sb.append("dewpointDecimal");
        sb.append('=');
        sb.append(((this.dewpointDecimal == null)?"<null>":this.dewpointDecimal));
        sb.append(',');
        sb.append("maximumTemperature24");
        sb.append('=');
        sb.append(((this.maximumTemperature24 == null)?"<null>":this.maximumTemperature24));
        sb.append(',');
        sb.append("minimumTemperature24");
        sb.append('=');
        sb.append(((this.minimumTemperature24 == null)?"<null>":this.minimumTemperature24));
        sb.append(',');
        sb.append("precipHourly");
        sb.append('=');
        sb.append(((this.precipHourly == null)?"<null>":this.precipHourly));
        sb.append(',');
        sb.append("seaLevelPressure");
        sb.append('=');
        sb.append(((this.seaLevelPressure == null)?"<null>":this.seaLevelPressure));
        sb.append(',');
        sb.append("snowDepth");
        sb.append('=');
        sb.append(((this.snowDepth == null)?"<null>":this.snowDepth));
        sb.append(',');
        sb.append("temperatureDecimal");
        sb.append('=');
        sb.append(((this.temperatureDecimal == null)?"<null>":this.temperatureDecimal));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
