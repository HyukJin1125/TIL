CREATE TABLESPACE TS_STUDY
datafile '/u01/app/oracle/oradata/XE/ts_study.dbf'
size 100m autoextend on next 5m;

CREATE user java2 identified by oracle
default tablespace TS_STUDY
temporary tablespace TEMP;

GRANT connect, resource to java2;

CREATE TABLE ex_MEM(
MEM_ID VARCHAR2(10)  not null
,MEM_NAME VARCHAR2(20) not null
,MEM_JOB VARCHAR2(30)
,MEM_MILEAGE NUMBER(8,2) default '0'
,MEM_REG_DATE DATE default sysdate
,constraint pk_ex_mem primary key(mem_id)
);

INSERT INTO ex_MEM (MEM_ID) VALUES('hong');
INSERT INTO ex_MEM (MEM_NAME) VALUES('홍길동');
INSERT INTO ex_MEM (MEM_JOB) VALUES('주부');
INSERT INTO ex_MEM (MEM_REG_DATE) VALUES(sysdate);

COMMENT ON TABLE ex_MEM IS '임시회원테이블';
COMMENT ON TABLE ex_MEM.MEM_ID IS '아이디';
COMMENT ON TABLE ex_MEM.mem_name IS '회원명';
COMMENT ON TABLE ex_mem.mem_job IS '직업';
COMMENT ON TABLE ex_mem.mem_mileage IS '마일리지';
COMMENT ON TABLE ex_mem.mem_reg_date IS '등록일';

ALTER TABLE ex_MEM MODIFY MEM_NAME VARCHAR2(50);

CREATE SEQUENCE my_seq
INCREMENT BY 1        
START WITH   1000        
MINVALUE     1000       
MAXVALUE     9999   
CYCLE;                

INSERT INTO ex_MEM(
MEM_ID
, MEM_NAME
, MEM_JOB
, MEM_MIleage
)
SELECT mem_id
,mem_name
,mem_job
,mem_mileage

FROM MEMBER
WHERE MEM_LIKE in('독서','등산','바둑');

DELETE FROM ex_MEM WHERE MEM_NAME LIKE '김%';

SELECT MEM_ID
, MEM_NAME
, MEM_JOB
, MEM_MILEAGE
FROM member
WHERE MEM_JOB = '주부'
AND MEM_MILEAGE  BETWEEN 1000 and 3000
ORDER BY MEM_MILEAGE desc;

SELECT prod_id
      ,prod_name
      ,prod_sale
FROM PROD
WHERE PROD_SALE = 23000
or PROD_SALE = 26000
or PROD_SALE = 33000;

SELECT *
FROM
(
SELECT MEM_JOB 
     , count(MEM_ID) as MEM_CNT 
     , max(mem_mileage) as MAX_MLG
     , to_char(AVG(MEM_MILEAGE),'999,999,999') as avg_MLG
FROM MEMBER
GROUP BY MEM_JOB
ORDER BY 2 DESC
) tb1
WHERE MEM_CNT >= 3;

SELECT MEM_ID
, MEM_NAME
, MEM_JOB
, CART_PROD
, CART_QTY
FROM MEMBER a
   , CART b
WHERE a.mem_id = b.cart_member;

SELECT MEM_ID
, MEM_NAME
, MEM_JOB
, CART_PROD
, CART_QTY
FROM CART
INNER join member mem
on (cart.cart_member = mem.mem_id);

SELECT mem_id
,mem_name
,mem_job
,mem_mileage
, rank() over(PARTITION BY mem_job 
        order by mem_mileage desc) as mem_rank
FROM member;
