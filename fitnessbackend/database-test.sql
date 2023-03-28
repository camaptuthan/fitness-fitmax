/*create database fitmax;*/
/*use fitmax;*/

/*select * from role;*/
insert into role(role_id,role_name,description) values ('ROLE01','Admin','');
insert into role(role_id,role_name,description) values ('ROLE02','Studio Manager','');
insert into role(role_id,role_name,description) values ('ROLE03','Assistant','');
insert into role(role_id,role_name,description) values ('ROLE04','Trainer','');
insert into role(role_id,role_name,description) values ('ROLE05','Trainee','');

/*select * from city;*/
insert into city(city_name) values ('Ha Noi');
insert into city(city_name) values ('Ho Chi Minh');
insert into city(city_name) values ('Da Nang');

/*select * from district;*/
insert into district(district_name,city_id) values ('Hai Ba Trung',1);
insert into district(district_name,city_id) values ('Dong Da',1);
insert into district(district_name,city_id) values ('Thanh Xuan',1);
insert into district(district_name,city_id) values ('Hoan Kiem',1);
insert into district(district_name,city_id) values ('Cau Giay',1);
insert into district(district_name,city_id) values ('Thu Duc',2);
insert into district(district_name,city_id) values ('Quan 4',2);
insert into district(district_name,city_id) values ('Quan 7',2);
insert into district(district_name,city_id) values ('Quan 2',2);
insert into district(district_name,city_id) values ('Tan Binh',2);
insert into district(district_name,city_id) values ('Thanh Khe',3);
insert into district(district_name,city_id) values ('Hai Chau',3);
insert into district(district_name,city_id) values ('Ngu Hanh Son',3);
insert into district(district_name,city_id) values ('Cam Le',3);
insert into district(district_name,city_id) values ('Son Tra',3);

/*select * from studio;*/
insert into studio(studio_id,district_id,contact,studio_name,road,status,created_date) values ('STU001',1,'','Gym Ha Noi A','458 Minh Khai',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,road,status,created_date) values ('STU002',2,'','Gym Ha Noi B','88 Lang Ha',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,road,status,created_date) values ('STU003',3,'','Gym Ha Noi C','72A Nguyen Trai',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,road,status,created_date) values ('STU004',4,'','Gym Ha Noi D','1 Hang Da',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,road,status,created_date) values ('STU005',5,'','Gym Ha Noi E','173 Xuan Thuy',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,road,status,created_date) values ('STU006',6,'','Gym HCM A','216 Vo Van Ngan',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,road,status,created_date) values ('STU007',7,'','Gym HCM B','346 Ben Van Don',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,road,status,created_date) values ('STU008',8,'','Gym HCM C','1058 Nguyen Van Linh',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,road,status,created_date) values ('STU009',9,'','Gym HCM D','12 Quoc Huong',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,road,status,created_date) values ('STU010',10,'','Gym HCM E','20 Cong Hoa',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,road,status,created_date) values ('STU011',11,'','Gym Da Nang A','271 Nguyen Van Linh',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,road,status,created_date) values ('STU012',12,'','Gym Da Nang B','2 Nguyen Tat Thanh',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,road,status,created_date) values ('STU013',13,'','Gym Da Nang C','18 Vo Nguyen Giap',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,road,status,created_date) values ('STU014',14,'','Gym Da Nang D','149 Truong Chinh',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,road,status,created_date) values ('STU015',15,'','Gym Da Nang E','45 Yet Kieu',1,CURDATE());

