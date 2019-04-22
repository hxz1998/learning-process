package com.tccloud.webserver.dao.impl;

import {package_name}.dao.{dao_name};
import {package_name}.model.{model_name};

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

@Component("{component_name}")
public class {dao_name}Impl implements {dao_name} {

    private HibernateTemplate hibernateTemplate;

    public void save({model_name} {lower_case_model_name}) {
        hibernateTemplate.save({lower_case_model_name});
    }

    public void delete({model_name} {lower_case_model_name}) {

    }

    public User get({model_name} {lower_case_model_name}) {
        return null;
    }

    public List<{model_name}> get{model_name}s() {
        return null;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}