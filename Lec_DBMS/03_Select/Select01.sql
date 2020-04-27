-- dual 은 row 1개 짜리 dummy Table;
SELECT 'abcde' FROM  dual;
SELECT '안녕하세요' FROM dual;
SELECT 100 FROM dual;
SELECT 100+10 FROM DUAL;

-- *: 모든 컬럼
SELECT * FROM  T_EMP;

-- 원하는 컴럼만 조회
SELECT  EMPNO, ENAME 
FROM T_EMP;

SELECT *
FROM T_PROFESSOR ;

SELECT NAME, BONUS 
FROM T_PROFESSOR;

SELECT '안녕하세요'
FROM T_PROFESSOR ;

SELECT name, '교수님 싸랑해요'
FROM  T_PROFESSOR ;

-- 컬럼 별명(alias) 사용한 출력
SELECT STUDNO 학번, NAME 이름 
FROM T_STUDENT ;

SELECT STUDNO  "학번", NAME AS 이름
FROM T_STUDENT ;

SELECT STUDNO "학생 학번", NAME 이름  -- SQL Error [923] [42000]: ORA-00923: FROM keyword not found where expected
FROM T_STUDENT ;

SELECT EMPNO AS 사원번호, ENAME AS 사원명, JOB AS 직업
FROM  T_EMP ;

SELECT DEPTNO AS 부서#, DNAME AS 부서명, LOC AS 위치
FROM T_DEPT ;

-- DISTINCT
SELECT * FROM T_EMP ;

SELECT DISTINCT DEPTNO
FROM T_EMP ;

SELECT DISTINCT DEPTNO1 
FROM T_STUDENT;

SELECT DISTINCT JOB
FROM T_EMP ;

--|| : 필드, 문자열 연결 연산
SELECT NAME, "POSITION" 
FROM T_PROFESSOR ;

SELECT NAME || '-' || "POSITION" AS 교수님명단
FROM T_PROFESSOR ;

SELECT NAME || '의 키는 ' || HEIGHT || 'cm, 몸무게는 '|| WEIGHT ||'kg 입니다' "학생의 키와 몸무게"
FROM T_STUDENT ;

