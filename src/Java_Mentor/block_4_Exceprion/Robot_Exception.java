package Java_Mentor.block_4_Exceprion;
// 4.2.8 and 4.2.9

public class Robot_Exception {
    //interface
    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);

        @Override
        void close();
    }

    // manager
    public interface RobotConnectionManager {
        RobotConnection getConnection();
    }

    //соединение
    public static class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);

        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    //метод
// 4.2.8
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean success = false;
        RobotConnection rc = null;
        for (int i = 0; !success && (i < 3); ++i) {
            try {
                rc = robotConnectionManager.getConnection();
                rc.moveRobotTo(toX, toY);
                success = true;
            } catch (RobotConnectionException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rc != null) {
                        rc.close();
                    }
                } catch (RobotConnectionException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!success) {
            throw new RobotConnectionException("3 попытки не удались");
        }
    }
// 4.2.9
//public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
//    boolean success = false;
//    for (int i = 0; !success && (i < 3); ++i) {
//        try (RobotConnection rc = robotConnectionManager.getConnection()) {
//            rc.moveRobotTo(toX, toY);
//            success = true;
//        } catch (RobotConnectionException e) {
//            e.printStackTrace();
//        }
//    }
//    if (!success) {
//        throw new RobotConnectionException("3 попытки не удались");
//    }
//}
}
