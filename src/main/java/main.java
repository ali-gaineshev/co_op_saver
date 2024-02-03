import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        jsonTools tool = new jsonTools();
        List<link> links = tool.read_json();
        System.out.println(links);


    }

    public boolean check_link(String uri)
    {
        int x = 1;
        return true;
        }
}