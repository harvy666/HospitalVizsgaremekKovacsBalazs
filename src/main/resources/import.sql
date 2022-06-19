-- Doctor : id, name
-- Patient: id, age,name, doctor_id,receipt_id
-- Receipt: id, name, price, patient_id




insert into doctor (name) values ('Dr. House');
insert into doctor (name) values ('Dr. Green');

insert into patient (age,name,doctor_id) values (23,'Thomas Williams',1);
insert into patient (age,name,doctor_id) values (47,'Sarah Smith',1);
insert into patient (age,name,doctor_id) values (83,'John Sanders',2);

insert into receipt (name,price) values ('Insulin',870);
insert into receipt (name,price) values ('Tylenol',65);
insert into receipt (name,price) values ('Metformin',99);