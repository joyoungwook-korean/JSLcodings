create table TBL_AREA_202005
(
    AREA_CODE CHAR(2)      not null
        constraint TBL_AREA_202005_PK
            primary key,
    AREA_NAME VARCHAR2(20) not null
);

create table TBL_CITY_202005(
    city_code char(2) not null primary key ,
    city_name varchar2(10) not null ,
    area_code char(2),
    city_tel1 char(3),
    city_tel2 char(4),
    city_tel3 char(4),
    city_admin char(12),
    city_level char(1),
    foreign key (area_code) REFERENCES TBL_AREA_202005(AREA_CODE)
);

create table TBL_TEST_202005(
    test_date char(8) not null ,
    test_ampm char(2),
    pollution char(2),
    city_code char(2),
    test_value number(5),
    foreign key (city_code) references TBL_CITY_202005(city_code)
);

select city_code,city_name, (RTRIM(city_tel1)||'-'||city_tel2||'-'||city_tel3) as tel,tc.area_code,AREA_NAME, city_admin, city_level
from TBL_CITY_202005 tc, TBL_AREA_202005 ta where tc.area_code=ta.AREA_CODE;

insert into TBL_TEST_202005 values (?,?,?,?,?,?);

select (SUBSTR(test_date,0,4)||'년'||SUBSTR(test_date,5,2)||'월'||SUBSTR(test_date,7,2)||'일') as date_a,
       test_ampm,pollution,tt.city_code,city_name,ta.AREA_NAME,test_value
from TBL_TEST_202005 tt , TBL_AREA_202005 ta, TBL_CITY_202005 tc where tt.city_code=tc.city_code and ta.AREA_CODE=tc.AREA_CODE
 order by test_ampm,tc.city_code;


select  (SUBSTR(test_date,0,4)||'년'||SUBSTR(test_date,5,2)||'월'||SUBSTR(test_date,7,2)||'일') as date_a,
        city_name, TRUNC(sum(test_value)/count(test_value),0) as avg,
       case when TRUNC(sum(test_value)/count(test_value),0) >150 then '매우나쁨'
when TRUNC(sum(test_value)/count(test_value),0) >80 then '나쁨'
when TRUNC(sum(test_value)/count(test_value),0) >30 then '보통'
else '좋음'
end as PL
from TBL_TEST_202005 tb , TBL_CITY_202005 tc where tb.city_code=tc.city_code group by city_name,test_date;

