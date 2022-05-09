/* REGEXP_SUBSTR(대상문자, 패턴, 시작위치, 매칭순번)
*/
SELECT REGEXP_SUBSTR('c-01-02-03','[^-]+',1,1) as re1
     , REGEXP_SUBSTR('c-01-02-03','[^-]+',1,2) as re2
     , REGEXP_SUBSTR('c-01-02-03','[^-]+',1,3) as re3
     , REGEXP_SUBSTR('c-01-02-03','[^-]+',1,4) as re4
     , REGEXP_SUBSTR('c-01-02-03','[^-]+',1,5) as re5
FROM dual;


SELECT mem_mail
     , REGEXP_SUBSTR(mem_mail,'[^@]+',1,1) as ids 
     , REGEXP_SUBSTR(mem_mail,'[^@]+',1,2) as domain
FROM member;


SELECT REGEXP_REPLACE('Oracle is th     Information....','( ){2,}',' ')
     , REPLACE('Oracle is th  Information....','  ',' ')
fROM dual;

DECLARE
  -- 부서레코드 타입선언
   TYPE depart_rect IS RECORD (
         department_id     departments.department_id%TYPE,
         department_name  departments.department_name%TYPE, 
         parent_id          departments.parent_id%TYPE,
         manager_id        departments.manager_id%TYPE
   );
  -- 위에서 선언된 타입으로 레코드 변수 선언  
   vr_dep depart_rect;
  -- 두 번째 변수 선언 
   vr_dep2 depart_rect;
BEGIN
   vr_dep.department_id := 999;
   vr_dep.department_name := '테스트부서';
   vr_dep.parent_id := 100;
   vr_dep.manager_id := NULL;
   -- 두 번째 변수에 첫 번째 레코드변수 대입
   vr_dep2 := vr_dep;
   DBMS_OUTPUT.PUT_LINE( 'vr_dep2.department_id :' || vr_dep2.department_id);
   DBMS_OUTPUT.PUT_LINE( 'vr_dep2.department_name :' ||  vr_dep2.department_name);
   DBMS_OUTPUT.PUT_LINE( 'vr_dep2.parent_id :' ||  vr_dep2.parent_id);
   DBMS_OUTPUT.PUT_LINE( 'vr_dep2.manager_id :' ||  vr_dep2.manager_id);
END;

DECLARE
  -- 부서번호, 부서명을 필드로 가진 dep_rec 레코드 타입 선언 
  TYPE dep_rec IS RECORD (
        dep_id      departments.department_id%TYPE,
        dep_name departments.department_name%TYPE );
        
  --사번, 사원명 그리고 dep_rec(부서번호, 부서명) 타입의 레코드 선언 
  TYPE emp_rec IS RECORD (
        emp_id      employees.employee_id%TYPE,
        emp_name employees.emp_name%TYPE,
        dep          dep_rec                          );
        
   --  emp_rec 타입의 레코드 변수 선언 
   vr_emp_rec emp_rec;
BEGIN
   -- 100번 사원의 사번, 사원명, 부서번호, 부서명을 가져온다. 
   SELECT a.employee_id, a.emp_name, a.department_id, b.department_name
     INTO vr_emp_rec.emp_id, vr_emp_rec.emp_name, vr_emp_rec.dep.dep_id, vr_emp_rec.dep.dep_name
     FROM employees a, 
             departments b
    WHERE a.employee_id = 100
       AND a.department_id = b.department_id;
       
    -- 레코드 변수 값 출력    
    DBMS_OUTPUT.PUT_LINE('emp_id : ' ||  vr_emp_rec.emp_id);
    DBMS_OUTPUT.PUT_LINE('emp_name : ' ||  vr_emp_rec.emp_name);
    DBMS_OUTPUT.PUT_LINE('dep_id : ' ||  vr_emp_rec.dep.dep_id);
    DBMS_OUTPUT.PUT_LINE('dep_name : ' ||  vr_emp_rec.dep.dep_name);
END;

