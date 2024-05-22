public class MainPump {
    public static void main(String[] arg){
        PumpR pR = new PumpR();
        PumpC pC = new PumpC();
        double pValue = 3;
        double qValue = 12;
        System.out.println("Насос 1: " + pR.calculate(pValue, qValue));
        System.out.println("Насос 2: " + pC.calculate(pValue, qValue));
    }
}

abstract class Pump{
    public abstract double h (double a);
    public abstract double k (double a);
    public double calculate(double a, double b){
        return h(a) * k(b) + 1.25;
    }
}

class PumpR extends Pump{

    @Override
    public double h(double a) {
        return Math.pow(a, 2) + 3 * a + 5;
    }

    @Override
    public double k(double a) {
        return Math.sqrt(2*a);
    }
}

class PumpC extends Pump{

    @Override
    public double h(double a) {
        return Math.log(a*5) + 7 * a + 1;
    }

    @Override
    public double k(double a) {
        return Math.log10(a*4);
    }
}