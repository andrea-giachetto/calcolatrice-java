import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcolatriceGUI extends JFrame {
    private Calcolatrice calcolatrice;
    private JTextField display;
    private JButton[] bottoneCifre;
    private JButton bottoneOperazioni[];
    private JButton bottoneUguali;
    private JButton bottoneReset;
    
    public CalcolatriceGUI() {
        // Inizializza la calcolatrice logica
        calcolatrice = new Calcolatrice();
        
        // Configurazione della finestra
        setTitle("Calcolatrice");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null); // Centra la finestra
        
        // Crea il layout principale
        JPanel panelPrincipale = new JPanel();
        panelPrincipale.setLayout(new BorderLayout(10, 10));
        panelPrincipale.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Crea il display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setText("0");
        display.setEditable(false);
        display.setBackground(new Color(200, 200, 200));
        panelPrincipale.add(display, BorderLayout.NORTH);
        
        // Crea il pannello dei bottoni
        JPanel panelBottoni = new JPanel();
        panelBottoni.setLayout(new GridLayout(5, 4, 5, 5));
        
        // Crea i bottoni delle cifre (0-9)
        bottoneCifre = new JButton[10];
        for (int i = 0; i < 10; i++) {
            bottoneCifre[i] = new JButton(String.valueOf(i));
            bottoneCifre[i].setFont(new Font("Arial", Font.PLAIN, 18));
            bottoneCifre[i].addActionListener(new GestoreBottoneCifra(i));
            bottoneCifre[i].setBackground(new Color(220, 220, 220));
            bottoneCifre[i].setOpaque(true);
        }
        
        // Crea i bottoni delle operazioni
        String[] operazioni = {"+", "-", "*", "/"};
        bottoneOperazioni = new JButton[operazioni.length];
        for (int i = 0; i < operazioni.length; i++) {
            bottoneOperazioni[i] = new JButton(operazioni[i]);
            bottoneOperazioni[i].setFont(new Font("Arial", Font.PLAIN, 18));
            bottoneOperazioni[i].addActionListener(new GestoreBottoneOperazione(operazioni[i]));
            bottoneOperazioni[i].setBackground(new Color(255, 165, 0));
            bottoneOperazioni[i].setOpaque(true);
        }
        
        // Bottone Uguale
        bottoneUguali = new JButton("=");
        bottoneUguali.setFont(new Font("Arial", Font.PLAIN, 18));
        bottoneUguali.addActionListener(new GestoreBottoneUguali());
        bottoneUguali.setBackground(new Color(0, 200, 0));
        bottoneUguali.setOpaque(true);
        bottoneUguali.setForeground(Color.WHITE);
        
        // Bottone Reset
        bottoneReset = new JButton("C");
        bottoneReset.setFont(new Font("Arial", Font.PLAIN, 18));
        bottoneReset.addActionListener(new GestoreBottoneReset());
        bottoneReset.setBackground(new Color(200, 0, 0));
        bottoneReset.setOpaque(true);
        bottoneReset.setForeground(Color.WHITE);
        
        // Layout della griglia (5 righe x 4 colonne)
        // Riga 1: Reset, /, *, -
        panelBottoni.add(bottoneReset);
        panelBottoni.add(bottoneOperazioni[2]); // *
        panelBottoni.add(bottoneOperazioni[3]); // /
        panelBottoni.add(bottoneOperazioni[1]); // -
        
        // Riga 2: 7, 8, 9, +
        panelBottoni.add(bottoneCifre[7]);
        panelBottoni.add(bottoneCifre[8]);
        panelBottoni.add(bottoneCifre[9]);
        panelBottoni.add(bottoneOperazioni[0]); // +
        
        // Riga 3: 4, 5, 6, =
        panelBottoni.add(bottoneCifre[4]);
        panelBottoni.add(bottoneCifre[5]);
        panelBottoni.add(bottoneCifre[6]);
        panelBottoni.add(bottoneUguali);
        
        // Riga 4: 1, 2, 3, =
        panelBottoni.add(bottoneCifre[1]);
        panelBottoni.add(bottoneCifre[2]);
        panelBottoni.add(bottoneCifre[3]);
        panelBottoni.add(bottoneUguali);
        
        // Riga 5: 0 (largo), ., , =
        panelBottoni.add(bottoneCifre[0]);
        panelBottoni.add(bottoneCifre[0]);
        panelBottoni.add(bottoneCifre[0]);
        panelBottoni.add(bottoneUguali);
        
        panelPrincipale.add(panelBottoni, BorderLayout.CENTER);
        
        add(panelPrincipale);
        setVisible(true);
    }
    
    // Gestore per i bottoni delle cifre
    private class GestoreBottoneCifra implements ActionListener {
        private int cifra;
        
        public GestoreBottoneCifra(int cifra) {
            this.cifra = cifra;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            calcolatrice.inserisciCifra(cifra);
            aggiornaDisplay();
        }
    }
    
    // Gestore per i bottoni delle operazioni
    private class GestoreBottoneOperazione implements ActionListener {
        private String operazione;
        
        public GestoreBottoneOperazione(String operazione) {
            this.operazione = operazione;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                calcolatrice.selezionaOperazione(operazione);
                aggiornaDisplay();
            } catch (IllegalArgumentException ex) {
                display.setText("Errore: " + ex.getMessage());
            }
        }
    }
    
    // Gestore per il bottone Uguale
    private class GestoreBottoneUguali implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                calcolatrice.calcolaRisultato();
                aggiornaDisplay();
            } catch (IllegalArgumentException ex) {
                display.setText("Errore: " + ex.getMessage());
            }
        }
    }
    
    // Gestore per il bottone Reset
    private class GestoreBottoneReset implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calcolatrice.reset();
            aggiornaDisplay();
        }
    }
    
    // Aggiorna il display con il risultato corrente
    private void aggiornaDisplay() {
        double risultato = calcolatrice.getRisultato();
        // Se il numero è intero, mostralo senza decimali
        if (risultato == (long) risultato) {
            display.setText(String.format("%d", (long) risultato));
        } else {
            display.setText(String.format("%.2f", risultato));
        }
    }
    
    public static void main(String[] args) {
        // Esegui la GUI nel thread di evento di Swing
        SwingUtilities.invokeLater(() -> new CalcolatriceGUI());
    }
}