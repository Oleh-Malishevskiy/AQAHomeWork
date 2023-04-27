package AQA.Task5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class Json {
    public static void main(String[] args) throws IOException {

        ColorPalette colorPalette = new ColorPalette();
        colorPalette.setColors(Arrays.asList("red", "green", "blue"));
        colorPalette.setPrimary(Boolean.TRUE);
        colorPalette.setRgb(Arrays.asList(255,0,0));
        System.out.println(colorPalette);

        ObjectMapper objectMapper = new ObjectMapper();
        String stringJson = objectMapper.writeValueAsString(colorPalette);
        System.out.println(stringJson);

        ColorPalette inputJson = objectMapper.readValue(new File("input.json"),ColorPalette.class);
        System.out.println(inputJson);

        inputJson.getColors().add("Black");
        objectMapper.writeValue(new File("output.json"),inputJson);
        System.out.println(inputJson);
    }
}

