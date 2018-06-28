package com.prophet.EducationAdministrativeSystem.web.handler;

import com.prophet.EducationAdministrativeSystem.business.exception.QueryServiceException;
import com.prophet.EducationAdministrativeSystem.model.Course;
import com.prophet.EducationAdministrativeSystem.service.CourseRelatedQueryService;
import com.prophet.EducationAdministrativeSystem.web.command.exception.ServiceException;
import com.prophet.EducationAdministrativeSystem.web.command.service.ServiceRequestHandler;
import com.prophet.EducationAdministrativeSystem.web.response.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class CourseRelatedQueryHandlerImpl implements ServiceRequestHandler<HttpServletRequest, ResponseModel> {

    @Autowired
    CourseRelatedQueryService courseRelatedQueryService;

    @Override
    public ResponseModel process(HttpServletRequest request) throws ServiceException {

        try {
            List<Course> courses = courseRelatedQueryService.getAllCourse();
            return buildResp(courses);
        } catch (QueryServiceException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    private ResponseModel buildResp(Object data) {

        ResponseModel resp = new ResponseModel();
        resp.setStatus("success");
        resp.setMessage("查询成功");
        resp.setData(data);
        return resp;
    }

    @Override
    public ResponseModel handleFailure(HttpServletRequest request, ServiceException e) {
        ResponseModel resp = new ResponseModel();
        resp.setStatus("failed");
        resp.setMessage(e.getRemark());
        resp.setData(e.getCause());
        return resp;
    }
}
