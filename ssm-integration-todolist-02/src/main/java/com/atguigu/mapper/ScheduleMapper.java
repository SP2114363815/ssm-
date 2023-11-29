package com.atguigu.mapper;

import com.atguigu.pojo.Schedule;

import java.util.List;

public interface ScheduleMapper {
    List<Schedule> queryList();

    int deleteById(Integer id);

    int insert(Schedule schedule);

    int update(Schedule schedule);
}
