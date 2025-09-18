package org.indra;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.indra.rules.RuleStrategy;
import org.indra.rules.impl.LongWordRule;
import org.indra.rules.impl.StartsWithMRule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCounter {
    private static final Logger logger = LogManager.getLogger(WordCounter.class);

    public static void main(String[] args) {
        String defaultFilePath = "src/main/resources/input.txt";
        boolean usingDefault = args.length == 0 || args[0].isBlank();
        // Use user-supplied file if provided, else default
        String filePath = usingDefault ? defaultFilePath : args[0];
        if (usingDefault) {
            logger.info("No input file supplied. Using default file: {}", filePath);
        } else {
            logger.info("Using supplied input file: {}", filePath);
        }
        String content;
        try {
            content = Files.readString(Paths.get(filePath));
            String[] words = content.split("\\W+");

            List<RuleStrategy> rules = List.of(
                    new StartsWithMRule(),
                    new LongWordRule()
            );

            Map<String, List<String>> results = applyRules(rules, words);

            results.forEach((ruleName, matched) ->
                    logger.info("{} {} count: {}, {} Matched words: {}", System.lineSeparator(), ruleName, matched.size(), System.lineSeparator(), matched));
        } catch (IOException e) {
            logger.error("An exception occurred : {}", e.getMessage());
        }
    }

    static Map<String, List<String>> applyRules(List<RuleStrategy> rules, String[] words) {
        return rules.stream()
                .collect(Collectors.toMap(
                        RuleStrategy::getName,
                        rule -> Arrays.stream(words)
                                .filter(word -> !word.isEmpty())
                                .filter(rule::matches)
                                .toList()
                ));
    }
}
