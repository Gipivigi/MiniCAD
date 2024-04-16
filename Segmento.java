import java.awt.*;
import java.io.Serializable;

public class Segmento implements Serializable
{
    Punto puntoIniziale = null;
    Punto puntoFinale = null;
    Color c;
    int thickness;
    public Segmento(Punto puntoIniziale, Punto puntoFinale, Color c, int thickness)
    {
        this.puntoIniziale=puntoIniziale;
        this.puntoFinale=puntoFinale;
        this.c=c;
        this.thickness=thickness;
    }

    public Segmento(Segmento s)
    {
        this.puntoIniziale=s.getPuntoIniziale();
        this.puntoFinale=s.getPuntoFinale();
        this.c=s.getC();
        this.thickness=s.getThickness();
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
    public int getThickness(){
        return thickness;
    }
    public void setThickness(int thickness){
        this.thickness=thickness;
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
