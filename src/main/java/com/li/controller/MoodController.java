package com.li.controller;

import com.li.dto.MoodDto;
import com.li.service.MoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/mood")
public class MoodController {
    @Resource
    private MoodService moodService;
    @RequestMapping("/findAllForRedis")
    public String findAll(Model model) {
        List<MoodDto> lists = moodService.findAllFroRedis();
        model.addAttribute("moodList",lists);
        return "pages/mood";
    }
    @GetMapping("/{moodId}/praiseForRedis")
    public String praise(Model model, @PathVariable("moodId") String moodId,@RequestParam("userId") String userId) {
        boolean isPraise = moodService.praiseMoodForRedis(userId, moodId);
        List<MoodDto> lists = moodService.findAllFroRedis();
        model.addAttribute("moodList",lists);
        model.addAttribute("isPraise",isPraise);
        return "/pages/mood";
    }
}
