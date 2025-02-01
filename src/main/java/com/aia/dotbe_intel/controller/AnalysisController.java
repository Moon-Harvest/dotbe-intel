package com.aia.dotbe_intel.controller;

import org.springframework.web.bind.annotation.*;

import com.aia.dotbe_intel.service.AnalysisService;

@RestController
public class AnalysisController {

    private final AnalysisService analysisService;

    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

}
