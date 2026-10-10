package com.codeanalyzer.model;

import java.util.List;

public class AnalysisResult {

    private String message;
    private int issueCount;
    private List<String> issues;

    // Default constructor
    public AnalysisResult() {
    }

    // Parameterized constructor
    public AnalysisResult(
            String message,
            int issueCount,
            List<String> issues) {

        this.message = message;
        this.issueCount = issueCount;
        this.issues = issues;
    }

    // Getters
    public String getMessage() {
        return message;
    }

    public int getIssueCount() {
        return issueCount;
    }

    public List<String> getIssues() {
        return issues;
    }

    // Setters
    public void setMessage(String message) {
        this.message = message;
    }

    public void setIssueCount(int issueCount) {
        this.issueCount = issueCount;
    }

    public void setIssues(List<String> issues) {
        this.issues = issues;
    }
}