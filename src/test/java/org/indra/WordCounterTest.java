package org.indra;

import org.indra.rules.RuleStrategy;
import org.indra.rules.impl.LongWordRule;
import org.indra.rules.impl.StartsWithMRule;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class WordCounterTest {

    @Test
    void testStartsWithMRule() {
        String[] words = {"Mike", "john", "Mary", "apple", "manhattan"};
        List<RuleStrategy> rules = List.of(new StartsWithMRule());

        Map<String, List<String>> results = WordCounter.applyRules(rules, words);

        List<String> matched = results.get("Starts with M/m");
        assertNotNull(matched);
        assertEquals(List.of("Mike", "Mary", "manhattan"), matched);
    }

    @Test
    void testLongWordRule() {
        String[] words = {"short", "elephant", "banana", "tiny", "magnificent"};
        List<RuleStrategy> rules = List.of(new LongWordRule());

        Map<String, List<String>> results = WordCounter.applyRules(rules, words);

        List<String> matched = results.get("Longer than 5 characters");
        assertNotNull(matched);
        assertEquals(List.of("elephant", "banana", "magnificent"), matched);
    }

    @Test
    void testMultipleRules() {
        String[] words = {"Mike", "Mary", "apple", "magnificent", "bob"};
        List<RuleStrategy> rules = List.of(new StartsWithMRule(), new LongWordRule());

        Map<String, List<String>> results = WordCounter.applyRules(rules, words);

        assertEquals(List.of("Mike", "Mary", "magnificent"), results.get("Starts with M/m"));
        assertEquals(List.of("magnificent"), results.get("Longer than 5 characters"));
    }

    @Test
    void testEmptyWords() {
        String[] words = {};
        List<RuleStrategy> rules = List.of(new StartsWithMRule(), new LongWordRule());

        Map<String, List<String>> results = WordCounter.applyRules(rules, words);

        assertTrue(results.get("Starts with M/m").isEmpty());
        assertTrue(results.get("Longer than 5 characters").isEmpty());
    }
}

