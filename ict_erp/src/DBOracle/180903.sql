CREATE SEQUENCE SEQ_music_chart_mcNum INCREMENT BY 1 START WITH 1;

CREATE SEQUENCE SEQ_ticket_movie_tmNum INCREMENT BY 1 START WITH 1;

-- 필자의 경우 user를 system으로 사용하였습니다.
-- create 권한 부여
grant connect to ictu;
grant connect to ictu;
grant create table to ictu;
grant create sequence to ictu;
grant create trigger to ictu;
grant select,insert,update,delete on <user1>.<table> to <user2>;


-- 다음과 같이 한 줄로 써도 됩니다.테이블권한

grant select, insert, update, delete on ictu.MUSIC_CHART to ICTU;
grant select, insert, update, delete on ictu.TICKET_MOVIE to ICTU;

-- SEQUENCE 권한 부여
GRANT SELECT, ALTER on ictu.SEQ_TICKET_MOVIE_TMNUM to ictu;

GRANT SELECT, ALTER on ictu.SEQ_MUSIC_CHART_MCNUM to ictu;