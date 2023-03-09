package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

  @NotBlank(message = "Nome não pode ser vazio")
  @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres")
  private String nome;

  @NotBlank(message = "CPF não pode ser vazio") 
  @CPF(message = "CPF inválido")
  private String cpf;

  @NotBlank(message = "Bairro não pode ser vazio")
  private String bairro;

  @NotNull(message = "Data de nascimento não pode ser vazia")
  @Past(message = "Data invalida")
  private LocalDate dataDeNascimento;
}
