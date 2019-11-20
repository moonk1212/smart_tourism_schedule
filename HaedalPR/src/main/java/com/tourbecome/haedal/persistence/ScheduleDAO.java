package com.tourbecome.haedal.persistence;

import java.util.*;

import com.tourbecome.haedal.domain.*;

public interface ScheduleDAO {

	/**
	 * 여행 생성
	 * @param scheduleVO
	 * @return 
	 * @throws Exception
	*/
	public void insertSch(ScheduleVO scheduleVO) throws Exception;
	
	/**
	 * 여행 상세 조회 - 일정조회
	 * @param scheduleVO
	 * @return
	 * @throws Exception
	 */
	public List<ScheduleVO> selectSch(ScheduleVO scheduleVO) throws Exception;
	
	/**
	 * 여행 수정
	 * @param scheduleVO
	 * @throws Exception
	 */
	public void updateSch(ScheduleVO scheduleVO) throws Exception;
	
	/**
	 * 여행 삭제
	 * @param scd_id
	 * @throws Exception
	 */
	public void deleteSch(int scd_id) throws Exception;
	
	/**
	 * 여행 리스트 조회
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	public List<ScheduleVO> selectSchList(int user_id) throws Exception;
	
	/**
	 * 여행 일정 추가
	 * @param scheduleVO
	 * @return 
	 * @throws Exception
	*/
	public void insertSchContent(ScheduleContentVO scheduleContentVO) throws Exception;
	
	/**
	 * 여행 일정 수정
	 * @param scheduleContentVO
	 * @throws Exception
	 */	
	public void updateSchContent(ScheduleContentVO scheduleContentVO) throws Exception;
	
	/**
	 * 여행 일정 삭제
	 * @param scd_id
	 * @throws Exception
	 */	
	public void deleteSchContent(int sco_id) throws Exception;	
	
	
	public void updateSchExpense(ScheduleVO scheduleVO) throws Exception;
	
	
} //ScheduleDAO
