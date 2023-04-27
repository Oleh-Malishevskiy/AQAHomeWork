package AQA.Task5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream {
    public static void main(String[] args) {
        Integer n = 10;
        if(args.length>0){
            try {
                n = Integer.parseInt(args[0]);
            }catch (Exception e){
                System.out.println(args[0]);
            }

        }

        List<ColorPalette> colorPalettes=generateColorPalettes(n);
        System.out.println(colorPalettes);

        Collections.sort(colorPalettes);
        System.out.println(colorPalettes);

        System.out.println(colorPalettes.stream().sorted(new Comparator<ColorPalette>() {
            @Override
            public int compare(ColorPalette o1, ColorPalette o2) {
                return o1.getRgb().toString().compareTo(o2.getRgb().toString());
            }
        }).collect(Collectors.toList()));

    }

    private static List<ColorPalette> generateColorPalettes(int i) {
        Random random= new Random();
        List<ColorPalette> colorPalettesList = new ArrayList<>();
        IntStream.range(1,i).forEach(n->{
            ColorPalette colorPalette = new ColorPalette();
            colorPalette.setPrimary(random.nextBoolean());
            colorPalette.setRgb(Collections.singletonList(random.nextInt(100)));
            colorPalette.setColors(Collections.singletonList("color"+random.nextInt(100)));
            colorPalettesList.add(colorPalette);
        });
        return colorPalettesList;
    }
}