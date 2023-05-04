package AQA.Task6_7;

import javax.persistence.*;

@Entity
@Table(name = "autos")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "model")
    private String model;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "colorPalette")
    private ColorPalette colorPalette;
    public Auto() {
    }

    public Auto(String model) {
        this.model = model;

    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public User getUser() {
        return user;
    }
    public ColorPalette getColorPalette()
    {
        return colorPalette;
    }

    public void
    setColorPalette(ColorPalette colorPalette)
    {
        this.colorPalette = colorPalette;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return " " + model;
    }
}