package com.metro.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.metro.pojo.Station;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/2/26
 * @Content:
 */
@Mapper
public interface StationMapper extends BaseMapper<Station> {
    int insertStation(Station station);

    int deleteStation(Station station);

    int updateStation(Station station);
}
