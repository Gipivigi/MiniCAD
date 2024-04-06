import java.awt.*;

public class Segmento
{
    Punto puntoIniziale = null;
    Punto puntoFinale = null;
    Color c;
    public Segmento(Punto puntoIniziale, Punto puntoFinale, Color c)
    {
        this.puntoIniziale=puntoIniziale;
        this.puntoFinale=puntoFinale;
        this.c=c;
    }
    public Punto getPuntoIniziale()
    {
        return puntoIniziale;
    }
    public Punto getPuntoFinale()
    {
        return puntoFinale;
    }
    public Color getC()
    {
        return c;
    }
    public void setPuntoIniziale(Punto puntoIniziale)
    {
        this.puntoIniziale=puntoIniziale;
    }
    public void setPuntoFinale(Punto puntoFinale)
    {
        this.puntoFinale=puntoFinale;
    }
    public void setC(Color c)
    {
        this.c = c;
    }
}
