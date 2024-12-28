package com.knowledge.track.controller;


import com.knowledge.track.common.response.ResultResponse;
import com.knowledge.track.domain.dto.DatasetListDTO;
import com.knowledge.track.service.DatasetService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/dataset")
public class DatasetController {

    @Resource
    private DatasetService datasetService;

    @GetMapping("/list")
    public ResultResponse list(DatasetListDTO dto) {
        return datasetService.list(dto);
    }

}
