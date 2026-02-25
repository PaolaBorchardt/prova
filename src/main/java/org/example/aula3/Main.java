package org.example.aula3;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        exibirTitulo();

        System.out.println("🦸🏽‍ Digite o nome do seu heroí: ️");
        String nomeHeroi = scanner.next();

        Heroi heroi = new Heroi(nomeHeroi, 100, 20, 5);

        heroi.adicionarItem(new Item("Granada Sombria", "ataque", 40));
        heroi.adicionarItem(new Item("Pergaminho de Fogo", "ataque", 15));
        heroi.adicionarItem(new Item("Escudo Mágico", "cura", 15));

        //MUDAR ISSO DE LUGAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAR


        System.out.println("\n✅ Herói criado com sucesso!");
        heroi.exibirStatus();


        Monstro[] monstros = {
                new Monstro("Goblin", "👿", 40, 12, 2, 20),               //Fácil
                new Monstro("Orc Guerreiro", "👺", 50, 14, 2, 25),        //Fácil
                new Monstro("Zumbi", "🧟", 35, 12, 1, 10),                //Fácil - Novo Monstro (NM)
                new Monstro("Esqueleto Arqueiro", "💀", 50, 17, 4, 40),   //Médio - NM
                new Monstro("Lobisomem", "🐺", 90, 20, 7, 50),            //Médio - NM
                new Monstro("Verdugo", "🕷️️", 110, 25, 9, 85),             //Difícil - NM
                new Monstro("Bruxa Sombria", "🧙", 160, 35, 12, 130),     //Chefe - NM
                new Monstro("Vampiro Ancião", "🧛", 190, 30, 15, 180)     //Chefe - NM
        };

        int vitorias = 0;

        for (Monstro monstro : monstros) {
            System.out.println("\n\n🗺️ Você avança pela dungeon...");
            System.out.println("🚪 Um " + monstro.getNome() + " bloqueia o caminho!");
            System.out.println("\n [1] Lutar");
            System.out.println(" [2] Fugir (pula essa batalha)");
            System.out.println(" Escolha: ");

            int opcao;
            try {
                opcao = scanner.nextInt();
            } catch (Exception e) {
                opcao = 1;
                scanner.nextLine();
            }

            if (opcao == 2) {
                System.out.println(" 🏃🏽 Você fugiu para o proximo corredor...");
                continue;
            }

            Batalhas batalhas = new Batalhas(heroi, monstro, scanner);
            boolean venceu = batalhas.iniciar();

            if (venceu) {
                vitorias++;
                System.out.println("\n [Pressione ENTER para continuar]");
                scanner.nextLine();
                scanner.nextLine();
            } else {
                exibirGameOver(nomeHeroi, vitorias, heroi.getXp());
                scanner.close();
                return;
            }

        }

        exibirVitoria(heroi, vitorias);
        scanner.close();
    }

    private static void exibirTitulo() {
        System.out.println("-------------------------------------------");
        System.out.println("-         ⚔️ DUNGEON QUEST                -");
        System.out.println("-  Programação Orientação a Objeto        -");
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    private static void exibirGameOver(String nome, int vitorias, int xp) {
        System.out.println("-------------------------------------------");
        System.out.println("-            💀 GAME OVER                 -");
        System.out.println("-------------------------------------------");
        System.out.println("Fim da Jornada de " + nome);
        System.out.println(" Vitórias: " + vitorias);
        System.out.println("XP Total: " + xp);
        System.out.println();

    }

    private static void exibirVitoria(Heroi heroi, int vitorias) {
        System.out.println("-----------------------------------------");
        System.out.println("            👑 DUNGEON COMPLETA          ");
        System.out.println("-----------------------------------------");
        System.out.println("Parabéns, " + heroi.getNome() + "!");
        System.out.println(" Vitórias: " + vitorias);
        System.out.println("XP Total: " + heroi.getXp());
        heroi.exibirStatus();
    }


}