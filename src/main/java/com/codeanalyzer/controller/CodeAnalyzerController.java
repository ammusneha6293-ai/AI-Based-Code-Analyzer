package com.codeanalyzer.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeanalyzer.model.AnalysisResult;
import com.codeanalyzer.service.CodeAnalyzerService;

@RestController
@RequestMapping("/api")
public class CodeAnalyzerController {

    private final CodeAnalyzerService codeAnalyzerService;

    public CodeAnalyzerController(
            CodeAnalyzerService codeAnalyzerService) {
        this.codeAnalyzerService = codeAnalyzerService;
    }

    // GET: Check API status
    @GetMapping("/status")
    public String getStatus() {
        return "Code Analyzer API is working!";
    }

    // POST: Analyze Java code
    @PostMapping(
        value = "/analyze",
        consumes = MediaType.TEXT_PLAIN_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public AnalysisResult analyzeCode(@RequestBody String code) {
        return codeAnalyzerService.analyzeCode(code);
    }

    // PUT: Receive code for updating
    @PutMapping("/update")
    public String updateCode(@RequestBody String code) {
        return "Code received for update: " + code;
    }

    // DELETE: Test delete request
    @DeleteMapping("/delete")
    public String deleteCode() {
        return "Delete request received successfully!";
    }
}