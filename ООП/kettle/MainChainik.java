import java.util.Scanner;

public class MainChainik {
    static Tap tap = new Tap();
    static Kettle kettle = new Kettle();
    static Matches matches = new Matches();
    static GasStove stove = new GasStove();
    static int choice;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Выберите свой путь:\n1. Первый случай\n2. Второй случай\n0. Конец");
            choice = scanner.nextInt();
            switch (choice){
                case 0:
                    System.out.println("Конец");
                    Runtime.getRuntime().exit(0);
                case 1:
                    System.out.println("Вы выбрали путь 1");
                    makeSomeTeaFirst();
                    break;
                case 2:
                    System.out.println("Вы выбрали путь 2");
                    makeSomeTeaSecond();
                    break;
                default:
                    System.out.println("Плохой выбор");
                    break;
            }
        } while(choice != 0);
        scanner.close();
    }

    public static void makeSomeTeaFirst(){
        tap.open();
        kettle.fill(tap);
        tap.close();
        kettle.putOnStove();
        matches.lightUp();
        stove.turnOn(matches);
        matches.putOut();
        stove.heat(kettle);
        stove.turnOff();
        return;
    }

    public static void makeSomeTeaSecond(){
        System.out.println("*** Второй случай ***");
        kettle.empty();

        kettle.putDownStove();

        makeSomeTeaFirst();
    }
}

class Matches {
    public boolean isLight;

    public void lightUp(){
        if(!isLight){
            System.out.println("Успешно зажгли спичку");
            isLight = true;
        } else{
            System.out.println("Спичка уже горит");
        }
    }

    public void putOut(){
        if(isLight){
            System.out.println("Успешно потушили спичку");
            isLight = false;
        } else{
            System.out.println("Спичка еще не горит");
        }
    }
}

class Tap {

    public boolean isOpen;

    public void open(){
        if(isOpen){
            System.out.println("Кран уже открыт");
        }
        else{
            isOpen = true;
            System.out.println("Кран открыт");
        }
    }

    public void close(){
        if(isOpen){
            isOpen = false;
            System.out.println("Кран закрыт");
        }
        else{
            System.out.println("Кран уже закрыт");
        }
    }
}

class Kettle {
    public boolean isFull;
    public boolean isBoiled;
    public boolean isOnStove;
    public int timeSec = 3;


    public void empty(){
        if(isFull){
            isFull = false;
            System.out.println("Выливаем воду из чайника...");
            for(int i = 0; i < timeSec; i++){
                try {
                    System.out.println("Чайник опустошится через " + i + " сек...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("В чайнике теперь нет воды");
        } else{
            System.out.println("Вода не найдена в чайнике, возможно он пустой");
        }

    }

    public void fill(Tap tap){
        if(tap.isOpen && !isFull){
            isFull = true;
            System.out.println("Наполнение чайника...");
            for(int i = 0; i < timeSec; i++){
                try {
                    System.out.println("Чайник наполнится через " + i + " сек...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Чайник наполнен успешно!");
        } else{
            System.out.println("Ошибка при наполнении: Вы забыли открыть кран или чайник уже полный...");
        }
    }

    public void putOnStove(){
        if(!isOnStove){
            System.out.println("Чайник успешно оказался на плите");
            isOnStove = true;
        } else{
            System.out.println("Чайник уже на плите");
        }
    }

    public void putDownStove(){
        if(isOnStove){
            System.out.println("Чайник успешно убран с плиты");
            isOnStove = false;
        } else{
            System.out.println("Чайник уже на не плите");
        }
    }
}

class GasStove {
    public boolean isOn;
    public boolean isBurning;
    public boolean warning;
    private final int timeSec = 10;


    public void turnOn(Matches matches) {
        isOn = true;
        if (matches.isLight) {
            isBurning = true;
            System.out.println("Газовая плита успешно зажглась");
        } else {
            warning = true;
            System.out.println("Скорее выключите газ! Спички не горят");
        }
    }

    public void turnOff() {
        if (isOn && isBurning) {
            isBurning = false;
            System.out.println("Газовая плита выключена");
        } else if (warning) {
            System.out.println("Больше так не делайте! Сначала зажгите спичку");
        } else {
            System.out.println("Газовая плита еще не включена");
        }
    }

    public void heat(Kettle kettle) {
        if (isOn && kettle.isFull) {
            System.out.println("Кипечение воды...");
            for (int i = 0; i < timeSec; i++) {
                try {
                    System.out.println("Вода вскипит через " + i + " сек...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Вода вскипела успешно!");
            kettle.isBoiled = true;
        } else if (!isOn) {
            System.out.println("Сначала включите и зажгите плиту!");
        } else {
            System.out.println("А воды-то в чайнике нет..");
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("Пожар через " + i + " сек...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Вы проиграли огню");
            return;
        }

    }
}

