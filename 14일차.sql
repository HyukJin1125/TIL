/* 분석함수 
분석함수(매개변수) OVER (PRATITION BY exp1, exp2...
						ORDER BY expr3, exp4...
						WINDOW ... )
PARTITION BY : 계산 대상 그룹지정
ORDER BY : 대상 그룹에 대한 정렬
WINDOW : 파티션으로 분할된 그룹에 대해 더 상세한 그룹을 분할
*/

SELECT
	department_id,
	emp_name,
	ROW_NUMBER() OVER ( -- 부서번호별 ROW NUMBER
		PARTITION BY department_id
		ORDER BY
		emp_name
	) AS dep_row
FROM
	EMPLOYEES e ;
	
SELECT
	department_id,
	emp_name,
	ROW_NUMBER () OVER (
							PARTITION BY DEPARTMENT_ID 
							ORDER BY
								EMP_NAME 
							) AS dep_row,
	round(avg(salary) OVER(PARTITION BY DEPARTMENT_ID)) AS dep_avg,
	round(avg(salary) OVER()) AS all_avg
FROM
	EMPLOYEES;
	
-- 모든 학생의 이름, 전공, 전공별 평점평균, 전체 평균평점을 출력하시오
SELECT
	이름,
	전공,
	ROUND(AVG(평점) OVER(PARTITION BY 전공), 2) AS 전공평균평점,
	ROUND(AVG(평점) OVER(), 2) AS 전체평균평점
FROM
	학생;

-- RANK()
-- 동일한 순윈느 건너뜀
-- DENSE_RANK()
-- 건너뛰지 않음

-- 부서별 직원의 월급 순위

SELECT
	DEPARTMENT_ID ,
	EMP_NAME ,
	RANK() OVER (
		PARTITION BY DEPARTMENT_ID
	ORDER BY
		SALARY DESC
	) AS rank_dep,
	DENSE_RANK() OVER (
		PARTITION BY DEPARTMENT_ID
	ORDER BY
		SALARY DESC
	) AS dense_rank_dep
FROM
	EMPLOYEES e
WHERE
	DEPARTMENT_ID IN(
		30, 60
);
-- 부서별로 월급을 가장 많이 받는 직원 1명씩 출력하시오

SELECT
	emp_name,
	department_id,
	salary,
	rank_dep
FROM
	(
		SELECT
			e.*,
			RANK() OVER (
				PARTITION BY DEPARTMENT_ID
			ORDER BY
				SALARY DESC
			) AS rank_dep
		FROM
			EMPLOYEES e
	)
WHERE
	rank_dep = 1
ORDER BY
	department_id;

-- 부서별 월급 이용이 많이 드는 순위를 출력하시오

SELECT
	tb1.* , 
	RANK() OVER (
	ORDER BY
		TOTAL_SALARY DESC
	) AS dep_rank
FROM
	(
		SELECT
			department_id,
			sum(salary) AS TOTAL_SALARY
		FROM
			EMPLOYEES
		WHERE
			DEPARTMENT_ID IS NOT NULL
		GROUP BY
			DEPARTMENT_ID
	) tb1;


SELECT
	department_id,
	sum(salary) AS total_salary,
	RANK() OVER(ORDER BY SUM(SALARY) DESC) AS dep_rank
FROM
	EMPLOYEES e
WHERE
	DEPARTMENT_ID IS NOT NULL
GROUP BY
	DEPARTMENT_ID;

-- CART, PROD 테이블을 활용하여 물품별 판매금액의 순위를 출력하시오
-- DENSE_RANK 사용

SELECT * FROM CART;
SELECT * FROM PROD;

SELECT
	cart.CART_PROD,
	prod.PROD_NAME,
	sum(cart.CART_QTY * prod.PROD_SALE) AS total_sales,
	DENSE_RANK() OVER(
		ORDER BY sum(cart.CART_QTY * prod.PROD_SALE) DESC) AS sales_rank
FROM
	CART,
	PROD
WHERE
	cart.CART_PROD = prod.PROD_ID(+)
GROUP BY
	cart.CART_PROD,
	prod.PROD_NAME;

-- LAG 선행로우 값 반환
-- LEAD 후행로우 값 반환

SELECT
	EMP_NAME ,
	DEPARTMENT_ID ,
	SALARY ,
	LAG(EMP_NAME, 1, '가장높음') OVER(PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) AS AP_EMP, -- 1단계 앞 로우의 EMP_NAME
	LEAD(EMP_NAME, 2, '가장낮음') OVER(PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) AS AP_EMP  -- 1단계 뒤 로우의 EMP_NAME
FROM
	EMPLOYEES
WHERE 
	DEPARTMENT_ID IN (30,60);

-- 각 학생들의 평점이 1단계 높은 학생과의 평점 차이를 출력하시오

SELECT * FROM 학생;

SELECT
	학번,
	이름,
	ROUND(평점, 2) AS 평점,
	LAG(이름, 1, '1등') OVER(ORDER BY 평점 DESC) AS 앞사람,
	ROUND(LAG(평점, 1, 평점) OVER(ORDER BY 평점 DESC) - 평점, 2) AS 차이
FROM
	학생;

SELECT 
	COUNT(*) OVER() AS 전체건수,
	emp.*
FROM EMPLOYEES emp;