DECLARE 
  vn_department_id employees.department_id%TYPE := 80;
BEGIN
	-- 80번 부서의 사원이름을 자신의 이름으로 갱신
	 UPDATE employees
	     SET emp_name = emp_name
	   WHERE department_id = vn_department_id;	   
	   
	-- 몇 건의 데이터가 갱신됐는지 출력  없으면 0을 반환
	DBMS_OUTPUT.PUT_LINE('묵시적 커서 :'||SQL%ROWCOUNT); 
	COMMIT;
END;

DECLARE
   -- 사원명을 받아오기 위한 변수 선언
   vs_emp_name employees.emp_name%TYPE;

   --1.단계 커서 선언 : 명칭과 사용 쿼리 선언 매개변수로 부서코드를 받는다.
   -- CURSOR 커서명 [(매개변수1, 매개변수2, ..)]

   CURSOR cur_emp_dep ( cp_department_id employees.department_id%TYPE
                       , )

   IS

   SELECT emp_name,salary
     FROM employees
    WHERE department_id = cp_department_id;

BEGIN
	--2.단계 커서 오픈 (매개변수로 90번 부서를 전달)
	OPEN cur_emp_dep (90,'job_id');

	--3.단계 패치 단계에서 커서 사용
	LOOP
	
    	  -- 반복문을 통한 커서 패치작업
	  -- 커서 결과로 나온 로우를 패치함 (사원명을 변수에 할당)
	  FETCH cur_emp_dep INTO vs_emp_name, vs_salary;
	  -- 더 이상 패치된 참조로우가 없는 경우 LOOP 탈출
	  EXIT WHEN cur_emp_dep%NOTFOUND;
	  -- 사원명을 출력
	  DBMS_OUTPUT.PUT_LINE(vs_emp_name);

  END LOOP;
  --4.단계 커서 닫기(반드시 닫아야함)
  CLOSE cur_emp_dep;
END;

DECLARE
BEGIN
	-- FOR문을 통한 커서 패치작업 ( 커서 선언시 정의 부분을 FOR문에 직접 기술)
	FOR emp_rec IN ( SELECT emp_name
                         FROM employees
                         WHERE department_id = 90	
	               ) 
	LOOP
	  -- 사원명을 출력, 레코드 타입은 레코드명.컬럼명 형태로 사용
	  DBMS_OUTPUT.PUT_LINE(emp_rec.emp_name);
	END LOOP;
END;	

-- 위으 방법으로 모든 학생의
-- 학생.이름, 학생.전공, 학생.평점을 출력하시오

DECLARE
TYPE hak_type IS RECORD(
     이름 학생.이름%TYPE
    ,전공 학생.전공%TYPE
    ,평점 학생.평점%TYPE);
v_hak hak_type;
BEGIN
	-- FOR문을 통한 커서 패치작업 ( 커서 선언시 정의 부분을 FOR문에 직접 기술)
	FOR hak_rec IN ( SELECT 이름,
                            전공,
                            평점
                         FROM 학생
                        	
	               ) 
	LOOP
	  v_hak := hak_rec;
      -- 사원명을 출력, 레코드 타입은 레코드명.컬럼명 형태로 사용
	  DBMS_OUTPUT.PUT_LINE(hak_rec.이름|| ':'||hak_rec.전공||':'||hak_rec.평점);
	END LOOP;
END;

DECLARE
   -- 숫자-문자 쌍의 연관배열 선언
   TYPE av_type IS TABLE OF VARCHAR2(40) INDEX BY PLS_INTEGER;
   -- 연관배열 변수 선언
   vav_test av_type;
BEGIN
  -- 연관배열에 값 할당
  vav_test(10) := '10에 대한 값';
  vav_test(20) := '20에 대한 값';
  
  --연관배열 값 출력
  DBMS_OUTPUT.PUT_LINE(vav_test(10));
  DBMS_OUTPUT.PUT_LINE(vav_test(20));

END;

