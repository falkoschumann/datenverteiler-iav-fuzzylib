package de.bsvrz.iav.fuzzylib.fuzzylib;

/**
 * Führt die Fuzzyfizierung von Messwerten zu linguistischen Variablen durch.
 *
 * @author Falko Schumann &lt;falko.schumann@muspellheim.de&gt;
 */
public class Fuzzyfizierung {

    public LinguistischeVariable fuzzyfiziere(Basisvariable basisvariable, double wert) {
        final LinguistischeVariable result = new LinguistischeVariable();
        for (FuzzySet fs : basisvariable.getFuzzySets()) {
            result.setTerm(new LinguistischerTerm(fs.getName(), fs.contains(wert)));
        }
        return result;
    }

}
