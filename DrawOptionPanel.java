import javax.swing.*;
import java.awt.*;
public class DrawOptionPanel extends JPanel
{
    JButton JBThickness1;
    JButton JBThickness2;
    JButton JBThickness3;
    JButton JBThickness4;
    JButton JBThickness5;

    public DrawOptionPanel()
    {
        Icon th1=new ImageIcon("./images/thickness/stroke1.png");
        JBThickness1=new JButton(th1);
        JBThickness1.setActionCommand("thickness_1");
        Icon th2=new ImageIcon("./images/thickness/stroke2.png");
        JBThickness2=new JButton(th2);
        JBThickness2.setActionCommand("thickness_2");
        Icon th3=new ImageIcon("./images/thickness/stroke3.png");
        JBThickness3=new JButton(th3);
        JBThickness3.setActionCommand("thickness_3");
        Icon th4=new ImageIcon("./images/thickness/stroke4.png");
        JBThickness4=new JButton(th4);
        JBThickness4.setActionCommand("thickness_4");
        Icon th5=new ImageIcon("./images/thickness/stroke5.png");
        JBThickness5=new JButton(th5);
        JBThickness5.setActionCommand("thickness_5");
        JBThickness1.setPreferredSize(new Dimension(th1.getIconWidth(), th1.getIconHeight()));
        JBThickness2.setPreferredSize(new Dimension(th2.getIconWidth(), th2.getIconHeight()));
        JBThickness3.setPreferredSize(new Dimension(th3.getIconWidth(), th3.getIconHeight()));
        JBThickness4.setPreferredSize(new Dimension(th4.getIconWidth(), th4.getIconHeight()));
        JBThickness5.setPreferredSize(new Dimension(th5.getIconWidth(), th5.getIconHeight()));
        add(JBThickness1);
        add(JBThickness2);
        add(JBThickness3);
        add(JBThickness4);
        add(JBThickness5);
    }


}
