package com.agenda.agenda.controller;

import com.agenda.agenda.model.Contato;
import com.agenda.agenda.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Contato> listarTodos() {
        return contatoService.listarTodos();
    }

    // GET contato por ID
    @GetMapping("/{id}")
    public Contato buscarPorId(@PathVariable Long id) {
        return contatoService.buscarPorId(id);
    }

    // POST novo contato
    @PostMapping
    public Contato criarContato(@RequestBody Contato contato) {
        return contatoService.salvar(contato);
    }

    // PUT atualizar contato existente
    @PutMapping("/{id}")
    public Contato atualizarContato(@PathVariable Long id, @RequestBody Contato contatoAtualizado) {
        return contatoService.atualizar(id, contatoAtualizado);
    }

    // DELETE contato por ID
    @DeleteMapping("/{id}")
    public void deletarContato(@PathVariable Long id) {
        contatoService.deletar(id);
    }
}