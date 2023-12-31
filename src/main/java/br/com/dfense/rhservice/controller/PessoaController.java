package br.com.dfense.rhservice.controller;

import br.com.dfense.rhservice.domain.dto.DtoRequestPessoa;
import br.com.dfense.rhservice.domain.dto.DtoResponsePessoa;
import br.com.dfense.rhservice.service.PessoaService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<List<DtoResponsePessoa>>getAllPessoas(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoResponsePessoa>getUsuarioById(@PathVariable("id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getPessoaById(id));
    }


    @PostMapping
    public ResponseEntity criarUsuario(@RequestBody @Valid DtoRequestPessoa dados){
        service.cadastrarPessoa(dados);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarUsuario(@PathVariable("id")Long id, @RequestBody DtoRequestPessoa dados){
        service.atualizaPessoa(id, dados);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarUsuario(@PathVariable("id")Long id){
        service.deletarPessoa(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
