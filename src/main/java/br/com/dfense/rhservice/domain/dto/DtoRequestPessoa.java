package br.com.dfense.rhservice.domain.dto;

import br.com.dfense.rhservice.domain.Cargo;
import jakarta.validation.constraints.*;

public record DtoRequestPessoa(

        /*
        @NotBlank
        @NotNull
        String nome,
        @NotBlank
        String email,
        @Size(max = 10, min = 10)
        String dataNascimento,
        @Size(max = 11, min = 11)
        String cpf) {
         */
        @NotBlank
        @NotNull
        String nome,
        @NotBlank
        String email,
        @Size(max = 10, min = 10)
        String dataNascimento,

        @Size(max = 11, min = 11)
        String cpf,


        Cargo cargo
        ) {
}
