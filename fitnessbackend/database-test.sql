/*create database fitmax;*/
/*use fitmax;*/

/*select * from role;*/
insert into role(role_id,role_name,description) values ('ROLE0001','Admin','');
insert into role(role_id,role_name,description) values ('ROLE0002','Manager','');
insert into role(role_id,role_name,description) values ('ROLE0003','Assistant','');
insert into role(role_id,role_name,description) values ('ROLE0004','Trainer','');
insert into role(role_id,role_name,description) values ('ROLE0005','Trainee','');

/*select * from studio;*/
insert into studio(studio_id,city,contact,district,studio_name,status,created_date) values ('STU0001','Ha Noi','','Ba Dinh','Gym A',1,CURDATE());
insert into studio(studio_id,city,contact,district,studio_name,status,created_date) values ('STU0002','HCM','','Thu Duc','Gym B',1,CURDATE());
insert into studio(studio_id,city,contact,district,studio_name,status,created_date) values ('STU0003','Da Nang','','Son Tra','Gym C',1,CURDATE());
insert into studio(studio_id,city,contact,district,studio_name,status,created_date) values ('STU0004','Ha Noi','','Hai Ba Trung','Gym D',1,CURDATE());
insert into studio(studio_id,city,contact,district,studio_name,status,created_date) values ('STU0005','Ha Noi','','Cau Giay','Gym E',1,CURDATE());

/*select * from user;*/
insert into user(email,password,first_name,last_name,role_id,status,created_date) values ('fivemonkeys.co@gmail.com','123456','Monkey','Five','ROLE0001',1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,studio_id,status,created_date) values ('hungha19156@gmail.com','hungha1915','Ha','Pham','ROLE0002','STU0001',1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,studio_id,status,created_date) values ('tuanduong144@gmail.com','123456','Tuan','Duong','ROLE0002','STU0002',1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,studio_id,status,created_date) values ('huy191101@gmail.com','123456','Huy','Duong','ROLE0002','STU0003',1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,studio_id,status,created_date) values ('nguyenvanduc14012000@gmail.com','123456','Duc','Nguyen','ROLE0002','STU0004',1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,studio_id,status,created_date) values ('parkhunjk@gmail.com','123456','Viet Anh','Cao','ROLE0002','STU0005',1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,studio_id,status,created_date) values ('davidpham95aka201@gmail.com','123456','A','Nguyen','ROLE0003','STU0001',1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,studio_id,status,created_date) values ('haphhe151269@fpt.edu.vn','123456','Ha','Pham','ROLE0005','STU0001',1,CURDATE());
insert into user(email,password,first_name,last_name,role_id,studio_id,status,created_date) values ('ducnvhe141646@fpt.edu.vn','123456','Duc','Nguyen','ROLE0004','STU0001',1,CURDATE());

/*select * from manager;*/
insert into manager(manager_email) values ('hungha19156@gmail.com');
insert into manager(manager_email) values ('tuanduong144@gmail.com');
insert into manager(manager_email) values ('huy191101@gmail.com');
insert into manager(manager_email) values ('nguyenvanduc14012000@gmail.com');
insert into manager(manager_email) values ('parkhunjk@gmail.com');

update studio set manager_email = 'hungha19156@gmail.com' where studio_id = 'STU0001';
update studio set manager_email = 'tuanduong144@gmail.com' where studio_id = 'STU0002';
update studio set manager_email = 'huy191101@gmail.com' where studio_id = 'STU0003';
update studio set manager_email = 'nguyenvanduc14012000@gmail.com' where studio_id = 'STU0004';
update studio set manager_email = 'parkhunjk@gmail.com' where studio_id = 'STU0005';

/*select * from assistant;*/
insert into assistant(assistant_email) values ('davidpham95aka201@gmail.com');

/*select * from service;*/
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date) values ('SER0001','Tap luyen toan than',1,'davidpham95aka201@gmail.com','STU0001',CURDATE());
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date) values ('SER0002','Tap luyen the luc',1,'davidpham95aka201@gmail.com','STU0001',CURDATE());
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date) values ('SER0003','Tap luyen tay',1,'davidpham95aka201@gmail.com','STU0001',CURDATE());
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date) values ('SER0004','Tap luyen chan',1,'davidpham95aka201@gmail.com','STU0001',CURDATE());

