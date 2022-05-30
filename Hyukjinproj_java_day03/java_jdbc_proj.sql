CREATE TABLE MEMBERS(
    mem_id VARCHAR2(30)
   ,mem_pw VARCHAR2(30)
   ,mem_age number
   
);
commit;

SELECT *
FROM members;

CREATE TABLE accounts(
    mem_id VARCHAR2(30)
    ,ac_date VARCHAR2(30)
   ,ac_contents VARCHAR2(30)
   ,ac_price NUMBER(30)
);

SELECT to_char(ac_price,'L999,999,999,999,999')
FROM accounts;

SELECT *
fROm accounts;

commit;

drop TABLE accounts;

select 
     mem_age
    ,avg(accounts.ac_price)
    
from (select *
        from members
    ) a, accounts
where a.mem_id=accounts.mem_id
group by mem_age
;
select y * 10
     , avg(price_sum)
from(
        select  trunc(mem_age/10) as y
             ,  sum(b.ac_price) as price_sum
        from members a
           , accounts b
        where a.mem_id = b.mem_id(+)
        group by  trunc(mem_age/10)
    )
group by y * 10;



select *
from (
        select  a.mem_id
             ,  a.mem_age
             ,  trunc(a.mem_age/10) as age_y
             ,  sum(b.ac_price) as mem_sum
        from members a
           , accounts b
        where a.mem_id = b.mem_id(+)
        group by a.mem_id
              ,  a.mem_age
              ,  trunc(a.mem_age/10) 
      );


------------------------------------------------
select age_y * 10   as y
     , avg(mem_sum) as y_avg
from (
        select  a.mem_id
             ,  a.mem_age
             ,  trunc(a.mem_age/10) as age_y
             ,  sum(b.ac_price)     as mem_sum
        from members a
           , accounts b
        where a.mem_id = b.mem_id(+)
        group by a.mem_id
              ,  a.mem_age
              ,  trunc(a.mem_age/10) 
      )
group by age_y * 10;





select *
from accounts;

select trunc(mem_age/10)
from members;


select sum(price)
from members
group by trunc(mem_age/10);



SELECT trunc(mem_age/10) * 10 					
     , avg(sum(ac_price)) 		 			
FROM	(									
		select members.mem_id						
		 	,members.mem_age						
		 	,trunc(members.mem_age/10) 	
		 	,sum(accounts.ac_price) AS AC_PRICE 		
        From members  							
            ,accounts 								
        WHERE 1=1									
          AND members.mem_id = accounts.mem_id(+)				
          group by members.mem_id						
                 , members.mem_age						
                 , trunc(members.mem_age/10)			
        )  										
  group by trunc(mem_age/10) * 10;