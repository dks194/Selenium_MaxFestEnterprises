package dataProvider;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
  


  @DataProvider(name = "unsuccessfulLogin")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "admin", "12345" },
      new Object[] { "adm", "123456" },
      new Object[] {"admi","12345"}
    };
  }
}
