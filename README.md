# TestRail API Kotlin Client

## Overview

The goal of this project is to simplify the process of making GET & POST requests to the TestRail RESTful API service using the Kotlin programming language. Kotlin was chosen for this project since it offers multi-language interoperability, native serialization support, open source HTTP networking libraries, data classes with optional parameters, and null safety. Currently this project is focused on supporting JVM languages. In the long term of this project, the goal is to support all languages that are interoperable with Kotlin.

&nbsp;

For detailed documentation of all data types and methods available in this client please refer to the [wiki](https://github.com/chapeco/testrail-api-kotlin-client/wiki).

## Setup

Maven Dependency (IN PROGRESS - Check Back Soon):

```
TODO
```


Set the following system properties with valid values:

* **testrailEndpoint**
	- Example: 
	
		`-DtestrailEndpoint="https://<some_endpoint>.testrail.io/"`
* **testrailUsername**
	- Example:
	
		`-DtestrailUsername="some_user@gmail.com"`
* **testrailPassword**
	- Example:
	
		`-DtestrailPassword="some_password!!!789"`

## Example Usage

###For in depth documentation refer to the [Wiki](https://github.com/chapeco/testrail-api-kotlin-client/wiki)

### Creating a new case in TestRail:

```
val caseFoo = Case( sectionId = 1, title = "My Expected Case" ).addCase()
```


### Adding a result to an existing case in TestRail:

```
val someRunId = 1
val resultFoo = Result(caseId = 1, statusId = 1).addResultForCase(someRunId)
```


