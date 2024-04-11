import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandPanel extends JPanel
{
    JButton JBline;
    JButton JBcircle;
    JButton JBrectangle;
    JButton JBpoint;
    JButton JBselectColor;
    JButton JBCursor;

    Color selectedColor;

    public CommandPanel()
    {
        Icon cursor=new ImageIcon("./images/icons/hand-cmd.bmp");
        JBCursor=new JButton(cursor);
        JBCursor.setActionCommand("cursor");
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
        Icon selectColor=new ImageIcon("./images/icons/color.png");
        JBselectColor=new JButton(selectColor);
        JBselectColor.setActionCommand("selectColor");
        JBCursor.setPreferredSize(new Dimension(cursor.getIconWidth(), cursor.getIconHeight()));
        JBline.setPreferredSize(new Dimension(line.getIconWidth(), line.getIconHeight()));
        JBrectangle.setPreferredSize(new Dimension(rectangle.getIconWidth(), rectangle.getIconHeight()));
        JBcircle.setPreferredSize(new Dimension(circle.getIconWidth(), circle.getIconHeight()));
        JBpoint.setPreferredSize(new Dimension(point.getIconWidth(), point.getIconHeight()));
        JBselectColor.setPreferredSize(new Dimension(selectColor.getIconWidth(),selectColor.getIconHeight()));
        JBselectColor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selectedColor = JColorChooser.showDialog(null, "Seleziona un colore", Color.BLACK);
                System.out.println(selectColor);
            }
        });
        add(JBCursor);
        add(JBline);
        add(JBrectangle);
        add(JBcircle);
        add(JBpoint);
        add(JBselectColor);
    }
    public Color getColor()
    {
        return selectedColor;
    }

}
