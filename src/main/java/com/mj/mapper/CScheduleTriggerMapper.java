package com.mj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mj.entity.CScheduleTrigger;

@Mapper
public interface CScheduleTriggerMapper {
	int deleteByPrimaryKey(Integer integer);

	int insert(CScheduleTrigger record);

	int insertSelective(CScheduleTrigger record);

	CScheduleTrigger selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(CScheduleTrigger record);

	int updateByPrimaryKey(CScheduleTrigger record);

	List<CScheduleTrigger> cornList();
}