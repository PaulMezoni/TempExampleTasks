package Stepic.exmpl.module2;

public class Solution331_Robot {
    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.LEFT);
        moveRobot(robot, 3, -2);
    }

    public static void moveRobot(Robot robot, int toX, int toY) {


        if (toX < robot.getX()) {
            while (Direction.LEFT != robot.getDirection()) {
                robot.turnLeft();
            }
        } else if (toX > robot.getX()) {
            while (Direction.RIGHT != robot.getDirection()) {
                robot.turnRight();
            }
        }
        while (robot.getX() != toX) {
            robot.stepForward();
        }
        if (toY < robot.getY()) {
            while (Direction.DOWN != robot.getDirection()) {
                robot.turnLeft();
            }
        } else if (toY > robot.getY()) {
            while (Direction.UP != robot.getDirection()) {
                robot.turnRight();
            }
        }
        while (robot.getY() != toY) {
            robot.stepForward();
        }
        System.out.println("Position X = " + robot.getX() + " Y = " + robot.getY() + ". Direction: " + robot.getDirection());
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    static class Robot {

        private int x, y;
        private Direction direction;

        public Robot(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public Direction getDirection() {
            // текущее направление взгляда
            return direction;
        }

        public int getX() {
            // текущая координата X
            return x;
        }

        public int getY() {
            // текущая координата Y
            return y;
        }

        public void turnLeft() {
            // повернуться на 90 градусов против часовой стрелки
            switch (direction) {
                case UP -> direction = Direction.LEFT;
                case DOWN -> direction = Direction.RIGHT;
                case LEFT -> direction = Direction.DOWN;
                case RIGHT -> direction = Direction.UP;
            }
        }

        public void turnRight() {
            // повернуться на 90 градусов по часовой стрелке
            switch (direction) {
                case UP -> direction = Direction.RIGHT;
                case DOWN -> direction = Direction.LEFT;
                case LEFT -> direction = Direction.UP;
                case RIGHT -> direction = Direction.DOWN;
            }
        }

        public void stepForward() {
            // шаг в направлении взгляда
            // за один шаг робот изменяет одну свою координату на единицу
            switch (direction) {
                case UP -> y++;
                case DOWN -> y--;
                case LEFT -> x--;
                case RIGHT -> x++;
            }
        }
    }
}
