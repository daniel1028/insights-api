package org.gooru.insights.api.services;

import java.util.Map;

import org.gooru.insights.api.models.ContentTaxonomyActivity;
import org.gooru.insights.api.models.ResponseParamDTO;

import rx.Observable;

public interface ClassService {

	Observable<ResponseParamDTO<Map<String, Object>>> getSessionStatus(String sessionId, String contentGooruId);

	Observable<ResponseParamDTO<Map<String, Object>>> getUserSessions(String classId, String courseId, String unitId, String lessonId, String collectionId, String collectionType, String userUid, boolean openSession) throws Exception;
	
	Observable<ResponseParamDTO<Map<String, Object>>> getSummaryData(String classId, String courseId, String unitId, String lessonId, String assessmentId, String sessionId, String userUid, String collectionType) throws Exception;

	Observable<ResponseParamDTO<Map<String, Object>>> getUserCurrentLocationInLesson(String userUid, String classId);

	Observable<ResponseParamDTO<Map<String, Object>>> getPerformance(String classId, String courseId, String unitId, String lessonId, String userUid, String collectionType,
			String nextLevelType);

	Observable<ResponseParamDTO<Map<String, Object>>> getAllStudentPerformance(String classId, String courseId, String unitId, String lessonId, String gooruOid, String collectionType, String userUid);

	Observable<ResponseParamDTO<ContentTaxonomyActivity>> getUserDomainParentMastery(String studentId, String subjectId, String courseIds, String domainId);
	
	Observable<ResponseParamDTO<Map<String, Object>>> getTeacherGrade(String teacherUid, String userUid, String sessionId);

	Observable<ResponseParamDTO<Map<String, Object>>> getResourceUsage(String sessionId, String resourceIds);

	Observable<ResponseParamDTO<Map<String, Object>>> getPriorDetail(String classId, String courseId, String unitId, String lessonId, String assessmentId, String sessionId, String userUid, String collectionType, boolean openSession);
		
	Observable<ResponseParamDTO<Map<String, Object>>> getUserPeers(String classId, String courseId, String unitId, String nextLevelType);

	Observable<ResponseParamDTO<Map<String, Object>>> getUserPeers(String classId, String courseId, String unitId, String lessonId, String nextLevelType);
	
	Observable<ResponseParamDTO<ContentTaxonomyActivity>> getTaxonomyActivity(Integer depth, String... taxonomyLevelIds);

	Observable<ResponseParamDTO<Map<String, Object>>> getStatisticalMetrics(String gooruOids);
}


