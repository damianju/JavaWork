
/* Drop Tables */

DROP TABLE tbl_member_auth CASCADE CONSTRAINTS;
DROP TABLE tbl_member CASCADE CONSTRAINTS;




/* Create Tables */


CREATE TABLE tbl_member
(
	userid varchar2(50) NOT NULL PRIMARY KEY,
	userpw varchar2(100) NOT NULL,
	username varchar2(100) NOT NULL,
	regdate date DEFAULT SYSDATE,
	updatedate date DEFAULT SYSDATE,
	enabled char(1) DEFAULT '1'
);


CREATE TABLE tbl_member_auth
(
	userid varchar2(50) NOT NULL,
	auth varchar2(50) NOT NULL,
	CONSTRAINT fk_member_auth FOREIGN KEY(userid) REFERENCES tbl_member(userid),
	PRIMARY KEY(userid, auth) -- 복합키
);

SELECT * FROM tbl_member;
SELECT * FROM tbl_member_auth;

-- 확인
SELECT u.userid, u.userpw ,u.enabled, a.auth
FROM tbl_member u, tbl_member_auth a
WHERE u.userid = a.userid;

DROP FROM tbl_member;
DROP FROM tbl_member_auth;


-- 특정 user
SELECT u.userid, u.userpw ,u.enabled, a.auth
FROM tbl_member u, tbl_member_auth a
WHERE u.userid = a.userid='admin90';

