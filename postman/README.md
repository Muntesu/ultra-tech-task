# Tech task for Ultra.io - Task 2

Postman collection for validating  'POST https://gorest.co.in//public/v2/users' endpoint

### Instructions to run via Postman:

- Import create_user_collection.json collection
- Import prod.postman_environment.json environment
- Update auth_token with a valid token
- Run collection

*Note: Two tests are failing due to api errors. Api is returning wrong result when malformed JSON is sent. Api is
returning wrong error message when incorrect status is sent*

### Instructions to run via Newman (npm package):

- Install node and npm
- Install newman npm package

```
npm i -g newman
```

- Install newman-reporter-htmlextra package

```
npm i -g newman-reporter-htmlextra
```

- Run collection

```
newman run create_user_collection.json  -e prod.postman_environment.json  --reporters cli,junit,htmlextra --reporter-junit-export "newman_result.xml" --reporter-htmlextra-export "newman_result.html"
```

- Open **newman_result.html** file to see the results


### Instructions to run via Newman (docker container):
```
docker pull postman/newman
```
```
docker run --rm --name newman --volume `pwd`:/etc/newman postman/newman run create_user_collection.json --environment prod_env.json
```

### How to run on jenkins:
Create a jenkins pipeline; In **Pipeline** section the `Definition` dropdown should be set to `pipeline script from SCM`, then provide link for the repository and path to the jenkins file `postman/Jenkinsfile`

