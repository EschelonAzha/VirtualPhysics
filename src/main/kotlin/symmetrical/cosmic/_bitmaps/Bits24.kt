package symmetrical.cosmic._bitmaps

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Bits24 (
    private val antiMatter: IAntiMatter = AntiMatter(Bits24::class),
) :
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Bits24::class),
    )

    var top     : Bits08 = Bits08()
    var middle  : Bits08 = Bits08()
    var bottom  : Bits08 = Bits08()

    constructor(byte1:UByte, byte2:UByte, byte3:UByte) : this() {
        top     = Bits08(byte1)
        middle  = Bits08(byte2)
        bottom  = Bits08(byte3)
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    fun size() : Int {
        return 3
    }
    override fun toString() : String {
        return "$top : $middle : $bottom"
    }
}