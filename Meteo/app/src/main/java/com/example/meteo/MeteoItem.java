package com.example.meteo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName ="table_name")
public class MeteoItem implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int ID;
    @ColumnInfo
    public int temperature;
    @ColumnInfo
    public int tempMax;
    @ColumnInfo
    public int tempMin;
    @ColumnInfo
    public int pression;
    @ColumnInfo
    public String image;
    @ColumnInfo
    public String date;
    @ColumnInfo
    public double lon;
    @ColumnInfo
    public double lat;

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public int getPression() {
        return pression;
    }

    public void setPression(int pression) {
        this.pression = pression;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
