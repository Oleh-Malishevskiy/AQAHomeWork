package AQA.Task5;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class XML {
    public static void main(String[] args) throws IOException {

        Person colorPalette = new Person();
        colorPalette.setColors(Arrays.asList("red", "green", "blue"));
        colorPalette.setPrimary(Boolean.TRUE);
        colorPalette.setRgb(Arrays.asList(255,0,0));
        System.out.println(colorPalette);

        XmlMapper xmlMapper = new XmlMapper();
        String stringXML = xmlMapper.writeValueAsString(colorPalette);
        System.out.println(stringXML);

        Person inputXml = xmlMapper.readValue(new File("input.xml"), Person.class);
        System.out.println(inputXml);

        inputXml.getColors().add("White");
        xmlMapper.writeValue(new File("output.xml"),inputXml);
        System.out.println(inputXml);
    }
}
