CREATE USER lorenac IDENTIFIED BY lorenac; -- you should replace my user name with yours. â€œIDENTIFIED BYâ€? means the password.
GRANT CREATE SESSION TO lorenac; -- necessary for connecting to the database with your new user.
GRANT CREATE ANY INDEX TO lorenac; -- we use indexes for faster queries.
GRANT ALTER ANY INDEX TO lorenac;
GRANT DROP ANY INDEX TO lorenac;
GRANT CREATE ANY PROCEDURE TO lorenac; -- we will use them in following workshops.
GRANT ALTER ANY PROCEDURE TO lorenac;
GRANT DROP ANY PROCEDURE TO lorenac;
GRANT EXECUTE ANY PROCEDURE TO lorenac;
GRANT CREATE ANY SEQUENCE TO lorenac; -- we need sequences for inserting data.
GRANT ALTER ANY SEQUENCE TO lorenac;
GRANT DROP ANY SEQUENCE TO lorenac;
GRANT SELECT ANY SEQUENCE TO lorenac;
GRANT CREATE ANY TABLE TO lorenac;
GRANT ALTER ANY TABLE TO lorenac;
GRANT DELETE ANY TABLE TO lorenac;
GRANT DROP ANY TABLE TO lorenac;
GRANT INSERT ANY TABLE TO lorenac;
GRANT LOCK ANY TABLE TO lorenac;
GRANT SELECT ANY TABLE TO lorenac;
GRANT UPDATE ANY TABLE TO lorenac;
GRANT CREATE TABLESPACE TO lorenac;
GRANT ALTER TABLESPACE TO lorenac;
GRANT DROP TABLESPACE TO lorenac;
GRANT CREATE ANY VIEW TO lorenac;
GRANT DROP ANY VIEW TO lorenac;
GRANT UNDER ANY VIEW TO lorenac;
alter user lorenac quota 50m on system;
