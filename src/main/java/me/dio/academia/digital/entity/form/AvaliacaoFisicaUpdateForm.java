package me.dio.academia.digital.entity.form;

import java.util.OptionalDouble;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaUpdateForm {

  private OptionalDouble  peso;

  private OptionalDouble  altura;
}
