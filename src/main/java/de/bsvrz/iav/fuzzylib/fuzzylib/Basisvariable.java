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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Eine Basisvariable fasst die Fuzzy-Sets mit denen eine linguistische Variabe gebildet wird
 * zusammen.
 *
 * @author Falko Schumann &lt;falko.schumann@muspellheim.de&gt;
 */
public class Basisvariable {

    // TODO Wird ein Wertebereich benötigt? (z.B. für Norden?)
    // TODO Wie soll eine Definitionslücke erkannt werden? (IAV-38)

    private Map<String, FuzzySet> fuzzySets = new LinkedHashMap<String, FuzzySet>();

    public List<FuzzySet> getFuzzySets() {
        return new ArrayList<FuzzySet>(fuzzySets.values());
    }

    public void setFuzzySets(List<FuzzySet> fuzzySets) {
        if (fuzzySets == null)
            throw new NullPointerException("Der Parameter fuzzySets ist null");
        for (FuzzySet fs : fuzzySets)
            this.fuzzySets.put(fs.getName(), fs);
    }

    public void setFuzzySet(FuzzySet fuzzySet) {
        if (fuzzySet == null)
            throw new NullPointerException("Der Parameter fuzzySet ist null.");
        fuzzySets.put(fuzzySet.getName(), fuzzySet);
    }

    @Override
    public String toString() {
        return getClass().getName() + "(fuzzySets=" + getFuzzySets() + ")";
    }

}
