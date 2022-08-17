package Modul_7.Comparable;

public class Car implements Comparable<Car> {
    private String model;
    private int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
//    public int compareTo(Car o) {
//        return 0;
//    }
/* метод по умолчанию. 0 - объекты равны между собой. Адаптируем... */
    public int compareTo(Car car) {
        if (year == car.getYear()) {
            return 0;
        }
        if (year < car.getYear()) {
            return -1;
        }
        return 1;
        /*что бы сортировать по году от большего к меньшему меняем
        местами 1 и -1 */
//    return model.compareTo(car.getModel());
    /* для сортировки по названию модели, по алфавиту */
    }
}
