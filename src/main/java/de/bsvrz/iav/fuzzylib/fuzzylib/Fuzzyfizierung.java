package de.bsvrz.iav.fuzzylib.fuzzylib;

/**
 * Führt die Fuzzyfizierung von Messwerten zu linguistischen Variablen durch.
 *
 * @author Falko Schumann &lt;falko.schumann@muspellheim.de&gt;
 */
public class Fuzzyfizierung {

    public LinguistischeVariable fuzzyfiziere(Basisvariable basisvariable, double wert) {
        final LinguistischeVariable result = new LinguistischeVariable();
        result.setName(basisvariable.getName());
        for (FuzzySet fs : basisvariable.getFuzzySets()) {
            result.setTerm(fuzzyfiziere(fs, wert));
        }
        return result;
    }

    private LinguistischerTerm fuzzyfiziere(FuzzySet fuzzySet, double wert) {
        LinguistischerTerm result = new LinguistischerTerm();
        result.setName(fuzzySet.getName());
        if (fuzzySet.getT1() < wert && wert < fuzzySet.getT2()) {
            // ansteigende Trapezkante, Zugehörigkeit mit Hilfe des Strahlensatzes ausrechnen
            result.setZugehoerigkeit((wert - fuzzySet.getT1()) / (fuzzySet.getT2() - fuzzySet.getT1()));
        } else if (fuzzySet.getT2() <= wert && wert <= fuzzySet.getT3()) {
            // obere Trapezkante
            result.setZugehoerigkeit(1.0);
        } else if (fuzzySet.getT3() < wert && wert < fuzzySet.getT4()) {
            // absteigende Trapezkante, Zugehörigkeit mit Hilfe des Strahlensatzes ausrechnen
            result.setZugehoerigkeit((fuzzySet.getT4() - wert) / (fuzzySet.getT4() - fuzzySet.getT3()));
        } else {
            // Wert nicht im Fuzzy-Set enthalten
            result.setZugehoerigkeit(0.0);
        }
        return result;
    }

}
