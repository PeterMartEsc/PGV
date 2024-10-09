package es.ies.puerto.modelo;

public class Map {
    private int positionX;

    private int positionY;


    public Map(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }



    @Override
    public String toString() {
        return "Map{" +
                "positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }
}
