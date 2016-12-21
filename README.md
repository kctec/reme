# playbook-service

**playbook-service** - parent Maven project containing projects related to exposing Playbook services

Sub-projects: 

**playbook-service-common** - Contains POJO objects that may be returned in all services. 

**playbook-service-entities** - JPA entities used by all services. 

**playbook-service-db** - Liquibase project for pushing changes to the PRODOPS database schema (ORACLE DB)

**playbook-resource-api** - Client API project which contains client interfaces which can be used by other Java apps consuming the resource services. Clients can use this API by including the following Maven dependency in their project.  Note that this project will also pull in POJO dependencies. 

	<dependency>
			    <groupId>ese-business-apps/groupId>
			    <artifactId>playbook-resource-api</artifactId>
			    <version>${version}</version>
			</dependency> 
			

**playbook-resource-service** - RESTful service implementation for returning Playbook resource data (departments, roles, person and other resource data) 


**Playbook services currently require the following JBOSS properties**

```
# DB
datasource.iscvapp.playbook.uri
datasource.iscvapp.playbook.password
datasource.iscvapp.playbook.username

# USED BY REST OAUTH UTIL
espn.web.oauth.service.url
espn.web.playbook-resource-service.oauth.app.id
espn.web.playbook-resource-service.oauth.app.key

### SSL Configuration - should point to trust.keystore ###
javax.net.ssl.trustStore
javax.net.ssl.trustStorePassword

```
 
**Requires the following Liquibase profile properties**

```
  espn.jdbc.url
  database.username.prodops
  database.password.prodops
```
