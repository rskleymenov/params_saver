package com.rskleymenov.controller;

import com.rskleymenov.model.SaveParamsModel;
import com.rskleymenov.service.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaveController {

    @Autowired
    private SaveService saveService;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ResponseEntity<SaveParamsModel> save(final @RequestParam("stationName") String stationName,
                                                final @RequestParam("action") String action) {
        SaveParamsModel savedParamsModel = this.saveService.save(stationName, action);
        return ResponseEntity.ok(savedParamsModel);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<SaveParamsModel>> retrieveAll() {
        return ResponseEntity.ok(this.saveService.retrieveAll());
    }

}
