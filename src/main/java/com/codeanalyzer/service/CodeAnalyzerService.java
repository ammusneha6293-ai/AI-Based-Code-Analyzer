package com.codeanalyzer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codeanalyzer.analyzer.BugDetector;
import com.codeanalyzer.model.AnalysisResult;

@Service
public class CodeAnalyzerService {

    private final BugDetector bugDetector;

    public CodeAnalyzerService(BugDetector bugDetector) {
        this.bugDetector = bugDetector;
    }

    public AnalysisResult analyzeCode(String code) {

        // Detect possible issues in Java code
        List<String> issues = bugDetector.detectBugs(code);

        // Count detected issues
        int issueCount = issues.size();

        // If no issues are found, count should be zero
        if (issues.size() == 1 &&
            issues.get(0).equals(
                "No issues detected by basic checks.")) {

            issueCount = 0;
        }

        // Return analysis results
        return new AnalysisResult(
            "Code analysis completed successfully.",
            issueCount,
            issues
        );
    }
}