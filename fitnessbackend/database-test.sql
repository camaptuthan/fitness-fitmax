/*create database fitmax;*/
/*use fitmax;*/

/*select * from role;*/
insert into role(role_id,role_name,description) values ('ROLE0001','Admin','');
insert into role(role_id,role_name,description) values ('ROLE0002','Studio Manager','');
insert into role(role_id,role_name,description) values ('ROLE0003','Assistant','');
insert into role(role_id,role_name,description) values ('ROLE0004','Trainer','');
insert into role(role_id,role_name,description) values ('ROLE0005','Trainee','');
insert into role(role_id,role_name,description) values ('ROLE0006','City Manager','');

/*select * from city;*/
insert into city(city_name) values ('Ha Noi');
insert into city(city_name) values ('Ho Chi Minh');
insert into city(city_name) values ('Da Nang');

/*select * from district;*/
insert into district(district_name,road,city_id) values ('Hai Ba Trung','458 Minh Khai',1);
insert into district(district_name,road,city_id) values ('Dong Da','88 Lang Ha',1);
insert into district(district_name,road,city_id) values ('Thanh Xuan','72A Nguyen Trai',1);
insert into district(district_name,road,city_id) values ('Hoan Kiem','1 Hang Da',1);
insert into district(district_name,road,city_id) values ('Cau Giay','173 Xuan Thuy',1);
insert into district(district_name,road,city_id) values ('Thu Duc','216 Vo Van Ngan',2);
insert into district(district_name,road,city_id) values ('Quan 4','346 Ben Van Don',2);
insert into district(district_name,road,city_id) values ('Quan 7','1058 Nguyen Van Linh',2);
insert into district(district_name,road,city_id) values ('Quan 2','12 Quoc Huong',2);
insert into district(district_name,road,city_id) values ('Tan Binh','20 Cong Hoa',2);
insert into district(district_name,road,city_id) values ('Thanh Khe','271 Nguyen Van Linh',3);
insert into district(district_name,road,city_id) values ('Hai Chau','2 Nguyen Tat Thanh',3);
insert into district(district_name,road,city_id) values ('Ngu Hanh Son','18 Vo Nguyen Giap',3);
insert into district(district_name,road,city_id) values ('Cam Le','149 Truong Chinh',3);
insert into district(district_name,road,city_id) values ('Son Tra','45 Yet Kieu',3);


/*select * from package join service on package.service_id = service.service_id join studio on service.studio_id = studio.studio_id; 
select * from package join service on package.service_id = service.service_id join studio on service.studio_id = studio.studio_id join studio_manager on studio.studio_manager_email = studio_manager.studio_manager_email;
*/

