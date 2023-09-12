package br.com.dfense.rhservice.domain.dto;

import br.com.dfense.rhservice.domain.Pessoa;

public record DtoResponsePessoa (
        Long id,
        String nome,
        String email,
        String dataNascimento,
        String cpf

){
    public DtoResponsePessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getEmail(), pessoa.getDataNascimento(), pessoa.getCpf());
    }

}
