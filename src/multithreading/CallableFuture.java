package multithreading;

import java.util.concurrent.*;

public class CallableFuture {
    static long factorialResult = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Call call = new Call(6);
        Future<Long> future = executorService.submit(call);

        try {
            System.out.println(future.isDone());
            factorialResult = future.get();
            System.out.println(future.isDone());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        System.out.println(factorialResult + " RESULT");
    }

    static class Call implements Callable<Long> {
        private final long f;

        public Call(long f) {
            this.f = f;
        }

        @Override
        public Long call() throws Exception {
            if (f <= 0) {
                throw new Exception(" неверное число");
            }
            long result = 1;
            for (int i = 1; i <= f; i++) {
                result *= i;
                System.out.println(result + " = вывод результата каждой итерации");
                Thread.sleep(1000);
            }

            return result;
        }
    }
}
