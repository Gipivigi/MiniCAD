import javax.swing.*;
import java.awt.*;

public class CommandPanel extends JPanel
{
    JButton JBline;
    JButton JBcircle;
    JButton JBrectangle;
    JButton JBpoint;
    JButton JBselectColor;
    JButton JBCursor;
    JButton JBDelSelected;
    JButton JBFill;
    JButton JBTextBox;

    Icon fillOn=new ImageIcon("./res/images/icons/fill-on.bmp");
    Icon fillOff=new ImageIcon("./res/images/icons/fill-off.png");

    public CommandPanel()
    {
        Icon cursor=new ImageIcon("./res/images/icons/hand-cmd.bmp");
        JBCursor=new JButton(cursor);
        JBCursor.setActionCommand("cursor");
        Icon line=new ImageIcon("./res/images/icons/line-cmd.bmp");
        JBline=new JButton(line);
        JBline.setActionCommand("line");
        Icon rectangle=new ImageIcon("./res/images/icons/rect-cmd.bmp");
        JBrectangle=new JButton(rectangle);
        JBrectangle.setActionCommand("rectangle");
        Icon circle=new ImageIcon("./res/images/icons/center-rad-cmd.bmp");
        JBcircle=new JButton(circle);
        JBcircle.setActionCommand("circle");
        Icon point=new ImageIcon("./res/images/icons/point-cmd.bmp");
        JBpoint=new JButton(point);
        JBpoint.setActionCommand("point");
        Icon selectColor=new ImageIcon("./res/images/icons/color.png");
        JBselectColor=new JButton(selectColor);
        JBselectColor.setActionCommand("selectColor");
        Icon delete=new ImageIcon("./res/images/icons/delete-icon.png");
        JBDelSelected=new JButton(delete);
        JBDelSelected.setActionCommand("DeleteFigure");
        JBFill=new JButton(fillOff);
        JBFill.setActionCommand("fill");
        Icon textBox=new ImageIcon("./res/images/icons/textBox.png");
        JBTextBox=new JButton(textBox);
        JBTextBox.setActionCommand("text");
        JBCursor.setPreferredSize(new Dimension(cursor.getIconWidth(), cursor.getIconHeight()));
        JBline.setPreferredSize(new Dimension(line.getIconWidth(), line.getIconHeight()));
        JBrectangle.setPreferredSize(new Dimension(rectangle.getIconWidth(), rectangle.getIconHeight()));
        JBcircle.setPreferredSize(new Dimension(circle.getIconWidth(), circle.getIconHeight()));
        JBpoint.setPreferredSize(new Dimension(point.getIconWidth(), point.getIconHeight()));
        JBselectColor.setPreferredSize(new Dimension(selectColor.getIconWidth(),selectColor.getIconHeight()));
        JBDelSelected.setPreferredSize(new Dimension(delete.getIconWidth(),delete.getIconHeight()));
        JBFill.setPreferredSize(new Dimension(fillOn.getIconWidth(),fillOn.getIconHeight()));
        JBTextBox.setPreferredSize(new Dimension(textBox.getIconWidth(), textBox.getIconHeight()));
        add(JBCursor);
        add(JBline);
        add(JBrectangle);
        add(JBcircle);
        add(JBpoint);
        add(JBTextBox);
        add(JBselectColor);
        add(JBDelSelected);
        add(JBFill);
    }
    public void setFillAction(boolean status)
    {
        if(status)
        {
            JBFill.setIcon(fillOn);
        }
        else
        {
            JBFill.setIcon(fillOff);
        }
    }

}
