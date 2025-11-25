// Classe per rappresentare un'operazione
public class Operazione {
    private String simbolo;
    
    public Operazione(String simbolo) {
        this.simbolo = simbolo;
    }
    
    public double esegui(double operando1, double operando2) {
        switch(simbolo) {
            case "+":
                return operando1 + operando2;
            case "-":
                return operando1 - operando2;
            case "*":
                return operando1 * operando2;
            case "/":
                if (operando2 == 0) {
                    throw new IllegalArgumentException("Errore: divisione per zero!");
                }
                return operando1 / operando2;
            default:
                throw new IllegalArgumentException("Operazione non riconosciuta: " + simbolo);
        }
    }
    
    public String getSimbolo() {
        return simbolo;
    }
}