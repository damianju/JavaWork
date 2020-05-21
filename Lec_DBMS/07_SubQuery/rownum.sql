-- SELECT 결과물중 맨 위의 5개만 출력해보고 싶으면 어케 해야 하나?
--   ex) 게시판.. 페이징

-- DBMS 마다 구현 방법 다름
--	MYSQL : LIMIT
-- 	MS SQL server : TOP
-- 	ORACLE : ROWNUM 

SELECT EMPNO , ENAME , SAL 
FROM T_EMP ;


-- 자동적으로 오라클에서 붙여주는 행번호 객체 (ROWNUM)
SELECT ROWNUM, EMPNO , ENAME , SAL 
FROM T_EMP ;


-- 직원번호 역순. 그러나 ROWNUM은 1 ~
SELECT ROWNUM, EMPNO , ENAME , SAL 
FROM T_EMP 
ORDER BY EMPNO DESC 
;


-- 상위 5개만!
SELECT ROWNUM, EMPNO , ENAME , SAL 
FROM T_EMP 
WHERE ROWNUM <=5
ORDER BY EMPNO DESC ;

-- SELECT에 ROWNUM 없어도 동작
SELECT EMPNO , ENAME , SAL 
FROM T_EMP 
WHERE ROWNUM <=5
ORDER BY EMPNO DESC ;

-- ROWNUM > 5 ?? 동작 안 함 .. ROWNUM 범위가 1이 포함 안 되면 동작 안 함.
SELECT ROWNUM, EMPNO , ENAME , SAL 
FROM T_EMP 
WHERE ROWNUM > 5
ORDER BY EMPNO DESC ;

-- 상위 5개 출력
-- ROW 1~ROW 5까지 출력 (1PAGE)
SELECT ROWNUM, EMPNO , ENAME , SAL 
FROM T_EMP 
WHERE ROWNUM > =1 AND ROWNUM < 1+5
ORDER BY EMPNO DESC ;

-- 2PAGE
SELECT ROWNUM, EMPNO , ENAME , SAL 
FROM T_EMP 
WHERE ROWNUM > =6 AND ROWNUM < 6+5
ORDER BY EMPNO DESC ; -- 안 나온다 


-- PHONBOOK 뻥튀기
INSERT INTO PHONEBOOK (SELECT * FROM PHONEBOOK); -- 에러 PRIMARY KEY 중복!

INSERT INTO PHONEBOOK (SELECT PHONEBOOK_SEQ.NEXTVAL, PB_NAME , PB_PHONENUM , PB_MEMO , SYSDATE FROM PHONEBOOK );

SELECT * FROM PHONEBOOK ;

-- ROWNUM rev.
SELECT PB_UID, PB_NAME, PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID DESC ;

SELECT T.*
FROM (SELECT PB_UID, PB_NAME, PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID DESC ) T
;

SELECT ROWNUM AS RNUM, T.*
FROM (SELECT PB_UID, PB_NAME, PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID DESC ) T
;

-- P1
SELECT * FROM 
(
SELECT ROWNUM AS RNUM, T.*
FROM (SELECT PB_UID, PB_NAME, PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID DESC ) T
)
WHERE RNUM >= 6 AND RNUM < 6+ 5;

-- P2
SELECT * FROM 
(
SELECT ROWNUM AS RNUM, T.*
FROM (SELECT PB_UID, PB_NAME, PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID DESC ) T
)
WHERE RNUM >= 11 AND RNUM < 11+ 5;

--P3
SELECT * FROM 
(
SELECT ROWNUM AS RNUM, T.*
FROM (SELECT PB_UID, PB_NAME, PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID DESC ) T
)
WHERE RNUM >= 16 AND RNUM < 16+ 5;

SELECT * FROM 
(
SELECT ROWNUM AS RNUM, T.*
FROM (SELECT PB_UID, PB_NAME, PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID DESC ) T
)
WHERE RNUM >= 21 AND RNUM < 21+ 10;

-- 한 페이지 5개 글
-- 4 페이지는
-- WHERE RNUM >= 21 AND RNUM < 21+ 5;

SELECT * FROM 
(
SELECT ROWNUM AS RNUM, T.*
FROM (SELECT PB_UID, PB_NAME, PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID DESC ) T
)
WHERE RNUM >= ? AND RNUM < ?+ ?;




