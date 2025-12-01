# Calcolatrice

Una semplice applicazione calcolatrice realizzata in Java con interfaccia grafica basata su Swing.

## Funzionalità

- Operazioni aritmetiche di base: addizione (+), sottrazione (-), moltiplicazione (*), divisione (/)
- Separazione netta tra logica di business e interfaccia utente
- Gestione degli errori per la divisione per zero
- Funzionalità di cancellazione/reset
- Layout intuitivo dei pulsanti con operazioni codificate per colore

## Struttura del Progetto

```
calcolatrice/
├── Calcolatrice.java      # Logica principale della calcolatrice (senza dipendenze GUI)
├── Operazione.java        # Classe per le operazioni aritmetiche
├── CalcolatriceGUI.java   # Implementazione GUI con Swing
└── README.md              # Questo file
```

## Architettura

### Calcolatrice.java
Motore principale della calcolatrice che gestisce:
- Risultato corrente e operando precedente
- Macchina a stati delle operazioni
- Gestione dell'input delle cifre
- Esecuzione dei calcoli

### Operazione.java
Incapsula le operazioni aritmetiche con:
- Supporto per gli operatori +, -, *, /
- Protezione dalla divisione per zero
- Validazione delle operazioni

### CalcolatriceGUI.java
Interfaccia utente basata su Swing che include:
- Finestra di 400x500 pixel
- Campo di testo per il display (allineato a destra)
- Layout a griglia con pulsanti per cifre e operazioni
- Pulsanti codificati per colore (operazioni in arancione, uguale in verde, cancella in rosso)

## Requisiti

- Java Development Kit (JDK) 8 o superiore
- Java Runtime Environment (JRE) per l'esecuzione
- Visual Studio Code (consigliato per lo sviluppo)

## Istruzioni per l'Installazione

### 1. Installazione di Java SDK

#### Windows
1. Scarica l'ultima versione di JDK dal [sito di Oracle](https://www.oracle.com/java/technologies/downloads/) oppure [OpenJDK](https://adoptium.net/)
2. Esegui il programma di installazione e segui la procedura guidata
3. Aggiungi Java alla variabile d'ambiente PATH:
   - Apri "Variabili d'ambiente" dalle Proprietà del sistema
   - Aggiungi la directory `bin` del JDK (es. `C:\Program Files\Java\jdk-17\bin`) alla variabile PATH
4. Verifica l'installazione aprendo il Prompt dei comandi ed eseguendo:
   ```bash
   java -version
   javac -version
   ```

#### macOS
1. Scarica il JDK dal [sito di Oracle](https://www.oracle.com/java/technologies/downloads/) oppure installalo tramite Homebrew:
   ```bash
   brew install openjdk
   ```
2. Per l'installazione tramite Homebrew, segui le istruzioni post-installazione per aggiungere Java al PATH
3. Verifica l'installazione nel Terminale:
   ```bash
   java -version
   javac -version
   ```

#### Linux
1. Installa OpenJDK usando il gestore pacchetti:
   ```bash
   # Ubuntu/Debian
   sudo apt update
   sudo apt install openjdk-17-jdk

   # Fedora/RHEL
   sudo dnf install java-17-openjdk-devel
   ```
2. Verifica l'installazione:
   ```bash
   java -version
   javac -version
   ```

### 2. Configurazione di Visual Studio Code

#### Installare VS Code
Scarica e installa VS Code da [https://code.visualstudio.com/](https://code.visualstudio.com/)

#### Installare le Estensioni Java
1. Apri VS Code
2. Clicca sull'icona Estensioni nella barra laterale (oppure premi `Ctrl+Shift+X` / `Cmd+Shift+X`)
3. Cerca "Extension Pack for Java" di Microsoft
4. Clicca su "Installa" (questo installerà diverse estensioni Java essenziali tra cui):
   - Language Support for Java by Red Hat
   - Debugger for Java
   - Java Test Runner
   - Maven for Java
   - Project Manager for Java
   - Visual Studio IntelliCode

#### Configurare Java in VS Code
1. Apri la cartella del progetto in VS Code (`File > Apri cartella`)
2. VS Code dovrebbe rilevare automaticamente l'installazione di Java
3. Se necessario, configura il percorso del JDK:
   - Premi `Ctrl+Shift+P` / `Cmd+Shift+P` per aprire il Riquadro comandi
   - Digita "Java: Configure Java Runtime"
   - Seleziona la versione del JDK installata

### 3. Esecuzione con "Esegui e Debug"

#### Usando il Pulsante Run
1. Apri `CalcolatriceGUI.java` in VS Code
2. Cerca i link "Run" e "Debug" che appaiono sopra il metodo `main`
3. Clicca su "Run" per eseguire l'applicazione
4. Dovrebbe apparire l'interfaccia grafica della calcolatrice

#### Usando il Pannello Debug
1. Clicca sull'icona "Esegui e Debug" nella barra laterale (oppure premi `Ctrl+Shift+D` / `Cmd+Shift+D`)
2. Se non esiste una configurazione di avvio, clicca su "crea un file launch.json"
3. Seleziona "Java" come ambiente
4. VS Code creerà un file `.vscode/launch.json`
5. Clicca sul pulsante verde "Play" oppure premi `F5` per avviare il debug
6. Imposta i breakpoint cliccando a sinistra dei numeri di riga

#### Scorciatoie Rapide per l'Esecuzione
- `F5` - Avvia il debug
- `Ctrl+F5` / `Cmd+F5` - Esegui senza debug
- `Shift+F5` - Interrompi il debug
- `F9` - Attiva/disattiva breakpoint
- `F10` - Esegui istruzione (step over)
- `F11` - Entra nella funzione (step into)

## Compilazione

Compila tutti i file Java:

```bash
javac Calcolatrice.java Operazione.java CalcolatriceGUI.java
```

## Esecuzione dell'Applicazione

Esegui la classe principale:

```bash
java CalcolatriceGUI
```

## Utilizzo

1. Clicca sui pulsanti delle cifre (0-9) per inserire i numeri
2. Clicca su un pulsante operazione (+, -, *, /)
3. Inserisci il secondo numero
4. Clicca sul pulsante uguale (=) per vedere il risultato
5. Clicca sul pulsante cancella (C) per resettare

## Dettagli di Implementazione

- **Gestione dello Stato**: Utilizza flag per tracciare se si sta inserendo un nuovo numero
- **Operazioni a Catena**: Supporta calcoli continui (es. 5 + 3 + 2)
- **Formattazione del Display**: Mostra gli interi senza decimali, i numeri decimali con 2 cifre decimali
- **Gestione degli Errori**: Intercetta e visualizza gli errori per operazioni non valide

## Licenza

Progetto educativo per il corso ITS.
