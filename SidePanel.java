import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel
{
    JButton JBSave;
    JButton JBLoad;
    JButton JBDel;
    public SidePanel() {
        Icon save = new ImageIcon("./images/icons/save_file.png");
        JBSave = new JButton(save);
        JBSave.setActionCommand("save");
        Icon load = new ImageIcon("./images/icons/load_file.png");
        JBLoad = new JButton(load);
        JBLoad.setActionCommand("load");
        Icon del = new ImageIcon("./images/icons/trash.png");
        JBDel = new JButton(del);
        JBDel.setActionCommand("del");
        JBSave.setPreferredSize(new Dimension(save.getIconWidth(), save.getIconHeight()));
        JBLoad.setPreferredSize(new Dimension(save.getIconWidth(), save.getIconHeight()));
        JBDel.setPreferredSize(new Dimension(save.getIconWidth(), save.getIconHeight()));
        add(JBSave);
        add(JBLoad);
        add(JBDel);
    }
}
