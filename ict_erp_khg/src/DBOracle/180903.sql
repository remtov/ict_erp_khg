CREATE SEQUENCE SEQ_music_chart_mcNum INCREMENT BY 1 START WITH 1;

CREATE SEQUENCE SEQ_ticket_movie_tmNum INCREMENT BY 1 START WITH 1;

-- ������ ��� user�� system���� ����Ͽ����ϴ�.
-- create ���� �ο�
grant connect to ictu;
grant connect to ictu;
grant create table to ictu;
grant create sequence to ictu;
grant create trigger to ictu;
grant select,insert,update,delete on <user1>.<table> to <user2>;


-- ������ ���� �� �ٷ� �ᵵ �˴ϴ�.���̺����

grant select, insert, update, delete on ictu.MUSIC_CHART to ICTU;
grant select, insert, update, delete on ictu.TICKET_MOVIE to ICTU;

-- SEQUENCE ���� �ο�
GRANT SELECT, ALTER on ictu.SEQ_TICKET_MOVIE_TMNUM to ictu;

GRANT SELECT, ALTER on ictu.SEQ_MUSIC_CHART_MCNUM to ictu;