package pe.edu.cibertec.sw_examen_t1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_examen_t1.model.Animal;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
    @Service
    public class FileService {

    private static final String FILE_PATH = "archivo1.txt";
    private static final String XML_FILE_PATH = "archivo2.xml";
    private static final String JSON_FILE_PATH = "archivo3.json";


    public void crearArchivoTxt() throws IOException {

    }

    public void crearArchivoJson(Animal animal) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        TimeUnit.SECONDS.sleep(5);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(JSON_FILE_PATH), animal);
        log.info("JSON "+ objectMapper.writeValueAsString(animal));

    }
    public void crearArchivoXML() throws Exception {

    }

}