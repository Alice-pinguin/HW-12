package water;

import lombok.SneakyThrows;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Water {
    private final CyclicBarrier barrier;
    private final Semaphore oxygen;
    private final Semaphore hydrogen;

    public Water(){
        barrier = new CyclicBarrier(3);
        oxygen = new Semaphore(1);
        hydrogen = new Semaphore(2);
    }
    @SneakyThrows
    public void atomicHydrogen(Runnable atomHydrogen) {
        hydrogen.acquire();
        barrier.await();
        atomHydrogen.run();
        hydrogen.release();
    }
    @SneakyThrows
    public void atomicOxygen(Runnable atomOxygen){
        oxygen.acquire();
        barrier.await();
        atomOxygen.run();
        oxygen.release();
    }
}
