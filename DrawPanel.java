import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener
{
    ArrayList<Segmento> segmentsList=new ArrayList<>();
    ArrayList<Cerchio> circlesList=new ArrayList<>();
    ArrayList<Punto> pointsList=new ArrayList<>();
    ArrayList<Rettangolo> rectanglesList=new ArrayList<>();
    int figure=0, xRect=0, yRect=0;
    Boolean drawing=false;


    int x1=0, y1=0, x2=0, y2=0;

    public DrawPanel()
    {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.green);
        // Disegna un rettangolo che copre l'intera area del pannello
        g.fillRect(0, 0, getWidth(), getHeight());
        for(int i=0; i<segmentsList.size(); i++)
        {
            Segmento s=new Segmento(segmentsList.get(i).getPuntoIniziale(), segmentsList.get(i).getPuntoFinale(), segmentsList.get(i).getC());
            g.setColor(s.getC());
            g.drawLine(s.getPuntoIniziale().getX(), s.getPuntoIniziale().getY(), s.getPuntoFinale().getX(), s.getPuntoFinale().getY());
        }
        for(int i=0; i<rectanglesList.size(); i++)
        {
            Rettangolo r=new Rettangolo(rectanglesList.get(i).getWidth(),rectanglesList.get(i).getHeight(),rectanglesList.get(i).getPuntoIniziale(),Color.BLACK);
            g.setColor(r.getC());
            g.drawRect(r.getPuntoIniziale().getX(),r.getPuntoIniziale().getY(),r.getWidth(),r.getHeight());
            xRect=0;
            yRect=0;
        }

    }

    public void setFigure(int figure)
    {
        this.figure=figure;
    }


    @Override
    public void mouseEntered(MouseEvent e){}
    @Override
    public void mouseClicked(MouseEvent e)
    {

        if(e.getButton()==MouseEvent.BUTTON1)
        {
            if(!drawing)
            {
                x1=(int) e.getX();
                y1=(int) e.getY();
                x2=(int) e.getX();
                y2=(int) e.getY();
                switch(figure)
                {
                    case 1:
                        segmentsList.add(new Segmento(new Punto(x1,y1, Color.BLACK), new Punto (x2,y2, Color.BLACK), Color.BLACK));
                        drawing=true;
                        break;
                    case 2:
                        rectanglesList.add(new Rettangolo(0,0,new Punto(x1,y1,Color.BLACK),Color.BLACK));
                        System.out.println();
                        drawing=true;
                        break;
                    default:
                        break;

                }
                repaint();
            }
            else
            {
                x2=(int) e.getX();
                y2=(int) e.getY();
                switch(figure)
                {
                    case 1:
                        segmentsList.add(new Segmento(new Punto(x1,y1, Color.BLACK), new Punto (x2,y2, Color.BLACK), Color.BLACK));
                        drawing=false;
                        repaint();
                        break;
                    case 2:
                        rectanglesList.add(new Rettangolo(xRect,yRect, new Punto(x1,y1,Color.BLACK),Color.BLACK));
                        drawing=false;
                        repaint();
                        break;
                    default:
                        break;

                }

            }

        }
    }
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseDragged(MouseEvent e)
    {

    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        if(drawing)
        {
            switch (figure)
            {
                case 1:
                    x2=(int) e.getX();
                    y2=(int) e.getY();
                    if(!segmentsList.isEmpty())
                    {
                        segmentsList.remove(segmentsList.size()-1);
                    }
                    segmentsList.add(new Segmento(new Punto(x1,y1, Color.BLACK), new Punto (x2,y2, Color.BLACK), Color.BLACK));
                    repaint();
                    break;
                case 2:
                    Rettangolo r = rectanglesList.get(rectanglesList.size() - 1);
                    int width = Math.abs(x1 - e.getX());
                    int height = Math.abs(y1 - e.getY());
                    r.setWidth(width);
                    r.setHeight(height);
                    r.getPuntoIniziale().setX(Math.min(x1, e.getX()));
                    r.getPuntoIniziale().setY(Math.min(y1, e.getY()));
                    xRect=r.puntoIniziale.getX();
                    yRect=r.puntoIniziale.getY();
                    repaint();

                    break;
                default:
                    break;
            }



        }
    }
}
