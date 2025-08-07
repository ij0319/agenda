package com.agenda.agenda.service;

import com.agenda.agenda.model.Contato;

import java.util.List;

public interface ContatoService {
    List<Contato> listarTodos();
    Contato buscarPorId(long id);
    Contato salvar(Contato contato);
    Contato atualizar(Long id, Contato contato);
    void deletar (Long id);
}
