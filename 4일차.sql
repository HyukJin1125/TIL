SELECT       MEM_NAME     /*고객명*/
            ,MEM_ADD1     /*고객주소*/  
            ,MEM_JOB      /*고객직업*/
            ,MEM_MAIL     /*고객 E-mail*/
FROM member
WHERE MEM_ADD1 like '%대전%'   
AND MEM_JOB like '회사원'; 


/* 함수 (function)
   오라클 데이터베이스에서 함수는 특정 연산처리 결과를
   '단일값'으로 반환하는 객체
   내장함수와 사용자 정의함수가 있음
*/
--  '숫자 함수'
-- ABS 매개변수로 숫자를 받아 절대값 반환
SELECT ABS(-10)
      ,ABS(-10.123)
      ,ABS(10)
FROM dual; -- dual <-- 임시테이블 개념(테스트용)

SELECT 10 * 2 * 45
FROM dual;


-- ROUND(n, i)
-- 매개변수 n을 소수점 (i + 1)번째에서 반올림한 결과를 반환
-- i 디폴트는 0
-- i 가 음수이면 소수점 왼쪽에서 반올림
SELECT ROUND(10.154)
     , ROUND(10.526, 1)
     , ROUND(16.123,-1)
FROM dual;

-- employees 직원의 일당을 계산하여 출력하시오 (한달 30일 기준)
--                                    소수점 2째자리 반올림   
SELECT emp_name
     , salary
     , ROUND(salary / 30, 2) as 일당
     , round(234 / 30,2)
FROM employees;

SELECT 'hi', emp_name
FROM employees;

-- mod(m, n) m을 n으로 나눈 나머지를 반환
SELECT MOD(4, 2)
     , mod(5, 2)
fROM dual;


-- INFO_NO 가 짝수면 짝수를
--           홀수면 홀수를 출력하시오

SELECT INFO_NO 
   ,CASE WHEN mod(INFO_NO,2) = 0 then '짝수' 
   ElSE '홀수' 
   END as 짝홀
   ,NM
fROM TB_INFO;


-- 문자 함수
-- 문자 함수는 연산 대상이 문자이며, 반환값은 함수에 따라  문자 또는 숫자를 반환함.

-- INITCAP: 첫글자 대문자, LOWER: 모두 소문자, UPPER: 대문자
SELECT INITCAP('pangsu')
    ,LOWER('PanGsu')
    ,UPPER('pangsu')
    FROM dual;
    
    SELECT LOWER(emp_name)
         , UPPER(emp_name)
         , emp_name
    FROM employees
    WHERE LOWER(emp_name) like LOWER('%DOnald%');
    
    -- SUBSTR(char, pos, len)
    --POS: 시작 값
    --LEN: 자를 값
    -- 문자열 char에서 pos번째 부터 len만큼 문자열을 자른뒤에 반환
    -- len을 쓰지 않으면 pos번째 부터 나머지 모든 문자 반환
                     
    SELECT substr('ABCD EFG',1,4)
        ,substr('ABCD EFG',2,4)
        ,substr('ABCD EFG',2)
        ,substr('ABCD EFG',-4,2) -- pos 마이너스 이면 뒤에서 
    FROM dual;
    
    SELECT mem_regno1
    ,mem_regno2
    ,mem_name
FROM member;
-- member 테이블의 고객 정보를 이름:김은대 주민번호:760115-1****** 형태로 출력하시오
    
  SELECT '이름:' || mem_name || ' ' || '주민번호:' || mem_regno1 || '-' || substr(mem_regno2,1,1) || '******'
 
 as 고객정보
   FROM member;
   
   -- LPAD, RPAD L:왼쪽 R:오른쪽에 지정한 문자로 채움
SELECT  LPAD(123, 5, '0')
       ,LPAD(1 , 5, '0')
       ,LPAD(11234, 5, '0')
       ,RPAD(123 , 5, '0')
       ,RPAD(1 , 5, '0')
       ,RPAD(112344 , 5, '0')
FROM dual;

SELECT LPAD(INFO_NO, 10, '0'), nm
FROM TB_INFO;

-- LTRIM, RTRIM, TRIM 공백제거
SELECT LTRIM(' 안녕하세요 ')
      ,RTRIM(' 안녕하세요 ')
       ,TRIM(' 안녕하세요 ')
FROM dual;

-- REPLACE(char, i, j)
-- 대상문자열 char에서 i를 찾아서 j로 치환

SELECT REPLACE('왜 사왔는데 먹지를 못하니','먹지','사왔')
      , TRANSLATE('먹지를 못하는데 왜 사왔니','사왔','먹지')
