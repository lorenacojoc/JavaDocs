ALTER TABLE EMPLOYEES ADD FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENTS (DEPARTMENT_ID);
ALTER TABLE DEPARTMENTS ADD FOREIGN KEY (LOCATION_ID) REFERENCES LOCATIONS (LOCATION_ID);
ALTER TABLE EMPLOYEES ADD FOREIGN KEY (JOB_ID) REFERENCES JOBS (JOB_ID);
ALTER TABLE EMPLOYEES ADD FOREIGN KEY (JOB_ID) REFERENCES JOBS (JOB_ID);
ALTER TABLE EMPLOYEES ADD FOREIGN KEY (MANAGER_ID) REFERENCES EMPLOYEES (EMPLOYEE_ID);



INSERT INTO DEPARTMENTS VALUES (TAB_DEPARTMENTS_SEQ.nextval, 'Administration', 1700);
ALTER TABLE JOBS MODIFY JOB_ID VARCHAR2(10);
alter table jobs drop constraint JOB_ID;
ALTER TABLE JOBS MODIFY JOB_ID VARCHAR2(10);
ALTER TABLE EMPLOYEES DROP CONSTRAINT FOREIGN KEY (JOB_ID);
INSERT INTO DEPARTMENTS VALUES (TAB_DEPARTMENTS_SEQ.nextval, 'Administration', 1700);
drop table jobs;
alter table jobs drop constraint ;
select constraint_name
from user_cons_columns
where table_name = 'JOBS'
and column_name = 'JOB_ID';

select constraint_name
from user_cons_columns
where table_name = 'EMPLOYEES'
and column_name = 'JOB_ID';
ALTER TABLE EMPLOYEES DROP CONSTRAINT SYS_C007001;

INSERT INTO DEPARTMENTS VALUES (TAB_DEPARTMENTS_SEQ.nextval, 'Administration', 1700);
INSERT INTO LOCATIONS VALUES (1700,'LALA','LALA','LALA','LALA' );
INSERT INTO DEPARTMENTS VALUES (TAB_DEPARTMENTS_SEQ.nextval, 'Administration', 1700);
insert into jobs values
( 'AD_PRES1'
    	    , 'President'
     	    , 20000
          , 40000
);

INSERT INTO employees
     		VALUES (TAB_EMPLOYEES_SEQ.nextval,
             	  'Steven',
                    'King',
                    'SKING',
                    '515.123.4567',
                    sysdate,
                    'AD_PRES',
                    24000,
                    NULL,
                    NULL,
           90);
           
           ALTER TABLE EMPLOYEES
ADD CONSTRAINT PRIMARY KEY (EMPLOYEE_ID);

insert into DEPARTMENTS values
( 90
    	    , 'DEP1'
     	    , 1700
          
);

INSERT INTO employees
     		VALUES (TAB_EMPLOYEES_SEQ.nextval,
             	  'Steven',
                    'King',
                    'SKING',
                    '515.123.4567',
                    sysdate,
                    'AD_PRES',
                    24000,
                    NULL,
                    NULL,
           90);
           
           commit;
           rollback;
           DELETE FROM departments;
           
DELETE FROM JOBS;
DELETE FROM EMPLOYEES;
DELETE FROM DEPARTMENTS;
DELETE FROM LOCATIONS;


        COMMIT;  

SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM JOBS;
SELECT * FROM LOCATIONS;
SELECT FIRST_NAME, LAST_NAME FROM EMPLOYEES;
SELECT * FROM EMPLOYEES E WHERE E.DEPARTMENT_ID = 50;
UPDATE EMPLOYEES SET SALARY=SALARY*1.3 WHERE SALARY=SALARY;
DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID=101;
UPDATE EMPLOYEES SET MANAGER_ID=NULL WHERE MANAGER_ID=101;
DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID=101;
SELECT * FROM EMPLOYEES E INNER JOIN JOBS J ON J.JOB_TITLE = 'IT_PROG' AND E.JOB_ID = J.JOB_ID
ORDER BY E.FIRST_NAME;

SELECT * FROM EMPLOYEES E WHERE E.JOB_ID = 'IT_PROG' 
ORDER BY E.FIRST_NAME;

select count(employee_id) from employees emp where emp.JOB_ID = 'IT_PROG';

SELECT FIRST_NAME,LAST_NAME,D.DEPARTMENT_NAME FROM EMPLOYEES E INNER JOIN DEPARTMENTS D 
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID AND E.DEPARTMENT_ID = 50;

SELECT * FROM EMPLOYEES E INNER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
INNER JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID AND L.LOCATION_ID = 1700;

CREATE VIEW EMPLOYEE_VIEW AS
SELECT employee_id, first_name, department_name FROM employees, departments;

SELECT sysdate from dual;

select to_char(sysdate, 'dd-MM-yyyy') from dual;
select to_date ('25-11-2014', 'dd-MM-yyyy') from dual;

select upper(first_name),lower(email) from employees;

select count(employee_id) from employees;

select LAST_NAME , count(employee_id) from employees where job_id = 'IT_PROG'
GROUP BY LAST_NAME;

SELECT COUNT(EMPLOYEE_ID) FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID;

SELECT AVG(SALARY) FROM EMPLOYEES WHERE DEPARTMENT_ID = 50;

SELECT MIN(SALARY),MAX(SALARY) FROM EMPLOYEES E INNER JOIN DEPARTMENTS D 
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
INNER JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID AND L.LOCATION_ID = 1700;







