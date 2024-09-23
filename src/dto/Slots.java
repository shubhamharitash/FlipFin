package dto;

import java.util.Objects;

public class Slots {
    String startTime;
    String endTime;
    boolean isBooked;
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slots slots = (Slots) o;
        return startTime.equals(slots.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime);
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }



    @Override
    public String toString() {
        return "\n"+"Slots{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", isBooked=" + isBooked +
                '}';
    }

    public Slots(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.isBooked = false;
    }

}
