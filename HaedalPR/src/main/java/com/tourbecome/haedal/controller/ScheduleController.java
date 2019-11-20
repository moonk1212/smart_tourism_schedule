package com.tourbecome.haedal.controller;

import java.text.*;
import java.util.*;

import javax.inject.*;
import javax.servlet.http.*;

import org.springframework.web.bind.annotation.*;

import com.tourbecome.haedal.domain.*;
import com.tourbecome.haedal.service.*;


@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Inject
	private ScheduleService scheduleService;
	
	//1. 여행 생성 POST
	@RequestMapping(value="", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> schedulePOST(HttpServletRequest req, HttpServletResponse res, ScheduleVO scheduleVO) {

		Map<String, Object> output = new HashMap<String, Object>();
		Map<String, Object> succeed = new HashMap<String, Object>();
			
		try {
			scheduleService.insertSch(scheduleVO);
			succeed.put("succeed", true);
			output.put("data", succeed);
		} catch (Exception e) {
			e.printStackTrace();
			succeed.put("succeed", false);
			output.put("data", succeed);
		} //try~catch
			
		return output;
		
	} //schedulePOST 

	
	//2. 여행 상세 조회 - 일정조회 GET
	@RequestMapping(value="/{scd_id}", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> scheduleGET(HttpServletRequest req, HttpServletResponse res, ScheduleVO scheduleVO) {
		Map<String, Object> output = new HashMap<String, Object>();
		List<ScheduleVO> scheduleVOList = new ArrayList<ScheduleVO>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			scheduleVOList = scheduleService.selectSch(scheduleVO);
			List contentList = new ArrayList<>();
			Map<String, Object> data = new HashMap<String, Object>();
			output.put("user_id",scheduleVOList.get(0).getUser_id());
			output.put("scd_title",scheduleVOList.get(0).getScd_title());
			String start_date = new SimpleDateFormat("yyyy/MM/dd").format(scheduleVOList.get(0).getScd_start_date());
			output.put("scd_start_date", start_date);
			String end_date = new SimpleDateFormat("yyyy/MM/dd").format(scheduleVOList.get(0).getScd_end_date());
			output.put("scd_end_date", end_date);
			output.put("scd_destination",scheduleVOList.get(0).getScd_destination());
			output.put("scd_total_expense",scheduleVOList.get(0).getScd_total_expense());
			for(int i = 0; i < scheduleVOList.size(); i++) {
				Map<String, Object> contentMap = new HashMap<String, Object>();
				contentMap.put("sco_start_spot", scheduleVOList.get(i).getScheduleContentVO().getSco_start_spot());
				contentMap.put("sco_end_spot", scheduleVOList.get(i).getScheduleContentVO().getSco_end_spot());
				String time = new SimpleDateFormat("HH:mm:ss").format(scheduleVOList.get(i).getScheduleContentVO().getSco_time());
				contentMap.put("sco_time", time);
				contentMap.put("sco_content", scheduleVOList.get(i).getScheduleContentVO().getSco_content());
				contentMap.put("sco_expenses", scheduleVOList.get(i).getScheduleContentVO().getSco_expenses());
				contentMap.put("sco_day", scheduleVOList.get(i).getScheduleContentVO().getSco_day());
				contentList.add(contentMap);
			}	
			
			output.put("schedule_content",contentList);
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map<String, Object> succeed = new HashMap<String, Object>();
			succeed.put("succeed", false);
			output.put("data", succeed);
			//list.add(output);
		} //try~catch
			return output;
			
	} //scheduleGET

	//3. 여행 수정 PUT
	@RequestMapping(value="/{scd_id}", method=RequestMethod.PUT)
	public @ResponseBody Map<String, Object> schedulePUT(HttpServletRequest req, HttpServletResponse res, ScheduleVO scheduleVO) {
		Map<String, Object> output = new HashMap<String, Object>();
		Map<String, Object> succeed = new HashMap<String, Object>();
		try {
			scheduleService.updateSch(scheduleVO);
			succeed.put("succeed", true);
			output.put("data", succeed);
			return output;
		} catch(Exception e) {
			e.printStackTrace();
			succeed.put("succeed", false);
			output.put("data", succeed);
		} //try~catch
		
		return output;
		
	} //schedulePUT
	
	//4. 여행 삭제 DELETE
	@RequestMapping(value="/{scd_id}", method=RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> scheduleDELETE(HttpServletRequest req, HttpServletResponse res, @PathVariable("scd_id") int scd_id) {
		Map<String, Object> output = new HashMap<String, Object>();
		Map<String, Object> succeed = new HashMap<String, Object>();
		try {
			scheduleService.deleteSch(scd_id);
			succeed.put("succeed", true);
			output.put("data", succeed);
			return output;
		} catch(Exception e) {
			e.printStackTrace();
			succeed.put("succeed", false);
			output.put("data", succeed);
		} //try~catch
		
		return output;
		
	} //scheduleDELETE
	
	//5. 여행 리스트 조회
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> scheduleListGET(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Object> output = new HashMap<String, Object>();
		List<ScheduleVO> scheduleVOList = new ArrayList<ScheduleVO>();
		List scheduleList = new ArrayList<>();
		try {
			int user_id = TokenProcess.validate(req); //로그인한 회원아이디로 바꾸기
			scheduleVOList = scheduleService.selectSchList(user_id);
			
			for(int i = 0; i < scheduleVOList.size(); i++) {
				Map<String, Object> scheduleMap = new HashMap<String, Object>();
				scheduleMap.put("scd_id", scheduleVOList.get(i).getScd_id());
				scheduleMap.put("user_id", scheduleVOList.get(i).getUser_id());
				scheduleMap.put("scd_title", scheduleVOList.get(i).getScd_title());
				String start_date = new SimpleDateFormat("yyyy/MM/dd").format(scheduleVOList.get(i).getScd_start_date());
				scheduleMap.put("scd_start_date", start_date);
				String end_date = new SimpleDateFormat("yyyy/MM/dd").format(scheduleVOList.get(i).getScd_end_date());
				scheduleMap.put("scd_end_date", end_date);
				scheduleMap.put("scd_destination", scheduleVOList.get(i).getScd_destination());
				scheduleMap.put("scd_total_expense", scheduleVOList.get(i).getScd_total_expense());
				scheduleList.add(scheduleMap);
			}	
			
			output.put("schedule_content",scheduleList);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map<String, Object> succeed = new HashMap<String, Object>();
			succeed.put("succeed", false);
			output.put("data", succeed);
		} //try~catch

		return output;
	} //scheduleListGET
	
	//6. 여행 일정 추가
	@RequestMapping(value="{scd_id}", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> scheduleContentPOST(HttpServletRequest req, HttpServletResponse res, ScheduleContentVO scheduleContentVO) {

		Map<String, Object> output = new HashMap<String, Object>();
		Map<String, Object> succeed = new HashMap<String, Object>();
			
		try {
			scheduleService.insertSchContent(scheduleContentVO);
			succeed.put("succeed", true);
			output.put("data", succeed);
		} catch (Exception e) {
			e.printStackTrace();
			succeed.put("succeed", false);
			output.put("data", succeed);
		} //try~catch
			
		return output;
		
	} //scheduleContentPOST 
	
	//7. 여행 일정 수정
	@RequestMapping(value="/{scd_id}/{sco_id}", method=RequestMethod.PUT)
	public @ResponseBody Map<String, Object> scheduleContentPUT(HttpServletRequest req, HttpServletResponse res, ScheduleVO scheduleVO, ScheduleContentVO scheduleContentVO) {
		Map<String, Object> output = new HashMap<String, Object>();
		Map<String, Object> succeed = new HashMap<String, Object>();
		try {
			scheduleService.updateSchContent(scheduleContentVO);
			scheduleService.updateSchExpense(scheduleVO);
			succeed.put("succeed", true);
			output.put("data", succeed);
			return output;
		} catch(Exception e) {
			e.printStackTrace();
			succeed.put("succeed", false);
			output.put("data", succeed);
		} //try~catch
		
		return output;
		
	} //scheduleContentPUT
	
	//8. 여행 일정 삭제
	@RequestMapping(value="/{scd_id}/{sco_id}", method=RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> scheduleContentDELETE(HttpServletRequest req, HttpServletResponse res, @PathVariable("sco_id") int sco_id) {
		Map<String, Object> output = new HashMap<String, Object>();
		Map<String, Object> succeed = new HashMap<String, Object>();
		try {
			scheduleService.deleteSchContent(sco_id);
			succeed.put("succeed", true);
			output.put("data", succeed);
			return output;
		} catch(Exception e) {
			e.printStackTrace();
			succeed.put("succeed", false);
			output.put("data", succeed);
		} //try~catch
		
		return output;
		
	} //scheduleContentDELETE
	
} //ScheduleController
