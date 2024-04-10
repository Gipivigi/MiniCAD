import java.awt.*;

public class Cerchio
{
    int width;
    int height;
    Punto puntoIniziale;
    int thickness;
    Color c;
    public Cerchio(int width, int height, Punto puntoIniziale, Color c, int thickness)
    {
        this.width=width;
        this.height=height;
        this.puntoIniziale=puntoIniziale;
        this.c=c;
        this.thickness=thickness;
    }
    public Cerchio(Cerchio c)
    {
        this.width=c.getWidth();
        this.height=c.getHeight();
        this.puntoIniziale=c.getPuntoIniziale();
        this.c=c.getC();
        this.thickness=c.getThickness();
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
    public int getThickness(){
        return thickness;
    }
    public void setThickness(int thickness){
        this.thickness=thickness;
    }
    public Color getC()
    {
        return c;
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
