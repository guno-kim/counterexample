package project.counterexample.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

@RestController
public class ProblemController {
    @PostMapping("/problem")
    public boolean saveProblem(@RequestBody Map<String ,Object> body) {
        for (String s : body.keySet()) {
            System.out.println(s+body.get(s));
        }
        return false;
    }

    @Data
    static class SaveProblemRequest {
        @NotEmpty
        private Long id;
        private Long userid;
//        private ProblemType problemType;
//        private Long problemNum;
        private String title;
        private String description;
        private String answerCode;

    }


}
