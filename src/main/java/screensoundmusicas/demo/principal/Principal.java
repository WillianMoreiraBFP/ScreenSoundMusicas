package screensoundmusicas.demo.principal;

import screensoundmusicas.demo.repository.ArtistaRepository;

import java.util.Scanner;

public class Principal {
    private ArtistaRepository repository;
    private Scanner leitura = new Scanner(System.in);

    public Principal(ArtistaRepository repository) {this.repository = repository;}

    public void exibeMenu() {
        var opcao = -1;
        while (opcao!= 0){
            var menu = """
                    1- Cadastrar artistas
                                        
                    2- Cadastrar músicas
                                        
                    3- Listar músicas
                                        
                    4- Buscar músicas por artistas
                                        
                    9- Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            switch (opcao){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }


        }
    }
}