/*select * from category;*/
insert into category(category_id,description,category_name) values ('CATE0001','Tap tay','');
insert into category(category_id,description,category_name) values ('CATE0002','Tap chan','');
insert into category(category_id,description,category_name) values ('CATE0003','Tap toan than','');
insert into category(category_id,description,category_name) values ('CATE0004','Tap the luc','');
insert into category(category_id,description,category_name) values ('CATE0005','Quang cao','');
insert into category(category_id,description,category_name) values ('CATE0006','Tap luyen','');
insert into category(category_id,description,category_name) values ('CATE0007','An uong','');

/*select * from service_category;*/
insert into service_category(service_id,category_id) values ('SER0004','CATE0002');
insert into service_category(service_id,category_id) values ('SER0001','CATE0003');
insert into service_category(service_id,category_id) values ('SER0003','CATE0001');
insert into service_category(service_id,category_id) values ('SER0002','CATE0004');

/*select * from blog;*/
insert into blog(blog_id,title,writer_email,description,status,created_date) values ('BLO0001','Quang cao 1','davidpham95aka201@gmail.com','',1,CURDATE());
insert into blog(blog_id,title,writer_email,description,status,created_date) values ('BLO0002','Quang cao 2','davidpham95aka201@gmail.com','',1,CURDATE());
insert into blog(blog_id,title,writer_email,description,status,created_date) values ('BLO0003','Quang cao 3','davidpham95aka201@gmail.com','',1,CURDATE());
insert into blog(blog_id,title,writer_email,description,status,created_date) values ('BLO0004','Quang cao 4','davidpham95aka201@gmail.com','',1,CURDATE());

/*select * from blog_category;*/
insert into blog_category(blog_id,category_id) values ('BLO0001','CATE0005');
insert into blog_category(blog_id,category_id) values ('BLO0002','CATE0005');
insert into blog_category(blog_id,category_id) values ('BLO0003','CATE0005');
insert into blog_category(blog_id,category_id) values ('BLO0004','CATE0005');

/*select * from trainee;*/
insert into trainee(trainee_email) values ('haphhe151269@fpt.edu.vn');

/*select * from registration;*/
insert into registration(registration_id,user_email,service_id,status,registration_date) values ('REGIS0001','haphhe151269@fpt.edu.vn','SER0001',1,CURDATE());
insert into registration(registration_id,user_email,service_id,status,registration_date) values ('REGIS0002','haphhe151269@fpt.edu.vn','SER0002',1,CURDATE());
insert into registration(registration_id,user_email,service_id,status,registration_date) values ('REGIS0003','haphhe151269@fpt.edu.vn','SER0003',1,CURDATE());
insert into registration(registration_id,user_email,service_id,status,registration_date) values ('REGIS0004','haphhe151269@fpt.edu.vn','SER0004',1,CURDATE());

/*select * from trainer;*/
insert into trainer(trainer_email,status) values ('ducnvhe141646@fpt.edu.vn',1);

/*select * from class;*/
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0001','Tap Yoga trong vong 6 thang',6,'Tap Yoga',500,1,'SER0001',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0002','Tap Yoga trong vong 12 thang',12,'Tap Yoga',950,1,'SER0001',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0003','Tap KickBoxing trong vong 3 thang',3,'Tap KickBoxing',350,1,'SER0004',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0004','Tap KickBoxing trong vong 6 thang',6,'Tap KickBoxing',100,1,'SER0004',CURDATE());

/*select * from package;*/
insert into package(package_id,package_name,description,duration,price,status,service_id,created_date) values ('PKG0001','Tap tu do','Tap tu do trong vong 3 thang',3,150,1,'SER0001',CURDATE());
insert into package(package_id,package_name,description,duration,price,status,service_id,created_date) values ('PKG0002','Tap tu do','Tap tu do trong vong 6 thang',6,270,1,'SER0001',CURDATE());
insert into package(package_id,package_name,description,duration,price,status,service_id,created_date) values ('PKG0003','Tap tu do','Tap tu do trong vong 12 thang',12,500,1,'SER0001',CURDATE());

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






