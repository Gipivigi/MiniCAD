import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandPanel extends JPanel
{
    JButton JBline;
    JButton JBcircle;
    JButton JBrectangle;
    JButton JBpoint;

    boolean line=false, circle=false, rectangle=false, point=false;

    public CommandPanel()
    {
        Icon line=new ImageIcon("./images/icons/line-cmd.bmp");
        JBline=new JButton(line);
        JBline.setActionCommand("line");
        Icon rectangle=new ImageIcon("./images/icons/rect-cmd.bmp");
        JBrectangle=new JButton(rectangle);
        JBrectangle.setActionCommand("rectangle");
        Icon circle=new ImageIcon("./images/icons/center-rad-cmd.bmp");
        JBcircle=new JButton(circle);
        JBcircle.setActionCommand("circle");
        Icon point=new ImageIcon("./images/icons/point-cmd.bmp");
        JBpoint=new JButton(point);
        JBpoint.setActionCommand("point");
        JBline.setPreferredSize(new Dimension(line.getIconWidth(), line.getIconHeight()));
        JBrectangle.setPreferredSize(new Dimension(rectangle.getIconWidth(), rectangle.getIconHeight()));
        JBcircle.setPreferredSize(new Dimension(circle.getIconWidth(), circle.getIconHeight()));
        JBpoint.setPreferredSize(new Dimension(point.getIconWidth(), point.getIconHeight()));
        add(JBline);
        add(JBrectangle);
        add(JBcircle);
        add(JBpoint);
        repaint();
    }

}
