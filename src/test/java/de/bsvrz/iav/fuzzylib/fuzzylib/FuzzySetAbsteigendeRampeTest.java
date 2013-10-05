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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit Test für ein Fuzzy-Set mit der Fuzzy-Funktion aufsteigende Rampe.
 *
 * @author Falko Schumann &lt;falko.schumann@muspellheim.de&gt;
 */
public class FuzzySetAbsteigendeRampeTest {

    private FuzzySet fixture;

    @Before
    public void setUp() {
        fixture = new FuzzySet("Aufsteigende Rampe", 0, 0, 20, 30);
    }

    @Test
    public void testContains_WertVorT1() {
        assertEquals(0.0, fixture.contains(-10), 0.00001);
    }

    @Test
    public void testContains_WertT1UndT2() {
        assertEquals(1.0, fixture.contains(0), 0.00001);
    }

    @Test
    public void testContains_WertZwischenT2UndT3() {
        assertEquals(1.0, fixture.contains(15), 0.00001);
    }

    @Test
    public void testContains_WertT3() {
        assertEquals(1.0, fixture.contains(20), 0.00001);
    }

    @Test
    public void testContains_WertZwischenT3UndT4() {
        assertEquals(0.6, fixture.contains(24), 0.00001);
    }

    @Test
    public void testContains_WertT4() {
        assertEquals(0.0, fixture.contains(30), 0.00001);
    }

    @Test
    public void testContains_WertHinterT4() {
        assertEquals(0.0, fixture.contains(42), 0.00001);
    }


}
