package com.merits.m.merits.api;

import com.merits.m.merits.Model.Hadith;
import com.merits.m.merits.service.HadithService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HadithController {
    private final HadithService hadithService;

    @Autowired
    public HadithController(@RequestBody HadithService hadithService) {
        this.hadithService = hadithService;
    }

    @GetMapping("/merits")
    @ResponseBody
    public List<Hadith> getAllHadith() {
        return hadithService.getAllHadith();
    }
}
