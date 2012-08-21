create table Interview_Interview (
	uuid_ VARCHAR(75) null,
	interviewId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	startDate DATE null,
	expireDate DATE null,
	questionSetId LONG,
	response VARCHAR(300) null
);

create table Interview_Question (
	questionId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	questionSetId LONG,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	type_ INTEGER,
	order_ INTEGER
);

create table Interview_QuestionSet (
	questionSetId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	timeLimit INTEGER
);