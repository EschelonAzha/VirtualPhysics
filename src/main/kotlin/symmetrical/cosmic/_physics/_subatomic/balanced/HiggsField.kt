package symmetrical.cosmic._physics._subatomic.balanced

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


open class HiggsField(
    private val fermion: IFermion = Fermion(HiggsField::class),
) : Energy(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(HiggsField::class),
    )
    // Spin 0
    companion object {
        lateinit var higgsField : HiggsField

        fun setForce(higgs: HiggsField) : HiggsField {
            higgsField = higgs
            return higgs
        }
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    open fun materialize() : HiggsField {
        println("Higgs")
        return this
    }
}