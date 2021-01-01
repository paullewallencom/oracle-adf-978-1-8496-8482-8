create or replace package departments_api as
  procedure insert_department(p_department_id number,
                           p_department_name varchar2,
                           p_manager_id number,
                           p_location_id number);
  procedure update_department(p_department_id number,
                           p_department_name varchar2,
                           p_manager_id number,
                           p_location_id number);
  procedure delete_department(p_department_id number);
  procedure lock_department(p_department_id number,
                         p_department_name OUT varchar2,
                         p_manager_id OUT number,
                         p_location_id OUT number);
  procedure select_department(p_department_id number,
                         p_department_name OUT varchar2,
                         p_manager_id OUT number,
                         p_location_id OUT number);  
                         TYPE ref_cursor IS REF CURSOR;
  function get_departments(p_department_id number,
                           p_department_name varchar2,
                           p_manager_id number,
                           p_location_id number) RETURN ref_cursor;
  function count_departments(p_department_id number,
                           p_department_name varchar2,
                           p_manager_id number,
                           p_location_id number) RETURN NUMBER;   
end departments_api;
.
/
show errors