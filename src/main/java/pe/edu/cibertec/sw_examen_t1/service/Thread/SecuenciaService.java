package pe.edu.cibertec.sw_examen_t1.service.Thread;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_examen_t1.model.Animal;
import pe.edu.cibertec.sw_examen_t1.service.FileService;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class SecuenciaService {

    private final FileService fileService;

    @Async
    public CompletableFuture<String> creandoArchivos() throws Exception {
        CompletableFuture<String> tarea1 = fileService.crearArchivoTxt();
        CompletableFuture<String> tarea2 = fileService.crearArchivoJson();
        CompletableFuture<String> tarea3 = fileService.crearArchivoXML();

        return CompletableFuture.allOf(tarea1, tarea2, tarea3)
                .thenApply(result ->{
                    try{
                        String valorTarea1 = tarea1.join();
                        String valorTarea2 = tarea2.join();
                        String valorTarea3 = tarea3.join();
                        return "Resultado de tareas: "+
                                valorTarea1+"-"+
                                valorTarea2+"-"+
                                valorTarea3;

                    }catch (Exception ex){
                        return "Error al combinar los datos "+ex.getMessage();
                    }
                })
                .exceptionally(ex-> "Error al ejecutar tareas " + ex.getMessage());
    }

}
