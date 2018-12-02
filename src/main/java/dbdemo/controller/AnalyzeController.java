package dbdemo.controller;

import dbdemo.domain.Analyze;
import dbdemo.domain.AnalyzeRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalyzeController {

    @PostMapping("/analyze")
    public Analyze newAnalyze(@RequestBody AnalyzeRequest analyzeRequest) {
        return new Analyze(analyzeRequest.getText());
    }

}
