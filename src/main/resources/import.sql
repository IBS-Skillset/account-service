
create table account (
                         id bigint auto_increment,
                         email varchar(255),
                         firstName varchar(255),
                         lastName varchar(255),
                         password varchar(255),
                         phoneNumber varchar(20),
                         primary key (id)
);


INSERT INTO account(email,firstName,lastName,password,phoneNumber) VALUES ('test1@gmail.com','tees','alex','T@#%WE','9123456545');
INSERT INTO account(email,firstName,lastName,password,phoneNumber) VALUES ('test2@gmail.com','toc','bob','J$#EB','876765779');
INSERT INTO account(email,firstName,lastName,password,phoneNumber) VALUES ('test3@gmail.com','ter','charl','N$T@54','879078689');
