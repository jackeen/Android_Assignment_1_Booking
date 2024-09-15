package app.fatal.assignment_1_booking.user

import android.content.Context
import android.content.SharedPreferences
import app.fatal.assignment_1_booking.data.users
import app.fatal.assignment_1_booking.model.User

class UserState(
    private val context: Context
) {

    val LOGIN_USER = "LoginUser"
    val SHARED_PREFERENCE = "PrefBooking"
    val sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    val userList = users

    public fun login(userName: String, password: String) : User? {
        val user = userList.find { it.userName == userName }
        if (user != null) {
            if (user.password == password) {
                editor.putString(LOGIN_USER, user.userName)
                editor.apply()
                return user
            }
        }
        return null
    }

    public fun logout() {
        editor.remove(LOGIN_USER)
        editor.apply()
    }

    public fun getCurrentUser(): User? {
        val userName = sharedPreferences.getString(LOGIN_USER, "")
        if (userName != "") {
            val user = userList.find { it.userName == userName }
            if (user != null) {
                return user
            }
        }
        return null
    }
}