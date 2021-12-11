package feature.marvelapi.data.api

import java.math.BigInteger
import java.security.MessageDigest

internal object Util {


    val publicKey = "a8e89960ad1d172d104fbc9b152bba87"
    val privateKey = "779fdd0b62e089b94fa09ffbced0c543b0e1c937"

    val ts = System.currentTimeMillis().toString()
    val hash = "$ts + $publicKey + $privateKey".md5()

    private fun String.md5(): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }
}