package flyingObjects;

public class SpecialItem extends FlyObject implements moveModel{

    public int id = 0;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void moveDown(){
        y+=speed;
    }
    public void moveLeft(){
        x-=speed;
    }
    public void moveRight(){
        x+=speed;
    }
    public void moveUp(){
        y-=speed;
    }
    public void moveR45D(){ moveDown();x+= 10; }
    public void moveL45D(){ moveDown();x-= 10; }
    public void moveR30D(){ moveDown();x+= 5; }
    public void moveL30D(){ moveDown();x-= 5; }
    public void moveR45U() {

    }
    public void moveL45U() {

    }
    public void moveR30U() {

    }
    public void moveL30U() {

    }

}
