public class Passageiro {

    private String id;
    private int idade;

    public Passageiro(String id, int idade) {
        this.id = id;
        this.idade = idade;
    }
    public String getNome() {
        return id;
    }
    public int getIdade() {
        return idade;
    }
    public boolean ePrioritario(){
        if (getIdade()>=65) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return id + ":" + idade;

    }
}
