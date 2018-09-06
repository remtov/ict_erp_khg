SELECT DINUM, DICODE, DINAME, DIDESC FROM ICTU.DEPART_INFO;

grant connect to ictu;
grant create table to ictu;
grant create sequence to ictu;
grant create trigger to ictu;

grant connect to ictu;

grant create table,
      create sequence to ictu;
      
      
      grant select, insert, update, delete on ictu.DEPART_INFO to ictu;
      grant select, insert, update, delete on ictu.LEVEL_INFO to ictu;
      grant select, insert, update, delete on ictu.MEMBER_INFO to ictu;
      
      
      GRANT SELECT, ALTER on ictu.SEQ_Depart_Info_diNum to ictu;
 GRANT SELECT, ALTER on ictu.SEQ_liNum to ictu;
  GRANT SELECT, ALTER on ictu.SEQ_Member_Info_miNum to ictu;
      
      CREATE SEQUENCE SEQ_Depart_Info_diNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_liNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Member_Info_miNum INCREMENT BY 1 START WITH 1;