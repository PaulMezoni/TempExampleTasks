package Generics;

public class ParametrizedClass {
    public static void main(String[] args) {
        Info<Object, Object> info = new Info<>(21, 21);
        System.out.println(info);
    }

    static class Info<K, V> {
        private final K key;
        private final V value;

        public Info(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{ { " + value + " } }";
        }
    }
}
