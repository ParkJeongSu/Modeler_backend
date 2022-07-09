-- 모델러 계정 생성 테스트

alter session set "_ORACLE_SCRIPT"=true;

create user modeler1 identified by modeler1;

grant create session to modeler1;

grant connect, resource, DBA to modeler1;

alter user modeler1 default tablespace users quota unlimited on users;

-- objectDefinition
CREATE TABLE objectDefinition
(
    tableName VARCHAR2(40),
    columnName VARCHAR2(40),
    POSITION NUMBER(3),
    keyFlag VARCHAR2(40),
    userFlag VARCHAR2(40),
    dateFlag VARCHAR2(40),
    dataType VARCHAR2(40)
);

ALTER TABLE objectDefinition ADD CONSTRAINT objectDefinition_pk PRIMARY KEY (tableName,columnName,POSITION);

COMMENT ON
TABLE objectDefinition IS '테이블정의';

COMMENT ON
COLUMN objectDefinition.tableName IS '테이블이름';

COMMENT ON
COLUMN objectDefinition.columnName IS '컬럼이름';

COMMENT ON
COLUMN objectDefinition.position IS '컬럼순서';

COMMENT ON
COLUMN objectDefinition.keyFlag IS '사용자id컬럼';

COMMENT ON
COLUMN objectDefinition.userFlag IS '사용자id컬럼';

COMMENT ON
COLUMN objectDefinition.dateFlag IS '변경날짜flag';

COMMENT ON
COLUMN objectDefinition.dataType IS '데이터 타입';



-- userDefinition

CREATE TABLE userDefinition
(
    userId VARCHAR2(40),
    password VARCHAR2(40),
    email VARCHAR2(40),
    phoneNumber VARCHAR2(40),
    userLevel VARCHAR2(40), -- Admin,nomal 관리자, 일반유저
    groupName VARCHAR2(40)
);

ALTER TABLE userDefinition ADD CONSTRAINT userDefinition_pk PRIMARY KEY (userId);

COMMENT ON
TABLE userDefinition IS '사용자정의';

COMMENT ON
COLUMN userDefinition.userId IS '사용자아이디';

COMMENT ON
COLUMN userDefinition.password IS '사용자비밀번호';

COMMENT ON
COLUMN userDefinition.email IS '사용자이메일';

COMMENT ON
COLUMN userDefinition.phoneNumber IS '사용자전화번호';

COMMENT ON
COLUMN userDefinition.userLevel IS '사용자레벨';

COMMENT ON
COLUMN userDefinition.groupName IS '사용자그룹이름';

-- menuDefinition

CREATE TABLE menuDefinition
(
    menuName VARCHAR2(40),
    position NUMBER(3),
    superMenuName VARCHAR2(40)
);

ALTER TABLE menuDefinition ADD CONSTRAINT menuDefinition_pk PRIMARY KEY (menuName,position,superMenuName);

COMMENT ON
TABLE menuDefinition IS '메뉴정의';

COMMENT ON
COLUMN menuDefinition.menuName IS '메뉴이름';

COMMENT ON
COLUMN menuDefinition.position IS '메뉴순서';

COMMENT ON
COLUMN menuDefinition.superMenuName IS '상위메뉴이름';



-- 여기서 부턴 관리테이블

CREATE TABLE MACHINE
(
	FACTORYNAME VARCHAR2(40),
    MACINHNAME VARCHAR2(40),
    MACHINESPECNAME VARCHAR2(40),
    MACHINEGROUPNAME VARCHAR2(40)
);

ALTER TABLE MACHINE ADD CONSTRAINT MACHINE_pk PRIMARY KEY (FACTORYNAME,MACINHNAME);

COMMENT ON
TABLE MACHINE IS '설비';

COMMENT ON
COLUMN MACHINE.FACTORYNAME IS '샵이름';

COMMENT ON
COLUMN MACHINE.MACINHNAME IS '설비명';

COMMENT ON
COLUMN MACHINE.MACHINESPECNAME IS '설비스펙';

COMMENT ON
COLUMN MACHINE.MACHINEGROUPNAME IS '설비그룹';