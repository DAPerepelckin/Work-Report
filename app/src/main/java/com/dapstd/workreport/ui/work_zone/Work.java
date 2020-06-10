package com.dapstd.workreport.ui.work_zone;

import android.text.format.Time;

public class Work {
    private String description;
    private Time time;

    public Work(String description) {
        this.description = description;
        //this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
