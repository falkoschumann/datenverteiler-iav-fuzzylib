/*
 * Funktionen Fuzzy, Intelligente Analyseverfahren (IAV)
 * Copyright (c) 2013, Falko Schumann <http://www.muspellheim.de>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *   - Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *   - Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package de.bsvrz.iav.fuzzylib.fuzzylib;

/**
 * Wertet eine Regelbasis anhand von Eingangsvariablen aus und berechnet mit Hilfe der Regeln die
 * Ausgangsvariablen.
 *
 * @author Falko Schumann &lt;falko.schumann@muspellheim.de&gt;
 */
public class Inferenz {

    /**
     * Berechnet das Minimum der Operanden und speichert es im Ergebnis. Das Minimum entspricht der
     * Schnittmenge in der Mengenlehre bzw. dem Und-Operator in der Logik. Zum Verketten von
     * Operatoren wird das Ergebnis von der Methode auch zurückgegeben.
     */
    public static LinguistischerTerm min(LinguistischerTerm ergebnis,
                                         LinguistischerTerm... operanden) {
        validiereArgumente(ergebnis, operanden);

        double min = Double.MAX_VALUE;
        for (LinguistischerTerm o : operanden)
            if (o.getZugehoerigkeit() < min)
                min = o.getZugehoerigkeit();
        ergebnis.setZugehoerigkeit(min);
        return ergebnis;
    }

    private static void validiereArgumente(LinguistischerTerm ergebnis,
                                           LinguistischerTerm[] operanden) {
        if (ergebnis == null)
            throw new NullPointerException("Der Parameter ergebnis ist null.");
        if (operanden == null)
            throw new NullPointerException("Der Parameter operanden ist null.");
        if (operanden.length < 2)
            throw new IllegalArgumentException(
                    "Es müssen mindestens zwei Operanden angegeben werden.");
    }

    /**
     * Berechnet das Maximum der Operanden und speichert es im Ergebnis. Das Maximum entspricht der
     * Vereinigung in der Mengenlehre bzw. dem Oder-Operator in der Logik. Zum Verketten von
     * Operatoren wird das Ergebnis von der Methode auch zurückgegeben.
     */
    public static LinguistischerTerm max(LinguistischerTerm ergebnis,
                                         LinguistischerTerm... operanden) {
        validiereArgumente(ergebnis, operanden);

        double max = Double.MIN_VALUE;
        for (LinguistischerTerm o : operanden)
            if (o.getZugehoerigkeit() > max)
                max = o.getZugehoerigkeit();
        ergebnis.setZugehoerigkeit(max);
        return ergebnis;
    }

    /**
     * Berechnet das algebraische Produkt der Operanden und speichert es im Ergebnis. Zum Verketten
     * von Operatoren wird das Ergebnis von der Methode auch zurückgegeben.
     */
    public static LinguistischerTerm algebraischesProdukt(LinguistischerTerm ergebnis,
                                                          LinguistischerTerm... operanden) {
        validiereArgumente(ergebnis, operanden);

        double produkt = 1.0;
        for (LinguistischerTerm o : operanden)
            produkt *= o.getZugehoerigkeit();
        ergebnis.setZugehoerigkeit(produkt);
        return ergebnis;
    }

    /**
     * Berechnet die algebraische Summe der Operanden und speichert es im Ergebnis. Zum Verketten
     * von Operatoren wird das Ergebnis von der Methode auch zurückgegeben.
     */
    public static LinguistischerTerm algebraischesSumme(LinguistischerTerm ergebnis,
                                                        LinguistischerTerm... operanden) {
        validiereArgumente(ergebnis, operanden);

        double d = 1.0;
        for (LinguistischerTerm o : operanden)
            d *= 1 - o.getZugehoerigkeit();
        ergebnis.setZugehoerigkeit(1 - d);
        return ergebnis;
    }

    /**
     * Wendet den Gamma-Operator auf die Operanden an und speichert das Resultat im Ergebnis. Der
     * Wert für Gamma muss im Intervall [0,1] liegen. Zum Verketten von Operatoren wird das Ergebnis
     * von der Methode auch zurückgegeben.
     */
    public static LinguistischerTerm gammaOperator(LinguistischerTerm ergebnis,
                                                   double gamma,
                                                   LinguistischerTerm... operanden) {
        validiereArgumente(ergebnis, gamma, operanden);

        LinguistischerTerm produkt = new LinguistischerTerm();
        algebraischesProdukt(produkt, operanden);
        LinguistischerTerm summe = new LinguistischerTerm();
        algebraischesSumme(summe, operanden);
        ergebnis.setZugehoerigkeit(Math.pow(produkt.getZugehoerigkeit(), 1.0 - gamma)
                * Math.pow(summe.getZugehoerigkeit(), gamma));

        return ergebnis;
    }

    private static void validiereArgumente(LinguistischerTerm ergebnis,
                                           double gamma,
                                           LinguistischerTerm[] operanden) {
        validiereArgumente(ergebnis, operanden);
        if (gamma < 0 || gamma > 1)
            throw new IllegalArgumentException(
                    "Der Parameter gamma muss im Intervall [0,1] liegen");
    }

    /**
     * Berechnet das Komplement des Operanden und speichert es im Ergebnis. Das Komplement
     * entspricht dem logischen Nicht-Operator. Zum Verketten von Operatoren wird das Ergebnis von
     * der Methode auch zurückgegeben.
     */
    public static LinguistischerTerm komplement(LinguistischerTerm ergebnis,
                                                LinguistischerTerm operand) {
        validiereArgumente(ergebnis, operand);

        ergebnis.setZugehoerigkeit(1 - operand.getZugehoerigkeit());
        return ergebnis;
    }

    private static void validiereArgumente(LinguistischerTerm ergebnis,
                                           LinguistischerTerm operand) {
        if (ergebnis == null)
            throw new NullPointerException("Der Parameter ergebnis ist null.");
        if (operand == null)
            throw new NullPointerException("Der Parameter operand ist null.");
    }

}
