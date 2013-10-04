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

    private String name;
    private Map<String, FuzzySet> fuzzySets = new LinkedHashMap<String, FuzzySet>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null)
            throw new NullPointerException("Der Parameter name ist null.");
        this.name = name;
    }

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
        return getClass() + getName() + "(name=" + getName() + ", fuzzySets=" + getFuzzySets() + ")";
    }

}
