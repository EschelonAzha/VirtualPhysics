package asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits08


import symmetrical.cosmic._bitmaps.Bits08

class MaskLength : Bits08 {
    object Static {
        const val CONTINUATION  = 0
        const val TEXT          = 1
        const val BINARY        = 2
        const val CLOSE         = 8
        const val PING          = 9
        const val PONG          = 10
    }
    constructor(byte:UByte) : super(byte) {
    }
    fun isMasked() : Boolean {
        return high.get0() == 1
    }
    fun getByteLength() : Int {
        var lth : Int = toDecimal()
        if (lth > 127)
            lth -= 128
        return lth
    }


}