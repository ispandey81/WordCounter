package org.indra.rules.impl;

import org.indra.rules.RuleStrategy;

public class StartsWithMRule implements RuleStrategy {
    @Override
    public String getName() {
        return "Starts with M/m";
    }

    @Override
    public boolean matches(String word) {
        return word.startsWith("M") || word.startsWith("m");
    }
}