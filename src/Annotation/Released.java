package Annotation;

@Repeat(5)
public class Released implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello, can you see me?");
    }
    public static void main(String[] strings) {
        CustomThreadPoolExecutor customThreadPoolExecutor =
                new CustomThreadPoolExecutor(1);
        customThreadPoolExecutor.execute(new Released());
        customThreadPoolExecutor.shutdown();
    }
}


