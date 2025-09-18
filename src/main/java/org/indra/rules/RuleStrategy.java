package org.indra.rules;

public interface RuleStrategy {
    String getName();
    boolean matches(String word);
}

