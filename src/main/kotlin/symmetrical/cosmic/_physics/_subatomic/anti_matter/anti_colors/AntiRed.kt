package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

// ORIGINAL VALUE
open class AntiRed (
    private val luminescent: ILuminescent = Luminescent(AntiRed::class),
) : AntiColor(),
    ILuminescent by luminescent
{  // Byte
    constructor() : this(
        Luminescent(AntiRed::class),
    ) {
        luminescent.setKClass(AntiRed::class)
    }

    init {
        color = ANTI_RED
    }


    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : AntiRed {
        super.i()
        return this
    }
    override fun clone() : AntiRed {
        var result      = AntiRed()
        result.setValue(_value)
        return result
    }
}