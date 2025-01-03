public class Topic {

    private String passageirosNormais[];
    private String passageirosPreferencias[];
    private int capacidade;
    private int qtdPreferenciais;

    public Topic(int capacidade, int qtdPreferenciais) {
        this.capacidade = capacidade;
        this.qtdPreferenciais = qtdPreferenciais;
        this.passageirosPreferencias= new String[qtdPreferenciais];
        this.passageirosNormais= new String[qtdPreferenciais - capacidade];
    }

    public boolean subir(Passageiro passageiro) {
        if (topicCheia()){
            System.out.println("Topic cheia");
            return false;
        }
        if (passageiroPresente(passageiro.getNome())){
            System.out.println("Passageiro já esta na topic");
            return false;
        }
        if (passageiro.ePrioritario()){
            alocarPreferencial(passageiro);
            return true;
        }else{
            alocarNormais(passageiro);
            return true;
        }
    }
    public boolean descer(String nome) {
        for(int i= 0;i < qtdPreferenciais; i++){
            if (passageirosPreferencias[i] != null && passageirosPreferencias[i].equals(nome)){
                return true;
            }
        }
        for(int i= 0;i < capacidade-qtdPreferenciais; i++){
            if (passageirosNormais[i] != null && passageirosNormais[i].equals(nome)){
                passageirosPreferencias = removerPassagriro(passageirosPreferencias, i);
                return true;
            }
        }
        return false;
    }

    private String[] removerPassagriro(String[] array, int indice){
        if (indice < 0 || indice >= array.length){
            System.out.println("O passageiro nao esta na topic");
        }

        String[] novoarray= new String[array.length - 1];

        for(int i= 0,j= 0; i < array.length; i++){
            if (i !=  indice){
                novoarray[j++]= array[i];
            }
        }
        return novoarray;
    }
    private boolean topicCheia(){
        for (int i = 0; i < passageirosPreferencias.length; i++) {
            if (passageirosPreferencias[i] == null){
                return false;
            }
        }
        for (int i=0; i < passageirosNormais.length; i++){
            if (passageirosNormais[i] == null){
                return false;
            }
        }
        return true;
    }
    private boolean passageiroPresente(String id){
        for (int i = 0; i < passageirosPreferencias.length; i++) {
            if (passageirosPreferencias[i] == id){
                return true;
            }
        }
        for (int i=0; i < passageirosNormais.length; i++){
            if (passageirosNormais[i] == id){
                return true;
            }
        }
        return false;
    }
    private void alocarPreferencial(Passageiro passageiro){
        if (passageiro.ePrioritario()) {
            for (int i = 0; i < qtdPreferenciais; i++) {
                if (passageirosPreferencias[i] == null){
                    passageirosPreferencias[i]= passageiro.getNome();
                }
            }
        }
        if (passageiro.ePrioritario()) {
            for (int i = 0; i < passageirosNormais.length; i++) {
                if (passageirosNormais[i] == null) {
                    passageirosNormais[i] = passageiro.getNome();
                }
            }
        }
    }
    private void alocarNormais(Passageiro passageiro) {
        for (int i = 0; i < passageirosNormais.length; i++) {
            if (passageirosNormais[i] == null) {
                passageirosNormais[i] = passageiro.getNome();
            }
        }
        if (!passageiro.ePrioritario()) {
            for (int i = 0; i < qtdPreferenciais; i++) {
                if (passageirosPreferencias[i] == null) {
                    passageirosPreferencias[i] = passageiro.getNome();
                }
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < passageirosPreferencias.length; i++) {
            sb.append(passageirosPreferencias[i] == null ? "@" : "@" + passageirosPreferencias[i]);
            if (i < passageirosPreferencias.length - 1 || passageirosNormais.length > 0) sb.append(" ");
        }
        for (int i = 0; i < passageirosNormais.length; i++) {
            sb.append(passageirosNormais[i] == null ? "=" : "=" + passageirosNormais[i]);
            if (i < passageirosNormais.length - 1) sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}