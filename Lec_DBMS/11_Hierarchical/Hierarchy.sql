-- 계층형 쿼리(Hierarchical Query)

SELECT * 
FROM T_DEPT2 ;  -- 서로의 계층관계 주목!

SELECT LAPD(DNAME, 10, '*') 부서명 FROM T_DEPT2;

-- LEVEL
SELECT DNAME, LEVEL 
FROM T_DEPT2 
CONNECT BY PRIOR DCODE = PDEPT
START WITH DCODE = 0001; 

-- SQL Error [1788] [42000]: ORA-01788: CONNECT BY clause required in this query block

/* 해설
 * LEVEL 은 오라클에서 계속 사용할 수 있는 것으로
 * 해당 데이터가 몇번째 단계 이냐를 의미하는 것.
 * 
 * CONNECT BY PRIOR  :  각 row 들이 어떻게 연결되어야 하는지 조건 지정
 * PRIOR를 어느쪽에 주느냐가 중요!
 */

-- PRIOR를 다른데 주면?
SELECT DNAME, LEVEL 
FROM T_DEPT2 
CONNECT BY  DCODE = PRIOR PDEPT
START WITH DCODE = 0001; 


SELECT DCODE , DNAME, PDEPT ,LEVEL 
FROM T_DEPT2 
CONNECT BY  DCODE = PRIOR PDEPT
--START WITH DCODE = 1005; ---SW지원3 ==> 기술부2 ==> 사장실1
START WITH DCODE = 1011;


SELECT LPAD(DNAME , LEVEL * 6, '*') 부서명 
FROM T_DEPT2 
CONNECT BY PRIOR DCODE = PDEPT 
START WITH DCODE = 0001;

---
SELECT * FROM T_EMP2 ;

SELECT LPAD(e.NAME || ' ' || D.DNAME || ' '|| NVL(E.POST, '사원'), LEVEL*22, '-') "이름과 직급" 
FROM T_EMP2 e, (SELECT DNAME , DCODE , PDEPT FROM T_DEPT2) d
WHERE e.DEPTNO = d.DCODE
CONNECT BY PRIOR e.EMPNO  = e.PEMPNO
START WITH e.EMPNO = 20000101
;

SELECT LEVEL -1 HR
FROM DUAL 
CONNECT BY LEVEL <= 24;


-- 입양 시각 구하기 (https://programmers.co.kr/learn/courses/30/lessons/59413?language=oracle)
SELECT b.HR, COUNT(a.DATETIME) 
FROM ANIMAL_OUTS a RIGHT OUTER JOIN (SELECT LEVEL -1 HR FROM DUAL CONNECT BY LEVEL <= 24) b
ON TO_NUMBER(TO_CHAR(a.DATETIME, 'HH24')) = b.HR 
GROUP BY b.HR
ORDER BY 1;
