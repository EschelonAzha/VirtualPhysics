package symmetrical.cosmic._physics._creation

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

open class Universe (
    private val entanglement: IQuantumEntanglement = QuantumEntanglement(),
) :
    IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Universe::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
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