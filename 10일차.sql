-- 문제 1번
SELECT *
FROM customer
WHERE to_number(substr(birth,1,4)) >= 1988
AND job in('의사','자영업')
ORDER BY birth desc;

-- 문제 2번
SELECT CUSTOMER_NAME 
      ,PHONE_NUMBER
      
  FROM
     CUSTOMER a , ADDRESS b
 WHERE a.zip_code = b.zip_code
 And address_detail = '강남구';
 
 
-- 문제 3번
SELECT JOB
,count(*) as CNT

FROM CUSTOMER
WHERE job is not null
GROUP BY job
ORDER BY job desc;

-- 문제 4-1번 너무 어려워요
SELECT to_date (max(FIRST_REG_DATE),'dd') as 요일
   
FROM CUSTOMER;

-- 문제 4-2번 진짜 정신이 나갈거 같아요
SELECT nvl(sex, '합계') as gender
    count(customer_id) as cnt

FROM
(
GRoup by sex_code
ORDER BY sex_code;

-- 문제 5번요 아무것도 모르겠어

SELECT *
FROM RESERVATION;

-- 문제 6번 엄마가 보고싶어요....

SELECT PRODUCT_NAME
 
FROM ITEM;

-- 문제 7번

SELECT SUBSTR(a.reserv_date,1,6) as 매출월
,sum(decode(b.item_id, 'M0001',b.sales,0)) SPECIAL_SET
,sum(decode(b.item_id, 'M0002',b.sales,0)) PASTA
,sum(decode(b.item_id, 'M0003',b.sales,0)) PIZZA
,sum(decode(b.item_id, 'M0004',b.sales,0)) SEA_FOOD
,sum(decode(b.item_id, 'M0005',b.sales,0)) STEAK
,sum(decode(b.item_id, 'M0006',b.sales,0)) SALAD_BAR
,sum(decode(b.item_id, 'M0007',b.sales,0)) SALAD
,sum(decode(b.item_id, 'M0008',b.sales,0)) SANDWICH
,sum(decode(b.item_id, 'M0009',b.sales,0)) WINE
,sum(decode(b.item_id, 'M0010',b.sales,0)) JUICE
FROM RESERVATION a, ORDER_INFO b
WHERE a.reserv_no = b.reserv_no
and a.cancel = 'N'
group by substr(a.reserv_date,1,6)
Order by substr(a.reserv_date,1,6);




-- 문제 8번
SELECT * FROM order_info;
SELECT * FROM item;

SELECT order_month as 날짜
      ,product_name as 상품명
    ,sum(decode(day,'일요일',sales,0)) as 일요일
    ,sum(decode(day,'월요일',sales,0)) as 월요일
    ,sum(decode(day,'화요일',sales,0)) as 화요일
    ,sum(decode(day,'수요일',sales,0)) as 수요일
    ,sum(decode(day,'목요일',sales,0)) as 목요일
    ,sum(decode(day,'금요일',sales,0)) as 금요일
    ,sum(decode(day,'토요일',sales,0)) as 토요일
FROM   
(
    SELECT SUBSTR(ord.reserv_no,1,6) as order_month
          ,item.product_name
          ,ord.sales
,to_char(to_date(SUBSTR(ord.reserv_no,1,8)),'day') as day
from order_info ord
    ,item
WHERE ord.item_id = item.item_id(+)
and item.product_name = 'SPECIAL_SET'
)
group by order_month, product_name
order by 1;
-- 문제 9번

SELECT count(customer_id) as 고객수
,count(decode(sex_code,'M','1')) as 남자
,count(decode(sex_code,'F','1')) as 여자
,round(AVG(age),1) as 평균나이
,round(AVG(duration),1) as 평균거래기간
FROM(
SELECT customer_id
, sex_code
, MONTHS_BETWEEN(sysdate, to_date(birth))/12 as age
, MONTHS_BETWEEN(sysdate, to_date(first_reg_date) as duration
FROM customer
WHERE sex_code is not null
and birth is not null
);

-- 문제 10번 살려주세요 선생님....
SELECT *
FROM address;


