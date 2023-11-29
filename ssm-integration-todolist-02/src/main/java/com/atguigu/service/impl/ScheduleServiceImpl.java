package com.atguigu.service.impl;

import com.atguigu.mapper.ScheduleMapper;
import com.atguigu.pojo.Schedule;
import com.atguigu.service.ScheduleService;
import com.atguigu.utils.PageBean;
import com.atguigu.utils.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Override
    public R page(int pageSize, int currentPage) {
        //分页
        PageHelper.startPage(currentPage,pageSize);
        //查询
        List<Schedule> schedulesList=scheduleMapper.queryList();
        //分页数据装配
        PageInfo<Schedule> info=new PageInfo<>(schedulesList);
        //装配PageBean
        PageBean<Schedule> pageBean=new PageBean<>(currentPage,pageSize,info.getTotal(),info.getList());
        R ok = R.ok(pageBean);
        return ok;
    }

    @Override
    public R remove(Integer id) {
        int rows=scheduleMapper.deleteById(id);
        if (rows>0){
            return R.ok(null);
        }


        return R.fail(null);
    }

    @Override
    public R save(Schedule schedule) {
        int rows=scheduleMapper.insert(schedule);
        if (rows>0){
            return R.ok(null);
        }


        return R.fail(null);
    }

    @Override
    public R update(Schedule schedule) {
        //判断id不能为空
        if (schedule.getId()==null){
            return R.fail("核心参数为空，无法修改");
        }

        int rows=scheduleMapper.update(schedule);
        if (rows>0){
            return R.ok(null);
        }

        return R.fail(null);
    }
}
