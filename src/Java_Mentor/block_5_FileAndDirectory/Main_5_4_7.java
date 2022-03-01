package Java_Mentor.block_5_FileAndDirectory;
//5.4.7

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

//5.4.7
public class Main_5_4_7 {
public static void main(String[] args) throws IOException {
    Animal animal1 = new Animal("имя1");
    Animal animal2 = new Animal("имя2");

    serializeAnimalArray(animal1, animal2);

    byte[] data = Files.readAllBytes(Paths.get("/Users/imac/IdeaProjects/My_Education/JavaMentorCore/src/Lesson_5_4_7/animal.bin"));
    Animal[] animals = deserializeAnimalArray(data);

    System.out.println(Arrays.toString(animals));

// итог, без красоты [Lesson_5_4_7.Animal@5034c75a, Lesson_5_4_7.Animal@396a51ab]
}

private static void serializeAnimalArray(Animal animal1, Animal animal2) {
}

static class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
}

//5.4.7
public static Animal[] deserializeAnimalArray(byte[] data) {
    //Твой код здесь
    int count;
    Animal[] animals = null;

    try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
         ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {

        count = objectInputStream.readInt();
        animals = new Animal[count];

        for (int i = 0; i < count; i++) {
            Animal a = (Animal) objectInputStream.readObject();
            animals[i] = a;
        }
    } catch (RuntimeException | ClassNotFoundException | IOException e) {
        throw new IllegalArgumentException(e);
    }
    return animals;
}
}
