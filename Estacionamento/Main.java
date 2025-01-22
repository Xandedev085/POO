package br.ufc.quixada.poo;

import java.time.LocalDateTime;

public class Main {
  public static void main(String[] args) {
    Estacionamento estacionamento = new Estacionamento(2, 3);

    Veiculo carro1 = new Carro("CAR001");
    Veiculo moto1 = new Moto("MOTO001");
    Veiculo bike1 = new Bike("BIKE001");

    // Registrar entradas
    estacionamento.registrarEntrada(carro1);
    estacionamento.registrarEntrada(moto1);
    estacionamento.registrarEntrada(bike1);

    // Listar veículos
    estacionamento.listarVeiculosEstacionados();

    // Pagar tickets
    estacionamento.registrarSaida("CAR001", LocalDateTime.now().plusMinutes(20));
    estacionamento.registrarSaida("MOTO001", LocalDateTime.now().plusHours(2));
    estacionamento.registrarSaida("BIKE001", LocalDateTime.now().plusMinutes(5));

    // Listar veículos novamente
    estacionamento.listarVeiculosEstacionados();
  }
}
