package feature.marvelapi.data.api

import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.Calendar

internal object Util {

    const val publicKey = "a8e89960ad1d172d104fbc9b152bba87"
    private const val privateKey = "779fdd0b62e089b94fa09ffbced0c543b0e1c937"

    private val timestamp = Calendar.getInstance().timeInMillis / 1000
    val ts = timestamp.toString()
    val hash = "$ts$privateKey$publicKey".md5()

    private fun String.md5(): String =
        BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
            .toString(16).padStart(32, '0')
}
