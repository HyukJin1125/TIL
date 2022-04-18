UPDATE tb_info
SET
    hobby = '컴퓨터'
WHERE
    nm = '오혁진';

/* 연산자 */
-- 수식 연산자 + - * /

SELECT
    employee_id,
    emp_name,
    round(salary / 30, 2) AS 일당,
    salary AS 월급,
    salary - salary * 0.1 AS 실수령액,
    salary * 12 AS 연봉,
    emp_name
    || ':'
    || email AS 이메일     -- 문자연산자 || <--
FROM
    employees;

--논리 연산자

SELECT * FROM employees WHERE salary = 2600;   -- 같다
SELECT * FROM employees WHERE salary <> 2600;  -- 같지않다
SELECT * FROM employees WHERE salary != 2600;  -- 같지않다
SELECT * FROM employees WHERE salary > 2600;   -- 초과
SELECT * FROM employees WHERE salary < 2600;   -- 미만
SELECT * FROM employees WHERE salary >= 2600;  -- 이상
SELECT * FROM employees WHERE salary <= 2600;  -- 이하

-- products 테이블에서 상품 최저 금액(min_price)가 50원 '미만'인 제품명을 출력하시오.

SELECT
    prod_name,
    prod_min_price
FROM
    products
WHERE
    prod_min_price >= 30
    AND prod_min_price < 50
    AND prod_category = 'Software/Other'
ORDER BY
    prod_min_price DESC;
--30원 '이상' 또는 50원 '미만'
-- AND(그리고)  [A, B 조건 모두 만족할때]
-- OR (또는)    [A, 또는 B 조건에 해당하면]
-- 50 or 60번 부서 직원을 조회하시오

SELECT
    emp_name,
    department_id
FROM
    employees
WHERE
    department_id = 50
    OR department_id = 60;

--TB_INFO에서 취미가 요리 또는 영화감상인 학생을 조회하시오
/*SELECT*
--FROM TB_INFO
WHERE hobby= '요리'
OR hobby = '영화감상';
*/

/* 표현식 CASE*/

SELECT
    cust_gender,
    cust_name,
    CASE
    WHEN cust_gender = 'M' THEN '남자'
    WHEN cust_gender = 'F' THEN '여자'
    ELSE '알 수없음'
END AS 성별
FROM customers;

SELECT
    employee_id,
    salary,
    CASE
        WHEN salary <= 5000 THEN 'C등급'
        WHEN salary > 5000 AND salary <= 15000 THEN 'B등급'
        ELSE 'A등급'
    END AS grade 
FROM  employees
ORDER BY 2 DESC;
    
    /*LIKE 조건식*** */
    SELECT emp_name
    FROM employees
    WHERE emp_name LIKE 'A%'; -- 첫글자가 A로 시작하는 값을 조회할 때('김%' -> 김OO을 조회하고싶다)
    
    CREATE TABLE ex3_5(
    nm varchar2(100)
    );
    INSERT INTO ex3_5 VALUES('홍길');
    INSERT INTO ex3_5 VALUES('홍길동');
    INSERT INTO ex3_5 VALUES('홍길상');
    INSERT INTO ex3_5 VALUES('길상');
    INSERT INTO ex3_5 VALUES('길상홍');
    
    SELECT *
    FROM ex3_5
    WHERE nm like '홍%';    --홍으로 시작하는 값
    WHERE nm like '%홍';    --홍으로 끝나는 값
    WHERE nm like '%홍%';   --홍이 포함된 값
    
    WHERE nm = '홍';        --홍 이라는 글자를 검색할 때 
                            --길이까지 맞아야 할때는 % 대신 언더바( _ ) <- 사용
   WHERE nm like '길__';    --언더바( _ )를 두번 썻음 그럼 길 뒤에 두글자가 더 나옴
   WHERE nm like '_길_';
   --이씨 또는 김씨를 검색하시오
   SELECT *
   FROM TB_INFO
    WHERE nm like '이%' 
    OR nm like '김%';
       --이씨가 아닌 학생을 조회하시오
   
   SELECT *
   FROM TB_INFO
   WHERE NM NOT LIKE '이%'; -- NOT 부정의 의미
   
   -- 메일 주소가 gmail이 아닌 학생을 출력하시오
   SELECT *
   FROM TB_INFO
   WHERE email NOT LIKE '%gmail%';
   
   
   
     
  
   