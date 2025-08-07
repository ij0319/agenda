package com.agenda.agenda.service;

import com.agenda.agenda.exception.ContatoNaoEncontradoException;
import com.agenda.agenda.model.Contato;
import com.agenda.agenda.repository.ContatoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContatoServiceImpl implements ContatoService{

    private ContatoRepository contatoRepo;

    public ContatoServiceImpl(ContatoRepository contatoRepo) {
        this.contatoRepo = contatoRepo;
    }

    @Override
    public List<Contato> listarTodos() {

        List <Contato> listarContatos = contatoRepo.findAll();
        return listarContatos;
    }

    @Override
    public Contato buscarPorId(long id) {
        return contatoRepo.findById(id)
                .orElseThrow(() -> new ContatoNaoEncontradoException("Contato ID: " + id + " não encontrado."));
    }

    @Override
    public Contato salvar(Contato contato) {

        return contatoRepo.save(contato);
    }

    @Transactional
    @Override
    public Contato atualizar(Long id, Contato contato) {
        Contato existente = buscarPorId(id);
        existente.setNome(contato.getNome());
        existente.setEmail(contato.getEmail());
        existente.setNumero(contato.getNumero());

        return contatoRepo.save(existente);
    }

    @Override
    public void deletar(Long id) {
        buscarPorId(id);

        contatoRepo.deleteById(id);
    }
}
