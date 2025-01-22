package br.ufc.quixada.poo;

import java.time.LocalDateTime;
import java.time.Duration;

public class Ticket {
  private int id;
  private LocalDateTime horaEntrada;
  private boolean pago;
  private LocalDateTime horaSaida;
  private Veiculo veiculo;
  private double valor;

  public Ticket(Veiculo veiculo) {
    this.veiculo = veiculo;
    this.pago = false;
    this.horaEntrada = LocalDateTime.now();
    this.horaSaida = null;
    this.valor = 0;
  }
  public void setHoraSaida(LocalDateTime horaSaida) {
    this.horaSaida = horaSaida;
  }
  public Veiculo getVeiculo() {
    return this.veiculo;
  }
  public double getValorPago() {
    return this.valor;
  }
  public boolean isPago() {
    return this.pago;
  }
  public LocalDateTime getHoraEntrada() {
    return this.horaEntrada;
  }
}

