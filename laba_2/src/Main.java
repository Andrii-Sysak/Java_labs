import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<House> flats = createArray();

        System.out.print("Number of room: ");
        int roomNum = input.nextInt();
        ArrayList<House> res1 = getSameFlatNum(flats, roomNum);

        System.out.print("Lower and upper flour: ");
        int lower = input.nextInt();
        int upper = input.nextInt();
        ArrayList<House> res2 = getRoomInFlour(flats, roomNum, lower, upper);

        System.out.print("Area: ");
        float area = input.nextFloat();
        ArrayList<House> res3 = getBiggerArea(flats, area);

        printArray(res1);
        printArray(res2);
        printArray(res3);
    }

    /**
     * Функція, що створює масив квартир і заносить дані допоки не буде введено нульове ID
     * @return масив квартир, що були створені
     */
    public static ArrayList<House> createArray(){
        Scanner input = new Scanner(System.in);
        ArrayList<House> flats = new ArrayList<>();
        while (true){
            House flat = new House();

            System.out.print("ID: ");
            flat.setId(input.nextInt());
            if(flat.getId() == 0)
                break;

            System.out.print("Flat number: ");
            flat.setFlatNum(input.nextInt());
            System.out.print("Area: ");
            flat.setArea(input.nextFloat());
            System.out.print("Floar: ");
            flat.setFloar(input.nextInt());
            System.out.print("Room number: ");
            flat.setRoomNum(input.nextInt());
            System.out.print("Street: ");
            input.nextLine();
            flat.setStreet(input.nextLine());
            flats.add(flat);
            System.out.println("--------------------------------------");
        }
        return flats;
    }

    /**
     * Функція для пошуку усіх квартир із заданим числом кімнат
     * @param flats масив квартир
     * @param roomNum кількість кімнат
     * @return масив із заданою кількістю кімнат
     */
    public static ArrayList<House> getSameFlatNum(ArrayList<House> flats, int roomNum){
        ArrayList<House> flatsSameRoomNum = new ArrayList<>();
        for(House el : flats)
            if(el.getRoomNum() == roomNum)
                flatsSameRoomNum.add(el);
        return flatsSameRoomNum;
    }


    /**
     * Функція для пошуку квартир із заданим числом кімнат на заданому проміжку поверхів
     * @param flats масива квартир
     * @param roomNum кількість кімнат
     * @param lower нижня межа поверхів
     * @param upper верхня межа поверхів
     * @return масив із знайденими квартирами
     */
    public static ArrayList<House> getRoomInFlour(ArrayList<House> flats, int roomNum, int lower, int upper){
        ArrayList<House> flatsInFlour = new ArrayList<>();
        for(House el : flats)
            if(el.getRoomNum() == roomNum)
                if(el.getFloar() >= lower && el.getFloar() <= upper)
                    flatsInFlour.add(el);
        return flatsInFlour;
    }

    /**
     * Функція для пошуку квартир із площею більшою за задану
     * @param flats масив квартир
     * @param area площа квартири
     * @return масив квартир з більшою площею за задану
     */
    public static ArrayList<House> getBiggerArea(ArrayList<House> flats, float area){
        ArrayList<House> flatsBiggerArea = new ArrayList<>();
        for(House el : flats)
            if(el.getArea() > area)
                flatsBiggerArea.add(el);
        return flatsBiggerArea;
    }

    public static ArrayList<House> getFlatWithArea(ArrayList<House> flats, float lower_area, float bigger_area){
        ArrayList<House> flatsWithArea = new ArrayList<>();

        for(House el : flats) {
            float area = el.getArea();
            if (area > lower_area && area < bigger_area)
                flatsWithArea.add(el);
        }
        return flatsWithArea;
    }

    /**
     * Функція для друку масива квартир
     * @param flats масив квартир
     */
    public static void printArray(ArrayList<House> flats){
        System.out.println("---------------------------------");
        for(House el : flats)
            System.out.println(el);
        System.out.println("---------------------------------");
    }
}