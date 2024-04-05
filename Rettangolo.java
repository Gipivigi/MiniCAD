public class Rettangolo
{
    int width;
    int height;
    int puntoIniziale;
    public Rettangolo(int width, int height, int puntoIniziale)
    {
        this.width=width;
        this.height=height;
        this.puntoIniziale=puntoIniziale;
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
}
