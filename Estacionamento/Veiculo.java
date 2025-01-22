package br.ufc.quixada.poo;

public class Veiculo {
  private String identificador;

  public Veiculo(String identificador) {
    if (identificador == null || identificador.trim().isEmpty()){
      throw new IllegalArgumentException("Identificador vazio");
    }
    this.identificador = identificador;
  }
  public String getIdentificador() {
    return identificador;
  }
}
