package com.main;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class link implements Comparable<link>{
    private final int id;
    private String link1;
    private String link2;
    private String date;

    @JsonCreator
    public link(
            @JsonProperty("id") int id,
            @JsonProperty("link1") String link1,
            @JsonProperty("link2") String link2,
            @JsonProperty("date") String date) {
        this.id = id;
        this.link1 = link1;
        this.link2 = link2;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getLink1() {
        return link1;
    }

    public String getLink2() {
        return link2;
    }

    public String getDate() {
        return date;
    }

    public void setLink1(String link1)
    {
        this.link1 = link1;
    }

    public void setLink2(String link2)
    {
        this.link2 = link2;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    @Override
    public int compareTo(link other)
    {
        return this.link1.compareTo(other.link1);
    }

    @Override
    public String toString()
    {
        String link2_check = this.link2.equals("") ? "" : "Secondary link:" + this.link2 + "\n";

        return String.format("Num: %d\nLink: %s\n%sDate: %s", this.id, this.link1, link2_check, this.date);
    }
}
