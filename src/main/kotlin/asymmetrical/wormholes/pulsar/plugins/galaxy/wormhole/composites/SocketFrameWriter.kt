package asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.composites

import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits08.FinalOpCode
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits08.MaskLength
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits04.Final
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits16.ShortLength
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits32.IntLength
import symmetrical.cosmic._bitmaps.Bits04

open class SocketFrameWriter {
    private   val finalOpCode : FinalOpCode
    protected val maskLength  : MaskLength
    private   var shortLength : ShortLength?    = null
    private   var intLength   : IntLength?      = null
    protected var payload     : String          = ""

    constructor(opCode: Bits04, maskLength: MaskLength, payload:String = "") {
        this.payload     = payload;
        this.maskLength  = maskLength
        this.finalOpCode = FinalOpCode(Final(), opCode)
    }

    fun getByteArray() : ByteArray {
        var next = 0
        val byteArray = ByteArray(getMessageSize())
        byteArray[next++] = finalOpCode.getByte().toByte()
        byteArray[next++] = maskLength.getByte().toByte()
        if (shortLength != null) {
            val shortArray = shortLength!!.getByteArray()
            byteArray[next++] = shortArray[0]
            byteArray[next++] = shortArray[1]
        }
        if (intLength != null) {
            val shortArray = intLength!!.getByteArray()
            byteArray[next++] = shortArray[0]
            byteArray[next++] = shortArray[1]
            byteArray[next++] = shortArray[2]
            byteArray[next++] = shortArray[3]
        }

        var payloadArray = payload.toByteArray()
        for (i in payload.indices) {
            byteArray[next++] = payloadArray[i]
        }
        return byteArray
    }
    fun getPayloadLth() : Int {
        return payload.length
    }
    fun setIntLength(intLength: IntLength) : SocketFrameWriter {
        this.intLength = intLength;
        return this
    }
    fun setPayloadLth() : Unit {
        if (getPayloadLth() < 126) {
            maskLength.setDecimal(payload.length.toUByte())
            return
        }
        if (getPayloadLth() < 65536) {
            maskLength.setDecimal(126u)
            setShortLength(ShortLength(getPayloadLth().toUShort()))
            return
        }
        maskLength.setDecimal(127u)
        setIntLength(IntLength(getPayloadLth()))
    }
    fun setShortLength(shortLength: ShortLength) : SocketFrameWriter {
        this.shortLength = shortLength;
        return this
    }
    private fun getMessageSize() : Int {
        var result = finalOpCode.size()
        result += maskLength.size()
        if (shortLength != null) {
            result += shortLength!!.size()
        }
        if (intLength != null) {
            result += intLength!!.size()
        }
        var payloadLth = payload.length

        result += payloadLth
        return result
    }
}