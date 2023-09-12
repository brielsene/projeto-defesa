package br.com.dfense.rhservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pessoa")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    @Column(name = "data_nascimento")
    private String dataNascimento;
    private String cpf;
}
