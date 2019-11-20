package com.tourbecome.haedal.service;

import java.util.*;

import javax.inject.*;

import org.springframework.stereotype.*;

import com.tourbecome.haedal.domain.*;
import com.tourbecome.haedal.persistence.*;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Inject
	ScheduleDAO scheduleDAO;

	@Override
	public void insertSch(ScheduleVO scheduleVO) throws Exception {
		// TODO Auto-generated method stub
		scheduleDAO.insertSch(scheduleVO);
	}

	@Override
	public List<ScheduleVO> selectSch(ScheduleVO scheduleVO) throws Exception {
		// TODO Auto-generated method stub
		return scheduleDAO.selectSch(scheduleVO);
	}

	@Override
	public void updateSch(ScheduleVO scheduleVO) throws Exception {
		// TODO Auto-generated method stub
		scheduleDAO.updateSch(scheduleVO);
	}

	@Override
	public void deleteSch(int scd_id) throws Exception {
		// TODO Auto-generated method stub
		scheduleDAO.deleteSch(scd_id);
	}

	@Override
	public List<ScheduleVO> selectSchList(int user_id) throws Exception {
		// TODO Auto-generated method stub
		return scheduleDAO.selectSchList(user_id);
	}

	@Override
	public void insertSchContent(ScheduleContentVO scheduleContentVO) throws Exception {
		// TODO Auto-generated method stub
		scheduleDAO.insertSchContent(scheduleContentVO);
	}

	@Override
	public void updateSchContent(ScheduleContentVO scheduleContentVO) throws Exception {
		// TODO Auto-generated method stub
		scheduleDAO.updateSchContent(scheduleContentVO);
	}

	@Override
	public void deleteSchContent(int sco_id) throws Exception {
		// TODO Auto-generated method stub
		scheduleDAO.deleteSchContent(sco_id);
	}
	
	@Override
	public void updateSchExpense(ScheduleVO scheduleVO) throws Exception {
		scheduleDAO.updateSchExpense(scheduleVO);
	}
	
	
	
	
} //ScheduleServiceImpl
