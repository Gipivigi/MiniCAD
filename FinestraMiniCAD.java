import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinestraMiniCAD extends JFrame implements ActionListener
{
    CommandPanel JPCommand;
    DrawPanel JPDraw;
    Container contents;
    boolean line=false, circle=false, rectangle=false, point=false;
    public FinestraMiniCAD()
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getContentPane().setLayout(new BorderLayout());
        JPCommand=new CommandPanel();
        JPDraw=new DrawPanel();
        contents=getContentPane();
        contents.setLayout(new BorderLayout());
        contents.add(JPCommand, BorderLayout.NORTH);
        contents.add(JPDraw, BorderLayout.CENTER);
        setVisible(true);
        JPCommand.JBline.addActionListener(this);
        JPCommand.JBcircle.addActionListener(this);
        JPCommand.JBrectangle.addActionListener(this);
        JPCommand.JBpoint.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command=e.getActionCommand();
        //System.out.println(command);
        switch(command)
        {
            case "line":
                JPDraw.setFigure(1);
                break;
            case "rectangle":
                JPDraw.setFigure(2);
                break;
            case "circle":
                JPDraw.setFigure(3);
                break;
            case "point":
                JPDraw.setFigure(4);
                break;
            default:

                break;
        }
    }
}
