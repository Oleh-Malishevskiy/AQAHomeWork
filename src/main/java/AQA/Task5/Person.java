package AQA.Task5;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable,Comparable<Person> {
    private List<String> friends;
    private Boolean isWorking;
    private List<Integer> rgb;

    public Person() {
    }

    public List<String> getColors() {
        return friends;
    }

    public void setColors(List<String> colors) {
        this.friends = colors;
    }

    public Boolean getPrimary() {
        return isWorking;
    }

    public void setPrimary(Boolean primary) {
        isWorking = primary;
    }

    public List<Integer> getRgb() {
        return rgb;
    }

    public void setRgb(List<Integer> rgb) {
        this.rgb = rgb;
    }

    @Override
    public String toString() {
        return "ColorPalette{" +
                "friends=" + friends +
                ", isWorking=" + isWorking +
                ", rgb=" + rgb +
                '}';
    }



    @Override
    public int compareTo(Person o) {
        Person o1 =(Person)this;
        Person o2 =(Person)o;
        return o1.getRgb().toString().compareTo(o2.getRgb().toString());
    }
}
