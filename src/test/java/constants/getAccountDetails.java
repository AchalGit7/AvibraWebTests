package constants;

public interface getAccountDetails {
	
	String GET_ACCOUNT_DETAILS_REQ_FILEPATH = "//request//getAccountDetails.json";

	//Request
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
	// Response
	String DEVICE_ID_RES_XPATH = "deviceInformation[0].deviceId";
	String PRODUCT_ID_RES_XPATH = "deviceInformation[0].productId";
	String QUOTE_NUMBER_RES_XPATH = "deviceInformation[0].quoteNumber";
	String QUOTE_NUMBER_SIGNED_IN_RES_XPATH = "deviceInformation[1].quoteNumber";
	String DEVICE_ID_SIGNED_IN_RES_XPATH = "deviceInformation[1].deviceId";
}
