package br.ufc.quixada.poo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Estacionamento {
  int vagasMotoBike;
  int vagasCarro;
  private ArrayList<String> listaVagas;
  private Map<String, Ticket> tickets;

  public Estacionamento(int vagasCarro, int vagasMotoBike) {
    this.vagasCarro = vagasCarro;
    this.vagasMotoBike = vagasMotoBike;
    this.listaVagas = new ArrayList<>();
    this.tickets = new HashMap<>();
  }

  public boolean registrarEntrada(Veiculo veiculo) {
    if (veiculo == null || veiculo.getIdentificador() == null || veiculo.getIdentificador().isEmpty()) {
      return false;
    }

    for (int i = 0; i < listaVagas.size(); i++) {
      if (listaVagas.get(i) == null) {
        if(veiculo.getIdentificador() != ""){
          Ticket ticket = new Ticket(veiculo);
          tickets.put(veiculo.getIdentificador(),ticket);
          listaVagas.set(i,veiculo.getIdentificador());
          return true;
        }
      }
    }
    return false;
  }

  public boolean registrarSaida(String identificador, LocalDateTime horaDeSaida) {
    if (tickets.containsKey(identificador)) {
      Ticket ticket= tickets.get(identificador);
      ticket.setHoraSaida(horaDeSaida);
      listaVagas.remove(identificador);
      return true;
    }
    return false;
  }
  public Ticket getTicketBy(String identificador) {
    return tickets.get(identificador);
  }
  public Veiculo[] listarVeiculosEstacionados() {
    ArrayList<Veiculo> veiculosEstacionados = new ArrayList<>();

    for (String identificador : listaVagas) {
      if (identificador != null && tickets.containsKey(identificador)) {
        Ticket ticket = tickets.get(identificador);
        if (ticket != null) {
          veiculosEstacionados.add(ticket.getVeiculo());
        }
      }
    }
    return veiculosEstacionados;
  }

  public int vagasDisponiveisPara(TipoVaga tipo) {
    int vagasDisponiveis = 0;
    for (int i = 0; i < listaVagas.size(); i++) {
      if (listaVagas.get(i) == null) {
        vagasDisponiveis++;
      }
    }
    if (tipo == TipoVaga.CARRO) {
      if (vagasCarro <= vagasDisponiveis) {
        return vagasDisponiveis - vagasMotoBike;
      }
    }
    return vagasDisponiveis - vagasCarro;
  }
}

