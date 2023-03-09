package me.dio.academia.digital.entity.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {

  @NotBlank(message = "O campo alunoId não pode ser vazio")
  @Positive(message = "O campo alunoId deve ser um número positivo")
  private Long alunoId;

  @NotBlank(message = "O campo peso não pode ser vazio")
  private double peso;

  @NotBlank(message = "O campo altura não pode ser vazio")
  private double altura;
}
