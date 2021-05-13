package water;

public class BuildWater {
    public static void main(String[] args) {
        CreateWater inputSymbols = new CreateWater(9);
        Water waterCyclicBarrier = new Water();
        String finalStr = inputSymbols.finalResult().toString();
        System.out.println("Input symbol : " + finalStr);
        System.out.print("Output symbol : ");
        Runnable hydrogen = () -> System.out.print("H");
        Runnable oxygen = () -> System.out.print("O");
       for (int i = 0; i < finalStr.length(); i++) {
            char element = finalStr.charAt(i);
           switch (element) {
                case 'O':
                    new Thread(() -> waterCyclicBarrier.atomicOxygen(oxygen)).start();
                    break;
                case 'H':
                    new Thread(() -> waterCyclicBarrier.atomicHydrogen(hydrogen)).start();
                    break;
            }
        }
    }
}





