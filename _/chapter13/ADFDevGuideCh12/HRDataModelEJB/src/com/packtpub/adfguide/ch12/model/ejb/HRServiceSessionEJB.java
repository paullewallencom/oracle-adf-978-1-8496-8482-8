package com.packtpub.adfguide.ch12.model.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface HRServiceSessionEJB {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    Employees persistEmployees(Employees employees);

    Employees mergeEmployees(Employees employees);

    void removeEmployees(Employees employees);

    List<Employees> getEmployeesFindAll();

    Departments persistDepartments(Departments departments);

    Departments mergeDepartments(Departments departments);

    void removeDepartments(Departments departments);

    List<Departments> getDepartmentsFindAll();
}