/*select * from user where role_id = 'ROLE0002'; */
insert into user(email,password,first_name,last_name,role_id,status,created_date) values ('fivemonkeys.co@gmail.com','123456','Monkey','Five','ROLE0001',1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('hungha19156@gmail.com','hungha1915','Ha','Pham','ROLE0002',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('tuanduong144@gmail.com','123456','Tuan','Duong','ROLE0002',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('huy191101@gmail.com','123456','Huy','Duong','ROLE0002',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('nguyenvanduc14012000@gmail.com','123456','Duc','Nguyen','ROLE0002',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('parkhunjk@gmail.com','123456','Viet Anh','Cao','ROLE0002',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('davidpham95aka201@gmail.com','123456','A','Nguyen','ROLE0003',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('davidpham95aka2011@gmail.com','123456','A','Nguyen','ROLE0003',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('davidpham95aka2012@gmail.com','123456','A','Nguyen','ROLE0003',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('davidpham95aka2013@gmail.com','123456','A','Nguyen','ROLE0003',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('davidpham95aka2014@gmail.com','123456','A','Nguyen','ROLE0003',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('haphhe151269@fpt.edu.vn','123456','Ha','Pham','ROLE0005',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('ducnvhe141646@fpt.edu.vn','123456','Duc','Nguyen','ROLE0004',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('admincity1@gmail.com','123456','','','ROLE0006',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity1.1@fpt.edu.vn','123456','','','ROLE0005',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity1.2@fpt.edu.vn','123456','','','ROLE0005',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity1.3@fpt.edu.vn','123456','','','ROLE0005',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity1.4@fpt.edu.vn','123456','','','ROLE0005',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity1.5@fpt.edu.vn','123456','','','ROLE0005',1,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity1.6@fpt.edu.vn','123456','','','ROLE0005',1,1,CURDATE());

insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('hungha191561@gmail.com','hungha1915','Ha','Pham','ROLE0002',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('tuanduong1441@gmail.com','123456','Tuan','Duong','ROLE0002',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('huy1911011@gmail.com','123456','Huy','Duong','ROLE0002',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('nguyenvanduc140120001@gmail.com','123456','Duc','Nguyen','ROLE0002',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('parkhunjk1@gmail.com','123456','Viet Anh','Cao','ROLE0002',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('davidpham95aka2015@gmail.com','123456','A','Nguyen','ROLE0003',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('davidpham95aka2016@gmail.com','123456','A','Nguyen','ROLE0003',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('davidpham95aka2017@gmail.com','123456','A','Nguyen','ROLE0003',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('davidpham95aka2018@gmail.com','123456','A','Nguyen','ROLE0003',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('davidpham95aka2019@gmail.com','123456','A','Nguyen','ROLE0003',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('haphhe1512691@fpt.edu.vn','123456','Ha','Pham','ROLE0005',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('ducnvhe1416461@fpt.edu.vn','123456','Duc','Nguyen','ROLE0004',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('admincity2@gmail.com','123456','','','ROLE0006',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity2.1@fpt.edu.vn','123456','','','ROLE0005',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity2.2@fpt.edu.vn','123456','','','ROLE0005',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity2.3@fpt.edu.vn','123456','','','ROLE0005',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity2.4@fpt.edu.vn','123456','','','ROLE0005',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity2.5@fpt.edu.vn','123456','','','ROLE0005',2,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity2.6@fpt.edu.vn','123456','','','ROLE0005',2,1,CURDATE());

insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('hungha191562@gmail.com','hungha1915','Ha','Pham','ROLE0002',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('tuanduong1442@gmail.com','123456','Tuan','Duong','ROLE0002',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('huy1911012@gmail.com','123456','Huy','Duong','ROLE0002',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('nguyenvanduc140120002@gmail.com','123456','Duc','Nguyen','ROLE0002',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('parkhunjk2@gmail.com','123456','Viet Anh','Cao','ROLE0002',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('davidpham95aka20110@gmail.com','123456','A','Nguyen','ROLE0003',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('davidpham95aka20111@gmail.com','123456','A','Nguyen','ROLE0003',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('davidpham95aka20112@gmail.com','123456','A','Nguyen','ROLE0003',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('davidpham95aka20113@gmail.com','123456','A','Nguyen','ROLE0003',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('davidpham95aka20114@gmail.com','123456','A','Nguyen','ROLE0003',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('haphhe1512692@fpt.edu.vn','123456','Ha','Pham','ROLE0005',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('ducnvhe1416462@fpt.edu.vn','123456','Duc','Nguyen','ROLE0004',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('admincity3@gmail.com','123456','','','ROLE0006',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity3.1@fpt.edu.vn','123456','','','ROLE0005',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity3.2@fpt.edu.vn','123456','','','ROLE0005',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity3.3@fpt.edu.vn','123456','','','ROLE0005',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity3.4@fpt.edu.vn','123456','','','ROLE0005',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity3.5@fpt.edu.vn','123456','','','ROLE0005',3,1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,city_id,status,created_date) values ('traineecity3.6@fpt.edu.vn','123456','','','ROLE0005',3,1,CURDATE());

/*select * from studio;*/
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0001',1,'','Gym Ha Noi A',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0002',2,'','Gym Ha Noi B',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0003',3,'','Gym Ha Noi C',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0004',4,'','Gym Ha Noi D',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0005',5,'','Gym Ha Noi E',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0006',6,'','Gym HCM A',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0007',7,'','Gym HCM B',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0008',8,'','Gym HCM C',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0009',9,'','Gym HCM D',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0010',10,'','Gym HCM E',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0011',11,'','Gym Da Nang A',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0012',12,'','Gym Da Nang B',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0013',13,'','Gym Da Nang C',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0014',14,'','Gym Da Nang D',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0015',15,'','Gym Da Nang E',1,CURDATE());


/*select * from studio_manager;*/
insert into studio_manager(studio_manager_email,studio_id) values ('hungha19156@gmail.com','STU0001');
insert into studio_manager(studio_manager_email,studio_id) values ('hungha191561@gmail.com','STU0002');
insert into studio_manager(studio_manager_email,studio_id) values ('hungha191562@gmail.com','STU0003');
insert into studio_manager(studio_manager_email,studio_id) values ('tuanduong144@gmail.com','STU0004');
insert into studio_manager(studio_manager_email,studio_id) values ('tuanduong1441@gmail.com','STU0005');
insert into studio_manager(studio_manager_email,studio_id) values ('tuanduong1442@gmail.com','STU0006');
insert into studio_manager(studio_manager_email,studio_id) values ('huy191101@gmail.com','STU0007');
insert into studio_manager(studio_manager_email,studio_id) values ('huy1911011@gmail.com','STU0008');
insert into studio_manager(studio_manager_email,studio_id) values ('huy1911012@gmail.com','STU0009');
insert into studio_manager(studio_manager_email,studio_id) values ('nguyenvanduc14012000@gmail.com','STU0010');
insert into studio_manager(studio_manager_email,studio_id) values ('nguyenvanduc140120001@gmail.com','STU0011');
insert into studio_manager(studio_manager_email,studio_id) values ('nguyenvanduc140120002@gmail.com','STU0012');
insert into studio_manager(studio_manager_email,studio_id) values ('parkhunjk@gmail.com','STU0013');
insert into studio_manager(studio_manager_email,studio_id) values ('parkhunjk1@gmail.com','STU0014');
insert into studio_manager(studio_manager_email,studio_id) values ('parkhunjk2@gmail.com','STU0015');

/*select * from user where role_id = 'ROLE0003';*/
/*select * from assistant;*/
insert into assistant(assistant_email,studio_id) values ('davidpham95aka201@gmail.com','STU0001');
insert into assistant(assistant_email,studio_id) values ('davidpham95aka2011@gmail.com','STU0002');
insert into assistant(assistant_email,studio_id) values ('davidpham95aka2012@gmail.com','STU0003');
insert into assistant(assistant_email,studio_id) values ('davidpham95aka2013@gmail.com','STU0004');
insert into assistant(assistant_email,studio_id) values ('davidpham95aka2014@gmail.com','STU0005');
insert into assistant(assistant_email,studio_id) values ('davidpham95aka2015@gmail.com','STU0006');
insert into assistant(assistant_email,studio_id) values ('davidpham95aka2016@gmail.com','STU0007');
insert into assistant(assistant_email,studio_id) values ('davidpham95aka2017@gmail.com','STU0008');
insert into assistant(assistant_email,studio_id) values ('davidpham95aka2018@gmail.com','STU0009');
insert into assistant(assistant_email,studio_id) values ('davidpham95aka2019@gmail.com','STU0010');
insert into assistant(assistant_email,studio_id) values ('davidpham95aka20110@gmail.com','STU0011');
insert into assistant(assistant_email,studio_id) values ('davidpham95aka20111@gmail.com','STU0012');
insert into assistant(assistant_email,studio_id) values ('davidpham95aka20112@gmail.com','STU0013');
insert into assistant(assistant_email,studio_id) values ('davidpham95aka20113@gmail.com','STU0014');
insert into assistant(assistant_email,studio_id) values ('davidpham95aka20114@gmail.com','STU0015');

/*select * from service_type*/
insert into service_type(image,description) values ('https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package.jpg?alt=media&token=74815fd1-3f23-43a0-b1af-99bb15c1a404','Packages');
insert into service_type(image,description) values ('https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/personal_training.jpg?alt=media&token=d43b4d45-061a-42f1-8b31-9ece0a972976','Personal Traning');
insert into service_type(image,description) values ('https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_class.jpg?alt=media&token=90d3c570-409e-41af-be27-39f2dc4d154f','Classes');

/*select * from category;*/
/*select p.package_id,p.package_name,p.description,p.duration,p.price,p.status,p.service_id,p.created_date,c.category_id 
from package p inner join service s on p.service_id = s.service_id inner join category c on s.category_id = c.category_id group by p.package_id;*/
insert into category(category_id,description,category_name,type) values ('CATE0001','','Arm','service');
insert into category(category_id,description,category_name,type) values ('CATE0002','','Leg','service');
insert into category(category_id,description,category_name,type) values ('CATE0003','','Full Body','service');
insert into category(category_id,description,category_name,type) values ('CATE0004','','Physical','service');
insert into category(category_id,description,category_name,type) values ('CATE0005','','Advertisement','blog');
insert into category(category_id,description,category_name,type) values ('CATE0006','','Exercise','blog');
insert into category(category_id,description,category_name,type) values ('CATE0007','','Nutrition','blog');
insert into category(category_id,description,category_name,type) values ('CATE0008','','Abs','service');
insert into category(category_id,description,category_name,type) values ('CATE0009','','Back','service');
insert into category(category_id,description,category_name,type) values ('CATE0010','','Shoulder','service');


/*select * from service;*/
/*select count(*) from service;*/
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0001','Basic Workout 1.1',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),1,1,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0002','Basic Workout 1.2',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),1,1,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0003','Basic Workout 2.1',1,'davidpham95aka2011@gmail.com','STU0002',CURDATE(),1,1,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0004','Basic Workout 2.2',1,'davidpham95aka2011@gmail.com','STU0002',CURDATE(),1,1,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0005','Basic Workout 3.1',1,'davidpham95aka2012@gmail.com','STU0003',CURDATE(),1,1,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0006','Basic Workout 3.2',1,'davidpham95aka2012@gmail.com','STU0003',CURDATE(),1,1,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0007','Basic Workout 4.1',1,'davidpham95aka2013@gmail.com','STU0004',CURDATE(),1,1,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0008','Basic Workout 4.2',1,'davidpham95aka2013@gmail.com','STU0004',CURDATE(),1,1,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0009','Basic Workout 5.1',1,'davidpham95aka2014@gmail.com','STU0005',CURDATE(),1,1,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0010','Basic Workout 5.2',1,'davidpham95aka2014@gmail.com','STU0005',CURDATE(),1,1,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0011','Basic Workout 6.1',1,'davidpham95aka2015@gmail.com','STU0006',CURDATE(),1,2,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0012','Basic Workout 6.2',1,'davidpham95aka2015@gmail.com','STU0006',CURDATE(),1,2,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0013','Basic Workout 7.1',1,'davidpham95aka2016@gmail.com','STU0007',CURDATE(),1,2,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0014','Basic Workout 7.2',1,'davidpham95aka2016@gmail.com','STU0007',CURDATE(),1,2,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0015','Basic Workout 8.1',1,'davidpham95aka2017@gmail.com','STU0008',CURDATE(),1,2,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0016','Basic Workout 8.2',1,'davidpham95aka2017@gmail.com','STU0008',CURDATE(),1,2,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0017','Basic Workout 9.1',1,'davidpham95aka2018@gmail.com','STU0009',CURDATE(),1,2,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0018','Basic Workout 9.2',1,'davidpham95aka2018@gmail.com','STU0009',CURDATE(),1,2,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0019','Basic Workout 10.1',1,'davidpham95aka2019@gmail.com','STU0010',CURDATE(),1,2,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0020','Basic Workout 10.2',1,'davidpham95aka2019@gmail.com','STU0010',CURDATE(),1,2,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0021','Basic Workout 11.1',1,'davidpham95aka20110@gmail.com','STU0011',CURDATE(),1,3,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0022','Basic Workout 11.2',1,'davidpham95aka20110@gmail.com','STU0011',CURDATE(),1,3,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0023','Basic Workout 12.1',1,'davidpham95aka20111@gmail.com','STU0012',CURDATE(),1,3,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0024','Basic Workout 12.2',1,'davidpham95aka20111@gmail.com','STU0012',CURDATE(),1,3,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0025','Basic Workout 13.1',1,'davidpham95aka20112@gmail.com','STU0013',CURDATE(),1,3,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0026','Basic Workout 13.2',1,'davidpham95aka20112@gmail.com','STU0013',CURDATE(),1,3,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0027','Basic Workout 14.1',1,'davidpham95aka20113@gmail.com','STU0014',CURDATE(),1,3,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0028','Basic Workout 14.2',1,'davidpham95aka20113@gmail.com','STU0014',CURDATE(),1,3,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0029','Basic Workout 15.1',1,'davidpham95aka20114@gmail.com','STU0015',CURDATE(),1,3,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0030','Basic Workout 15.2',1,'davidpham95aka20114@gmail.com','STU0015',CURDATE(),1,3,'CATE0004');



insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0031','Full Body Workout 1.1',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),3,1,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0032','Full Body Workout 1.2',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),3,1,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0033','Full Body Workout 2.1',1,'davidpham95aka2011@gmail.com','STU0002',CURDATE(),3,1,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0034','Full Body Workout 2.2',1,'davidpham95aka2011@gmail.com','STU0002',CURDATE(),3,1,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0035','Full Body Workout 3.1',1,'davidpham95aka2012@gmail.com','STU0003',CURDATE(),3,1,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0036','Full Body Workout 3.2',1,'davidpham95aka2012@gmail.com','STU0003',CURDATE(),3,1,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0037','Full Body Workout 4.1',1,'davidpham95aka2013@gmail.com','STU0004',CURDATE(),3,1,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0038','Full Body Workout 4.2',1,'davidpham95aka2013@gmail.com','STU0004',CURDATE(),3,1,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0039','Full Body Workout 5.1',1,'davidpham95aka2014@gmail.com','STU0005',CURDATE(),3,1,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0040','Full Body Workout 5.2',1,'davidpham95aka2014@gmail.com','STU0005',CURDATE(),3,1,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0041','Full Body Workout 6.1',1,'davidpham95aka2015@gmail.com','STU0006',CURDATE(),3,2,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0042','Full Body Workout 6.2',1,'davidpham95aka2015@gmail.com','STU0006',CURDATE(),3,2,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0043','Full Body Workout 7.1',1,'davidpham95aka2016@gmail.com','STU0007',CURDATE(),3,2,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0044','Full Body Workout 7.2',1,'davidpham95aka2016@gmail.com','STU0007',CURDATE(),3,2,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0045','Full Body Workout 8.1',1,'davidpham95aka2017@gmail.com','STU0008',CURDATE(),3,2,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0046','Full Body Workout 8.2',1,'davidpham95aka2017@gmail.com','STU0008',CURDATE(),3,2,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0047','Full Body Workout 9.1',1,'davidpham95aka2018@gmail.com','STU0009',CURDATE(),3,2,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0048','Full Body Workout 9.2',1,'davidpham95aka2018@gmail.com','STU0009',CURDATE(),3,2,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0049','Full Body Workout 10.1',1,'davidpham95aka2019@gmail.com','STU0010',CURDATE(),3,2,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0050','Full Body Workout 10.2',1,'davidpham95aka2019@gmail.com','STU0010',CURDATE(),3,2,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0051','Full Body Workout 11.1',1,'davidpham95aka20110@gmail.com','STU0011',CURDATE(),3,3,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0052','Full Body Workout 11.2',1,'davidpham95aka20110@gmail.com','STU0011',CURDATE(),3,3,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0053','Full Body Workout 12.1',1,'davidpham95aka20111@gmail.com','STU0012',CURDATE(),3,3,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0054','Full Body Workout 12.2',1,'davidpham95aka20111@gmail.com','STU0012',CURDATE(),3,3,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0055','Full Body Workout 13.1',1,'davidpham95aka20112@gmail.com','STU0013',CURDATE(),3,3,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0056','Full Body Workout 13.2',1,'davidpham95aka20112@gmail.com','STU0013',CURDATE(),3,3,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0057','Full Body Workout 14.1',1,'davidpham95aka20113@gmail.com','STU0014',CURDATE(),3,3,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0058','Full Body Workout 14.2',1,'davidpham95aka20113@gmail.com','STU0014',CURDATE(),3,3,'CATE0004');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0059','Full Body Workout 15.1',1,'davidpham95aka20114@gmail.com','STU0015',CURDATE(),3,3,'CATE0003');
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id,city_id,category_id) values ('SER0060','Full Body Workout 15.2',1,'davidpham95aka20114@gmail.com','STU0015',CURDATE(),3,3,'CATE0004');



/*select * from blog;*/
insert into blog(blog_id,title,writer_email,thumbnail,description,status,created_date,category_id) values ('BLO0001','Advertise 1','davidpham95aka201@gmail.com','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_blog_thumbnail_1.jpg?alt=media&token=3973baad-c698-469c-95ce-f05d77028e07','Cras pulvinar mattis nunc sed blandit libero volutpat. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Amet consectetur adipiscing elit pellentesque. Ultricies tristique nulla aliquet enim tortor. Ultricies tristique nulla aliquet enim tortor. Arcu bibendum at varius vel pharetra vel turpis nunc eget. Et leo duis ut diam quam nulla. Cras pulvinar mattis nunc sed blandit libero volutpat. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Amet consectetur adipiscing elit pellentesque.',1,CURDATE(),'CATE0005');
insert into blog(blog_id,title,writer_email,thumbnail,description,status,created_date,category_id) values ('BLO0002','Advertise 2','davidpham95aka201@gmail.com','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_blog_thumbnail_2.jpg?alt=media&token=d9930a69-ab8a-461c-b13a-2f18b3755660','Cras pulvinar mattis nunc sed blandit libero volutpat. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Amet consectetur adipiscing elit pellentesque. Ultricies tristique nulla aliquet enim tortor. Ultricies tristique nulla aliquet enim tortor. Arcu bibendum at varius vel pharetra vel turpis nunc eget. Et leo duis ut diam quam nulla. Cras pulvinar mattis nunc sed blandit libero volutpat. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Amet consectetur adipiscing elit pellentesque.',1,CURDATE(),'CATE0005');
insert into blog(blog_id,title,writer_email,thumbnail,description,status,created_date,category_id) values ('BLO0003','Advertise 3','davidpham95aka201@gmail.com','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_blog_thumbnail_3.jpg?alt=media&token=5d0aa508-d507-44e9-8c8a-a64bc919fcc5','Cras pulvinar mattis nunc sed blandit libero volutpat. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Amet consectetur adipiscing elit pellentesque. Ultricies tristique nulla aliquet enim tortor. Ultricies tristique nulla aliquet enim tortor. Arcu bibendum at varius vel pharetra vel turpis nunc eget. Et leo duis ut diam quam nulla. Cras pulvinar mattis nunc sed blandit libero volutpat. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Amet consectetur adipiscing elit pellentesque.',1,CURDATE(),'CATE0005');
insert into blog(blog_id,title,writer_email,thumbnail,description,status,created_date,category_id) values ('BLO0004','Advertise 4','davidpham95aka201@gmail.com','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_blog_thumbnail_4.jpg?alt=media&token=15505224-9b3d-4bf2-ba5d-52dcff4bfa3c','Cras pulvinar mattis nunc sed blandit libero volutpat. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Amet consectetur adipiscing elit pellentesque. Ultricies tristique nulla aliquet enim tortor. Ultricies tristique nulla aliquet enim tortor. Arcu bibendum at varius vel pharetra vel turpis nunc eget. Et leo duis ut diam quam nulla. Cras pulvinar mattis nunc sed blandit libero volutpat. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Amet consectetur adipiscing elit pellentesque.',1,CURDATE(),'CATE0005');

/*select * from trainee;*/
/*select * from user where role_id = 'ROLE0005';*/
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


/*select * from registration;*/
/*insert into registration(registration_id,user_email,service_id,status,registration_date) values ('REGIS0001','haphhe151269@fpt.edu.vn','SER0001',1,CURDATE());
insert into registration(registration_id,user_email,service_id,status,registration_date) values ('REGIS0002','haphhe151269@fpt.edu.vn','SER0002',1,CURDATE());
insert into registration(registration_id,user_email,service_id,status,registration_date) values ('REGIS0003','haphhe151269@fpt.edu.vn','SER0003',1,CURDATE());
insert into registration(registration_id,user_email,service_id,status,registration_date) values ('REGIS0004','haphhe151269@fpt.edu.vn','SER0004',1,CURDATE());
insert into registration(registration_id,user_email,service_id,status,registration_date) values ('REGIS0005','haphhe151269@fpt.edu.vn','SER0001',1,CURDATE());
insert into registration(registration_id,user_email,service_id,status,registration_date) values ('REGIS0006','haphhe151269@fpt.edu.vn','SER0001',1,CURDATE());*/

/*select * from trainer;*/
/*select * from user where role_id = 'ROLE0004'*/
insert into trainer(trainer_email,status) values ('ducnvhe141646@fpt.edu.vn',1);
insert into trainer(trainer_email,status) values ('ducnvhe1416461@fpt.edu.vn',1);
insert into trainer(trainer_email,status) values ('ducnvhe1416462@fpt.edu.vn',1);

/*select * from class;*/
/*select * from service where service_type_id = 3*/
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0001','Practice Yoga for 3 months',3,'Yoga 1',300,1,'SER0031',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0002','Practice KickBoxing for 3 months',3,'KickBoxing 1',350,1,'SER0032',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0003','Practice Yoga for 3 months',3,'Yoga 1',320,1,'SER0033',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0004','Practice KickBoxing for 3 months',3,'KickBoxing 1',380,1,'SER0034',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0005','Practice Yoga for 3 months',3,'Yoga 1',290,1,'SER0035',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0006','Practice KickBoxing for 3 months',3,'KickBoxing 1',390,1,'SER0036',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0007','Practice Yoga for 3 months',3,'Yoga 1',285,1,'SER0037',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0008','Practice KickBoxing for 3 months',3,'KickBoxing 1',400,1,'SER0038',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0009','Practice Yoga for 3 months',3,'Yoga 1',250,1,'SER0039',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0010','Practice KickBoxing for 3 months',3,'KickBoxing 1',405,1,'SER0040',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0011','Practice Yoga for 3 months',3,'Yoga 1',260,1,'SER0041',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0012','Practice KickBoxing for 3 months',3,'KickBoxing 1',400,1,'SER0042',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0013','Practice Yoga for 3 months',3,'Yoga 1',270,1,'SER0043',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0014','Practice KickBoxing for 3 months',3,'KickBoxing 1',390,1,'SER0044',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0015','Practice Yoga for 3 months',3,'Yoga 1',275,1,'SER0045',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0016','Practice KickBoxing for 3 months',3,'KickBoxing 1',380,1,'SER0046',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0017','Practice Yoga for 3 months',3,'Yoga 1',255,1,'SER0047',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0018','Practice KickBoxing for 3 months',3,'KickBoxing 1',350,1,'SER0048',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0019','Practice Yoga for 3 months',3,'Yoga 1',257,1,'SER0049',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0020','Practice KickBoxing for 3 months',3,'KickBoxing 1',355,1,'SER0050',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0021','Practice Yoga for 3 months',3,'Yoga 1',260,1,'SER0051',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0022','Practice KickBoxing for 3 months',3,'KickBoxing 1',360,1,'SER0052',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0023','Practice Yoga for 3 months',3,'Yoga 1',262,1,'SER0053',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0024','Practice KickBoxing for 3 months',3,'KickBoxing 1',370,1,'SER0054',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0025','Practice Yoga for 3 months',3,'Yoga 1',265,1,'SER0055',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0026','Practice KickBoxing for 3 months',3,'KickBoxing 1',375,1,'SER0056',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0027','Practice Yoga for 3 months',3,'Yoga 1',270,1,'SER0057',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0028','Practice KickBoxing for 3 months',3,'KickBoxing 1',388,1,'SER0058',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0029','Practice Yoga for 3 months',3,'Yoga 1',290,1,'SER0059',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0030','Practice KickBoxing for 3 months',3,'KickBoxing 1',392,1,'SER0060',CURDATE());

/*select * from package;*/
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0001','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_1.jpg?alt=media&token=c9cf6140-edad-487a-8733-2e50a528705a','Basic Workout','Basic Workout in 3 months in HN',3,150,1,'SER0001',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0002','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_2.jpg?alt=media&token=8b053a63-3518-412c-9da1-4f21fc4dc97a','Basic Workout','Basic Workout in 6 months in HN',6,270,1,'SER0002',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0003','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_3.jpg?alt=media&token=2c5485cf-bb1a-448f-b02b-7768b53b5e4c','Basic Workout','Basic Workout in 9 months in HN',9,500,1,'SER0003',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0004','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_4.jpg?alt=media&token=5179633b-eabc-4b6b-b8ae-db12762175f8','Basic Workout','Basic Workout in 12 months in HN',12,750,1,'SER0004',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0005','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_5.jpg?alt=media&token=8adfc941-6825-4481-be9f-72f8dc83e567','Basic Workout','Basic Workout in 15 months in HN',15,870,1,'SER0005',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0006','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_6.jpg?alt=media&token=00e97800-f264-484a-b093-66e0bba89e84','Basic Workout','Basic Workout in 18 months in HN',18,1000,1,'SER0006',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0007','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_7.jpg?alt=media&token=8343fa49-96e5-41e1-a964-cb44e861596a','Basic Workout','Basic Workout in 21 months in HN',21,1100,1,'SER0007',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0008','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_8.jpg?alt=media&token=66901113-ae27-481d-be94-1391851121c6','Basic Workout','Basic Workout in 24 months in HN',24,1200,1,'SER0008',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0009','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_9.jpg?alt=media&token=4188e13a-86be-4473-8616-db91f6b68497','Basic Workout','Basic Workout in 27 months in HN',27,1280,1,'SER0009',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0010','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_10.jpg?alt=media&token=8ec9be91-c354-40a3-ab7e-86c313003ac3','Basic Workout','Basic Workout in 30 months in HN',30,1350,1,'SER0010',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0011','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_11.jpg?alt=media&token=971ec138-6e5b-42dd-9375-d93f0c3fdf98','Basic Workout','Basic Workout in 3 months in HCM',3,130,1,'SER0011',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0012','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_12.jpg?alt=media&token=fa440521-ba32-40ce-93f8-b591568575c9','Basic Workout','Basic Workout in 6 months in HCM',6,240,1,'SER0012',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0013','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_13.jpg?alt=media&token=12af336f-994c-45b7-a248-9b82e3724a9d','Basic Workout','Basic Workout in 9 months in HCM',9,470,1,'SER0013',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0014','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_14.jpg?alt=media&token=87d9f7c4-f9f4-4fc5-b9b9-f1e67d9aeb87','Basic Workout','Basic Workout in 12 months in HCM',12,720,1,'SER0014',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0015','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_15.jpg?alt=media&token=668cf983-95a2-4438-b21c-8316fabb8556','Basic Workout','Basic Workout in 15 months in HCM',15,840,1,'SER0015',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0016','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_16.jpg?alt=media&token=e580d8bf-10b7-4fc9-ac0e-3071a4aa8bb1','Basic Workout','Basic Workout in 18 months in HCM',18,970,1,'SER0016',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0017','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_17.jpg?alt=media&token=f01f8f76-83eb-4655-b065-9ee7aaa4d336','Basic Workout','Basic Workout in 21 months in HCM',21,1070,1,'SER0017',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0018','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_18.jpg?alt=media&token=17b8fa52-758b-427f-b2ab-a11459d72084','Basic Workout','Basic Workout in 24 months in HCM',24,1170,1,'SER0018',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0019','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_19.jpg?alt=media&token=90b28312-a1fa-4c3e-b043-329701fdb2c1','Basic Workout','Basic Workout in 27 months in HCM',27,1250,1,'SER0019',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0020','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_20.jpg?alt=media&token=d58e77a8-6f52-4317-be62-7b9e7d185a6f','Basic Workout','Basic Workout in 30 months in HCM',30,1320,1,'SER0020',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0021','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_21.jpg?alt=media&token=68bfafb8-446f-44fa-ae09-1ef1c121f645','Basic Workout','Basic Workout in 3 months in DN',3,170,1,'SER0021',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0022','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_22.jpg?alt=media&token=c1fd16a1-7753-43f3-a960-2678b17687da','Basic Workout','Basic Workout in 6 months in DN',6,290,1,'SER0022',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0023','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_23.jpg?alt=media&token=9b0d3973-05c7-4430-84f0-d684a5c6f62e','Basic Workout','Basic Workout in 9 months in DN',9,520,1,'SER0023',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0024','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_24.jpg?alt=media&token=09bc8854-c7e1-4c47-a677-b53c5f21ed47','Basic Workout','Basic Workout in 12 months in DN',12,770,1,'SER0024',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0025','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_25.jpg?alt=media&token=076a1736-d1d7-4554-872b-b9018caea5a5','Basic Workout','Basic Workout in 15 months in DN',15,890,1,'SER0025',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0026','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_26.png?alt=media&token=50e96177-c23a-4456-875c-788786560e82','Basic Workout','Basic Workout in 18 months in DN',18,1020,1,'SER0026',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0027','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_27.jpg?alt=media&token=5c96b06d-d15a-4110-8010-3bdff783ecf8','Basic Workout','Basic Workout in 21 months in DN',21,1120,1,'SER0027',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0028','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_28.jpg?alt=media&token=9f5d0625-2f79-4b5e-b3fe-9c0f8aa012be','Basic Workout','Basic Workout in 24 months in DN',24,1220,1,'SER0028',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0029','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_29.jfif?alt=media&token=a67d56d0-93e0-409d-a15a-fc62becfa53f','Basic Workout','Basic Workout in 27 months in DN',27,1300,1,'SER0029',CURDATE());
insert into package(package_id,image,package_name,description,duration,price,status,service_id,created_date) values ('PKG0030','https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_30.jpg?alt=media&token=a03c72cc-96a7-44d7-95a1-683acf06dc21','Basic Workout','Basic Workout in 30 months in DN',30,1370,1,'SER0030',CURDATE());

/*select * from schedule;*/
insert into schedule(schedule_id,start_time,end_time) values ('SCHE0001','05:00:00','07:00:00');
insert into schedule(schedule_id,start_time,end_time) values ('SCHE0002','07:00:00','09:00:00');
insert into schedule(schedule_id,start_time,end_time) values ('SCHE0003','09:00:00','11:00:00');
insert into schedule(schedule_id,start_time,end_time) values ('SCHE0004','11:00:00','13:00:00');
insert into schedule(schedule_id,start_time,end_time) values ('SCHE0005','13:00:00','15:00:00');
insert into schedule(schedule_id,start_time,end_time) values ('SCHE0006','15:00:00','17:00:00');
insert into schedule(schedule_id,start_time,end_time) values ('SCHE0007','17:00:00','19:00:00');
insert into schedule(schedule_id,start_time,end_time) values ('SCHE0008','19:00:00','21:00:00');

/*select * from session;*/
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000001','Gentle Yoga',CURDATE(),'2023-02-27','CL0001','SCHE0001','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000002','Yoga Flow',CURDATE(),'2023-02-28','CL0001','SCHE0001','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000003','Gentle Yoga',CURDATE(),'2023-03-01','CL0001','SCHE0001','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000004','Hatha Yoga',CURDATE(),'2023-03-02','CL0001','SCHE0001','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000005','Yoga Flow',CURDATE(),'2023-03-03','CL0001','SCHE0001','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000006','Yoga Therapy',CURDATE(),'2023-03-04','CL0001','SCHE0001','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000007','Yoga Core',CURDATE(),'2023-02-27','CL0001','SCHE0002','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000008','Core Fit',CURDATE(),'2023-02-28','CL0001','SCHE0002','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000009','Ashtanga Yoga',CURDATE(),'2023-03-01','CL0001','SCHE0002','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000010','Ashtanga Yoga',CURDATE(),'2023-03-02','CL0001','SCHE0002','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000011','Inversion Yoga',CURDATE(),'2023-03-03','CL0001','SCHE0002','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000012','Breath & Asana',CURDATE(),'2023-02-27','CL0001','SCHE0003','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000013','Back & Twist',CURDATE(),'2023-02-28','CL0001','SCHE0003','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000014','Hip & Twist',CURDATE(),'2023-03-01','CL0001','SCHE0003','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000015','Yoga Core',CURDATE(),'2023-02-27','CL0001','SCHE0005','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000016','Hatha Flow',CURDATE(),'2023-03-01','CL0001','SCHE0005','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000017','Solar Yoga',CURDATE(),'2023-03-03','CL0001','SCHE0005','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000018','Vinyasa Yoga',CURDATE(),'2023-02-27','CL0001','SCHE0006','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000019','Split Yoga',CURDATE(),'2023-02-28','CL0001','SCHE0006','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000020','Core Fit',CURDATE(),'2023-03-01','CL0001','SCHE0006','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000021','Hatha Yoga',CURDATE(),'2023-03-02','CL0001','SCHE0006','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000022','Ashtanga Yoga',CURDATE(),'2023-03-03','CL0001','SCHE0006','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000023','Hatha Yoga',CURDATE(),'2023-03-04','CL0001','SCHE0006','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000024','Twisting Yoga',CURDATE(),'2023-02-27','CL0001','SCHE0007','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000025','Hatha Balance',CURDATE(),'2023-02-28','CL0001','SCHE0007','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000026','Hip Opening',CURDATE(),'2023-03-01','CL0001','SCHE0007','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000027','Vinyasa Flow',CURDATE(),'2023-03-02','CL0001','SCHE0007','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000028','Yoga Therapy',CURDATE(),'2023-03-03','CL0001','SCHE0007','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000029','Yoga Core',CURDATE(),'2023-03-04','CL0001','SCHE0007','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000030','Yoga Stretch',CURDATE(),'2023-02-27','CL0001','SCHE0008','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000031','Hatha Flow',CURDATE(),'2023-02-28','CL0001','SCHE0008','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000032','Yoga Basic',CURDATE(),'2023-03-01','CL0001','SCHE0008','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000033','Power Yoga',CURDATE(),'2023-03-02','CL0001','SCHE0008','ducnvhe141646@fpt.edu.vn');
insert into session(session_id,session_name,created_date,happened_date,class_id,schedule_id,trainer_email) values ('SES0000034','Hip Opening',CURDATE(),'2023-03-03','CL0001','SCHE0008','ducnvhe141646@fpt.edu.vn');

/*select p.package_id,p.created_date,p.description,p.duration from package p join service s on p.service_id = s.service_id join category c on s.category_id = c.category_id;*/





