create table tbl_student_201905(
    syear char(1) not null,
    sclass char(2) not null ,
    sno char(2) not null ,
    sname varchar(20) ,
    birth char(8),
    gender char(1),
    tel1 char(3),
    tel2 char(4),
    tel3 char(4),
    primary key (syear,sclass,sno)
);

create table tbl_dept_201905(
  syear char(1) not null ,
  sclass char(2) not null ,
  tname varchar(20),
  primary key (syear, sclass)
);

create table tel_score_201905(
    syear char(1) not null ,
    sclass char(2) not null ,
    sno char(2) not null ,
    kor int(3),
    eng int(3),
    mat int(3),
    foreign key (syear,sclass,sno) REFERENCES tbl_student_201905(syear,sclass,sno)
);

select syear,sclass,sno from tbl_student_201905;

select st.syear,st.sclass,st.sno,st.sname,kor,eng,mat
from tel_score_201905 sc, tbl_student_201905 st
where sc.syear=st.syear and sc.sno = st.sno and  sc.sclass = st.sclass;

delete from tel_score_201905 where syear=? and sclass=? and sno=?;

select st.syear, st.sno, st.sclass, sname, kor,eng,mat
from tel_score_201905 sc, tbl_student_201905 st
where sc.syear=st.syear and sc.sno = st.sno and  sc.sclass = st.sclass
group by  st.syear, st.sno, st.sclass;

select  st.sclass, tname, sum(kor) as kor_sum,sum(eng) as eng_sum,sum(mat) as mat_sum, count(st.sno) as count
from tel_score_201905 sc, tbl_student_201905 st, tbl_dept_201905 dp
where sc.syear=st.syear and sc.sno = st.sno and  sc.sclass = st.sclass and dp.sclass = st.sclass
group by  st.sclass;

INSERT INTO track2_4.tel_score_201905 (syear, sclass, sno, kor, eng, mat) VALUES ('1', '01', '01', 50, 50, 50);
INSERT INTO track2_4.tel_score_201905 (syear, sclass, sno, kor, eng, mat) VALUES ('1', '01', '02', 60, 40, 100);
INSERT INTO track2_4.tel_score_201905 (syear, sclass, sno, kor, eng, mat) VALUES ('1', '01', '03', 70, 70, 70);
INSERT INTO track2_4.tel_score_201905 (syear, sclass, sno, kor, eng, mat) VALUES ('1', '02', '01', 80, 80, 80);
INSERT INTO track2_4.tel_score_201905 (syear, sclass, sno, kor, eng, mat) VALUES ('1', '02', '02', 50, 50, 50);
INSERT INTO track2_4.tel_score_201905 (syear, sclass, sno, kor, eng, mat) VALUES ('1', '02', '03', 40, 90, 80);
INSERT INTO track2_4.tel_score_201905 (syear, sclass, sno, kor, eng, mat) VALUES ('1', '03', '01', 70, 70, 70);
INSERT INTO track2_4.tel_score_201905 (syear, sclass, sno, kor, eng, mat) VALUES ('1', '03', '02', 80, 60, 90);
INSERT INTO track2_4.tel_score_201905 (syear, sclass, sno, kor, eng, mat) VALUES ('1', '03', '03', 90, 80, 70);

INSERT INTO track2_4.tbl_student_201905 (syear, sclass, sno, sname, birth, gender, tel1, tel2, tel3) VALUES ('1', '01', '01', '김학생', '20020101', 'F', '010', '1234', '1001');
INSERT INTO track2_4.tbl_student_201905 (syear, sclass, sno, sname, birth, gender, tel1, tel2, tel3) VALUES ('1', '01', '02', '이학생', '20020201', 'M', '010', '1234', '1002');
INSERT INTO track2_4.tbl_student_201905 (syear, sclass, sno, sname, birth, gender, tel1, tel2, tel3) VALUES ('1', '01', '03', '박학생', '20020301', 'M', '010', '1234', '1003');
INSERT INTO track2_4.tbl_student_201905 (syear, sclass, sno, sname, birth, gender, tel1, tel2, tel3) VALUES ('1', '02', '01', '조학생', '20020401', 'M', '010', '1234', '1004');
INSERT INTO track2_4.tbl_student_201905 (syear, sclass, sno, sname, birth, gender, tel1, tel2, tel3) VALUES ('1', '02', '02', '유학생', '20020501', 'M', '010', '1234', '1005');
INSERT INTO track2_4.tbl_student_201905 (syear, sclass, sno, sname, birth, gender, tel1, tel2, tel3) VALUES ('1', '02', '03', '여학생', '20020601', 'M', '010', '1234', '1006');
INSERT INTO track2_4.tbl_student_201905 (syear, sclass, sno, sname, birth, gender, tel1, tel2, tel3) VALUES ('1', '03', '01', '남학생', '20020701', 'F', '010', '1234', '1007');
INSERT INTO track2_4.tbl_student_201905 (syear, sclass, sno, sname, birth, gender, tel1, tel2, tel3) VALUES ('1', '03', '02', '황학생', '20020801', 'F', '010', '1234', '1008');
INSERT INTO track2_4.tbl_student_201905 (syear, sclass, sno, sname, birth, gender, tel1, tel2, tel3) VALUES ('1', '03', '03', '전학생', '20020901', 'F', '010', '1234', '1009');

INSERT INTO track2_4.tbl_dept_201905 (syear, sclass, tname) VALUES ('1', '01', '김교사');
INSERT INTO track2_4.tbl_dept_201905 (syear, sclass, tname) VALUES ('1', '02', '이교사');
INSERT INTO track2_4.tbl_dept_201905 (syear, sclass, tname) VALUES ('1', '03', '박교사');