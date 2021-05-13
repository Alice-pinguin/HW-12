package water;

import java.util.Random;
import java.util.StringJoiner;

public class CreateWater {
    private int elements;
    private int numberOxygen = 0;
    private int numberHydrogen = 0;
    private Random symbol = new Random();
    private StringJoiner result = new StringJoiner("");

    public CreateWater(int elements) {
            this.elements = elements;
        }
     public StringJoiner finalResult() {
        String inputElements = "OH";
        int i = 0;
        while (i <= elements){
            i++;
            char element = inputElements.charAt(symbol.nextInt(2));
            switch (element) {
                case 'O':
                    if (numberOxygen < (elements / 3)) {
                        result.add(Character.toString(element));
                        numberOxygen++;
                    }
                        break;
                    case 'H':
                        if (numberHydrogen < (elements / 3 * 2)) {
                            result.add(Character.toString(element));
                            numberHydrogen++;
                        }
                        break;
                }
            }
            return result;
        }
    }

