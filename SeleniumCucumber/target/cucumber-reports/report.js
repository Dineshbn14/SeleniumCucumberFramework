$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/LoginPage.feature");
formatter.feature({
  "name": "Login Page feature",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@LoginPage"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Login Page Title",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@LoginSwagLabs"
    }
  ]
});
formatter.step({
  "name": "user is able to navigate to url",
  "keyword": "Given "
});
formatter.step({
  "name": "user logs in as \"\u003cuserId\u003e\" and \"PasswordManger\"",
  "keyword": "When "
});
formatter.step({
  "name": "user navigates to the dashboard and verifies title",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "userId"
      ]
    },
    {
      "cells": [
        "standard_user"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login Page Title",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@LoginPage"
    },
    {
      "name": "@LoginSwagLabs"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is able to navigate to url",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginPageStepDef.user_is_able_to_navigate_to_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user logs in as \"standard_user\" and \"PasswordManger\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginPageStepDef.user_logs_in(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigates to the dashboard and verifies title",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageStepDef.user_navigates_to_dashboard_and_verifies_title()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});