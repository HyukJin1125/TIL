    /*  WITH 절 별칭으로 사용한 SELECT문을
        다른 SELECT문에서 참조가능함. (반복되는 쿼리가 있다면 WITH절로 사용하면
                                    변수처럼 사용가능)
        통계쿼리나 튜닝할 때 많이 사용
        tmep라는 임시 테이블을 사용하여 장시간 걸리는 쿼리 결과를
        임시로 저장하여 사용함.
        oralce 9이상에서 지원함.
        가독성이 좋음
    */
    -- WITH절을 활용하여 수강건수 출력
    WITH T1 AS(
    SELECT 학생.이름
    ,학생.학번
    ,학생.평점
    ,학생,전공
    ,수강내역.수강내역번호
    ,수강내역.과목번호과목번호
    FROM 학생, 수강내역
    WHERE 학생.학번 = 수강내역.학번(+)
    ), t2 as ( 
   SELECT 학번, 이름, count(수강내역번호) as cnt
    FROM T1;
    SELECT
    FROM T2;
    GROUP BY 학번, 이름
    ) SELECT *
        FROM 과목, T1
        WHERE 과목.과목번호 = T1.과목번호
        ;
        
/* 문제 (일반 쿼리로 작성하세요)
    kor_loan_status 테이블에서 '연도별' '최종월(마지막월)'
    기준으로 가장 대출이 많은 도시와 잔액을 구하시오.
    1. 연도별 최종월 (2011년은 12월 이지만 2013은 11월임)
      - 연도별 가장 큰 월을 구한다.  
    2. 연도별 최종월을 기준으로 대출잔액이 가장 큰 금액을 추출
    3. 월별 지역별 대출잔액과 2의 결과를 비교하여 금액이 같은건 추출
*/
 -- 년월별 지역별 합계
    SELECT b2.*
    FROM ( SELECT period, region, sum(loan_jan_amt) jan_amt
             FROM kor_loan_status
             GROUP BY period, region
          ) b2,
          ( SELECT b.period,  MAX(b.jan_amt) max_jan_amt
             FROM ( SELECT period, region, sum(loan_jan_amt) jan_amt
                      FROM kor_loan_status
                     GROUP BY period, region
                  ) b,
                  ( SELECT MAX(PERIOD) max_month
                      FROM kor_loan_status
                     GROUP BY SUBSTR(PERIOD, 1, 4)
                  ) a
             WHERE b.period = a.max_month
             GROUP BY b.period
          ) c
     WHERE b2.period = c.period
       AND b2.jan_amt = c.max_jan_amt
     ORDER BY 1;


