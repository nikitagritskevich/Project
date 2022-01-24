package automationTest.framework.service;

import automationTest.framework.model.UserEmailBox;

public class EmailCreator {

  public static final String TESTDATA_EMAIL_NAME = "testdata.email.name";
  public static final String TESTDATA_EMAIL_PASSWORD = "testdata.email.password";

  public static UserEmailBox withCredentialsFromProperty() {
    return new UserEmailBox(TestDataReader.getTestData(TESTDATA_EMAIL_NAME),
        TestDataReader.getTestData(TESTDATA_EMAIL_PASSWORD));
  }

  public static UserEmailBox withEmptyUsername() {
    return new UserEmailBox("", TestDataReader.getTestData(TESTDATA_EMAIL_NAME));
  }

  public static UserEmailBox withEmptyPassword() {
    return new UserEmailBox(TestDataReader.getTestData(TESTDATA_EMAIL_NAME), "");
  }
}