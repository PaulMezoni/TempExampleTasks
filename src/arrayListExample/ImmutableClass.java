package arrayListExample;

public final class ImmutableClass {
    private final String name;
    private final Integer id;

    public ImmutableClass(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
