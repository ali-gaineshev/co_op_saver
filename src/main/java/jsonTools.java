import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class jsonTools {
    private File main_file = new File("data.json");
    public List<link> write_json(link new_link)
    {
        List<link> links = read_json();
        links.add(new_link);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(main_file, links);
            System.out.println("JSON written to file successfully.");
        }catch(Exception e)
        {
            System.out.println("Error occured. \n" + e);
            System.exit(1);
        }

        return links;
    }
    public List<link> read_json()
    {
        ObjectMapper objectMapper = new ObjectMapper();


        if(!main_file.exists())
        {
            System.out.println("No \"data.json\" file found ");
            System.exit(1);
        }
        try {
            return objectMapper.readValue(main_file, new TypeReference<List<link>>() {});
        }
        catch(Exception e)
        {
            System.out.println("Error occured. \n" + e);
            System.exit(1);
        }
        return new ArrayList<>();

    }
}
