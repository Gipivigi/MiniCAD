import java.awt.*;

public class Rettangolo
{
    int width;
    int height;
    Punto puntoIniziale;
    Color c;
    public Rettangolo(int width, int height, Punto puntoIniziale, Color c)
    {
        this.width=width;
        this.height=height;
        this.puntoIniziale=puntoIniziale;
        this.c=c;
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
