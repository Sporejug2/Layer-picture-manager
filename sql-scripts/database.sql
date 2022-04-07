create table picture (
 id int(11) NOT NULL AUTO_INCREMENT,
 name_discription varchar(200) DEFAULT NULL,
 discription varchar(200) DEFAULT NULL,
 author varchar(200) DEFAULT NULL,
 imageUrl varchar(200) DEFAULT NULL,
 width varchar(200) DEFAULT NULL,
 height varchar(200) DEFAULT NULL,
 properties json DEFAULT NULL,
  PRIMARY KEY (`id`)
);

create table name_history (
 id int(11) NOT NULL AUTO_INCREMENT,
 old_name varchar(200) DEFAULT NULL,
 creation_time time,
 picture_id int,
  PRIMARY KEY (id),
  FOREIGN KEY(picture_id) REFERENCES picture(id)
);

CREATE TRIGGER historise BEFORE UPDATE ON picture
  FOR EACH ROW
     BEGIN
       INSERT INTO name_history (old_name, creation_time, picture_id)
       SELECT picture.name_discription, now(), picture.id FROM picture
       WHERE picture.id = picture.id;
     END;
     
 CREATE TRIGGER fristDate AFTER INSERT ON picture
  FOR EACH ROW
     BEGIN
       INSERT INTO name_history (old_name, creation_time, picture_id)
       SELECT picture.name_discription, now(), picture.id FROM picture
       WHERE picture.id = picture.id;
     END;    
     
     
INSERT INTO name_history (old_name, creation_time, picture_id) SELECT picture.name_discription, now(), picture.id FROM picture WHERE picture.id = picture.id;
  
update traker_picture.picture set traker_picture.picture.name_discription = 'Natko Slatko3' where id = idofPicture;