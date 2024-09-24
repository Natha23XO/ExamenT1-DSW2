package pe.edu.cibertec.sw_examen_t1.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Random;

@XmlRootElement(name = "animal")
public class Animal {
    private String nombre;
    private int edad;
    private String tipo;

    public Animal() {
        Random random = new Random();
        this.nombre = generarNombreAleatorio();
        this.edad = random.nextInt(10) + 1;
        this.tipo = generarTipoAleatorio();
    }

    public String generarNombreAleatorio() {
        String[] nombres = {"Maximo", "Belita", "Carlita", "Natha", "Giovanna", "Alexander"};
        return nombres[new Random().nextInt(nombres.length)];
    }

    public String generarTipoAleatorio() {
        String[] tipos = {"Perro", "Gato", "Pollito", "Vaca", "Conejo", "Rata"};
        return tipos[new Random().nextInt(tipos.length)];
    }

    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "edad")
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @XmlElement(name = "tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}