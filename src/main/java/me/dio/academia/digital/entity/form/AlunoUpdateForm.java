package me.dio.academia.digital.entity.form;

import java.time.LocalDate;
import java.util.Optional;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoUpdateForm {

  private Optional<String> nome;

  private Optional<String> bairro;

  private Optional<LocalDate> dataDeNascimento;
}
