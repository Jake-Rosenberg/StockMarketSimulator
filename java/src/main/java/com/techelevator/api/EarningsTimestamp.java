
package com.techelevator.api;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class EarningsTimestamp {

    private String date;
    private String timezone;
    private Integer timezoneType;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getTimezoneType() {
        return timezoneType;
    }

    public void setTimezoneType(Integer timezoneType) {
        this.timezoneType = timezoneType;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.date == null)? 0 :this.date.hashCode()));
        result = ((result* 31)+((this.timezoneType == null)? 0 :this.timezoneType.hashCode()));
        result = ((result* 31)+((this.timezone == null)? 0 :this.timezone.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EarningsTimestamp) == false) {
            return false;
        }
        EarningsTimestamp rhs = ((EarningsTimestamp) other);
        return ((((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date)))&&((this.timezoneType == rhs.timezoneType)||((this.timezoneType!= null)&&this.timezoneType.equals(rhs.timezoneType))))&&((this.timezone == rhs.timezone)||((this.timezone!= null)&&this.timezone.equals(rhs.timezone))));
    }

}
