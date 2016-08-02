package org.our.android.user.model;

/**
 * 用户
 * Created by wangyang on 2016/8/1.
 */
public class User {
    public String mId;
    public String mUserName;
    public String mPassword;
    public boolean mIsMobilePhoneNumberVerified;
    public String mMobilePhoneNumber;
    public boolean mIsEmailVerified;
    public String mEmail;
    public String mCreateTime;
    public String mUpdateTime;

//    public User(String id, String userName, String password, boolean isMobilePhoneNumberVerified, String mobilePhoneNumber, boolean isEmailVerified, String email, String createTime, String updateTime) {
//        mId = id;
//        mUserName = userName;
//        mPassword = password;
//        mIsMobilePhoneNumberVerified = isMobilePhoneNumberVerified;
//        mMobilePhoneNumber = mobilePhoneNumber;
//        mIsEmailVerified = isEmailVerified;
//        mEmail = email;
//        mCreateTime = createTime;
//        mUpdateTime = updateTime;
//    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public boolean isMobilePhoneNumberVerified() {
        return mIsMobilePhoneNumberVerified;
    }

    public void setMobilePhoneNumberVerified(boolean mobilePhoneNumberVerified) {
        mIsMobilePhoneNumberVerified = mobilePhoneNumberVerified;
    }

    public String getMobilePhoneNumber() {
        return mMobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        mMobilePhoneNumber = mobilePhoneNumber;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public boolean isEmailVerified() {
        return mIsEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        mIsEmailVerified = emailVerified;
    }

    public String getCreateTime() {
        return mCreateTime;
    }

    public void setCreateTime(String createTime) {
        mCreateTime = createTime;
    }

    public String getUpdateTime() {
        return mUpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        mUpdateTime = updateTime;
    }
}
