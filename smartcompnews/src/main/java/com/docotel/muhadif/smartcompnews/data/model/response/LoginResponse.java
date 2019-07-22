
package com.docotel.muhadif.smartcompnews.data.model.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LoginResponse {

    @Expose
    private String address;
    @Expose
    private Long balance;
    @SerializedName("bank_account_number")
    private String bankAccountNumber;
    @Expose
    private String city;
    @SerializedName("city_name")
    private String cityName;
    @SerializedName("city_type")
    private String cityType;
    @SerializedName("community_id")
    private Long communityId;
    @Expose
    private String dob;
    @Expose
    private String email;
    @SerializedName("first_login")
    private String firstLogin;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("id_card")
    private String idCard;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("is_agent")
    private String isAgent;
    @SerializedName("is_merchant")
    private String isMerchant;
    @SerializedName("is_set_pin")
    private Long isSetPin;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("last_updated_balance")
    private String lastUpdatedBalance;
    @SerializedName("member_id")
    private String memberId;
    @SerializedName("ori_last_updated_balance")
    private String oriLastUpdatedBalance;
    @SerializedName("phone_number")
    private String phoneNumber;
    @Expose
    private String postcode;
    @Expose
    private String province;
    @SerializedName("province_name")
    private String provinceName;
    @SerializedName("qr_image")
    private String qrImage;
    @SerializedName("user_chat_id")
    private String userChatId;
    @SerializedName("user_id")
    private Long userId;
    @SerializedName("va_credit")
    private String vaCredit;
    @SerializedName("va_debet")
    private String vaDebet;
    @SerializedName("va_unikqu")
    private String vaUnikqu;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityType() {
        return cityType;
    }

    public void setCityType(String cityType) {
        this.cityType = cityType;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(String firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIsAgent() {
        return isAgent;
    }

    public void setIsAgent(String isAgent) {
        this.isAgent = isAgent;
    }

    public String getIsMerchant() {
        return isMerchant;
    }

    public void setIsMerchant(String isMerchant) {
        this.isMerchant = isMerchant;
    }

    public Long getIsSetPin() {
        return isSetPin;
    }

    public void setIsSetPin(Long isSetPin) {
        this.isSetPin = isSetPin;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastUpdatedBalance() {
        return lastUpdatedBalance;
    }

    public void setLastUpdatedBalance(String lastUpdatedBalance) {
        this.lastUpdatedBalance = lastUpdatedBalance;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getOriLastUpdatedBalance() {
        return oriLastUpdatedBalance;
    }

    public void setOriLastUpdatedBalance(String oriLastUpdatedBalance) {
        this.oriLastUpdatedBalance = oriLastUpdatedBalance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getQrImage() {
        return qrImage;
    }

    public void setQrImage(String qrImage) {
        this.qrImage = qrImage;
    }

    public String getUserChatId() {
        return userChatId;
    }

    public void setUserChatId(String userChatId) {
        this.userChatId = userChatId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getVaCredit() {
        return vaCredit;
    }

    public void setVaCredit(String vaCredit) {
        this.vaCredit = vaCredit;
    }

    public String getVaDebet() {
        return vaDebet;
    }

    public void setVaDebet(String vaDebet) {
        this.vaDebet = vaDebet;
    }

    public String getVaUnikqu() {
        return vaUnikqu;
    }

    public void setVaUnikqu(String vaUnikqu) {
        this.vaUnikqu = vaUnikqu;
    }

}
