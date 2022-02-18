package br.edu.ifpb.padroes;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
public class Estacionamento {

    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Veiculo veiculo;

    public static BigDecimal VALOR_HORA = new BigDecimal("2.00");
    public static BigDecimal VALOR_DIARIA = new BigDecimal("26.00");
    public static BigDecimal VALOR_MENSALIDADE = new BigDecimal("300.00");

    public BigDecimal obterTotalAPagar() {
        assert(entrada != null && saida != null && veiculo != null);
        long periodoHoras = Duration.between(entrada, saida).toHours();
        long periodoDias = Duration.between(entrada, saida).toDays();

        BigDecimal valor = new BigDecimal(0);
        if (periodoHoras < 12) {
            valor = VALOR_HORA.multiply(new BigDecimal(periodoHoras));
        } else if (periodoHoras > 12 && periodoDias < 15) {
            valor = VALOR_DIARIA.multiply(new BigDecimal(periodoDias));
        } else if (periodoDias > 15) {
            valor = VALOR_MENSALIDADE;
        }

        return valor;
    }

}
