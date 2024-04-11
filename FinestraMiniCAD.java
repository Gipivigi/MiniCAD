import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinestraMiniCAD extends JFrame implements ActionListener
{
    CommandPanel JPCommand;
    DrawPanel JPDraw;
    DrawOptionPanel JPOption;
    Container contents;
    Color selectedColor;
    boolean line=false, circle=false, rectangle=false, point=false;
    public FinestraMiniCAD()
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getContentPane().setLayout(new BorderLayout());
        JPCommand=new CommandPanel();
        JPDraw=new DrawPanel();
        JPOption= new DrawOptionPanel();
        contents=getContentPane();
        contents.setLayout(new BorderLayout());
        contents.add(JPCommand, BorderLayout.NORTH);
        contents.add(JPDraw, BorderLayout.CENTER);
        contents.add(JPOption, BorderLayout.SOUTH);
        setVisible(true);
        JPCommand.JBCursor.addActionListener(this);
        JPCommand.JBline.addActionListener(this);
        JPCommand.JBcircle.addActionListener(this);
        JPCommand.JBrectangle.addActionListener(this);
        JPCommand.JBpoint.addActionListener(this);
        JPCommand.JBselectColor.addActionListener(this);
        JPOption.JBThickness1.addActionListener(this);
        JPOption.JBThickness2.addActionListener(this);
        JPOption.JBThickness3.addActionListener(this);
        JPOption.JBThickness4.addActionListener(this);
        JPOption.JBThickness5.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command=e.getActionCommand();
        //System.out.println(command);
        switch(command)
        {
            case "cursor":
                JPDraw.setFigure(0);
                break;
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
            case"thickness_1":
                JPDraw.setThickness(1);
                break;
            case"thickness_2":
                JPDraw.setThickness(2);
                break;
            case"thickness_3":
                JPDraw.setThickness(3);
                break;
            case"thickness_4":
                JPDraw.setThickness(4);
                break;
            case"thickness_5":
                JPDraw.setThickness(5);
                break;
            case "selectColor":
                selectedColor = JColorChooser.showDialog(null, "Seleziona un colore", Color.BLACK);
                JPDraw.setColor(selectedColor);
                break;
            default:

                break;
        }
    }
}
