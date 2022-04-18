--  주석메모 할 때 : Ctrl+/

/*
     이공간은 주석 영역입니다.
     
     SQL(Structured Query Language) 구조화된 질의 언어
     종류 DDL, DML, DCL
     데이터 정의어 (DDl, Date Definition Language)
     테이블이나 관계의 구조를 생성하는데 사용
     CREATE, ALTER, DROP, TRUNCATE..
     
     데이터 조작어(DML, Date Manipulation Language)
     테이블의 데이터 검색, 삽입, 수정, 삭제하는데 사용
     SELECT, UPDATE, DELETE, INSERT..
     
     데이터 제어어(DCL, Dtat Control Language)
     데이터의 사용 권한을 관리하는데 사용
     GRANT, REVOKE  
*/
-- 테이블스페이스 생성 (물리적인 저장공간)
CREATE TABLESPACE myts
datafile '/u01/app/oracle/oradata/XE/myts.dbf'
size 100m autoextend on next 5m;

-- 계정생성(유저)
CREATE user java identified by oracle
default tablespace myts
temporary tablespace temp;

-- 권한부여
GRANT connect, resource to java;

-- 명령어 사이의 구분은 ; <- 세미클론으로 구분함
-- 명령어는 대소문자를 구별하지 않음 (데이터 자체는 구별함)

/* TABLE 테이블
1. 테이블 컬럼명은 최대 30byte 까지 올 수 있음
2. 테이블명 컬럼명으로 예약어는 사용할 수 없다.
3. 테이블명 컬러명으로 문자, 숫자, _, $, # 은 사용할 수 있지만, 첫 글자는 문자만 가능
4. 한 테이블에 컬럼은 최대 255개 까지
*/
-- 테이블 생성
CREATE TABLE ex1_1 (
    col1 CHAR(10)     -- 고정형
   ,col2 VARCHAR2(10) -- 가변형 (공간의 효율화를 위해 VARHCAR2 사용)
   );
-- 테이블 삭제
DROP TABLE ex1_1;

-- 데이터 삽입
INSERT INTO ex1_1 (col1, col2)
VALUES ('abc' , 'abc');
-- 데이터 조회
SELECT col1 , length(col1)
     , col2 , length(col2)
       from ex1_1;
       



