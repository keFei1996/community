package club.kefei.community.controller;

import club.kefei.community.dto.QuestionDTO;
import club.kefei.community.mapper.QuestionMapper;
import club.kefei.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model) {
        QuestionDTO questionDTO = questionService.getById(id);

        questionService.incView(id);
        model.addAttribute("question", questionDTO);
        return "question";
    }
}
