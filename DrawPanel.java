import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DrawPanel extends JPanel implements MouseListener
{
    ArrayList<Segmento> segmentsList=new ArrayList<>();
    ArrayList<Cerchio> circlesList=new ArrayList<>();
    ArrayList<Punto> pointsList=new ArrayList<>();
    ArrayList<Rettangolo> rectanglesList=new ArrayList<>();

    public DrawPanel()
    {
        this.addMouseListener(this);
    }

    public void mouseEntered(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}
