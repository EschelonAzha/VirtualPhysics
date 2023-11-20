package symmetrical.cosmic._bitmaps

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Bits24 (
    private val fermion: IFermion = Fermion(),
) :
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )

    var top     : Bits08 = Bits08()
    var middle  : Bits08 = Bits08()
    var bottom  : Bits08 = Bits08()

    constructor(byte1:UByte, byte2:UByte, byte3:UByte) : this() {
        top     = Bits08(byte1)
        middle  = Bits08(byte2)
        bottom  = Bits08(byte3)
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Bits24::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun size() : Int {
        return 3
    }
    override fun toString() : String {
        return "$top : $middle : $bottom"
    }
}