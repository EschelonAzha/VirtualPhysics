package symmetrical.cosmic._physics._subatomic.balanced

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement


open class HiggsField(
    private val entanglement: IQuantumEntanglement = QuantumEntanglement(),
) : Energy(),
    IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement()
    )
    // Spin 0
    companion object {
        lateinit var higgsField : HiggsField

        fun setForce(higgs: HiggsField) : HiggsField {
            higgsField = higgs
            return higgs
        }
    }


    private fun getLocalClassId() : String {
        return Absorber.getClassId(HiggsField::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    open fun materialize() : HiggsField {
        println("Higgs")
        return this
    }
}