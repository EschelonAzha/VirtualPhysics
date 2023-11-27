package symmetrical.cosmic._physics._creation

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

open class Universe (
    private val antiMatter: IAntiMatter = AntiMatter(Universe::class),
) :
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Universe::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
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