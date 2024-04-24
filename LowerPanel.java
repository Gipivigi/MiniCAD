import javax.swing.*;
import java.awt.*;

public class LowerPanel extends JPanel
{
    JCheckBox JCheck;
    String[] colori = {"Default","Nero","Blu","Grigio","Ciano","Verde"};
    JComboBox<String> JMenu;
    JLabel JMex;
    Color colorSelected=Color.WHITE;
    public LowerPanel()
    {
        JCheck = new JCheckBox("Mostra griglia");
        JMenu = new JComboBox<>(colori);
        JMenu.setActionCommand("backgroundColor");
        JMenu.setSelectedIndex(0);
        JMex = new JLabel("Colore di sfondo selezionato: ");
        add(JMex);
        add(JMenu);
        add(JCheck);
    }
    public void setColorSelected(Color colorSelected){this.colorSelected=colorSelected;};
    public Color getColorSelected(){return colorSelected;}
}
