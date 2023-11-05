package asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.composites

import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits08.FinalOpCode
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits08.MaskLength
import symmetrical.cosmic.__transpectors.transpectors.Bytes
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._bitmaps.Bits16
import symmetrical.cosmic._bitmaps.Bits32

class GenericSocketFrame {
    private var payloadLength       = 0
    private var maskKey:ByteArray   = ByteArray(0)
    private var payload:String      = ""

    private val finalOpCode : FinalOpCode
    private val maskLength  : MaskLength


    private var nextByte : Int = 0

    private val bytes       :ByteArray
    private val remainder   : ByteArray

    constructor(bytes:ByteArray) {
        this.bytes  = bytes
        finalOpCode = FinalOpCode(bytes[nextByte++].toUByte())
        maskLength  = MaskLength (bytes[nextByte++].toUByte())

        val lth = maskLength.getByteLength()
        if (lth < 126) {
            payloadLength = maskLength.getByteLength()
        }
        if (lth == 126) {
            payloadLength = Bits16(bytes[nextByte++].toUByte(), bytes[nextByte++].toUByte()).toDecimal()
        }
        if (lth == 127) {
            payloadLength = Bits32(bytes[nextByte++].toUByte(), bytes[nextByte++].toUByte(), bytes[nextByte++].toUByte(), bytes[nextByte++].toUByte()).toDecimal()
        }
        if (maskLength.isMasked()) {
            maskKey = Bits32(bytes[nextByte++].toUByte(), bytes[nextByte++].toUByte(), bytes[nextByte++].toUByte(), bytes[nextByte++].toUByte()).getByteArray()
        }

        payload = Strings.scramble(applyMask(Bytes.selectBytes(nextByte, payloadLength, bytes)))

        val end = nextByte+payloadLength
        remainder = Bytes.selectBytes(end, bytes.size-end, bytes)
    }

    fun getRemainder() : ByteArray {
        return remainder
    }
    fun getByteArray() : ByteArray {
        return bytes
    }

    fun getOpCode() : Int {
        return finalOpCode.getOpCode()
    }

    fun getPayload() : String {
        return payload
    }

    fun hasRemainder() : Boolean {
        return remainder.isNotEmpty()
    }

    private fun applyMask(payload:ByteArray) : String {
        val unmaskedPayload = ByteArray(payload.size)
        for (i in payload.indices) {
            unmaskedPayload[i] = (payload[i].toInt() xor maskKey[i % 4].toInt()).toByte()
        }
        return String(unmaskedPayload)
    }

}