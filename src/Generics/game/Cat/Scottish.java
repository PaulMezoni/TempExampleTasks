package Generics.game.Cat;

import java.util.Objects;

public class Scottish extends Cat {
    private String owner;

    public Scottish(int age, String name, String owner) {
        super(age, name);
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scottish)) return false;
        if (!super.equals(o)) return false;
        Scottish scottish = (Scottish) o;
        return Objects.equals(owner, scottish.owner);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }
}
