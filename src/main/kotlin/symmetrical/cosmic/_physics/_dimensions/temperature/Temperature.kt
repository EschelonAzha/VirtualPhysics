package symmetrical.cosmic._physics._dimensions.temperature

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Temperature (
    private val luminescent: ILuminescent = Luminescent(Temperature::class),
) :
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Temperature::class),
    ) {
        luminescent.setKClass(Temperature::class)
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    fun i() : Temperature {
        return this
    }
}