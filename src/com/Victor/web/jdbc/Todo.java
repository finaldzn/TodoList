package com.Victor.web.jdbc;

public class Todo {
public int id;
public String content;
public Todo(int id, String content)
{
	this.setId(id);
	this.setContent(content);
}
public Todo(String content)
{
	this.setContent(content);
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String toString()
{
	return id+"\n"+content;
}
}
