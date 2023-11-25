package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class Color(
    private val fermion: ILuminescent = Luminescent(Color::class),
): ChromoCharge(),
    ILuminescent by fermion {

    constructor() : this(
        Luminescent(Color::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : Color {
        super.i()
        return this
    }
}