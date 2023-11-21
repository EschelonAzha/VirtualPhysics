package symmetrical.cosmic._physics._creation

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

open class Universe (
    private val fermion: IFermion = Fermion(Universe::class),
) :
    IFermion by fermion
{
    constructor() : this(
        Fermion(Universe::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
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