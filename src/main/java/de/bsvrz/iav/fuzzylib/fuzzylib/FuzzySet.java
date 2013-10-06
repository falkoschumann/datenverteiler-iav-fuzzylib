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
 * <li>Sonderfall Trapez über Wertebereichsgrenzen: z.B. Norden bei der Windrichtung; hier liegen
 * der erste und zweite Punkt hinter den dritten und vierten Punkt; der erste Punkt und der vierte
 * Punkt haben die Zugehörigkeit 0, der zweite und dritte Punkt haben die Zugehörigkeit 1.</li>
 * </ul>
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

    /**
     * Prüft ob der übergebene Wert im Fuzy-Set enthalten ist. Zurückgeben wird die Zugehörigkeit
     * des Wertes zum Fuzzy-Set. Die Zugehörigkeit ist eine Zahl im Intervall [0,1], wobei 0 für
     * nicht enthalten und 1 für enthalten steht.
     */
    public double contains(double wert) {
        if (isTrapez()) {
            return containsTrapez(wert);
        }

        throw new IllegalStateException("Das Fuzzy-Set ist ungültig: " + toString());
    }

    private boolean isTrapez() {
        return t1 <= t2 && t2 <= t3 && t3 <= t4;
    }

    private double containsTrapez(double wert) {
        if (t1 < wert && wert < t2) {
            // ansteigende Trapezkante, Zugehörigkeit mit Hilfe des Strahlensatzes ausrechnen
            return (wert - t1) / (t2 - t1);
        } else if (t2 <= wert && wert <= t3) {
            // obere Trapezkante
            return 1.0;
        } else if (t3 < wert && wert < t4) {
            // absteigende Trapezkante, Zugehörigkeit mit Hilfe des Strahlensatzes ausrechnen
            return (t4 - wert) / (t4 - t3);
        }

        // Wert nicht im Fuzzy-Set enthalten
        return 0.0;
    }


    @Override
    public String toString() {
        return getName() + "{t1=" + getT1() + ", t2=" + getT2() + ", t3=" + getT3() + ", t4="
                + getT4() + "}";
    }

}
