
-- 랭크함수
SELECT mem_id                     -- 시험 2장
    , mem_name                       
    , mem_job
    , mem_mileage
    , rank() over(PARTITION BY mem_job 
       order by mem_mileage desc) as mem_rank
FROM member;

-- 안시조인
SELECT MEMD                            -- 시험 2장
, MEM_NAME
, MEM_JOB
, CART_PROD
, CART_QTY
FROM CART
INNER join member mem
on (cart.cart_member = mem.mem_id);

-- 동등조인
SELECT MEM_ID
, MEM_NAME
, MEM_JOB
, CART_PROD
, CART_QTY
FROM MEMBER a
   , CART b
WHERE a.mem_id = b.cart_member;

-- 인서트
INSERT INTO ex_MEM (MEM_ID) VALUES('hong');

-- UPDATE
UPDATE member
SET mem_job = '회사원'
  , mem_mileage = 1200
WHERE mem_id = 'hong';

-- 조회
select * 
FROM EX_MEM
WHERE MEM_NAME LIKE '김%';


/*
데이터베이스 객체          
                 
프로시저(PROCEDURE) : 업무적으로 복잡한 구문을 별도의 구문으로 작성하여,
                    DB에 저장하고 실행가능한 고유한 기능을 수행하는 객체
                    함수와 유사하지만 서버에서 실행되며 리턴값을 0 ~ n 개로 설정가능
                    DML문에서는 사용하지 못하며, PL/SQL 문에서 사용가능

트랜잭션(Transaction) : '거래'라는 뜻으로 은행에서는 입금과
                       출금을 하는 거래를 뜻하며 사용자, 오라클서버,  
                       개발자, DBA 등에게 데이터 일치성과
                       동시발생을 보장하기 위해 트랜잭션 처리를 한다.
                       업무의 가장 작은 단위로 구분하여 해당 업무가 성공하면
                       COMMIT; 하나라도 실패하면 ROLLBACK을 통해 작업이력을 제거한다.                 
*/   

