
package com.example.pojo_metar;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Meta implements Serializable {

    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("stations_updated")
    @Expose
    private String stationsUpdated;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStationsUpdated() {
        return stationsUpdated;
    }

    public void setStationsUpdated(String stationsUpdated) {
        this.stationsUpdated = stationsUpdated;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Meta.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
        sb.append(',');
        sb.append("stationsUpdated");
        sb.append('=');
        sb.append(((this.stationsUpdated == null)?"<null>":this.stationsUpdated));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
