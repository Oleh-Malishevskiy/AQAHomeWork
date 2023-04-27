package AQA.Task6;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table
public class ColorPalette implements Serializable{
    private List<String> colors;
    private Boolean isPrimary;
    private List<Integer> rgb;


}