DECLARE
   -- 숫자-문자 쌍의 연관배열 선언
   TYPE av_type IS TABLE OF VARCHAR2(40) INDEX BY VARCHAR2(30);
        
   -- 연관배열 변수 선언
   vav_test av_type;
BEGIN
  -- 연관배열에 값 할당
  vav_test('A') := '10에 대한 값';
  vav_test('B') := '20에 대한 값';
  
  --연관배열 값 출력
  DBMS_OUTPUT.PUT_LINE(vav_test('A'));
  DBMS_OUTPUT.PUT_LINE(vav_test('B'));

END;

DECLARE
   -- 5개의 문자형 값으로 이루어진 VARRAY 선언
   TYPE va_type IS VARRAY(5) OF VARCHAR2(20);
   -- VARRY 변수 선언
   vva_test va_type;
   vn_cnt NUMBER := 0;
BEGIN
  -- 생성자를 사용해 값 할당 (총 5개지만 최초 3개만 값 할당)
  vva_test := va_type('FIRST', 'SECOND', 'THIRD', '', '');
  
  LOOP
     vn_cnt := vn_cnt + 1;     
     -- 크기가 5이므로 5회 루프를 돌면서 각 요소 값 출력 
     IF vn_cnt > 5 THEN 
        EXIT;
     END IF;
     -- VARRY 요소 값 출력 
     DBMS_OUTPUT.PUT_LINE(vva_test(vn_cnt));
  END LOOP;
  -- 값 변경
  vva_test(2) := 'TEST';
  vva_test(4) := 'FOURTH';
  -- 다시 루프를 돌려 값 출력
  vn_cnt := 0;
  LOOP
     vn_cnt := vn_cnt + 1;     
     -- 크기가 5이므로 5회 루프를 돌면서 각 요소 값 출력 
     IF vn_cnt > 5 THEN 
        EXIT;
     END IF;
     -- VARRY 요소 값 출력 
     DBMS_OUTPUT.PUT_LINE(vva_test(vn_cnt));
  END LOOP;
END;

DECLARE
  -- 중첩 테이블 선언
  TYPE nt_typ IS TABLE OF VARCHAR2(10);
  
  -- 변수 선언
  vnt_test nt_typ;
BEGIN
  -- 생성자를 사용해 값 할당
  vnt_test := nt_typ('FIRST', 'SECOND', 'THIRD');

  -- 맨 끝에 NULL 요소 추가한 뒤 값 할당 후 출력
  vnt_test.EXTEND;
  vnt_test(4) := 'fourth';
  DBMS_OUTPUT.PUT_LINE(vnt_test(4));
  
  -- 맨 끝에 첫 번째 요소를 2개 복사해 추가 후 출력
  vnt_test.EXTEND(2, 1);
  DBMS_OUTPUT.PUT_LINE('첫번째 : ' || vnt_test(1));
  -- 첫 번째 요소를 복사해 2개 추가했으므로 추가된 요소는 5, 6
  DBMS_OUTPUT.PUT_LINE('추가한 요소1 : ' || vnt_test(5));
  DBMS_OUTPUT.PUT_LINE('추가한 요소2 : ' || vnt_test(6));

END;

-- FIRST와 LAST 메소드 함수 타입에 : 컬렉션의 첫번째 인덱스 반환, 마지막인덱스 반환
DECLARE
  -- 중첩 테이블 선언
  TYPE nt_typ IS TABLE OF VARCHAR2(10);
  
  -- 변수 선언
  vnt_test nt_typ;
BEGIN
  -- 생성자를 사용해 값 할당
  vnt_test := nt_typ('FIRST', 'SECOND', 'THIRD', 'FOURTH', 'FIFTH');

  -- FIRST와 LAST 메소드를 FOR문에서 사용해 컬렉션 값을 출력
  FOR i IN vnt_test.FIRST..vnt_test.LAST
  LOOP
  
     DBMS_OUTPUT.PUT_LINE(i || '번째 요소 값: ' || vnt_test(i));
  END LOOP;

END;


