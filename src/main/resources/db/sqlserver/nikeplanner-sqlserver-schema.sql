
use nikeplanner;

-- =============================
-- Table of PT_USER_PROFILE_TAB
-- =============================

create table PT_USER_PROFILE_TAB (
	USER_ID int not null identity (1, 1) primary key,
	USER_NAME varchar (30) default '' not null unique,
	USER_PASSWORD varchar (150) default '' not null
);

create index idx_USER_NAME_2_PT_USER_PROFILE_TAB on PT_USER_PROFILE_TAB (USER_NAME);

-- ==================================
-- Table of PT_USER_ROLE_MAPPING_TAB
-- ==================================

create table PT_USER_ROLE_MAPPING_TAB (
	USER_ID int not null,
	USER_ROLE_ID int not null
);

create index idx_2_PT_USER_ROLE_MAPPING_TAB on PT_USER_ROLE_MAPPING_TAB (USER_ID, USER_ROLE_ID);

-- ==========================
-- Table of PT_USER_ROLE_TAB
-- ==========================

create table PT_USER_ROLE_TAB (
	USER_ROLE_ID int not null identity (1, 1) primary key,
	ROLE_NAME varchar (30) default '' not null unique
);

create index idx_ROLE_NAME_2_PT_USER_ROLE_TAB on PT_USER_ROLE_TAB (ROLE_NAME);

-- =============================================
-- Table of PT_USER_ROLE_PERMISSION_MAPPING_TAB
-- =============================================

create table PT_USER_ROLE_PERMISSION_MAPPING_TAB (
	USER_ROLE_ID int not null,
	USER_ROLE_PERMISSION_ID int not null
);

create index idx_2_PT_USER_ROLE_PERMISSION_MAPPING_TAB on PT_USER_ROLE_PERMISSION_MAPPING_TAB (USER_ROLE_ID, USER_ROLE_PERMISSION_ID);

-- =====================================
-- Table of PT_USER_ROLE_PERMISSION_TAB
-- =====================================

create table PT_USER_ROLE_PERMISSION_TAB (
	USER_ROLE_PERMISSION_ID int not null identity (1, 1) primary key,
	PERMISSION_NAME varchar (150) default '' not null,
	PERMISSION_URL varchar (300) default '' not null
);



-- ==================================
-- Table of PT_STAFF_DETAIL_TEST_TAB
-- ==================================

create table PT_STAFF_DETAIL_TEST_TAB (
	STAFF_ID int not null identity (1, 1) primary key,
	FIRST_NAME varchar (50) default '' not null,
	LAST_NAME varchar (50) default '' not null,
	IMAGE_B64 text,
	GENDER varchar (10) default '' not null,
	POSITION varchar (80) default '' not null,
	EMAIL varchar (150) default '' not null,
	OFFICE varchar (80) default '' not null,
	EXTN varchar (20) default '' not null,
	AGE int not null,
	SALARY real not null,
	START_DATE datetime default getdate() not null,
	TIME_MILLIS bigint default 0 not null
);

-- =========================================
-- Table of PT_STAFF_SALARY_DETAIL_TEST_TAB
-- =========================================

create table PT_STAFF_SALARY_DETAIL_TEST_TAB (
	STAFF_SALARY_ID int not null identity (1, 1) primary key,
	FULL_NAME varchar (100) default '' not null,
	IMAGE_B64 text,
	GROSS real not null,
	BASE real not null,
	COMPENSATION real not null,
	INCENTIVE real not null
);

-- ========================
-- PT_ASSORTMENT_IMAGE_TAB
-- ========================

create table PT_ASSORTMENT_IMAGE_TAB (
	ASSORTMENT_IMAGE_ID bigint not null identity (1, 1) primary key,
	DIVISION varchar (30) default '' not null,
	ATTRIBUTE_1 varchar (30) default '' not null,
	ATTRIBUTE_3 varchar (30) default '' not null,
	STYLE_NAME varchar (50) default '' not null,
	STYLE_RANK bigint default 0 not null,
	IMAGE_B64 text
);

create index idx_1_PT_ASSORTMENT_IMAGE_TAB ON PT_ASSORTMENT_IMAGE_TAB (DIVISION, ATTRIBUTE_1, ATTRIBUTE_3, STYLE_NAME);

-- ==========================
-- PT_ASSORT_PLAN_DETAIL_TAB
-- ==========================

