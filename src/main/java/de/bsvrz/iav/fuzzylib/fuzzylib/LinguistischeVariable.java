package de.bsvrz.iav.fuzzylib.fuzzylib;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Eine linguistische Variable wird durch Terme wie "hoch" und "niedrig" anstelle von diskreten
 * Zahlen definiert.
 *
 * @author Falko Schumann &lt;falko.schumann@muspellheim.de&gt;
 */
public class LinguistischeVariable {

    private Map<String, LinguistischerTerm> terme = new LinkedHashMap<String, LinguistischerTerm>();

    public List<LinguistischerTerm> getTerme() {
        return new ArrayList<LinguistischerTerm>(terme.values());
    }

    public void setTerme(List<LinguistischerTerm> terme) {
        if (terme == null)
            throw new NullPointerException("Der Parameter terme ist null.");
        for (LinguistischerTerm t : terme)
            this.terme.put(t.getName(), t);
    }

    public void setTerm(LinguistischerTerm term) {
        if (term == null)
            throw new NullPointerException("Der Parameter term ist null.");
        terme.put(term.getName(), term);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof LinguistischeVariable) {
            LinguistischeVariable other = (LinguistischeVariable) obj;
            return terme.equals(other.terme);
        }

        return false;
    }

    @Override
    public String toString() {
        return getClass().getName() + "(terme=" + getTerme() + ")";
    }

}
