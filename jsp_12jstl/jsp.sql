
-- data_type이 NUMBER => 'int' 아니면 'String'
-- INITCAP함수 : 앞에것만 대문자로 바꿔준다. 단, 공백이 있거나 _(언더바)는 다른 문자라고 생각한다.
-- private String or int memId; << 이런식으로 나오게 해보세요

SELECT RPAD( 'private '
             || DECODE(a.data_type , 'NUMBER', 'int ', 'String ')
             || SUBSTR(LOWER(a.column_name),1,1) 
             || SUBSTR(REPLACE(INITCAP(a.column_name),'_',''),2)
               || ';'
              , 40)
       || NVL2(b.comments, '/* ' || b.comments || ' */', '')
  FROM user_tab_cols a, user_col_comments b
 WHERE a.table_name  = b.table_name
   AND a.column_name = b.column_name
   AND a.table_name = UPPER(:TB);

commit;
