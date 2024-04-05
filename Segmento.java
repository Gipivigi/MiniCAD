import java.awt.*;

public class Segmento
{
    Punto puntoIniziale = null;
    Punto puntoFinale = null;
    public Segmento(Punto puntoIniziale, Punto puntoFinale)
    {
        this.puntoIniziale=puntoIniziale;
        this.puntoFinale=puntoFinale;
    }
    public Punto getPuntoIniziale()
    {
        return puntoIniziale;
    }
    public Punto getPuntoFinale()
    {
        return puntoFinale;
    }
    public void setPuntoIniziale(Punto puntoIniziale)
    {
        this.puntoIniziale=puntoIniziale;
    }
    public void setPuntoFinale(Punto puntoFinale)
    {
        this.puntoFinale=puntoFinale;
    }
}
