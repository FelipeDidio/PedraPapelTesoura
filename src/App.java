import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        

        Scanner leitura = new Scanner(System.in);
        int jogador1;
        int jogador2;

        System.out.println("Escolha [1]Pedra  -  [2]Papel   -   [3]Tesoura");

        System.out.println("Jogador 1, digite sua opção:");
        jogador1 = leitura.nextInt();

        System.out.println("Jogador 2, digite sua opção:");
        jogador2 = leitura.nextInt();

            switch(jogador1){
                case 1:
                    switch(jogador2){
                        case 1:
                            System.out.println("EMPATE");
                            break;
                        case 2:
                            System.out.println("O jogador 2 venceu");
                            break;
                        case 3:
                            System.out.println("O jogador 1 venceu");
                            break;
                            default: 
                            System.out.println("Opção inválida");
                    }break;
                case 2:
                    switch(jogador2){
                        case 1:
                            System.out.println("O jogador 1 venceu!");
                            break;
                        case 2:
                            System.out.println("EMPATE");
                            break;
                        case 3:
                            System.out.println("O jogador 2 venceu");
                            break;
                            default: 
                            System.out.println("Opção inválida");
                    }break;
                case 3:
                    switch(jogador2){
                        case 1:
                            System.out.println("O jogador 2 venceu");
                            break;
                        case 2:
                            System.out.println("O jogador 1 venceu");
                            break;
                        case 3:
                            System.out.println("EMPATE");
                            break;
                            default: 
                            System.out.println("Opção inválida");
                    }break;
            }
              

    }
}
