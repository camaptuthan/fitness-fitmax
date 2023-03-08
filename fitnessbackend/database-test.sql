/*create database fitmax;*/
/*use fitmax;*/

/*select * from role;*/
insert into role(role_id,role_name,description) values ('ROLE0001','Admin','');
insert into role(role_id,role_name,description) values ('ROLE0002','Manager','');
insert into role(role_id,role_name,description) values ('ROLE0003','Assistant','');
insert into role(role_id,role_name,description) values ('ROLE0004','Trainer','');
insert into role(role_id,role_name,description) values ('ROLE0005','Trainee','');

/*select * from city;*/
insert into city(city_name) values ('Ha Noi');
insert into city(city_name) values ('Ho Chi Minh');
insert into city(city_name) values ('Da Nang');

/*select * from district;*/
insert into district(district_name,road,city_id) values ('Hai Ba Trung','458 Minh Khai',1);
insert into district(district_name,road,city_id) values ('Dong Da','88 Lang Ha',1);
insert into district(district_name,road,city_id) values ('Thanh Xuan','72A Nguyen Trai',1);
insert into district(district_name,road,city_id) values ('Thanh Khe','271 Nguyen Van Linh',3);
insert into district(district_name,road,city_id) values ('Thu Duc','216 Vo Van Ngan',2);

/*select * from studio;*/
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0001',1,'','Gym A',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0002',2,'','Gym B',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0003',3,'','Gym C',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0004',4,'','Gym D',1,CURDATE());
insert into studio(studio_id,district_id,contact,studio_name,status,created_date) values ('STU0005',5,'','Gym E',1,CURDATE());

/*select * from user; */
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

/*select * from service_type*/
insert into service_type(image,description) values ('','Packages');
insert into service_type(image,description) values ('','Personal Traning');
insert into service_type(image,description) values ('','Classes');

/*select * from service;*/
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id) values ('SER0001','Full Body Workout 1',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),3);
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id) values ('SER0002','Full Body Workout 2',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),3);
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id) values ('SER0003','Full Body Workout 3',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),3);
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id) values ('SER0004','Full Body Workout 4',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),3);
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id) values ('SER0005','Full Body Workout 5',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),3);
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date) values ('SER0006','Physical Workout 1',1,'davidpham95aka201@gmail.com','STU0001',CURDATE());
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date) values ('SER0007','Physical Workout 2',1,'davidpham95aka201@gmail.com','STU0001',CURDATE());
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date) values ('SER0008','Physical Workout 3',1,'davidpham95aka201@gmail.com','STU0001',CURDATE());
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date) values ('SER0009','Physical Workout 4',1,'davidpham95aka201@gmail.com','STU0001',CURDATE());
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date) values ('SER0010','Physical Workout 5',1,'davidpham95aka201@gmail.com','STU0001',CURDATE());
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date) values ('SER0011','Hand Workout 1',1,'davidpham95aka201@gmail.com','STU0001',CURDATE());
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date) values ('SER0012','Hand Workout 2',1,'davidpham95aka201@gmail.com','STU0001',CURDATE());
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date) values ('SER0013','Hand Workout 3',1,'davidpham95aka201@gmail.com','STU0001',CURDATE());
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date) values ('SER0014','Hand Workout 4',1,'davidpham95aka201@gmail.com','STU0001',CURDATE());
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date) values ('SER0015','Hand Workout 5',1,'davidpham95aka201@gmail.com','STU0001',CURDATE());
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id) values ('SER0016','Leg Workout 1',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),3);
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id) values ('SER0017','Leg Workout 2',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),3);
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id) values ('SER0018','Leg Workout 3',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),3);
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id) values ('SER0019','Leg Workout 4',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),3);
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id) values ('SER0020','Leg Workout 5',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),3);
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id) values ('SER0021','Basic Workout 1',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),1);
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id) values ('SER0022','Basic Workout 2',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),1);
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id) values ('SER0023','Basic Workout 3',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),1);
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id) values ('SER0024','Basic Workout 4',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),1);
insert into service(service_id,service_name,status,assistant_email,studio_id,created_date,service_type_id) values ('SER0025','Basic Workout 5',1,'davidpham95aka201@gmail.com','STU0001',CURDATE(),1);

/*select * from category;*/
insert into category(category_id,description,category_name,type) values ('CATE0001','Hand','','service');
insert into category(category_id,description,category_name,type) values ('CATE0002','Leg','','service');
insert into category(category_id,description,category_name,type) values ('CATE0003','Full Body','','service');
insert into category(category_id,description,category_name,type) values ('CATE0004','Physical','','service');
insert into category(category_id,description,category_name,type) values ('CATE0005','Advertisement','','blog');
insert into category(category_id,description,category_name,type) values ('CATE0006','Exercise','','blog');
insert into category(category_id,description,category_name,type) values ('CATE0007','Nutrition','','blog');

