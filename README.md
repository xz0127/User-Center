# Personal Center

A simple backend application built with Spring Boot which integrates Spring Web, Spring Data JPA and Mail Sender to provide the backend service for User Center. It supports CRUD operations such as:
* User registration/login. 
* View/update user settings.
* Article publish/update/delete/show 

RESTful Web Service is built based on SpringMVC. The ORM layer follows the JPA specification with default provider Hibernate. JWT is used for authorization purpose. Strategy Pattern / Responsibility Chain Pattern are adopted for service handling

### Tech Stacks
* Spring Boot / Spring MVC
* Spring Data JPA
* JWT/Java Mail Sender
* Mysql

### APIS
* Host: http://localhost:8080/user-center
* Registration/Login:
  * `Post: user/getcaptcha`
    * payload: `{"username":"your_username","password":"your_password","email":"youremail@mail.com"}`
  * `Post: user/register`
    * payload: `{"username":"your_username","password":"your_password","email":"youremail@mail.com",
      "captcha:"captcha"}`
  * `Post: user/login`
    * paylaod: `{ username : "your_username", password : "your_password"}`
* User Center (Requires Auth header):
  * `Post: account/center`
  * `Post: account/settings/profile/show`
  * `Post: account/settings/profile/update`
    * payload: `{"username": "admin","email": "somemail@mail.com","personalProfile": "Oh Yeah","country": "","province": "","city": "","streetAddress": "","areaNumber": "","phoneNumber": "123123"}`
  * `Post: account/settings/notice/show`
  * `Post: account/settings/notice/notice`
    * payload: `{"todoNotice": "1","sysMessageNotice": "1","otherUserMessageNotice": "1"}`

* Article (Requires Auth header):
  * `Post: article/publish`
    * payload: `{"publishTime":"","title":"","content ":"","articleTagList ":[]}`
  * `Post: article/update`
    * payload: `{"id":"","publishTime":"","title":"","content ":"","articleTagList ":[]}`
  * `Post: article/delete`
    * payload: `{"id":""}`
  * `Post: article/show/detail`
    * payload: `{"id":""}`

### Get Started
* Update settings in `application.properties`
* Import `maven` dependency
* Ensure `mysql` server is running.
* Start application.

### Official Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.2/reference/htmlsingle/#boot-features-developing-web-applications)
* [Java Mail Sender](https://docs.spring.io/spring-boot/docs/2.6.2/reference/htmlsingle/#boot-features-email)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.2/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
