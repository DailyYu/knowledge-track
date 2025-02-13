package com.knowledge.track.controller;


import com.knowledge.track.common.response.ResultResponse;
import com.knowledge.track.domain.dto.KnowledgeDataAddDTO;
import com.knowledge.track.domain.dto.KnowledgeDataListDTO;
import com.knowledge.track.domain.dto.KnowledgeDataUpdateDTO;
import com.knowledge.track.service.KnowledgeDataService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/knowledge")
public class KnowledgeDataController {

    @Resource
    private KnowledgeDataService knowledgeDataService;


    @GetMapping("/list")
    public ResultResponse list(KnowledgeDataListDTO dto) {
        return knowledgeDataService.list(dto);
    }

    @GetMapping("/delete")
    public ResultResponse delete(@RequestParam("id") Integer id) {
        return knowledgeDataService.delete(id);
    }


    @PostMapping("/update")
    public ResultResponse update(@RequestBody @Valid KnowledgeDataUpdateDTO dto) {
        return knowledgeDataService.update(dto);
    }

    @PostMapping("/add")
    public ResultResponse add(@RequestBody @Valid KnowledgeDataAddDTO dto) {
        return knowledgeDataService.add(dto);
    }


}
