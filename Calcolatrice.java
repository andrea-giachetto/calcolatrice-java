// Classe principale della calcolatrice (logica pura, senza GUI)
public class Calcolatrice {
    private double risultatoCorrente;
    private double operandoPrecedente;
    private Operazione operazioneAttuale;
    private boolean nuovoNumero;
    
    public Calcolatrice() {
        this.risultatoCorrente = 0;
        this.operandoPrecedente = 0;
        this.operazioneAttuale = null;
        this.nuovoNumero = true;
    }
    
    // Inserisce una cifra
    public void inserisciCifra(int cifra) {
        if (nuovoNumero) {
            risultatoCorrente = cifra;
            nuovoNumero = false;
        } else {
            risultatoCorrente = risultatoCorrente * 10 + cifra;
        }
    }
    
    // Seleziona un'operazione
    public void selezionaOperazione(String simboloOperazione) {
        if (operazioneAttuale != null && !nuovoNumero) {
            calcolaRisultato();
        }
        operandoPrecedente = risultatoCorrente;
        operazioneAttuale = new Operazione(simboloOperazione);
        nuovoNumero = true;
    }
    
    // Calcola il risultato finale
    public double calcolaRisultato() {
        if (operazioneAttuale != null) {
            risultatoCorrente = operazioneAttuale.esegui(operandoPrecedente, risultatoCorrente);
            operazioneAttuale = null;
            operandoPrecedente = 0;
            nuovoNumero = true;
        }
        return risultatoCorrente;
    }
    
    // Restituisce il risultato attuale
    public double getRisultato() {
        return risultatoCorrente;
    }
    
    // Resetta la calcolatrice
    public void reset() {
        risultatoCorrente = 0;
        operandoPrecedente = 0;
        operazioneAttuale = null;
        nuovoNumero = true;
    }
    
    // Debug: mostra lo stato interno
    public String getStato() {
        String op = (operazioneAttuale != null) ? operazioneAttuale.getSimbolo() : "nessuna";
        return String.format("Risultato: %.2f | Operazione: %s | Nuovo numero: %b", 
                             risultatoCorrente, op, nuovoNumero);
    }
}