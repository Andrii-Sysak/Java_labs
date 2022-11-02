public class House {
    private int id;
    private int flatNum;
    private float area;
    private int floar;
    private int roomNum;
    private String street;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlatNum() {
        return flatNum;
    }

    public void setFlatNum(int flatNum) {
        this.flatNum = flatNum;
    }

    public int getFloar() { return floar; }

    public void setFloar(int floar) {
        this.floar = floar;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) { this.roomNum = roomNum; }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", flatNum=" + flatNum +
                ", area=" + area +
                ", floar=" + floar +
                ", roomNum=" + roomNum +
                ", street='" + street + '\'' +
                '}';
    }
}
