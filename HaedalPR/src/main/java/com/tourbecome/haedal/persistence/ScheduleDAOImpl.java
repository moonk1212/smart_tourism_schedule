package com.tourbecome.haedal.persistence;

import java.util.*;

import javax.inject.*;

import org.apache.ibatis.session.*;
import org.springframework.stereotype.*;

import com.tourbecome.haedal.domain.*;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.tourbecome.haedal.mapper.ScheduleMapper";
	
	@Override
	public void insertSch(ScheduleVO scheduleVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertSch", scheduleVO);
	}

	@Override
	public List<ScheduleVO> selectSch(ScheduleVO scheduleVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".selectSch", scheduleVO);
	}

	@Override
	public void updateSch(ScheduleVO scheduleVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".updateSch", scheduleVO);
	}

	@Override
	public void deleteSch(int scd_id) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".deleteSch", scd_id);
	}

	@Override
	public List<ScheduleVO> selectSchList(int user_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".selectSchList", user_id);
	}

	@Override
	public void insertSchContent(ScheduleContentVO scheduleContentVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertSchContent", scheduleContentVO);
	}

	@Override
	public void updateSchContent(ScheduleContentVO scheduleContentVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".updateSchContent", scheduleContentVO);
	}

	@Override
	public void deleteSchContent(int sco_id) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".deleteSchContent", sco_id);
	}
	
	@Override
	public void updateSchExpense(ScheduleVO scheduleVO) throws Exception {
		sqlSession.update(namespace + ".updateSchExpense", scheduleVO);
	}
	
} //ScheduleDAOImpl
