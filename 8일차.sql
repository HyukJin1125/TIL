/* CUSTOMERS 고객 정보를 출력하시오
*/

SELECT *
where
FROM customers;

SELECT cust_name as 이름
, dDEcpecode(cust_gende
r, 'M','남자','F', '여자') as 성별
, to_char(sysdate,'yyyy') - cust_year_of_birth as 나이
, cust_city as 도시
,O(a.duskcimrf,
FROM customers
ORdER BY asc;


SELECT (SELECT cust_nmae
from customers
where cust_id = a.cust_id) 구매고객

,(SELECT )EMP_name
from emloyees
WHERE emplpyye cus _id a.cust_id)as 구매고객;


SELECT b.cust_name as 고객이름
       , c.emp_name as 직원이름
       , count(*)  as cnt
fROM sales a
   , customers b
   , employees c 
 WHERE a.cust_id = b.cust_id
 and a.employee_id = c.employee_id
 group by b.cust_id, b.cust_name
 ,c.employee_id, c.emp_name
 ORDER BY 3 DESC;
 
 -- 세미 조인 (EXISTS <-- 존재하는)
 SELECT department_id
, department_name
FROM departments a
WHERE not EXISTS ( SELECT 1
    FROM employees b
    WHERE a.department_id = b.department_id);
-- 수강이력이 없는 학생 조회
SELECT *
FROM 학생 a
WHERE not EXISTS (select *  
                    from 수강내역
                    where 학번 = a.학번);

-- ANSI JOIN
-- 일반 내부조인 (INNER JOIN)
SELECT * 
FROM  학생
    , 수강내역
    , 과목
WHERE 학생.학번 = 수강내역.학번
ANd   수강내역.과목번호 = 과목.과목번호;

-- ANSI 내부조인(조인관련 내용이 모두 FROM절에 위치함)
SELECT *
FROM 학생
INNER JOIN 수강내역
ON(학생.학번 = 수강내역.학번)
INNER JOIN 과목
ON(수강내역.과목번호 = 과목.과목번호);

-- 일반 외부조인 OUTER JOIN
SELECT * 
FROM 학생
,수강내역
,과목
WHERE 학생.학번 = 수강내역.학번(+)
AND 수강내역.과목번호 = 과목.과목번호(+);
-- ANSI 외부조인
SELECT *
FROM 수강내역
RIGHT JOIN 학생 -- OUTER <-- 숨김가능
ON(학생.학번 = 수강내역.학번)
LEFT OUTER JOIN 과목
ON(수강내역.과목번호 = 과목.과목번호);

-- FULL OUTER JOIN
CREATE TABLE test_a (emp_id number);
CREATE TABLE test_b (emp_id number);
INSERT INTO test_a VALUES(10);
INSERT INTO test_a VALUES(10);
INSERT INTO test_a VALUES(10);

INSERT INTO test_b VALUES(10);
INSERT INTO test_b VALUES(10);
INSERT INTO test_b VALUES(10);
SELECT a.emp_id
      ,b.emp_id
FROM test_a, test_b b
WHERE a.emp_id(+) = b.emp_id(+); -- 일반조인에서는 안됨

SELECT a.emp_id
      ,b.emp_id
FROM test_a a
FULL OUTER JOIN test_b b
ON(a.emp_id = b.emp_id);

-- 2000년도(검색조건) 판매(금액)왕을 출력하시오 (sales)
-- 직원명은 서브쿼리사용(select)
--(1) sales 테이블을 활용하여 직원별 판매금액(amount_sold), 수량을 집계
--(2) 판매금액 기준으로 정렬하여 1건 출력 (인라인 뷰 사용)
--(3) 사번으로 employees테이블 이용하여 이름가져오기 (스칼라서브쿼리 사용)


SELECT (select emp_name from employees 
        where employee_id = a.employee_id) as 직원
        ,판매수량, to_char(판매금액,'999,999,999.99') as 판매금액
FROM(SELECT employee_id
        ,sum(quantity_sold) as 판매수량
        ,sum(amount_sold) as 판매금액
        From sales
        WHERE to_char(sales_date,'yyyy') = '2000'  
        GROUP BY employee_id
        ORDER BY 3 desc
        ) a
        WHERE rownum = 1;
        
-- 2000년도 최다판매상품(수량으로) 1 ~ 3등까지 출력하시오
--(1) 필요한 컬럼 출력
--(2) 집계 및 정렬 후 3건 출력
--(3) 상품아이디로 상품명 출력

select
ROWNUM as 순위
    ,(
        SELECT prod_name
        FROM products
        where products.prod_id = tb1.prod_id
        )as 상품명
        ,to_char(total_sold_price,'999,999,999,999') as 판매금액
        ,total_sold_amount as 판매수량
FROM
(
       SELECT prod_id
        ,sum(quantity_sold) as total_sold_amount
        ,sum(amount_sold) as total_sold_price
        From sales
        WHERE to_char(sales_date,'yyyy') = '2000'
        GROUP BY prod_id
        ORDER BY 2 desc
        ) tb1
        WHERE rownum <= 3;