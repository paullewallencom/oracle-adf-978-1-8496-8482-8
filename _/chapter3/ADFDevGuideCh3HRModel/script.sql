CREATE OR REPLACE VIEW  EmployeeDepartmentView AS SELECT Emp.COMMISSION_PCT, Emp.DEPARTMENT_ID,Emp.EMAIL,Emp.EMPLOYEE_ID,Emp.FIRST_NAME,Emp.HIRE_DATE,Emp.JOB_ID,Emp.LAST_NAME,Emp.MANAGER_ID,Emp.PHONE_NUMBER,Emp.SALARY, Dept.DEPARTMENT_NAME FROM EMPLOYEES Emp, DEPARTMENTS Dept WHERE Emp.DEPARTMENT_ID = Dept.DEPARTMENT_ID;
CREATE OR REPLACE  SYNONYM EMP for EMPLOYEES;
CREATE  MATERIALIZED VIEW EmployeeMView FOR UPDATE AS SELECT * FROM EMPLOYEES Employees WHERE Employees.DEPARTMENT_ID = 10;