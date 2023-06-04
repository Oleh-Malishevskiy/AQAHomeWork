package AQA.Task5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream {
    public static List<Person> main(String[] args) {
        Integer count = 10;
        if(args.length>0){
            try {
                count = Integer.parseInt(args[0]);
            }catch (Exception e){
               System.out.println(args[0]);
            }

        }

        List<Person> personList=generatePersons(count);
        System.out.println(personList);

        Collections.sort(personList);
        System.out.println(personList);

        System.out.println(personList.stream().sorted(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }).collect(Collectors.toList()));

        return personList;
    }

    private static List<Person> generatePersons(int counts) {
        Random random= new Random();
        List<Person> personArrayList = new ArrayList<>();
        IntStream.range(1,counts).forEach(n->{
            Person person = new Person();
            person.setStudent(random.nextBoolean());
            person.setName(UUID.randomUUID().toString());
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("street",UUID.randomUUID().toString());
            map.put("city",UUID.randomUUID().toString());
            map.put("state",UUID.randomUUID().toString());
            person.setAddress(map);
            personArrayList.add(person);
        });
        return personArrayList;
    }

}
