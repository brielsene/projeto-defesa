package br.com.dfense.rhservice.service;

import br.com.dfense.rhservice.domain.Pessoa;
import br.com.dfense.rhservice.domain.dto.DtoRequestPessoa;
import br.com.dfense.rhservice.domain.dto.DtoResponsePessoa;
import br.com.dfense.rhservice.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public void cadastrarPessoa(DtoRequestPessoa dados){
        Pessoa pessoa = new Pessoa(null, dados.nome(), dados.email(), dados.dataNascimento(), dados.cpf());
        pessoaRepository.save(pessoa);

    }

    public List<DtoResponsePessoa>getAllPessoas(){
        return pessoaRepository.findAll().stream().map(DtoResponsePessoa::new).toList();
    }

    public DtoResponsePessoa getPessoaById(Long id){
        Optional<Pessoa> byId = pessoaRepository.findById(id);
        if (byId.isPresent()){
            DtoResponsePessoa pessoa = new DtoResponsePessoa(byId.get());
            return pessoa;
        }else{
            throw new RuntimeException("Pessoa com id: "+id+", inexistente");
        }


}}