FROM dual;

--  LENGTH  -- 문자열길이
-- LENGTHB  -- 문자열byte수

SELECT LENGTH('오혁진')
      , LENGTHB('오혁진')
      ,LENGTH('abc')
      ,LENGTHB('이앞길 선생님')
FROM dual;


-- INSTR(char, check, pos, i)
-- char에서 pos 위치에서부터 i번째 위치하는 check 문자열의 인덱스값 반환
SELECT INSTR('abc abc abc ab', 'ab')         -- 디폴트 1, 1
        ,INSTR('abc abc abc ab', 'ab', 1)
        ,INSTR('abc abc abc ab', 'ab', 1, 2)
        ,INSTR('abc abc abc ab', 'ab', 4, 2)
FROM dual;


SELECT mem_name
      ,INSTR(mem_mail,'@') as 이메일
FROM member;

-- mem_mail @ 이의 위치를 출력하시오
-- 문제 : email 주소의 @앞 문자열을 id
--                   @뒤 문자열을 domain으로 출력하시오 
-- ex name  id      domain
--    김은대 pyiedab lycos.co.kr

SELECT mem_name
      , mem_mail 
      , INSTR(mem_mail,'@') as idx
      , substr(mem_mail,1, instr(mem_mail,'@')-1) as id
      , substr(mem_mail,instr(mem_mail,'@')+1) as domain
FROM MEMBER;


-- 날짜함수 **
SELECT SYSDATE      as 현재시간
     , SYSTIMESTAMP as 현재시간_밀리세컨드   
FROM dual;
-- ADD_MONTHS 월 추가
SELECT ADD_MONTHS (SYSDATE, 1)
     , ADD_MONTHS (SYSDATE, -1)
FROM dual;
-- LAST_DAY 마지막날 구하는 함수
-- NEXT_DAY
SELECT LAST_DAY(SYSDATE)
      ,NEXT_DAY(SYSDATE, '금요일') -- 다음 금요일
      ,NEXT_DAY(SYSDATE, '목요일') -- 다음 목요일 
FROM dual;

SELECT SYSDATE +1
      ,SYSDATE +100
      ,ROUND(sysdate, 'month')
      ,ROUND(sysdate, 'year')
      ,TRUNC(sysdate, 'month')
      ,TRUNC(sysdate, 'year')
FROM dual;


-- 오늘부터 이번달 마지막 날까지 남은 일자 D-day를 구하시오
-- LAST_DAY, ||, () <-- 문자열로 출력시 연산이 있으면 소괄호로 묶어줘야함
SELECT 
LAST_DAY(SYSDATE) || '까지는 ' || (LAST_DAY(SYSDATE)-sysdate) || '일 남았습니다.' as DDAY
FROM dual;

-- 변환함수 to 문자: TO_CHAR
--        to 숫자: TO_NUMBER
--        to 날짜: TO_DATE
SELECT TO_CHAR(SYSDATE, 'YYYY')
      ,TO_CHAR(SYSDATE, 'yyyy/mm/dd hh:mi:ss')
      ,TO_CHAR(SYSDATE, 'mm')
      ,TO_CHAR(SYSDATE, 'YYmmdd')
      ,TO_CHAR(SYSDATE, 'YYYY-mm-dd')
      ,TO_CHAR(SYSDATE, 'day')
      ,TO_CHAR(SYSDATE, 'd') -- 1 ~ 7 요일을 숫자로 반환
      ,TO_CHAR(1234569, '999,999,999')
      ,TO_CHAR(123, 'RN')
 FROM dual;
 
 SELECT TO_DATE('2002 02 14','yyyy mm dd')
       ,TO_DATE('2002_02_14','yyyy_mm_dd')
       ,TO_DATE('2002','yyyy')
       ,TO_DATE('200202','yyyymm')
       ,TO_DATE('20020214','yyyy.mm.dd')
 FROM dual;

SELECT (SYSDATE+1) - SYSDATE
,(TO_DATE('20220414')+1) - SYSDATE
FROM dual;


-- 현재일자를 기준으로 사원테이블(employees)의 입사일자를 참조해서
-- 근속년수가 23년 이상인 사원을 출력하시오

SELECT hire_date
,to_CHAR(SYSDATE,'yyyy') - TO_CHAR(hire_date,'yyyy') as 근속년수

FROM employees
where to_CHAR(SYSDATE,'yyyy') - TO_CHAR(hire_date,'yyyy') >= 23;
