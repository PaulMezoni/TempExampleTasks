package Java_Mentor.block_7_API;

import java.util.stream.Stream;

public class LambdaApp {

    public static void main(String[] args) {
        MonitoringSystem generalModule = () -> System.out.println("Мониторинг общих показателей стартовал!");
        MonitoringSystem errorModule = () -> System.out.println("Мониторинг отслеживания ошибок стартовал!");
        MonitoringSystem securityModule = () -> System.out.println("Мониторинг безопасности стартовал!");

        MonitoringSystem monitoringSystem = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println(" 123 ");
            }
        };

        Stream.of("AAA", "BBB", "CCC").parallel().forEach(s -> System.out.println("Output forEach :" + s));
        Stream.of("AAA", "BBB", "CCC").parallel().forEachOrdered(s -> System.out.println("Output forEachOrdered:" + s));

//        generalModule.startMonitoring();
//        errorModule.startMonitoring();
//        securityModule.startMonitoring();

        monitoringSystem.startMonitoring();


        Operationable operation;
        operation = Integer::sum;

        int result = operation.calculate(10, 20);
        System.out.println(result); //30

    }

    public interface MonitoringSystem {
        void startMonitoring();
    }

    interface Operationable {
        int calculate(int x, int y);
    }
}

