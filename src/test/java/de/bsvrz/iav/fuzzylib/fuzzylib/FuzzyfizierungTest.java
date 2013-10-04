package de.bsvrz.iav.fuzzylib.fuzzylib;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit Test für die Fuzzyfizierung.
 * <p/>
 * Im Test wird der Messwert der Temperatur im Wertebereich von 0 bis 100 °C fuzzyfiziert.
 *
 * @author Falko Schumann &lt;falko.schumann@muspellheim.de&gt;
 */
public class FuzzyfizierungTest {

    private Fuzzyfizierung fixture;
    private Basisvariable basisvariable;

    @Before
    public void setUp() {
        fixture = new Fuzzyfizierung();

        basisvariable = new Basisvariable();
        basisvariable.setFuzzySet(new FuzzySet("kalt", 0, 0, 15, 20));
        basisvariable.setFuzzySet(new FuzzySet("warm", 15, 20, 25, 30));
        basisvariable.setFuzzySet(new FuzzySet("heiß", 25, 30, 100, 100));
    }

    @Test
    public void test0() {
        double messwert = 0;
        final LinguistischeVariable actual = fixture.fuzzyfiziere(basisvariable, messwert);

        LinguistischeVariable expected = new LinguistischeVariable();
        expected.setTerm(new LinguistischerTerm("kalt", 1.0));
        expected.setTerm(new LinguistischerTerm("warm", 0.0));
        expected.setTerm(new LinguistischerTerm("heiß", 0.0));
        assertEquals(expected, actual);
    }

    @Test
    public void test15() {
        double messwert = 15;
        final LinguistischeVariable actual = fixture.fuzzyfiziere(basisvariable, messwert);

        LinguistischeVariable expected = new LinguistischeVariable();
        expected.setTerm(new LinguistischerTerm("kalt", 1.0));
        expected.setTerm(new LinguistischerTerm("warm", 0.0));
        expected.setTerm(new LinguistischerTerm("heiß", 0.0));
        assertEquals(expected, actual);
    }

    @Test
    public void test17() {
        double messwert = 17;
        final LinguistischeVariable actual = fixture.fuzzyfiziere(basisvariable, messwert);

        LinguistischeVariable expected = new LinguistischeVariable();
        expected.setTerm(new LinguistischerTerm("kalt", 0.6));
        expected.setTerm(new LinguistischerTerm("warm", 0.4));
        expected.setTerm(new LinguistischerTerm("heiß", 0.0));
        assertEquals(expected, actual);
    }


    @Test
    public void test20() {
        double messwert = 20;
        final LinguistischeVariable actual = fixture.fuzzyfiziere(basisvariable, messwert);

        LinguistischeVariable expected = new LinguistischeVariable();
        expected.setTerm(new LinguistischerTerm("kalt", 0.0));
        expected.setTerm(new LinguistischerTerm("warm", 1.0));
        expected.setTerm(new LinguistischerTerm("heiß", 0.0));
        assertEquals(expected, actual);
    }

    @Test
    public void test25() {
        double messwert = 25;
        final LinguistischeVariable actual = fixture.fuzzyfiziere(basisvariable, messwert);

        LinguistischeVariable expected = new LinguistischeVariable();
        expected.setTerm(new LinguistischerTerm("kalt", 0.0));
        expected.setTerm(new LinguistischerTerm("warm", 1.0));
        expected.setTerm(new LinguistischerTerm("heiß", 0.0));
        assertEquals(expected, actual);
    }

    @Test
    public void test28() {
        double messwert = 28;
        final LinguistischeVariable actual = fixture.fuzzyfiziere(basisvariable, messwert);

        LinguistischeVariable expected = new LinguistischeVariable();
        expected.setTerm(new LinguistischerTerm("kalt", 0.0));
        expected.setTerm(new LinguistischerTerm("warm", 0.4));
        expected.setTerm(new LinguistischerTerm("heiß", 0.6));
        assertEquals(expected, actual);
    }


    @Test
    public void test30() {
        double messwert = 30;
        final LinguistischeVariable actual = fixture.fuzzyfiziere(basisvariable, messwert);

        LinguistischeVariable expected = new LinguistischeVariable();
        expected.setTerm(new LinguistischerTerm("kalt", 0.0));
        expected.setTerm(new LinguistischerTerm("warm", 0.0));
        expected.setTerm(new LinguistischerTerm("heiß", 1.0));
        assertEquals(expected, actual);
    }

    @Test
    public void test100() {
        double messwert = 100;
        final LinguistischeVariable actual = fixture.fuzzyfiziere(basisvariable, messwert);

        LinguistischeVariable expected = new LinguistischeVariable();
        expected.setTerm(new LinguistischerTerm("kalt", 0.0));
        expected.setTerm(new LinguistischerTerm("warm", 0.0));
        expected.setTerm(new LinguistischerTerm("heiß", 1.0));
        assertEquals(expected, actual);
    }

}
