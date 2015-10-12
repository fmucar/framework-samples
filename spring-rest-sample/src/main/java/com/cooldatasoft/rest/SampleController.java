package com.cooldatasoft.rest;

import com.cooldatasoft.rest.data.SampleEntity;
import com.cooldatasoft.rest.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody SampleEntity entity) {
        return sampleService.create();
    }

    @ResponseBody
    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public SampleEntity read(@PathVariable("id") Long id) {
        return sampleService.read(id);
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody SampleEntity entity) {
        return sampleService.update(entity);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
        return sampleService.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<SampleEntity> list(@RequestParam(value = "startId", defaultValue = "1") Long startId, @RequestParam(value = "size", defaultValue = "20")  Integer size) {
        return sampleService.list(startId, size);
    }


}
