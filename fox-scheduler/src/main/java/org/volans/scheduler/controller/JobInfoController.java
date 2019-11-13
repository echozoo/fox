package org.volans.scheduler.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.volans.scheduler.service.impl.ScheduleServiceImpl;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author j
 * @since 2019-11-12
 */
@RestController
@RequestMapping("/jobInfo")
public class JobInfoController {


    @Autowired
    private ScheduleServiceImpl scheduleService;

    @GetMapping
    public void add() {
        scheduleService.add();
    }

    @PutMapping
    public void put() {
        System.out.println("aaaa");
    }

    @DeleteMapping
    public void delete() {
        scheduleService.delete();
    }

}

