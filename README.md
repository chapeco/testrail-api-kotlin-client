# TestRail API Kotlin Client

## Setup

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


