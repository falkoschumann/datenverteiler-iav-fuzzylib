package de.bsvrz.iav.fuzzylib.fuzzylib;

/**
 * Ein Fuzzy-Set (unscharfe Menge) wird durch die Fuzzy-Funktion Trapez beschrieben.
 * <p/>
 * Die Trapezfunktion wird durch vier aufsteigende Punkte im Wertebereich des Messwertes definiert.
 * Der erste und letzte Punkt hat die Zugehörigkeit 0 und der zweite und dritte Punkt hat die
 * Zugehörigkeit 1.
 * <p/>
 * Neben dem Trapez selbst werden folgende Spezialfälle des Trapzes häufig verwendet:
 * <ul>
 * <li>Dreieck: der erste und letzte Punkt haben die Zugehörigkeit 0, der zweite und dritte Punkt
 * sind identisch und haben die Zugehörigkeit 1</li>
 * <li>Aufsteigende Rampe: der erste Punkt hat die Zugehörigkeit 0, der zweite Punkt hat die
 * Zugehörigkeit 1, der dritte und vierte Punkt sind identisch und haben die Zugehörigkeit 1</li>
 * <li>Absteigende Rampe: der erste und zweite Punkt sind identisch und haben die Zugehörigkeit 1,
 * der dritte Punkt hat die Zugehörigkeit 1, der vierte Punkt hat die Zugehörigkeit 0</li>
 * </ul>
 * TODO Trapez über Wertebereichsgrenzen z.B. Norden bei der Windrichtung
 * TODO Fuzzy-Funktionen mit Bild verdeutlichen
 *
 * @author Falko Schumann &lt;falko.schumann@muspellheim.de&gt;
 */
public class FuzzySet {

    private String name;
    private double t1;
    private double t2;
    private double t3;
    private double t4;

    public FuzzySet() {
        // Standardkonstruktor
    }

    public FuzzySet(String name, double t1, double t2, double t3, double t4) {
        setName(name);
        setT1(t1);
        setT2(t2);
        setT3(t3);
        setT4(t4);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null)
            throw new NullPointerException("Der Parameter name ist null.");
        this.name = name;
    }

    public double getT1() {
        return t1;
    }

    public void setT1(double t1) {
        this.t1 = t1;
    }

    public double getT2() {
        return t2;
    }

    public void setT2(double t2) {
        this.t2 = t2;
    }

    public double getT3() {
        return t3;
    }

    public void setT3(double t3) {
        this.t3 = t3;
    }

    public double getT4() {
        return t4;
    }

    public void setT4(double t4) {
        this.t4 = t4;
    }

    @Override
    public String toString() {
        return getClass().getName() + "(name=" + getName() + ", t1=" + getT1() + ", t2=" + getT2() + ", t3=" + getT3() + ", t4=" + getT4() + ")";
    }

}
