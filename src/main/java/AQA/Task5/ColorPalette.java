package AQA.Task5;

import java.io.Serializable;
import java.util.List;

public class ColorPalette implements Serializable,Comparable<ColorPalette> {
    private List<String> colors;
    private Boolean isPrimary;
    private List<Integer> rgb;

    public ColorPalette() {
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
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
                "colors=" + colors +
                ", isPrimary=" + isPrimary +
                ", rgb=" + rgb +
                '}';
    }



    @Override
    public int compareTo(ColorPalette o) {
        ColorPalette o1 =(ColorPalette)this;
        ColorPalette o2 =(ColorPalette)o;
        return o1.getRgb().toString().compareTo(o2.getRgb().toString());
    }
}
