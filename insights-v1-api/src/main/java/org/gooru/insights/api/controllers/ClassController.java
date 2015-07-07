package org.gooru.insights.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gooru.insights.api.constants.InsightsOperationConstants;
import org.gooru.insights.api.security.AuthorizeOperations;
import org.gooru.insights.api.services.BaseService;
import org.gooru.insights.api.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="class/")
public class ClassController extends BaseController{

	@Autowired
	private ClassService classService;
	
	@Autowired
	private BaseService baseService;
	
	private ClassService getClassService() {
		return classService;
	}
	
	@RequestMapping(value="/{classGooruId}/course/{courseGooruId}/unit",method ={ RequestMethod.GET,RequestMethod.POST})
	@AuthorizeOperations(operations =  InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	@ResponseBody
	public ModelAndView getClasspageCourseUsage(HttpServletRequest request, @PathVariable(value="classGooruId") String classGooruId,
			@PathVariable(value="courseGooruId") String courseGooruId, @RequestParam(value="getUsageData", required = false) Boolean getUsageData,
			@RequestParam(value="userUid", required = false) String userUid, HttpServletResponse response) throws Exception{
		setAllowOrigin(response);
		return getModel(getClassService().getCourseUsage(getTraceId(request), classGooruId, courseGooruId, userUid, getUsageData, request.isSecure()));
	}
	
	@RequestMapping(value="/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/lesson",method ={ RequestMethod.GET,RequestMethod.POST})
	@AuthorizeOperations(operations =  InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	@ResponseBody
	public ModelAndView getClasspageUnitUsage(HttpServletRequest request, @PathVariable(value="classGooruId") String classGooruId,
			@PathVariable(value="courseGooruId") String courseGooruId, @PathVariable(value="unitGooruId") String unitGooruId, 
			@RequestParam(value="userUid", required = false) String userUid,
			@RequestParam(value="getUsageData", required = false) Boolean getUsageData, HttpServletResponse response) throws Exception{
		setAllowOrigin(response);
		return getModel(getClassService().getUnitUsage(getTraceId(request), classGooruId, courseGooruId, unitGooruId, userUid, getUsageData, request.isSecure()));
	}
	
	@RequestMapping(value="/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/lesson/{lessonGooruId}",method ={ RequestMethod.GET,RequestMethod.POST})
	@AuthorizeOperations(operations =  InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	@ResponseBody
	public ModelAndView getClasspageLessonUsage(HttpServletRequest request, @PathVariable(value="classGooruId") String classGooruId,
			@PathVariable(value="courseGooruId") String courseGooruId, @PathVariable(value="unitGooruId") String unitGooruId, 
			@PathVariable(value="lessonGooruId") String lessonGooruId, @RequestParam(value="userUid", required = false) String userUid,
			@RequestParam(value="getUsageData", required = false) Boolean getUsageData, HttpServletResponse response) throws Exception{
		setAllowOrigin(response);
		return getModel(getClassService().getLessonUsage(getTraceId(request), classGooruId, courseGooruId, unitGooruId, lessonGooruId, userUid, getUsageData, request.isSecure()));
	}
	
	@RequestMapping(value="/{classGooruId}/course/{courseGooruId}/planView",method ={ RequestMethod.GET,RequestMethod.POST})
	@AuthorizeOperations(operations =  InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	@ResponseBody
	public ModelAndView getCoursePlanView(HttpServletRequest request, @PathVariable(value="classGooruId") String classGooruId,
			@PathVariable(value="courseGooruId") String courseGooruId, @RequestParam(value="userUid", required = false) String userUid, HttpServletResponse response) throws Exception{
		setAllowOrigin(response);
		return getModel(getClassService().getCoursePlanView(getTraceId(request), classGooruId, courseGooruId, userUid, request.isSecure()));
	}
	
	@RequestMapping(value="/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/planView",method ={ RequestMethod.GET,RequestMethod.POST})
	@AuthorizeOperations(operations =  InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	@ResponseBody
	public ModelAndView getUnitPlanView(HttpServletRequest request, @PathVariable(value="classGooruId") String classGooruId,
			@PathVariable(value="courseGooruId") String courseGooruId, @PathVariable(value="unitGooruId") String unitGooruId,
			@RequestParam(value="userUid", required = false) String userUid, HttpServletResponse response) throws Exception{
		setAllowOrigin(response);
		return getModel(getClassService().getUnitPlanView(getTraceId(request), classGooruId, courseGooruId, unitGooruId, userUid, request.isSecure()));
	}

	@RequestMapping(value="/{classGooruId}/course/{courseGooruId}/lesson",method ={ RequestMethod.GET,RequestMethod.POST})
	@AuthorizeOperations(operations =  InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	public ModelAndView getLessonAndUsage(HttpServletRequest request, @PathVariable(value="classGooruId") String classGooruId,
			@PathVariable(value="courseGooruId") String courseGooruId, @RequestParam(value="unitGooruId") String unitGooruId, 
			@RequestParam(value="userUid", required = true) String userUid,@RequestParam(value="isUsageRequired", required = false) boolean isUsageRequired,@RequestParam(value="isMetaRequired", required = false) boolean isMetaRequired
			,HttpServletResponse response) throws Exception{
		setAllowOrigin(response);
		return getModel(getClassService().getItemsUsage(getTraceId(request), baseService.appendTilda(classGooruId,courseGooruId),userUid, isUsageRequired, isMetaRequired, request.isSecure(), unitGooruId));
	}
	
	@RequestMapping(value="/{classGooruId}/course/{courseGooruId}/progressView",method ={ RequestMethod.GET,RequestMethod.POST})
	@AuthorizeOperations(operations =  InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	@ResponseBody
	public ModelAndView getCourseProgressView(HttpServletRequest request, @PathVariable(value="classGooruId") String classGooruId,
			@PathVariable(value="courseGooruId") String courseGooruId, @RequestParam(value="userUid", required = false) String userUid, HttpServletResponse response) throws Exception{
		setAllowOrigin(response);
		return getModel(getClassService().getCourseProgressView(getTraceId(request), classGooruId, courseGooruId, userUid, request.isSecure()));
	}
	
	@RequestMapping(value="/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/progressView",method ={ RequestMethod.GET,RequestMethod.POST})
	@AuthorizeOperations(operations =  InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	@ResponseBody
	public ModelAndView getUnitProgressView(HttpServletRequest request, @PathVariable(value="classGooruId") String classGooruId,
			@PathVariable(value="courseGooruId") String courseGooruId, @PathVariable(value="unitGooruId") String unitGooruId,
			@RequestParam(value="userUid", required = false) String userUid, HttpServletResponse response) throws Exception {
		setAllowOrigin(response);
		return getModel(getClassService().getUnitProgressView(getTraceId(request), classGooruId, courseGooruId, unitGooruId, userUid, request.isSecure()));
	}
	
}