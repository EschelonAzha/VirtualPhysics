package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class Color(
    private val luminescent: ILuminescent = Luminescent(Color::class),
): ChromoCharge(),
    ILuminescent by luminescent {

    constructor() : this(
        Luminescent(Color::class),
    )

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : Color {
        super.i()
        return this
    }
}