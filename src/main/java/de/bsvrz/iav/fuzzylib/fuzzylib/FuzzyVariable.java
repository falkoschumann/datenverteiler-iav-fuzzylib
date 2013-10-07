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
