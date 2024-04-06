import java.awt.*;

public class Cerchio
{
    int width;
    int height;
    int puntoIniziale;
    Color c;
    public Cerchio(int width, int height, int puntoIniziale, Color c)
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
    public int getPuntoIniziale()
    {
        return puntoIniziale;
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
    public void setPuntoIniziale(int puntoIniziale)
    {
        this.puntoIniziale = puntoIniziale;
    }
    public void setC(Color c)
    {
        this.c = c;
    }
}
