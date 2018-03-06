package com.peachyy.springmvc.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Taoxs on 2017/10/23.
 */
public class VersionCondition implements RequestCondition<VersionCondition> {
    public static final Logger LOGGER = LoggerFactory.getLogger(VersionCondition.class);
    private final static Pattern VERSION_PATTERN = Pattern.compile("/v(\\d+)/");
    //正确情况下应该只有1个
    private Set<VersionCondition> versionConditions;
    private String version;
    private int order;
    public VersionCondition(Set<VersionCondition> versionConditions){
        this.versionConditions= Collections.unmodifiableSet(versionConditions);
    }
    public VersionCondition(String version,int order){
        this.version=version;
        this.order=order;
    }
    /**
     * 条件组合
     * @param other
     * @return
     */
    @Override
    public VersionCondition combine(VersionCondition other) {
        return new VersionCondition(other.version,other.order);
    }

    /**
     * 当前匹配条件的
     * @param request
     * @return
     */
    @Override
    public VersionCondition getMatchingCondition(HttpServletRequest request) {
        String url=request.getRequestURI();
        Matcher matcher=VERSION_PATTERN.matcher(url);
        if(matcher.find()){
            String versionGroup=matcher.group(0);
            String versionName=versionGroup.replaceAll("/","");
            if(!StringUtils.isEmpty(versionGroup) && versionName.equalsIgnoreCase(version)){
                if(LOGGER.isDebugEnabled()){
                    LOGGER.debug("URL {} matcher {}",url,versionName);
                }
                return this;
            }
        }
        return null;
    }


    /**
     * 用于排序
     * @param other
     * @param request
     * @return
     */
    @Override
    public int compareTo(VersionCondition other, HttpServletRequest request) {
        return new Integer(order).compareTo(other.order);
    }



   // @Override
    protected Collection<?> getContent() {
        return this.versionConditions;
    }

    //@Override
    protected String getToStringInfix() {
        return " && ";
    }
}
