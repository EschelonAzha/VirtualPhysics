package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

// ORIGINAL VALUE
open class AntiGreen (
    private val luminescent: ILuminescent = Luminescent(AntiGreen::class),
) : AntiColor(),
    ILuminescent by luminescent
{ // Char
    constructor() : this(
        Luminescent(AntiGreen::class),
    )

    init {
        color = ANTI_GREEN
    }


    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : AntiGreen {
        super.i()
        return this
    }
    override fun clone() : AntiGreen {
        var result      = AntiGreen()
        result.setValue(_value)
        return result
    }
}