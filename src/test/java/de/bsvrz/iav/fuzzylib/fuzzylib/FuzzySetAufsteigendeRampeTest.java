package de.bsvrz.iav.fuzzylib.fuzzylib;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit Test für ein Fuzzy-Set mit der Fuzzy-Funktion absteigende Rampe.
 *
 * @author Falko Schumann &lt;falko.schumann@muspellheim.de&gt;
 */
public class FuzzySetAufsteigendeRampeTest {

    private FuzzySet fixture;

    @Before
    public void setUp() {
        fixture = new FuzzySet("Absteigende Rampe", 60, 80, 100, 100);
    }

    @Test
    public void testContains_WertVorT1() {
        assertEquals(0.0, fixture.contains(42), 0.00001);
    }

    @Test
    public void testContains_WertT1() {
        assertEquals(0.0, fixture.contains(60), 0.00001);
    }

    @Test
    public void testContains_WertZwischenT1UndT2() {
        assertEquals(0.3, fixture.contains(66), 0.00001);
    }

    @Test
    public void testContains_WertT2() {
        assertEquals(1.0, fixture.contains(80), 0.00001);
    }

    @Test
    public void testContains_WertZwischenT2UndT3() {
        assertEquals(1.0, fixture.contains(88), 0.00001);
    }

    @Test
    public void testContains_WertT3UndT4() {
        assertEquals(1.0, fixture.contains(100), 0.00001);
    }

    @Test
    public void testContains_WertHinterT4() {
        assertEquals(0.0, fixture.contains(111), 0.00001);
    }


}
