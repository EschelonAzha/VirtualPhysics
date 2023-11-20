package symmetrical.cosmic._physics._subatomic.balanced

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


open class HiggsField(
    private val fermion: IFermion = Fermion(),
) : Energy(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
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