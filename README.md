# Automated web/mobile/api tests for the [Todoist](http://todoist.com/) task manager  - graduation project ([QA.GURU](https://qa.guru/) school)
<p align="left">
<img title="Todoist" src="images/logo/todoist.PNG">
</p>

##  :page_with_curl: Content

➠ [Test cases](#TestCases)

➠ [Technology stack](#TechnologyStack)

➠ [Launch from the terminal](#Terminal)

➠ [Jenkins job](#Jenkins)

## :globe_with_meridians: <a name="TestCases"></a> Test cases
- ### WEB
<p align="left">
<img title="Web" src="images/screenshots/Web.PNG">
</p>

- ### API
<p align="left">
<img title="Api" src="images/screenshots/Api.PNG">
</p>

- ### MOBILE
<p align="left">
<img title="Mobile" src="images/screenshots/Mobile.PNG">
</p>

## :computer: <a name="TechnologyStack"></a> Technology stack

<p align="center">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="5%" title="Appium" src="images/logo/Appium.svg">
<img width="5%" title="RestAssured" src="images/logo/RestAssured.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Browserstack" src="images/logo/Browserstack.svg">
<img width="7%" title="Android Studio" src="images/logo/android-studio-1.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Allure TestOps" src="images/logo/Allure_TO.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

```mermaid        
    stateDiagram-v2
        State1: Let's do some automation!
        State2: Java & IntelliJ IDEA
        State3: Selenide & JUnit5
        State4: GitHub
        State5: Gradle
        State6: Jenkins
        State7: Selenoid
        State8: Allure Report & TestOps
        State9: Telegram
        State10: Android Studio
        State11: Appium
        State12: Browserstack
        State13: Local Mobile Tests
        State14: Remote Mobile Tests
        State15: Local Web Tests
        State16: Remote Web Tests
        State17: API tests
        State18: Rest Assured
        State1 --> State2
        State2 --> State3
        State3 --> State4
        State4 --> State5
        State5 --> State15
        State5 --> State13
        State5 --> State6
        State16 --> State7
        State6 --> State9
        State6 --> State14
        State6 --> State4
        State6 --> State17
        State6 --> State16
        State17 --> State18
        State7 --> State8
        State8 --> State9
        State13 --> State11
        State11 --> State10
        State14 --> State12
        State18 --> State8
        State12 --> State8
        note right of State2 : Code writing
        note left of State3 : Frameworks
        note left of State4 : Version Control System
        note left of State5 : Project building
        note left of State6 : Automation server
        note right of State7 : Containerization
        note right of State8 : Reporting system & Quality management platform
        note left of State9 : Notifications
        note right of State12 : Cloud testing platform
        note left of State11 : Mobile automation tool
        note right of State10 : IDE for android apps
        note left of State18 : Java domain-specific language
```

## :technologist: <a name="Terminal"></a> Launch from the terminal

### Local test run:

```
gradle clean mobileTests -DmobileDeviceHost=emulation
```

### Remote test run:

```
gradle clean 
${TYPE}Tests
```

```mermaid
graph LR
A[TYPE] --> B[web]
A --> D[api]
A --> E[mobile]
A --> F[all]
```

## <a name="Jenkins"></a><img width="4%" title="Jenkins" src="images/logo/Jenkins.svg"> Jenkins [job](https://jenkins.autotests.cloud/job/SergeevSS90-Diploma-todoist/)

<p align="center">
  <img src="images/screenshots/Jenkins.PNG">
</p>

### :robot: Build Options

<p align="center">
  <img src="images/screenshots/BuildOptions.PNG">
</p>
