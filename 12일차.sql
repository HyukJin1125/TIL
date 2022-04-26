10일차에 풀었던 문제들 풀이 하는 시간 가짐

-----------------------------------

-- DMBS_RANDOM.VALUE
-- 0 ~ 까지 난수 랜덤생성
SELECT DBMS_RANDOM.VALUE() * 10 as 난수1
     , DBMS_RANDOM.VALUE(0,  10) as 난수2
-- 0 ~ 10 자연수 랜덤생성
     , ROUND(DBMS_RANDOM.VALUE() * 10) as 난수3
     , ROUND(DBMS_RANDOM.VALUE(0,  10)) as 난수4
FROM dual;

CREATE TABLE ex12_1 as
SELECT rownum as seq
     , to_char(sysdate,'yyyy') || LPAD(ceil(rownum / 1000),2,'0') as months 
     , ROUND(DBMS_RANDOM>VALue(100,1000)) as amt
FROM dual
CONNECT BY level <= 12000;

SELECT *
FROM 학생
ORDER BY DBMS_RANDOM.VALUE;

SELECT *
FROM tb_info;
/* 
TB_INFO 에서 DBMS_RANDOM.VALUE를 활용하여
SSAM을 제외하고 랜덤으로 학생 1명만 뽑은 SQL을 작성하시오
*/
SELECT NM
FROM(
SELECT *
FROM TB_INFO
WHERE PC_NO not like '%SSAM%'
ORDER BY DBMS_RANDOM.VALUE
)
WHERE rownum = 1;

/*
    가장 매출이 높은 지점의 BEST TOP3 메뉴이름과 가격을 출력하시오
    (1) 가장 매출이 높은 지점명 SQL 
    (2) 지점의 메뉴 매출순위 3개 출력
    (3) (1)의 지점명으로 (2)를 조회하여 출력
    study계정의 item, order_info, reservation 활용
*/

SELECT
rownum as 순위,
tb1.*
FROM
(
SELECT i.product_desc,6
     , i.price
 FROM   item i
        ,order_info oi
        ,reservation r
WHERE   i.item_id = oi.item_id
AND     oi.RESERV_NO = r.RESERV_NO
AND     r.branch = (
SElECT 
branch
FRoM
(
SELECT  r.branch 
       ,sum(oi.sales) as total_sales
fROM order_info oi
    ,reservation r
WHERE oi.reserv_no = r.reserv_no
AND r.cancel = 'N'
GROUP BY r.branch
ORDER BY 2 desc
)
WHERE rownum = 1)
GROUP BY i.product_desc
        ,i.price
ORDER BY 
sum(oi.sales) desc
) tb1
WHERE rownum <= 3;
