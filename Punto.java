import java.awt.*;
import java.io.Serializable;

public class Punto implements Serializable
{
    private int x=-500;
    private int y=-500;
    private Color c;
    private int thickness;
    public Punto(int x, int y, Color c, int thickness)
    {
        this.x=x;
        this.y=y;
        this.c=c;
        this.thickness=thickness;
    }

    public Punto(Punto p)
    {
        this.x=p.getX();
        this.y=p.getY();
        this.c=p.getColor();
        this.thickness=p.getThickness();
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public Color getColor()
    {
        return c;
    }
    public int getThickness(){
        return thickness;
    }
    public void setThickness(int thickness){
        this.thickness=thickness;
    }
    public void setX(int x)
    {
        this.x=x;
    }
    public void setY(int y)
    {
        this.y=y;
    }
    public void setColor(Color c)
    {
        this.c=c;
    }
}
