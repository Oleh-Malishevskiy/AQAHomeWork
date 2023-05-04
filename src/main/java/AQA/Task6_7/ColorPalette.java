package AQA.Task6_7;

import javax.persistence.*;

@Entity
@Table(name = "colorPalette")
public class ColorPalette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "color")
    private String color;
    @Column(name = "isPrimary")
    private Boolean isPrimary;
    @Column(name = "rgb")
    private int rgb;

    public void ColorPalette() {}

    public void ColorPalette(String color,Boolean isPrimary, int rgb)
    {
        this.color = color;
        this.isPrimary = isPrimary;
        this.rgb = rgb;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getColor() { return color; }

    public void setColor(String college)
    {
        this.color = college;
    }

    public int getRgb()
    {
        return rgb;
    }

    public void
    setRgb(int rgb)
    {
        this.rgb = rgb;
    }

    public Boolean getIsPrimary()
    {
        return isPrimary;
    }

    public void
    setIsPrimary(Boolean isPrimary)
    {
        this.isPrimary = isPrimary;
    }

    @Override public String toString()
    {
        return "ColorPalette{"
                + "id=" + id + ", color='" + color + '\''
                + ", rgb=" + rgb
                + '}';
    }
}
