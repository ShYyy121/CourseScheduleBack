/*CREATE DATABASE course_schedule
    COLLATE Chinese_Simplified_Pinyin_100_CI_AI_KS_WS_SC_UTF8*/
USE course_schedule;

IF OBJECT_ID('Teacher', 'U') IS NOT NULL
    DROP TABLE Teacher;

CREATE TABLE Teacher (
                         teacher_id INT IDENTITY(1,1) PRIMARY KEY,
                         teacher_name VARCHAR(50),
                         teacher_password VARCHAR(50)
);

IF OBJECT_ID('Classroom', 'U') IS NOT NULL
    DROP TABLE Classroom;

CREATE TABLE Classroom (
                           classroom_id INT IDENTITY(1,1) PRIMARY KEY,
                           classroom_name VARCHAR(50),
                           equipment_type VARCHAR(50),
                           equipment_count INT,
                           capacity INT
);

IF OBJECT_ID('Course', 'U') IS NOT NULL
    DROP TABLE Course;

CREATE TABLE Course (
                        course_id INT IDENTITY(1,1) PRIMARY KEY,
                        course_name VARCHAR(50),
                        total_hours INT,
                        lab_hours INT
);

IF OBJECT_ID('Experiment', 'U') IS NOT NULL
    DROP TABLE Experiment;

CREATE TABLE Experiment (
                            experiment_id INT IDENTITY(1,1) PRIMARY KEY,
                            experiment_name VARCHAR(50),
                            experiment_type VARCHAR(50),
                            hours INT
);

IF OBJECT_ID('Major', 'U') IS NOT NULL
    DROP TABLE Major;

CREATE TABLE Major (
                       major_code INT IDENTITY(1,1) PRIMARY KEY,
                       major_name VARCHAR(50)
);

IF OBJECT_ID('Grade', 'U') IS NOT NULL
    DROP TABLE Grade;

CREATE TABLE Grade (
                       grade_id INT IDENTITY(1,1) PRIMARY KEY,
                       grade_name VARCHAR(50)
);

IF OBJECT_ID('TeachingClass', 'U') IS NOT NULL
    DROP TABLE Class;

CREATE TABLE Class (
                               class_id INT IDENTITY(1,1) PRIMARY KEY,
                               student_count INT,
                               course_id INT,
                               major_code INT,
                               grade_id INT,
                               teacher_id INT,
                               FOREIGN KEY (course_id) REFERENCES Course(course_id),
                               FOREIGN KEY (major_code) REFERENCES Major(major_code),
                               FOREIGN KEY (grade_id) REFERENCES Grade(grade_id),
                               FOREIGN KEY (teacher_id) REFERENCES Teacher(teacher_id)
);

IF OBJECT_ID('Administrator', 'U') IS NOT NULL
    DROP TABLE Administrator;

CREATE TABLE Administrator (
                               admin_id INT IDENTITY(1,1) PRIMARY KEY,
                               admin_name VARCHAR(50),
                               admin_password VARCHAR(50)
);

IF OBJECT_ID('AcademicCalendar', 'U') IS NOT NULL
    DROP TABLE AcademicCalendar;

CREATE TABLE AcademicCalendar (
                                  semester VARCHAR(50) PRIMARY KEY,
                                  start_date DATE,
                                  end_date DATE
);

IF OBJECT_ID('Schedule', 'U') IS NOT NULL
    DROP TABLE Schedule;

CREATE TABLE Schedule (
                          schedule_id INT IDENTITY(1,1) PRIMARY KEY,
                          class_id INT,
                          classroom_id INT,
                          week INT,
                          weekday INT,
                          period INT,
                          FOREIGN KEY (class_id) REFERENCES Class(class_id),
                          FOREIGN KEY (classroom_id) REFERENCES Classroom(classroom_id)
);

IF OBJECT_ID('PreSchedule', 'U') IS NOT NULL
    DROP TABLE PreSchedule;

CREATE TABLE PreSchedule (
                             preschedule_id INT IDENTITY(1,1) PRIMARY KEY,
                             class_id INT,
                             classroom_id INT,
                             week INT,
                             weekday INT,
                             period INT,
                                 FOREIGN KEY (class_id) REFERENCES Class(class_id),
                             FOREIGN KEY (classroom_id) REFERENCES Classroom(classroom_id)
);

CREATE TABLE SPRING_SESSION (
                                PRIMARY_ID CHAR(36) NOT NULL,
                                SESSION_ID CHAR(36) NOT NULL,
                                CREATION_TIME BIGINT NOT NULL,
                                LAST_ACCESS_TIME BIGINT NOT NULL,
                                MAX_INACTIVE_INTERVAL INT NOT NULL,
                                EXPIRY_TIME BIGINT NOT NULL,
                                PRINCIPAL_NAME VARCHAR(100),
                                CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
);

CREATE TABLE SPRING_SESSION_ATTRIBUTES (
                                           SESSION_PRIMARY_ID CHAR(36) NOT NULL,
                                           ATTRIBUTE_NAME VARCHAR(200) NOT NULL,
                                           ATTRIBUTE_BYTES VARBINARY(MAX) NOT NULL,
                                           CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
                                           CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE
);

CREATE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);
CREATE INDEX SPRING_SESSION_IX4 ON SPRING_SESSION_ATTRIBUTES (SESSION_PRIMARY_ID);
