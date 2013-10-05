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
            throw new IllegalArgumentException("Die Zugehörigkeit muss im Intervall [0,1] liegen: "
                    + zugehoerigkeit);
        this.zugehoerigkeit = zugehoerigkeit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof LinguistischerTerm) {
            LinguistischerTerm other = (LinguistischerTerm) obj;
            boolean result = true;
            result &= (name == null && other.name == null)
                    || (name != null && name.equals(other.name));
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
