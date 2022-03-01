package arrayListExample;


public class Cat {
    private String name;
    private  int age;

//    protected Cat(final String name, final int age) {
//        System.out.println("constructor args");
//        this.name = name;
//        this.age = age;
//    }
    public Cat(String cat){
        System.out.println("дефолтный конструктор");
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
