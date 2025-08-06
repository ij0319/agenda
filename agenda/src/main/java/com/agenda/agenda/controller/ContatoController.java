package com.agenda.agenda.controller;

import com.agenda.agenda.model.Contato;
import com.agenda.agenda.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    // GET todos os contatos
    @GetMapping
    public List<Contato> listarTodos() {
        return contatoRepository.findAll();
    }

    // GET contato por ID
    @GetMapping("/{id}")
    public Optional<Contato> buscarPorId(@PathVariable Long id) {
        return contatoRepository.findById(id);
    }

    // POST novo contato
    @PostMapping
    public Contato criarContato(@RequestBody Contato contato) {
        return contatoRepository.save(contato);
    }

    // PUT atualizar contato existente
    @PutMapping("/{id}")
    public Contato atualizarContato(@PathVariable Long id, @RequestBody Contato contatoAtualizado) {
        return contatoRepository.findById(id).map(contato -> {
            contato.setNome(contatoAtualizado.getNome());
            contato.setEmail(contatoAtualizado.getEmail());
            contato.setNumero(contatoAtualizado.getNumero());
            return contatoRepository.save(contato);
        }).orElseGet(() -> {
            contatoAtualizado.setId(id);
            return contatoRepository.save(contatoAtualizado);
        });
    }

    // DELETE contato por ID
    @DeleteMapping("/{id}")
    public void deletarContato(@PathVariable Long id) {
        contatoRepository.deleteById(id);
    }
}