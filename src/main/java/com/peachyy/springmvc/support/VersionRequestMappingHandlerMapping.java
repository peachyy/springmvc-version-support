package com.peachyy.springmvc.support;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Taoxs on 2017/10/23.
 */
public class VersionRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
    private VersionCondition newVersionCondition(Version version){
        if(null == version){
            return null;
        }
        return new VersionCondition(version.version(),version.order());
    }


    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        Version version = AnnotationUtils.findAnnotation(handlerType, Version.class);
        return newVersionCondition(version);
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        Version version = AnnotationUtils.findAnnotation(method, Version.class);
        return newVersionCondition(version);
    }

    @Override
    protected HandlerMethod lookupHandlerMethod(String lookupPath, HttpServletRequest request) throws Exception {
        return super.lookupHandlerMethod(lookupPath, request);
    }
}
