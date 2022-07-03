-- objectDefinition
CREATE TABLE objectDefinition
(
    tableName VARCHAR2(40),
    columnName VARCHAR2(40),
    POSITION NUMBER(3)
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

-- 모델러 계정 생성 테스트
CREATE USER modeler1 IDENTIFIED BY modeler1;

GRANT CONNECT, RESOURCE, DBA TO c##modeler1;

COMMIT;