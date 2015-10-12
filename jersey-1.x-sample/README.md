Info
============
- You need to setup lombok framework to your ide if you want to compile it inside your ide.
- Another option is to remove the lombok annotations and generate getter/setter/toString/hashCode/equals methods manually
- You need maven installed to be able to compile/package with provided pom.xml
- 1.x projects uses jersey 1.x version and 2.x projects uses jersey 2.x version

jersey-sample
===============

This is a sample rest application build with the jersey framework.


There is one resource defined which is called SampleResource. It is implementing CRUD operation for a simple object. Application does not have any persistence layer and returns randomly generated data for each request.


Following are the URL if you run it locally on port 8080 and with the default context root as jersey-sample


REST ENDPOINTS
===============


All endpoints are consuming/producing json 


- POST    http://localhost:8080/jersey-1.x-sample/v1/sample/create
- GET     http://localhost:8080/jersey-1.x-sample/v1/sample/read/{id}
- PUT     http://localhost:8080/jersey-1.x-sample/v1/sample/update
- DELETE  http://localhost:8080/jersey-1.x-sample/v1/sample/delete/{id}
- GET  http://localhost:8080/jersey-1.x-sample/v1/sample/list
- GET  http://localhost:8080/jersey-1.x-sample/v1/sample/list?size=4&startId=500


SampleEntity.json:

{
"id": 6694386226370551000,
"field1": "3YXVmtcCLh",
"field2": "9lRz8hegv2"
}


jersey-spring-sample
======================

Updates the jersey-sample project to use spring for injecting dependencies via applicationContext.xml file


jersey-spring-sample-noxml
============================

Updates the jersey-spring-sample project to use new annotation based configuration of spring


Load Test Details
=================
- Application is deployed on tomcat7 java7 installation
- Before each test application server is restarted fresh
- There is no other application deployed to tomcat7
- Performed on a machine with Intel i7-3632QM CPU and 8GB RAM