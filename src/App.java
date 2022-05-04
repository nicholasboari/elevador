import javax.swing.JOptionPane;

public class App {
  public static void main(String[] args) throws Exception {
    int andares;
    int capacidadeElevador;
    do {
      andares = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantos andares o predio tem?", "Elevador", 3));
      capacidadeElevador = Integer.parseInt(JOptionPane.showInputDialog(null,
          "Qual a capacidade do elevador?", "Elevador", 3));
      if (andares < 1 && capacidadeElevador < 1) {
        JOptionPane.showMessageDialog(null, "O numero de andares ou capacidade do elevador estao incorretas");
      }
    } while (andares < 1 && capacidadeElevador < 1);

    Elevador elevador = new Elevador(andares, capacidadeElevador);

    int menu;
    do {
      menu = Integer
          .parseInt(
              JOptionPane.showInputDialog(null, "1 - Entrar no elevador\n2 - Sair do elevador\n3 - Subir elevador\n"
                  + "4 - Descer elevador\n5 - Informacoes do elevador\n6 - Fechar programa", "Elevador", 3));
      switch (menu) {
        case 1:
          int pessoas;
          do {
            pessoas = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Quantas pessoas vao entrar?", "Elevador", 3));

            if (elevador.entra(pessoas) == false) {
              JOptionPane.showMessageDialog(null, "O numero de pessoas é maior que " + capacidadeElevador, "Elevador",
                  0);
            } else {
              JOptionPane.showMessageDialog(null, "Entraram " + pessoas + " pessoas no elevador"
                  + "\nPessoas dentro do elevador: " + elevador.getPessoasElevador()
                  + "\nAndar atual: " + elevador.getAndarAtual(),
                  "Elevador", 1);
            }
          } while (pessoas > capacidadeElevador);
          break;
        case 2:
          int saiPessoas;
          saiPessoas = Integer
              .parseInt(JOptionPane.showInputDialog(null, "Quantas pessoas vão sair?", "Elevador", 3));
          if (elevador.sair(saiPessoas) == false) {
            JOptionPane.showMessageDialog(null, "Não é possivel sair mais pessoas do que a quantidade atual",
                "Elevador", 0);
          } else {
            JOptionPane.showMessageDialog(null, "Sairam " + saiPessoas + " pessoas no elevador"
                + "\nQuantidade atual: " + elevador.getPessoasElevador()
                + "\nAndar atual: " + elevador.getAndarAtual(),
                "Elevador", 1);
          }
          break;

      }
      switch (menu) {
        case 3:
          int subirAndar;
          subirAndar = Integer
              .parseInt(JOptionPane.showInputDialog(null, "Quantos andares deseja subir?\nAndar atual: "
                  + elevador.getAndarAtual(), "Elevador", 3));
          if (elevador.subir(subirAndar) == false) {
            JOptionPane.showMessageDialog(null,
                "Não é possivel subir mais do que " + andares + " andares\nAndar atual: " + elevador.getAndarAtual(),
                "Elevador", 0);
          } else {
            JOptionPane.showMessageDialog(null,
                "Você subiu " + subirAndar + " andares\nAndar atual: " + elevador.getAndarAtual(), "Elevador", 1);
          }
          break;
      }
      switch (menu) {
        case 4:
          int descerAndar;
          descerAndar = Integer
              .parseInt(JOptionPane.showInputDialog(null, "Quantos andares deseja descer?\nAndar atual: "
                  + elevador.getAndarAtual(), "Elevador", 3));
          if (elevador.descer(descerAndar) == false) {
            JOptionPane.showMessageDialog(null,
                "Não é possivel descer mais do que " + elevador.getAndarAtual() + " andares\nAndar atual: "
                    + elevador.getAndarAtual(),
                "Elevador", 0);
          } else {
            JOptionPane.showMessageDialog(null,
                "Você desceu " + descerAndar + " andares\nAndar atual: " + elevador.getAndarAtual(), "Elevador", 1);
          }
          break;
      }
      switch (menu) {
        case 5:
          JOptionPane.showMessageDialog(null,
              "Total de andares do prédio: " + andares + "\nCapacidade do elevador: " + capacidadeElevador +
                  "\nPessoas dentro do elevador: " + elevador.getPessoasElevador()
                  + "\nAndar atual: " + elevador.getAndarAtual(),
              "Elevador", 1);
          break;
      }
    } while (menu != 6);
  }
}
