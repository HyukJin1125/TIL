-- 계층형 쿼리
SELECT department_id, 
       department_name, 
       0 AS PARENT_ID,
       1 as levels,
        parent_id || department_id AS sort
FROM departments 
WHERE parent_id IS NULL
UNION ALL
SELECT t2.department_id, 
       LPAD(' ' , 3 * (2-1)) || t2.department_name AS department_name, 
       t2.parent_id,
       2 AS levels,
       t2.parent_id || t2.department_id AS sort
FROM departments t1,
     departments t2
WHERE t1.parent_id is null
  AND t2.parent_id = t1.department_id
UNION ALL
SELECT t3.department_id, 
       LPAD(' ' , 3 * (3-1)) || t3.department_name AS department_name, 
       t3.parent_id,
       3 as levels,
       t2.parent_id || t3.parent_id || t3.department_id as sort
FROM departments t1,
     departments t2,
     departments t3
WHERE t1.parent_id IS NULL
  AND t2.parent_id = t1.department_id
  AND t3.parent_id = t2.department_id
UNION ALL
SELECT t4.department_id, 
       LPAD(' ' , 3 * (4-1)) || t4.department_name as department_name, 
       t4.parent_id,
       4 as levels,
       t2.parent_id || t3.parent_id || t4.parent_id || t4.department_id AS sort
FROM departments t1,
     departments t2,
     departments t3,
     departments t4
WHERE t1.parent_id IS NULL
  AND t2.parent_id = t1.department_id
  AND t3.parent_id = t2.department_id
  and t4.parent_id = t3.department_id
ORDER BY sort;

SELECT department_id
    , parent_id
    , LPAD(' ', 3 * (level - 1)) || department_name as 부서명
    , level
    from departments
    START WITH parent_id is null                    -- 최상위(root) 조건
    CONNECT BY PRIOR department_id = parent_id ;    -- 계층구조 조건
    
    SELECT employee_id
    , manager_id
    , level
    , LPAD(' ', 3 * (level - 1)) || emp_name as 직원명
FROM employees
START WITH manager_id is null
CONNECT BY PRIOR employee_id = manager_id;

-- 30번 부서직원의 관리자

SELECT a.employee_id
    , level
    ,LPAD(' ', 3 * (level - 1)) || a.emp_name
    , b.department_name
    , b.department_id
FROM employees a
   , departments b
WHERE a.department_id = b.department_id
AND a.department_id = 30        -- start with 전 검색조건
START WITH a.manager_id is null
CONNECT BY PRIOR a.employee_id = a.manager_id
ORDER SIBLINGS BY a.emp_name desc;


-- 부서아이디 : 230 부서명 : IT 헬프데스크
-- 팀의 하위 부서가 신설됐습니다.
-- 5 level에 해당하는 'IT 데이터 수집' 팀을 부서테이블에 INSERT 후 조회하시오

INSERT INTO departments (department_id, department_name, parent_id)
VALUES ('','','');
INSERT INTO departments VALUES(280, 'IT 데이터수집', 230, null, sysdate, sysdate);
/*
-- 아래와 같이 출력되도록 (1) 테이블 생성 ex (테이블 명 : 팀), 최소한의 컬럼
                       (2) 데이터 삽입
                       (3) 계층형쿼리 조회하시오
*/        
CREATE TABLE ex팀 (
아이디 number
,이름 varchar2(10)
,직책 varchar2(10) 
,상위아이디 number
);
INSERT INTO ex팀 VALUES(1, '이사장', '사장', 0);
INSERT INTO ex팀 VALUES(2, '김부장', '부장', 1);
INSERT INTO ex팀 VALUES(3, '서차장', '차장', 2);
INSERT INTO ex팀 VALUES(4, '장과장', '과장', 3);
INSERT INTO ex팀 VALUES(5, '박과장', '과장', 3);
INSERT INTO ex팀 VALUES(6, '이대리', '대리', 4);
INSERT INTO ex팀 VALUES(7, '김대리', '대리', 5);
INSERT INTO ex팀 VALUES(8, '최사원', '사원', 6);
INSERT INTO ex팀 VALUES(9, '강사원', '사원', 6);
INSERT INTO ex팀 VALUES(10, '윤사원', '사원', 7);

 SELECT 이름
    , LPAD(' ', (level - 1 )) || 직책 as 직책
    , level
 
FROM ex팀
START WITH 상위아이디 = 0
CONNECT BY PRIOR 아이디 = 상위아이디
ORDER SIBLINGS BY 이름 desc;

-- CONNECT BY PRIOR 자식 = 부모 Top Dwon
-- CONNECT BY PRIOR 부모 = 자식 Buttom uo
-- 무한루프 상황
              




UPDATE departments
SET parent_id = 170
WHERE department_id = 30;
SELECT *
FROM departments
WHERE department_id = 30;

SELECT department_id
    , parent_id
    , LPAD(' ', 3 * (level - 1)) || department_name as 부서명
    , level
    , CONNECT_BY_ROOT department_name as 최상위데이터
    , CONNECT_BY_ISLEAF as 하위있는지       -- 마지막이면1, 자식이 있으면 0         
    , SYS_CONNECT_BY_PATH (department_name, '|') as 연결정보
    from departments
    START WITH parent_id is null                   
    CONNECT BY PRIOR department_id = parent_id ; 
    
/* LEVEL 은 오라클에서 실행되는 모든 쿼리 내에서 사용가능한
   가상의 열로 (CONNECT BY 절과) 함께 사용된다.
   트리 내에서 어떤 단계에 있는지를 나타내는 정수값.
   정수형 데이터가 필요할 때 사용
*/

SELECT '2017' || lpad(level,2,'0') as 년월
FROM dual
CONNECT BY LEVEL <=12;
-- 201701 ~ 201712

SELECT period            as 년월 
     , sum(loan_jan_amt) as 합계
FROM kor_loan_status
WHERE period like '2011%'
GROUP BY period;
/* 201101      0
   201102      0
   201103...
   201112...      1031611.1
*/

/* CONNECT BY LEVEL을 사용하여(동적으로) 다음날이되면
   쿼리 수정없이 31일까지 출력이 되도록     
   이번달 20220404 ~ 이번달 마지막날 까지 데이터를 출력하시오
*/
SELECT to_char(sysdate,'yyyymm') || lpad(level,2,'0') as 일자
FROM dual
CONNECT BY LEVEL <= to_char(LAST_DAY(SYSDATE),'dd');

select *
from reservation;


/* 
 reservation 테이블을 활용하여 (study계정)
 금천 지점의 요일별 예약수를 출력하시오 (취소제외)
 (1) 요일별 예약수 집계
 (2) 1 ~ 7의 요일 데이터 생성
 (3) (1),(2) 조인하여 출력
*/

SELECT * FROM reservation;

SELECT DECODE(tb2.d, '1','일요일','2','월요일','3','화요일','4','수요일','5','목요일','6','금요일','7','토요일')as 요일
,NVL(tb1.reserv_count,'0') as 예약수
FROM
(SELECT count(reserv_no) as reserv_count
,To_CHAR(To_DATE(reserv_date), 'd')as d
FROM reservation
WHERE cancel = 'N'
AND branch = '금천'
GROUP BY To_CHAR(TO_date(reserv_date),'d')
) tb1
,(
SELECT level as d
FROM dual
CONNECT BY level <=7
) tb2
WHERE tb2.d = tb1.d(+)
ORDER by tb2.d;
