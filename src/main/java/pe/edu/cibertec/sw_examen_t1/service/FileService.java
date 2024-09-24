package pe.edu.cibertec.sw_examen_t1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_examen_t1.model.Animal;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@Service
public class FileService {

    private static final String FILE_PATH = "archivo1.txt";
    private static final String XML_FILE_PATH = "archivo2.xml";
    private static final String JSON_FILE_PATH = "archivo3.json";


    public void crearArchivoTxt() throws IOException {
        Animal animal = new Animal();

        try(FileOutputStream fos = new FileOutputStream(FILE_PATH);
            DataOutputStream dos = new DataOutputStream(fos)) {

            dos.writeUTF(animal.getNombre());
            dos.writeInt(animal.getEdad());
            dos.writeUTF(animal.getTipo());

        }catch (IOException e){
            log.error(e.getMessage());
        }
    }

    public void crearArchivoJson() throws Exception {


    }
    public void crearArchivoXML() throws Exception {

    }

}