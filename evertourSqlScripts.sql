use Evertour;

CREATE TABLE GUIDEREVIEW(
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  TEXTRATING VARCHAR (32) NOT NULL,
  RATINGSCORE INT NOT NULL,
  CLIENTID INT NOT NULL
  
);


CREATE table TOURCATEGORIES(
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(32) NOT NULL
);



Insert into GUIDEREVIEW (TEXTRATING, RATINGSCORE, CLIENTID) values ("good",5,1); 
select * from GUIDEREVIEW;


Insert into TOURCATEGORIES (NAME) values ("History"); 
Insert into TOURCATEGORIES (NAME) values ("Culinary");
Insert into TOURCATEGORIES (NAME) values ("NightLife");  
select * from TOURCATEGORIES;





#drop table TOURS;

CREATE TABLE TOURS(
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    TNAME VARCHAR(32),
    DESCRIPTION VARCHAR(32),
    TYPE_ID int,
    ADDRESS VARCHAR(32),
    LAT double ,
    LNG double,
    FOREIGN KEY (TYPE_ID) REFERENCES TOURCATEGORIES(ID)

);

use Evertour;
INSERT INTO TOURS (TNAME, DESCRIPTION,TYPE_ID,ADDRESS,LAT,LNG) values ("adf","this is a descript",1,"this is an address", "37.994539324697314","23.721502303378657");
INSERT INTO TOURS (TNAME, DESCRIPTION,TYPE_ID,ADDRESS,LAT,LNG) values ("tour tour ","this is a descript",2,"address2", "37.994539324697414","23.721503303378657");

INSERT INTO TOURS (TNAME, DESCRIPTION,TYPE_ID,ADDRESS,LAT,LNG) values ("tour tourq2 ","this is a descript",2,"address2", "37.878846","23.753825");
INSERT INTO TOURS (TNAME, DESCRIPTION,TYPE_ID,ADDRESS,LAT,LNG) values ("tour3 ","this is a descript",2,"address2", "37.878846","23.763830");
INSERT INTO TOURS (TNAME, DESCRIPTION,TYPE_ID,ADDRESS,LAT,LNG) values ("tour1 ","this is a descript",2,"address2", "37.978846","23.763825");

select * from TOURS;    
select * from TOURS where TYPE_ID = 1;    


# guides has a many to many relation with tours
# and a many to many relation with skills and languages spoken
#drop table GUIDES;
create table GUIDES(
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    GNAME VARCHAR(32),
    TYPE_ID tinyint, #boolean true licenced, false local
    ADDRESS VARCHAR(32),
    LAT double , # the following two denote the guides current address 
    LNG double ,
    PICTURE varchar(30)
);

insert into GUIDES (GNAME, TYPE_ID, ADDRESS, LAT,LNG,PICTURE) values ("Nikos",1, "kali-50", 0,0,'url');
insert into GUIDES (GNAME, TYPE_ID, ADDRESS, LAT,LNG,PICTURE) values ("Katerina",0, "kali-50", 0,0,'url');

#junction table for guides_tours
create table  GUIDES_TOURS(
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	TOUR_ID int,
    GUIDE_ID int,
    FOREIGN KEY (TOUR_ID) REFERENCES TOURS(ID),
    foreign key (GUIDE_ID) references GUIDES(ID)
);

insert into GUIDES_TOURS (TOUR_ID,GUIDE_ID) values (1,1);
insert into GUIDES_TOURS (TOUR_ID,GUIDE_ID) values (1,2);
insert into GUIDES_TOURS (TOUR_ID,GUIDE_ID) values (2,1);
insert into GUIDES_TOURS (TOUR_ID,GUIDE_ID) values (3,2);

# basically a view to get the join of tours with the guides that offer them
select * from Evertour.GUIDES_TOURS gt
join Evertour.TOURS t on gt.TOUR_ID = t.ID
join Evertour.GUIDES g on gt.GUIDE_ID = g.ID
order by gt.GUIDE_ID;

# select all the guides that offer a specific tour
select g.ID, g.GNAME, g.TYPE_ID, g.ADDRESS, g.LAT,g.LNG, g.PICTURE from Evertour.GUIDES_TOURS gt
join Evertour.TOURS t on gt.TOUR_ID = t.ID
join Evertour.GUIDES g on gt.GUIDE_ID = g.ID 
where t.ID=2;


alter table GUIDES add column USERNAME varchar(250);
alter table GUIDES add column PASS varchar(250);

drop table USERS;
create table USERS(
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    GNAME VARCHAR(32),
    ADDRESS VARCHAR(32),
    LAT double , # the following two denote the guides current address 
    LNG double,
    USERNAME varchar(250),
    PASS varchar(250)
);
select * from USERS;

