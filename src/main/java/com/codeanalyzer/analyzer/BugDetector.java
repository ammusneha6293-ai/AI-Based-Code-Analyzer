package com.codeanalyzer.analyzer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BugDetector {

    public List<String> detectBugs(String code) {

        List<String> issues = new ArrayList<>();

        if (code == null || code.trim().isEmpty()) {
            issues.add("Please enter Java code.");
            return issues;
        }

        if (code.contains("/0") || code.contains("/ 0")) {
            issues.add("Possible division by zero detected.");
        }

        if (code.contains("TODO")) {
            issues.add("TODO comment found.");
        }

        if (code.contains("System.out.println")) {
            issues.add("Debug print statement found.");
        }

        if (issues.isEmpty()) {
            issues.add("No issues detected by basic checks.");
        }

        return issues;
    }
}