package pe.edu.cibertec.sw_examen_t1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Random;

@XmlRootElement(name = "animal")
public class Animal {
    private String name;
    private int age;
    private String type;

    public Animal() {
        Random random = new Random();
        this.name = generateRandomName();
        this.age = random.nextInt(10) + 1;
        this.type = generateRandomType();
    }

    private String generateRandomName() {
        String[] names = {"Max", "Bella", "Charlie", "Luna", "Rocky", "Lucy"};
        return names[new Random().nextInt(names.length)];
    }

    private String generateRandomType() {
        String[] types = {"Dog", "Cat", "Bird", "Fish", "Hamster", "Rabbit"};
        return types[new Random().nextInt(types.length)];
    }

    @JsonProperty("name")
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("age")
    @XmlElement(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @JsonProperty("type")
    @XmlElement(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                '}';
    }
}