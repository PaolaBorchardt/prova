/*Identifiquei que tanto a classe heroi quanto monstro tem diversas coisas em comum, ou seja, sendo
  uma caracteristica básica de cada personagem do jogo, tanto o "mocinho" - heroi, quanto o "vilão",
  - monstro precisam.

  Faz sentido mover para a classe base (personagem):

   - nome (String)
   - vida / vidaAtual (int)
   - ataque (int)
   - defesa (int)
   - receberDano(int)
   - atacar()
   - estaVivo()
   - exibirStatus()

  e deve ontinuar em cada classe separada - Heroi, as coisas particulares do heroi, que são:

   - pocoes
   - xp
   - inventario
   - usarPocao()
   - ganharXp()
  - usarItem()

  e deve ontinuar em cada classe separada - Monstro, as coisas particulares do monstro, que são:

  - xpRecompensa
  - emoji

 */

package org.example.aula3;

public class Personagem {

    // protected = acessível na própria classe E nas subclasses (filhas)
    // Diferente de private, que só a própria classe acessa
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;

    // Construtor da classe base
    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public int atacar() {
        int variacao = (int) (Math.random() * 10) - 5;
        return ataque + variacao;
    }

    public void receberDano(int dano) {
        int danoReal = dano - defesa;
        if (danoReal < 1) danoReal = 1;
        vida -= danoReal;
        if (vida < 0) vida = 0;
        System.out.println("  💥 " + nome + " recebeu " + danoReal + " de dano!");
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    void exibirStatus() {
        System.out.println("=== " + nome + " ===");
        System.out.println("❤️ Vida: " + vida);
        System.out.println("⚔️ Ataque: " + ataque);
        System.out.println("🛡️ Defesa: " + defesa);
    }
}


