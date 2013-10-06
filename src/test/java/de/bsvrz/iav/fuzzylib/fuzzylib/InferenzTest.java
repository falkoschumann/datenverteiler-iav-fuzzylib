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

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit Tests für die Inferenz auf linguistischen Termen.
 *
 * @author Falko Schumann &lt;falko.schumann@muspellheim.de&gt;
 */
public class InferenzTest {

    @Test
    public void testMin() {
        LinguistischerTerm t1 = new LinguistischerTerm("t1");
        LinguistischerTerm t2 = new LinguistischerTerm("t2", 0.3);
        LinguistischerTerm t3 = new LinguistischerTerm("t3", 0.7);

        Inferenz.min(t1, t2, t3);

        assertEquals(0.3, t1.getZugehoerigkeit(), 0.00001);
    }

    @Test
    public void testMax() {
        LinguistischerTerm t1 = new LinguistischerTerm("t1");
        LinguistischerTerm t2 = new LinguistischerTerm("t2", 0.7);
        LinguistischerTerm t3 = new LinguistischerTerm("t3", 0.3);

        Inferenz.max(t1, t2, t3);

        assertEquals(0.7, t1.getZugehoerigkeit(), 0.00001);
    }

    @Test
    public void testAlgebraischesProdukt() {
        LinguistischerTerm t1 = new LinguistischerTerm("t1");
        LinguistischerTerm t2 = new LinguistischerTerm("t2", 0.3);
        LinguistischerTerm t3 = new LinguistischerTerm("t3", 0.7);

        Inferenz.algebraischesProdukt(t1, t2, t3);

        assertEquals(0.21, t1.getZugehoerigkeit(), 0.00001);
    }

    @Test
    public void testAlgebraischesSumme() {
        LinguistischerTerm t1 = new LinguistischerTerm("t1");
        LinguistischerTerm t2 = new LinguistischerTerm("t2", 0.3);
        LinguistischerTerm t3 = new LinguistischerTerm("t3", 0.7);

        Inferenz.algebraischesSumme(t1, t2, t3);

        assertEquals(0.79, t1.getZugehoerigkeit(), 0.00001);
    }

    @Test
    public void testGammaOperator() {
        LinguistischerTerm t1 = new LinguistischerTerm("t1");
        LinguistischerTerm t2 = new LinguistischerTerm("t2", 0.3);
        LinguistischerTerm t3 = new LinguistischerTerm("t3", 0.7);

        Inferenz.gammaOperator(t1, 0.5, t2, t3);

        assertEquals(0.407308, t1.getZugehoerigkeit(), 0.00001);
    }

    @Test
    public void testKombinationVonInferenz() {
        LinguistischerTerm t1 = new LinguistischerTerm("t1");
        LinguistischerTerm t2 = new LinguistischerTerm("t2", 0.3);
        LinguistischerTerm t3 = new LinguistischerTerm("t3", 0.3);
        LinguistischerTerm t4 = new LinguistischerTerm("t4", 0.4);

        Inferenz.min(t1, Inferenz.komplement(t1, t2), Inferenz.max(t1, t3, t4));

        assertEquals(0.4, t1.getZugehoerigkeit(), 0.00001);
    }

    @Test
    public void testKomplement() {
        LinguistischerTerm t1 = new LinguistischerTerm("t1");
        LinguistischerTerm t2 = new LinguistischerTerm("t2", 0.3);

        Inferenz.komplement(t1, t2);

        assertEquals(0.7, t1.getZugehoerigkeit(), 0.00001);
    }

}
