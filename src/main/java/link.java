import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class link {
    private int id;
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

    @Override
    public String toString()
    {
        String link2_check = this.link2.equals("") ? "Unavailable" : this.link2;

        return String.format("Num: %d\nLink: %s\nSecondary link: %s\nDate: %s\n", this.id, this.link1, link2_check, this.date);
    }
}
