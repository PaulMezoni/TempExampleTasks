package AbstractInterface;

public class SuperMan extends Parent {
    @Override
    public void execute() {
        super.execute();
//        System.out.println("Superman");
    }

    @Override
    public void current() {
        super.current();
    }

    @Override
    public void run() {
        super.run();
    }

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        superMan.execute();
        superMan.current();
        superMan.run();
    }
}
