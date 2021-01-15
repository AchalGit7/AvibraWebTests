package constants;

public interface FindAccountDetails {

	String FIND_ACCOUNT_REQ_FILEPATH = "//request//findAccountDetails.json";

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
	String EMAIL_ID_REQ_XPATH = "email";
	String DEVICE_INFO_REQ_XPATH = "deviceInformation";

	// Response
	String ACCOUNT_ID_RES_XPATH = "accountList[0].accountId";

}
