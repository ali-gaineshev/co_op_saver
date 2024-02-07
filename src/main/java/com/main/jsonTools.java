package com.main;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
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

    public <T>T performJsonOperation(JsonOperation<T> op)
    {
        ObjectMap obj = new ObjectMap(); //object mapper that performs actions
        ObjectMapper objectMapper = obj.getObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); //pretty writer
        try {
            return op.perform(objectMapper);
        }catch(Exception e)
        {
            System.out.println("Error occured. \n" + e);
            System.exit(1);
        }
        return null;
    }

    public void write_json(List<link> links)
    {
        performJsonOperation(objectMapper -> {
            objectMapper.writeValue(main_file,links);
            System.out.println("JSON written to file successfully.");
            return null;
        });
    }

    public List<link> read_json()
    {
        List<link> links = performJsonOperation(objectMapper ->
                    objectMapper.readValue(main_file, new TypeReference<>() {})
        );


        if(links == null)
        {
            return new ArrayList<>();
        }
        return links;

    }

    public void delete_all()
    {
        performJsonOperation(objectMapper -> {
            objectMapper.writeValue(main_file, new ArrayList<>()); //replace whole file with []
            return null;
        });

    }
}
