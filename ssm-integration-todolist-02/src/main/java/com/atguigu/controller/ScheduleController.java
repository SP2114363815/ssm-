package com.atguigu.controller;

import com.atguigu.pojo.Schedule;
import com.atguigu.service.ScheduleService;
import com.atguigu.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//接收参数
//相应结果springmvc
@CrossOrigin//允许其他源访问我们的controller
@Slf4j
@RestController
@RequestMapping("schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    //查询
    @GetMapping("/{pageSize}/{currentPage}")
    public R page(@PathVariable int pageSize,
                  @PathVariable int currentPage){
        R r=scheduleService.page(pageSize,currentPage);
        //sl4fj
        log.info("查询的数据为：{}",r);
        return r;
    }
    //删除
    @DeleteMapping("/{id}")
    public R remove(@PathVariable Integer id){
        R r=scheduleService.remove(id);
        return r;
    }
    //保存,插入
    @PostMapping
    public R save(@Validated @RequestBody Schedule schedule, BindingResult result){
        if(result.hasErrors()){
            return R.fail("参数为null，不能保存");
        }
        R r=scheduleService.save(schedule);
        return r;
    }
    //修改
    @PutMapping
    public R update(@Validated @RequestBody Schedule schedule, BindingResult result){
        if(result.hasErrors()){
            return R.fail("参数为null，不能保存");
        }
        R r=scheduleService.update(schedule);
        return r;
    }
}
