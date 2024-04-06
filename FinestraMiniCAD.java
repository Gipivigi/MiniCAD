import javax.swing.*;
import java.awt.*;

public class FinestraMiniCAD extends JFrame
{
    CommandPanel JPCommand;
    Container CFigures;
    public FinestraMiniCAD()
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        getContentPane().setLayout(new BorderLayout());
        JPCommand=new CommandPanel();
        CFigures=getContentPane();
        CFigures.setLayout(new BorderLayout());
        CFigures.add(JPCommand, BorderLayout.WEST);
    }
}
