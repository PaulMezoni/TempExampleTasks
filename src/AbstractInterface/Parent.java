package AbstractInterface;

public abstract class Parent implements Fly, Run {

    @Override
    public void execute() {
        Fly.super.execute();
        Run.super.execute();
    }

    @Override
    public void current() {
        System.out.println("current");
    }

    @Override
    public void run() {
        System.out.println("Run");
    }

    public static void main(String[] args) {

    }
}
