package pe.edu.cibertec.sw_examen_t1.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_examen_t1.model.Animal;


import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

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

            TimeUnit.SECONDS.sleep(10);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearArchivoJson() throws Exception {


    }
    public void crearArchivoXML() throws Exception {
        TimeUnit.SECONDS.sleep(7);
        Animal animal = new Animal();
        JAXBContext context = JAXBContext.newInstance(Animal.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(animal, new File(XML_FILE_PATH));
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(animal, stringWriter);
        log.info("XML: " + stringWriter);
    }
}