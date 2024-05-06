import javax.swing.*;

public class MincadInstructions extends JFrame {

    public MincadInstructions()
    {
        setTitle("ISTRUZIONI PER IL FUNZIONAMENTO DI MINCAD");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JTextPane instructionsPane=new JTextPane();
        instructionsPane.setContentType("text/html");
        instructionsPane.setEditable(false);

        String instructionsText="<html><body style='font-family: Arial; font-size: 14px;'>";
        instructionsText+="<h1><b>ISTRUZIONI PER IL FUNZIONAMENTO DELL’APPLICAZIONE “MINCAD”</b></h1>";
        instructionsText+="<h2><b>DISEGNO DELLE FIGURE</b></h2>";
        instructionsText+="<p>Nella parte superiore e nel lato destro della finestra si trovano tutti i pulsanti relativi al disegno delle figure e le loro diverse funzioni:</p>";
        instructionsText+="<ul><li>Nella parte superiore: selezione, disegno, scelta del colore, cancellazione e riempimento delle varie figure.</li>";
        instructionsText+="<li>Sul lato destro: selezione dello spessore dei tratti delle figure da disegnare.</li></ul>";
        instructionsText+="<p>Per eseguire il disegno di una figura, si procede in questo modo: tra i vari tasti si sceglie la figura desiderata (linea, rettangolo, ovale o punto). Il colore di default, se non modificato dall'utente, è il nero, mentre il riempimento è disattivato all'avvio del programma. Lo spessore predefinito è 1, a meno che non venga modificato.</p>";
        instructionsText+="<p>Successivamente, ci si posiziona nell'area di disegno e, facendo un primo clic sinistro del mouse, si disegna il punto iniziale della figura. Spostando il cursore, si costruisce la figura desiderata. Per confermare il disegno, basta eseguire un secondo clic sinistro del mouse. Nel caso del punto, un solo clic sinistro basterà per disegnarlo.</p>";
        instructionsText+="<p>Per ridisegnare una figura precedentemente disegnata, basta eseguire nuovamente un clic sinistro del mouse. La figura selezionata dall'utente rimane attiva finché non se ne seleziona un'altra o finché non si attiva la modalità di selezione delle figure disegnate.</p>";
        instructionsText+="<h2><b>SELEZIONE DELLE FIGURE</b></h2>";
        instructionsText+="<p>Se si desidera modificare o eliminare una figura disegnata, è sufficiente selezionare il tasto in cui è raffigurata la mano (il primo a sinistra della barra superiore) per attivare la modalità di selezione. In questa modalità, un clic sinistro del mouse su una figura la selezionerà. È possibile capire se una figura è selezionata perché cambierà colore in ciano. A questo punto, è possibile eseguire diverse operazioni:</p>";
        instructionsText+="<ul><li>Modifica: se una figura è selezionata e si seleziona uno spessore o un colore dagli appositi tasti, le modifiche verranno applicate solo a quella figura e non alle prossime figure disegnate. Una volta eseguita la modifica, la figura si deselezionerà automaticamente, rendendo effettive le modifiche apportate.</li>";
        instructionsText+="<li>Eliminazione: una volta selezionata la figura, utilizzando il tasto apposito per la cancellazione di una figura (l'ultimo a destra della barra superiore), questa verrà eliminata. Se per caso viene selezionata per errore una figura e si desidera annullare la selezione, basterà cliccare su uno spazio vuoto o su un'altra figura, o sulla stessa figura selezionata, per annullare la selezione.</li></ul>";
        instructionsText+="<p>Come per i tasti usati per disegnare le figure, anche la funzione di selezione rimane attiva finché non viene selezionato un tasto per il disegno delle figure.</p>";
        instructionsText+="<h2><b>SALVATAGGIO DELL’AREA DI DISEGNO</b></h2>";
        instructionsText+="<p>Sulla parte sinistra della finestra si trovano tre tasti che eseguono le seguenti operazioni: salvataggio dei disegni, caricamento di un file contenente i disegni e eliminazione di un file contenente i disegni.</p>";
        instructionsText+="<h2><b>MODIFICA DELL’INTERFACCIA GRAFICA</b></h2>";
        instructionsText+="<p>Nella parte inferiore si trova un menù a tendina che permette di cambiare lo sfondo dell'area di disegno e una spunta per attivare o disattivare la griglia.</p>";
        instructionsText+="</body></html>";

        instructionsPane.setText(instructionsText);
        instructionsPane.setCaretPosition(0);

        JScrollPane scrollPane=new JScrollPane(instructionsPane);
        scrollPane.getVerticalScrollBar().setValue(0);
        add(scrollPane);
    }
}
