package constants;

public interface UpdateQuotePlan {

	String UPDATE_QUOTE_PLAN_REQ_FILEPATH = "//request//updateQuote.json";
	
	String SERVICE_REQUEST_DETAILS_REQ_XPATH = "ServiceRequestDetail";
	String OWNER_ID_REQ_XPATH = "ServiceRequestDetail.OwnerId";
	String RESPONSE_TYPE_REQ_XPATH = "ServiceRequestDetail.ResponseType";
	String END_CLIENT_USER_UNIQUE_SESSION_ID_REQ_XPATH = "ServiceRequestDetail.EndClientUserUniqueSessionId";
	String USER_NAME_REQ_XPATH = "ServiceRequestDetail.UserName";
	String TOKEN_REQ_XPATH = "ServiceRequestDetail.Token";
	String SERVICE_REQ_VERSION_REQ_XPATH = "ServiceRequestDetail.ServiceRequestVersion";
	String SERVICE_RES_VERSION_REQ_XPATH = "ServiceRequestDetail.ServiceResponseVersion";
	String REGION_CODE_REQ_XPATH = "ServiceRequestDetail.RegionCode";
	String LANGUAGE_CODE_REQ_XPATH = "ServiceRequestDetail.LanguageCode";
	String ACCOUNT_ID_REQ_XPATH = "accountId";
	String DEVICE_ID_REQ_XPATH = "deviceInformation[0].deviceId";
	String QUOTE_NUMBER_REQ_XPATH = "deviceInformation[0].quoteNumber";
	String IMEI_REQ_XPATH = "deviceInformation[0].imei";
	String LOCKED_TIME_REQ_XPATH = "deviceInformation[0].lockedTime";
	String EFFECTIVE_DATE_REQ_XPATH = "deviceInformation[0].effectiveDate";
}
