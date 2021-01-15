package constants;

public interface PayAndIssue {
    String UPDATE_QUOTE_PLAN_REQ_FILEPATH = "//request//payAndIssue.json";

    String ACCOUNT_ID_REQ_XPATH = "accountId";
    String DEVICE_ID_REQ_XPATH = "deviceInformation[0].deviceId";
    String QUOTE_NUMBER_REQ_XPATH = "deviceInformation[0].quoteNumber";
    String BOUND_TIME_REQ_XPATH = "deviceInformation[0].boundTime";
    String ISSUED_TIME_REQ_XPATH = "deviceInformation[0].issuedTime";
    String PAY_EFFECTIVE_DATE_REQ_XPATH = "deviceInformation[0].effectiveDate";
}
