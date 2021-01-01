create or replace package body departments_api as
 PROCEDURE insert_department(p_department_id number,
                           p_department_name varchar2,
                           p_manager_id number,
                           p_location_id number) IS
  BEGIN
    INSERT INTO departments(department_id,   
           department_name,   
           manager_id,   
           location_id)
    VALUES(p_department_id,   
           p_department_name,   
           p_manager_id,   
           p_location_id);
  END insert_department;
 PROCEDURE update_department(p_department_id number,
                           p_department_name varchar2,
                           p_manager_id number,
                           p_location_id number) IS
  BEGIN

    UPDATE departments
    SET department_name = p_department_name,
      manager_id = p_manager_id,
      location_id = p_location_id
    WHERE department_id = p_department_id;
  END update_department;
  PROCEDURE delete_department(p_department_id NUMBER) IS
  BEGIN

    DELETE FROM departments
    WHERE department_id = p_department_id;
  END;

PROCEDURE lock_department(p_department_id NUMBER,   
                         p_department_name OUT VARCHAR2,   
                         p_manager_id OUT NUMBER,   
                         p_location_id OUT NUMBER) IS
  BEGIN
    SELECT department_name,
      manager_id,
      location_id
    INTO p_department_name,
      p_manager_id,
      p_location_id
    FROM departments
    WHERE department_id = p_department_id FOR

    UPDATE NOWAIT;
  END lock_department;

PROCEDURE select_department(p_department_id NUMBER,   
                         p_department_name OUT VARCHAR2,   
                         p_manager_id OUT NUMBER,   
                         p_location_id OUT NUMBER) IS
  BEGIN
   SELECT department_name,
      manager_id,
      location_id
    INTO p_department_name,
      p_manager_id,
      p_location_id
    FROM departments
    WHERE department_id = p_department_id;
  END select_department;

  FUNCTION get_departments(p_department_id number,
                           p_department_name varchar2,
                           p_manager_id number,
                           p_location_id number) RETURN ref_cursor IS
      the_cursor ref_cursor;
    BEGIN
    
     OPEN the_cursor FOR
   SELECT DepartmentEO.DEPARTMENT_ID, 
       DepartmentEO.DEPARTMENT_NAME, 
       DepartmentEO.MANAGER_ID, 
       DepartmentEO.LOCATION_ID
       FROM DEPARTMENTS DepartmentEO
  WHERE DepartmentEO.DEPARTMENT_NAME LIKE DECODE(p_department_name,null,'',p_department_name)||'%' AND
    DepartmentEO.DEPARTMENT_ID = NVL( p_department_id, DepartmentEO.DEPARTMENT_ID) AND
    DepartmentEO.MANAGER_ID = NVL( p_manager_id, DepartmentEO.MANAGER_ID) AND
    DepartmentEO.LOCATION_ID = NVL( p_location_id,DepartmentEO.LOCATION_ID) ;
    RETURN the_cursor;
    END get_departments;
  
 FUNCTION count_departments(p_department_id number,
                           p_department_name varchar2,
                           p_manager_id number,
                           p_location_id number) RETURN NUMBER IS
      the_count NUMBER;
    BEGIN
      SELECT COUNT(*) 
        INTO the_count
         FROM DEPARTMENTS DepartmentEO  WHERE DepartmentEO.DEPARTMENT_NAME LIKE DECODE(p_department_name,null,'',p_department_name)||'%' AND
    DepartmentEO.DEPARTMENT_ID = NVL( p_department_id, DepartmentEO.DEPARTMENT_ID) AND
    DepartmentEO.MANAGER_ID = NVL( p_manager_id, DepartmentEO.MANAGER_ID) AND
    DepartmentEO.LOCATION_ID = NVL( p_location_id,DepartmentEO.LOCATION_ID) ;
      RETURN the_count;
  END count_departments;
  end departments_api;
.
/
show errors