update fitmax.user set user.password ='$2a$10$YW.LA1YSfRuV82V8xxFGquSzrgzV0y.yTIYl.P65HJp0lheXdwAEi' where user.user_id between 0 and 100;
/*select * from user*/
insert into user(email,password,first_name,last_name,role_id,status,created_date) values ('fivemonkey.co@gmail.com','123456','Monkey','Five','ROLE01',1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('hungha19156@gmail.com','hungha1915','Ha','Pham','ROLE02',1,1,'STU001',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('tuanduong144@gmail.com','123456','Tuan','Duong','ROLE02',1,1,'STU004',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('huy191101@gmail.com','123456','Huy','Duong','ROLE02',1,1,'STU007',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('nguyenvanduc14012000@gmail.com','123456','Duc','Nguyen','ROLE02',1,1,'STU010',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('parkhunjk@gmail.com','123456','Viet Anh','Cao','ROLE02',1,1,'STU013',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('davidpham95aka201@gmail.com','123456','A','Nguyen','ROLE03',1,1,'STU001',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('assistant1.1@gmail.com','123456','A','Nguyen','ROLE03',1,1,'STU001',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('assistant1.2@gmail.com','123456','A','Nguyen','ROLE03',1,1,'STU001',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('davidpham95aka2011@gmail.com','123456','A','Nguyen','ROLE03',1,1,'STU002',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('davidpham95aka2012@gmail.com','123456','A','Nguyen','ROLE03',1,1,'STU003',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('davidpham95aka2013@gmail.com','123456','A','Nguyen','ROLE03',1,1,'STU004',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('davidpham95aka2014@gmail.com','123456','A','Nguyen','ROLE03',1,1,'STU005',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('ducnvhe141646@fpt.edu.vn','123456','Duc','Nguyen','ROLE04',1,1,'STU001',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer1.1@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU001',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer1.2@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU001',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer1.3@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU001',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer1.4@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU001',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer1.5@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU001',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer1.6@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU001',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer1.7@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU001',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer1.8@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU001',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('haphhe151269@fpt.edu.vn','123456','Ha','Pham','ROLE05',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity1.1@fpt.edu.vn','123456','','','ROLE05',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity1.2@fpt.edu.vn','123456','','','ROLE05',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity1.3@fpt.edu.vn','123456','','','ROLE05',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity1.4@fpt.edu.vn','123456','','','ROLE05',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity1.5@fpt.edu.vn','123456','','','ROLE05',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity1.6@fpt.edu.vn','123456','','','ROLE05',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('anhcvhe150742@fpt.edu.vn','123456','','','ROLE01',1,1,CURDATE());

insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('hungha191561@gmail.com','hungha1915','Ha','Pham','ROLE02',2,1,'STU002',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('tuanduong1441@gmail.com','123456','Tuan','Duong','ROLE02',2,1,'STU005',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('huy1911011@gmail.com','123456','Huy','Duong','ROLE02',2,1,'STU008',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('nguyenvanduc140120001@gmail.com','123456','Duc','Nguyen','ROLE02',2,1,'STU011',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('parkhunjk1@gmail.com','123456','Viet Anh','Cao','ROLE02',2,1,'STU014',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('davidpham95aka2015@gmail.com','123456','A','Nguyen','ROLE03',2,1,'STU006',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('assistant6.1@gmail.com','123456','A','Nguyen','ROLE03',1,1,'STU006',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('assistant6.2@gmail.com','123456','A','Nguyen','ROLE03',1,1,'STU006',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('davidpham95aka2016@gmail.com','123456','A','Nguyen','ROLE03',2,1,'STU007',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('davidpham95aka2017@gmail.com','123456','A','Nguyen','ROLE03',2,1,'STU008',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('davidpham95aka2018@gmail.com','123456','A','Nguyen','ROLE03',2,1,'STU009',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('davidpham95aka2019@gmail.com','123456','A','Nguyen','ROLE03',2,1,'STU010',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('ducnvhe1416461@fpt.edu.vn','123456','Duc','Nguyen','ROLE04',2,1,'STU006',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer6.1@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU006',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer6.2@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU006',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer6.3@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU006',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer6.4@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU006',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer6.5@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU006',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer6.6@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU006',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer6.7@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU006',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer6.8@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU006',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('haphhe1512691@fpt.edu.vn','123456','Ha','Pham','ROLE05',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity2.1@fpt.edu.vn','123456','','','ROLE05',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity2.2@fpt.edu.vn','123456','','','ROLE05',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity2.3@fpt.edu.vn','123456','','','ROLE05',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity2.4@fpt.edu.vn','123456','','','ROLE05',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity2.5@fpt.edu.vn','123456','','','ROLE05',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity2.6@fpt.edu.vn','123456','','','ROLE05',2,1,CURDATE());

insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('hungha191562@gmail.com','hungha1915','Ha','Pham','ROLE02',3,1,'STU003',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('tuanduong1442@gmail.com','123456','Tuan','Duong','ROLE02',3,1,'STU006',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('huy1911012@gmail.com','123456','Huy','Duong','ROLE02',3,1,'STU009',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('nguyenvanduc140120002@gmail.com','123456','Duc','Nguyen','ROLE02',3,1,'STU012',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('parkhunjk2@gmail.com','123456','Viet Anh','Cao','ROLE02',3,1,'STU015',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('davidpham95aka20110@gmail.com','123456','A','Nguyen','ROLE03',3,1,'STU011',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('assistant11.1@gmail.com','123456','A','Nguyen','ROLE03',1,1,'STU011',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('assistant11.2@gmail.com','123456','A','Nguyen','ROLE03',1,1,'STU011',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('davidpham95aka20111@gmail.com','123456','A','Nguyen','ROLE03',3,1,'STU012',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('davidpham95aka20112@gmail.com','123456','A','Nguyen','ROLE03',3,1,'STU013',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('davidpham95aka20113@gmail.com','123456','A','Nguyen','ROLE03',3,1,'STU014',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('davidpham95aka20114@gmail.com','123456','A','Nguyen','ROLE03',3,1,'STU015',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('ducnvhe1416462@fpt.edu.vn','123456','Duc','Nguyen','ROLE04',3,1,'STU011',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer11.1@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU011',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer11.2@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU011',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer11.3@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU011',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer11.4@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU011',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer11.5@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU011',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer11.6@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU011',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer11.7@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU011',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,studio_id,created_date) values ('trainer11.8@gmail.com','123456','Duc','Nguyen','ROLE04',1,1,'STU011',CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('haphhe1512692@fpt.edu.vn','123456','Ha','Pham','ROLE05',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity3.1@fpt.edu.vn','123456','','','ROLE05',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity3.2@fpt.edu.vn','123456','','','ROLE05',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity3.3@fpt.edu.vn','123456','','','ROLE05',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity3.4@fpt.edu.vn','123456','','','ROLE05',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity3.5@fpt.edu.vn','123456','','','ROLE05',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity3.6@fpt.edu.vn','123456','','','ROLE05',3,1,CURDATE());

/*select * from trainee;*/
insert into trainee(trainee_email) values ('haphhe151269@fpt.edu.vn');
insert into trainee(trainee_email) values ('haphhe1512691@fpt.edu.vn');
insert into trainee(trainee_email) values ('haphhe1512692@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity1.1@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity1.2@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity1.3@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity1.4@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity1.5@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity1.6@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity2.1@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity2.2@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity2.3@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity2.4@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity2.5@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity2.6@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity3.1@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity3.2@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity3.3@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity3.4@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity3.5@fpt.edu.vn');
insert into trainee(trainee_email) values ('traineecity3.6@fpt.edu.vn');

/*select * from trainer;*/
insert into trainer(trainer_email,status) values ('ducnvhe141646@fpt.edu.vn',1);
insert into trainer(trainer_email,status) values ('ducnvhe1416461@fpt.edu.vn',1);
insert into trainer(trainer_email,status) values ('ducnvhe1416462@fpt.edu.vn',1);
insert into trainer(trainer_email,status) values ('trainer1.1@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer1.2@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer1.3@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer1.4@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer1.5@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer1.6@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer1.7@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer1.8@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer6.1@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer6.2@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer6.3@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer6.4@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer6.5@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer6.6@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer6.7@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer6.8@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer11.1@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer11.2@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer11.3@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer11.4@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer11.5@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer11.6@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer11.7@gmail.com',1);
insert into trainer(trainer_email,status) values ('trainer11.8@gmail.com',1);

/*select * from category;*/
insert into category(description,category_name,type) values ('','Arm','service');
insert into category(description,category_name,type) values ('','Leg','service');
insert into category(description,category_name,type) values ('','Full Body','service');
insert into category(description,category_name,type) values ('','Physical','service');
insert into category(description,category_name,type) values ('','Advertisement','blog');
insert into category(description,category_name,type) values ('','Exercise','blog');
insert into category(description,category_name,type) values ('','Nutrition','blog');
insert into category(description,category_name,type) values ('','Abs','service');
insert into category(description,category_name,type) values ('','Back','service');
insert into category(description,category_name,type) values ('','Shoulder','service');


/*select * from blog;*/
insert into blog(title,writer_id,thumbnail,description,status,created_date,category_id) values ('Advertise 1',7,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_blog_thumbnail_1.jpg?alt=media&token=3973baad-c698-469c-95ce-f05d77028e07','',1,now(),5);
insert into blog(title,writer_id,thumbnail,description,status,created_date,category_id) values ('Advertise 2',7,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_blog_thumbnail_2.jpg?alt=media&token=d9930a69-ab8a-461c-b13a-2f18b3755660','',1,now(),5);
insert into blog(title,writer_id,thumbnail,description,status,created_date,category_id) values ('Advertise 3',7,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_blog_thumbnail_3.jpg?alt=media&token=5d0aa508-d507-44e9-8c8a-a64bc919fcc5','',1,now(),5);
insert into blog(title,writer_id,thumbnail,description,status,created_date,category_id) values ('Advertise 4',7,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_blog_thumbnail_4.jpg?alt=media&token=15505224-9b3d-4bf2-ba5d-52dcff4bfa3c','',1,now(),5);



/*select * from schedule;*/
insert into schedule(schedule_id,start_time,end_time) values ('SCHE01','05:00:00','07:00:00');
insert into schedule(schedule_id,start_time,end_time) values ('SCHE02','07:00:00','09:00:00');
insert into schedule(schedule_id,start_time,end_time) values ('SCHE03','09:00:00','11:00:00');
insert into schedule(schedule_id,start_time,end_time) values ('SCHE04','11:00:00','13:00:00');
insert into schedule(schedule_id,start_time,end_time) values ('SCHE05','13:00:00','15:00:00');
insert into schedule(schedule_id,start_time,end_time) values ('SCHE06','15:00:00','17:00:00');
insert into schedule(schedule_id,start_time,end_time) values ('SCHE07','17:00:00','19:00:00');
insert into schedule(schedule_id,start_time,end_time) values ('SCHE08','19:00:00','21:00:00');

/*select * from service_type*/
insert into service_type(image,description) values ('https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package.jpg?alt=media&token=74815fd1-3f23-43a0-b1af-99bb15c1a404','Packages');
insert into service_type(image,description) values ('https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/personal_training.jpg?alt=media&token=d43b4d45-061a-42f1-8b31-9ece0a972976','Personal Traning');
insert into service_type(image,description) values ('https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_class.jpg?alt=media&token=90d3c570-409e-41af-be27-39f2dc4d154f','Classes');

/*select s.service_name from service s where s.service_type_id = 1;*/

/*select * from service;*/
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230001','Basic Workout in 3 months in HN',3,150,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_1.jpg?alt=media&token=c9cf6140-edad-487a-8733-2e50a528705a',2,7,CURDATE(),1,1,3);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230002','Basic Workout in 6 months in HN',6,270,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_2.jpg?alt=media&token=8b053a63-3518-412c-9da1-4f21fc4dc97a',2,7,CURDATE(),1,1,4);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230003','Basic Workout in 9 months in HN',9,500,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_3.jpg?alt=media&token=2c5485cf-bb1a-448f-b02b-7768b53b5e4c',2,10,CURDATE(),1,1,3);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230004','Basic Workout in 12 months in HN',12,750,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_4.jpg?alt=media&token=5179633b-eabc-4b6b-b8ae-db12762175f8',2,10,CURDATE(),1,1,4);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230005','Basic Workout in 15 months in HN',15,870,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_5.jpg?alt=media&token=8adfc941-6825-4481-be9f-72f8dc83e567',2,11,CURDATE(),1,1,3);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230006','Basic Workout in 18 months in HN',18,1000,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_6.jpg?alt=media&token=00e97800-f264-484a-b093-66e0bba89e84',2,11,CURDATE(),1,1,4);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230007','Basic Workout in 21 months in HN',21,1100,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_7.jpg?alt=media&token=8343fa49-96e5-41e1-a964-cb44e861596a',2,12,CURDATE(),1,1,3);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230008','Basic Workout in 24 months in HN',24,1200,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_8.jpg?alt=media&token=66901113-ae27-481d-be94-1391851121c6',2,12,CURDATE(),1,1,4);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230009','Hanoi VIP Workout in 3 months',3,350,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_9.jpg?alt=media&token=4188e13a-86be-4473-8616-db91f6b68497',2,13,CURDATE(),1,'STU001',1,3);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230010','Hanoi VIP Workout in 6 months',6,680,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_10.jpg?alt=media&token=8ec9be91-c354-40a3-ab7e-86c313003ac3',2,13,CURDATE(),1,'STU001',1,4);

insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230011','Basic Workout in 3 months in HCM',3,170,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_11.jpg?alt=media&token=971ec138-6e5b-42dd-9375-d93f0c3fdf98',2,35,CURDATE(),1,2,3);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230012','Basic Workout in 6 months in HCM',6,290,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_12.jpg?alt=media&token=fa440521-ba32-40ce-93f8-b591568575c9',2,35,CURDATE(),1,2,4);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230013','Basic Workout in 9 months in HCM',9,520,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_13.jpg?alt=media&token=12af336f-994c-45b7-a248-9b82e3724a9d',2,38,CURDATE(),1,2,3);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230014','Basic Workout in 12 months in HCM',12,770,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_14.jpg?alt=media&token=87d9f7c4-f9f4-4fc5-b9b9-f1e67d9aeb87',2,38,CURDATE(),1,2,4);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230015','Basic Workout in 15 months in HCM',15,890,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_15.jpg?alt=media&token=668cf983-95a2-4438-b21c-8316fabb8556',2,39,CURDATE(),1,2,3);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230016','Basic Workout in 18 months in HCM',18,1020,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_16.jpg?alt=media&token=e580d8bf-10b7-4fc9-ac0e-3071a4aa8bb1',2,39,CURDATE(),1,2,4);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230017','Basic Workout in 21 months in HCM',21,1120,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_17.jpg?alt=media&token=f01f8f76-83eb-4655-b065-9ee7aaa4d336',2,40,CURDATE(),1,2,3);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230018','Basic Workout in 24 months in HCM',24,1220,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_18.jpg?alt=media&token=17b8fa52-758b-427f-b2ab-a11459d72084',2,40,CURDATE(),1,2,4);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230019','HCM VIP Workout in 3 months',3,400,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_19.jpg?alt=media&token=90b28312-a1fa-4c3e-b043-329701fdb2c1',2,41,CURDATE(),1,'STU006',2,3);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230020','HCM VIP Workout in 6 months',6,750,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_20.jpg?alt=media&token=d58e77a8-6f52-4317-be62-7b9e7d185a6f',2,41,CURDATE(),1,'STU006',2,4);

insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230021','Basic Workout in 3 months in DN',3,130,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_21.jpg?alt=media&token=68bfafb8-446f-44fa-ae09-1ef1c121f645',2,63,CURDATE(),1,3,3);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230022','Basic Workout in 6 months in DN',6,240,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_22.jpg?alt=media&token=c1fd16a1-7753-43f3-a960-2678b17687da',2,63,CURDATE(),1,3,4);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230023','Basic Workout in 9 months in DN',9,470,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_23.jpg?alt=media&token=9b0d3973-05c7-4430-84f0-d684a5c6f62e',2,66,CURDATE(),1,3,3);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230024','Basic Workout in 12 months in DN',12,720,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_24.jpg?alt=media&token=09bc8854-c7e1-4c47-a677-b53c5f21ed47',2,66,CURDATE(),1,3,4);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230025','Basic Workout in 15 months in DN',15,840,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_25.jpg?alt=media&token=076a1736-d1d7-4554-872b-b9018caea5a5',2,67,CURDATE(),1,3,3);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230026','Basic Workout in 18 months in DN',18,970,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_26.png?alt=media&token=50e96177-c23a-4456-875c-788786560e82',2,67,CURDATE(),1,3,4);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230027','Basic Workout in 21 months in DN',21,1070,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_27.jpg?alt=media&token=5c96b06d-d15a-4110-8010-3bdff783ecf8',2,68,CURDATE(),1,3,3);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,city_id,category_id) values ('SER20230028','Basic Workout in 24 months in DN',24,1170,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_28.jpg?alt=media&token=9f5d0625-2f79-4b5e-b3fe-9c0f8aa012be',2,68,CURDATE(),1,3,4);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230029','DN VIP Workout in 3 months',3,300,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_29.jfif?alt=media&token=a67d56d0-93e0-409d-a15a-fc62becfa53f',2,69,CURDATE(),1,'STU011',3,3);
insert into service(service_id,service_name,duration,price,image,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230030','DN VIP Workout in 6 months',6,580,'https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_30.jpg?alt=media&token=a03c72cc-96a7-44d7-95a1-683acf06dc21',2,69,CURDATE(),1,'STU011',3,4);


insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230031','Practice Yoga for 3 months',3,300,2,7,CURDATE(),3,'STU001',1,3);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230032','Practice KickBoxing for 3 months',3,350,2,7,CURDATE(),3,'STU001',1,4);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230033','Practice Yoga for 3 months',3,320,2,10,CURDATE(),3,'STU002',1,3);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230034','Practice KickBoxing for 3 months',3,380,2,10,CURDATE(),3,'STU002',1,4);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230035','Practice Yoga for 3 months',3,290,2,11,CURDATE(),3,'STU003',1,3);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230036','Practice KickBoxing for 3 months',3,390,2,11,CURDATE(),3,'STU003',1,4);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230037','Practice Yoga for 3 months',3,285,2,12,CURDATE(),3,'STU004',1,3);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230038','Practice KickBoxing for 3 months',3,400,2,12,CURDATE(),3,'STU004',1,4);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230039','Practice Yoga for 3 months',3,250,2,13,CURDATE(),3,'STU005',1,3);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230040','Practice KickBoxing for 3 months',3,405,2,13,CURDATE(),3,'STU005',1,4);

insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230041','Practice Yoga for 3 months',3,260,2,35,CURDATE(),3,'STU006',2,3);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230042','Practice KickBoxing for 3 months',3,400,2,35,CURDATE(),3,'STU006',2,4);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230043','Practice Yoga for 3 months',3,270,2,38,CURDATE(),3,'STU007',2,3);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230044','Practice KickBoxing for 3 months',3,390,2,38,CURDATE(),3,'STU007',2,4);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230045','Practice Yoga for 3 months',3,275,2,39,CURDATE(),3,'STU008',2,3);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230046','Practice KickBoxing for 3 months',3,380,2,39,CURDATE(),3,'STU008',2,4);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230047','Practice Yoga for 3 months',3,255,2,40,CURDATE(),3,'STU009',2,3);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230048','Practice KickBoxing for 3 months',3,350,2,40,CURDATE(),3,'STU009',2,4);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230049','Practice Yoga for 3 months',3,257,2,41,CURDATE(),3,'STU010',2,3);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230050','Practice KickBoxing for 3 months',3,355,2,41,CURDATE(),3,'STU010',2,4);

insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230051','Practice Yoga for 3 months',3,260,2,63,CURDATE(),3,'STU011',3,3);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230052','Practice KickBoxing for 3 months',3,360,2,63,CURDATE(),3,'STU011',3,4);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230053','Practice Yoga for 3 months',3,262,2,66,CURDATE(),3,'STU012',3,3);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230054','Practice KickBoxing for 3 months',3,370,2,66,CURDATE(),3,'STU012',3,4);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230055','Practice Yoga for 3 months',3,265,2,67,CURDATE(),3,'STU013',3,3);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230056','Practice KickBoxing for 3 months',2,3,375,67,CURDATE(),3,'STU013',3,4);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230057','Practice Yoga for 3 months',3,290,2,68,CURDATE(),3,'STU014',3,3);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230058','Practice KickBoxing for 3 months',3,388,2,68,CURDATE(),3,'STU014',3,4);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230059','Practice Yoga for 3 months',3,270,2,69,CURDATE(),3,'STU015',3,3);
insert into service(service_id,service_name,duration,price,status,created_by,created_date,service_type_id,studio_id,city_id,category_id) values ('SER20230060','Practice KickBoxing for 3 months',3,392,2,69,CURDATE(),3,'STU015',3,4);

/*select * from class*/
insert into class(service_id) values ('SER20230031');
insert into class(service_id) values ('SER20230032');
insert into class(service_id) values ('SER20230033');
insert into class(service_id) values ('SER20230034');
insert into class(service_id) values ('SER20230035');
insert into class(service_id) values ('SER20230036');
insert into class(service_id) values ('SER20230037');
insert into class(service_id) values ('SER20230038');
insert into class(service_id) values ('SER20230039');
insert into class(service_id) values ('SER20230040');
insert into class(service_id) values ('SER20230041');
insert into class(service_id) values ('SER20230042');
insert into class(service_id) values ('SER20230043');
insert into class(service_id) values ('SER20230044');
insert into class(service_id) values ('SER20230045');
insert into class(service_id) values ('SER20230046');
insert into class(service_id) values ('SER20230047');
insert into class(service_id) values ('SER20230048');
insert into class(service_id) values ('SER20230049');
insert into class(service_id) values ('SER20230050');
insert into class(service_id) values ('SER20230051');
insert into class(service_id) values ('SER20230052');
insert into class(service_id) values ('SER20230053');
insert into class(service_id) values ('SER20230054');
insert into class(service_id) values ('SER20230055');
insert into class(service_id) values ('SER20230056');
insert into class(service_id) values ('SER20230057');
insert into class(service_id) values ('SER20230058');
insert into class(service_id) values ('SER20230059');
insert into class(service_id) values ('SER20230060');

/*select * from session;*/
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230001','Gentle Yoga',CURDATE(),'2023-03-20',1,'SCHE01','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230002','Yoga Flow',CURDATE(),'2023-03-21',1,'SCHE01','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230003','Gentle Yoga',CURDATE(),'2023-03-22',1,'SCHE01','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230004','Hatha Yoga',CURDATE(),'2023-03-23',1,'SCHE01','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230005','Yoga Flow',CURDATE(),'2023-03-24',1,'SCHE01','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230006','Yoga Therapy',CURDATE(),'2023-03-25',1,'SCHE01','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230007','Yoga Core',CURDATE(),'2023-03-20',1,'SCHE02','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230008','Core Fit',CURDATE(),'2023-03-21',1,'SCHE02','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230009','Ashtanga Yoga',CURDATE(),'2023-03-22',1,'SCHE02','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230010','Ashtanga Yoga',CURDATE(),'2023-03-23',1,'SCHE02','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230011','Inversion Yoga',CURDATE(),'2023-03-24',1,'SCHE02','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230012','Breath & Asana',CURDATE(),'2023-03-20',1,'SCHE03','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230013','Back & Twist',CURDATE(),'2023-03-21',1,'SCHE03','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230014','Hip & Twist',CURDATE(),'2023-03-22',1,'SCHE03','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230015','Yoga Core',CURDATE(),'2023-03-20',1,'SCHE05','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230016','Hatha Flow',CURDATE(),'2023-03-22',1,'SCHE05','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230017','Solar Yoga',CURDATE(),'2023-03-24',1,'SCHE05','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230018','Vinyasa Yoga',CURDATE(),'2023-03-20',1,'SCHE06','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230019','Split Yoga',CURDATE(),'2023-03-21',1,'SCHE06','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230020','Core Fit',CURDATE(),'2023-03-22',1,'SCHE06','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230021','Hatha Yoga',CURDATE(),'2023-03-23',1,'SCHE06','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230022','Ashtanga Yoga',CURDATE(),'2023-03-24',1,'SCHE06','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230023','Hatha Yoga',CURDATE(),'2023-03-25',1,'SCHE06','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230024','Twisting Yoga',CURDATE(),'2023-03-20',1,'SCHE07','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230025','Hatha Balance',CURDATE(),'2023-03-21',1,'SCHE07','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230026','Hip Opening',CURDATE(),'2023-03-22',1,'SCHE07','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230027','Vinyasa Flow',CURDATE(),'2023-03-23',1,'SCHE07','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230028','Yoga Therapy',CURDATE(),'2023-03-24',1,'SCHE07','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230029','Yoga Core',CURDATE(),'2023-03-25',1,'SCHE07','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230030','Yoga Stretch',CURDATE(),'2023-03-20',1,'SCHE08','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230031','Hatha Flow',CURDATE(),'2023-03-21',1,'SCHE08','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230032','Yoga Basic',CURDATE(),'2023-03-22',1,'SCHE08','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230033','Power Yoga',CURDATE(),'2023-03-23',1,'SCHE08','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES20230034','Hip Opening',CURDATE(),'2023-03-24',1,'SCHE08','ducnvhe141646@fpt.edu.vn');

/*select * from status;*/
insert into status(type,type_id,status_name) values ('service',0,'Rejected');
insert into status(type,type_id,status_name) values ('service',1,'Waiting');
insert into status(type,type_id,status_name) values ('service',2,'In Progress');
insert into status(type,type_id,status_name) values ('service',3,'Expired');
insert into status(type,type_id,status_name) values ('blog',0,'Waiting');
insert into status(type,type_id,status_name) values ('blog',1,'Approved');
insert into status(type,type_id,status_name) values ('blog',2,'Expired');

INSERT INTO slider(description,image,title,user_id) VALUES('ELITE FITNESS X VPBANK | TẬP LUYỆN THẢ GA - CHẲNG LO VỀ GIÁ','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/slide-1.jpg?alt=media&token=0e0571e6-4c9a-4afd-a272-4ec4a8afc618','A New California',1);
INSERT INTO slider(description,image,title,user_id) VALUES('ELITE FITNESS X VPBANK | TẬP LUYỆN THẢ GA - CHẲNG LO VỀ GIÁ','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/slide-2.jpg?alt=media&token=48de613b-77df-4ca8-aa73-c0876c5b5aa0','A New California',1);
INSERT INTO slider(description,image,title,user_id) VALUES('ELITE FITNESS X VPBANK | TẬP LUYỆN THẢ GA - CHẲNG LO VỀ GIÁ','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/slide-1.jpg?alt=media&token=0e0571e6-4c9a-4afd-a272-4ec4a8afc618','A New California',1);


