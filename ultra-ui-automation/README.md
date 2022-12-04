# Tech task for Ultra.io - Task 1

UI automation framework for Saucedemo.com

### Used Libraries: 
- Spring Boot
- Selenium
- Atlas 
- Yandex Matchers
- Cucumber



### Instructions to run locally:
Run prerequisites: JDK 17

1) Clean up

```
gradlew clean
```

2) Start test execution

```
gradlew test
```

3) Generate Allure Report

```
gradlew allureServe
```


Note: Commands above will start execution on Chrome browsers, in order to change browser (chrome,firefox,safari) please update `browser` property in `ultra-ui-automation/src/main/resources/application.yaml`


### How to run on jenkins:
You need a jenkins with JDK 17 set up.
Create a jenkins pipeline; In **Pipeline** section the `Definition` dropdown should be set to `pipeline script from SCM`, then provide link for the repository and path to the jenkins file `ultra-ui-automation/Jenkinsfile`


