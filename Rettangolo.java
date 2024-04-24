import java.awt.*;
import java.io.Serializable;

public class Rettangolo implements Serializable
{
    int width;
    int height;
    Punto puntoIniziale;
    Color c;
    int thickness;
    boolean fill;
    public Rettangolo(int width, int height, Punto puntoIniziale, Color c, int thickness, boolean fill)
    {

        this.fill=fill;
        this.width=width;
        this.height=height;
        this.puntoIniziale=puntoIniziale;
        this.c=c;
        this.thickness=thickness;
    }


    public Rettangolo(Rettangolo r)
    {
        this.width=r.getWidth();
        this.height=r.getHeight();
        this.puntoIniziale=r.getPuntoIniziale();
        this.c=r.getC();
        this.thickness=r.getThickness();
        this.fill=r.getFill();
    }
    public boolean getFill()
    {
        return fill;
    }
    public void setFill(boolean fill)
    {
        this.fill=fill;
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
    public Punto getPuntoIniziale()
    {
        return puntoIniziale;
    }
    public Color getC() {
        return c;
    }
    public int getThickness(){
        return thickness;
    }
    public void setThickness(int thickness){
        this.thickness=thickness;
    }
    public void setHeight(int height)
    {
        this.height = height;
    }
    public void setWidth(int width)
    {
        this.width = width;
    }
    public void setPuntoIniziale(Punto puntoIniziale)
    {
        this.puntoIniziale = puntoIniziale;
    }
    public void setC(Color c)
    {
        this.c = c;
    }
}
