import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel
{
    JButton JBSave;
    JButton JBLoad;
    JButton JBDel;
    JButton JBInfo;
    public SidePanel()
    {
        setLayout(new GridLayout(15,1));
        Icon save = new ImageIcon("./res/images/icons/save_file.png");
        JBSave = new JButton(save);
        JBSave.setActionCommand("save");
        Icon load = new ImageIcon("./res/images/icons/load_file.png");
        JBLoad = new JButton(load);
        JBLoad.setActionCommand("load");
        Icon del = new ImageIcon("./res/images/icons/trash.png");
        JBDel = new JButton(del);
        JBDel.setActionCommand("del");
        Icon info = new ImageIcon("./res/images/icons/info.png");
        JBInfo = new JButton(info);
        JBInfo.setActionCommand("info");
        JBSave.setPreferredSize(new Dimension(save.getIconWidth(), save.getIconHeight()));
        JBLoad.setPreferredSize(new Dimension(load.getIconWidth(), load.getIconHeight()));
        JBDel.setPreferredSize(new Dimension(del.getIconWidth(), del.getIconHeight()));
        JBInfo.setPreferredSize(new Dimension(info.getIconWidth(), info.getIconHeight()));
        add(JBSave);
        add(JBLoad);
        add(JBDel);
        add(JBInfo);
    }
}
