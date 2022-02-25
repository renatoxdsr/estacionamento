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

        BigDecimal valorHoras = calcularHoras(periodoHoras);
        BigDecimal valorDiarias = calcularDiaria(periodoHoras, periodoDias);
        BigDecimal valorMensalidade = calcularMensalidade(periodoDias);
        BigDecimal total = valorHoras.add(valorDiarias).add(valorMensalidade);

        return total;
    }

    public BigDecimal calcularHoras(long periodoHoras){
        BigDecimal valor = new BigDecimal(0);
        if (periodoHoras < 12) {
             valor = VALOR_HORA.multiply(new BigDecimal(periodoHoras));
        }
        return valor;
    }

    public BigDecimal calcularDiaria(long periodoHoras, long periodoDias){
        BigDecimal valor = new BigDecimal(0);
        if (periodoHoras > 12 && periodoDias < 15) {
           valor = VALOR_DIARIA.multiply(new BigDecimal(periodoDias));
        }
        return valor;
    }

    public BigDecimal calcularMensalidade(long periodoDias){
        BigDecimal valor = new BigDecimal(0);
        if (periodoDias > 15) {
            valor = VALOR_MENSALIDADE;
        }
        return valor;
    }

}
