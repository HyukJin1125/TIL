-- TO_NUMBE 숫자데이터 타입으로

SELECT '12' * '300'
FROM dual;
CREATE TABLE ex5_1(
col varchar2(1000)
);
INSERT INTO ex5_1 VALUES('123');
INSERT INTO ex5_1 VALUES('92');
INSERT INTO ex5_1 VALUES('1111');
INSERT INTO ex5_1 VALUES('999');

SELECT *
FROM ex5_1
ORDER BY TO_NUMBER(col1) desc;

--CUSTOMERS 테이블에서
--CUST_YEAR_OF_BIRTH <- 을 활용하여
--1980년 이후 출생자를 출력하시오
--이름, 출생년도, 나이(나이계산은 올해년도 - 출생년도), 성별 출력


SELECT CUST_NAME
     , CUST_YEAR_OF_BIRTH
     , TO_CHAR(SYSDATE,'yyyy') - CUST_YEAR_OF_BIRTH as 나이
     , CUST_GENDER
FROM CUSTOMERS
WHERE CUST_YEAR_OF_BIRTH >= 1980
ORDER BY 나이 asc, cust_name asc;

/* 집계함수 대상 데이터에서 특정 그룹으로 묶어,대상 그룹에대해
   총합, 평균, 최대값, 최소값 등을 구하는 함수
*/
-- COUNT <-- 로우의 건수집계
SELECT COUNT(*)                          -- null 포함
      ,COUNT(ALL department_id)          -- defulat ALL
      ,COUNT(department_id)              -- all은 중복 포함
      ,COUNT(distinct department_id)     -- 중복제거 
FROM employees;                     

-- 우리반 학생의 수
SELECT COUNT(*)
FROM TB_INFO
WHERE PC_NO !=  'SSAM';

-- AVG: 평균 
 SELECT AVG(mem_mileage)
 FROM member;
 
 
 --employees의 '평균 급여'와 '직원수'를 출력하시오
SELECT ROUND(AVG(SALARY),2)    as 평균급여
      ,COUNT(EMP_NAME) as 직원수
FROM employees;

--
SELECT ROUND(AVG(salary),2)
      ,min(salary)
      ,max(salary)
      ,sum(salary)
FROM employees;

-- 50부서의 직원 수와 평균, 최소, 최대 급여를 출력하시오

SELECT COUNT(employee_id)                as  직원수    
        ,round(avg(salary),2)           as 평균급여
        ,min(salary)                    as 최소
        ,max(salary)                    as 최대
fROM employees
WHERE department_id = 50
or department_id = 60;

-- 부서별 '직원수', '평균급여'
-- GROUP BY 절
SELECT department_id
      ,COUNT(employee_id)     as 부서별직원수
      ,round(AVG(salary),2)            as 부서평균급여  
      FROM employees
      GROUP BY department_id     -- 집계함수를 제외한 select 절에 들어간 컬럼은
                                 -- 그룹바이절에 들어가야함.
      ORDER By 1;
      
-- member 테이블 직업별 고객수를 출력하시오

-- 3명 이상 있는 직업만 출력하시오
SELECT mem_job
    ,COUNT(mem_id)  as 고객수
FROM member
GROUP BY MEM_JOB
HAVING COUNT(mem_id) >=3
ORDER BY 2 desc;


-- distinct 중복제거
SELECT DISTINCT mem_job
FROM member;

-- 년도별, 지역별, 대출총액을 구하시
SELECT region
,sum(loan_jan_amt) as 대출총액
FROM kor_loan_status
GROUP BY region
ORDER by 2 desc;

SELECT substr(period,1,4) as 년도
    ,region
    ,sum(loan_jan_amt)    as 대출합계
    FROM kor_loan_status
WHERE substr(period,1,4) = '2013'
GROUP BY substr(period,1,4),region
HAVING sum(loan_jan_amt) > 500000
ORDER BY 2;

-- !!실행순서!!
-- FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY
--
-- 직원수가 30명 이상인 부서와 직원수를 출력하시오
-- employees
SELECT department_id
,count(employee_id) as 직원수
FROM employees
gROUP BY department_id
HAVING count(employee_id) >= 30;

SELECT *
FROM(
    SELECT rownum as rnum
        ,a.*
        FROM( 
        SELECT *
        FROM member
        ORDER BY mem_name
        ) a
        )
        WHERE rnum between 11 and 20;
        
-- 의사컬럼 ROWNUM: 테이블에 없는데 있는것 처럼 사용
-- 임시로 번호가 생김
SELECT rownum as rnum
, a.*
FROM employees a;

-- 고용 요일별 입사직원수를 조회하시오
-- hire_date
-- employees에 있는 직원 
SELECT TO_char(hire_date,'day') as 요일
 ,count(employee_id) as 직원수
 FROM employees
 group by to_CHAR(hire_date,'day') 
 ORDER by 2 desc;
 
 
 SELECT cust_gender
 ,cust_name
 ,case when cust_Gender = 'M' then '남자'
       when cust_gender = 'F' then '여자'
       else '?'
       end as gender
       , DECODE(cust_gender, 'M', '남자', 'F', '여자', '?') gender2
                           --조건1 결과1 --조건2 --결과2 그밖에
FROM customers;

-- 직원의 고용일자 컬럼을 활용하여
-- 년도별 요일별 입사인원수를 출력하시오 (정렬 년도)
-- ex)TO_CHAR, DECODE, GROUP BY, COUNT, SUM.. 사용

--(1) 고용일자 데이터로 년도컬럼 생성, 요일 컬럼 생성
--(2) 생성한 데이터로 집계
SELECT TO_CHAR(HIRE_DATE,'yyyy') as 년도
    ,count(decode(to_char(hire_date,'day'),'일요일',1)) as 일요일
    ,count(decode(to_char(hire_date,'day'),'월요일',1)) as 월요일
    ,count(decode(to_char(hire_date,'day'),'화요일',1)) as 화요일
    ,count(decode(to_char(hire_date,'day'),'수요일',1)) as 수요일
    ,count(decode(to_char(hire_date,'day'),'목요일',1)) as 목요일
    ,count(decode(to_char(hire_date,'day'),'금요일',1)) as 금요일
    ,count(decode(to_char(hire_date,'day'),'토요일',1)) as 토요일
    ,count(employee_id) as년도별전체
FROM employees
group by TO_CHAR(hire_date,'yyyy')
ORDER BY TO_CHAR(hire_date,'yyyy');




 







