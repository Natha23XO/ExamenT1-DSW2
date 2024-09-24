package pe.edu.cibertec.sw_examen_t1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.sw_examen_t1.model.Animal;
import pe.edu.cibertec.sw_examen_t1.service.Thread.SecuenciaService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
public class ArchivosController {

    private final SecuenciaService secuenciaService;

    @GetMapping("/generar")
    public String generarArchivos() throws Exception {
        CompletableFuture<String> resultado = secuenciaService.creandoArchivos();
        return resultado.get();
    }

}
