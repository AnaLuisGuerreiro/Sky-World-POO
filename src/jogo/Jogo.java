package jogo;

import efeitos.Efeitos;
import entidades.Heroi;
import entidades.herois.Arqueiro;
import entidades.herois.Cavaleiro;
import entidades.herois.Feiticeiro;
import itens.ArmaPrincipal;

import java.util.Scanner;


public class Jogo {

public Heroi criarPersonagem(){
    Scanner input = new Scanner(System.in);
    String nick;
    int classe,dificuldade;

    // Escolhas do utilizador
    System.out.print("Introduz o teu nick: ");
    nick = input.next();
    System.out.println("Bem vindo(a) " + Efeitos.BOLD + nick + Efeitos.RESET);

    System.out.println("        Escolhe a tua classe: ");
    System.out.println("1.Arqueiro | 2.Cavaleiro | 3.Feiticeiro");
    classe = input.nextInt();
    System.out.println("        Escolhe a dificuldade: ");
    System.out.println("1.Fácil | 2.Difícil");
    dificuldade = input.nextInt();

    int pontosCriacao, ouroInicial;

    if(dificuldade == 1){
        pontosCriacao = 300;
        ouroInicial = 20;
    } else if(dificuldade == 2){
        pontosCriacao = 220;
        ouroInicial = 15;
    } else{
        System.out.println("Dificuldade inválida.");
        return null;
    }

    System.out.println(Efeitos.GREEN + "Distribua pontos de criação entre vida e força:");
    System.out.println("Sabendo que cada ponto de vida vale 1 ponto de criação e cada ponto de força vale 5 pontos de criação." + Efeitos.RESET);

    int pontosVida = 0;
    int pontosForca = 0;

    // Loop para distribuir os pontos
    while (pontosCriacao > 0){
        System.out.println("Pontos de criação disponiveis: " + pontosCriacao); // Apresentaçao dos pontos que tem
        System.out.println("Quantos pontos para vida?");
        int vida = input.nextInt();
        if(vida <= pontosCriacao){ // Verificar se tem pontos suficientes para adicionar
            pontosVida += vida;    // Adicionar à vida
            pontosCriacao -= vida; // Retirar ao pontos de criaçao
        } else{
            System.out.println("Pontos insuficientes! Tenta novamente.");
        }

        System.out.println("Pontos de criação restantes: " + pontosCriacao); // Apresentaçao dos pontos que ainda tem
        System.out.println("Quantos pontos para força?");
        int forca = input.nextInt();
        if(forca * 5 <= pontosCriacao){ // Verificar se tem pontos suficientes para adicionar (5* mais o custo)
            pontosForca += forca;       // Adicionar à força
            pontosCriacao -= forca * 5; // Retirar ao pontos de criaçao
        }
    }

    Heroi heroi = null;
    ArmaPrincipal primeiraArma = new ArmaPrincipal("Faca pequena",20,15,30);
    primeiraArma.addHeroi("Cavaleiro");
    primeiraArma.addHeroi("Arqueiro");
    primeiraArma.addHeroi("Feiticeiro");

    // Instanciar o heroi selecionado com os dados corretos iniciais
    switch (classe){
        case 1:
            heroi = new Arqueiro(nick,pontosForca,pontosVida,ouroInicial,primeiraArma);
            break;
        case 2:
            heroi = new Cavaleiro(nick,pontosForca,pontosVida,ouroInicial,primeiraArma);
            break;
        case 3:
            heroi = new Feiticeiro(nick,pontosForca,pontosVida,ouroInicial,primeiraArma);
            break;
        default:
            System.out.println("Classe inválida.");
            break;
    }

    return heroi;

}



    }






