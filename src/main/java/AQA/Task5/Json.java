package AQA.Task5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Json {
    public static void main(String[] args) throws IOException {
        // Я тільки трохи наплутав і зробив 11 варіант замість мого 10 в 5.6.7 я вже міняти не буду на діюсь ви зарахуєте
       // General task for all:
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

//        V11
//        {
//            "colors": ["red", "green", "blue"],
//            "isPrimary": true,
//                "rgb": {
//            "r": 255,
//                    "g": 0,
//                    "b": 0
//        }
//        }
//<colorPalette>
//  <colors>
//    <color>red</color>
//    <color>green</color>
//    <color>blue</color>
//  </colors>
//  <isPrimary>true</isPrimary>
//  <rgb>
//    <r>255</r>
//    <g>0</g>
//    <b>0</b>
//  </rgb>
//</colorPalette>


                Person colorPalette = new Person();
        colorPalette.setColors(Arrays.asList("red", "green", "blue"));
        colorPalette.setPrimary(Boolean.TRUE);
        colorPalette.setRgb(Arrays.asList(255,0,0));
        System.out.println(colorPalette);

        ObjectMapper objectMapper = new ObjectMapper();
        String stringJson = objectMapper.writeValueAsString(colorPalette);
        System.out.println(stringJson);

        Person inputJson = objectMapper.readValue(new File("input.json"), Person.class);
        System.out.println(inputJson);

        inputJson.getColors().add("Black");
        objectMapper.writeValue(new File("output.json"),inputJson);
        System.out.println(inputJson);
    }
}

