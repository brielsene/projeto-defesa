package br.com.dfense.rhservice.service;

import br.com.dfense.rhservice.domain.Pessoa;
import br.com.dfense.rhservice.domain.dto.DtoRequestPessoa;
import br.com.dfense.rhservice.domain.dto.DtoResponsePessoa;
import br.com.dfense.rhservice.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pessoa não encontrada com o ID: " + id));
            DtoResponsePessoa pessoaDto = new DtoResponsePessoa(pessoa);
            return pessoaDto;



}

    public void atualizaPessoa(Long id, DtoRequestPessoa dados){


        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Pessoa com este ID não existe"));
        if (!(dados.nome().isEmpty() || dados.nome().isBlank())){
            pessoa.setNome(dados.nome());

        }
        if(!(dados.email().isBlank() || dados.email().isEmpty())){
            pessoa.setEmail(dados.email());
        }
        if(!(dados.dataNascimento().isBlank() || dados.dataNascimento().isEmpty())){
            pessoa.setDataNascimento(dados.dataNascimento());
        }
        if(!(dados.cpf().isBlank() || dados.cpf().isEmpty())){
            pessoa.setCpf(dados.cpf());
        }

        pessoaRepository.save(pessoa);

    }


    public void deletarPessoa(Long id){
        Pessoa pessoa = pessoaRepository.findById(id)
                        .orElseThrow(()-> new NoSuchElementException("Não existe pessoa com o id: "+id));
        pessoaRepository.deleteById(id);
    }


}
