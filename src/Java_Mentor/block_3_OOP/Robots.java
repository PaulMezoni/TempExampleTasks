package Java_Mentor.block_3_OOP;

// 3.3.13
public class Robots {
    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.UP);
        moveRobot(robot, 10, 12);


        System.out.println(robot.getClass()); // class Robot

    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        //Твой код здесь
        if (toX < robot.getX() | toY < robot.getX()) {
            while (Direction.LEFT != robot.getDirection() | Direction.UP != robot.getDirection())
                robot.turnLeft();

        } else if (toX > robot.getX() | toY > robot.getY()) {
            while (Direction.RIGHT != robot.getDirection() | Direction.DOWN != robot.getDirection()) {
                robot.turnRight();
            }
        }
        while (robot.getX() != toX | robot.getY() != toY) {
            robot.stepForward();
        }
//        if (robot.getX() > toX) {
//            while (robot.getDirection() != Direction.LEFT) {
//                robot.turnLeft();
//            }
//        } else if (robot.getX() < toX) {
//            while (robot.getDirection() != Direction.RIGHT) {
//                robot.turnRight();
//            }
//        }
//        while (robot.getX() != toX) {
//            robot.stepForward();
//        }
//
//        if (robot.getY() > toY) {
//            while (robot.getDirection() != Direction.DOWN) {
//                robot.turnLeft();
//            }
//        } else if (robot.getY() < toY) {
//            while (robot.getDirection() != Direction.UP) {
//                robot.turnRight();
//            }
//        }
//        while (robot.getY() != toY) {
//            robot.stepForward();
//        }

        System.out.println("Position X = " + robot.getX() + " Y = " + robot.getY() + ". Direction: " + robot.getDirection());
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            if (dir == Direction.UP) {
                dir = Direction.LEFT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.DOWN;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.UP;
            }
        }

        public void turnRight() {
            if (dir == Direction.UP) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.LEFT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.UP;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.DOWN;
            }
        }

        public void stepForward() {
            if (dir == Direction.UP) {
                y++;
            }
            if (dir == Direction.DOWN) {
                y--;
            }
            if (dir == Direction.LEFT) {
                x--;
            }
            if (dir == Direction.RIGHT) {
                x++;
            }
        }
    }
}