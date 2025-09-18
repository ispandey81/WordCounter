package org.indra.rules.impl;

import org.indra.rules.RuleStrategy;

public class LongWordRule implements RuleStrategy {
    @Override
    public String getName() {
        return "Longer than 5 characters";
    }

    @Override
    public boolean matches(String word) {
        return word.length() > 5;
    }
}

