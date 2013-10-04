package de.bsvrz.iav.fuzzylib.fuzzylib;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit Test für ein Fuzzy-Set mit der Fuzzy-Funktion Trapez.
 *
 * @author Falko Schumann &lt;falko.schumann@muspellheim.de&gt;
 */
public class FuzzySetTrapezTest {

    private FuzzySet fixture;

    @Before
    public void setUp() {
        fixture = new FuzzySet("Trapez", 15, 20, 25, 30);
    }

    @Test
    public void testContains_WertVorT1() {
        assertEquals(0.0, fixture.contains(10), 0.00001);
    }

    @Test
    public void testContains_WertT1() {
        assertEquals(0.0, fixture.contains(15), 0.00001);
    }

    @Test
    public void testContains_WertZwischenT1UndT2() {
        assertEquals(0.4, fixture.contains(17), 0.00001);
    }

    @Test
    public void testContains_WertT2() {
        assertEquals(1.0, fixture.contains(20), 0.00001);
    }

    @Test
    public void testContains_WertZwischenT2UndT3() {
        assertEquals(1.0, fixture.contains(23), 0.00001);
    }

    @Test
    public void testContains_WertT3() {
        assertEquals(1.0, fixture.contains(25), 0.00001);
    }

    @Test
    public void testContains_WertZwischenT3UndT4() {
        assertEquals(0.6, fixture.contains(18), 0.00001);
    }

    @Test
    public void testContains_WertT4() {
        assertEquals(0.0, fixture.contains(30), 0.00001);
    }

    @Test
    public void testContains_WertHinterT4() {
        assertEquals(0.0, fixture.contains(40), 0.00001);
    }


}
