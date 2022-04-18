CREATE TABLE ORDERS(
    ORDER_ID NUMBER(12,0) primary key
   ,ORDER_DTE DATE
   ,ORDER_MODE VARCHAR2(8 BYTE)
   ,CUSTOMER_ID NUMBER(6,0)
   ,ORDER_STATUS NUMBER(2,0)
   ,ORDER_TOTAL NUMBER(8,2) default 0
   ,SALES_REP_ID NUMBER(6,0)
   ,PROMOTION_ID NUMBER(6,0)
   ,constraint ck_ORDER_MODE check(order_mode in('direct','online'))
   );
   
select * from ORDERS;



CREATE TABLE ORDER_ITEMS(
ORDER_ID NUMBER(12,0)
    ,LINE_ITEM_ID NUMBER(3,0)
    ,RODUCT_ID NUMBER(3,0)
    ,UNIT_PRICE NUMBER(8,2) default 0
    ,QUANTITY NUMBER(8,0) default 0
    ,CRATE_DT DATE default sysdate
    ,constraint PK_ORDER_ITEMS primary key (ORDER_ID, LINE_ITEM_ID)

);


