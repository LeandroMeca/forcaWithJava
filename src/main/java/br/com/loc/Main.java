package br.com.loc;

import br.com.loc.hangman.exception.GameIsFinishedException;
import br.com.loc.hangman.model.HangmanChar;
import br.com.loc.hangman.model.HangmanGame;

import java.util.Scanner;
import java.util.stream.Stream;


public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {

        var characters = Stream.of(args).map(a -> a.toLowerCase().charAt(0)).map(HangmanChar::new).toList();
        System.out.println(characters);
        var hangmanGame = new HangmanGame(characters);

        System.out.println("Bem vindo ao jogo da forca, tente adivinhar a palavra, boa sorte");
        System.out.println(hangmanGame);
        System.out.println("Selecione uma das opções:");

        var option = -1;
        while (option != 3){
            System.out.println("1 - Informar uma letra");
            System.out.println("2 - Verificar status do jogo");
            System.out.println("3 - Sair do jogo");
            option = scanner.nextInt();
            if((option > 3) || (option < 1)){
                System.out.println("Opção inválida");
            }
            if(option == 1){
                System.out.println("Informe uma letra");
                var character = scanner.next().charAt(0);
                try{
                    hangmanGame.inputCharacter(character);
                }catch (GameIsFinishedException ex){
                    System.out.println(ex.getMessage());
                    System.exit(0);
                }
            }
        }

    }



}