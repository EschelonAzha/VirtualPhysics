package symmetrical.cosmic._physics._creation

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class Universe (
    private val luminescent: ILuminescent = Luminescent(Universe::class),
) :
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Universe::class),
    )

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    fun i() : Universe {
       return this
    }
    open fun run() {
//        while (true) {
//            Energy.sleep(4)
//        }
    }
}