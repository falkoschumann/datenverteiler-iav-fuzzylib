package de.bsvrz.iav.fuzzylib.fuzzylib;

import java.util.ArrayList;
import java.util.List;

/**
 * Definierte eine Fuzzy-Variable bestehend aus dem Namen der Basisvariable, den dazugehörigen
 * Termen und den Zyklus auf den sie sich bezieht.
 * <p/>
 * Der Zyklus ist eine positive Zahl im Intervall [0,127]. Die 0 steht für den aktuellen Zyklus, die
 * 1 für den letzten, die 2 für den vorletzte, die 3 für den vorvorletzten usw.
 *
 * @author Falko Schumann &lt;falko.schumann@muspellheim.de&gt;
 */
public class FuzzyVariable {

    // TODO Es fehlt ein Flag für die Verneinung

    private String variable;
    private byte zyklus;
    private List<String> term = new ArrayList<String>();

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public byte getZyklus() {
        return zyklus;
    }

    public void setZyklus(byte zyklus) {
        this.zyklus = zyklus;
    }

    public List<String> getTerm() {
        return term;
    }

    public void setTerm(List<String> term) {
        this.term = term;
    }

}
