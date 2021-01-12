CREATE TABLE `liner_schedule` (
   `LINER_CODE` varchar(5) NOT NULL,
   `VESSEL_NAME` varchar(100) NOT NULL,
   `POL` varchar(5) NOT NULL,
   `POD` varchar(5) NOT NULL,
   `ETD` datetime NOT NULL,
   `ETA` datetime NOT NULL,
   `REMARK` varchar(100) DEFAULT NULL,
   PRIMARY KEY (`LINER_CODE`,`VESSEL_NAME`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8

INSERT INTO LINER_SCHEDULE 
VALUE('KMTC','VSL_NAME1','KRPUS','HKHKG','2021-01-01 14:33', '2021-01-04 16:30' , '')

INSERT INTO LINER_SCHEDULE 
VALUE('KMTC','VSL_NAME2','KRPUS','HKHKG','2021-01-01 14:33', '2021-01-04 16:30' , '')

INSERT INTO LINER_SCHEDULE 
VALUE('KMTC','VSL_NAME3','KRPUS','HKHKG','2021-01-01 14:33', '2021-01-04 16:30' , '')


INSERT INTO LINER_SCHEDULE 
VALUE('DJSC','VSL_NAME1','KRPUS','HKHKG','2021-01-01 11:33', '2021-01-04 16:30' , '')

INSERT INTO LINER_SCHEDULE 
VALUE('DJSC','VSL_NAME2','KRPUS','HKHKG','2021-01-01 07:33', '2021-01-04 16:30' , '')

INSERT INTO LINER_SCHEDULE 
VALUE('DJSC','VSL_NAME3','KRPUS','HKHKG','2021-01-01 05:33', '2021-01-04 16:30' , '')



CREATE TABLE `common_code` (
   `COUNTRY_CODE` varchar(2) NOT NULL,
   `PORT_CODE` varchar(5) NOT NULL,
   PRIMARY KEY (`COUNTRY_CODE`,`PORT_CODE`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8


INSERT INTO COMMON_CODE   VALUE('KR' , 'KRKIN')
INSERT INTO COMMON_CODE   VALUE('KR' , 'KRPUS')
INSERT INTO COMMON_CODE   VALUE('CN' , 'CNSHA')

CREATE TABLE `liner_code` (
   `LINER_CODE` varchar(4) NOT NULL,
   `ORG_PORT_CODE` varchar(5) NOT NULL,
   `COM_PORT_CODE` varchar(5) NOT NULL,
   PRIMARY KEY (`LINER_CODE`,`ORG_PORT_CODE`,`COM_PORT_CODE`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8

INSERT INTO COMMON_CODE   VALUE('KMTC' , 'KRBUS', 'KRPUS')

INSERT INTO COMMON_CODE   VALUE('KMTC' , 'KRKAN' , 'KRKIN')
INSERT INTO COMMON_CODE   VALUE('KMTC' , 'SHA'  ,'CNSHA')




