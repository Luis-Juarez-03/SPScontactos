package com.example.spscontactos.utils
import android.util.Base64
class Utils {
    fun imageToBase64(imageBytes: ByteArray): String {
        return Base64.encodeToString(imageBytes, Base64.DEFAULT)
    }

    fun base64ToImage(base64String: String): ByteArray {
        return Base64.decode(base64String, Base64.DEFAULT)
    }
}