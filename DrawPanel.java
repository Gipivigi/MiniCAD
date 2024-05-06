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
    Color color=Color.black, lastColor;
    Boolean drawing=false, lastRectangle=false, lastCircle=false;
    Boolean selectedLine=false, selectedCircle=false, selectedRectangle=false, lastDelete=false, selectedPoint=false;
    int indexOfLine, indexOfCircle, indexOfRectangle, indexOfPoint;
    Boolean grid=false, fill=false;
    Color gridColor=Color.black;

    int x1=0, y1=0, x2=0, y2=0;

    public DrawPanel()
    {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        setBackground(Color.WHITE);
    }
    public void setGrid(Boolean grid) {this.grid=grid;}
    public void setGridColor(Color gridColor) {this.gridColor=gridColor;}
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d=(Graphics2D) g;
        super.paintComponent(g2d);
        if(grid)
        {
            g2d.setColor(gridColor);
            for (int i = 0; i < getWidth(); i += 10) {
                g2d.drawLine(i, 0, i, getHeight());
            }
            for (int i = 0; i < getHeight(); i += 10) {
                g2d.drawLine(0, i, getWidth(), i);
            }
            repaint();
        }

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
            if(r.getFill())
                {g2d.fillRect(r.getPuntoIniziale().getX(),r.getPuntoIniziale().getY(),r.getWidth(),r.getHeight());}
            else
                {g2d.drawRect(r.getPuntoIniziale().getX(),r.getPuntoIniziale().getY(),r.getWidth(),r.getHeight());}
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
            if(c.getFill()==true)
                {g2d.fillOval(c.getPuntoIniziale().getX(),c.getPuntoIniziale().getY(),c.getWidth(),c.getHeight());}
            else
                {g2d.drawOval(c.getPuntoIniziale().getX(),c.getPuntoIniziale().getY(),c.getWidth(),c.getHeight());}
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
            g2d.fillOval(p.getX(), p.getY(), p.getThickness(),p.getThickness());
        }

    }

    public void setFigure(int figure)
    {
        this.figure=figure;
    }

    public void setThickness(int thickness)
    {
        if(!(selectedLine || selectedRectangle || selectedCircle || selectedPoint))
        {
            this.thickness=thickness;
        }

        if(selectedLine)
        {
            resetSelected();
            segmentsList.get(indexOfLine).setThickness(thickness);
            repaint();
            color=Color.BLACK;
        }

        if(selectedCircle)
        {
            resetSelected();
            circlesList.get(indexOfCircle).setThickness(thickness);
            repaint();
        }

        if(selectedRectangle)
        {
            resetSelected();
            rectanglesList.get(indexOfRectangle).setThickness(thickness);
            repaint();
        }
        if(selectedPoint)
        {
            resetSelected();
            pointsList.get(indexOfPoint).setThickness(thickness*2);
            repaint();
        }
    }

    public ArrayList<Cerchio> getCirclesList() {return circlesList;}
    public ArrayList<Punto> getPointsList(){return pointsList;}
    public ArrayList<Segmento> getSegmentsList() {return segmentsList;}
    public ArrayList<Rettangolo> getRectanglesList() {return rectanglesList;}
    public void setPointsList(ArrayList<Punto> pointsList) {this.pointsList = pointsList;}
    public void setCirclesList(ArrayList<Cerchio> circlesList) {this.circlesList = circlesList;}
    public void setSegmentsList(ArrayList<Segmento> segmentsList) {this.segmentsList = segmentsList;}
    public void setRectanglesList(ArrayList<Rettangolo> rectanglesList) {this.rectanglesList = rectanglesList;}

    public boolean selectFigure()
    {
        for(int i=0; i<segmentsList.size(); i++)
        {
            if(selectedLine || selectedRectangle || selectedCircle || selectedPoint) break;
            Segmento s=new Segmento(segmentsList.get(i));
            double xs0=s.getPuntoIniziale().getX();
            double ys0=s.getPuntoIniziale().getY();
            double xs1=s.getPuntoFinale().getX();
            double ys1=s.getPuntoFinale().getY();
            double m=(ys1-ys0)/(xs1-xs0);
            double q=ys0-m*xs0;
            if (Math.abs(y1-(m*x1+q))<=4)
            {
                if((x1>xs0 && y1>ys0 && x1<xs1 && y1<ys1) || (x1<xs0 && y1<ys0 && x1>xs1 && y1>ys1)) {
                    lastColor = segmentsList.get(i).getC();
                    segmentsList.get(i).setC(Color.CYAN);
                    selectedLine = true;
                    indexOfLine = i;
                    repaint();
                    return true;
                }
            }
        }
        for (int i=0; i<circlesList.size(); i++)
        {
            if(selectedLine || selectedRectangle || selectedCircle || selectedPoint) break;
            Cerchio c=new Cerchio(circlesList.get(i));
            int ovalCenterX=c.getPuntoIniziale().getX()+c.getWidth()/2;
            int ovalCenterY=c.getPuntoIniziale().getY()+c.getHeight()/2;
            int radius=(int)Math.sqrt(c.getWidth()*c.getWidth()/4.0+c.getHeight()*c.getHeight()/4.0);
            if (x1>=ovalCenterX-radius && x1<=ovalCenterX+radius && y1>=ovalCenterY-radius && y1<=ovalCenterY+radius)
            {
                lastColor=circlesList.get(i).getC();
                selectedCircle=true;
                indexOfCircle=i;
                circlesList.get(i).setC(Color.cyan);
                repaint();
                return true;
            }
        }
        for (int i=0; i<rectanglesList.size(); i++)
        {
            if(selectedLine || selectedRectangle || selectedCircle || selectedPoint) break;
            Rettangolo r=new Rettangolo(rectanglesList.get(i));
            int originPointX=r.getPuntoIniziale().getX();
            int originPointY=r.getPuntoIniziale().getY();
            int oppostoX=originPointX+r.getWidth();
            int oppostoY=originPointY+r.getHeight();
            if((x1 >= originPointX && x1 <= oppostoX) && (y1 >= originPointY && y1 <= oppostoY))
            {
                lastColor=rectanglesList.get(i).getC();
                selectedRectangle=true;
                indexOfRectangle=i;
                rectanglesList.get(i).setC(Color.CYAN);
                repaint();
                return true;
            }
        }
        for (int i=0; i<pointsList.size(); i++)
        {
            if(selectedLine || selectedRectangle || selectedCircle || selectedPoint) break;
            Punto p=new Punto(pointsList.get(i));
            int ovalCenterX=p.getX()+p.getThickness()/2;
            int ovalCenterY=p.getY()+p.getThickness()/2;
            int radius=(int)Math.sqrt(p.getThickness()*p.getThickness()/4.0+p.getThickness()*p.getThickness()/4.0);
            if (x1>=ovalCenterX-radius && x1<=ovalCenterX+radius && y1>=ovalCenterY-radius && y1<=ovalCenterY+radius)
            {
                lastColor=pointsList.get(i).getColor();
                selectedPoint=true;
                indexOfPoint=i;
                pointsList.get(i).setColor(Color.cyan);
                repaint();
                return true;
            }
        }

        return false;
    }
    public void setFill(boolean f)
    {
        this.fill=f;
    }
    public void setColor(Color color)
    {
        if(!(selectedLine || selectedRectangle || selectedCircle || selectedPoint ))
        {
            this.color=color;
        }

        if(selectedLine)
        {
            resetSelected();
            segmentsList.get(indexOfLine).setC(color);
            repaint();
            color=Color.BLACK;
        }

        if(selectedCircle)
        {
            resetSelected();
            circlesList.get(indexOfCircle).setC(color);
            repaint();
        }

        if(selectedRectangle)
        {
            resetSelected();
            rectanglesList.get(indexOfRectangle).setC(color);
            repaint();
        }

        if(selectedPoint)
        {
            resetSelected();
            pointsList.get(indexOfPoint).setColor(color);
            repaint();
        }
    }

    public void deleteFigure()
    {
        if(selectedLine)
        {
            segmentsList.remove(indexOfLine);
            lastDelete=true;
        }
        if(selectedCircle)
        {
            circlesList.remove(indexOfCircle);
            lastDelete=true;
        }
        if(selectedRectangle)
        {
            rectanglesList.remove(indexOfRectangle);
            lastDelete=true;
        }
        if(selectedPoint)
        {
            pointsList.remove(indexOfPoint);
            lastDelete=true;
        }
        resetSelected();
        repaint();
    }

    public void resetSelected()
    {
        if(!(lastDelete))
        {
            if (selectedLine && segmentsList.get(indexOfLine)!=null)
            {
                segmentsList.get(indexOfLine).setC(lastColor);
            }

            if (selectedCircle && circlesList.get(indexOfCircle)!=null)
            {
                circlesList.get(indexOfCircle).setC(lastColor);
            }

            if (selectedRectangle && rectanglesList.get(indexOfRectangle)!=null)
            {
                rectanglesList.get(indexOfRectangle).setC(lastColor);
            }
            if(selectedPoint && pointsList.get(indexOfPoint)!=null)
            {
                pointsList.get(indexOfPoint).setColor(lastColor);
            }
        }
        else
        {
            lastDelete=false;
        }
        selectedLine=false;
        selectedCircle=false;
        selectedRectangle=false;
        selectedPoint=false;
        repaint();
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
                    case 0:
                        if(!selectFigure())
                            resetSelected();
                        break;
                    case 1:
                        segmentsList.add(new Segmento(new Punto(x1,y1, color,0), new Punto (x2,y2, color,0), color, thickness));
                        drawing=true;
                        break;
                    case 2:
                        rectanglesList.add(new Rettangolo(0,0,new Punto(x1,y1,color,0),color, thickness, fill));
                        drawing=true;
                        break;
                    case 3:
                        circlesList.add(new Cerchio(0,0,new Punto(x1,y1,color,0),color, thickness, fill));
                        drawing=true;
                        break;
                    case 4:
                        pointsList.add(new Punto(x1-thickness,y1-thickness,color, thickness*2));
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
                        rectanglesList.add(new Rettangolo(xRect,yRect, new Punto(x1,y1,color,0),color, thickness, fill));
                        drawing=false;
                        lastRectangle=true;
                        repaint();
                        break;
                    case 3:
                        circlesList.add(new Cerchio(xCirc,yCirc, new Punto(x1,y1,color,0),color, thickness, fill));
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
