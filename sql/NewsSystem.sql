create database stu_1352937;
use stu_1352937;
create table interdata(NewsName text ,NewsHref text, NewsTime text);
create table mainlanddata(NewsName text ,NewsHref text, NewsTime text);
create table socidata(NewsName text ,NewsHref text, NewsTime text);
create table taidata(NewsName text ,NewsHref text, NewsTime text);
create table user(username text,userPWD text);
create table faverUser(userName text,interNews int,mainNews int,sociNews int,taiNews int);
create table pictureNews(title text,pictureHref text,textHref text);