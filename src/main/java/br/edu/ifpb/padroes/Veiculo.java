package br.edu.ifpb.padroes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Veiculo {
    private String placa;
    private String modelo;
    private String cor;
}