create table PT_ASSORT_PLAN_DETAIL_TAB (
	ASSORT_PLAN_ID int not null identity (1, 1) primary key,
	ASSORTMENT_IMAGE_ID bigint not null,
	CATEGORY varchar (70) default '' not null,
	DIVISION varchar (30) default '' not null,
	SEASON varchar (5) default '' not null,
	PRODUCT_ID bigint default 0 not null,
	STYLE varchar (30) default '' not null,
	PRODUCT_CODE varchar (40) default '' not null,
	GENDER varchar (10) default '' not null,
	AGE varchar (20) default '' not null,
	STYLE_NAME varchar (50) default '' not null,
	SILHOUETTE varchar (50) default '' not null,
	DTC_OMD datetime default getdate() not null,
	MMX_OMD datetime default getdate() not null,
	MONTH varchar (20) default '' not null,
	SELLING_WEEKS bigint default 0 not null,
	FLOW varchar (20) default '' not null,
	FULL_COLOR_DESCRIPTION varchar (100) default '' not null,
	CN_MSRP real default 0.0 not null,
	HK_MSRP real default 0.0 not null,
	TW_MSRP real default 0.0 not null,
	ATTRIBUTE_1 varchar (30) default '' not null,
	ATTRIBUTE_2 varchar (30) default '' not null,
	ATTRIBUTE_3 varchar (30) default '' not null,
	BLIND_BUY varchar (4) default '' not null,
	DMCA varchar (4) default '' not null,
	STYLE_RANK bigint default 0 not null,
	COLOR_RANK bigint default 0 not null,
	REFERENCE_STYLE_NAME varchar (30) default '' not null,
	STORE_COUNT bigint default 0 not null,
	NIKECOM_FLAG bigint default 0 not null,
	TMALL_FLAG bigint default 0 not null,
	HKCOM_FLAG bigint default 0 not null,
	constraint fk_ASSORT_PLAN_DETAIL_2_IMAGE foreign key (ASSORTMENT_IMAGE_ID) references PT_ASSORTMENT_IMAGE_TAB (ASSORTMENT_IMAGE_ID)
);

create index idx_1_PT_ASSORT_PLAN_DETAIL_TAB on PT_ASSORT_PLAN_DETAIL_TAB (REFERENCE_STYLE_NAME);
create index idx_2_PT_ASSORT_PLAN_DETAIL_TAB on PT_ASSORT_PLAN_DETAIL_TAB (DIVISION, ATTRIBUTE_1, ATTRIBUTE_3, STYLE_RANK, REFERENCE_STYLE_NAME, STYLE_NAME, CN_MSRP);
create index idx_3_PT_ASSORT_PLAN_DETAIL_TAB on PT_ASSORT_PLAN_DETAIL_TAB (DIVISION, ATTRIBUTE_1, ATTRIBUTE_3, STYLE_NAME);

-- ===========================
-- PT_BP_T2D_STYLE_DETAIL_TAB
-- ===========================

create table PT_BP_T2D_STYLE_DETAIL_TAB (
	BP_T2D_STYLE_ID int UNSIGNED not null identity (1, 1) primary key, 
	DIVISION VARCHAR(20) DEFAULT '' NOT NULL, 
	ATTRIBUTE_1 VARCHAR(30) DEFAULT '' NOT NULL, 
	ATTRIBUTE_3 VARCHAR(30) DEFAULT '' NOT NULL, 
	RANK INT UNSIGNED DEFAULT 0 NOT NULL, 
	MSRP DOUBLE DEFAULT 0.0 NOT NULL, 
	STYLE_NAME VARCHAR(75) DEFAULT '' NOT NULL, 
	REFERENCE_STYLE VARCHAR(75) DEFAULT '' NOT NULL, 
	REV_DOLAR DOUBLE DEFAULT 0.0 NOT NULL, 
	DELTA_PERCENT DOUBLE DEFAULT 0.0 NOT NULL, 
	SALE_UNIT INT UNSIGNED DEFAULT 0 NOT NULL, 
	AUR_DOLAR DOUBLE DEFAULT 0.0 NOT NULL, 
	APS DOUBLE, 
	MD_PERCENT DOUBLE DEFAULT 0.0 NOT NULL, 
	IN_SEA_PERCENT DOUBLE, 
	ST_PERCENT DOUBLE DEFAULT 0.0 NOT NULL, 
	BUY_UNIT INT UNSIGNED DEFAULT 0 NOT NULL, 
	REV_PERCENT DOUBLE DEFAULT 0.0 NOT NULL, 
	YEAR_NUM INT UNSIGNED DEFAULT 0 NOT NULL
);





