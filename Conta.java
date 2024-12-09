public class Conta {
        int numero;
        double saldo;
        double limite;
        double[] extrato = new double[10];
        int operacoesRealizadas = 0;

        public Conta(int numero, double saldoInicial) {
            this.numero = numero;
            this.saldo = saldoInicial;
            this.limite = 100.00;
        }

        public boolean sacar(double valor) {
            if(this.getSaldo() >= valor) {
                this.saldo -= valor;
                extrato[operacoesRealizadas++] = valor*(-1);
                return true;
            }
            return false;
        }

        public boolean depositar(double valor) {
            this.saldo += valor;
            extrato[operacoesRealizadas++] = valor;
            return true;
        }

        public boolean transferir(Conta destino, double valor) {
            if(this.getSaldo() >= valor) {
                destino.depositar(valor);
                this.sacar(valor);
                extrato[operacoesRealizadas++] = valor*(-1);
                return true;
            } else {
                return false;
            }
        }

        public double getSaldo() {
            return saldo;
        }

        public String toString() {
            return "Conta{" +
                    "numero=" + numero +
                    ", saldo=" + saldo +
                    ", limite=" + limite +
                    '}';
        }

        public double[] verExtrato() {
            double[] resultado = new double[operacoesRealizadas];
            for(int i = 0; i < operacoesRealizadas; i++) {
                resultado[i] = extrato[i];
            }
            return resultado;
        }
    }

