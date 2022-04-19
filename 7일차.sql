SELECT *
FROM 학생;

SELECT *
FROM 수강내역;

SELECT 학생.이름
     , 수강내역. 강의실
     , 과목.과목이름
FROM  학생
    , 수강내역
    , 과목
WHERE 학생.학번 = 수강내역.학번(+)
AND 수강내역.과목번호 = 과목.과목번호(+);
/*
    외부조인 (Outer Join)
    조인 조건에 만족하는 데이터가 어느 한 쪽에 값이 널이어도
    모두 추출해야할 때 사용 null이 포함되는 쪽에 (+)<- 사용
*/

SELECT 학생.학번
      ,학생.이름
      ,COUNT(수강내역.수강내역번호) 수강건수
FROM 학생
   , 수강내역
WHERE 학생.학번 = 수강내역.학번(+)
GROUP BY 학생.학번
       , 학생.이름;

-- 모든 교수의강의이력을 출력하시오
-- 교수이름, 전공, 강의내역번호, 과목번호, 강의실
       
SELECT 교수.교수이름
     , 교수.전공
     ,count( 강의내역.강의내역번호) as 강의교수    
FROM     교수, 강의내역
WHERE    교수.교수번호 =  강의내역.교수번호(+)
GROUP BY 교수.교수이름 
       , 교수.전공
ORDER BY 3 desc;

-- 학생들의 '수강건수'와 '수강평점합계'를 출력하시오
--                     과목에 학점이 있음
-- (1) 각 테이블별 필요한 컬럼 조회
-- (2) 조인 후 필요한 컬럼 조회
-- (3) 집계함수 사용
-- (4) 건수 체크
SELECT 학생.이름
     , count(수강내역.수강내역번호)     as 수강건수
     , NVL(sum(과목.학점),0)          as 수강학점합계
FROM 학생
   , 수강내역
   , 과목
WHERE 학생.학번 = 수강내역.학번(+)
AND 수강내역.과목번호 = 과목.과목번호(+)
GROUP BY 학생.학번
        ,학생.이름
ORDER BY 2 desc;

/* 서브쿼리 (sub query)
    SQL문장 안에 보조로 사요오디는 또 다른 SELECT문
    
   1. 메인 쿼리와 연관성에 따라
    (1) 연관성 없는 서브 쿼리
    (2) 연관성 있는 서브쿼리
   2. 형태(위치)에 따라
    (1) 일반 서브쿼리(SELECT 절) 스칼라 서브쿼리라고도 함.
    (2) 인라인뷰 (FROM 절)
    (3) 중첩쿼리 (WHERE 절)
*/

SELECT emp_name
     , department_name
From employees a
   , departments b
WHERE a.department_id = b.department_id;
-- (1) 일반 서브쿼리(SELECT 절) '스칼라 서브쿼리'라고도 함.
-- 1:1 매핑되어야함.
-- 성능의 문제 때문에 가벼운 테이블에만 사용 함
SELECT a.emp_name
    , a.department_id
    , (select department_name
       from departments
       where department_id = a.department_id) as nm
       FROM employees a
       ;
       -- 학생, 수강내역
       SELECT 학생.이름
      , (select 과목이름
        from 과목
        where 과목.과번호 = 수강내역.과목번호) as 과목명
       fROM 학생, 수강내역
       where 학생.학번 = 수강내역.학번;

-- (2) 인라인뷰 (FROM절)
-- SELECT 출력결과를 테이블처럼 사용
SELECT *
FROM ( SELECT rownum as rnum
            , a.*
        FROM 학생 a
     ) t1
WHERE t1.rnum BETWEEN 1 and 10;

-- 평점이 높은 5명의 학생만 출력하시오
-- (1) 평점 높은 학생부터 출력되도록 정렬
SELECT 이름
      ,평점
FROM 학생
ORDER BY 평점 DESC;
-- (2) 정렬된 결과에 rownum 생성하여 인라인 뷰를 만듬
-- (3) (2) 결과에서 2 ~ 5등까지만 나도록 조건
SELECT *
FROM(SELECT rownum as rnum
    , a.*
FROM (SELECT 이름
            ,평점
        FROM 학생
        ORDER BY 평점 desc) a
       )
WHERE rnum BETWEEN 2 AND 5;

-- (3) 중첩쿼리 (WHERE절)
-- 전체 직원의 평균월급 이상 받는 직원만 출력하시오
SELECT *
fROM employees
WHERE salary >= (SELECT avg(salary)
                FROM employees);

-- 수강내역이 있는 학생만 학생정보를 조회하시오
SELECT *
FROM 학생
WHERE 학번 IN (SELECT distinct 학번
              FROM 수강내역);
-- 수강내역이 없는 학생
SELECT *
FROM 학생
WHERE 학번 not in (SELECT distinct 학번
                   FROM 수강내역);
                   
-- 평균평점 이상인 학생만 조회하시오
SELECT *
FROM 학생
WHERE 평점 >= (SELECT avg(평점)
               FROM 학생);
               
-- member, cart
-- 고객의 cart 사용 이력의 최대, 최소 건수를 출력하시오

SELECT min(cnt) as 최소
     , max(cnt) as 최대
FROM (SELECT a.mem_id
           , a.mem_name
           , count(b.cart_no) as cnt
FROM member a, cart b
WHERE a.mem_id = b.cart_member
GROUP BY a.mem_id, a.mem_name);

/* member, cart, prod 테이블을 사용하여
    고객별 카트 사용횟수, 구매상품 품목 수, 전체 상품 구매 수, 총 구매 금액을 출력하시오
    (구매이력이 없으면 0건, 정렬조건 카트사용 내림)
    (구매금액 prod_sale 구매수량 cart_qty)
*/
SELECT * FROM member;
SELECT * FROM cart;
SELECT * FROM prod;

SELECT mem.mem_name as 이름
    ,count(DISTINCT memcart.cart_prod) as 카트사용횟수
    ,count(DISTINCT memcart.cart_prod) as 구매상품_품목수
    ,sum(memcart.cart_qty) as 전체상품_구매수
    ,sum(memcart.toal_price) as 총구매금액
FROM
(
    SELECT mem.mem_name as 이름
          , mem.mem_id as 고객번호
          , cart.cart_no as 장바구니번호
          , cart.cart_prod as 제품번호
          , cart.cart_qty as 수량
          , prod.prod_sale as 가격 
          , cart.cart_qty * prod.prod_sale as 결제금액
          FROM member mem
          , cart
          , prod
          WHERE mem.mem_id = cart.cart_member
          )
          GROUP BY mem.mem_name
          ORDER BY 카트사용횟수 desc;