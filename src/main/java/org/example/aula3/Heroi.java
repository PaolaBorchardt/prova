package org.example.aula3;

import java.util.ArrayList;

public class Heroi {
    ArrayList<Item> inventario = new ArrayList<>();

    private String nome;
    private int vidaMaxima;
    private int vidaAtual;
    private int ataque;
    private int defesa;
    private int pocoes;
    private int xp;
    private int nivel = 1; // começa no nível 1

    public Heroi(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;        //Comum
        this.vidaMaxima = vida;  //Comum
        this.vidaAtual = vida;   //Comum
        this.ataque = ataque;    //Comum
        this.defesa = defesa;    //Comum
        this.pocoes = 3;         //Exclusivos
        this.xp = 0;             //Exclusivos


    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vidaAtual;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getPocoes() {
        return pocoes;
    }

    public int getXp() {
        return xp;
    }

    public int atacar() {
        int variacao = (int) (Math.random() * 10) - 5;
        return ataque + variacao;
    }

    public void receberDano(int dano) {
        int danoReal = dano - defesa;
        if (danoReal < 1) danoReal = 1;

        vidaAtual -= danoReal;
        if (vidaAtual < 0) vidaAtual = 0;

        System.out.println(" 💔" + nome + " recebeu " + danoReal + " de dano! " + "[❤️ " + vidaAtual + "/" + vidaMaxima + "]");

    }

    public boolean usarPocao() {
        if (pocoes <= 0) {
            System.out.println(" ❌ Sem poções!");
            return false;
        }
        if (vidaAtual == vidaMaxima) {
            System.out.println(" ⚠️ Vida já está cheia! Poção não foi usada.");
            return false;
        }

        int cura = 30;
        vidaAtual += cura;
        if (vidaAtual > vidaMaxima) vidaAtual = vidaMaxima;

        pocoes--;
        System.out.println(" 🧪 " + nome + " usou poção! +30 💚 " + "[💚 " + vidaAtual + "/" + vidaMaxima + "] [Poções: " + pocoes + "]");
        return true;
    }

    public void receberCura(int cura) {

        if (vidaAtual == vidaMaxima) {
            System.out.println(" ❤️ Vida já está cheia!");
            return;
        }

        vidaAtual += cura;

        if (vidaAtual > vidaMaxima) {
            vidaAtual = vidaMaxima;
        }

        System.out.println(" 💚 " + nome + " recuperou +" + cura +
                " HP! [" + vidaAtual + "/" + vidaMaxima + "]");
    }

    public void ganharXp(int quantidade) {
        xp += quantidade;
        System.out.println(" ⭐⬆️" + quantidade + " XP! [Total: " + xp + "]");
        verificarNivel();  //novo
    }

    public boolean estaVivo() {
        return vidaAtual > 0;
    }

    public void exibirStatus() {
        System.out.println("\n 🦸‍♂️ " + nome);
        System.out.println(" 🏅 Nível:  " + nivel);
        System.out.println(" ❤️ Vida: " + vidaAtual + "/" + vidaMaxima);
        System.out.println(" ⚔️ Ataque: " + ataque);
        System.out.println(" 🛡️ Defesa: " + defesa);
        System.out.println(" 🧪 Poções: " + pocoes);
        System.out.println(" ⭐ XP: " + xp);

    }

    public void adicionarItem(Item item) {
        inventario.add(item);
        System.out.println("📦 Item adicionado: " + item.getDescricao());
    }

    public void listarInventario() {

        if (inventario.isEmpty()) {
            System.out.println("✖️ Inventário Vazio!");
            return;
        }

        System.out.println("\n🎒 Inventário:");

        for (int i = 0; i < inventario.size(); i++) {
            System.out.println(" [" + i + "] " + inventario.get(i).getDescricao());
        }

    }

    //Novo - Evolução de níveis ( 3 )

    public boolean usarItem(int indice, Monstro monstro) {

        if (inventario.isEmpty()) {
            System.out.println(" ❌ Inventário vazio!");
            return false;
        }

        if (indice < 0 || indice >= inventario.size()) {
            System.out.println(" ❌ Índice inválido!");
            return false;
        }

        Item item = inventario.get(indice);

        item.usar(this, monstro);

        inventario.remove(indice);

        return true;
    }

    public int getNivel() {
        return nivel;
    }

    private void verificarNivel() {
        int xpNecessario = nivel * 100;

        if (xp >= xpNecessario) {
            nivel++;

            ataque += 5;
            defesa += 2;
            vidaMaxima += 20;
            vidaAtual += 20;
            pocoes += 1;

            // Garantir que a vida não passe do máximo
            if (vidaAtual > vidaMaxima) vidaAtual = vidaMaxima;

            // Exibir mensagem de Level Up
            System.out.println("\n  ✨ LEVEL UP! ✨");
            System.out.println("  " + nome + " chegou ao Nível " + nivel + "!");
            System.out.println("  ⚔️  Ataque +5  |  🛡️  Defesa +2  |  ❤️  Vida +20  |  🧪 +1 Poção");
        }
    }


}







