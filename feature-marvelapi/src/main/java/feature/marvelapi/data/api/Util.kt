package feature.marvelapi.data.api

import java.lang.StringBuilder
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

internal object Util {

    const val publicKey = "a8e89960ad1d172d104fbc9b152bba87"
    private const val privateKey = "779fdd0b62e089b94fa09ffbced0c543b0e1c937"

    private val timestamp = Calendar.getInstance().timeInMillis / 1000
//    private val timestamp = System.currentTimeMillis() / 1000
//    private val timestamp = 1L
    val ts = timestamp.toString()
    val hash1 = "$ts + $privateKey + $publicKey"
    val hash = Criptografia.md5(ts + privateKey + publicKey)

    private fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    private fun md52(s: String): String {
        val MD5 = "MD5"
        try {
            // Create MD5 Hash
            val digest = MessageDigest
                .getInstance(MD5)
            digest.update(s.toByteArray())
            val messageDigest = digest.digest()

            // Create Hex String
            val hexString = StringBuilder()
            for (aMessageDigest in messageDigest) {
                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (h.length < 2) h = "0$h"
                hexString.append(h)
            }
            return hexString.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }
}

internal class Criptografia {
    companion object {
        private val HEXCHARS = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')

        private fun hexEncode(bytes: ByteArray): String {
            val result = CharArray(bytes.size * 2)
            var b: Int
            var i = 0
            var j = 0
            while (i < bytes.size) {
                b = bytes[i].toInt() and 0xff
                result[j++] = HEXCHARS[b shr 4]
                result[j++] = HEXCHARS[b and 0xf]
                i++
            }
            return String(result)
        }


        /**
         * Cria um hash MD5 par enviarmos a API da marvel
         */
        fun md5(s: String): String {
            try { // Create MD5 Hash
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