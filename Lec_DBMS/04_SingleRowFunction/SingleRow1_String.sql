-- INITCAP() 함수


-- #4101
SELECT INITCAP('pretty girl')
FROM dual;

-- #4102
SELECT ID , INITCAP(ID) ID
FROM T_STUDENT 
WHERE DEPTNO1 = 201;

-- LOWER(), UPPER()
-- #4103
SELECT NAME ,ID , UPPER(ID) 대문자, LOWER(ID) 소문자 
FROM T_STUDENT
WHERE DEPTNO1 = 201;

-- LENGTH / LENGTHB
-- #4104
SELECT NAME , ID , LENGTH (ID) 글자수
FROM T_STUDENT 
WHERE LENGTH (ID) >= 9; -- 단일행 함수는 조건절 사용 가능

-- #4105
SELECT  NAME 이름, LENGTH (NAME) 길이, LENGTHB(NAME) 바이트
FROM T_STUDENT 
WHERE DEPTNO1 = 201;

-- CONCAT
-- #4106
SELECT CONCAT(NAME , "POSITION" ) 교수님명단
FROM T_PROFESSOR 
WHERE DEPTNO = 101;

-- SUBSTR()
SELECT substr('ABCD', 20,3) -- 에러 아님(NULL) 출력
FROM dual;

SELECT substr('ABCDE', -2,2) -- DE
FROM dual;

-- #4107
SELECT NAME, SUBSTR(JUMIN , 1,6) 생년월일
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4108
SELECT NAME , SUBSTR(JUMIN , 1, 6) 생년월일
FROM T_STUDENT 
--WHERE SUBSTR(JUMIN , 3, 2) = '08'; -- SUBSTR의 결과는 STRING, NUMBER 보다는 STRING을 쓰자
WHERE jumin LIKE '__08%'

-- #4109
SELECT NAME , JUMIN 
FROM T_STUDENT 
WHERE GRADE = 4 AND SUBSTR(JUMIN , 7, 1)= '2' ;

--SUBSTRB
SELECT SUBSTRB(name, 1, 3), NAME 
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

--INSTR() 함수
SELECT INSTR('A*B*C*', '*', 1, 1) FROM dual;	--2
SELECT INSTR('A*B*C*', '*', 1, 2) FROM dual;	--4
SELECT INSTR('A*B*C*', '*', 3, 2) FROM dual;	--6
SELECT INSTR('A*B*C*', '*', -4, 1) FROM dual;  -- 2 --음수 인덱스의 경우 검색도 음의 방향으로 진행
SELECT INSTR('A*B*C*', '*', -4, 2) FROM dual;  -- 0 없으면 0리턴
SELECT INSTR('A*B*C*', '*', -2, 2) FROM dual;  -- 2

-- #4110
--SELECT NAME , TEL, INSTR(TEL, ')', 1, 1) 위치
SELECT NAME , TEL, INSTR(TEL, ')') 위치 -- defualt 값 빼도 동작
FROM T_STUDENT
WHERE DEPTNO1 = 101;

-- #4111
SELECT NAME , TEL , SUBSTR(TEL , 1, INSTR(TEL , ')')-1) 지역번호 
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4112
SELECT id, LPAD(id, 10, '$') LPAD
FROM T_STUDENT
WHERE DEPTNO1 = 101;

-- LTRIM(), RTRIM(), TRIM()
SELECT LTRIM('슈퍼슈퍼슈가맨', '슈퍼') LTRIM1, --가맨: 슈퍼슈퍼 반복해서 지움 
LTRIM('슈퍼슈퍼슈가맨', '슈') LTRIM2, -- 퍼슈퍼슈가맨
LTRIM('  슈퍼슈가맨', ' ') LTRIM, 
LTRIM('  슈퍼슈가맨') LTRIM, -- defualt 공백 제거 
RTRIM(' 슈퍼슈가맨      ') RTRIM, -- defualt 공백 제거 
TRIM('       슈퍼슈가맨      ') TRIM, -- defualt 공백 제거 
LTRIM('******1000','*')
FROM dual;

-- #4116
SELECT  DNAME, LTRIM(DNAME, '영'), RTRIM(DNAME , '부') 
FROM T_DEPT2 ;

-- REPLACE 함수
SELECT REPLACE ('아버지가 방에 들어간다', ' ', '')
FROM  dual;

-- #4118
SELECT REPLACE (NAME , SUBSTR(NAME, 1,1), '#' ) 학생
FROM T_STUDENT 
WHERE DEPTNO1 = 102;

-- #4119
SELECT REPLACE (NAME , SUBSTR(NAME, 2,1), '#' ) 학생
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4120
SELECT NAME , jumin, REPLACE (JUMIN, SUBSTR(JUMIN , 7, 7), '*******') -- 주민번호 처럼 폭이 일정한 값은 연산 속도가 빠른 CHAR로 정의
FROM  T_STUDENT 
WHERE DEPTNO1  = 101;

-- #4121
SELECT NAME , TEL , REPLACE (tel, SUBSTR(tel, INSTR(tel, ')') + 1, 3 ), '###') 전화번호
FROM T_STUDENT 
WHERE DEPTNO1 = 102;





