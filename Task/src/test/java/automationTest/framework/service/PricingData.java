package automationTest.framework.service;

public class PricingData {

  private final static String TEST_DATA_PRICING_DATE_NUMBER_INSTANCE = "testdata.pricingdata.numberInstance";
  private final static String TEST_DATA_PRICING_DATE_SERIES_NUMBER = "testdata.pringdata.seriesnumber";
  private final static String TEST_DATA_PRICING_DATE_MACHINE_TYPE = "testdata.pricingdata.machinetype";
  private final static String TEST_DATA_PRICING_DATE_NUMBER_GPU = "testdata.pricingdata.numberGPUs";
  private final static String TEST_DATA_PRICING_DATA_VALUE_LOCAL_SSD = "testdata.pricingdata.valueLocalSSD";
  private final static String TEST_DATA_PRICING_DATA_VALUE_COMMITTED_USAGES = "testdata.pricingdata.valueCommittedUsages";
  private final static String TEST_DATA_PRICING_DATA_VALUE_DATACENTER_LOCATION = "testdata.pricingdata.valueDatacenterLocation";

  public String getNumberInstance() {
    return TestDataReader.getTestData(TEST_DATA_PRICING_DATE_NUMBER_INSTANCE);
  }

  public String getSeriesNumber() {
    return TestDataReader.getTestData(TEST_DATA_PRICING_DATE_SERIES_NUMBER);
  }

  public String getMachineType() {
    return TestDataReader.getTestData(TEST_DATA_PRICING_DATE_MACHINE_TYPE);
  }

  public String getNumberGPUs() {
    return TestDataReader.getTestData(TEST_DATA_PRICING_DATE_NUMBER_GPU);
  }

  public String getLocalSSDValue() {
    return TestDataReader.getTestData(TEST_DATA_PRICING_DATA_VALUE_LOCAL_SSD);
  }

  public String getCommittedUsages() {
    return TestDataReader.getTestData(TEST_DATA_PRICING_DATA_VALUE_COMMITTED_USAGES);
  }

  public String getValueDatacenterLocation() {
    return TestDataReader.getTestData(TEST_DATA_PRICING_DATA_VALUE_DATACENTER_LOCATION);
  }
}
