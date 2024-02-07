import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class jsonTools {
    private static final File main_file = new File("data.json");
    private static class ObjectMap
    {
        ObjectMapper objectMapper;
        private ObjectMap()
        {
            this.objectMapper = new ObjectMapper();
            if(!main_file.exists())
            {
                System.out.println("No \"data.json\" file found ");
                System.exit(1);
            }
        }
        public ObjectMapper getObjectMapper()
        {
            return this.objectMapper;
        }
    }

    public void write_json(List<link> links)
    {

        ObjectMap obj = new ObjectMap();
        ObjectMapper objectMapper = obj.getObjectMapper();

        try {
            objectMapper.writeValue(main_file, links);
            System.out.println("JSON written to file successfully.");
        }catch(Exception e)
        {
            System.out.println("Error occured. \n" + e);
            System.exit(1);
        }
    }
    public List<link> read_json()
    {
        ObjectMap obj = new ObjectMap();
        ObjectMapper objectMapper = obj.getObjectMapper();

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

    public void delete_all()
    {

        ObjectMap obj = new ObjectMap();
        ObjectMapper objectMapper = obj.getObjectMapper();
        try {
            objectMapper.writeValue(main_file, new ArrayList<>()); //replace whole file with []
        }catch(Exception e)
        {
            System.out.println("Error occured. \n" + e);
            System.exit(1);
        }
    }
}
