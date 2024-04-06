import javax.swing.*;
import java.awt.*;

public class FinestraMiniCAD extends JFrame
{
    CommandPanel JPCommand;
    Container contents;
    public FinestraMiniCAD()
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);
        setSize(600,600);
        getContentPane().setLayout(new BorderLayout());
        JPCommand=new CommandPanel();
        contents=getContentPane();
        contents.setLayout(new BorderLayout());
        contents.add(JPCommand, BorderLayout.WEST);
    }
}
