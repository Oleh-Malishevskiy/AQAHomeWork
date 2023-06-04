package AQA.Task5;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class XML {
    public static void main(String[] args) throws IOException {

        Person person = new Person();
        person.setStudent(true);
        person.setName("Mark");
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("street","789 Oak St");
        map.put("city","Los Angeles");
        map.put("state","CA");
        person.setAddress(map);
        System.out.println(person);

        XmlMapper xmlMapper = new XmlMapper();
        String stringXML = xmlMapper.writeValueAsString(person);
        System.out.println(stringXML);

        Person inputXml = xmlMapper.readValue(new File("input.xml"), Person.class);
        System.out.println(inputXml);

        inputXml.getAddress().put("country","USA");
        xmlMapper.writeValue(new File("output.xml"),inputXml);
        System.out.println(inputXml);
    }
}
