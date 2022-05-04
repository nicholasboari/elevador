public class Elevador {
  private int andares;
  private int capacidadeElevador;
  private int andarAtual = 0;
  private int pessoasElevador;

  public int getAndares() {
    return andares;
  }

  public void setAndares(int andares) {
    this.andares = andares;
  }

  public int getCapacidadeElevador() {
    return capacidadeElevador;
  }

  public void setCapacidadeElevador(int capacidadeElevador) {
    this.capacidadeElevador = capacidadeElevador;
  }

  public int getAndarAtual() {
    return andarAtual;
  }

  public void setAndarAtual(int andarAtual) {
    this.andarAtual = andarAtual;
  }

  public int getPessoasElevador() {
    return pessoasElevador;
  }

  public void setPessoasElevador(int pessoasElevador) {
    this.pessoasElevador = pessoasElevador;
  }

  public Elevador(int andares, int capacidadeElevador) {
    this.andares = andares;
    this.capacidadeElevador = capacidadeElevador;
  }

  public boolean entra(int pessoasEntrar) {
    if (pessoasElevador + pessoasEntrar <= capacidadeElevador && pessoasEntrar > 0) {
      pessoasElevador += pessoasEntrar;
      return true;
    } else {
      return false;
    }
  }

  public boolean sair(int pessoasSair) {
    if (pessoasSair <= pessoasElevador) {
      pessoasElevador -= pessoasSair;
      return true;
    } else {
      return false;
    }
  }

  public boolean subir(int subirAndar) {
    if (subirAndar > 0 && subirAndar <= andares && subirAndar <= (andares - andarAtual)) {
      andarAtual += subirAndar;
      return true;
    } else {
      return false;
    }
  }

  public boolean descer(int descerAndar) {
    if (descerAndar <= andarAtual && descerAndar > 0) {
      andarAtual = andarAtual - descerAndar;
      return true;
    } else {
      return false;
    }
  }
}
