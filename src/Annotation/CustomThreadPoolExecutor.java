package Annotation;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor{

    public CustomThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize, corePoolSize, 0l, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>());
    }
    @Override
    public void execute(Runnable command) {
        if (!command.getClass().isAnnotationPresent(Repeat.class)) {
            super.execute(command);
        } else {
            Repeat annotation = command.getClass().getAnnotation(Repeat.class);
            int counter = annotation.value();
            while (counter-- > 0) {
                super.execute(command);
            }
        }
    }
}

