package pe.edu.cibertec.sw_examen_t1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_examen_t1.model.Animal;

import java.io.File;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class FileService {

    private static final String FILE_PATH = "archivo1.txt";
    private static final String XML_FILE_PATH = "archivo2.xml";
    private static final String JSON_FILE_PATH = "archivo3.json";

    @Async
    public CompletableFuture<String> crearArchivoTxt() throws IOException {
        Animal animal = new Animal();

        try(FileOutputStream fos = new FileOutputStream(FILE_PATH);
            DataOutputStream dos = new DataOutputStream(fos)) {

            dos.writeUTF(animal.getNombre());
            dos.writeInt(animal.getEdad());
            dos.writeUTF(animal.getTipo());

            TimeUnit.SECONDS.sleep(10);
            log.info("TXT: " + animal.toString());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return CompletableFuture.completedFuture("Archivo TXT completado exitosamente");
    }

    @Async
    public CompletableFuture<String> crearArchivoJson() throws Exception {
        Animal animal = new Animal();
        ObjectMapper objectMapper = new ObjectMapper();
        TimeUnit.SECONDS.sleep(5);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(JSON_FILE_PATH), animal);
        log.info("JSON "+ objectMapper.writeValueAsString(animal));

        return CompletableFuture.completedFuture("Archivo JSON completado exitosamente");
    }

    @Async
    public CompletableFuture<String> crearArchivoXML() throws Exception {
        Animal animal = new Animal();
        TimeUnit.SECONDS.sleep(7);
        JAXBContext context = JAXBContext.newInstance(Animal.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(animal, new File(XML_FILE_PATH));
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(animal, stringWriter);
        log.info("XML: " + stringWriter);

        return CompletableFuture.completedFuture("Archivo XML completado exitosamente");
    }


}