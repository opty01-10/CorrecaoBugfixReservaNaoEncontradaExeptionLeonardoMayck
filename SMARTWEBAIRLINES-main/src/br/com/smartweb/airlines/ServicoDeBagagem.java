package br.com.smartweb.airlines;

import java.util.Objects;

public class ServicoDeBagagem {

    private ServicoDeReserva servicoDeReserva;

    public ServicoDeBagagem(ServicoDeReserva servicoDeReserva) {
        Objects.requireNonNull(servicoDeReserva);
        this.servicoDeReserva = servicoDeReserva;
    }

    public void contratar(String codigoReserva, int quantidadeBagagens) {
        if (quantidadeBagagens <= 0) {
            throw new IllegalArgumentException("Quantidade de bagagens inválida");
        }

        Reserva reserva = servicoDeReserva.buscar(codigoReserva)
            .orElseThrow(() -> new ReservaNaoEncontradaException(
                String.format("Reserva com código %s não encontrada", codigoReserva)
            ));
        
        reserva.adicionarBagagens(quantidadeBagagens);
    }
   }  
