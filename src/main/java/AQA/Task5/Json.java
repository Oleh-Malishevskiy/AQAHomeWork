package AQA.Task5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Json {
    public static void main(String[] args) throws IOException {
//        Serialization-Deserialization:
//        a) Make some complex models using your variant.
//                b) Make it serializable.
//                c) Read json from “input.json”
//        d) and deserialize it to POJO.
//                e) Then change a few fields and save it to “output.json”.
//        f) Do the same for xml.
//
//                Stream:
//        a) Generate 10 random object using class from previous class
//        b) Sort it using any two fields using stream.
//        b) Filter it by any two fields custom filter.
//        c) Collect it to List with *main field(s).
//
//        3. Write a maven command for executing one of your tasks with arguments (number of elements).
//        {
//            "isStudent": true,
//                "name": "Mark",
//                "address": {
//            "street": "789 Oak St",
//                    "city": "Los Angeles",
//                    "state": "CA"
//        }
//        }
//<person>
//  <isStudent>true</isStudent>
//  <name>Mark</name>
//  <address>
//    <street>789 Oak St</street>
//    <city>Los Angeles</city>
//    <state>CA</state>
//  </address>
//</person>



                Person person = new Person();
        person.setStudent(true);
        person.setName("Mark");
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("street","789 Oak St");
        map.put("city","Los Angeles");
        map.put("state","CA");
        person.setAddress(map);
        System.out.println(person);

        ObjectMapper objectMapper = new ObjectMapper();
        String stringJson = objectMapper.writeValueAsString(person);
        System.out.println(stringJson);

       Person inputJson = objectMapper.readValue(new File("input.json"), Person.class);
        System.out.println(inputJson);

        inputJson.getAddress().put("country","USA");
        objectMapper.writeValue(new File("output.json"),inputJson);
        System.out.println(inputJson);
    }
}

