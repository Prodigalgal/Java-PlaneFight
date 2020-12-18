create table users.user
(
	loginName char(10) not null,
	loginPassword char(10) null,
	UserScore int default 0 null,
	UserId int auto_increment,
	Money int default 0 null,
	PlaneHP int default 3 null,
	PlaneDamage int default 2 null,
	PlaneSpeed int default 0 null,
	constraint user_UserId_uindex
		unique (UserId),
	constraint user_loginName_uindex
		unique (loginName)
);

alter table users.user
	add primary key (loginName);

