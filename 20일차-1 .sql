-- 1-1번 문제
SELECT 
    CATEGORY_ID
    ,PRODUCT_name
    ,PRODUCT_DESC
    FROM ITEM
    WHERE category_id ='FOOD';
-- 1-2번 문제
SELECT CUSTOMER_NAME 
      ,PHONE_NUMBER
FROM
     CUSTOMER a 
   , ADDRESS b
 WHERE a.zip_code = b.zip_code
 And address_detail = '강남구';
 
 -- 2번 문제
 SELECT customer_name
       ,PHONE_NUMBER
       ,substr(email,
       ,to_char(REG_DATE,'yyyy-mm-dd')
       ,to_char(birth,'yyyy-mm-dd') as birth
 FROM CUSTOMER
 where to_number(substr(birth,1,4)) >= 1996;
 
 
 
 
 
 