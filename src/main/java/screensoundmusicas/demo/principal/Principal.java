package screensoundmusicas.demo.principal;

import screensoundmusicas.demo.model.Artista;
import screensoundmusicas.demo.model.Musica;
import screensoundmusicas.demo.model.Tipo;
import screensoundmusicas.demo.repository.ArtistaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private ArtistaRepository repository;
    private Scanner leitura = new Scanner(System.in);
    private List<Artista> artistas = new ArrayList<>();
    Artista artista = new Artista();

    public Principal(ArtistaRepository repository) {this.repository = repository;}

    public void exibeMenu() {
        var opcao = -1;
        while (opcao!= 9){
            var menu = """
                    1- Cadastrar artistas
                                        
                    2- Cadastrar músicas
                                        
                    3- Listar músicas
                                        
                    4- Buscar músicas por artistas
                                        
                    9- Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    cadastraArtista();
                    break;
                case 2:
                    listarArtistas();
                    cadastraMusica();
                    break;
                case 3:
                    //listarMusica();
                    break;
                case 4:
                    //buscarMusicaArtista();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }


        }
    }

    private void cadastraArtista() {
        System.out.println("Informe o nome desse artista:");
        var nome = leitura.nextLine();

        System.out.println("Informe o tipo desse artista: (solo, dupla, banda)");
        Tipo tipo = Tipo.fromString(leitura.nextLine());

        if (tipo == Tipo.DUPLA){
            String nome2 = null;
            var op = "i";
            while (op.equalsIgnoreCase("i")){
                System.out.println("Cadastrar outro artista? (S/N)");
                op = leitura.nextLine();
                if (op.equalsIgnoreCase("s")) {
                    System.out.println("Informe o nome desse artista:");
                    nome2 = leitura.nextLine();
                    nome += " e " + nome2;

                }else if (!op.equalsIgnoreCase("n")){
                    System.out.println("Opçao invalida");
                    op = "i";
                }
            }
        }

        artista.setNome(nome);
        artista.setTipo(tipo);
        repository.save(artista);

        System.out.println("*** Screen Sound Músicas ***");
    }

    private void cadastraMusica() {

        System.out.println("Informe o nome do artista dono da musica:");
        definirArtista();

        System.out.println("Informe o nome da musica:");
        var nomeMusica = leitura.nextLine();
        System.out.println("Informe o nome do álbum:");
        var nomeAlbum = leitura.nextLine();

        Musica musica = new Musica(nomeMusica,nomeAlbum);

        artista.setMusica(musica);
        repository.save(artista);

    }

    private void definirArtista(){
        var nomeArtista = leitura.nextLine();
        if (artistas.stream().anyMatch(a -> a.getNome().equalsIgnoreCase(nomeArtista))) {
            artista = repository.encontraArtista(nomeArtista);

        } else {
            System.out.println("Artista não encontrado");
        }
    }

    private void listarArtistas() {
//        artistas = repository.findAll();
//        artistas.stream()
//                        .sorted(Comparator.comparing(Artista::getNome))
//                        .forEach(System.out::println);

        artistas = repository.listarArtistas();
        artistas.forEach(System.out::println);
    }
}
