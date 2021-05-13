package water;
import java.util.concurrent.BrokenBarrierException;
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

    public void atomicHydrogen(Runnable atomHydrogen) throws InterruptedException {
        hydrogen.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException eH) {
            eH.printStackTrace();
        }
        atomHydrogen.run();
        hydrogen.release();
    }
    public void atomicOxygen(Runnable atomOxygen) throws InterruptedException {
        oxygen.acquire();
        try {
            barrier.await();
        } catch (Exception eO) {
            eO.printStackTrace();
        }
        atomOxygen.run();
        oxygen.release();
    }
}
