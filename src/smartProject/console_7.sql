create table tbl_product_201909(
   p_code char(4) not null,
   p_name varchar(20),
   p_size varchar(40),
   p_type varchar(20),
   p_price int(7),
   primary key (p_code)
 );

create table tbl_worklist_201909(
    w_workno char(8) not null ,
    p_code char(4),
    w_quentity int(5),
    w_workdate char(4),
    primary key (w_workno), foreign key (p_code) REFERENCES tbl_product_201909 (p_code)
);

create table tbl_process_201909(
    w_workno char(8) not null ,
    p_p1 char(1),
    p_p2 char(1),
    p_p3 char(1),
    p_p4 char(1),
    p_p5 char(1),
    p_p6 char(1),
    w_lastdate char(8),
    w_lasttime char(4),
    primary key (w_workno)
);
