package stream.prac3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExample {
    public static void main(String[] args) {
        int n = 10; // Вычисление факториала для числа 10

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FactorialTask factorialTask = new FactorialTask(n);
        forkJoinPool.invoke(factorialTask);

        long result = forkJoinPool.invoke(factorialTask);

        System.out.println("Факториал " + n + "! = " + result);
    }
}

class FactorialTask extends RecursiveTask<Long> {
    int n;

    public FactorialTask(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {


        if (this.n <= 1) {
            return 1L;
        } else {
            FactorialTask myFork = new FactorialTask(n - 1);
            myFork.fork();
            return myFork.join() * n;
        }
    }
}
