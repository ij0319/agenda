package com.agenda.agenda.controller;

import com.agenda.agenda.model.Contato;
import com.agenda.agenda.service.ContatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    @Autowired
    private ContatoController(ContatoService contatoService){
        this.contatoService = contatoService;
    }

    // GET todos os contatos
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> listarTodos() {
        return contatoService.listarTodos();
    }

    // GET contato por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contato buscarPorId(@PathVariable Long id) {
        return contatoService.buscarPorId(id);
    }

    // POST novo contato
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato criarContato(@Valid @RequestBody Contato contato) {
        return contatoService.salvar(contato);
    }

    // PUT atualizar contato existente
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contato atualizarContato(@PathVariable Long id,@Valid @RequestBody Contato contatoAtualizado) {
        return contatoService.atualizar(id, contatoAtualizado);
    }

    // DELETE contato por ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarContato(@PathVariable Long id) {
        contatoService.deletar(id);
    }
}