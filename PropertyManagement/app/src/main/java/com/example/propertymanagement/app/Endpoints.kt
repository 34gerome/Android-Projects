package com.example.propertymanagement.app

class Endpoints {

    companion object {

        private const val URL_Login = "auth/login/"
        private const val URL_REGISTER = "auth/register/"
        private const val URL_USER = "users/"  // id also
        private const val URL_PROPERTY = "property/" // id also
        private const val URL_PROPERTY_USER = "property/user" // id only
        private const val URL_TENANT = "tenant/" // id also
        private const val URL_TENANT_LANDLORD = "tenant/landlord/" // id only
        private const val URL_PROPERTY_PICTURE = "upload/property/picture"
    }

    fun getLogin(): String {
        return Config.BASE_URL + URL_Login
    }

    fun getRegister(): String {
        return Config.BASE_URL + URL_REGISTER
    }

    fun getUSER(): String {
        return Config.BASE_URL + URL_USER
    }

    fun getUSER(userId: Int): String {
        return Config.BASE_URL + URL_USER + userId
    }

    fun getProperty(): String {
        return Config.BASE_URL + URL_PROPERTY
    }

    fun getProperty(propertyId: Int): String {
        return Config.BASE_URL + URL_PROPERTY + propertyId
    }

    fun getPropertyUserId(propUserId: Int): String {
        return Config.BASE_URL + URL_PROPERTY_USER + propUserId
    }

    fun getTenant(): String {
        return Config.BASE_URL + URL_TENANT
    }

    fun getTenant(tenantId: Int): String {
        return Config.BASE_URL + URL_TENANT + tenantId
    }

    fun getTenantLandord(tenLordId: Int): String {
        return Config.BASE_URL + URL_TENANT_LANDLORD + tenLordId
    }

    fun getPropertyPicture(): String {
        return Config.BASE_URL + URL_PROPERTY_PICTURE
    }


}