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
