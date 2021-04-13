# 과일가게 API

## 개발환경

- OS: Mac OS
- IDE : IntelliJ
- Language : JAVA
- Middleware : Tomcat
- Framework : Spring Boot 2.4.4
- View Template : Thymeleaf

## Folder Structure

    .
    ├── src/main/java                   
    │          	 └── itemservice
    │             	   ├── controllers
    │ 		   │ 	  ├── ExceptionController
    │                  │	  └── ItemController
    │                  ├── payload
    │ 		   │ 	  ├── request
    │                  │	  │     └── SearchVo
    │                  │	  └── response
    │                  │	        └── ApiDataResponseVo
    │             	   ├── service
    │ 		   │      ├── ItemService
    │                  │	  └── ItemServiceImpl
    │             	   ├── AppConfig
    │             	   └── ItemServiceApplication
    └── src/main/resources
                  		 ├── static
                  		 └── templates
     			      └── items.html


## HTTP API

| URL                   | Description                            | Example         |
| --------------------- | -------------------------------------- | --------------- |
| /items                | 가격 조회할 수 있는 화면이 반환됩니다  | /items          |
| /fruit/{itemName}     | 비동기 방식으로 과일 가격이 조회됩니다 | /fruit/배       |
| /vegetable/{itemName} | 비동기 방식으로 채소 가격이 조회됩니다 | /vegetable/깻잎 |

