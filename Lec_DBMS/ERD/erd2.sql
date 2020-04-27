
/* Drop Tables */

DROP TABLE join CASCADE CONSTRAINTS;
DROP TABLE lec CASCADE CONSTRAINTS;
DROP TABLE professor CASCADE CONSTRAINTS;
DROP TABLE student CASCADE CONSTRAINTS;
DROP TABLE dept CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE dept
(
	deptno number NOT NULL,
	dp_phone varchar2(10),
	office varchar2(10),
	dp_name varchar2(10) NOT NULL,
	PRIMARY KEY (deptno)
);


CREATE TABLE join
(
	studno number NOT NULL,
	lec_no number NOT NULL
);


CREATE TABLE lec
(
	lec_no number NOT NULL,
	lec_name varchar2(10) NOT NULL,
	credit number,
	num_stu number,
	room varchar2(10),
	lec_year timestamp with time zone,
	prof_no number NOT NULL,
	PRIMARY KEY (lec_no)
);


CREATE TABLE professor
(
	hiredyear timestamp,
	prof_no number NOT NULL,
	prof_jumin char(13) NOT NULL,
	prof_address varchar2(100),
	prof_name varchar2(10) NOT NULL,
	prof_phone varchar2(15),
	position varchar2(10),
	deptno number NOT NULL,
	PRIMARY KEY (prof_no)
);


CREATE TABLE student
(
	studno number NOT NULL,
	name varchar2(10) NOT NULL,
	jumin char(13) NOT NULL UNIQUE,
	grade number,
	address varchar2(100),
	st_phone varchar2(10),
	deptno number NOT NULL,
	PRIMARY KEY (studno)
);



/* Create Foreign Keys */

ALTER TABLE professor
	ADD FOREIGN KEY (deptno)
	REFERENCES dept (deptno)
;


ALTER TABLE student
	ADD FOREIGN KEY (deptno)
	REFERENCES dept (deptno)
;


ALTER TABLE join
	ADD FOREIGN KEY (lec_no)
	REFERENCES lec (lec_no)
;


ALTER TABLE lec
	ADD FOREIGN KEY (prof_no)
	REFERENCES professor (prof_no)
;


ALTER TABLE join
	ADD FOREIGN KEY (studno)
	REFERENCES student (studno)
;



