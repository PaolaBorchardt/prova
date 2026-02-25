package org.example.aula3;

public class Item {
    Heroi heroi;
    private String nome;
    private String tipo;
    private int valor;

    public Item(String nome, String tipo, int valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    // Aplica o efeito do item no herói passado como parâmetro
    public void usar(Heroi heroi, Monstro monstro) {
        if (tipo.equals("cura")) {
            heroi.usarPocao();
            System.out.println(" 🧪" + nome + " foi usado!");
        }
        if (tipo.equals("ataque")) {                                                    //Novo
            System.out.println("DEBUG: aplicando dano no monstro...");
            System.out.println(nome + " 💥🔥 causou " + valor + " de dano!");
            monstro.receberDano(valor);
        }
    }


    // Retorna descrição formatada: ex: "Poção Pequena [cura +20]"
    public String getDescricao() {
        return nome + " [" + tipo + " +" + valor + "]";
    }


    //Getters
    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }
}
