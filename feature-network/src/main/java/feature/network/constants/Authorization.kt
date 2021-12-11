package feature.network.constants

import java.math.BigInteger
import java.security.MessageDigest

object Authorization {
    const val dogsAuth: String = "54985b8c-d100-4b7a-9032-4c4feea147a4"
    const val newsApiAuth: String = "bd85f7c4ab644a508ca22fb524e69276"

}

object MarvelHeader{
    const val publicKey = "a8e89960ad1d172d104fbc9b152bba87"
    const val privateKey = "779fdd0b62e089b94fa09ffbced0c543b0e1c937"

    val ts = System.currentTimeMillis().toString()
    val hash = "$ts + $publicKey + $privateKey".md5()

    private fun String.md5(): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }
}
