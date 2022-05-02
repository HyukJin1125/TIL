/* 
   이름이 있는는 블록 
   이름 
   IS
    선언부 
   BEGIN
    실행부 
    EXCEPTION 
   END;
*/
-- 국가번호를 입력 받아 국가명을 반환하는 함수 
CREATE OR REPLACE FUNCTION fn_get_coutry(p_id NUMBER)
 RETURN VARCHAR2         -- 리턴타입 
IS
  vs_country_name countries.country_name%TYPE;
  vn_num number;
BEGIN
  SELECT COUNT(*)
    INTO vn_num
  FROM countries
  WHERE country_id = p_id;
-- 해당 데이터가 있는지 없는지 체크 
  IF vn_num > 0 THEN 
      -- 있을경우 조회 
      SELECT country_name
        INTO vs_country_name
      FROM countries
      WHERE country_id = p_id;
  -- 없을경우 '해당국가 없음' 할당 
  ELSE 
     vs_country_name := '해당국가 없음';
  END IF;
  RETURN vs_country_name; -- 리턴값
END;

CREATE OR REPLACE FUNCTION fn_year
 RETURN VARCHAR2
IS
BEGIN
 RETURN TO_CHAR(SYSDATE,'YYYY');
END;

SELECT fn_year(), fn_year
FROM DUAL;

/*학생 이름을 입력받아 수강학점의 총합을 리턴하는 함수를 작성하시오
  해당이름의 학생이 없으면 0 or '없음'
  입력값 이름 : varcahr2
  리턴값 학점 : varchar2
*/
CREATE OR REPLACE FUNCTION fn_get_score(p_name VARCHAR2)
 RETURN VARCHAR2
IS
 vn_score VARCHAR2(30);
 vn_cnt   NUMBER;
BEGIN 
 --(1)입력 받은 학생이 존재하는지 체크 
 SELECT COUNT(*)
  INTO vn_cnt
 FROM 학생 
 WHERE 이름 = p_name;
 --(2)학생이 있으면 수강학점합계 조회 ;
 IF vn_cnt > 0 THEN 
   SELECT NVL(SUM(과목.학점),0) 
    INTO vn_score
   FROM 학생, 수강내역, 과목
   WHERE 학생.이름 = p_name
   AND 학생.학번 = 수강내역.학번(+) 
   AND 수강내역.과목번호 = 과목.과목번호(+);
 ELSE
  vn_score := '없음'; 
 END IF;
 RETURN vn_score;
END;

SELECT 이름, FN_GET_SCORE(이름) as 수강학점합계
FROM 학생;


SELECT COUNT(*)
FROM 학생 
WHERE 이름 = '최숙경';


SELECT SUM(과목.학점) 
FROM 학생, 수강내역, 과목
WHERE 학생.이름 ='최숙경'
AND 학생.학번 = 수강내역.학번(+) 
AND 수강내역.과목번호 = 과목.과목번호(+);


SELECT fn_get_coutry(5277)
FROM dual;

DECLARE
  vs_country_name countries.country_name%TYPE;
  vn_num number;
BEGIN

  SELECT COUNT(*)
    INTO vn_num
  FROM countries
  WHERE country_id = 1234;
  
  IF vn_num > 0 THEN 
      SELECT country_name
        INTO vs_country_name
      FROM countries
      WHERE country_id = 1234;
  ELSE
     country_name := '데이터없음';
  END IF;

  DBMS_OUTPUT.PUT_LINE(vs_country_name);
END;


/*
   mem_id를 입력받아 등급을 리턴하는 함수를 만드시오 
   VIP : 마일리지 5000 이상 또는 구매 수량 100 이상 
   GOLD: 마일리지 5000 미만 3000 이상 또는 구매 수량 50 이상 
   SILVER : 나머지 
   (1) 필요한 SQL작성 (고객별 마일리지, 구매수량(qty))
   (2) (1)조회데이터로 조건문 작성 
     IF ~ VIP
     ELSIF GOLD
     ELSE SILVER
*/

CREATE OR REPLACE FUNCTION fn_get_mem_grade(p_id varchar2)
 RETURN VARCHAR2
IS 
  vn_qty     number;
  vn_mileage number;
  vs_grade   varchar2(30);
BEGIN
  
 SELECT nvl(sum(b.cart_qty),0), nvl(max(a.mem_mileage),0)
  INTO vn_qty, vn_mileage
 FROM member a
    , cart b
 WHERE a.mem_id = p_id
 AND a.mem_id = b.cart_member(+);
 
 IF vn_mileage >= 5000 or vn_qty >= 100 THEN 
   vs_grade := 'VIP';
 ELSIF vn_mileage < 5000 and vn_mileage >=3000 or vn_qty >= 50 THEN
   vs_grade := 'GOLD';
 ELSE
   vs_grade := 'SILVER';
 END IF;
 
 RETURN vs_grade;
END;

SELECT sum(b.cart_qty), max(a.mem_mileage)
FROM member a
   , cart b
WHERE a.mem_id = 'a001'
AND a.mem_id = b.cart_member(+);

select mem_id, mem_name, fn_get_mem_grade(mem_id) as grade
from member ;



/* YYYYMMDD(문자)형태의 날짜를 입력받아 
   dday를 계산하는 함수를 만드시오 (네이버 dday기준) 
   지났다면   : 기준일 부터 1722일째 되는 날 입니다.
   오늘이라면 : 오늘은 기준일 부터 1일째 되는 날 입니다.
   남았다면   : 오늘부터 기준일까지는 243일 남았습니다.
   (입력 :문자열, 리턴:문자열) 
*/
SELECT fn_dday('20170815')
      ,fn_dday('20220502')
      ,fn_dday('20221231')
FROM dual;


