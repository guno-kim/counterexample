package project.counterexample.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.RestController;
import project.counterexample.domain.entity.ProblemType;

import javax.validation.constraints.NotEmpty;

@RestController
public class ProblemController {
//    @PostMapping("/problem")
//    public boolean saveProblem(@RequestBody @Valid SaveProblemRequest req) {
//    }

    @Data
    static class SaveProblemRequest {
        @NotEmpty
        private Long userId;
        private ProblemType problemType;
        private Long problemNum;
        private String title;
        private String description;
        private String answerCode;

    }


}