/*select * from blog;*/
insert into blog(blog_id,title,writer_email,description,status,created_date,category_id) values ('BLO0001','Advertise 1','davidpham95aka201@gmail.com','Cras pulvinar mattis nunc sed blandit libero volutpat. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Amet consectetur adipiscing elit pellentesque. Ultricies tristique nulla aliquet enim tortor. Ultricies tristique nulla aliquet enim tortor. Arcu bibendum at varius vel pharetra vel turpis nunc eget. Et leo duis ut diam quam nulla. Cras pulvinar mattis nunc sed blandit libero volutpat. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Amet consectetur adipiscing elit pellentesque.',1,CURDATE(),'CATE0005');
insert into blog(blog_id,title,writer_email,description,status,created_date,category_id) values ('BLO0002','Advertise 2','davidpham95aka201@gmail.com','Cras pulvinar mattis nunc sed blandit libero volutpat. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Amet consectetur adipiscing elit pellentesque. Ultricies tristique nulla aliquet enim tortor. Ultricies tristique nulla aliquet enim tortor. Arcu bibendum at varius vel pharetra vel turpis nunc eget. Et leo duis ut diam quam nulla. Cras pulvinar mattis nunc sed blandit libero volutpat. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Amet consectetur adipiscing elit pellentesque.',1,CURDATE(),'CATE0005');
insert into blog(blog_id,title,writer_email,description,status,created_date,category_id) values ('BLO0003','Advertise 3','davidpham95aka201@gmail.com','Cras pulvinar mattis nunc sed blandit libero volutpat. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Amet consectetur adipiscing elit pellentesque. Ultricies tristique nulla aliquet enim tortor. Ultricies tristique nulla aliquet enim tortor. Arcu bibendum at varius vel pharetra vel turpis nunc eget. Et leo duis ut diam quam nulla. Cras pulvinar mattis nunc sed blandit libero volutpat. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Amet consectetur adipiscing elit pellentesque.',1,CURDATE(),'CATE0005');
insert into blog(blog_id,title,writer_email,description,status,created_date,category_id) values ('BLO0004','Advertise 4','davidpham95aka201@gmail.com','Cras pulvinar mattis nunc sed blandit libero volutpat. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Amet consectetur adipiscing elit pellentesque. Ultricies tristique nulla aliquet enim tortor. Ultricies tristique nulla aliquet enim tortor. Arcu bibendum at varius vel pharetra vel turpis nunc eget. Et leo duis ut diam quam nulla. Cras pulvinar mattis nunc sed blandit libero volutpat. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit. Amet consectetur adipiscing elit pellentesque.',1,CURDATE(),'CATE0005');

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
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0001','Practice Yoga for 6 months',6,'Yoga 1',500,1,'SER0001',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0002','Practice Yoga for 12 months',12,'Yoga 2',950,1,'SER0002',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0003','Practice KickBoxing for 3 months',3,'KickBoxing 1',350,1,'SER0016',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0004','Practice KickBoxing for 6 months',6,'KickBoxing 2',675,1,'SER0017',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0005','Practice Yoga for 3 months',3,'Yoga 3',300,1,'SER0003',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0006','Practice Yoga for 9 months',9,'Yoga 4',750,1,'SER0004',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0007','Practice Yoga for 18 months',18,'Yoga 5',1350,1,'SER0005',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0008','Practice KickBoxing for 9 months',9,'KickBoxing 3',975,1,'SER0018',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0009','Practice KickBoxing for 12 months',12,'KickBoxing 4',1250,1,'SER0019',CURDATE());
insert into class(class_id,description,duration,class_name,price,status,service_id,created_date) values ('CL0010','Practice KickBoxing for 18 months',18,'KickBoxing 5',1625,1,'SER0020',CURDATE());


/*select * from package;*/
insert into package(package_id,package_name,description,duration,price,status,service_id,created_date) values ('PKG0001','Basic Workout','Basic Workout in 3 months',3,150,1,'SER0021',CURDATE());
insert into package(package_id,package_name,description,duration,price,status,service_id,created_date) values ('PKG0002','Basic Workout','Basic Workout in 6 months',6,270,1,'SER0022',CURDATE());
insert into package(package_id,package_name,description,duration,price,status,service_id,created_date) values ('PKG0003','Basic Workout','Basic Workout in 12 months',12,500,1,'SER0023',CURDATE());
insert into package(package_id,package_name,description,duration,price,status,service_id,created_date) values ('PKG0004','Basic Workout','Basic Workout in 18 months',12,750,1,'SER0024',CURDATE());
insert into package(package_id,package_name,description,duration,price,status,service_id,created_date) values ('PKG0005','Basic Workout','Basic Workout in 24 months',12,900,1,'SER0025',CURDATE());

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







