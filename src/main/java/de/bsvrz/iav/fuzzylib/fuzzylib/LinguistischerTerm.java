package de.bsvrz.iav.fuzzylib.fuzzylib;

/**
 * Ein LinguistischerTerm einer linguistischen Variable.
 * <p/>
 * Die Zugehörigkeit muss im Interval [0,1] liegen.
 *
 * @author Falko Schumann &lt;falko.schumann@muspellheim.de&gt;
 */
public class LinguistischerTerm {

    private String name;
    private double zugehoerigkeit;

    public LinguistischerTerm() {
        // Standardkonstruktor
    }

    public LinguistischerTerm(String name, double zugehoerigkeit) {
        setName(name);
        setZugehoerigkeit(zugehoerigkeit);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null)
            throw new NullPointerException("Der Parameter name ist null.");
        this.name = name;
    }

    public double getZugehoerigkeit() {
        return zugehoerigkeit;
    }

    public void setZugehoerigkeit(double zugehoerigkeit) {
        if (zugehoerigkeit < 0 || zugehoerigkeit > 1)
            throw new IllegalArgumentException("Die Zugehörigkeit muss im Intervall [0,1] liegen: " + zugehoerigkeit);
        this.zugehoerigkeit = zugehoerigkeit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof LinguistischerTerm) {
            LinguistischerTerm other = (LinguistischerTerm) obj;
            boolean result = true;
            result &= (name == null && other.name == null) || (name != null && name.equals(other.name));
            result &= Double.compare(zugehoerigkeit, other.zugehoerigkeit) == 0;
            return result;
        }
        return false;
    }

    @Override
    public String toString() {
        return getName() + "=>" + getZugehoerigkeit();
    }

}
