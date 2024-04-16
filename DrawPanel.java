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
    int figure=0, thickness= 1, xRect=0, yRect=0, xCirc=0, yCirc=0;
    Color color=Color.black;
    Boolean drawing=false, lastRectangle=false, lastCircle=false;


    int x1=0, y1=0, x2=0, y2=0;

    public DrawPanel()
    {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2d=(Graphics2D) g;
        super.paintComponent(g2d);

        for(int i=0; i<segmentsList.size(); i++)
        {
            Segmento s=new Segmento(segmentsList.get(i));
            g2d.setStroke(new BasicStroke(s.getThickness()));
            g2d.setColor(s.getC());
            g2d.drawLine(s.getPuntoIniziale().getX(), s.getPuntoIniziale().getY(), s.getPuntoFinale().getX(), s.getPuntoFinale().getY());
        }
        for(int i=0; i<rectanglesList.size(); i++)
        {
            Rettangolo r=new Rettangolo(rectanglesList.get(i));
            g2d.setStroke(new BasicStroke(r.getThickness()));
            g2d.setColor(r.getC());
            g2d.drawRect(r.getPuntoIniziale().getX(),r.getPuntoIniziale().getY(),r.getWidth(),r.getHeight());
            xRect=0;
            yRect=0;
            if(drawing==false && lastRectangle==true)
                {
                    rectanglesList.remove(rectanglesList.size()-1);
                    lastRectangle=false;
                }
        }
        for(int i=0; i<circlesList.size(); i++)
        {
            Cerchio c=new Cerchio(circlesList.get(i));
            g2d.setStroke(new BasicStroke(c.getThickness()));
            g2d.setColor(c.getC());
            g2d.drawOval(c.getPuntoIniziale().getX(),c.getPuntoIniziale().getY(),c.getWidth(),c.getHeight());
            xCirc=0;
            yCirc=0;
            if(drawing==false && lastCircle==true)
            {
                circlesList.remove(circlesList.size()-1);
                lastCircle=false;
            }
        }
        for (int i=0; i<pointsList.size(); i++)
        {
            Punto p=new Punto(pointsList.get(i));
            g2d.setColor(p.getColor());
            g2d.fillOval(p.getX(), p.getY(), 10,10);
        }

    }

    public void setFigure(int figure)
    {
        this.figure=figure;
    }

    public void setThickness(int thickness)
    {
        this.thickness=thickness;
    }

    public ArrayList<Cerchio> getCirclesList() {return circlesList;}
    public ArrayList<Punto> getPointsList(){return pointsList;}
    public ArrayList<Segmento> getSegmentsList() {return segmentsList;}
    public ArrayList<Rettangolo> getRectanglesList() {return rectanglesList;}
    public void setPointsList(ArrayList<Punto> pointsList) {this.pointsList = pointsList;}
    public void setCirclesList(ArrayList<Cerchio> circlesList) {this.circlesList = circlesList;}
    public void setSegmentsList(ArrayList<Segmento> segmentsList) {this.segmentsList = segmentsList;}
    public void setRectanglesList(ArrayList<Rettangolo> rectanglesList) {this.rectanglesList = rectanglesList;}

    public void selectFigure()
    {
        for(int i=0; i<segmentsList.size(); i++)
        {
            Segmento s=new Segmento(segmentsList.get(i));
            if (x1>=Math.min(s.getPuntoIniziale().getX(), s.getPuntoFinale().getX()) && x1<=Math.max(s.getPuntoIniziale().getX(), s.getPuntoFinale().getX()) &&  y1>=Math.min(s.getPuntoIniziale().getY(), s.getPuntoFinale().getY()) && y1<=Math.max(s.getPuntoIniziale().getY(), s.getPuntoFinale().getY()))
            {
                segmentsList.get(i).setC(Color.cyan);
                break;
            }
        }
        repaint();
    }
    public void setColor(Color color){this.color=color;}

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
                    case 0:
                        selectFigure();
                        break;
                    case 1:
                        segmentsList.add(new Segmento(new Punto(x1,y1, color,0), new Punto (x2,y2, color,0), color, thickness));
                        drawing=true;
                        break;
                    case 2:
                        rectanglesList.add(new Rettangolo(0,0,new Punto(x1,y1,color,0),color, thickness));
                        drawing=true;
                        break;
                    case 3:
                        circlesList.add(new Cerchio(0,0,new Punto(x1,y1,color,0),color, thickness));
                        drawing=true;
                        break;
                    case 4:
                        pointsList.add(new Punto(x1-5,y1-5,color, thickness));
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
                        if(!segmentsList.isEmpty())
                        {
                            segmentsList.remove(segmentsList.size()-1);
                        }
                        segmentsList.add(new Segmento(new Punto(x1,y1, color,0), new Punto (x2,y2, color,0), color, thickness));
                        drawing=false;
                        repaint();
                        break;
                    case 2:
                        rectanglesList.add(new Rettangolo(xRect,yRect, new Punto(x1,y1,color,0),color, thickness));
                        drawing=false;
                        lastRectangle=true;
                        repaint();
                        break;
                    case 3:
                        circlesList.add(new Cerchio(xCirc,yCirc, new Punto(x1,y1,color,0),color, thickness));
                        drawing=false;
                        lastCircle=true;
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
                    segmentsList.add(new Segmento(new Punto(x1,y1,color,0), new Punto (x2,y2, color,0), color, thickness));
                    repaint();
                    break;
                case 2:
                    Rettangolo r = rectanglesList.get(rectanglesList.size() - 1);
                    int widthRect = Math.abs(x1 - e.getX());
                    int heightRect = Math.abs(y1 - e.getY());
                    r.setWidth(widthRect);
                    r.setHeight(heightRect);
                    r.getPuntoIniziale().setX(Math.min(x1, e.getX()));
                    r.getPuntoIniziale().setY(Math.min(y1, e.getY()));
                    xRect=r.puntoIniziale.getX();
                    yRect=r.puntoIniziale.getY();
                    repaint();
                    break;
                case 3:
                    Cerchio c = circlesList.get(circlesList.size() - 1);
                    int widthCirc = Math.abs(x1 - e.getX());
                    int heightCirc = Math.abs(y1 - e.getY());
                    c.setWidth(widthCirc);
                    c.setHeight(heightCirc);
                    c.getPuntoIniziale().setX(Math.min(x1, e.getX()));
                    c.getPuntoIniziale().setY(Math.min(y1, e.getY()));
                    xCirc=c.puntoIniziale.getX();
                    yCirc=c.puntoIniziale.getY();
                    repaint();
                    break;

                default:
                    break;
            }
        }
    }
}
