package feature.marvelapi.data.api

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.Calendar

internal object Util {

    const val publicKey = "a8e89960ad1d172d104fbc9b152bba87"
    private const val privateKey = "779fdd0b62e089b94fa09ffbced0c543b0e1c937"

    private val timestamp = Calendar.getInstance().timeInMillis / 1000
    val ts = timestamp.toString()
    val hash = Cryptography.md5(ts + privateKey + publicKey)
}

internal class Cryptography {
    companion object {
        private val HEX_CHARS = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')

        private fun hexEncode(bytes: ByteArray): String {
            val result = CharArray(bytes.size * 2)
            var b: Int
            var i = 0
            var j = 0
            while (i < bytes.size) {
                b = bytes[i].toInt() and 0xff
                result[j++] = HEX_CHARS[b shr 4]
                result[j++] = HEX_CHARS[b and 0xf]
                i++
            }
            return String(result)
        }

        fun md5(s: String): String {
            try {
                val digest = MessageDigest.getInstance("MD5")
                digest.update(s.toByteArray())
                return hexEncode(digest.digest())
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }
            return ""
        }
    }
}
