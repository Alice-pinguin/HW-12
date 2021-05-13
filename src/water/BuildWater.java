package water;

public class BuildWater {
    public static void main(String[] args) {
        CreateWater inputSymbols = new CreateWater(7);
        Water waterCyclicBarrier = new Water();
        String finalStr = inputSymbols.finalResult().toString();
        System.out.println("Input  : " + finalStr);
        System.out.print("Output : ");
        Runnable hydrogen = () -> System.out.print("H");
        Runnable oxygen = () -> System.out.print("O");
       for (int i = 0; i < finalStr.length(); i++) {
            char element = finalStr.charAt(i);
           switch (element) {
                case 'O':
                    new Thread(() -> {
                        try {
                            waterCyclicBarrier.atomicOxygen(oxygen);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                    break;
                case 'H':
                    new Thread(() -> {
                        try {
                            waterCyclicBarrier.atomicHydrogen(hydrogen);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                    break;
            }
        }
    }
}





