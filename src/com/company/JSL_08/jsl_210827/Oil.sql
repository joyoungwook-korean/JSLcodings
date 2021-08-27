CREATE TABLE TBL_CUSTINFO_202010
(
    custno       CHAR(4)         NOT NULL,
    custname     VARCHAR2(20)    NULL,
    custjumin    CHAR(13)        NULL,
    custtel1     CHAR(3)         NULL,
    custtel2     CHAR(4)         NULL,
    custtel3     CHAR(4)         NULL,
    PRIMARY KEY (custno)
);

CREATE TABLE TBL_OILINFO_202010
(
    oiltype    CHAR(1)         NOT NULL,
    oilname    VARCHAR2(20)    NULL,
    PRIMARY KEY (oiltype)
);

CREATE TABLE TBL_SALEINFO_202010
(
    saleno        CHAR(4)      NOT NULL,
    oildate       CHAR(8)      NULL,
    oiltype       CHAR(1)      NULL,
    amount        NUMBER(4)    NULL,
    paytype       CHAR(1)      NULL,
    creditcard    CHAR(16)     NULL,
    oilcost       NUMBER(7)    NULL,
    custno        CHAR(4)      NULL,
    PRIMARY KEY (saleno)
);

ALTER TABLE TBL_SALEINFO_202010
    ADD CONSTRAINT FK_TBL_SALEINFO_202010_custno_ FOREIGN KEY (custno)
        REFERENCES TBL_CUSTINFO_202010 (custno);

ALTER TABLE TBL_SALEINFO_202010
    ADD CONSTRAINT FK_TBL_SALEINFO_202010_oiltype FOREIGN KEY (oiltype)
        REFERENCES TBL_OILINFO_202010 (oiltype);

INSERT INTO HR.TBL_OILINFO_202010 (OILTYPE, OILNAME) VALUES ('1', '휘발유');
INSERT INTO HR.TBL_OILINFO_202010 (OILTYPE, OILNAME) VALUES ('2', '고급휘발유');
INSERT INTO HR.TBL_OILINFO_202010 (OILTYPE, OILNAME) VALUES ('3', '경유');
INSERT INTO HR.TBL_OILINFO_202010 (OILTYPE, OILNAME) VALUES ('4', '등유');

INSERT INTO HR.TBL_SALEINFO_202010 (SALENO, OILDATE, OILTYPE, AMOUNT, PAYTYPE, CREDITCARD, OILCOST, CUSTNO) VALUES ('9001', '20211001', '1', 30, '2', '3001200130014001', 45000, '1001');

select saleno,oildate,oilname,amount,paytype,custname,si.custno,(custtel1||'-'||custtel2||'-'||custtel3) as custtel, creditcard, oilcost, sum(si.oilcost) over (  )as sumcost  from TBL_SALEINFO_202010 si, TBL_OILINFO_202010 oi, TBL_CUSTINFO_202010 ci
where si.oiltype=oi.oiltype and si.custno=ci.custno(+);

select OILDATE,OILNAME,COUNT(OILNAME)||'건' as gun ,sum(OILCOST) as OIL_SUM from TBL_SALEINFO_202010 si , TBL_OILINFO_202010 oi where si.OILTYPE=oi.OILTYPE  group by OILDATE,OILNAME order by OILDATE, OILNAME;
