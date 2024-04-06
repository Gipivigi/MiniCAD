import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandPanel extends JPanel implements ActionListener
{
    JButton JBline;
    JButton JBcircle;
    JButton JBrectangle;
    JButton JBpoint;

    public CommandPanel()
    {
        Icon line=new ImageIcon("./images/icons/line-cmd.bmp");
        JBline=new JButton(line);
        JBline.addActionListener(this);
        Icon rectangle=new ImageIcon("./images/icons/rect-cmd.bmp");
        JBrectangle=new JButton(rectangle);
        JBrectangle.addActionListener(this);
        Icon circle=new ImageIcon("./images/icons/center-rad-cmd.bmp");
        JBcircle=new JButton(circle);
        JBcircle.addActionListener(this);
        Icon point=new ImageIcon("./images/icons/point-cmd.bmp");
        JBpoint=new JButton(point);
        JBpoint.addActionListener(this);
        JBline.setPreferredSize(new Dimension(line.getIconWidth(), line.getIconHeight()));
        JBrectangle.setPreferredSize(new Dimension(rectangle.getIconWidth(), rectangle.getIconHeight()));
        JBcircle.setPreferredSize(new Dimension(circle.getIconWidth(), circle.getIconHeight()));
        JBpoint.setPreferredSize(new Dimension(point.getIconWidth(), point.getIconHeight()));
        add(JBline);
        add(JBrectangle);
        add(JBcircle);
        add(JBpoint);
    }
    public void actionPerformed(ActionEvent e)
    {

    }
}
